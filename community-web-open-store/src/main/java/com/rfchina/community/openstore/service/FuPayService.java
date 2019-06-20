package com.rfchina.community.openstore.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.rfchina.api.ApiClient;
import com.rfchina.api.request.user.GetUserInfoWithOpenIdRequest;
import com.rfchina.api.response.ResponseData;
import com.rfchina.api.response.model.user.GetUserInfoWithOpenIdResponseModel;
import com.rfchina.api.util.SecurityCoder;
import com.rfchina.api.util.SignUtil;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.platform.common.http.HttpUtil;

@Service
public class FuPayService {

	private static transient Logger logger = LoggerFactory.getLogger(FuPayService.class);
	
	@Value("${rfpay.host}")
    private String rfpayHost;
	@Value("${zizai.open.api.url}")
	private String openApiServer;
	
	
	/**
	 * @author:fukangwen
	 * @Description: 
	 * @return String
	 * @throws
	 */
	public String getClientTicket(int service_id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("service_id", String.valueOf(service_id));
		String responeData = HttpUtil.post(openApiServer + OpenConstant.ROOT_PATH_OPEN_STORE + "/create_client_ticket", params);
		JSONObject json = JSON.parseObject(responeData);
		if (200 != json.getIntValue("code")) {
			logger.info("获取clientTicket失败：{}", responeData);
			return null;
		}
		JSONObject dataJson = json.getJSONObject("data");
		if(1001 != dataJson.getIntValue("code")) {
			logger.info("获取clientTicket失败：{}", responeData);
			return null;
		}
			
		return dataJson.getJSONObject("data").getString("clientTicket");
	}

	/**
	 * @author:fukangwen
	 * @Description: 
	 * @return String
	 * @throws
	 */
	public JSONObject getUidFromOpenId(String open_id, int service_id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("open_id", open_id);
		params.put("service_id", String.valueOf(service_id));
		String responeData = HttpUtil.post(openApiServer + OpenConstant.ROOT_PATH_OPEN_STORE + "/openid_to_uid", params);
		JSONObject json = JSON.parseObject(responeData);
		if (200 != json.getIntValue("code")) {
			logger.info("获取uid失败：{}", responeData);
			return null;
		}
		return json.getJSONObject("data");
	}

}
