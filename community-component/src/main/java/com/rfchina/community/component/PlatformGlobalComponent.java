
package com.rfchina.community.component;

import com.alibaba.fastjson.JSON;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.rfchina.api.ApiClient;
import com.rfchina.api.ApiRequest;
import com.rfchina.api.request.app.*;
import com.rfchina.api.request.express.GetAuthorizeUrlRequest;
import com.rfchina.api.request.express.QueryCommCodeByNumberRequest;
import com.rfchina.api.request.express.QueryExpressCompanyListRequest;
import com.rfchina.api.request.express.QueryExpressProgresRequest;
import com.rfchina.api.request.mch.*;
import com.rfchina.api.request.pay.*;
import com.rfchina.api.request.pay.FuPayCreateRequest.GoodsDetail;
import com.rfchina.api.request.pay.FuPayRefundApplyV2Request.AuditData;
import com.rfchina.api.request.pay.FuPayRefundApplyV2Request.RefundItem;
import com.rfchina.api.request.pay.FuPaySplitBillRequest.SplitDataModel;
import com.rfchina.api.request.settle.SettlebApplyRequest;
import com.rfchina.api.request.sms.SendSmsRequest;
import com.rfchina.api.request.user.VerifyUserTokenRequest;
import com.rfchina.api.response.ResponseData;
import com.rfchina.api.response.model.app.CreateAppResponseModel;
import com.rfchina.api.response.model.app.GetAccessTokenReponseModel;
import com.rfchina.api.response.model.app.GetApiListResponseModel;
import com.rfchina.api.response.model.app.GetServiceListResponseModel;
import com.rfchina.api.response.model.express.*;
import com.rfchina.api.response.model.mch.MchResponseModel;
import com.rfchina.api.response.model.mch.SSOApplyAuthResponseModel;
import com.rfchina.api.response.model.mch.SettleAccountResponseModel;
import com.rfchina.api.response.model.mch.SyncLoginResponseModel;
import com.rfchina.api.response.model.pay.*;
import com.rfchina.api.response.model.pay.base.FuPayAccountModel;
import com.rfchina.api.response.model.pay.base.FuPayBillModel2;
import com.rfchina.api.response.model.pay.base.FuPayRefundBillsModel;
import com.rfchina.api.response.model.user.VerifyUserTokenResponseModel;
import com.rfchina.community.base.OpenRefundConstant;
import com.rfchina.community.base.exception.WorkRunTimeException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 慢慢统一起到这里
 */
@Component
public class PlatformGlobalComponent {
	public void error(String msg) {
		throw new WorkRunTimeException(msg);
	}

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Value("${platform.host:default}")
	private String host;
	@Value("${platform.appId:0}")
	private Long appId;
	@Value("${platform.appSecret:default}")
	private String appSecret;

	@Value("${platform.manage.appId:0}")
	private Long manageAppId;
	@Value("${platform.manage.appSecret:default}")
	private String manageAppSecret;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getManageAppSecret() {
		return manageAppSecret;
	}

	public void setManageAppSecret(String manageAppSecret) {
		this.manageAppSecret = manageAppSecret;
	}

	public Logger getLogger() {
		return logger;
	}

	public Long getManageAppId() {
		return manageAppId;
	}

	public void setManageAppId(Long manageAppId) {
		this.manageAppId = manageAppId;
	}

	// platform.host=http://test.p.rfmember.net
	// platform.appId=347285
	// platform.appSecret=1361cb7bc29d11e68ce800163e02580e
	// platform.manage.appId=99831765
	// platform.manage.appSecret=280d01d54adfb4da142b055fef91535d

	private Cache<String, String> accessTokenLocalCache = CacheBuilder.newBuilder()
			.expireAfterWrite(50, TimeUnit.MINUTES).build();

	public String getAccessToken() {
		return getAccessToken(host, appId, appSecret);

	}

	public String getAccessTokenManage() {
		return getAccessToken(host, manageAppId, manageAppSecret);
	}

	private <T> ResponseData<T> executeManager(ApiRequest req) {
		ApiClient apiClient = new ApiClient(host, manageAppId, manageAppSecret);
		return apiClient.execute(req);
	}

	private <T> ResponseData<T> execute(ApiRequest req) {
		ApiClient apiClient = new ApiClient(host, appId, appSecret);
		return apiClient.execute(req);
	}

	// 获取平台的accessToken
	public String getAccessToken(String host, Long appid, String appSecret) {
		// 从缓存里面获取accessToken
		String key = appid + "_" + appSecret;
		String accessToken = accessTokenLocalCache.getIfPresent(key);

		// 如果缓存里面为空，则从平台重新获取accessToken
		if (StringUtils.isBlank(accessToken)) {
			accessToken = getRemoteAccessToken(host, appid, appSecret);
			if (accessToken != null)
				accessTokenLocalCache.put(key, accessToken);
		}
		return accessToken;
	}

