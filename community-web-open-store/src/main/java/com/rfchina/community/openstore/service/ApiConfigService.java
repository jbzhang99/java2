package com.rfchina.community.openstore.service;

import com.alibaba.fastjson.JSONObject;
import com.jfinal.kit.StrKit;
import com.jfinal.weixin.sdk.api.*;
import com.jfinal.weixin.sdk.cache.IAccessTokenCache;
import com.jfinal.weixin.sdk.kit.ParaMap;
import com.jfinal.weixin.sdk.utils.HttpUtils;
import com.jfinal.weixin.sdk.utils.RetryUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;

@Service
public class ApiConfigService {

	private static Logger logger = LoggerFactory.getLogger(ApiConfigService.class);

	@Value("${wechat.appid}")
	String appid;
	@Value("${wechat.appSecret}")
	String appSecret;
	@Autowired
	private IAccessTokenCache accessTokenCache;
	@Value("${wx.info}")
	private String extendWxInfo;

	private static String apiUrl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";

	@PostConstruct
	public void init() {
		//初始化
		AccessTokenApi.removeAccessToken();
		accessTokenCache.remove(appid);

		ApiConfig apiConfig = new ApiConfig();
		apiConfig.setAppId(appid);
		apiConfig.setAppSecret(appSecret);
		ApiConfigKit.putApiConfig(apiConfig);

		//加载额外的appId
		JSONObject info = JSONObject.parseObject(extendWxInfo);
		for(Map.Entry entry : info.entrySet()){
			JSONObject obj = (JSONObject)entry.getValue();
			ApiConfig config = new ApiConfig();
			config.setAppId(obj.getString("appId"));
			config.setAppSecret(obj.getString("appSecret"));
			ApiConfigKit.putApiConfig(config);
		}

		ApiConfigKit.setAccessTokenCache(accessTokenCache);
		logger.info("json,appid:{},appSecret:{}", appid, appSecret);
	}

	public static JsTicket getTicket(JsTicketApi.JsApiType jsApiType, String appId) {
		String access_token = AccessTokenApi.getAccessTokenStr();
		String key = appId + ':' + jsApiType.name();
		final ParaMap pm = ParaMap.create("access_token", access_token).put("type", jsApiType.name());
		IAccessTokenCache accessTokenCache = ApiConfigKit.getAccessTokenCache();
		String jsTicketJson = accessTokenCache.get(key);
		JsTicket jsTicket = null;
		if (StrKit.notBlank(jsTicketJson)) {
			jsTicket = new JsTicket(jsTicketJson);
		}

		if (null == jsTicket || !jsTicket.isAvailable()) {
			jsTicket = RetryUtils.retryOnException(3, () -> new JsTicket(HttpUtils.get(apiUrl, pm.getData())));
			if (null != jsApiType) {
				accessTokenCache.set(key, jsTicket.getCacheJson());
			}
		}

		return jsTicket;
	}

	public static JsTicket getTicket(JsTicketApi.JsApiType jsApiType) {
		return JsTicketApi.getTicket(jsApiType);
	}

	public static ApiConfig getDefaultApiConfig() {
		return ApiConfigKit.getApiConfig();
	}

	public static ApiConfig getApiConfig(String appId) {
		return ApiConfigKit.getApiConfig(appId);
	}
}
