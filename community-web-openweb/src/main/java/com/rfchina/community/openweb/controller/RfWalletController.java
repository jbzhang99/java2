package com.rfchina.community.openweb.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rfchina.api.response.model.pay.FuPayGetAccountListResponseModel;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.StatusCode;
import com.rfchina.community.base.util.ValidatorUtil;
import com.rfchina.community.component.PlatformGlobalComponent;
import com.rfchina.community.entity.communityService.ExtCommunityServiceTemp;
import com.rfchina.community.openweb.entity.AdminUserInfo;
import com.rfchina.community.openweb.service.AccountService;
import com.rfchina.community.openweb.service.MerchantInfoService;
import com.rfchina.community.openweb.service.OpenStoreServiceTempleteService;
import com.rfchina.community.openweb.shiro.AdminInfoUtils;
import com.rfchina.community.persistence.mapper.OpenMerchantInfoMapper;
import com.rfchina.community.persistence.model.OpenMerchantInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 */
@RestController
@RequestMapping(value = { Constant.ROOT_PATH_OPENWEB })
public class RfWalletController extends BaseController {

	//// 1 广告发送,2过期,
	int regType = 1;

	int forgetType = 2;

	// 有效时长
//	long EMAIL_EFFECTIVE_LENGTH = 1000L * 3600 * 24;
	@Value("${email.effective.length}")
	private long emailEffectiveLength ;

	@Autowired
	private OpenMerchantInfoMapper openMerchantInfoMapper;
	@Autowired
	private AccountService accountService;
	@Autowired
	private MerchantInfoService merchantInfoService;
	@Autowired
	private PlatformGlobalComponent platformGlobalComponent;
	@Autowired
	private OpenStoreServiceTempleteService openStoreServiceTempleteService;


	/******************************************** new 富汇通 *************************************************/

	@RequestMapping(value = { "/acc/login" }, method = { RequestMethod.GET })
	public Result<?> login() {
		logger.info("------------------login----------");
		Subject subject = SecurityUtils.getSubject();
		boolean auth = subject.isAuthenticated();
		if (auth) {
			return Result.success();
		} else {
			response.addHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Headers", "*");
			response.addHeader("Access-Control-Allow-Methods", "*");
			response.addHeader("Access-Control-Allow-Credentials", "true");

			return Result.create(StatusCode.UNAUTHORIZED.value(), StatusCode.UNAUTHORIZED.name());
		}
	}

	/**
	 * 登录
	 */
	@RequestMapping(value = { "/acc/login" }, method = { RequestMethod.POST })
	public Result<?> login(
			@RequestParam("userName") String userName,
			@RequestParam("passwd") String passwd,
			@RequestParam(value = "clientType",required = false) String clientType
	){
		logger.info("userName={},passwd={}",userName, passwd);
		ValidatorUtil.verify(userName, "账号");
		userName = userName.toLowerCase().trim();
		ValidatorUtil.verify(passwd, "密码");

		//拿到用户信息跟token
		AdminUserInfo userInfo = accountService.rfWalletLogin(userName,passwd, getIp2());
		validator(userInfo == null, "调用平台登录失败");
		logger.info("调用平台登录:{}",userInfo.toString());
		JSONObject json = new JSONObject();
		if(!Constant.merchantInfo.RegProgress.HOME.equals(userInfo.getRegProgress())) {
			Map<String, String> map = platformGlobalComponent.ssOApplyAuth(userInfo.getUserToken(), userInfo.getRegProgress(), null);
			validator(map == null, "调用平台授权失败");
			json.put("redirectUrl", map.get("redirect_url").toString());
		}

		Long merchantId = userInfo.getUid();

		if(StringUtils.isBlank(clientType)) {
			this.completeMerchantJson(json, merchantId);//pc端
		}else{
			this.completeXfsjInfo(json, merchantId);//手机端
		}

		return Result.successData(json);
	}

	private void completeMerchantJson(JSONObject json, Long merchantId){

		OpenMerchantInfo minfo = openMerchantInfoMapper.selectByPrimaryKey(merchantId);
		//如果还是没有商家资料，直接跳转到redirectUrl
		if(minfo == null){
			logger.error("创建商家失败org");
			Result.successData(json);
		}

		//有商家信息情况下,查看是否是小富市集的
		if(minfo.getXfsjStatus() == 0){
			json.put("jeep", "index");
		}else{
			//小富市集-判断服务是否生成，未生成调到服务注册页面
			long serviceNum = communityServiceService.getCommunityServiceTempCount(merchantId);
			validator(serviceNum <= 0, "请使用手机登录，完善商家和店铺信息后再试");

			List<ExtCommunityServiceTemp> communityServiceList = communityServiceService.getCommunityServiceTempList(merchantId.intValue());
			json.put("serviceId", communityServiceList.get(0).getId());
			json.put("jeep", "xfsj");
		}
	}

