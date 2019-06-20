package com.rfchina.community.openweb.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rfchina.api.response.ResponseData;
import com.rfchina.api.response.model.app.CreateAppResponseModel;
import com.rfchina.api.response.model.app.GetApiListResponseModel;
import com.rfchina.api.response.model.pay.FuPayCreateResponseModel;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.EmojiUtil;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.OpenConstant.open_service_detail.templete_name;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.HttpUtil;
import com.rfchina.community.base.util.RegexUtil;
import com.rfchina.community.base.util.RegexUtils;
import com.rfchina.community.component.HttpClientComponent;
import com.rfchina.community.component.HttpClientComponent.Callback;
import com.rfchina.community.component.OpenAuditInfoComponent;
import com.rfchina.community.component.SysMsgInfoComponent;
import com.rfchina.community.component.SysMsgInfoComponent.ObjectType;
import com.rfchina.community.entity.communityService.ExtCommunityServiceTemp;
import com.rfchina.community.openweb.entity.AdminUserInfo;
import com.rfchina.community.openweb.entity.ExtCommunity;
import com.rfchina.community.openweb.entity.ExtCommunityContacts;
import com.rfchina.community.openweb.entity.ExtInterfaceList;
import com.rfchina.community.openweb.service.*;
import com.rfchina.community.persistence.mapper.*;
import com.rfchina.community.persistence.model.*;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.ext.ExtCommunityServiceRela;
import com.rfchina.community.service.openser.OpenServiceDetailTabService;
import com.rfchina.community.service.openser.OpenServicePayService;
import okhttp3.Response;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = Constant.ROOT_PATH_OPENWEB)
public class CommunityServiceController extends BaseController {

	@Autowired
	private CommunityServiceService communityServiceService;
	@Autowired
	private UserInfoMapper userInfoMapper;

	@Autowired
	private CommunityServiceRelaService communityServiceRelaService;
	@Autowired
	private OpenStoreServiceTempleteService openStoreServiceTempleteService;
	@Autowired
	private PlatformService platformService;
	@Autowired
	private HttpClientComponent httpClientComponent;
	@Autowired
	private OpenServiceDetailTabService openServiceDetailTabService;
	@Autowired
	private OpenServicePayService openServicePayService;

	@Value("${debug.communityId}")
	private int debugCommunityId;

	@Value("${debug.masterInfoId}")
	private long debugMasterInfoId;

	@Value("${rfpay.appId}")
	private long rfpayAppId;

	@Value("${rfpay.appSecret}")
	private String rfpayAppSecret;

	@Value("${rfpay.accountId}")
	private String rfpayAccountId;

	@Value("${balance.receive.email}")
	private String balanceReceiveEmail;
	@Value("${open.storeapi.url}")
	private String openStoreapiUrl;
	@Value("${openweb.site.link}")
	private String openwebUrl;

	@Autowired
	private MasterChildService masterChildService;

	@Autowired
	private OpenDebugUserService openDebugUserService;

	@Autowired
	private OpenStoreServiceTempleteMapper openStoreServiceTempleteMapper;

	@Autowired
	private CommunityServiceCountService communityServiceCountService;

	@Autowired
	private CommunityServiceCommentService communityServiceCommentService;

	@Autowired
	private CommunityServiceCategoryService communityServiceCategoryService;

	@Autowired
	private FuPayService fuPayService;

	@Autowired
	private OpenWebOrderService openOrderService;

	@Autowired
	private com.rfchina.community.openweb.service.CommunityService communityService;

	@Autowired
	private OpenAuditInfoComponent openAuditInfoComponent;

	@Autowired
	private CommunityServiceRelaMapper communityServiceRelaMapper;
	@Autowired
	private SysMsgInfoComponent sysMsgInfoComponent;

	@Autowired
	private AreaService areaService;

	@Autowired
	private OpenServiceInterfaceService openServiceInterfaceService;

	@Autowired
	private OpenInterfaceService openInterfaceService;

	@Autowired
	private OpenServiceAreaService openServiceAreaService;

	@Autowired
	private OpenMerchantInfoMapper openMerchantInfoMapper;

	@Autowired
	private VisitCommunityUserMapper visitCommunityUserMapper;
	@Autowired
	private OpenServiceDetailMapper openServiceDetailMapper;
	@Autowired
	private OpenServiceExtendService openServiceExtendService;
	@Autowired
	private CommunityServiceMapper communityServiceMapper;
	@Autowired
	private CommunityPayMapper communityPayMapper;


	@RequestMapping("/merchant_service_list")
	public Result<?> merchantServiceList() {
		return Result.successData(communityServiceService.getCommunityServiceTempList(getAdminId().intValue()));
	}

	// 增加服务
	@RequestMapping("/create_service")
	@Transactional(rollbackFor = Exception.class)
	public Result<?> createService(@RequestParam("title") String title, @RequestParam("description") String description,
			@RequestParam("category_id") int categoryId, @RequestParam("community_ids") String communityIds,
			@RequestParam("is_need_hardware") int isNeedHardware,
			@RequestParam("target_month_turnover") String targetMonthTurnover,
			@RequestParam("develop_type") String developType,
			@RequestParam(value = "service_need", required = false) String serviceNeed,
			@RequestParam(value = "account", required = false) String account,
			@RequestParam("user_range") int userRange) throws IllegalAccessException, InvocationTargetException {
		Long adminid = getAdminId();
		OpenMerchantInfo merchant = openMerchantInfoMapper.selectByPrimaryKey(adminid);

		//去掉限制
//		if (merchant.getStatus() != 1) {
//			error("资质审核通过后，方可创建服务，请耐心等待。");
//		}
		validator(merchant == null, "服务商不存在!不能创建服务,请重新登录");
		validator(!EnumUtils.isValidEnum(OpenConstant.open_service_detail.develop_type.class, developType),
				"开发模式只能是TEMPLETE,SELF");
		validator(StringUtils.isBlank(title), "服务名称不能为空");
		title = EmojiUtil.replaceAll(title);

		validator(StringUtils.isBlank(description), "服务描述不能为空");
		validator(categoryId <= 0, "服务分类不能为空");
		validator(StringUtils.isBlank(communityIds), "服务范围不能为空");
		if (StringUtils.isNotBlank(serviceNeed) && serviceNeed.length() > 140) {
			serviceNeed = serviceNeed.substring(0, 140);
		}
		validator(StringUtils.isBlank(Constant.OpenAdmin.IsNeedHardware.translate(isNeedHardware)),
				"是否需要硬件入住社区选项不对，只能选是、否");
		validator(StringUtils.isBlank(targetMonthTurnover), "目标月营业额不能为空");
		validator(Double.parseDouble(targetMonthTurnover) <= 0, "目标月营业额必须大于0");
		validator(Double.parseDouble(targetMonthTurnover) > 100000000000D, "目标月营业额必须小于100000000000");

		validator(StringUtils.isBlank(Constant.OpenAdmin.UserRange.translate(userRange)),
				"社区用户覆盖范围选项不对，只能选择社区认证用户及社区关注用户，或者社区认证用户");
		// 判断一个服务商只能创建5个服务
		validator(
				communityServiceService
						.getCommunityServiceTempCount(getAdminId()) >= Constant.OpenAdmin.MAX_SERVICE_COUNT,
				"服务商最多只能创建" + Constant.OpenAdmin.MAX_SERVICE_COUNT + "个服务");

		//收款账户
		validator(StringUtils.isBlank(account), "收款账户不能为空");
		//验证收款账户状态
		Boolean accountHadUse = communityServiceService.getAccountHadUse(account);
		validator(accountHadUse, "创建失败，请选择没有使用过的收款账户");
		// 根据条件进行排重
		List<CommunityServiceTemp> list = communityServiceService.getCommunityServiceTemp(title);
		validator(list != null && list.size() > 0, "服务名称：" + title + "，已存在");
		Date now = new Date();

		CommunityServiceTemp communityServiceTemp = new CommunityServiceTemp();
		communityServiceTemp.setTitle(title);
		communityServiceTemp.setDescription(description);
		communityServiceTemp.setCategoryId(categoryId);
		communityServiceTemp.setIsNeedHardware(isNeedHardware);
		communityServiceTemp.setTargetMonthTurnover(new BigDecimal(targetMonthTurnover));
		communityServiceTemp.setCreateTime(now);
		communityServiceTemp.setMerchantId(adminid);
		communityServiceTemp.setReorder(1);
		communityServiceTemp.setProvideType(2);
		communityServiceTemp.setAccountId(account);

		//服务类型
		int type = OpenConstant.CommunityServiceType.third_inner_life;
		int tab = OpenConstant.OpenServiceDetailTab.templete.getCode();
		if(OpenConstant.open_service_detail.develop_type.SELF.toString().equals(developType)) {
			type = OpenConstant.CommunityServiceType.third_out_life;
			tab =  OpenConstant.OpenServiceDetailTab.third.getCode();
		}
		communityServiceTemp.setType(type);
//		communityServiceTemp.setCommissionRate(BigDecimal.valueOf(0L));

		communityServiceTemp.setServiceNeed(serviceNeed);
		communityServiceTemp.setGroundMode(Constant.OpenAdmin.GroundMode.AUTO);
		communityServiceTemp.setStatus(Constant.OpenAdmin.CommunityServiceGroundStatus.UNGROUNDING);
		communityServiceTemp.setUserRange(userRange);
		communityServiceTemp.setAuditStatus(Constant.OpenAdmin.CommunityServiceAuditStatus.AUDIT);
		communityServiceTemp.setGroundAuditStatus(Constant.OpenAdmin.CommunityServiceGroundAuditStatus.NOTAUDIT);
		communityServiceTemp.setCautionMoneyStatus(OpenConstant.CautionMoneyStatus.UNPAID);
		communityServiceService.addCommunityServiceTemp(communityServiceTemp);
		CommunityService communityService = new CommunityService();
		BeanUtils.copyProperties(communityService, communityServiceTemp);
		communityServiceService.addCommunityService(communityService);
		Integer id = communityService.getId();
		OpenServiceDetail detail = new OpenServiceDetail();
		detail.setServiceId(id);
		detail.setTempleteStatus(0);
		detail.setDevelopType(developType);
		detail.setTempleteName("");
		detail.setAppCatSort(999);
		detail.setAppIndexSort(999);
		detail.setXfsjStatus(0);
		// 1 我们自己开发,2第三方开发,
		detail.setRfchinaCode(2);
		communityServiceService.insertORUpdateOpenServiceDetail(detail);


		//保存 服务的费用比例
		OpenServicePay pay=new OpenServicePay();
		pay.setServiceId(id);
		pay.setCommunityRate(new BigDecimal(0));
		pay.setThinkRate(new BigDecimal(0));
		pay.setPlatformFee(new BigDecimal(0));
		openServicePayService.insertOrUpdate(pay);

		
		//设置服务标签
		openServiceDetailTabService.insert(tab, communityService.getId());
		
		// 保存服务范围信息
		communityServiceRelaService.saveByIds(communityIds, communityServiceTemp.getId(), merchant.getContactPerson(),
				merchant.getContactPhone(), merchant.getEmail(), Constant.OpenAdmin.CommunityServiceRelaAuditStatus.NOTAUDIT, 
				Constant.OpenAdmin.CommunityServiceRelaStatus.DISABLE);
		
		// 插入审核表中
		openAuditInfoComponent.add(OpenAuditInfoComponent.ObjectType.service_approval, adminid,
				communityServiceTemp.getId().toString(), id,merchant.getId());
		// 消息
		addSysMsg(merchant,ObjectType.open_service_approval, communityServiceTemp);
		return Result.successData(communityServiceTemp.getId());
	}

