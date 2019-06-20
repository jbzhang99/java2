package com.rfchina.community.openweb.service;

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
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.base.exception.WorkRunTimeException;

@Service
public class HttpClientPlugin {

	private static final Logger logger = LoggerFactory.getLogger(HttpClientPlugin.class);

	public String encoding = "utf-8";

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
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
		CloseableHttpClient httpClient = httpClientBuilder.build();
		HttpPost httpost = new HttpPost(url);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		try {
			if (params != null) {
				for (Entry<String, ?> nameValuePair : params.entrySet()) {
					if (nameValuePair.getValue() != null) {
						nvps.add(new BasicNameValuePair(nameValuePair.getKey(), nameValuePair.getValue().toString()));
					}
				}
			}
			httpost.setEntity(new UrlEncodedFormEntity(nvps, getEncoding()));
			HttpResponse response = httpClient.execute(httpost);
			HttpEntity entity = response.getEntity();
			StatusLine sl = response.getStatusLine();
//			logger.info("url:{}, params:{}, StatusLine:{} ", url, params, sl.toString());
			try {
				InputStream input = entity.getContent();
				return IOUtils.toString(input, getEncoding());
			} finally {
				EntityUtils.consume(entity);
			}

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
				HttpEntity entity = response.getEntity();
				try {
					InputStream input = entity.getContent();
					return IOUtils.toString(input, getEncoding());
				} finally {
					EntityUtils.consume(entity);
				}
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

	// public boolean start() {
	// httpClientBuilder = HttpClients.custom();
	// return true;
	// }

}