	/**
	 * 验证临时令牌
	 */
	@RequestMapping(value = { "/acc/verifyTempToken" }, method = { RequestMethod.POST })
	public Result<?> verifyTempToken(
			@RequestParam("tempToken") String tempToken,
			@RequestParam(value = "clientType",required = false) String clientType
	){
		//验证并保存用户令牌
		accountService.loginWhenRegister(tempToken,getIp2());

		//同步商家信息
		AdminUserInfo userInfo = AdminInfoUtils.getAdminUserInfo();

		JSONObject json = new JSONObject();
		Long merchantId = userInfo.getUid();
		if(StringUtils.isBlank(clientType)) {
			this.completeMerchantJson(json, merchantId);//pc端
		}else{
			this.completeXfsjInfo(json, merchantId);//手机端
		}

		return Result.successData(merchantId);
	}

	/**
	 * 跳转富汇通链接
	 */
	@RequestMapping(value = { "/applyRfwalletAuth" })
	public void applyAuth (
			@RequestParam("authType") String authType,
			@RequestParam(value="stat",required = false) String stat
	) throws Exception {
		AdminUserInfo adminInfo = AdminInfoUtils.getAdminUserInfo();
		validator(adminInfo == null, "用户失效,请重新登录");
		Map<String, String> map = platformGlobalComponent.ssOApplyAuth(adminInfo.getUserToken(),
				authType, stat);
		validator(map == null, "调用平台授权失败");
		response.setHeader("content-type", "text/html;charset=utf-8");
		response.sendRedirect(map.get("redirect_url").toString());
	}


	/**
	 * 刷新用户user_token,给客户端调用
	 */
	@RequestMapping(value = { "/rfwalletRefresh" }, method = { RequestMethod.POST })
	public void refresh(){
		AdminUserInfo adminInfo = AdminInfoUtils.getAdminUserInfo();
		validator(adminInfo == null, "用户失效,请重新登录");
		platformGlobalComponent.refreshUserToken(adminInfo.getUserToken());
	}

	/**
	 * 登出
	 * @return
	 */
	@RequestMapping(value = { "/acc/logout" })
	public Result<?> logout() {
		AdminUserInfo adminInfo = AdminInfoUtils.getAdminUserInfo();
		if(adminInfo != null){
			//调用平台退出
			platformGlobalComponent.logout(adminInfo.getUserToken());
		}
		Subject subject = SecurityUtils.getSubject();
		subject.logout();

		return Result.successData(null);
	}

	@RequestMapping(value = { "/acc/unauthorized" }, method = { RequestMethod.POST, RequestMethod.GET })
	public Result<?> unauthorized() {
		return Result.create(StatusCode.UNAUTHORIZED.value(), StatusCode.UNAUTHORIZED.name());
	}

	@RequestMapping(value = { "/login_check" }, method = { RequestMethod.POST })
	public Result<?> loginCheck() {
		AdminUserInfo admin = getAdminInfo();
		JSONObject json = new JSONObject();
		json.put("userName", admin.getUserName());
		OpenMerchantInfo info = openMerchantInfoMapper.selectByPrimaryKey(admin.getUid());
		if (info == null) {
			json.put("title", "");
		} else {
			json.put("title", info.getTitle());
		}
		return Result.successData(json);
	}

	/**
	 * 获取账号列表
	 * @return
	 */
	@RequestMapping(value = { "/getAccountList" })
	public Result<?> getAccountList() {
		AdminUserInfo adminInfo = AdminInfoUtils.getAdminUserInfo();
		FuPayGetAccountListResponseModel list = platformGlobalComponent.getAccountListRequest(null,
				adminInfo.getMchId(), "", true, 50, 0);
		logger.info(JSON.toJSONString(list));
		return Result.successData(list);
	}

	/**
	 * 获取账号列表
	 * @return
	 */
	@RequestMapping(value = { "/sysMerchantInfo" })
	public Result<?> sysMerchantInfo() {
		AdminUserInfo adminInfo = AdminInfoUtils.getAdminUserInfo();
		merchantInfoService.sysMerchantInfo(adminInfo.getUserToken(), adminInfo.getMchId(), adminInfo.getUid(), adminInfo.getRemark());
		return Result.successData(null);
	}