	protected String getRemoteAccessToken(String host, Long appId, String appSecret) {
		GetAccessTokenRequest request = new GetAccessTokenRequest(appId, appSecret);
		ApiClient apiClient = new ApiClient(host, appId, appSecret);
		ResponseData<GetAccessTokenReponseModel> responseData = apiClient.execute(request);
		logger.info("Invoke [getRemoteAccessToken] with parameters: {}, {}, and response: {}", appId, appSecret,
				JSON.toJSONString(responseData));
		GetAccessTokenReponseModel model = responseData.getData();
		return null != model ? model.getAccessToken() : null;
	}

	public ResponseData<VerifyUserTokenResponseModel> verifyUserToken(String accessToken) {
		VerifyUserTokenRequest request = new VerifyUserTokenRequest(accessToken);
		return execute(request);
	}

	public int sendSms(String mobiles, String content) {
		String accessToken = getAccessToken();
		SendSmsRequest request = new SendSmsRequest(accessToken, mobiles, content);
		ResponseData responseData = execute(request);
		if (responseData.getCode() != 1001) {
			logger.error("sendSms mobiles error:{} content:{} responseData:{}", mobiles, content,
					JSON.toJSONString(responseData));
		}
		logger.info("sendSms mobiles:{} content:{} responseData:{}", mobiles, content, JSON.toJSONString(responseData));
		return responseData.getCode();
	}

	public GetServiceListResponseModel getServiceListRequest(String serviceIds, String title, Integer status) {
		String accessToken = getAccessTokenManage();
		GetServiceListRequest req = new GetServiceListRequest(accessToken, serviceIds, title, status);
		ResponseData<?> aa = executeManager(req);
		if (aa.getCode() == 1001) {
			return (GetServiceListResponseModel) aa.getData();
		}
		return null;
	}

	public ResponseData<?> createServiceRequest(Integer serviceId, String title, String desc) {
		String accessToken = getAccessTokenManage();

		CreateServiceRequest req = new CreateServiceRequest(accessToken, serviceId, title, desc);
		ResponseData<?> aa = executeManager(req);
		return aa;
	}

	public ResponseData<?> editServiceRequest(int serviceId, String title, String desc, Integer status) {
		String accessToken = getAccessTokenManage();
		// 1:启用, 2: 禁用
		EditServiceRequest req = new EditServiceRequest(accessToken, serviceId, title, desc, status);
		ResponseData<?> aa = executeManager(req);
		return aa;
	}

	public GetApiListResponseModel getApiListRequest(String apiIds, Integer serviceId, String title, Integer status,
			int limit, int offset, Boolean stat) {
		String accessToken = getAccessTokenManage();
		GetApiListRequest req = new GetApiListRequest(accessToken, apiIds, serviceId, title, status, limit, offset,
				stat);
		ResponseData<?> aa = executeManager(req);
		if (aa.getCode() == 1001) {
			return (GetApiListResponseModel) aa.getData();
		}
		return null;
	}

	public ResponseData<?> createApiRequest(Integer apiId, int serviceId, String url, String title, String remark,
			int sort, String targetUrl, Integer defaultQuota) {
		logger.info("createApiRequest apiId:{}, serviceId:{}, url:{}, title:{}, remark:{}, sort:{}, targetUrl:{}",
				apiId, serviceId, url, title, remark, sort, targetUrl);
		String accessToken = getAccessTokenManage();
		CreateApiRequest req = new CreateApiRequest(accessToken, apiId, serviceId, url, title, remark, sort, targetUrl,
				defaultQuota);
		ResponseData<?> aa = executeManager(req);
		return aa;
	}

	public ResponseData<?> editApiRequest(Integer apiId, int serviceId, String url, String title, String remark,
			int sort, String targetUrl, Integer status) {
		logger.info(
				"createApiRequest apiId:{}, serviceId:{}, url:{}, title:{}, remark:{}, sort:{}, targetUrl:{},status:{}",
				apiId, serviceId, url, title, remark, sort, targetUrl, status);
		String accessToken = getAccessTokenManage();

		EditApiRequest req = new EditApiRequest(accessToken, apiId, serviceId, url, title, remark, sort, status,
				targetUrl);
		ResponseData<?> aa = executeManager(req);
		return aa;
	}

	// app有的服务权限
	public ResponseData<?> getAppServiceListRequest(Long appId, String status) {
		String accessToken = getAccessTokenManage();

		GetAppServiceListRequest req = new GetAppServiceListRequest(accessToken, appId, status);
		ResponseData<?> aa = executeManager(req);
		return aa;
	}

