package com.rfchina.community.openweb.service;

import com.alibaba.fastjson.JSON;
import com.rfchina.api.ApiClient;
import com.rfchina.api.request.app.*;
import com.rfchina.api.request.pay.*;
import com.rfchina.api.request.pay.FuPaySplitBillRequest.SplitDataModel;
import com.rfchina.api.request.pay.FuPayUploadSettleDataRequest.SettleData;
import com.rfchina.api.response.ResponseData;
import com.rfchina.api.response.model.app.*;
import com.rfchina.api.response.model.pay.*;
import com.rfchina.community.base.exception.WorkRunTimeException;
import com.rfchina.community.openweb.util.PlatformUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatformService {
	public void error(String msg) {
		throw new WorkRunTimeException(msg);
	}

	@Value("${platform.host}")
	private String host;

	@Value("${platform.admin.appId}")
	private String platformAdminAppId;

	@Value("${platform.admin.appSecret}")
	private String platformAdminAppSecret;
	@Autowired
	private HttpClientPlugin httpClientPlugin;

	private static transient Logger logger = LoggerFactory.getLogger(PlatformService.class);

	/**
	 * 创建应用
	 */
	public CreateAppResponseModel createApp(String name, int appType, String tokenType, String sessionType,
			String description, int expireTime, int status, int mode, String waterMarkIcon, String hdIcon,
			String callbackUrl, String domain, int catalogId, int online) {
		String accessToken = PlatformUtil.getAccessToken(host, Long.parseLong(platformAdminAppId),
				platformAdminAppSecret);
		CreateAppRequest request = new CreateAppRequest(accessToken, name, appType, tokenType, sessionType, description,
				expireTime, status, mode, waterMarkIcon, hdIcon, callbackUrl, domain, catalogId, online);
		ApiClient apiClient = new ApiClient(host, Long.parseLong(platformAdminAppId), platformAdminAppSecret);
		ResponseData<CreateAppResponseModel> responseData = apiClient.execute(request);
		if (responseData.getCode() == 1001) {
			return responseData.getData();
		} else {
			logger.error(
					"调用平台接口创建应用失败，原因为：name:{}, appType:{}, tokenType:{}, sessionType:{}, description:{}, expireTime:{}, status:{},"
							+ "mode:{}, waterMarkIcon:{}, hdIcon:{}, callbackUrl:{}, domain:{}, catalogId:{}, online:{},{}",
					name, appType, tokenType, sessionType, description, expireTime, status, mode, waterMarkIcon, hdIcon,
					callbackUrl, domain, catalogId, online, JSON.toJSONString(responseData));
		}
		return null;
	}

	public GetServiceListResponseModel getInterfaceList(String serviceIds, String title, int status) {
		String accessToken = PlatformUtil.getAccessToken(host, Long.parseLong(platformAdminAppId),
				platformAdminAppSecret);
		GetServiceListRequest request = new GetServiceListRequest(accessToken, serviceIds, title, status);
		ApiClient apiClient = new ApiClient(host, Long.parseLong(platformAdminAppId), platformAdminAppSecret);
		ResponseData<GetServiceListResponseModel> responseData = apiClient.execute(request);
		if (responseData.getCode() == 1001) {
			return responseData.getData();
		} else {
			logger.error("调用平台接口获取服务列表失败，原因为：" + JSON.toJSONString(responseData));
		}
		return null;
	}

	public GetApiListResponseModel getApiList(String apiIds, int serviceId, String title, int status, int limit,
			int offset, boolean stat) {
		String accessToken = PlatformUtil.getAccessToken(host, Long.parseLong(platformAdminAppId),
				platformAdminAppSecret);
		GetApiListRequest request = new GetApiListRequest(accessToken, apiIds, serviceId, title, status, limit, offset,
				stat);
		ApiClient apiClient = new ApiClient(host, Long.parseLong(platformAdminAppId), platformAdminAppSecret);
		ResponseData<GetApiListResponseModel> responseData = apiClient.execute(request);
		logger.info(
				"getApiList host:{},accessToken：{}, apiIds：{}, serviceId：{}, title：{}, status：{}, limit：{}, offset：{},stat：{} data:{}",
				host, accessToken, apiIds, serviceId, title, status, limit, offset, stat,
				JSON.toJSONString(responseData));
		if (responseData.getCode() == 1001) {
			return responseData.getData();
		} else {
			logger.error("获取服务API列表出错，原因为：" + JSON.toJSONString(responseData));
		}
		return null;
	}

	public boolean applyPayService(long appId, String notifyUrl, String balanceReceiveEmail, int levelId) {
		String accessToken = PlatformUtil.getAccessToken(host, Long.parseLong(platformAdminAppId),
				platformAdminAppSecret);
		ApplyPayServiceRequest request = new ApplyPayServiceRequest(accessToken, appId, notifyUrl, balanceReceiveEmail,
				levelId);
		ApiClient apiClient = new ApiClient(host, Long.parseLong(platformAdminAppId), platformAdminAppSecret);
		ResponseData responseData = apiClient.execute(request);
		if (responseData.getCode() == 1001) {
			return true;
		} else {
			logger.error("开通支付服务失败，原因为：" + JSON.toJSONString(responseData));
			error("开通支付服务失败，原因为：" + JSON.toJSONString(responseData));
		}
		return false;
	}

	public GetServiceApplyProgressResponseModel getServiceApplyProgressRequest(long appId, int serviceId) {
		String accessToken = PlatformUtil.getAccessToken(host, Long.parseLong(platformAdminAppId),
				platformAdminAppSecret);
		GetServiceApplyProgressRequest request = new GetServiceApplyProgressRequest(accessToken, appId, serviceId);
		ApiClient apiClient = new ApiClient(host, Long.parseLong(platformAdminAppId), platformAdminAppSecret);
		ResponseData<GetServiceApplyProgressResponseModel> responseData = apiClient.execute(request);
		if (responseData.getCode() == 1001) {
			return responseData.getData();
		} else {
			logger.error("查询服务开通申请审核进度:" + JSON.toJSONString(responseData));
			// error("查询服务开通申请审核进度:" + JSON.toJSONString(responseData));
		}
		return null;
	}

	public boolean applyService(long appId, int interfaceId, int levelId) {
		String accessToken = PlatformUtil.getAccessToken(host, Long.parseLong(platformAdminAppId),
				platformAdminAppSecret);
		ApplyServiceRequest request = new ApplyServiceRequest(accessToken, appId, interfaceId, levelId);
		ApiClient apiClient = new ApiClient(host, Long.parseLong(platformAdminAppId), platformAdminAppSecret);
		ResponseData responseData = apiClient.execute(request);
		if (responseData.getCode() == 1001) {
			return true;
		} else {
			logger.error("开通服务失败，原因为：" + JSON.toJSONString(responseData));
		}
		return false;
	}

	public boolean auditService(long appId, int serviceId, int status, String auditComment) {
		String accessToken = PlatformUtil.getAccessToken(host, Long.parseLong(platformAdminAppId),
				platformAdminAppSecret);
		AuditServiceRequest request = new AuditServiceRequest(accessToken, appId, serviceId, status, auditComment);
		ApiClient apiClient = new ApiClient(host, Long.parseLong(platformAdminAppId), platformAdminAppSecret);
		ResponseData responseData = apiClient.execute(request);
		if (responseData.getCode() == 1001) {
			return true;
		} else {
			logger.error("auditService appId:{} ,  serviceId :{},  status:{} ,  auditComment, :{},responseData:{}",
					appId, serviceId, status, auditComment, JSON.toJSONString(responseData));
			error("auditService:" + JSON.toJSONString(responseData));
		}
		return false;
	}

	// public void sendSms(String mobiles, String content) {
	//
	// String accessToken = PlatformUtil.getAccessToken(host,
	// Long.parseLong(platformAdminAppId),
	// platformAdminAppSecret);
	// SendSmsRequest request = new SendSmsRequest(accessToken, mobiles,
	// content);
	// ApiClient apiClient = new ApiClient(host,
	// Long.parseLong(platformAdminAppId), platformAdminAppSecret);
	// ResponseData responseData = apiClient.execute(request);
	// logger.info(
	// "sendSms host:{}, platformAdminAppId:{},
	// platformAdminAppSecret:{},mobiles:{},
	// content:{},accessToken:{},ResponseData:{} ",
	// host, Long.parseLong(platformAdminAppId), platformAdminAppSecret,
	// mobiles, content, accessToken,
	// JSON.toJSONString(responseData));
	// }

	public FuPaySplitBillResponseModel splitBill(String billId, List<SplitDataModel> splitDataList) {
		String accessToken = PlatformUtil.getAccessToken(host, Long.parseLong(platformAdminAppId),
				platformAdminAppSecret);
		FuPaySplitBillRequest request = new FuPaySplitBillRequest(accessToken, billId, splitDataList);
		ApiClient apiClient = new ApiClient(host, Long.parseLong(platformAdminAppId), platformAdminAppSecret);
		ResponseData<FuPaySplitBillResponseModel> responseData = apiClient.execute(request);

		if (responseData.getCode() == 1001) {
			return responseData.getData();
		} else {
			logger.error("调用支付中心拆单接口出错，原因为" + JSON.toJSONString(responseData));
		}

		return null;
	}

	public ResponseData<FuPayGetBillDetailResponseModel> getBillDetail(String billId) {
		String accessToken = PlatformUtil.getAccessToken(host, Long.parseLong(platformAdminAppId),
				platformAdminAppSecret);
		FuPayGetBillDetailRequest request = new FuPayGetBillDetailRequest(accessToken, billId);
		ApiClient apiClient = new ApiClient(host, Long.parseLong(platformAdminAppId), platformAdminAppSecret);
		ResponseData<FuPayGetBillDetailResponseModel> responseData = apiClient.execute(request);

		// if (responseData.getCode() == 1001) {
		// return responseData.getData();
		// } else {
		// logger.error("获取订单详情出错，原因为" + JSON.toJSONString(responseData));
		// }

		return responseData;
	}

	public FuPayUploadSettleDataResponseModel uploadSettleData(String mchId, String title,
			List<SettleData> settleData) {
		String accessToken = PlatformUtil.getAccessToken(host, Long.parseLong(platformAdminAppId),
				platformAdminAppSecret);
		FuPayUploadSettleDataRequest request = new FuPayUploadSettleDataRequest(accessToken, mchId, title, settleData);
		ApiClient apiClient = new ApiClient(host, Long.parseLong(platformAdminAppId), platformAdminAppSecret);
		ResponseData<FuPayUploadSettleDataResponseModel> responseData = apiClient.execute(request);

		if (responseData.getCode() == 1001) {
			return responseData.getData();
		} else {
			logger.error("上传业务结算数据出错，原因为" + JSON.toJSONString(responseData));
		}

		return null;
	}

	public ResetAppSecretResponseModel resetAppSecret(long appId) {
		String accessToken = PlatformUtil.getAccessToken(host, Long.parseLong(platformAdminAppId),
				platformAdminAppSecret);
		ResetAppSecretRequest request = new ResetAppSecretRequest(accessToken, appId);
		ApiClient apiClient = new ApiClient(host, Long.parseLong(platformAdminAppId), platformAdminAppSecret);
		ResponseData<ResetAppSecretResponseModel> responseData = apiClient.execute(request);

		if (responseData.getCode() == 1001) {
			return responseData.getData();
		} else {
			logger.error("重置appSecret出错，原因为" + JSON.toJSONString(responseData));
		}

		return null;
	}

	public FuPayGetSettlementApplyDetailResponseModel getSettlementApplyDetail(String sid) {
		String accessToken = PlatformUtil.getAccessToken(host, Long.parseLong(platformAdminAppId),
				platformAdminAppSecret);
		FuPayGetSettlementApplyDetailRequest request = new FuPayGetSettlementApplyDetailRequest(accessToken, sid);
		ApiClient apiClient = new ApiClient(host, Long.parseLong(platformAdminAppId), platformAdminAppSecret);
		ResponseData<FuPayGetSettlementApplyDetailResponseModel> responseData = apiClient.execute(request);

		if (responseData.getCode() == 1001) {
			return responseData.getData();
		} else {
			logger.error("获取结算单详情出错" + JSON.toJSONString(responseData));
		}

		return null;
	}

	public ResponseData<FuPayGetAccountResponseModel> getAccount(String accountId) {
		String accessToken = PlatformUtil.getAccessToken(host, Long.parseLong(platformAdminAppId),
				platformAdminAppSecret);
		FuPayUGetAccountRequest request = new FuPayUGetAccountRequest(accessToken, accountId);
		ApiClient apiClient = new ApiClient(host, Long.parseLong(platformAdminAppId), platformAdminAppSecret);
		ResponseData<FuPayGetAccountResponseModel> responseData = apiClient.execute(request);

		logger.info("获取付款账号信息 ，原因为  accountId:{},{}", accountId, JSON.toJSONString(responseData));

		return responseData;
	}

	public ResponseData<FuPayAddAccountResponseModel> createAccount(String mchId, String desc) {
		String accessToken = PlatformUtil.getAccessToken(host, Long.parseLong(platformAdminAppId),
				platformAdminAppSecret);
		ApiClient apiClient = new ApiClient(host, Long.parseLong(platformAdminAppId), platformAdminAppSecret);
		FuPayMAddAccountRequest request = new FuPayMAddAccountRequest(accessToken, mchId, desc);
		ResponseData<FuPayAddAccountResponseModel> responseData = apiClient.execute(request);

		logger.info("createAccount mchId:{},desc:{},createAccount:{}", mchId, desc, JSON.toJSONString(responseData));
		if (responseData.getCode() != 1001) {
			logger.error("createAccount mchId:{},desc:{},createAccount:{}", mchId, desc,
					JSON.toJSONString(responseData));
		}
		return responseData;
	}


}