	/**
	 *test
	 * @return
	 */
	@RequestMapping(value = { "/test_account_status" })
	public Result<?> test_account_status() {
		AdminUserInfo adminInfo = AdminInfoUtils.getAdminUserInfo();
		//platformGlobalComponent.bindStatus("65822901","MC41367582");
		return Result.successData(null);
	}


	/**
	 * @author:fukangwen @Description: 小富市集登录 @return Result<?> @throws
	 */
	@RequestMapping(value = { "/acc/xfsj/login" }, method = { RequestMethod.POST })
	public Result<?> xfsjlogin(
			@RequestParam("user_name") String userName,
			@RequestParam("passwd") String passwd) {
		logger.info("userName={},passwd={}",userName, passwd);
		ValidatorUtil.verify(userName, "账号");
		userName = userName.toLowerCase().trim();
		ValidatorUtil.verify(passwd, "密码");

		//拿到用户信息跟token
		AdminUserInfo userInfo = accountService.rfWalletLogin(userName,passwd, getIp2());
		validator(userInfo == null, "调用平台登录失败");
		logger.info("调用平台登录:{}",userInfo.toString());
		JSONObject json = new JSONObject();
		if(!Constant.merchantInfo.RegProgress.HOME.equals(userInfo.getRegProgress())) {
			Map<String, String> map = platformGlobalComponent.ssOApplyAuth(userInfo.getUserToken(), userInfo.getRegProgress(), null);
			validator(map == null, "调用平台授权失败");
			json.put("redirectUrl", map.get("redirect_url").toString());
			return Result.successData(json);
		}

		Long merchantId = userInfo.getUid();

		OpenMerchantInfo minfo = openMerchantInfoMapper.selectByPrimaryKey(merchantId);
		//如果还是没有商家资料，直接跳转到redirectUrl
		if(minfo == null){
			logger.error("创建商家失败org");
			Result.successData(json);
		}

		//有商家信息情况下,查看是否是小富市集的
		if(minfo.getXfsjStatus() == 0){
			//商家非审核通过时
			if (minfo.getStatus() != Constant.Passport.Status.ENABLE) {
				json.put("jeep", "perfectinfo");//提示在电脑端完成注册流程
				return Result.successData(json);
			}
			//返回商家的模板商城服务列表
			json.put("templeteList", openStoreServiceTempleteService.getTempleteList(minfo.getId(),
					OpenConstant.open_service_detail.templete_status.start_up, OpenConstant.open_service_detail.templete_name.STORE.toString()));
			json.put("jeep", "index");
		}else{
			//小富市集-判断服务是否生成，未生成调到服务注册页
			long serviceNum = communityServiceService.getCommunityServiceTempCount(merchantId);
			if (serviceNum <= 0) {
				json.put("jeep", "registerService");
				return Result.successData(json);
			}

			// 成功登录
			List<ExtCommunityServiceTemp> communityServiceList = communityServiceService.getCommunityServiceTempList(merchantId.intValue());
			json.put("serviceId", communityServiceList.get(0).getId());
			json.put("jeep", "xfsj");
		}

		return Result.successData(json);




	}

	private void completeXfsjInfo(JSONObject json, Long merchantId){
		OpenMerchantInfo minfo = openMerchantInfoMapper.selectByPrimaryKey(merchantId);
		//如果还是没有商家资料，直接跳转到redirectUrl
		if(minfo == null){
			logger.error("创建商家失败org");
			Result.successData(json);
		}

		//有商家信息情况下,查看是否是小富市集的
		if(minfo.getXfsjStatus() == 0){
			//商家非审核通过时
			if (minfo.getStatus() != Constant.Passport.Status.ENABLE) {
				json.put("jeep", "perfectinfo");//提示在电脑端完成注册流程
				return;
			}
			//返回商家的模板商城服务列表
			json.put("templeteList", openStoreServiceTempleteService.getTempleteList(minfo.getId(),
					OpenConstant.open_service_detail.templete_status.start_up, OpenConstant.open_service_detail.templete_name.STORE.toString()));
			json.put("jeep", "index");
		}else{
			//小富市集-判断服务是否生成，未生成调到服务注册页
			long serviceNum = communityServiceService.getCommunityServiceTempCount(merchantId);
			if (serviceNum <= 0) {
				json.put("jeep", "registerService");
				return;
			}

			// 成功登录
			List<ExtCommunityServiceTemp> communityServiceList = communityServiceService.getCommunityServiceTempList(merchantId.intValue());
			json.put("serviceId", communityServiceList.get(0).getId());
			json.put("jeep", "xfsj");
		}
	}
}