	private void addSysMsg(OpenMerchantInfo merchant,ObjectType objectType, CommunityServiceTemp communityServiceTemp) {
		List<String> parameter = new ArrayList<>();
		parameter.add(merchant.getTitle());
		parameter.add(communityServiceTemp.getTitle());
		sysMsgInfoComponent.addPlatform(objectType,
				communityServiceTemp.getId().toString(), parameter);
	}


	// 修改基础服务
	@RequestMapping("/modify_service_base")
	public Result<?> modifyServiceBase(@RequestParam("service_id") int serviceId, @RequestParam("title") String title,
			@RequestParam("description") String description, @RequestParam("category_id") int categoryId,
			@RequestParam("community_ids") String communityIds, @RequestParam("is_need_hardware") int isNeedHardware,
			@RequestParam("target_month_turnover") String targetMonthTurnover,
			@RequestParam(value = "service_need", required = false) String serviceNeed,
			@RequestParam(value = "develop_type", required = false) String developType,
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam("user_range") int userRange) {

		AdminUserInfo admin = getAdminInfo();
		OpenMerchantInfo merchant = openMerchantInfoMapper.selectByPrimaryKey(admin.getUid());
		validator(merchant == null, "服务商不存在!不存在创建服务");
		CommunityServiceTemp communityServiceTemp = communityServiceService
				.getCommunityServiceTempByPrimaryKey(serviceId);
		validator(communityServiceTemp == null, "此服务信息不存在");

		validator(communityServiceTemp.getMerchantId().longValue() != admin.getUid(), "非法访问!");
		if (StringUtils.isBlank(title)) {
			error("服务名称不能为空");
		}
		title = EmojiUtil.replaceAll(title);
		if (StringUtils.isBlank(title)) {
			error("服务名称不能有表情");
		}
		if (StringUtils.isBlank(description)) {
			error("服务描述不能为空");
		}
		if (categoryId <= 0) {
			error("服务分类不能为空");
		}
		if (StringUtils.isBlank(communityIds)) {
			error("服务范围不能为空");
		}

		// developType不等于空
		validator(
				StringUtils.isNoneBlank(developType)
						&& !EnumUtils.isValidEnum(OpenConstant.open_service_detail.develop_type.class, developType),
				"开发模式只能是TEMPLETE,SELF");

		if (StringUtils.isNotBlank(serviceNeed) && serviceNeed.length() > 140) {
			serviceNeed = serviceNeed.substring(0, 140);
		}
		if (StringUtils.isBlank(Constant.OpenAdmin.IsNeedHardware.translate(isNeedHardware))) {
			error("是否需要硬件入住社区选项不对，只能选是、否");
		}
		if (StringUtils.isBlank(targetMonthTurnover)) {
			error("目标月营业额不能为空");
		}
		if (Double.parseDouble(targetMonthTurnover) <= 0) {
			error("目标月营业额必须大于0");
		}
		if (StringUtils.isBlank(Constant.OpenAdmin.UserRange.translate(userRange))) {
			error("社区用户覆盖范围选项不对，只能选择社区认证用户及社区关注用户，或者社区认证用户");
		}
		if (communityServiceTemp.getAuditStatus() == Constant.OpenAdmin.CommunityServiceAuditStatus.AUDIT
				|| Constant.OpenAdmin.CommunityServiceGroundAuditStatus.AUDIT == communityServiceTemp
						.getGroundAuditStatus()) {
			error("服务正在审核中，不能修改");
		}
		if (!communityServiceTemp.getTitle().equals(title)) {
			List<CommunityServiceTemp> list = communityServiceService.getCommunityServiceTemp(title);
			if (list != null && list.size() > 0) {
				error("服务名称：" + title + "，已存在");
			}
		}
		communityServiceTemp.setTitle(title);
		communityServiceTemp.setDescription(description);
		communityServiceTemp.setCategoryId(categoryId);
		communityServiceTemp.setIsNeedHardware(isNeedHardware);
		communityServiceTemp.setTargetMonthTurnover(new BigDecimal(targetMonthTurnover));
		communityServiceTemp.setUserRange(userRange);
		communityServiceTemp.setServiceNeed(serviceNeed);
		// communityServiceTemp.setStatus(Constant.OpenAdmin.CommunityServiceGroundStatus.UNGROUNDING);
		communityServiceTemp.setUpdateTime(new Date());
		communityServiceTemp.setAuditStatus(Constant.OpenAdmin.CommunityServiceAuditStatus.AUDIT);
		communityServiceService.updateCommunityServiceTemp(communityServiceTemp);

		// 未交保证金前可以修改,只要修改就不能修改了!
		// TODO 解决自主的能转模板,但是模板不能转自主???
		// 运营和商务的同事，刚才村村提到了这次“增加保证金”功能与开放平台一直就有的一个坑有冲突。建议在本期对创建服务流程做以下调整：
		// 商家爱点击创建服务后，选了啥接入模式（自行开发接入/使用服务模板）就是啥接入模式，不允许再修改了。
		 if (communityServiceTemp.getCautionMoneyStatus() == OpenConstant.CautionMoneyStatus.UNPAID
				 && StringUtils.isNotBlank(developType)) {
			 // 需要判断是否能修改
			 //communityServiceTemp.setCautionMoneyStatus(Constant.OpenAdmin.CautionMoneyStatus.PAID);
			 OpenServiceDetail detail = communityServiceService.getOpenServiceDetail(serviceId);
			 if (detail != null) {
				 detail.setDevelopType(developType);
				 openServiceDetailMapper.updateByPrimaryKeySelective(detail);
			 }
		 }

		// 修改服务范围信息
		String[] ids = communityIds.split(",");
		List<CommunityServiceRelaTemp> oldCommunityServiceRelaTemp = communityServiceRelaService
				.getCommunityServiceRelaTempList(serviceId);
		// 删除原来的服务社区关系
		communityServiceRelaService.deleteCommunityServiceRelaTemp(serviceId);
		for (int i = 0; i < ids.length; i++) {

			if (ids[i].startsWith("a") || ids[i].startsWith("A")) {
				// 保存到服务区域表中

				OpenServiceArea openServiceArea = openServiceAreaService.getOpenServiceArea(serviceId,
						Integer.parseInt(ids[i].substring(1)));

				if (openServiceArea == null) {

					openServiceArea = new OpenServiceArea();
					openServiceArea.setAreaId(Integer.parseInt(ids[i].substring(1)));
					openServiceArea.setServiceId(serviceId);

					openServiceAreaService.addOpenServiceArea(openServiceArea);
				}
			} else {

				int cid = Integer.parseInt(ids[i]);
				CommunityServiceRelaTemp communityServiceRelaTemp = new CommunityServiceRelaTemp();
				communityServiceRelaTemp.setServiceId(serviceId);
				communityServiceRelaTemp.setCommunityId(cid);
				communityServiceRelaTemp.setCreateTime(new Date());
				communityServiceRelaTemp.setAuditStatus(Constant.OpenAdmin.CommunityServiceRelaAuditStatus.NOTAUDIT);
				communityServiceRelaTemp.setStatus(Constant.OpenAdmin.CommunityServiceRelaStatus.DISABLE);
				communityServiceRelaTemp.setServiceContactsName(merchant.getContactPerson());
				communityServiceRelaTemp.setServiceContactsPhone(merchant.getContactPhone());
				communityServiceRelaTemp.setServiceContactsEmail(merchant.getEmail());
				if (oldCommunityServiceRelaTemp != null && oldCommunityServiceRelaTemp.size() > 0) {
					for (int j = 0; j < oldCommunityServiceRelaTemp.size(); j++) {
						if (oldCommunityServiceRelaTemp.get(j).getCommunityId() == cid) {
							// 保存原来的社区服务状态
							communityServiceRelaTemp
									.setAuditStatus(oldCommunityServiceRelaTemp.get(j).getAuditStatus());
							communityServiceRelaTemp.setStatus(oldCommunityServiceRelaTemp.get(j).getStatus());
							communityServiceRelaTemp.setCreateTime(oldCommunityServiceRelaTemp.get(j).getCreateTime());
							communityServiceRelaTemp.setUpdateTime(new Date());
							break;
						}
					}
				}
				// 判断是否存在,
				CommunityServiceRelaTemp csr = communityServiceRelaService.getCommunityServiceRelaTemp(serviceId, cid);
				// logger.info("getCommunityServiceRelaTemp466:ran:{},communityIds:{}, sid:{},
				// cid:{},csr:{}",ran,communityIds, serviceId, cid,csr);
				if (csr == null) {
					communityServiceRelaService.addCommunityServiceRelaTemp(communityServiceRelaTemp);
				} else {
					// 因为上面已经删除,估计是提交过来的数据重复,
					// communityServiceRelaService.updateCommunityServiceRelaTemp(communityServiceRelaTemp);
				}
			}
		}
		//插入新增关键词
		if(StringUtils.isNotBlank(keyword)) {
			openServiceExtendService.setKeywordToAudit(serviceId, keyword);
		}
		// 插入审核表中
		openAuditInfoComponent.add(OpenAuditInfoComponent.ObjectType.service_approval, admin.getUid(),
				communityServiceTemp.getId().toString(), communityServiceTemp.getId());
		// 消息
		addSysMsg(merchant,ObjectType.open_service_approval, communityServiceTemp);
		//
		return Result.success();
	}

