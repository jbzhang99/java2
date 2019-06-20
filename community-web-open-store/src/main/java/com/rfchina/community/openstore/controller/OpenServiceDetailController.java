package com.rfchina.community.openstore.controller;

import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.openstore.entity.ext.ExtCommunity;
import com.rfchina.community.openstore.service.FuPayService;
import com.rfchina.community.openstore.service.OpenServiceDetailService;
import com.rfchina.community.openstore.service.OpenUserServiceService;
import com.rfchina.community.persistence.mapper.CommunityMapper;
import com.rfchina.community.persistence.mapper.UserInfoMapper;
import com.rfchina.community.persistence.model.Area;
import com.rfchina.community.persistence.model.Community;
import com.rfchina.community.persistence.model.OpenServiceDetail;
import com.rfchina.community.persistence.model.UserInfo;
import com.rfchina.community.service.AreaBaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

/**
 */
@RestController
@RequestMapping(value = {Constant.ROOT_PATH_OPENSTORE})
public class OpenServiceDetailController extends BaseController {
	@Autowired
	private OpenServiceDetailService openServiceDetailService;
	@Autowired
	private AreaBaseService areaBaseService;
	@Autowired
	private CommunityMapper communityMapper;
	@Autowired
	private UserInfoMapper userInfoMapper;
	@Autowired
	private OpenUserServiceService openUserServiceService;
	@Autowired
	private FuPayService fuPayService;
	@Value("${rfpay.appId}")
	private Long rfpayAppId;

	@Value("${rfpay.appSecret}")
	private String rfpayAppSecret;

	/**
	 * @author:fukangwen
	 * @Description: 获取店铺模板,顺便保存用户凭证openId到session
	 * @throws
	 */
	@RequestMapping(value = {"/get_open_service_detail"})
	public Result<?> getOpenServiceDetail(
			@RequestParam(value = "serviceId", required = true) int serviceId,
			@RequestParam(value = "openId", required = true) String openId,
			HttpServletRequest request
	) {
		logger.info("method ： getOpenServiceDetail,params:service={},openId={}",serviceId, openId);
		validator(serviceId < 0 || StringUtils.isBlank(openId), "参数有误");

		//判断模式是否是模板开发
		Boolean isTemplete = openServiceDetailService.isTemplete(serviceId);
		validator(!isTemplete,"该服务不是使用模板开发");

		request.getSession().setAttribute("openId", openId);
		request.getSession().setAttribute("serviceId", serviceId);

		/// open id to uid
		JSONObject data = fuPayService.getUidFromOpenId(openId, serviceId);
		if(data == null) {
			error("获取uid错误:" + openId);
		}else if(data.getInteger("code") != 1001) {
			error("获取uid错误:" + data.getString("msg"));
		}else{
			request.getSession().setAttribute("uid", data.getJSONObject("data").getLong("uid"));
		}
		OpenServiceDetail detail = openServiceDetailService.getByServiceId(serviceId);
		validator(detail == null, "尚未选择模板");
		return Result.successData(detail);
	}

	/**
	 * @author:fukangwen
	 * @Description: 获取client_ticket
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/client_ticket")
	public Result<?> getClientTicket(
			@RequestParam(value = "serviceId", required = true) int serviceId) {
		logger.info("client_ticket ： service={}",serviceId);
		String clientTicket = fuPayService.getClientTicket(serviceId);
		logger.info(clientTicket);
		return Result.successData(clientTicket);
	}

	/**
	 * @author:fukangwen
	 * @Description: 获取用户信息
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/get_user_info")
	public Result<?> getUserInfo(
			@RequestParam(value = "clientType", required = false, defaultValue="APP") String clientType,
			@RequestParam(value = "access_token", required = false) String accessToken){
		Long uid = validateAndGetUid(clientType, accessToken);
		UserInfo userinfo = userInfoMapper.selectByPrimaryKey(uid);
		validator(userinfo == null, "用户信息不存在!");
		JSONObject json = new JSONObject();
		json.put("phone", userinfo.getPhone());
		json.put("nick_name", userinfo.getNickname());
		json.put("avatar", userinfo.getPic());
		return Result.successData(json);
	}

	/**
	 * @author:fukangwen
	 * @Description: 获取社区信息
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/community_info")
	public Result<?> getCommunity(@RequestParam("community_id") int communityId) throws IllegalAccessException, InvocationTargetException{

		logger.info("查询信息，communityId:{}",communityId);

		Community community = communityMapper.selectByPrimaryKey(communityId);

		ExtCommunity extCommunity = new ExtCommunity();

		if(community == null){
			error("社区ID："+communityId+",对应的社区信息不存在");
		}else{
			if(community.getStatus() != 1){
				error("社区ID："+communityId+",对应的社区已被禁用");
			}

			extCommunity.setAddress(community.getAddress());
			extCommunity.setId(community.getId());
			extCommunity.setIntro(community.getIntro());
			extCommunity.setLogo_url(community.getLogoUrl());
			extCommunity.setName(community.getName());
			//查询区域名称
			Area area = areaBaseService.selectByPrimaryKey(community.getAreaId());
			if(area != null){
				extCommunity.setArea_name(area.getMergerName());
			}
		}
		logger.info("社区信息:{}",JSONObject.toJSONString(extCommunity));
		return Result.successData(extCommunity);
	}


	/**
	 * @author:fukangwen
	 * @Description: 获取店铺模板,顺便保存用户凭证openId到session
	 * @throws
	 */
	@RequestMapping(value = {"/getXFSJServiceDetail"})
	public Result<?> getXFSJServiceDetail(
			@RequestParam(value = "serviceId", required = true) int serviceId,
			@RequestParam(value = "communityId", required = false, defaultValue="0") int communityId,
			@RequestParam(value = "access_token", required = false, defaultValue="") String accessToken,
			HttpServletRequest request
	) {

		logger.info("method ： getXFSJServiceDetail,params:serviceId={}",serviceId);
		if(StringUtils.isNotBlank(accessToken)) {
			Long uid = getUidByToken(accessToken);
			if (uid == null) {
				error("用户未登录");
			}
			request.getSession().setAttribute("uid", uid);
		}

		validator(serviceId < 0 , "参数有误");
		//判断模式是否是模板开发
		Boolean isTemplete = openServiceDetailService.isTemplete(serviceId);
		validator(!isTemplete,"该服务不是使用模板开发");

		logger.info("getXFSJServiceDetail: serviceId={}", serviceId);
		request.getSession().setAttribute("serviceId", serviceId);
		OpenServiceDetail detail = openServiceDetailService.getByServiceId(serviceId);
		validator(detail == null, "尚未选择模板");

		//最后一次进入(banner位进入的使用-1)
		openUserServiceService.insertOrUpdate(-1, getUidId(), communityId);

		return Result.successData(detail);
	}
}
