package com.rfchina.community.openstore.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.base.exception.WorkRunTimeException;

public class HttpClientPlugin {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	public static  String encoding = "utf-8";

	public String getEncoding() {
		return encoding;
	}

	protected JSONObject check(JSONObject jsonString) {
		if (jsonString != null && jsonString.containsKey("code")) {
			return jsonString;
		}
		throw new WorkRunTimeException("底层通讯失败!");
	}

	protected JSONObject parseObject(String str) {
		try {
			return JSON.parseObject(str);
		} catch (Exception e) {
			logger.error("parseObject: {}", str, e);
			throw new WorkRunTimeException("底层通讯失败!a");
		}

	}

	public JSONObject httpPostToJson(String url, Map<String, ?> params) {
		return check(parseObject(httpPost(url, params)));
	}

	public String httpPost(String url, Map<String, ?> params) {
		httpClientBuilder = HttpClients.custom();
		CloseableHttpClient httpClient = httpClientBuilder.build();
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> nameValuePairs = new ArrayList<>();
		try {
			if (params != null) {
				for (Entry<String, ?> nameValuePair : params.entrySet()) {
					if (nameValuePair.getValue() != null) {
						nameValuePairs.add(new BasicNameValuePair(nameValuePair.getKey(), nameValuePair.getValue().toString()));
					}
				}
			}
			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, getEncoding()));
			HttpResponse response = httpClient.execute(httpPost);
			return getResponse(response);

		} catch (Exception e) {
			logger.error("url:{}, params:{}  ", url, params, e);
			throw new WorkRunTimeException("底层通讯失败!!!!");
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				logger.error("url:{}, params:{}  ", url, params, e);
			}
		}
	}

	private String getResponse(HttpResponse response) throws IOException {
		HttpEntity entity = response.getEntity();
		try {
			InputStream input = entity.getContent();
			return IOUtils.toString(input, getEncoding());
		} finally {
			EntityUtils.consume(entity);
		}
	}

	public String httpGet(String url, Map<String, ?> params) {
		CloseableHttpClient httpClient = httpClientBuilder.build();
		HttpGet httpget = new HttpGet(url);
		for (Entry<String, ?> nameValuePair : params.entrySet()) {
			httpget.addHeader(nameValuePair.getKey(), nameValuePair.getValue().toString());
		}
		try {
			HttpResponse response = httpClient.execute(httpget);
			StatusLine sl = response.getStatusLine();
			if (sl.getStatusCode() == HttpStatus.SC_OK) {
				return getResponse(response);
			} else {
				logger.error("url:{}, params:{}, StatusLine:{} ", url, params, sl.toString());
			}
		} catch (Exception e) {
			logger.error("", e);
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				logger.error("url:{}, params:{}  ", url, params, e);
			}
		}
		return null;
	}

	HttpClientBuilder httpClientBuilder = null;

	public HttpClientBuilder getHttpClientBuilder() {
		return httpClientBuilder;
	}

	public void setHttpClientBuilder(HttpClientBuilder httpClientBuilder) {
		this.httpClientBuilder = httpClientBuilder;
	}


}