	// 服务链接：服务链接前请加 http:// 或 https://
	@RequestMapping("/modify_service_url")
	public Result<?> modifyServiceUrl(@RequestParam("service_id") int serviceId, @RequestParam("link") String link){
		CommunityServiceTemp communityServiceTemp1 = communityServiceService
				.getCommunityServiceTempByPrimaryKey(serviceId);
		validator(communityServiceTemp1 == null, "此服务信息不存在");
		validator(communityServiceTemp1.getMerchantId().longValue() != getAdminId(), "非法访问!");
		if (StringUtils.isBlank(link)) {
			error("链接地址不能为空");
		}
		if (!RegexUtil.matches(link, RegexUtil.URL.pattern())) {
			error("链接地址格式不正确");
		}
		if (communityServiceTemp1.getAuditStatus() == Constant.OpenAdmin.CommunityServiceAuditStatus.AUDIT
				|| Constant.OpenAdmin.CommunityServiceGroundAuditStatus.AUDIT == communityServiceTemp1
						.getGroundAuditStatus()) {
			error("服务正在审核中，不能修改");
		}
		try {
			httpClientComponent.postTestConnection(link, "");
		}catch (Exception e) {
			error("访问地址不通 " + link );
		}
//		httpClientComponent.postTestConnection(link, "", new Callback() {
//			@Override
//			public void call(String url, Response response) throws IOException {
//				if (response.isSuccessful()) {
//
//				} else {
//					error("访问地址不通 " + url + " 返回码:" + response.code());
//				}
//			}
//		});
		// URL url = new URL(link);
		CommunityServiceTemp communityServiceTemp = new CommunityServiceTemp();
		communityServiceTemp.setId(serviceId);
		communityServiceTemp.setLink(link);
		communityServiceTemp.setUpdateTime(new Date());
		communityServiceTemp.setAppId(communityServiceTemp1.getAppId());
		communityServiceTemp.setAppSecret(communityServiceTemp1.getAppSecret());
		if (0 == communityServiceTemp.getAppId()) {
			// 调用平台接口注册应用，获取APPID跟APPSecret
			CreateAppResponseModel createAppResponseModel = communityServiceService.createAppResponseModel(
					communityServiceTemp1.getTitle(), communityServiceTemp1.getDescription(), link);
			// platformService.createApp(
			// "自在-开放-" + communityServiceTemp1.getTitle(), 3, "1002", "0101",
			// communityServiceTemp1.getDescription(), 120 * 60, 4, 1, null, null, link,
			// url.getHost(), 1, 1);
			if (createAppResponseModel != null) {
				communityServiceTemp.setAppId(createAppResponseModel.getAppId());
				communityServiceTemp.setAppSecret(createAppResponseModel.getAppSecret());
				// 审核应用
			} else {
				error("创建平台应用失败");
			}
		}
		validator(communityServiceTemp.getAppId() == null || communityServiceTemp.getAppId() <= 0,
				"APPID 错误 " + communityServiceTemp.getAppId());
		// open_interface 3 应用中心 应用中心服务 2017-03-09 16:33:41 1
		platformService.applyService(communityServiceTemp.getAppId(), OPEN_INTERFACE_APPLICATION_CENTER, 1);
		platformService.auditService(communityServiceTemp.getAppId(), OPEN_INTERFACE_APPLICATION_CENTER,
				auditService_pass, "系统通过");
		OpenServiceInterface openServiceInterface = openServiceInterfaceService
				.getServiceInterface(communityServiceTemp.getId(), OPEN_INTERFACE_APPLICATION_CENTER);
		if (openServiceInterface == null) {
			openServiceInterface = new OpenServiceInterface();
			openServiceInterface.setAuditStatus(Constant.OpenAdmin.ServiceInterfaceAuditStatus.AUDIT_PASS);
			openServiceInterface.setCreateTime(new Date());
			openServiceInterface.setInterfaceId(OPEN_INTERFACE_APPLICATION_CENTER);
			openServiceInterface.setServiceId(communityServiceTemp.getId());
			openServiceInterface.setAuditComment("默认通过");
			openServiceInterface.setStatus(Constant.OpenAdmin.ServiceInterfaceStatus.ENABLE);
			openServiceInterfaceService.addServiceInterface(openServiceInterface);
		}
		communityServiceService.updateCommunityServiceTemp(communityServiceTemp);
		CommunityService communityService1 = new CommunityService();
		communityService1.setId(serviceId);
		communityService1.setLink(link);
		communityService1.setUpdateTime(new Date());
		communityService1.setAppId(communityServiceTemp.getAppId());
		communityService1.setAppSecret(communityServiceTemp.getAppSecret());
		communityServiceService.updateCommunityService(communityService1);
		// 提交审核
		return Result.success();
	}

	int OPEN_INTERFACE_APPLICATION_CENTER = 3;
	int OPEN_INTERFACE_PAY = 7;
	int auditService_pass = 3;

	@RequestMapping("/delete_service")
	public Result<?> deleteService(@RequestParam("service_id") int serviceId) {
		CommunityServiceTemp communityServiceTemp = communityServiceService
				.getCommunityServiceTempByPrimaryKey(serviceId);
		validator(communityServiceTemp == null, "此服务信息不存在");
		Long adminid = getAdminId();
		validator(communityServiceTemp.getMerchantId().longValue() != adminid, "非法访问!");

		CommunityService communityService = communityServiceService.getCommunityServiceByPrimaryKey(serviceId);
		// 判断是否缴纳保证金
		if (communityServiceTemp.getCautionMoneyStatus() == Constant.OpenAdmin.CautionMoneyStatus.UNPAID) {
			// 没有缴纳保证金，直接进行删除
			communityServiceTemp.setStatus(Constant.OpenAdmin.CommunityServiceGroundStatus.DELETE);

			communityServiceService.updateCommunityServiceTemp(communityServiceTemp);

			communityService.setStatus(Constant.OpenAdmin.CommunityServiceGroundStatus.DELETE);
			communityServiceService.updateCommunityService(communityService);
			openAuditInfoComponent.canel(OpenAuditInfoComponent.ObjectType.service_approval, adminid, serviceId + "");
		} else {
			// 新建服务的时候就可以删除,审批通过之后,再删除必须审批,
			// if (communityServiceTemp.getCautionMoneyStatus() ==
			// Constant.OpenAdmin.CautionMoneyStatus.PAID) {
			// 已经缴纳保证金
			if (Constant.OpenAdmin.CommunityServiceGroundStatus.GROUNDING == communityService.getStatus()) {
				error("服务处于上架状态，请先下架服务再进行删除");
			}

			// 查询是否存在未提现的且已支付的订单
			long count = openOrderService.getOpenOrderCount(communityService.getAppId(), 4, 2);
			if (count > 0) {
				error("该服务存在未提现完成的订单，请先提现完成再进行删除");
			}

			communityServiceTemp.setAuditStatus(Constant.OpenAdmin.CommunityServiceAuditStatus.DELETE_AUDIT);
			communityServiceService.updateCommunityServiceTemp(communityServiceTemp);

			// 提交服务删除申请
			openAuditInfoComponent.add(OpenAuditInfoComponent.ObjectType.service_delete_apply, getAdminId(),
					communityServiceTemp.getId().toString(), communityServiceTemp.getId());
			// 消息
			List<String> parameter = new ArrayList<>();
			parameter.add(communityServiceTemp.getTitle());
			sysMsgInfoComponent.addPlatform(SysMsgInfoComponent.ObjectType.open_service_delete_apply,
					communityServiceTemp.getId().toString(), parameter);
		}

		return Result.success();
	}

	@RequestMapping("/submit_service_audit")
	public Result<?> submitServiceAudit(@RequestParam("service_id") int serviceId,
			@RequestParam(value = "remark", required = false, defaultValue = "") String remark,
			@RequestParam(value = "interface_ids", required = false, defaultValue = "") String interfaceIds) {
		Long adminid = getAdminId();
		CommunityServiceTemp communityServiceTemp = communityServiceService
				.getCommunityServiceTempByPrimaryKey(serviceId);
		if (communityServiceTemp == null) {
			error("此服务信息不存在");
		}

		validator(communityServiceTemp.getMerchantId().longValue() != adminid.longValue(), "非法访问!");

		if (communityServiceTemp.getAuditStatus() == Constant.OpenAdmin.CommunityServiceAuditStatus.AUDIT
				|| Constant.OpenAdmin.CommunityServiceGroundAuditStatus.AUDIT == communityServiceTemp
						.getGroundAuditStatus()) {
			error("服务正在审核中，不能提交上架申请");
		}

		//

		// 上架配置
		OpenServiceDetail detail = communityServiceService.getOpenServiceDetail(serviceId);
		if (detail != null) {
			if (OpenConstant.open_service_detail.develop_type.TEMPLETE.name().equals(detail.getDevelopType())) {
				validator(StringUtils.isBlank(detail.getTempleteName()), "错误,请先配置服务模板.");
				validator(detail.getTempleteStatus() != 1, "错误,请服务模板未启用.");
			}
		}

		if (communityServiceTemp.getAppId() <= 0 || StringUtils.isBlank(communityServiceTemp.getLink())) {
			error("服务链接没有填写，请先填写服务链接后再提交上架申请");
		}

		validator(StringUtils.isBlank(communityServiceTemp.getPng()), "请补充[服务图标]");
		validator(StringUtils.isBlank(communityServiceTemp.getShot()), "请补充[服务截图]");

		communityServiceTemp.setStatus(Constant.OpenAdmin.CommunityServiceGroundStatus.UNGROUNDING);
		communityServiceTemp.setGroundAuditStatus(Constant.OpenAdmin.CommunityServiceGroundAuditStatus.AUDIT);
		communityServiceTemp.setUpdateTime(new Date());
		communityServiceTemp.setRemark(remark);
		communityServiceService.updateCommunityServiceTemp(communityServiceTemp);

		if (StringUtils.isNotBlank(interfaceIds)) {
			// 插入接口申请表中
			String[] ids = interfaceIds.split(",");
			for (int i = 0; i < ids.length; i++) {

				if (openServiceInterfaceService.getServiceInterface(serviceId, Integer.parseInt(ids[i])) == null) {
					OpenServiceInterface openServiceInterface = new OpenServiceInterface();
					openServiceInterface.setCreateTime(new Date());
					openServiceInterface.setInterfaceId(Integer.parseInt(ids[i]));
					openServiceInterface.setServiceId(serviceId);
					openServiceInterface.setAuditStatus(Constant.OpenAdmin.ServiceInterfaceAuditStatus.AUDIT);
					openServiceInterface.setStatus(Constant.OpenAdmin.ServiceInterfaceStatus.DISABLE);

					openServiceInterfaceService.addServiceInterface(openServiceInterface);

					// 平台接口
					platformService.applyService(communityServiceTemp.getAppId(), Integer.parseInt(ids[i]), 1);

					openAuditInfoComponent.add(OpenAuditInfoComponent.ObjectType.service_interface_apply, adminid,
							"s" + openServiceInterface.getServiceId().toString() + ":i" + openServiceInterface.getId(),
							openServiceInterface.getServiceId());

					List<String> parameter = new ArrayList<>();
					parameter.add(communityServiceTemp.getTitle());
					sysMsgInfoComponent.addPlatform(SysMsgInfoComponent.ObjectType.open_service_interface_apply,
							communityServiceTemp.getId().toString(), parameter);
				}

			}
		}

		// TODO xxxxxxxxxxxxx 有问题
		// 插入审核表中
		openAuditInfoComponent.add(OpenAuditInfoComponent.ObjectType.submit_service_audit, adminid,
				communityServiceTemp.getId().toString(), communityServiceTemp.getId());
		// 消息
		List<String> parameter = new ArrayList<>();
		parameter.add(communityServiceTemp.getTitle());
		sysMsgInfoComponent.addPlatform(SysMsgInfoComponent.ObjectType.open_submit_service_audit,
				communityServiceTemp.getId().toString(), parameter);
		//
		return Result.success();
	}

