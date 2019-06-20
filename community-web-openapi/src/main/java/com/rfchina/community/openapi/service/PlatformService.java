package com.rfchina.community.openapi.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.rfchina.api.ApiClient;
import com.rfchina.api.request.pay.FuPayGetBillDetailRequest;
import com.rfchina.api.request.pay.FuPaySplitBillRequest;
import com.rfchina.api.request.pay.FuPaySplitBillRequest.SplitDataModel;
import com.rfchina.api.request.pay.FuPayUGetAccountRequest;
import com.rfchina.api.request.pay.FuPayUGetMchDetailRequest;
import com.rfchina.api.request.pay.FuPayUploadSettleDataRequest;
import com.rfchina.api.request.pay.FuPayUploadSettleDataRequest.SettleData;
import com.rfchina.api.request.user.VerifyUserTokenRequest;
import com.rfchina.api.response.ResponseData;
import com.rfchina.api.response.model.pay.FuPayGetAccountResponseModel;
import com.rfchina.api.response.model.pay.FuPayGetBillDetailResponseModel;
import com.rfchina.api.response.model.pay.FuPayGetMchDetailResponseModel;
import com.rfchina.api.response.model.pay.FuPaySplitBillResponseModel;
import com.rfchina.api.response.model.pay.FuPayUploadSettleDataResponseModel;
import com.rfchina.api.response.model.user.VerifyUserTokenResponseModel;
import com.rfchina.community.openapi.util.PlatformUtil;

@Service
public class PlatformService {

	@Value("${platform.host}")
	private String host;

	@Value("${rfpay.appId}")
	private String rfpayAppId;

	@Value("${rfpay.appSecret}")
	private String rfpayAppSecret;

	private static transient Logger logger = LoggerFactory.getLogger(PlatformService.class);

	public FuPaySplitBillResponseModel splitBill(String billId, List<SplitDataModel> splitDataList) {
		String accessToken = PlatformUtil.getAccessToken(host, Long.parseLong(rfpayAppId), rfpayAppSecret);
		FuPaySplitBillRequest request = new FuPaySplitBillRequest(accessToken, billId, splitDataList);
		ApiClient apiClient = new ApiClient(host, Long.parseLong(rfpayAppId), rfpayAppSecret);
		ResponseData<FuPaySplitBillResponseModel> responseData = apiClient.execute(request);

		if (responseData.getCode() == 1001) {
			return responseData.getData();
		} else {
			logger.error("调用支付中心拆单接口出错，原因为" + responseData.getMsg());
		}

		return null;
	}

	public FuPayGetBillDetailResponseModel getBillDetail(String billId) {
		String accessToken = PlatformUtil.getAccessToken(host, Long.parseLong(rfpayAppId), rfpayAppSecret);
		FuPayGetBillDetailRequest request = new FuPayGetBillDetailRequest(accessToken, billId);
		ApiClient apiClient = new ApiClient(host, Long.parseLong(rfpayAppId), rfpayAppSecret);
		ResponseData<FuPayGetBillDetailResponseModel> responseData = apiClient.execute(request);

		if (responseData.getCode() == 1001) {
			return responseData.getData();
		} else {
			logger.error("获取订单详情出错，原因为" + responseData.getMsg());
		}

		return null;
	}

	public FuPayUploadSettleDataResponseModel uploadSettleData(String mchId, String title,
			List<SettleData> settleData) {
		String accessToken = PlatformUtil.getAccessToken(host, Long.parseLong(rfpayAppId), rfpayAppSecret);
		FuPayUploadSettleDataRequest request = new FuPayUploadSettleDataRequest(accessToken, mchId, title, settleData);
		ApiClient apiClient = new ApiClient(host, Long.parseLong(rfpayAppId), rfpayAppSecret);
		ResponseData<FuPayUploadSettleDataResponseModel> responseData = apiClient.execute(request);

		if (responseData.getCode() == 1001) {
			return responseData.getData();
		} else {
			logger.error("上传业务结算数据出错，原因为" + responseData.getMsg());
		}

		return null;
	}

	public FuPayGetAccountResponseModel getAccount(String accountId) {
		String accessToken = PlatformUtil.getAccessToken(host, Long.parseLong(rfpayAppId), rfpayAppSecret);
		FuPayUGetAccountRequest request = new FuPayUGetAccountRequest(accessToken, accountId);
		ApiClient apiClient = new ApiClient(host, Long.parseLong(rfpayAppId), rfpayAppSecret);
		ResponseData<FuPayGetAccountResponseModel> responseData = apiClient.execute(request);

		if (responseData.getCode() == 1001) {
			return responseData.getData();
		} else {
			logger.error("获取付款账号信息出错，原因为  host:{} accountId:{},{}", host, accountId, JSON.toJSONString(responseData));
		}

		logger.debug("获取付款账号信息完成");

		return null;
	}

	public FuPayGetMchDetailResponseModel getMchDetail(String mchId) {
		String accessToken = PlatformUtil.getAccessToken(host, Long.parseLong(rfpayAppId), rfpayAppSecret);
		FuPayUGetMchDetailRequest request = new FuPayUGetMchDetailRequest(accessToken, mchId);
		ApiClient apiClient = new ApiClient(host, Long.parseLong(rfpayAppId), rfpayAppSecret);
		ResponseData<FuPayGetMchDetailResponseModel> responseData = apiClient.execute(request);

		if (responseData.getCode() == 1001) {
			return responseData.getData();
		} else {
			logger.error("获取商家详情信息出错，原因为  mchId:{},{}", mchId, JSON.toJSONString(responseData));
		}

		return null;
	}

	public VerifyUserTokenResponseModel getVerifyUserToken(String token) {
		
		VerifyUserTokenRequest request = new VerifyUserTokenRequest(token);
		ApiClient apiClient = new ApiClient(host, Long.parseLong(rfpayAppId), rfpayAppSecret);
		ResponseData<VerifyUserTokenResponseModel> responseData = apiClient.execute(request);

		if (responseData.getCode() == 1001) {
			return responseData.getData();
		} else {
			logger.error("获取商家详情信息出错，原因为  token:{},{}", token, JSON.toJSONString(responseData));
		}

		return null;
	}

}