	// 获取结算明细列表
	// "/v1/pay/settle/data_list";
	public ResponseData<FuPayGetSettlementApplyDataListResponseModel> fuPayGetSettlementApplyDataListRequest(String sid,
			int limit, long offset, Boolean stat) {
		String accessToken = getAccessToken();

		FuPayGetSettlementApplyDataListRequest req = new FuPayGetSettlementApplyDataListRequest(accessToken, sid, limit,
				offset, stat);
		ResponseData<FuPayGetSettlementApplyDataListResponseModel> aa = execute(req);
		logger.info(
				"fuPayGetSettlementApplyDataListRequest host:{}, appId:{}, sid:{}, limit:{}, offset:{}, stat:{},json:{}",
				host, appId, sid, limit, offset, stat, JSON.toJSONString(aa));
		return aa;
	}

	public ResponseData<FuPayGetSettlementApplyDetailResponseModel> getSettlementApplyDetail(String sid) {
		String accessToken = getAccessToken();
		FuPayGetSettlementApplyDetailRequest request = new FuPayGetSettlementApplyDetailRequest(accessToken, sid);

		ResponseData<FuPayGetSettlementApplyDetailResponseModel> responseData = execute(request);

		logger.info("getSettlementApplyDetail278sid:{},json:{}", sid, JSON.toJSONString(responseData));

		return responseData;
	}

	/**
	 * 查询结算账号的信息
	 * 
	 * @param billId
	 * @return
	 */
	public ResponseData<FuPayGetBillDetailResponseModel> getBillDetail(String billId) {
		String accessToken = getAccessToken();
		FuPayGetBillDetailRequest request = new FuPayGetBillDetailRequest(accessToken, billId);

		ResponseData<FuPayGetBillDetailResponseModel> responseData = execute(request);
		return responseData;
	}

	public ResponseData<FuPayGetBillDetailResponseModel2> getBillDetail2(String billId) {
		String accessToken = getAccessToken();
		FuPayGetBillDetailRequest2 request = new FuPayGetBillDetailRequest2(accessToken, billId);
		ResponseData<FuPayGetBillDetailResponseModel2> responseData = execute(request);
		return responseData;
	}

	// 退款单详情是另外一个接口啊
	public ResponseData<FuPayBillModel2> getRefundBillDetail(String refundBillId) {
		String accessToken = getAccessToken();
		FuPayGetRefundBillDetailRequest request = new FuPayGetRefundBillDetailRequest(accessToken, refundBillId);
		ResponseData<FuPayBillModel2> responseData = execute(request);
		return responseData;
	}

	// /v1/pay/refund/apply_detail
	// 退款明细查询
	public ResponseData<FuPayGetRefundApplyDetailResponseModel> getRefundDetail(String refundId) {
		String accessToken = getAccessToken();
		FuPayGetRefundApplyDetailRequest request = new FuPayGetRefundApplyDetailRequest(accessToken, refundId);

		ResponseData<FuPayGetRefundApplyDetailResponseModel> responseData = execute(request);
		return responseData;
	}

	// 撤消退款
	public ResponseData<?> refundRevoke(String refundId) {
		String accessToken = getAccessToken();
		FuPayRefundRevokeRequest request = new FuPayRefundRevokeRequest(accessToken, refundId);

		ResponseData<?> responseData = execute(request);
		return responseData;
	}

	// 退款申请
	public ResponseData<FuPayRefundApplyResponseModel> refundApply(String title, String accountId,
			List<AuditData> auditData, List<RefundItem> refundItem, String refundReason, Integer refundWay) {
		String accessToken = getAccessToken();
		FuPayRefundApplyV2Request request = new FuPayRefundApplyV2Request(accessToken, title, accountId, auditData,
				refundItem, refundReason, refundWay);
		ResponseData<FuPayRefundApplyResponseModel> responseData = execute(request);
		//非原路的不打印，图片太大
		if(refundWay != OpenRefundConstant.SameWayStatus.no_original) {
			logger.info("refundApply accountId:{},refundItem:{},{}", accountId, JSON.toJSONString(refundItem),
					JSON.toJSONString(responseData));
		}
		return responseData;
	}

	// 查询退款单据回调信息
	public ResponseData<FuPayRefundBillsModel> refundBillCallbackList(String refundId) {
		String accessToken = getAccessToken();
		FuPayGetRefundBillCallbackListRequest request = new FuPayGetRefundBillCallbackListRequest(accessToken,
				refundId);
		ResponseData<FuPayRefundBillsModel> responseData = execute(request);
		logger.info("refundBillCallbackList_refundId:{},{},accessToken:{}", refundId, JSON.toJSONString(responseData),accessToken);
		return responseData;
	}

	// 获取付款账号信息
	public ResponseData<FuPayGetAccountResponseModel> getAccount(String accountId) {
		String accessToken = getAccessToken();
		FuPayUGetAccountRequest request = new FuPayUGetAccountRequest(accessToken, accountId);

		ResponseData<FuPayGetAccountResponseModel> responseData = execute(request);
		logger.info("getAccount accountId:{},{}", accountId, JSON.toJSONString(responseData));
		return responseData;
	}