	@RequestMapping("/modify_service_ground_mode")
	public Result<?> modifyServiceGroundMode(@RequestParam("service_id") int serviceId,
			@RequestParam("ground_mode") int groundMode) {
		CommunityServiceTemp communityServiceTemp = communityServiceService
				.getCommunityServiceTempByPrimaryKey(serviceId);
		if (communityServiceTemp == null) {
			error("此服务信息不存在");
		}
		validator(communityServiceTemp.getMerchantId().longValue() != getAdminId().longValue(), "非法访问!");
		if (StringUtils.isBlank(Constant.OpenAdmin.GroundMode.translate(groundMode))) {
			error("上架模式选择不正确，只能选手动上架或自动上架");
		}
		communityServiceTemp.setGroundMode(groundMode);
		communityServiceService.updateCommunityServiceTemp(communityServiceTemp);
		return Result.success();
	}

	@RequestMapping("debug_user_list")
	public Result<?> debugUserList(@RequestParam("service_id") int serviceId) {
		Long admin = getAdminId();
		CommunityServiceTemp communityServiceTemp = communityServiceService
				.getCommunityServiceTempByPrimaryKey(serviceId);
		validator(communityServiceTemp == null, "此服务信息不存在");
		validator(communityServiceTemp.getMerchantId().longValue() != getAdminId(), "非法访问!");
		return Result.successData(openDebugUserService.getOpenDebugUserList(serviceId, admin));
	}

	@RequestMapping("/add_debug_user")
	@Transactional(rollbackFor = Exception.class)
	public Result<?> addDebugUser(@RequestParam("service_id") int serviceId, @RequestParam("phone") String phone) {
		Long admin = getAdminId();
		CommunityServiceTemp communityServiceTemp = communityServiceService
				.getCommunityServiceTempByPrimaryKey(serviceId);
		validator(communityServiceTemp == null, "此服务信息不存在");
		validator(communityServiceTemp.getMerchantId().longValue() != getAdminId(), "非法访问!");
		if (StringUtils.isBlank(phone)) {
			error("调试账号不能为空");
		}

		if (!RegexUtils.isMobile(phone)) {
			error("调试账号不符合手机号码格式");
		}
		// 控制服务最多只能添加5个调试账号
		if (openDebugUserService.getOpenDebugUserCount(serviceId) >= Constant.OpenAdmin.MAX_DEBUG_USER_COUNT) {
			error("最多只能添加" + Constant.OpenAdmin.MAX_DEBUG_USER_COUNT + "个调试账号");
		}
		UserInfoExample ele = new UserInfoExample();
		ele.createCriteria().andPhoneEqualTo(phone);
		long count = userInfoMapper.countByExample(ele);
		validator(count == 0, "自在社区 APP 没有注册这个 手机号码!" + phone);

		// 添加为测试社区的认证会员
		MasterChild masterChild = masterChildService.getMasterChild(debugCommunityId, debugMasterInfoId, phone);
		if (masterChild == null) {
			masterChild = new MasterChild();
			masterChild.setCommunityId(debugCommunityId);
			masterChild.setMasterId(debugMasterInfoId);
			masterChild.setPhone(phone);
			masterChild.setName("自在服务测试账号");
			masterChild.setCreateTime(new Date());
			masterChild.setType(1);
			masterChild.setStatus(1);
			masterChildService.addMasterChild(masterChild);
			VisitCommunityUser visitCommunityUser = new VisitCommunityUser();
			visitCommunityUser.setRoleId(3);
			visitCommunityUser.setAgentPhone(phone);
			visitCommunityUser.setPhone(phone);
			visitCommunityUser.setMasterId(debugMasterInfoId);
			visitCommunityUserMapper.insertSelective(visitCommunityUser);
		}

		validator(openDebugUserService.getOpenDebugUserCount(serviceId, phone) > 0, "改手机号码已经添加为调试账号" + phone);

		OpenDebugUser openDebugUser = new OpenDebugUser();

		openDebugUser.setCreateTime(new Date());
		openDebugUser.setPhone(phone);
		openDebugUser.setServiceId(serviceId);
		openDebugUser.setMerchantId(admin);
		openDebugUserService.addOpenDebugUser(openDebugUser);
		return Result.success();
	}

	@RequestMapping("/delete_debug_user")
	public Result<?> deleteDebugUser(@RequestParam("id") int id) {
		OpenDebugUser de = openDebugUserService.getOpenDebugUser(id);
		validator(de == null, "信息不存在");
		validator(de.getMerchantId().longValue() != getAdminId(), "非法访问!");
		openDebugUserService.deleteOpenDebugUser(id);
		return Result.success();
	}

	@RequestMapping("/service_audit")
	@Transactional(rollbackFor = Exception.class)
	public Result<?> serviceAudit(@RequestParam("service_id") int serviceId,
			@RequestParam("audit_status") int auditStatus, @RequestParam("audit_comment") String auditComment)
			throws IllegalAccessException, InvocationTargetException {
		CommunityServiceTemp communityServiceTemp = communityServiceService
				.getCommunityServiceTempByPrimaryKey(serviceId);
		validator(communityServiceTemp == null, "此服务信息不存在");
		validator(communityServiceTemp.getMerchantId().longValue() != getAdminId(), "非法访问!");
		// if(StringUtils.isBlank(Constant.OpenAdmin.ThirdAPPStatus.translate(auditStatus))){
		// error("审批状态不对，只能是 通过或不通过");
		// }
		if (StringUtils.isBlank(auditComment)) {
			error("审批意见不能为空");
		}
		communityServiceTemp.setAuditStatus(auditStatus);
		communityServiceTemp.setAuditComment(auditComment);
		communityServiceTemp.setAuditTime(new Date());
		communityServiceService.updateCommunityServiceTemp(communityServiceTemp);
		// 审核通过之后，把临时表中的数据同步到正式表中
		if (1 == auditStatus) {
			CommunityService communityService = communityServiceService.getCommunityServiceByPrimaryKey(serviceId);
			// 正式表中为空时，进行插入操作
			if (communityService == null) {
				communityService = new CommunityService();
				BeanUtils.copyProperties(communityService, communityServiceTemp);
				communityServiceService.addCommunityService(communityService);
			} else {
				BeanUtils.copyProperties(communityService, communityServiceTemp);
				communityServiceService.updateCommunityService(communityService);
			}
			// 删除社区服务关系正式表的数据
			communityServiceRelaService.deleteCommunityServiceRela(serviceId);
			// 修改社区安装服务关系
			List<CommunityServiceRelaTemp> list = communityServiceRelaService
					.getCommunityServiceRelaTempList(serviceId);
			// 上架模式为自动上架时，审批通过后，服务范围内的社区全部自动上架
			if (Constant.OpenAdmin.GroundMode.AUTO == communityServiceTemp.getGroundMode()) {
				// 更新社区服务关系表状态为上架
				for (CommunityServiceRelaTemp communityServiceRelaTemp : list) {
					// communityServiceRelaTemp.setStatus(Constant.OpenAdmin.CommunityServiceRelaStatus.GROUNDING);
					communityServiceRelaService.updateCommunityServiceRelaTemp(communityServiceRelaTemp);
					CommunityServiceRela communityServiceRela = new CommunityServiceRela();
					BeanUtils.copyProperties(communityServiceRela, communityServiceRelaTemp);
					communityServiceRelaService.addCommunityServiceRela(communityServiceRela);
				}
			}
		}
		return Result.success();
	}

