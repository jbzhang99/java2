package com.rfchina.community.openweb.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.rfchina.api.ApiClient;
import com.rfchina.api.request.app.GetAccessTokenRequest;
import com.rfchina.api.request.pay.FuPayCreateRequest;
import com.rfchina.api.request.pay.FuPayQrCodeGenRequest;
import com.rfchina.api.request.pay.FuPayCreateRequest.GoodsDetail;
import com.rfchina.api.response.ResponseData;
import com.rfchina.api.response.model.app.GetAccessTokenReponseModel;
import com.rfchina.api.response.model.pay.FuPayCreateResponseModel;
import com.rfchina.api.response.model.pay.FuPayQrCodeGenResponseModel;

@Service
public class FuPayService {

	private static transient Logger logger = LoggerFactory.getLogger(FuPayService.class);
	
	private Cache<String, String> accessTokenLocalCache = CacheBuilder.newBuilder()
            .expireAfterWrite(95, TimeUnit.MINUTES)
            .build();
	
	@Value("${platform.host}")
    private String rfpayHost;
	
	//获取平台的accessToken
	public String getAccessToken(Long rfpayAppId , String rfpayAppSecret){
		//从缓存里面获取accessToken
		String accessToken = accessTokenLocalCache.getIfPresent(rfpayAppSecret+"_"+rfpayAppId);
		
		//如果缓存里面为空，则从平台重新获取accessToken
		if(StringUtils.isBlank(accessToken)){
			accessToken = getRemoteAccessToken(rfpayAppId , rfpayAppSecret);
		}
		return accessToken;
	}
	
	protected String getRemoteAccessToken(Long appId, String appSecret) {
        GetAccessTokenRequest request = new GetAccessTokenRequest(appId, appSecret);
        ApiClient apiClient = new ApiClient(rfpayHost, appId, appSecret);
        ResponseData<GetAccessTokenReponseModel> responseData = apiClient.execute(request);
        logger.info("Invoke [getRemoteAccessToken] with parameters: %d, %s, and response: %s", appId, appId, responseData);
        GetAccessTokenReponseModel model = responseData.getData();
        return null!=model? model.getAccessToken():null;
    }
	
	
	
	public ResponseData<FuPayCreateResponseModel> fuPayCreate(Long rfpayAppId , String rfpayAppSecret , String accountId,String payChannel, String outTradeNo, long totalAmount,long feeAmount, String subject,
            String body, String detail, String clientIp, Integer bussinessType, LocalDateTime expireTime,
            String projectType, String tradeType, String openId, FuPayCreateRequest.GoodsDetail... goodsDetails){
		String accessToken = getAccessToken(rfpayAppId, rfpayAppSecret);
		FuPayCreateRequest payApplyRequest = new FuPayCreateRequest(accessToken,accountId, payChannel, outTradeNo, totalAmount,0L,subject, body, detail, clientIp, bussinessType, expireTime, projectType, tradeType, openId,
				null,null, null, null, null,goodsDetails);
		
		ApiClient apiClient = new ApiClient(rfpayHost, rfpayAppId, rfpayAppSecret);
        ResponseData<FuPayCreateResponseModel> responseData = apiClient.execute(payApplyRequest);
        return responseData;
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 渠道未知时, 扫码付预建单 FuPayQrCodeGenRequest
	 * @return ResponseData<FuPayCreateResponseModel>
	 * @throws
	 */
	public ResponseData<FuPayQrCodeGenResponseModel> prePayCreate(Long rfpayAppId, String rfpayAppSecret, String accountId, String outTradeNo, long totalAmount, long feeAmount,
			String subject, String body, String clientIp, String projectType, LocalDateTime expireTime, String bussinessType, 
			List<GoodsDetail> goodsDetails, String redirectUrl, String deviceId, String mobile, String uid, String wid) {
		String accessToken = getAccessToken(rfpayAppId, rfpayAppSecret);
		logger.info("prePayCreate : accessToken={},accountId={},outTradeNo={},totalAmount={},"
				+ "feeAmount={},subject={},body={},clientIp={},expireTime{},goodsDetails={}, redirectUrl={}" ,
				accessToken,accountId,outTradeNo,totalAmount,feeAmount,subject,body, clientIp, expireTime, goodsDetails, redirectUrl);
		FuPayQrCodeGenRequest payCreateRequest = new FuPayQrCodeGenRequest(
				accessToken,accountId, outTradeNo, totalAmount,
				feeAmount,subject, body, clientIp, null,
				expireTime, bussinessType, goodsDetails, redirectUrl, deviceId, mobile, uid, wid);

		ApiClient apiClient = new ApiClient(rfpayHost, rfpayAppId, rfpayAppSecret);
		ResponseData<FuPayQrCodeGenResponseModel> responseData = apiClient.execute(payCreateRequest);
		return responseData;
	}

}
