package com.rfchina.community.openapi.util;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.rfchina.api.ApiClient;
import com.rfchina.api.request.app.GetAccessTokenRequest;
import com.rfchina.api.response.ResponseData;
import com.rfchina.api.response.model.app.GetAccessTokenReponseModel;

public class PlatformUtil {
	
	private static transient Logger logger = LoggerFactory.getLogger(PlatformUtil.class);

	private static Cache<String, String> accessTokenLocalCache = CacheBuilder.newBuilder()
            .expireAfterWrite(95, TimeUnit.MINUTES)
            .build();
	
	//获取平台的accessToken
	public static String getAccessToken(String rfpayHost ,Long rfpayAppId , String rfpayAppSecret){
		//从缓存里面获取accessToken
		String accessToken = accessTokenLocalCache.getIfPresent(rfpayAppSecret+"_"+rfpayAppId);
		
		//如果缓存里面为空，则从平台重新获取accessToken
		if(StringUtils.isBlank(accessToken)){
			accessToken = getRemoteAccessToken(rfpayHost , rfpayAppId , rfpayAppSecret);
		}
		return accessToken;
	}
	
	protected static String getRemoteAccessToken(String rfpayHost ,Long appId, String appSecret) {
        GetAccessTokenRequest request = new GetAccessTokenRequest(appId, appSecret);
        ApiClient apiClient = new ApiClient(rfpayHost, appId, appSecret);
        ResponseData<GetAccessTokenReponseModel> responseData = apiClient.execute(request);
        logger.info("Invoke [getRemoteAccessToken] with parameters: %d, %s, and response: %s", appId, appId, responseData);
        GetAccessTokenReponseModel model = responseData.getData();
        return null!=model? model.getAccessToken():null;
    }
}
