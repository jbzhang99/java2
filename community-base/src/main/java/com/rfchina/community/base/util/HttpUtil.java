package com.rfchina.community.base.util;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class HttpUtil {

	private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

	public static String getIp2(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (ip != null && ip.length() > 0 && !"unKnown".equalsIgnoreCase(ip)) {
			// 多次反向代理后会有多个ip值，第一个ip才是真实ip
			int index = ip.indexOf(",");
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		}
		ip = request.getHeader("X-Real-IP");
		if (ip != null && ip.length() > 0 && !"unKnown".equalsIgnoreCase(ip)) {
			return ip;
		}
		return request.getRemoteAddr();
	}

	/**
	 * String mytext = URLEncoder.encode("中国", "utf-8"); <br>
	 * 
	 * mytext: %E4%B8%AD%E5%9B%BD <br>
	 * 
	 * @param url
	 * @return
	 */
	public static String URLEncoder(String url) {
		try {
			return URLEncoder.encode(url, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error("url:{}", url, e);
			return "/";
		}
	}

	/**
	 * String mytext2 = URLDecoder.decode("%E4%B8%AD%E5%9B%BD", "utf-8");<br>
	 * mytex2: 中国 <br>
	 * 
	 * @param url
	 * @return
	 */
	public static String URLDecoder(String url) {
		try {
			return URLDecoder.decode(url, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error("url:{}", url, e);
			return "/";
		}
	}

	/**
	 * 获取加密后的字符串
	 * 
	 * @param input
	 * @return
	 */
	public static String stringMD5(String pw) {
		try {

			// 拿到一个MD5转换器（如果想要SHA1参数换成”SHA1”）
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			// 输入的字符串转换成字节数组
			byte[] inputByteArray = pw.getBytes();
			// inputByteArray是输入字符串转换得到的字节数组
			messageDigest.update(inputByteArray);
			// 转换并返回结果，也是字节数组，包含16个元素
			byte[] resultByteArray = messageDigest.digest();
			// 字符数组转换成字符串返回
			return byteArrayToHex(resultByteArray);
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

	public static String byteArrayToHex(byte[] byteArray) {

		// 首先初始化一个字符数组，用来存放每个16进制字符
		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		// new一个字符数组，这个就是用来组成结果字符串的（解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方））
		char[] resultCharArray = new char[byteArray.length * 2];
		// 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去
		int index = 0;
		for (byte b : byteArray) {
			resultCharArray[index++] = hexDigits[b >>> 4 & 0xf];
			resultCharArray[index++] = hexDigits[b & 0xf];
		}
		// 字符数组组合成字符串返回
		return new String(resultCharArray);
	}

	public static Date setNowTime(int h, int m, int s) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.HOUR_OF_DAY, h);
		cal.set(Calendar.MINUTE, m);
		cal.set(Calendar.SECOND, s);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static List<String> localHostAddress() {
		List<String> list = new ArrayList<String>();
		Enumeration<NetworkInterface> allNetInterfaces = null;
		try {
			allNetInterfaces = NetworkInterface.getNetworkInterfaces();
		} catch (java.net.SocketException e) {
			e.printStackTrace();
		}
		InetAddress ip = null;
		while (allNetInterfaces.hasMoreElements()) {
			NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
			Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
			while (addresses.hasMoreElements()) {
				ip = addresses.nextElement();
				if (ip != null && ip instanceof Inet4Address) {
					list.add(ip.getHostAddress());
				}
			}
		}
		return list;
	}

	public static void sendsms(String key, String url, String phone, String msg) throws Exception {
		HttpClientBuilder hh = HttpClientBuilder.create();
		CloseableHttpClient httpclient = hh.build();
		try {
			HttpPost httpost = new HttpPost(url);

			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			// 提交两个参数及值
			nvps.add(new BasicNameValuePair("key", key));
			nvps.add(new BasicNameValuePair("mobiles[]", phone));
			nvps.add(new BasicNameValuePair("content", msg));
			httpost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
			HttpResponse response = httpclient.execute(httpost);
			HttpEntity entity = response.getEntity();
			InputStream aaa = entity.getContent();

			// logger.info("getStatusLine {}", response.getStatusLine());
			EntityUtils.consume(entity);
		} finally {

			httpclient.close();
		}

	}

	public static String buildLink(HttpServletRequest request, String link) {
		try {
			URL localhost = new URL(request.getRequestURL().toString());
			URL url = new URL(localhost, link);
			return url.toString();
		} catch (MalformedURLException e) {
			logger.error("getRequestURL:{},link: {},getMessage:{}", request.getRequestURL(), link, e.getMessage(), e);
		}
		return null;
	}
}