	// 业务结算
	public ResponseData<Map<String, Object>> settlementApply(String mchId, String title, String accountId,
			String startDate, String endDate) {
		String accessToken = getAccessToken();
		SettlebApplyRequest request = new SettlebApplyRequest(accessToken, mchId, accountId,
				startDate, endDate);
		ResponseData<Map<String, Object>> responseData = execute(request);
		logger.info("settlementApply  mchId:{}, accountId:{}, startDate:{}, endDate:{},data:{},accessToken:{}",mchId,
				accountId, startDate, endDate, accessToken, JSON.toJSONString(responseData));
		return responseData;
	}

	// 拆单
	public ResponseData<FuPaySplitBillResponseModel> splitBill(String billId, List<SplitDataModel> splitDataList) {
		String accessToken = getAccessToken();
		FuPaySplitBillRequest request = new FuPaySplitBillRequest(accessToken, billId, splitDataList);
		ResponseData<FuPaySplitBillResponseModel> responseData = execute(request);
		if (responseData.getCode() != 1001) {
			logger.error("PlatformGlobalComponent.splitBill:357:{},splitDataList:{}:responseData{}", billId,
					JSON.toJSONString(splitDataList), JSON.toJSONString(responseData));
		} else {
			logger.info("PlatformGlobalComponent.splitBill:359:{},splitDataList:{}:responseData{}", billId,
					JSON.toJSONString(splitDataList), JSON.toJSONString(responseData));
		}
		return responseData;
	}

	// 拆单
	public ResponseData<FuPaySplitBillResponseModel2> splitBill2(String billId,
			List<FuPaySplitBillRequestV2.SplitDataModel> splitDataList) {
		String accessToken = getAccessToken();

		logger.info("splitBill2:1billId:{},splitDataList:{} ", billId, splitDataList.toString());
		for (FuPaySplitBillRequestV2.SplitDataModel splitDataModel : splitDataList) {
			logger.info("splitBill2: splitDataModel:{} ", splitDataModel.toString());
		}
		FuPaySplitBillRequestV2 request = new FuPaySplitBillRequestV2(accessToken, billId, splitDataList);
		ResponseData<FuPaySplitBillResponseModel2> responseData = execute(request);
		if (responseData.getCode() != 1001) {
			logger.error("splitBill2:2billId:{},splitDataList:{}:responseData{}", billId,
					JSON.toJSONString(splitDataList), JSON.toJSONString(responseData));
		} else {
			logger.info("splitBill2:3billId:{},splitDataList:{}:responseData:{}", billId,
					JSON.toJSONString(splitDataList), JSON.toJSONString(responseData));
		}
		return responseData;
	}

	public ResponseData auditService(long appId, int serviceId, int status, String auditComment) {
		// String accessToken = PlatformUtil.getAccessToken(host,
		// Long.parseLong(platformManageAppId),
		// platformManageAppSecret);
		String accessToken = getAccessTokenManage();
		AuditServiceRequest request = new AuditServiceRequest(accessToken, appId, serviceId, status, auditComment);
		// ApiClient apiClient = new ApiClient(host,
		// Long.parseLong(platformManageAppId), platformManageAppSecret);
		ResponseData responseData = executeManager(request);
		logger.info("auditService appId:{} ,  serviceId :{},  status:{} ,  auditComment, :{},responseData:{}", appId,
				serviceId, status, auditComment, JSON.toJSONString(responseData));
		return responseData;
	}

	public FuPayAccountModel createAccount(String mchId, String desc) {
		// String accessToken = PlatformUtil.getAccessToken(host,
		// Long.parseLong(platformManageAppId),
		// platformManageAppSecret);
		String accessToken = getAccessTokenManage();
		FuPayMAddAccountRequest request = new FuPayMAddAccountRequest(accessToken, mchId, desc);
		// ApiClient apiClient = new ApiClient(host,
		// Long.parseLong(platformManageAppId), platformManageAppSecret);
		ResponseData<FuPayAddAccountResponseModel> responseData = executeManager(request);

		logger.info("createAccount mchId:{},desc:{},createAccount:{}", mchId, desc, JSON.toJSONString(responseData));
		if (responseData.getCode() == 1001) {
			return responseData.getData();
		} else if (responseData.getCode() == 9062) {
			FuPayGetAccountListResponseModel list = fuPayMGetAccountListRequest(null, mchId, desc, true, 50, 0);
			for (FuPayAccountModel iterable_element : list.getList()) {
				return iterable_element;
			}
		} else {
			logger.error("创建支付中心账号出错，原因为：" + JSON.toJSONString(responseData));
			error("创建支付中心账号出错，原因为：" + JSON.toJSONString(responseData));
		}
		return null;
	}