	@Deprecated
	@RequestMapping("/payment_caution_money")
	@Transactional(rollbackFor = Exception.class)
	public Result<?> paymentCautionMoney(@RequestParam("service_id") int serviceId,
			@RequestParam(value = "caution_money", required = false, defaultValue = "0") String cautionMoney,
			@RequestParam("type") int type,
			@RequestParam(value = "caution_money_pic", required = false, defaultValue = "") String cautionMoneyPic,
			@RequestParam(value = "pay_channel", required = false, defaultValue = "") String payChannel,
			HttpServletRequest request) {
		validator(true, "您请求的数据存在有缓存,请Ctrl+F5刷新!");

		CommunityServiceTemp communityServiceTemp = communityServiceService
				.getCommunityServiceTempByPrimaryKey(serviceId);
		validator(communityServiceTemp == null, "此服务信息不存在");
		validator(communityServiceTemp.getMerchantId().longValue() != getAdminId(), "非法访问!");
		if (StringUtils.isBlank(Constant.OpenAdmin.CautionMoneyType.translate(type))) {
			error("保证金类别不正确，只能为线上或线下");
		}
		// 修改保证金
		communityServiceTemp.setCautionMoneyType(type);
		// 判断保证金类别
		if (type == Constant.OpenAdmin.CautionMoneyType.ONLINE) {
			if (StringUtils.isBlank(payChannel)) {
				error("线上支付时，支付渠道不能为空");
			}
			if (Double.parseDouble(cautionMoney) > 0) {
				// TODO sdddddddddd
				long feeAmount = 0;
				// 如果是线上支付的，则调用支付中心的支付接口进行支付
				String outTradeNo = String.format("%s%d%s", Constant.OpenOrder.PAY_CAUTION_PREFIX, System.nanoTime(),
						RandomStringUtils.randomNumeric(10));
				ResponseData<FuPayCreateResponseModel> responseData = fuPayService.fuPayCreate(rfpayAppId,
						rfpayAppSecret, rfpayAccountId, payChannel, outTradeNo,
						new BigDecimal(cautionMoney).multiply(new BigDecimal("100")).longValue(), feeAmount,
						communityServiceTemp.getTitle() + "服务的保证金", communityServiceTemp.getTitle() + "服务的保证金",
						communityServiceTemp.getTitle() + "服务的保证金", HttpUtil.getIp2(request), 2, null, "保证金", "NATIVE",
						null, null);

				if (responseData.getCode() == 1001) {
					// 保存订单信息
					OpenOrder openOrder = new OpenOrder();
					openOrder.setAccountId(rfpayAccountId);
					openOrder.setAppId(rfpayAppId);
					openOrder.setBillCreateTime(responseData.getData().getCreateTime());
					openOrder.setBillId(responseData.getData().getBillId());
					openOrder.setBillStatus(1);
					openOrder.setBody(communityServiceTemp.getTitle() + "服务的保证金");
					openOrder.setBussinessType(2);
					openOrder.setClientIp(HttpUtil.getIp2(request));
					openOrder.setCreateTime(responseData.getData().getCreateTime());
					openOrder.setDetail(communityServiceTemp.getTitle() + "服务的保证金");
					openOrder.setExpireTime(null);
					openOrder.setGoodsDetail(null);
					openOrder.setOutTradeNo(outTradeNo);
					openOrder.setPayChannel(payChannel);
					openOrder.setProjectType("保证金");
					// openOrder.setServiceStatus(1);
					openOrder.setSubject(communityServiceTemp.getTitle() + "服务的保证金");
					openOrder.setTotalAmount(new BigDecimal(cautionMoney));
					openOrder.setTradeType("NATIVE");
					openOrder.setCommunityTradeNo(outTradeNo);
					openOrder.setOutTradeNo(outTradeNo);
					openOrder.setReceiptAmount(new BigDecimal(cautionMoney));
					openOrder.setType(OpenConstant.open_order.Type.caution);
					openOrder.setServiceId(serviceId);
					openOrderService.insertOpenOrder(openOrder);
					// 修改服务信息
					communityServiceTemp.setCautionBillId(responseData.getData().getBillId());
					communityServiceService.updateCommunityServiceTemp(communityServiceTemp);
					return Result.successData(responseData.getData());
				} else {
					error("支付失败" + JSON.toJSONString(responseData));
				}
			} else {
				communityServiceTemp.setPaidCautionMoney(new BigDecimal("0"));
				communityServiceTemp.setCautionMoneyStatus(Constant.OpenAdmin.CautionMoneyStatus.PAID);
				communityServiceTemp.setAuditStatus(Constant.OpenAdmin.CommunityServiceAuditStatus.AUDIT_PASS_PAID);
				communityServiceService.updateCommunityServiceTemp(communityServiceTemp);

				CommunityService communityService1 = new CommunityService();
				communityService1.setId(serviceId);
				communityService1.setCautionMoneyType(type);
				communityService1.setCautionMoneyStatus(Constant.OpenAdmin.CautionMoneyStatus.PAID);
				communityService1.setAuditStatus(Constant.OpenAdmin.CommunityServiceAuditStatus.AUDIT_PASS_PAID);
				communityServiceService.updateCommunityService(communityService1);

			}
		}
		if (type == Constant.OpenAdmin.CautionMoneyType.OFFLINE) {
			if (StringUtils.isBlank(cautionMoneyPic)) {
				error("线下支付时，保证金转账图片不能为空");
			}
			communityServiceTemp.setCautionMoneyPic(cautionMoneyPic);
			// 修改服务信息
			communityServiceService.updateCommunityServiceTemp(communityServiceTemp);
			//
			CommunityService communityServiceInfo = new CommunityService();
			communityServiceInfo.setId(serviceId);
			communityServiceInfo.setCautionMoneyPic(cautionMoneyPic);
			communityServiceInfo.setCautionMoneyType(type);
			communityServiceService.updateCommunityService(communityServiceInfo);
			//
			List<String> parameter = new ArrayList<>();
			parameter.add(communityServiceTemp.getTitle());
			sysMsgInfoComponent.addPlatform(ObjectType.open_caution_money_pic, serviceId + "", parameter);
		}

		return Result.success();
	}

	@RequestMapping("/service_apply_pay_interface")
	public Result<?> serviceApplyPayInterface(@RequestParam("service_id") int serviceId,
			@RequestParam("notify_url") String notifyUrl
//			@RequestParam("account_receivable_project") String accountReceivableProject
	) {
		Long adminid = getAdminId();
		CommunityServiceTemp communityServiceTemp = communityServiceService
				.getCommunityServiceTempByPrimaryKey(serviceId);
		if (communityServiceTemp == null) {
			error("此服务信息不存在");
		}
//
//		validator(StringUtils.isBlank(accountReceivableProject) || accountReceivableProject.length() < 15
//				|| accountReceivableProject.length() > 200, "收款项目介绍 内容在15-200个字之间");

		validator(communityServiceTemp.getMerchantId().longValue() != adminid, "非法访问!");
		validator(communityServiceTemp.getAppId() == null || communityServiceTemp.getAppId() <= 0, "请先提供服务链接!");

		validator(StringUtils.isBlank("" + communityServiceTemp.getAppId()), "请先填写服务连接后，再进行支付接口的申请");
		
		//申请前判断提现信息是否存在
//		OpenMerchantInfo openMerchantInfo = openMerchantInfoMapper.selectByPrimaryKey(communityServiceTemp.getMerchantId());
//		validator(openMerchantInfo == null || openMerchantInfo.getAccountId() == null || openMerchantInfo.getAccountId() <=0,
//		"应用失败，该服务模板涉及收款业务，请先在“服务商中心”提交提现信息并等待审批通过。");
//		
//		httpClientComponent.postTestConnection(notifyUrl, "{\"out_trade_no\":\"0\"}", new Callback() {
//
//			public void call(String url, Response response) throws IOException {
//				if (response.isSuccessful()) {
//					String d = response.body().string();
//					logger.info("回调地址返回内容：" + d + d.length());
//					if ("failure".equals(d) || "success".equals(d)) {
//
//					} else {
//						error("回调地址不正确 " + url + " 必须返回内容必须是[failure或success]");
//					}
//				} else {
//					error("回调地址不正确 " + url + " 返回码:" + response.code());
//				}
//
//			}
//		});
		String resp = null;
		try {
			resp = httpClientComponent.postTestConnection(notifyUrl, "{\"out_trade_no\":\"0\"}");
		}catch (Exception e) {
			error("回调地址访问不通 " + notifyUrl);
		}
		validator(!("failure".equals(resp) || "success".equals(resp)), "回调地址不正确 " + notifyUrl + " 必须返回内容必须是[failure或success]");


		communityServiceTemp.setNotifyUrl(notifyUrl);
		communityServiceTemp.setBalanceReceiveEmail(balanceReceiveEmail);
//		communityServiceTemp.setAccountReceivableProject(accountReceivableProject);
		communityServiceService.updateCommunityServiceTemp(communityServiceTemp);

		// 插入接口申请表中

		OpenServiceInterface openServiceInterface = openServiceInterfaceService
				.getServiceInterface(communityServiceTemp.getId(), OPEN_INTERFACE_PAY);
		if (openServiceInterface == null) {
			openServiceInterface = new OpenServiceInterface();
			openServiceInterface.setAuditStatus(Constant.OpenAdmin.ServiceInterfaceAuditStatus.AUDIT);
			openServiceInterface.setCreateTime(new Date());
			openServiceInterface.setInterfaceId(OPEN_INTERFACE_PAY);
			openServiceInterface.setServiceId(communityServiceTemp.getId());
			openServiceInterface.setStatus(Constant.OpenAdmin.ServiceInterfaceStatus.DISABLE);
			// platformService.applyPayService(communityServiceTemp.getAppId(),
			// notifyUrl, balanceReceiveEmail, 1);
			openServiceInterfaceService.addServiceInterface(openServiceInterface);
			// 插入审核表中
			openAuditInfoComponent.add(OpenAuditInfoComponent.ObjectType.service_apply_pay, adminid,
					"s" + openServiceInterface.getServiceId().toString() + ":i" + openServiceInterface.getId(),
					openServiceInterface.getServiceId());

			// 消息
			List<String> parameter = new ArrayList<>();
			parameter.add(communityServiceTemp.getTitle());
			sysMsgInfoComponent.addPlatform(SysMsgInfoComponent.ObjectType.open_service_apply_pay,
					communityServiceTemp.getId().toString(), parameter);
		} else if (openServiceInterface.getAuditStatus() == Constant.OpenAdmin.ServiceInterfaceAuditStatus.AUDIT) {
			error("支付接入审核中，不能重复提交");
		} else if (openServiceInterface.getAuditStatus() == Constant.OpenAdmin.ServiceInterfaceAuditStatus.AUDIT_PASS) {
			// 通过
			CommunityService commce = new CommunityService();
			commce.setId(serviceId);
			commce.setNotifyUrl(notifyUrl);
			communityServiceService.updateCommunityService(commce);
		} else {

			// 对方是否有开通.
			// GetServiceApplyProgressResponseModel progress = platformService
			// .getServiceApplyProgressRequest(communityServiceTemp.getAppId(),
			// OPEN_INTERFACE_PAY);
			// if (progress == null || progress.getStatus() == 1) {
			// platformService.applyPayService(communityServiceTemp.getAppId(),
			// notifyUrl, balanceReceiveEmail, 1);
			// }

			OpenServiceInterface openServiceIntece = new OpenServiceInterface();
			openServiceIntece.setId(openServiceInterface.getId());
			openServiceIntece.setAuditStatus(Constant.OpenAdmin.ServiceInterfaceAuditStatus.AUDIT);
			openServiceIntece.setAuditComment("");
			openServiceInterfaceService.updateServiceInterface(openServiceIntece);

			// 插入审核表中
			openAuditInfoComponent.add(OpenAuditInfoComponent.ObjectType.service_apply_pay, adminid,
					"s" + openServiceInterface.getServiceId().toString() + ":i" + openServiceInterface.getId(),
					openServiceInterface.getServiceId());

			List<String> parameter = new ArrayList<>();
			parameter.add(communityServiceTemp.getTitle());
			sysMsgInfoComponent.addPlatform(SysMsgInfoComponent.ObjectType.open_service_apply_pay,
					communityServiceTemp.getId().toString(), parameter);
		}

		if (openServiceInterface.getStatus() == 1) {
			// 调用平台接口，申请开通支付服务
			//
			// platformService.auditService(communityServiceTemp.getAppId(),
			// OPEN_INTERFACE_PAY, auditService_pass,
			// "系统通过");
		}

		return Result.success();
	}

