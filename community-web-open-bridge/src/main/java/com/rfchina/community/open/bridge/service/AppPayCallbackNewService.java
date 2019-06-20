package com.rfchina.community.open.bridge.service;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import okhttp3.*;
import okhttp3.FormBody.Builder;

@Service
public class AppPayCallbackNewService {

	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

	private static Logger logger = LoggerFactory.getLogger(AppPayCallbackNewService.class);
	OkHttpClient client = new OkHttpClient();

	public String postToString(String url, Map<String, String> params) throws IOException {
		Builder builder = new FormBody.Builder();
		params.forEach((k, v) -> {
			builder.add(k, v);
		});
		RequestBody formBody = builder.build();

		Request request = new Request.Builder().url(url).post(formBody).build();
		Call call = client.newCall(request);

		Response response = call.execute();
		return response.body().string();

	}

}