	public FuPayGetAccountListResponseModel fuPayMGetAccountListRequest(String accountId, String mchId, String keyword,
			Boolean stat, int limit, int offset) {
		// String accessToken = PlatformUtil.getAccessToken(host,
		// Long.parseLong(platformManageAppId),
		// platformManageAppSecret);
		String accessToken = getAccessTokenManage();
		FuPayMGetAccountListRequest request = new FuPayMGetAccountListRequest(accessToken, accountId, mchId, keyword,
				stat, limit, offset);
		// ApiClient apiClient = new ApiClient(host,
		// Long.parseLong(platformManageAppId), platformManageAppSecret);
		ResponseData<FuPayGetAccountListResponseModel> responseData = executeManager(request);

		logger.info(
				"fuPayMGetAccountListRequest accessToken:{}, accountId:{}, mchId:{}, keyword:{},stat:{}, limit:{}, offset:{},{}",
				accessToken, accountId, mchId, keyword, stat, limit, offset, JSON.toJSONString(responseData));
		if (responseData.getCode() == 1001) {
			return responseData.getData();
		} else {
			logger.error("获取收款账号列表:" + JSON.toJSONString(responseData));
			error("获取收款账号列表:" + JSON.toJSONString(responseData));
		}
		return null;
	}

	public FuPayAddMchResponseModel addMchRequest(String contact, String title, String tel) {
		String accessToken = getAccessTokenManage();
		FuPayUAddMchRequest request = new FuPayUAddMchRequest(accessToken, contact, title, tel);
		// ApiClient apiClient = new ApiClient(host, Long.parseLong(platformAdminAppId),
		// platformAdminAppSecret);
		ResponseData<FuPayAddMchResponseModel> responseData = executeManager(request);
		logger.info("addMchRequest String contact:{}, String title:{}, String tel:{} ,addMchRequest:{}", contact, title,
				tel, JSON.toJSONString(responseData));
		if (responseData.getCode() == 1001) {
			return responseData.getData();
		} else if (responseData.getCode() == 9046) {
			error("商家已存在" + title + ":" + JSON.toJSONString(responseData));
		} else {
			logger.error("addMchRequest String contact:{}, String title:{}, String tel:{} ,addMchRequest:{}", contact,
					title, tel, JSON.toJSONString(responseData));
			error("addMchRequest:" + JSON.toJSONString(responseData));
		}
		return null;
	}

	public boolean editMchRequest(String mchId, String contact, String title, String tel, Integer status) {
		// String accessToken = PlatformUtil.getAccessToken(host,
		// Long.parseLong(platformAdminAppId),
		// platformAdminAppSecret);
		String accessToken = getAccessTokenManage();
		FuPayUEditMchRequest request = new FuPayUEditMchRequest(accessToken, mchId, contact, title, tel, status);
		// ApiClient apiClient = new ApiClient(host, Long.parseLong(platformAdminAppId),
		// platformAdminAppSecret);
		ResponseData<FuPayAddMchAccountResponseModel> responseData = executeManager(request);
		logger.info(
				"editMchRequest mchId:{},  contact:{},  title:{},  tel:{},  status:{}, editMchRequest:{},accessToken:{}",
				mchId, contact, title, tel, status, JSON.toJSONString(responseData), accessToken);
		if (responseData.getCode() == 1001) {
			return true;
		} else {
			logger.error("editMchRequest mchId:{},  contact:{},  title:{},  tel:{},  status:{}, editMchRequest:{}",
					mchId, contact, title, tel, status, JSON.toJSONString(responseData));
			error("editMchRequest" + JSON.toJSONString(responseData));
		}
		return false;
	}

	public boolean editMchAccountRequest(String mchId, long accountId, Integer status) {
		// String accessToken = PlatformUtil.getAccessToken(host,
		// Long.parseLong(platformAdminAppId),
		// platformAdminAppSecret);
		String accessToken = getAccessTokenManage();
		FuPayUEditMchAccountRequest request = new FuPayUEditMchAccountRequest(accessToken, accountId, status);
		// ApiClient apiClient = new ApiClient(host, Long.parseLong(platformAdminAppId),
		// platformAdminAppSecret);
		ResponseData<FuPayAddMchAccountResponseModel> responseData = executeManager(request);
		logger.info("editMchAccountRequest mchId:{},  accountId:{},  status:{},editMchAccountRequest:{}", mchId,
				accountId, status, JSON.toJSONString(responseData));
		if (responseData.getCode() == 1001) {
			return true;
		} else {
			logger.error("editMchAccountRequest error mchId:{},  accountId:{},  status:{},editMchAccountRequest:{}",
					mchId, accountId, status, JSON.toJSONString(responseData));
			error("editMchAccountRequest:" + JSON.toJSONString(responseData));
		}
		return false;
	}