	@RequestMapping("/cancel_pay_apply_audit")
	public Result<?> cancelPayApplyAudit(@RequestParam("service_id") int serviceId) {
		Long adminid = getAdminId();
		OpenServiceInterface openServiceInterface = openServiceInterfaceService.getServiceInterface(serviceId,
				OPEN_INTERFACE_PAY);

		if (openServiceInterface == null) {
			error("没有查询到支付申请信息");
		}

		if (openServiceInterface.getAuditStatus() != Constant.OpenAdmin.ServiceInterfaceAuditStatus.AUDIT) {
			error("支付申请状态不在审核中，不能撤销审核");
		}

		openServiceInterface.setAuditStatus(Constant.OpenAdmin.ServiceInterfaceAuditStatus.CANCEL_AUDIT);
		openServiceInterfaceService.updateServiceInterface(openServiceInterface);
		openAuditInfoComponent.canel(OpenAuditInfoComponent.ObjectType.service_apply_pay, adminid,
				"s" + openServiceInterface.getServiceId().toString() + ":i" + openServiceInterface.getId());

		return Result.success();
	}

	@RequestMapping("/interface_list")
	public Result<?> getInterfaceList(@RequestParam(value = "title", required = false, defaultValue = "") String title,
			@RequestParam(value = "status", required = false, defaultValue = "1") int status,
			@RequestParam("service_id") int serviceId) {
		// GetServiceListResponseModel getServiceListResponseModel =
		// platformService.getInterfaceList(title, status);
		// if (getServiceListResponseModel == null ||
		// getServiceListResponseModel.size() == 0) {
		// error("获取接口列表失败");
		// }

		List<OpenInterface> openServiceList = openInterfaceService.getOpenServiceList(1);
		List<ExtInterfaceList> list = new ArrayList<>();

		if (openServiceList != null && openServiceList.size() > 0) {
			for (int i = 0; i < openServiceList.size(); i++) {
				GetApiListResponseModel apiListResponseModel = platformService.getApiList(null,
						openServiceList.get(i).getId(), null, 1, 50, 0, true);
				ExtInterfaceList extInterfaceList = new ExtInterfaceList();
				extInterfaceList.setApiListResponseModel(apiListResponseModel);
				extInterfaceList.setCreateTime(openServiceList.get(i).getCreateTime());
				extInterfaceList.setDescription(openServiceList.get(i).getDescription());
				extInterfaceList.setId(openServiceList.get(i).getId());

				// 查询服务申请状态
				OpenServiceInterface openServiceInterface = openServiceInterfaceService.getServiceInterface(serviceId,
						openServiceList.get(i).getId());

				if (openServiceInterface != null) {

					if (1 == openServiceInterface.getAuditStatus()) {
						extInterfaceList.setStatus(3); // 申请中状态
					}

					if (2 == openServiceInterface.getAuditStatus()) {
						extInterfaceList.setStatus(1); // 已授权
					}

					if (3 == openServiceInterface.getAuditStatus()) {
						extInterfaceList.setStatus(4); // 审核不通过，重新申请
					}
				} else {
					extInterfaceList.setStatus(2);
				}
				extInterfaceList.setTitle(openServiceList.get(i).getTitle());
				list.add(extInterfaceList);
			}
		}

		return Result.successData(list);
	}

	/**
	 * 平台接口
	 * 
	 * @param serviceId
	 * @param interfaceId
	 * @return
	 */
	@RequestMapping("/service_apply_common_interface")
	public Result<?> serviceApplyCommonInterface(@RequestParam("service_id") int serviceId,
			@RequestParam("interface_id") int interfaceId) {
		CommunityServiceTemp communityServiceTemp = communityServiceService
				.getCommunityServiceTempByPrimaryKey(serviceId);
		validator(communityServiceTemp == null, "此服务信息不存在");
		validator(communityServiceTemp.getMerchantId().longValue() != getAdminId(), "非法访问!");
		// boolean flag =
		// platformService.applyService(communityServiceTemp.getAppId(),
		// interfaceId, 3);
		// if (flag == false) {
		// error("开通服务失败");
		// }

		OpenServiceInterface openServiceInterface = openServiceInterfaceService
				.getServiceInterface(communityServiceTemp.getId(), interfaceId);
		if (openServiceInterface == null) {
			// 插入服务接口申请表中
			openServiceInterface = new OpenServiceInterface();
			openServiceInterface.setCreateTime(new Date());
			openServiceInterface.setInterfaceId(interfaceId);
			openServiceInterface.setServiceId(serviceId);
			openServiceInterface.setStatus(Constant.OpenAdmin.ServiceInterfaceStatus.DISABLE);
			openServiceInterface.setAuditStatus(Constant.OpenAdmin.ServiceInterfaceAuditStatus.AUDIT);
			openServiceInterfaceService.addServiceInterface(openServiceInterface);
		} else {
			if (openServiceInterface.getAuditStatus() == Constant.OpenAdmin.ServiceInterfaceAuditStatus.AUDIT) {
				error("接口正在审核中，不能重复提交");
			}

			if (openServiceInterface.getAuditStatus() == 3) {
				openServiceInterface.setAuditStatus(Constant.OpenAdmin.ServiceInterfaceAuditStatus.AUDIT);

				openServiceInterfaceService.updateServiceInterface(openServiceInterface);
			}
		}
		// 调用平台接口，申请开通接口
		platformService.applyService(communityServiceTemp.getAppId(), interfaceId, 1);

		openAuditInfoComponent.add(OpenAuditInfoComponent.ObjectType.service_interface_apply, getAdminId(),
				"s" + openServiceInterface.getServiceId().toString() + ":i" + openServiceInterface.getId(),
				openServiceInterface.getServiceId());

		return Result.success();
	}

	@RequestMapping("/user_evaluate")
	public Result<?> getUserEvaluate(@RequestParam("service_id") int serviceId) {
		CommunityServiceTemp communityServiceTemp = communityServiceService
				.getCommunityServiceTempByPrimaryKey(serviceId);
		validator(communityServiceTemp == null, "此服务信息不存在");
		validator(communityServiceTemp.getMerchantId().longValue() != getAdminId(), "非法访问!");
		return Result.successData(communityServiceCountService.getCommunityServiceCount(serviceId));
	}

	@RequestMapping("/user_comment_list")
	public Result<?> getUserComment(@RequestParam("service_id") int serviceId,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) {
		if (serviceId <= 0) {
			error("服务ID不能少于0");
		}
		CommunityServiceTemp communityServiceTemp = communityServiceService
				.getCommunityServiceTempByPrimaryKey(serviceId);
		validator(communityServiceTemp == null, "此服务信息不存在");
		validator(communityServiceTemp.getMerchantId().longValue() != getAdminId(), "非法访问!");
		return Result
				.successData(communityServiceCommentService.getCommunityServiceCommentList(serviceId, index, size));
	}

	@RequestMapping("add_service_pic")
	public Result<?> addServicePic(@RequestParam("service_id") int serviceId, @RequestParam("pic_url") String picUrl,
			@RequestParam("type") int type) {
		CommunityServiceTemp communityServiceTemp = communityServiceService
				.getCommunityServiceTempByPrimaryKey(serviceId);
		validator(communityServiceTemp == null, "此服务信息不存在");
		validator(communityServiceTemp.getMerchantId().longValue() != getAdminId(), "非法访问!");

		if (type == 1) {
			if (StringUtils.isBlank(picUrl)) {
				error("图片地址不能为空");
			}
			communityServiceTemp.setPng(picUrl);
		}
		if (type == 2) {

			if (StringUtils.isNotBlank(picUrl)) {

				String[] strs = picUrl.split(",");
				if (strs.length > 5) {
					error("最多只能上传5张服务截图");
				}
				communityServiceTemp.setShot(picUrl);
			} else {
				communityServiceTemp.setShot("");
			}
		}
		communityServiceService.updateCommunityServiceTemp(communityServiceTemp);
		return Result.success();
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 小富市集更换图标免审核
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/xfsj/add_service_pic")
	public Result<?> addXFSJServicePic(@RequestParam("service_id") int serviceId,
			@RequestParam("pic_url") String picUrl) {
		CommunityServiceTemp communityServiceTemp = communityServiceService
				.getCommunityServiceTempByPrimaryKey(serviceId);
		validator(communityServiceTemp == null, "此服务信息不存在");
		validator(communityServiceTemp.getMerchantId().longValue() != getAdminId(), "非法访问!");

		if (StringUtils.isBlank(picUrl)) {
			error("图片地址不能为空");
		}
		communityServiceTemp.setPng(picUrl);
		communityServiceService.updateCommunityServiceTemp(communityServiceTemp);
		
		//直接更新到正式表
		CommunityService service = new CommunityService();
		service.setId(serviceId);
		service.setPng(picUrl);
		communityServiceMapper.updateByPrimaryKeySelective(service);
		return Result.success();
	}

	@RequestMapping("delete_service_pic")
	public Result<?> deleteServicePic(@RequestParam("service_id") int serviceId, @RequestParam("pic_url") String picUrl,
			@RequestParam("type") int type) {
		CommunityServiceTemp communityServiceTemp = communityServiceService
				.getCommunityServiceTempByPrimaryKey(serviceId);
		validator(communityServiceTemp == null, "此服务信息不存在");
		validator(communityServiceTemp.getMerchantId().longValue() != getAdminId(), "非法访问!");
		if (StringUtils.isBlank(picUrl)) {
			error("图片地址不能为空");
		}
		if (type == 1) {
			communityServiceTemp.setPng("");
		}
		if (type == 2) {
			String shot = communityServiceTemp.getShot();
			JSONArray jsonArray = null;
			if (StringUtils.isBlank(shot)) {
				jsonArray = new JSONArray();
			} else {
				jsonArray = JSON.parseArray(shot);
			}
			jsonArray.remove(picUrl);
			communityServiceTemp.setShot(jsonArray.toJSONString());
		}
		communityServiceService.updateCommunityServiceTemp(communityServiceTemp);
		return Result.success();
	}

	@RequestMapping("/service_info")
	public Result<?> serviceInfo(@RequestParam("service_id") int serviceId) {
		CommunityServiceTemp communityServiceTemp = communityServiceService
				.getCommunityServiceTempByPrimaryKey(serviceId);
		validator(communityServiceTemp == null, "此服务信息不存在");
		validator(communityServiceTemp.getMerchantId().longValue() != getAdminId(), "非法访问!");
		List<CommunityServiceRelaTemp> list = communityServiceRelaService.getCommunityServiceRelaTempList(serviceId);
		StringBuffer sb = new StringBuffer();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				sb.append(",");
				sb.append(list.get(i).getCommunityId());
			}
		}

		List<OpenServiceArea> areaList = openServiceAreaService.getOpenServiceAreaList(serviceId);
		if (areaList != null && areaList.size() > 0) {
			for (int i = 0; i < areaList.size(); i++) {
				sb.append(",");
				sb.append("a" + areaList.get(i).getAreaId());
			}
		}

