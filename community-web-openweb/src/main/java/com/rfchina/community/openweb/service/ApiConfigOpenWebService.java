package com.rfchina.community.openweb.service;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.api.ApiConfigKit;
import com.jfinal.weixin.sdk.cache.IAccessTokenCache;
import com.jfinal.weixin.sdk.cache.RedisAccessTokenCache;

@Service
public class ApiConfigOpenWebService {

	private static Logger logger = LoggerFactory.getLogger(ApiConfigOpenWebService.class);

	@Value("${wechat.appid}")
	private String appid;
	@Value("${wechat.appSecret}")
	private String appSecret;

	@Autowired
	private IAccessTokenCache accessTokenCache;

	@PostConstruct
	public void init() {
		ApiConfig apiConfig = new ApiConfig();
		apiConfig.setAppId(appid);
		apiConfig.setAppSecret(appSecret);
		ApiConfigKit.putApiConfig(apiConfig);

		ApiConfigKit.setAccessTokenCache(accessTokenCache);
		logger.info("json,init,appid:{},appSecret:{}", appid, appSecret);
	}
}