	public FuPayGetMchAccountListResponseModel uGetMchAccountListRequest(String mchId, String status) {
		// String accessToken = PlatformUtil.getAccessToken(host,
		// Long.parseLong(platformAdminAppId),
		// platformAdminAppSecret);
		// M_GET_MCH_ACCOUNT_LIST
		String accessToken = getAccessTokenManage();
		FuPayUGetMchAccountListRequest request = new FuPayUGetMchAccountListRequest(accessToken, mchId, status);
		// ApiClient apiClient = new ApiClient(host, Long.parseLong(platformAdminAppId),
		// platformAdminAppSecret);
		ResponseData<FuPayGetMchAccountListResponseModel> responseData = executeManager(request);

		if (responseData.getCode() == 1001) {
			return responseData.getData();
		} else {
			logger.error("获取订单详情出错，原因为{}", JSON.toJSONString(responseData));
			error("uGetMchAccountListRequest:" + JSON.toJSONString(responseData));
		}

		return null;
	}

	public FuPayAddMchAccountResponseModel addMchAccountRequest(String mchId, String depositName, String depositBank,
			String bankAccount) {
		// String accessToken = PlatformUtil.getAccessToken(host,
		// Long.parseLong(platformAdminAppId),
		// platformAdminAppSecret);
		String accessToken = getAccessTokenManage();
		FuPayUAddMchAccountRequest request = new FuPayUAddMchAccountRequest(accessToken, mchId, depositName,
				depositBank, bankAccount);
		// ApiClient apiClient = new ApiClient(host, Long.parseLong(platformAdminAppId),
		// platformAdminAppSecret);
		ResponseData<FuPayAddMchAccountResponseModel> responseData = executeManager(request);
		logger.info(
				"addMchAccountRequest String mchId:{}, String depositName:{}, String depositBank:{}, String bankAccount:{}, addMchRequest:{}",
				mchId, depositName, depositBank, bankAccount, JSON.toJSONString(responseData));
		if (responseData.getCode() == 1001) {
			return responseData.getData();
		} else {
			logger.error(
					"addMchAccountRequest String mchId:{}, String depositName:{}, String depositBank:{}, String bankAccount:{}, addMchRequest:{}",
					mchId, depositName, depositBank, bankAccount, JSON.toJSONString(responseData));
			error("addMchAccountRequest:" + JSON.toJSONString(responseData));
		}
		return null;
	}

	public ResponseData<FuPayCreateResponseModel> fuPayCreate(String accountId, String payChannel, String outTradeNo,
			long totalAmount, long feeAmount, String subject, String body, String detail, String clientIp,
			Integer bussinessType, LocalDateTime expireTime, String projectType, String tradeType, String openId,
			FuPayCreateRequest.GoodsDetail... goodsDetails) {

		return fuPayCreateAll(accountId, payChannel, outTradeNo, totalAmount, feeAmount, subject, body, detail,
				clientIp, bussinessType, expireTime, projectType, tradeType, openId, null,null, null, null, null, null, null,
				null, goodsDetails);

	}

	public ResponseData<FuPayCreateResponseModel> fuPayCreateAll(String accountId, String payChannel, String outTradeNo,
			long totalAmount, long feeAmount, String subject, String body, String detail, String clientIp,
			Integer bussinessType, LocalDateTime expireTime, String projectType, String tradeType, String openId,String channelAppName,
			String deviceId, String mobile, Long uid, String wid, String wapName, String wapUrl, String wapRedirectUrl,
			FuPayCreateRequest.GoodsDetail... goodsDetails) {
		String accessToken = getAccessToken();
		FuPayCreateRequest payApplyRequest = new FuPayCreateRequest(accessToken, accountId, payChannel, outTradeNo,
				totalAmount, feeAmount, subject, body, detail, clientIp, bussinessType, expireTime, projectType,
				tradeType, openId,channelAppName, deviceId, mobile, uid, wid, wapName, wapUrl, wapRedirectUrl, goodsDetails);
		ResponseData<FuPayCreateResponseModel> responseData = execute(payApplyRequest);
		return responseData;
	}

	public ResponseData<FuPayQrCodeGenResponseModel> prePayCreate(String accountId, String outTradeNo, long totalAmount,
			long feeAmount, String subject, String body, String clientIp, String projectType, LocalDateTime expireTime,
			String bussinessType, List<GoodsDetail> goodsDetails, String redirectUrl, String deviceId, String mobile,
			String uid, String wid) {
		String accessToken = getAccessToken();
		logger.info(
				"prePayCreate : accessToken={},accountId={},outTradeNo={},totalAmount={},"
						+ "feeAmount={},subject={},body={},clientIp={},expireTime{},goodsDetails={}, redirectUrl={}",
				accessToken, accountId, outTradeNo, totalAmount, feeAmount, subject, body, clientIp, expireTime,
				goodsDetails, redirectUrl);
		FuPayQrCodeGenRequest payCreateRequest = new FuPayQrCodeGenRequest(accessToken, accountId, outTradeNo,
				totalAmount, feeAmount, subject, body, clientIp, projectType, expireTime, bussinessType, goodsDetails,
				redirectUrl, deviceId, mobile, uid, wid);
		ResponseData<FuPayQrCodeGenResponseModel> responseData = execute(payCreateRequest);
		return responseData;
	}