		ExtCommunityServiceTemp extCommunityServiceTemp = communityServiceService
				.getCommunityServiceTempInfo(serviceId);
		if (extCommunityServiceTemp != null) {
			if (StringUtils.isNotBlank(sb)) {
				extCommunityServiceTemp.setCommunityIds(sb.toString().substring(1));
			} else {
				extCommunityServiceTemp.setCommunityIds("");
			}
		} else {
			error("没有此服务信息");
		}

		// 查询服务商信息
		OpenMerchantInfo openMerchantInfo = openMerchantInfoMapper.selectByPrimaryKey(getAdminId());

		// 查询支付接入状态
		OpenServiceInterface openServiceInterface = openServiceInterfaceService.getServiceInterface(serviceId, 7);
		if (openServiceInterface == null) {
			extCommunityServiceTemp.setPayStatus(0);
		} else {
			extCommunityServiceTemp.setPayStatus(openServiceInterface.getAuditStatus());
			extCommunityServiceTemp.setPayComment(openServiceInterface.getAuditComment());
		}

//		BigDecimal commissionRate = extCommunityServiceTemp.getCommissionRate() == null ? new BigDecimal("0")
//				: extCommunityServiceTemp.getCommissionRate();


		OpenServicePay pay1 = openServicePayService.getOpenServicePay(serviceId);
		
		extCommunityServiceTemp
				.setPlatformServiceFee(pay1.getCommunityRate().add(pay1.getPlatformFee()).add(pay1.getThinkRate()));
		
		extCommunityServiceTemp.setKeyword(openServiceExtendService.getKeyword(serviceId));
		OpenStoreServiceTemplete templete = openStoreServiceTempleteService.getTempleteDomain(serviceId);
		if(templete != null) {
			extCommunityServiceTemp.setBannerUrl(templete.getBannerUrl());
			extCommunityServiceTemp.setPhone(templete.getPhone());
		}
		return Result.successData(extCommunityServiceTemp);
	}

	@RequestMapping("/service_category_list")
	public Result<?> serviceCategoryList(@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size,
			@RequestParam(value = "type", required = false, defaultValue = "2") int type) {
		return Result.successData(communityServiceCategoryService.getCommunityServiceCategoryList(index, size, type));
	}
	
