package com.rfchina.community.component;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.rfchina.community.base.exception.WorkRunTimeException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;

@Component
public class HttpClientComponent{
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	public void postTestConnection(String url, String json, Callback call) {
		try {
			OkHttpClient.Builder mBuilder = new OkHttpClient.Builder();  
	        mBuilder.sslSocketFactory(createSSLSocketFactory());  
	        mBuilder.hostnameVerifier(new TrustAllHostnameVerifier());  
			OkHttpClient client = mBuilder.build();
			Builder builder = new Request.Builder().url(url);
			Request request = null;
			if (json != null) {
				RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
				request = builder.post(body).build();
			} else {
				request = builder.get().build();
			}

			Response response = client.newCall(request).execute();
			call.call(url, response);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}
	
	/**
	 * @author:fukangwen
	 * @Description: 测试地址是否通
	 * @return void
	 * @throws
	 */
	public String postTestConnection(String url, String json) {
		Response response = null;
		try {
			OkHttpClient.Builder mBuilder = new OkHttpClient.Builder();  
	        mBuilder.sslSocketFactory(createSSLSocketFactory());  
	        mBuilder.hostnameVerifier(new TrustAllHostnameVerifier());  
			OkHttpClient client = mBuilder.build();
			Builder builder = new Request.Builder().url(url);
			Request request = null;
			if (json != null) {
				RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
				request = builder.post(body).build();
			} else {
				request = builder.get().build();
			}

			response = client.newCall(request).execute();
			if(response.isSuccessful()) {
				return response.body().string();
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}finally {
			response.close();
		}
		return null;
	}
	
	
	/**
	 * 模拟请求
	 * 
	 * @param url	资源地址
	 * @param map	参数列表
	 * @param encoding	编码
	 * @return
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public static String send(String url, Map<String,String> map,String encoding) throws KeyManagementException, NoSuchAlgorithmException, ClientProtocolException, IOException {
		String body = "";
		//采用绕过验证的方式处理https请求
		SSLContext sslcontext = createIgnoreVerifySSL();
		
        // 设置协议http和https对应的处理socket链接工厂的对象
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
            .register("http", PlainConnectionSocketFactory.INSTANCE)
            .register("https", new SSLConnectionSocketFactory(sslcontext))
            .build();
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        HttpClients.custom().setConnectionManager(connManager);
 
        //创建自定义的httpclient对象
		CloseableHttpClient client = HttpClients.custom().setConnectionManager(connManager).build();
//		CloseableHttpClient client = HttpClients.createDefault();
		
		//创建post方式请求对象
		HttpPost httpPost = new HttpPost(url);
		
		//装填参数
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		if(map!=null){
			for (Entry<String, String> entry : map.entrySet()) {
				nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}
		}
		//设置参数到请求对象中
		httpPost.setEntity(new UrlEncodedFormEntity(nvps, encoding));
 
		//设置header信息
		//指定报文头【Content-type】、【User-Agent】
		httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
		httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
		
		//执行请求操作，并拿到结果（同步阻塞）
		CloseableHttpResponse response = client.execute(httpPost);
		//获取结果实体
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			//按指定编码转换结果实体为String类型
			body = EntityUtils.toString(entity, encoding);
		}
		EntityUtils.consume(entity);
		//释放链接
		response.close();
        return body;
	}
	
	/**
	 * 绕过验证
	 * 	
	 * @return
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 */
	public static SSLContext createIgnoreVerifySSL() throws NoSuchAlgorithmException, KeyManagementException {
		SSLContext sc = SSLContext.getInstance("SSLv3");
 
		// 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
		X509TrustManager trustManager = new X509TrustManager() {
			@Override
			public void checkClientTrusted(
					java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
					String paramString) throws CertificateException {
			}
 
			@Override
			public void checkServerTrusted(
					java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
					String paramString) throws CertificateException {
			}
 
			@Override
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		};
 
		sc.init(null, new TrustManager[] { trustManager }, null);
		return sc;
	}
	

	public interface Callback {
		public void call(String url, Response response) throws IOException;
	}
	
	private static class TrustAllCerts implements X509TrustManager {  
	    @Override  
	    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}  
	  
	    @Override  
	    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}  
	  
	    @Override  
	    public X509Certificate[] getAcceptedIssuers() {return new X509Certificate[0];}  
	}
	
    private static class TrustAllHostnameVerifier implements HostnameVerifier {  
        @Override  
        public boolean verify(String hostname, SSLSession session) {  
            return true;  
        }  
    }  
    
    
    private static SSLSocketFactory createSSLSocketFactory() {  
        SSLSocketFactory ssfFactory = null;  
      
        try {  
            SSLContext sc = SSLContext.getInstance("TLS");  
            sc.init(null,  new TrustManager[] { new TrustAllCerts() }, new SecureRandom());  
                  
            ssfFactory = sc.getSocketFactory();  
        } catch (Exception e) {  
        }  
      
        return ssfFactory;  
    }

}
