package com.rfchina.community.openweb.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.jfinal.weixin.sdk.api.ApiConfigKit;
import com.jfinal.weixin.sdk.api.JsTicket;
import com.jfinal.weixin.sdk.api.JsTicketApi;
import com.jfinal.weixin.sdk.api.JsTicketApi.JsApiType;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.HashUtil;

@RestController
@RequestMapping(value = {Constant.ROOT_PATH_OPENWEB})
public class AppidOpenWebController extends BaseController{

	private static Logger logger = LoggerFactory.getLogger(AppidOpenWebController.class);

	private static String create_nonce_str() {
		return UUID.randomUUID().toString();
	}

	private static String create_timestamp() {
		return Long.toString(System.currentTimeMillis() / 1000);
	}

	@RequestMapping("/getJsConfigByOpenWeb")
	public Result<?> getJsConfig(@RequestParam(value = "url") String url) {
		
		JsTicket jsApiTicket = JsTicketApi.getTicket(JsApiType.jsapi);

		String jsapi_ticket = jsApiTicket.getTicket();
		
		String nonce_str = create_nonce_str();
		// 注意 URL 一定要动态获取，不能 hardcode.

		String timestamp = create_timestamp();
		// 这里参数的顺序要按照 key 值 ASCII 码升序排序
		// 注意这里参数名必须全部小写，且必须有序
		String str = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + nonce_str + "&timestamp=" + timestamp + "&url="
				+ url;
		logger.info("getJsConfig_str:{}:json:{}", str,jsApiTicket.getJson());
		String signature = HashUtil.sha1(str);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("timestamp", timestamp);
		result.put("appId", ApiConfigKit.getApiConfig().getAppId());
		result.put("nonceStr", nonce_str);
		result.put("signature", signature);
		result.put("jsapi_ticket", jsapi_ticket);
		result.put("url", url);
		logger.info("result:{}", JSON.toJSONString(result));
		return Result.successData(result);
	}

}