//	@RequestMapping("/xfsj/service_category_list")
//	public Result<?> xfsjServiceCategoryList(@RequestParam(value = "index", required = false, defaultValue = "1") int index,
//			@RequestParam(value = "size", required = false, defaultValue = "10") int size) {
//		return Result.successData(communityServiceCategoryService.getCommunityServiceCategoryList(index, size, 3));
//	}

	@RequestMapping("/service_area_list")
	public Result<?> getServiceAreaList() throws IllegalAccessException, InvocationTargetException {
		// 查询所有社区
		List<Community> list = communityService.getCommunityList();
		List<ExtCommunity> extCommunityList = new ArrayList<>();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				ExtCommunity extCommunity = new ExtCommunity();
				BeanUtils.copyProperties(extCommunity, list.get(i));
				// 通过社区的区域ID，查询上级区域
				Area area = areaService.getArea(list.get(i).getAreaId());
				if (area != null) {
					extCommunity.setAreaName(area.getName());
					if (area.getLevelType() == 1) {
						extCommunity.setProvinceAreaId(area.getId());
						extCommunity.setProvinceAreaName(area.getName());
					}
					if (area.getLevelType() == 2) {
						extCommunity.setCityAreaId(area.getId());
						extCommunity.setCityAreaName(area.getName());
						// 查询上级省份
						Area provinceArea = areaService.getArea(area.getParentId());
						extCommunity.setProvinceAreaId(provinceArea.getId());
						extCommunity.setProvinceAreaName(provinceArea.getName());
					}
					if (area.getLevelType() == 3) {
						// 查询城市
						Area cityArea = areaService.getArea(area.getParentId());
						extCommunity.setCityAreaId(cityArea.getId());
						extCommunity.setCityAreaName(cityArea.getName());
						// 查询省份
						Area provinceArea = areaService.getArea(cityArea.getParentId());
						extCommunity.setProvinceAreaId(provinceArea.getId());
						extCommunity.setProvinceAreaName(provinceArea.getName());
					}
				}
				extCommunityList.add(extCommunity);
			}
		}
		return Result.successData(extCommunityList);
	}

	@RequestMapping("/cancel_service_audit")
	public Result<?> cancelServiceAudit(@RequestParam("service_id") int serviceId) {
		Long adminid = getAdminId();
		CommunityServiceTemp communityServiceTemp = communityServiceService
				.getCommunityServiceTempByPrimaryKey(serviceId);
		validator(communityServiceTemp == null, "此服务信息不存在");
		validator(communityServiceTemp.getMerchantId().longValue() != adminid.longValue(), "非法访问!");
		if (communityServiceTemp.getAuditStatus() == Constant.OpenAdmin.CommunityServiceAuditStatus.AUDIT
				|| communityServiceTemp
						.getAuditStatus() == Constant.OpenAdmin.CommunityServiceAuditStatus.DELETE_AUDIT) {
			communityServiceTemp.setAuditStatus(Constant.OpenAdmin.CommunityServiceAuditStatus.CANCEL_AUDIT);
		}
		if (communityServiceTemp.getGroundAuditStatus() == Constant.OpenAdmin.CommunityServiceGroundAuditStatus.AUDIT) {
			communityServiceTemp
					.setGroundAuditStatus(Constant.OpenAdmin.CommunityServiceGroundAuditStatus.CANCEL_AUDIT);
		}
		if (Constant.OpenAdmin.CommunityServiceGroundStatus.UNDER_AUDIT == communityServiceTemp.getStatus()) {
			communityServiceTemp.setStatus(Constant.OpenAdmin.CommunityServiceGroundStatus.GROUNDING);
		}
		communityServiceService.updateCommunityServiceTemp(communityServiceTemp);
		// 取消审核
		openAuditInfoComponent.canel(OpenAuditInfoComponent.ObjectType.service_approval, adminid, serviceId + "");
		openAuditInfoComponent.canel(OpenAuditInfoComponent.ObjectType.service_delete_apply, adminid, serviceId + "");
		openAuditInfoComponent.canel(OpenAuditInfoComponent.ObjectType.under_community_service, adminid,
				serviceId + "");
		openAuditInfoComponent.canel(OpenAuditInfoComponent.ObjectType.submit_service_audit, adminid, serviceId + "");
		return Result.success();
	}

	@RequestMapping("/community_service_add_list")
	public Result<?> communityServiceAddList(@RequestParam("service_id") int serviceId,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size)
			throws MalformedURLException {
		CommunityServiceTemp communityServiceTemp = communityServiceService
				.getCommunityServiceTempByPrimaryKey(serviceId);
		validator(communityServiceTemp == null, "此服务信息不存在");
		validator(communityServiceTemp.getMerchantId().longValue() != getAdminId(), "非法访问!");

		PageList<ExtCommunityServiceRela> pages = communityServiceRelaService.getCommunityServiceAddList(serviceId,
				index, size);
		String prefixUrl = null;
		if(communityServiceTemp.getType() == OpenConstant.CommunityServiceType.third_inner_life) {
			prefixUrl = openStoreapiUrl + "index.html";
			for (ExtCommunityServiceRela extCommunityServiceRela : pages) {
				extCommunityServiceRela.setDownQrcodeUrl(prefixUrl + "#/home?isNew=1&serviceId=" + serviceId + "&communityId="
						+ extCommunityServiceRela.getCommunityId());
			}
		}else{
			prefixUrl = openwebUrl + "/static/jump.html";
			for (ExtCommunityServiceRela extCommunityServiceRela : pages) {
				extCommunityServiceRela.setDownQrcodeUrl(prefixUrl + "?serviceId=" + serviceId + "&communityId="
						+ extCommunityServiceRela.getCommunityId());
			}
		}
		logger.info("prefixUrl={}, RequestURL={}", prefixUrl, request.getRequestURL());

		return Result.successData(pages.convert());
	}

	@RequestMapping("/community_service_add_count")
	public Result<?> communityServiceAddList(@RequestParam("service_id") int serviceId) {
		CommunityServiceTemp communityServiceTemp = communityServiceService
				.getCommunityServiceTempByPrimaryKey(serviceId);
		validator(communityServiceTemp == null, "此服务信息不存在");
		validator(communityServiceTemp.getMerchantId().longValue() != getAdminId(), "非法访问!");
		long totalCount = communityServiceRelaService.getCommunityServiceRelaCount(serviceId, 0);
		long addedCount = communityServiceRelaService.getCommunityServiceRelaCount(serviceId,
				Constant.OpenAdmin.CommunityServiceRelaStatus.ENABLE);
		JSONObject object = new JSONObject();
		object.put("totalCount", totalCount);
		object.put("addedCount", addedCount);
		return Result.successData(object);
	}

	@RequestMapping("/service_to_community_apply")
	public Result<?> serviceToCommunityApply(@RequestParam("service_id") int serviceId,
			@RequestParam("community_id") int communityId,
			@RequestParam("service_contacts_name") String serviceContactsName,
			@RequestParam("service_contacts_phone") String serviceContactsPhone,
			@RequestParam("service_contacts_email") String serviceContactsEmail) {
		CommunityServiceTemp communityServiceTemp = communityServiceService
				.getCommunityServiceTempByPrimaryKey(serviceId);
		validator(communityServiceTemp == null, "此服务信息不存在");
		validator(communityServiceTemp.getMerchantId().longValue() != getAdminId(), "非法访问!");
		CommunityServiceRela communityServiceRela = communityServiceRelaService.getCommunityServiceRela(serviceId,
				communityId);
		CommunityServiceRelaTemp communityServiceRelaTemp = communityServiceRelaService
				.getCommunityServiceRelaTemp(serviceId, communityId);
		if (communityServiceRela == null) {
			error("此数据不存在");
		}
		if (StringUtils.isBlank(serviceContactsName)) {
			error("联系人名称不能为空");
		}
		if (StringUtils.isBlank(serviceContactsPhone)) {
			error("联系人号码不能为空");
		}
		if (!RegexUtils.isMobile(serviceContactsPhone)) {
			error("联系人号码格式不正确");
		}
		if (StringUtils.isBlank(serviceContactsEmail)) {
			error("联系人邮箱不能为空");
		}
		if (!RegexUtils.isEmail(serviceContactsEmail)) {
			error("联系人邮箱格式不正确");
		}

		// TODO 服务向社区发送申请，需要发送消息

		communityServiceRela.setServiceContactsName(serviceContactsName);
		communityServiceRela.setServiceContactsPhone(serviceContactsPhone);
		communityServiceRela.setServiceContactsEmail(serviceContactsEmail);
		communityServiceRela.setAuditStatus(Constant.OpenAdmin.CommunityServiceRelaAuditStatus.AUDIT);
		communityServiceRela.setApplyTime(new Date());
		communityServiceRelaService.updateCommunityServiceRela(communityServiceRela);
		return Result.success();
	}

	@RequestMapping("/service_community_list")
	public Result<?> serviceCommunityList(@RequestParam("service_id") int serviceId,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10000") int size) {
		CommunityServiceTemp communityServiceTemp = communityServiceService
				.getCommunityServiceTempByPrimaryKey(serviceId);
		validator(communityServiceTemp == null, "此服务信息不存在");
		validator(communityServiceTemp.getMerchantId().longValue() != getAdminId(), "非法访问!");
		return Result.successData(
				communityServiceRelaService.getCommunityServiceRelaTempList(serviceId, index, size).convert());
	}

	@RequestMapping("/under_community_service")
	public Result<?> updateCommunityServiceStatus(@RequestParam("service_id") int serviceId,
			@RequestParam("under_reason") String underReason) {
		if (StringUtils.isBlank(underReason)) {
			error("下架理由不能为空");
		}
		// 更新服务的状态为下架
		CommunityServiceTemp communityServiceTemp = communityServiceService
				.getCommunityServiceTempByPrimaryKey(serviceId);
		validator(communityServiceTemp == null, "此服务信息不存在");
		validator(communityServiceTemp.getMerchantId().longValue() != getAdminId(), "非法访问!");
		if (communityServiceTemp != null) {
			Long adminid = getAdminId();
			validator(communityServiceTemp.getMerchantId().longValue() != adminid, "非法访问!");
			communityServiceTemp.setStatus(Constant.OpenAdmin.CommunityServiceGroundStatus.UNDER_AUDIT);
			communityServiceTemp.setUnderReason(underReason);
			communityServiceService.updateCommunityServiceTemp(communityServiceTemp);
			// 发送下架通知
			// 插入审核表中
			openAuditInfoComponent.add(OpenAuditInfoComponent.ObjectType.under_community_service, adminid,
					communityServiceTemp.getId().toString(), communityServiceTemp.getId());
			// 消息
			List<String> parameter = new ArrayList<>();
			parameter.add(communityServiceTemp.getTitle());
			sysMsgInfoComponent.addPlatform(SysMsgInfoComponent.ObjectType.open_under_community_service,
					communityServiceTemp.getId().toString(), parameter);

			// 通知已经上架的社区关联下架
			CommunityServiceRelaExample exa = new CommunityServiceRelaExample();
			exa.createCriteria().andServiceIdEqualTo(serviceId)
					.andStatusEqualTo(Constant.OpenAdmin.CommunityServiceRelaStatus.ENABLE);
			List<CommunityServiceRela> list = communityServiceRelaMapper.selectByExample(exa);
			for (CommunityServiceRela string : list) {
				// sms
				List<String> parameter2 = new ArrayList<>();
				// parameter.add(merchant.getTitle());
				parameter2.add(communityServiceTemp.getTitle());
				sysMsgInfoComponent.add(SysMsgInfoComponent.ObjectType.open_openweb_to_community_under, serviceId + "",
						string.getCommunityId(), null, parameter2);
			}
		}
		return Result.success();
	}

	@RequestMapping("/notify_community")
	public Result<?> notifyCommunity(@RequestParam("service_id") int serviceId,
			@RequestParam("community_id") int communityId) {

		CommunityServiceTemp communityServiceTemp = communityServiceService
				.getCommunityServiceTempByPrimaryKey(serviceId);
		validator(communityServiceTemp == null, "此服务信息不存在");
		validator(communityServiceTemp.getMerchantId().longValue() != getAdminId(), "非法访问!");
		CommunityServiceRela communityServiceRela = communityServiceRelaService.getCommunityServiceRela(serviceId,
				communityId);

		if (communityServiceRela == null) {
			error("此数据不存在");
		}

		if (Constant.OpenAdmin.CommunityServiceRelaAuditStatus.AUDIT != communityServiceRela.getAuditStatus()) {
			error("审批状态不在审批中，不能进行提醒对方操作");
		}

		Calendar now = Calendar.getInstance();
		now.set(Calendar.DATE, now.get(Calendar.DATE) - 5);

		if (communityServiceRela.getApplyTime().after(now.getTime())) {
			error("当前时间离申请时间不足5天，不能提醒对方");
		}

		if (communityServiceRela.getNotifyTime() != null && communityServiceRela.getNotifyTime().after(now.getTime())) {
			error("上一次提醒的时间到现在不足5天，不能再次提醒对方");
		}

		now.setTime(new Date());
		now.set(Calendar.DATE, now.get(Calendar.DATE) - 15);
		if (communityServiceRela.getApplyTime() != null && communityServiceRela.getApplyTime().before(now.getTime())) {
			// 15天没审批的，返回社区联系人信息
			Community community = communityService.getCommunity(communityServiceRela.getCommunityId());

			ExtCommunityContacts extCommunityContacts = new ExtCommunityContacts();
			extCommunityContacts.setCommunityConstactsPhone(community.getBusinessPhone());
			extCommunityContacts.setCommunityContactsName(community.getBusinessPerson());
			extCommunityContacts.setCommuntiyConstactsEmail(community.getBusinessEmail());

			return Result.successData(extCommunityContacts);
		}

		communityServiceRela.setNotifyTime(new Date());

		communityServiceRelaService.updateCommunityServiceRela(communityServiceRela);

		return Result.success();
	}

	@RequestMapping("/reset_appSecret")
	public Result<?> resetAppSecret(@RequestParam("app_id") long appId) {
		return Result.successData(platformService.resetAppSecret(appId));
	}

	@RequestMapping("/service_ground")
	public Result<?> serviceGround(@RequestParam("service_id") int serviceId)
			throws IllegalAccessException, InvocationTargetException {
		CommunityServiceTemp communityServiceTemp = communityServiceService
				.getCommunityServiceTempByPrimaryKey(serviceId);
		if (communityServiceTemp == null) {
			error("此数据不存在");
		}

		communityServiceTemp.setStatus(Constant.OpenAdmin.CommunityServiceGroundStatus.GROUNDING);
		communityServiceTemp.setGroundTime(new Date());

		communityServiceService.updateCommunityServiceTemp(communityServiceTemp);

		CommunityService communityService = new CommunityService();
		BeanUtils.copyProperties(communityService, communityServiceTemp);

		communityServiceService.updateCommunityService(communityService);

		return Result.success();
	}

	// 开通服务
	@RequestMapping("/update_open_service_detail")
	public Result<?> serviceGround(@RequestParam("service_id") int serviceId,
			@RequestParam("templete_name") String templeteName,
			@RequestParam(value = "templete_status", required = false, defaultValue = "1") int templeteStatus) {

		CommunityServiceTemp communityServiceTemp = communityServiceService
				.getCommunityServiceTempByPrimaryKey(serviceId);
		validator(communityServiceTemp == null, "此服务信息不存在");
		validator(communityServiceTemp.getMerchantId().longValue() != getAdminId(), "非法访问!");
		validator(communityServiceTemp.getCautionMoneyStatus() == 2, "未交保证金,不能配置模板模块!");

		OpenServiceDetail detail = communityServiceService.getOpenServiceDetail(serviceId);
		validator(detail == null, "不存在!" + serviceId);
		validator(!detail.getDevelopType().equals(OpenConstant.open_service_detail.develop_type.TEMPLETE.name()),
				"该服务非模板开发不能配置");
		validator(templete_name.STORE.getCode().equals(detail.getTempleteName()) && 
				templete_name.INFO.getCode().equals(templeteName), "您已使用了商城模板，无法降级到周边商家模板，如有需要可联系020-38882777转3891");
		// 需要去查询templet_info表
		// validator(!OpenConstant.open_service_detail.templete_name.isExist(templeteName),
		// "模板不存在");
		
		//如果是微商城等需要支付接入的，需判断提现账号是否审核通过
//		if(!templete_name.INFO.getCode().equals(templeteName)) {
//			OpenMerchantInfo openMerchantInfo = openMerchantInfoMapper.selectByPrimaryKey(communityServiceTemp.getMerchantId());
//			validator(openMerchantInfo == null || openMerchantInfo.getAccountId() == null || openMerchantInfo.getAccountId() <=0,
//			"应用失败，该服务模板涉及收款业务，请先在“服务商中心”提交提现信息并等待审批通过。");
//		}
		
		detail.setTempleteName(templeteName);
		detail.setTempleteStatus(templeteStatus);
		communityServiceService.insertORUpdateOpenServiceDetail(detail);

		// 启动的时候需要授权appid
		if (OpenConstant.open_service_detail.templete_status.start_up == templeteStatus) {
			// 创建appid
			Long appid = communityServiceTemp.getAppId();
			String title = communityServiceTemp.getTitle();
			if (appid == null || appid <= 0) {
				// 访问地址
				// http://store.zizai.test.thinkinpower.net/#/home?serviceId=407
				String link = openStoreapiUrl + "index.html#/home?isNew=1&serviceId=" + serviceId;
				String description = communityServiceTemp.getDescription();
				communityServiceService.createAppidAndSecret(serviceId, title, description, link);
			}

			// 完善回调地址
			Long mid = communityServiceTemp.getMerchantId();
			validator(mid == null || mid <= 0, "请先创建商家ID");
			logger.info("serviceId:{},mid:{}", serviceId, mid);
			String notifyUrl = openStoreapiUrl + "api/openstore/notify_url/" + serviceId;
			communityServiceService.completeNotifyUrl(serviceId, mid, title, notifyUrl);

			// 创建商场信息
			openStoreServiceTempleteService.insertOrUpdate(serviceId, BigDecimal.valueOf(0L), "", "", 0);
		}

		return Result.success();
	}

	//test
	@RequestMapping("/test")
	public void test(@RequestParam("link") String link){
		
			httpClientComponent.postTestConnection(link, "{\"out_trade_no\":\"0\"}", new Callback() {

				public void call(String url, Response response) throws IOException {

					if (response.isSuccessful()) {
						String d = response.body().string();
						logger.info("回调地址返回内容：" + d + d.length());
						if ("failure".equals(d) || "success".equals(d)) {
							
						} else {
							error("回调地址不正确 " + url + " 必须返回内容必须是[failure或success]");
						}
					} else {
						error("回调地址不正确 " + url + " 返回码:" + response.code());
					}
				}
				
			});
	}
		
		
}
