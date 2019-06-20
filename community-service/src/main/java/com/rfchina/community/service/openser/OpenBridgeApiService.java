package com.rfchina.community.service.openser;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Service
public class OpenBridgeApiService {
	@Value("${open.bridgeapi.url:test}")
	private String open_bridgeapi_url;

	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

	private static Logger logger = LoggerFactory.getLogger(OpenBridgeApiService.class);
	OkHttpClient client = new OkHttpClient();

	public void post(String url, Object json, OutputStream os) throws IOException {
		logger.info("post33:url{} json:{}", url, JSONObject.toJSONString(json));
		String content = null;
		if (json != null) {
			content = JSONObject.toJSONString(json);
		}
		RequestBody body = RequestBody.create(JSON, content);
		Request request = new Request.Builder().url(url).post(body).build();
		Call call = client.newCall(request);

		try (Response response = call.execute()) {
			ResponseBody body1 = response.body();
			if (body1 != null) {
				InputStream bs = body1.byteStream();
				IOUtils.copy(bs, os);
				IOUtils.closeQuietly(bs);
			}
		}
	}
}
