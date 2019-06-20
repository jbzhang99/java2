package com.rfchina.community.openapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.api.response.ResponseData;
import com.rfchina.api.response.model.oauth2.Oauth2ClientTicketResponseModel;
import com.rfchina.api.response.model.user.GetUserInfoWithOpenIdResponseModel;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.openapi.base.Result;
import com.rfchina.community.openapi.service.FuPayService;
import com.rfchina.community.openapi.service.PlatformService;
import com.rfchina.community.persistence.mapper.CommunityServiceMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceTempMapper;
import com.rfchina.community.persistence.mapper.OpenServiceDetailMapper;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.OpenServiceDetail;

//商城api
@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_OPEN_STORE)
public class StoreApiController extends BaseController {

	@Autowired
	private FuPayService fuPayService;

	@Autowired
	private CommunityServiceMapper communityServiceMapper;
	@Autowired
	private OpenServiceDetailMapper openServiceDetailMapper;
	@Autowired
	private CommunityServiceTempMapper communityServiceTempMapper;

	@Autowired
	private PlatformService platformService;

	@Value("${rfpay.appId}")
	private Long rfpayAppId;

	@Value("${rfpay.appSecret}")
	private String rfpayAppSecret;
	@Value("${debug.communityId}")
	private int debugCommunityId;

	@Value("${debug.masterInfoId}")
	private long debugMasterInfoId;

	private static transient Logger logger = LoggerFactory.getLogger(StoreApiController.class);

	/**
	 * 
	 * 
	 * 
	 * @param id
	 * @param open_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/openid_to_uid")
	public Result<?> openidToUid(@RequestParam(value = "service_id") int id,
			@RequestParam(value = "open_id") String open_id) throws Exception {

		OpenServiceDetail detail = openServiceDetailMapper.selectByPrimaryKey(id);
		validator(detail == null, "空数据" + id);

		if (detail.getRfchinaCode() != 1) {
			validator(detail.getTempleteStatus() != 1, "没有模板没有启动" + id);
			validator(!OpenConstant.open_service_detail.develop_type.TEMPLETE.name().equals(detail.getDevelopType()),
					"该服务不是模板服务" + id);
		}
		CommunityService cst = communityServiceMapper.selectByPrimaryKey(id);
		Long appid = cst.getAppId();
		String secret = cst.getAppSecret();
		/// open id to uid
		ResponseData<GetUserInfoWithOpenIdResponseModel> data1 = fuPayService.getUserInfoWithOpenIdRequest(appid,
				secret, appid, open_id);
		return Result.successData(data1);
		// {
		// "code": 200,
		// "msg": "OK",
		// "data": {
		// "code": 1001,
		// "msg": "成功",
		// "data": {
		// "openId": "fu_74427b4929ec0dc95ffa7476607c5c55",
		// "uid": 32636,
		// "appId": 70287289
		// }
		// }
		// }
	}

	@RequestMapping("/create_client_ticket")
	public Result<?> createClientTicket(@RequestParam(value = "service_id") int id) throws Exception {
		OpenServiceDetail detail = openServiceDetailMapper.selectByPrimaryKey(id);
		validator(detail == null, "空数据" + id);
		if (detail.getRfchinaCode() != 1) {
			validator(detail.getTempleteStatus() != 1, "没有模板没有启动" + id);
			validator(!OpenConstant.open_service_detail.develop_type.TEMPLETE.name().equals(detail.getDevelopType()),
					"该服务不是模板服务" + id);
		}
		CommunityService cst = communityServiceMapper.selectByPrimaryKey(id);
		Long appid = cst.getAppId();
		String secret = cst.getAppSecret();
		//
		String accessToken = fuPayService.getAccessToken(appid, secret);
		ResponseData<Oauth2ClientTicketResponseModel> client = fuPayService.getClientTicket(accessToken, appid, secret);
		return Result.successData(client);

		// {
		// "code": 200,
		// "msg": "OK",
		// "data": {
		// "code": 1001,
		// "msg": "成功",
		// "data": {
		// "clientTicket":
		// "E26D92209E6AF470443BAA7F29BDCA5683753FA4E3EED112599285B0CA0AA91C3E0BFC5475BB2C0BFD07BD70481DE804CAC08D644EE87211BA3692D4279A0E31",
		// "expireTime": "1506691743453"
		// }
		// }
		// }
	}

}