	/**
	 * 创建应用
	 */
	public CreateAppResponseModel createApp(String name, int appType, String tokenType, String sessionType,
			String description, int expireTime, int status, int mode, String waterMarkIcon, String hdIcon,
			String callbackUrl, String domain, int catalogId, int online) {
		String accessToken = getAccessTokenManage();
		CreateAppRequest request = new CreateAppRequest(accessToken, name, appType, tokenType, sessionType, description,
				expireTime, status, mode, waterMarkIcon, hdIcon, callbackUrl, domain, catalogId, online);
		ResponseData<CreateAppResponseModel> responseData = executeManager(request);
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

	//登录
	public ResponseData<SyncLoginResponseModel> rfWalletLogin(String username, String password, String clientIp){
		String accessToken = getAccessToken();
		// platform.appId=347285
		// platform.appSecret=1361cb7bc29d11e68ce800163e02580e
		// platform.manage.appId=99831765
		// platform.manage.appSecret=280d01d54adfb4da142b055fef91535d
		//accessToken = getAccessToken("http://192.168.197.28:10000",99831765L, "280d01d54adfb4da142b055fef91535d");
		SyncLoginRequest request = new SyncLoginRequest(accessToken, username, password, clientIp);
		ResponseData<SyncLoginResponseModel> responseData = execute(request);
		if (responseData.getCode() == 1001) {
		} else {
			logger.error(
					"调用平台登录失败，原因为：responseData={}", JSON.toJSONString(responseData));
		}
		return responseData;
	}

	//授权单点
	public Map<String, String> ssOApplyAuth(String userToken, String authType, String stat) {
		SSOApplyAuthRequest request = new SSOApplyAuthRequest(userToken, authType, stat);
		ResponseData<SSOApplyAuthResponseModel> responseData = execute(request);
		if (responseData.getCode() == 1001) {
			return (Map<String, String>)responseData.getData();
		} else {
			logger.error(
					"调用平台授权失败，原因为：responseData={}", JSON.toJSONString(responseData));
		}
		return null;
	}

	//获取商家详情
	public ResponseData<MchResponseModel> getMchDetail(String userToken, String mchId) {
		GetMchDetailForUserRequest request = new GetMchDetailForUserRequest(userToken,mchId);
		ResponseData<MchResponseModel> responseData = execute(request);
		logger.info("获取商家资料：responseData={}",JSON.toJSONString(responseData));
		return responseData;
	}

	//验证临时token
	public ResponseData<SyncLoginResponseModel> verifyTempToken(String tempToken, String ip) {
		String accessToken = getAccessToken();
		VerifyTempTokenRequest request = new VerifyTempTokenRequest(accessToken, tempToken, ip);
		ResponseData<SyncLoginResponseModel> responseData = execute(request);
		if (responseData.getCode() == 1001) {
		} else {
			logger.error(
					"调用平台验证令牌失败，原因为：responseData={}", JSON.toJSONString(responseData));
		}
		return responseData;
	}

	//刷新userToken
	public void refreshUserToken(String userToken) {
		com.rfchina.api.request.mch.VerifyUserTokenRequest request = new com.rfchina.api.request.mch.VerifyUserTokenRequest(userToken);
		execute(request);
	}

	//登出
	public void logout(String userToken) {
		SyncLogoutRequest request = new SyncLogoutRequest(userToken);
		execute(request);
	}

	public FuPayGetAccountListResponseModel getAccountListRequest(String accountId, String mchId, String keyword,
																		Boolean stat, int limit, int offset) {
		String accessToken = getAccessToken();
		FuPayMGetAccountListRequest request = new FuPayMGetAccountListRequest(accessToken, accountId, mchId, keyword,
				stat, limit, offset);
		ResponseData<FuPayGetAccountListResponseModel> responseData = execute(request);

		logger.info(
				"fuPayMGetAccountListRequest accessToken:{}, accountId:{}, mchId:{}, keyword:{},stat:{}, limit:{}, offset:{},{}",
				accessToken, accountId, mchId, keyword, stat, limit, offset, JSON.toJSONString(responseData));
		if (responseData.getCode() == 1001) {
			return responseData.getData();
		} else {
			logger.error("获取收款账号列表:" + JSON.toJSONString(responseData));
			error("获取收款账号列表:" + JSON.toJSONString(responseData));
		}
		return null;
	}

	//获取收款账号绑定结算账号状态
	public Boolean bindStatus(String mchId, String accountId) {
		String accessToken = getAccessToken();
		SettleAccountBindStatusRequest request = new SettleAccountBindStatusRequest(accessToken, mchId, accountId);

		ResponseData<FuPayGetAccountListResponseModel>responseData = execute(request);
		if (responseData.getCode() == 1001) {
			return true;
		}
		return false;
	}

	//获取商家详情
	public ResponseData<MchResponseModel> getMchDetailForBusiness(String mchId) {
		GetMchDetailForBusinessRequest request = new GetMchDetailForBusinessRequest(getAccessToken(),mchId);
		ResponseData<MchResponseModel> responseData = execute(request);
		logger.info("getMchDetail data:{}" + JSON.toJSONString(responseData));
		return responseData;
	}

	//查看账户是否绑定结算账号
	public Boolean getAccountBindStatus(String mchId, String accountId){
		GetSettleAccountForBusinessRequest request = new GetSettleAccountForBusinessRequest(getAccessToken(),mchId, accountId);
		ResponseData<SettleAccountResponseModel> responseData = execute(request);
		logger.info("getAccountBindStatus responseData:{}", JSON.toJSONString(responseData));
		if (responseData.getCode() == 1001) {
			return true;
		}
		return false;
	}

	/**
	 * @Author wlrllr
	 * @Description //查询退款申请审批记录
	 * @Date 2019/1/4
	 * @Param [mchId, accountId]
	 * @return java.lang.Boolean
	 **/
	public ArrayList<PayRefundAuditLogModel> getRefundAuditList(String refundId){
		FuPayRefundAuditListRequest request = new FuPayRefundAuditListRequest(getAccessToken(),refundId);
		ResponseData<PayRefundAuditLogResponseModel> responseData = execute(request);
		logger.info("getRefundAuditList responseData:{}", JSON.toJSONString(responseData));
		if (responseData.getCode() == 1001) {
			return responseData.getData();
		}
		return null;
	}


	public ResponseData<Map<String, Object>> settleConfirm(String bills){
		FuPaySettleConfirmRequest request = new FuPaySettleConfirmRequest(getAccessToken(),bills);
		ResponseData<Map<String, Object>> responseData = execute(request);
		logger.info("settleConfirm responseData:{}", JSON.toJSONString(responseData));
		return responseData;
	}

	public ResponseData<Map<String, Object>> businessConfirmRecord(String billId, String type){
		FuPaySettleConfirmRecordRequest request = new FuPaySettleConfirmRecordRequest(getAccessToken(),billId, type);
		ResponseData<Map<String, Object>> responseData = execute(request);
		logger.info("businessConfirmRecord responseData:{}", JSON.toJSONString(responseData));
		return responseData;
	}

	public ExpressProgressResponse queryExpressProgress(String company, String number){
		QueryExpressProgresRequest request = new QueryExpressProgresRequest(getAccessToken(),company,number);
		ResponseData<ExpressProgressResponse> responseData = execute(request);
		logger.info("queryExpressProgress responseData:{}", JSON.toJSONString(responseData));
		if (responseData.getCode() == 1001) {
			return responseData.getData();
		}
		return null;
	}

	public List<ExpressCompany> queryExpressCompany(){
		QueryExpressCompanyListRequest request = new QueryExpressCompanyListRequest(getAccessToken());
		ResponseData<QueryExpressCompanyListResponse> responseData = execute(request);
		logger.info("queryExpressCompany responseData:{}", JSON.toJSONString(responseData));
		if (responseData.getCode() == 1001) {
			return responseData.getData();
		}
		return null;
	}

	public QueryCommCodeByNumberResponse queryExpressCompany(String number){
		QueryCommCodeByNumberRequest request = new QueryCommCodeByNumberRequest(getAccessToken(),number);
		ResponseData<QueryCommCodeByNumberResponse> responseData = execute(request);
		logger.info("QueryCommCodeByNumberRequest responseData:{}", JSON.toJSONString(responseData));
		if (responseData.getCode() == 1001) {
			return responseData.getData();
		}
		return null;
	}

	public ExpressAuthorizeUrlResponse queryExpressAuthorizeUrl(String companyCode,String number){
		GetAuthorizeUrlRequest request = new GetAuthorizeUrlRequest(getAccessToken(),companyCode,number);
		ResponseData<ExpressAuthorizeUrlResponse> responseData = execute(request);
		logger.info("queryExpressAuthorizeUrl responseData:{}", JSON.toJSONString(responseData));
		if (responseData.getCode() == 1001) {
			return responseData.getData();
		}
		return null;
	}
}
