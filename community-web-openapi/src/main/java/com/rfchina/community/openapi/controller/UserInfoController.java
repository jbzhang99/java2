package com.rfchina.community.openapi.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.rfchina.api.response.ResponseData;
import com.rfchina.api.response.model.user.GetUserInfoWithOpenIdResponseModel;
import com.rfchina.community.base.Constant;
import com.rfchina.community.openapi.base.Result;
import com.rfchina.community.openapi.service.CommunityServiceInfoService;
import com.rfchina.community.openapi.service.FuPayService;
import com.rfchina.community.persistence.mapper.UserInfoMapper;
import com.rfchina.community.persistence.model.CommunityServiceTemp;
import com.rfchina.community.persistence.model.UserInfo;

@RestController
@RequestMapping(value = Constant.ROOT_PATH_OPEN)
public class UserInfoController extends BaseController {

	@Autowired
	private FuPayService fuPayService;
	@Autowired
	private UserInfoMapper userInfoMapper;

	@Autowired
	private CommunityServiceInfoService communityServiceInfoService;

	@Value("${rfpay.appId}")
	private Long rfpayAppId;

	@Value("${rfpay.appSecret}")
	private String rfpayAppSecret;

	private static transient Logger logger = LoggerFactory.getLogger(UserInfoController.class);

	@RequestMapping("/get_user_info")
	public Result<?> getUserInfo(

			@RequestParam(value = "__app_id") long appId, @RequestParam(value = "rf_open_id") String rfOpenId)
			throws Exception {
		// ValidatorUtil.verify(accessToken, "access_token");
		logger.info(" appId:{},rfOpenId:{}", appId, rfOpenId);
		validator(StringUtils.isBlank(rfOpenId),"rf_open_id 不能为空");
		// 服务是否为正式服务
		CommunityServiceTemp ser = communityServiceInfoService.getCommunityServiceTemp(appId);
		// 查询服务商信息
		communityServiceInfoService.getOpenMerchantInfo(ser.getMerchantId(), appId);
		Long uid = 0L;
		/// open id to uid
		ResponseData<GetUserInfoWithOpenIdResponseModel> data1 = fuPayService.getUserInfoWithOpenIdRequest(rfpayAppId,
				rfpayAppSecret, appId, rfOpenId);
		if (data1 != null && data1.getCode() == 1001) {
			uid = data1.getData().getUid();
		} else {
			error("错误:" + data1.getCode() + "_" + data1.getMsg());
		}

		UserInfo userinfo = userInfoMapper.selectByPrimaryKey(uid);
		validator(userinfo == null, "用户信息不存在!");
		JSONObject json = new JSONObject();
		json.put("phone", userinfo.getPhone());
		json.put("nick_name", userinfo.getNickname());
		json.put("avatar", userinfo.getPic());
		return Result.successData(json);
	}

}
