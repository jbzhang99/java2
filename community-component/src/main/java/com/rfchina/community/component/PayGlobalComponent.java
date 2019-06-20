package com.rfchina.community.component;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.rfchina.api.ApiClient;
import com.rfchina.api.request.app.GetAccessTokenRequest;
import com.rfchina.api.request.oauth2.Oauth2InfoGrantedRequest;
import com.rfchina.api.request.oauth2.Oauth2UserInfoRequest;
import com.rfchina.api.request.pay.FuPayCreateRequest;
import com.rfchina.api.response.ResponseData;
import com.rfchina.api.response.model.app.GetAccessTokenReponseModel;
import com.rfchina.api.response.model.oauth2.Oauth2InfoGrantedResponseModel;
import com.rfchina.api.response.model.oauth2.Oauth2UserInfoResponseModel;
import com.rfchina.api.response.model.pay.FuPayCreateResponseModel;
/**
 */
@Component
public class PayGlobalComponent {

	private static final String CACHE_KEY = "rfpay_access_token";

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Value("${rfpay.host:default}")
	private String rfpayHost;

	@Value("${rfpay.appId:0}")
	private Long rfpayAppId;

	@Value("${rfpay.appSecret:default}")
	private String rfpayAppSecret;

	// @Value("${rfpay.accountId}")
	// private String rfAccountId;
	private ApiClient apiClient = null;

	@PostConstruct
	public void init() {
		apiClient = new ApiClient(rfpayHost, rfpayAppId, rfpayAppSecret);
	}

	private void println() {
		logger.info("rfpay.host:{}, rfpay.appId:{}, rfpay.appSecret:{}", rfpayHost, rfpayAppId, rfpayAppSecret);
	}

	private Cache<String, String> accessTokenLocalCache = CacheBuilder.newBuilder().expireAfterWrite(95, TimeUnit.MINUTES).build();

	public ResponseData<FuPayCreateResponseModel> pay(String accountId, String payChannel, String outTradeNo, long totalAmount, long feeAmount, String subject,
			String body, String detail, String clientIp, Integer bussinessType, LocalDateTime expireTime, String projectType, String tradeType, String openId,
			FuPayCreateRequest.GoodsDetail... goodsDetails) {
		String cacheAccessToken = getCacheAccessToken();
		FuPayCreateRequest payApplyRequest = new FuPayCreateRequest(cacheAccessToken, accountId, payChannel, outTradeNo, totalAmount, feeAmount, subject, body,
				detail, clientIp, bussinessType, expireTime, projectType, tradeType, openId, null,null, null, null, null, goodsDetails);
		ResponseData<FuPayCreateResponseModel> responseData = apiClient.execute(payApplyRequest);
		return responseData;
	}

	private String getCacheAccessToken() {
		String cacheAccessToken = accessTokenLocalCache.getIfPresent(CACHE_KEY);
		if (StringUtils.isBlank(cacheAccessToken)) {
			String accessToken = getRemoteAccessToken(rfpayAppId, rfpayAppSecret);
			accessTokenLocalCache.put(CACHE_KEY, accessToken);
			cacheAccessToken = accessToken;
		}
		return cacheAccessToken;
	}

	public String getRemoteAccessToken(Long appId, String appSecret) {
		println();
		GetAccessTokenRequest request = new GetAccessTokenRequest(appId, appSecret);
		ResponseData<GetAccessTokenReponseModel> responseData = apiClient.execute(request);
		logger.info("Invoke [getRemoteAccessToken] with parameters: %d, %s, and response: %s", appId, appId, responseData);
		GetAccessTokenReponseModel model = responseData.getData();
		return null != model ? model.getAccessToken() : null;
	}

	public ResponseData<Oauth2InfoGrantedResponseModel> oauth2InfoGrantedRequest(String accessToken, String clientTicket) {
		println();
		Oauth2InfoGrantedRequest granted = new Oauth2InfoGrantedRequest(accessToken, clientTicket);
		ResponseData<Oauth2InfoGrantedResponseModel> aa = apiClient.execute(granted);
		return aa;
	}

	public ResponseData<Oauth2UserInfoResponseModel> oauth2UserInfoRequest(String grantToken) {
		println();
		ResponseData<Oauth2UserInfoResponseModel> aa = apiClient.execute(new Oauth2UserInfoRequest(grantToken));
		return aa;
	}
 
}
