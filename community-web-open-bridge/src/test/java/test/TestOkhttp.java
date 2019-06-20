package test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import okhttp3.FormBody;
import okhttp3.FormBody.Builder;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class TestOkhttp {

	@Before
	public void setUp() throws Exception {
		Interceptor interceptor;
		client = new OkHttpClient.Builder().proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 8888)))
				// .addInterceptor(interceptor)
				.build();

	}

	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

	// OkHttpClient client = new OkHttpClient();
	OkHttpClient client;

	@Test
	public void test() throws IOException {
		// Proxy p = client.proxy();

		// System.out.println(p.address());
		//String json = "{\"p21\":\"w10\",\"__admin_id\":\"21783\",\"__community_id\":\"null\"}";
		String url = "http://o.zizai.test.thinkinpower.net//api/platform/open/bridgeapi/test";
		
		for (int i = 0; i < 10; i++) {
			//json = bowlingJson("Jesse", "Jake");
			
			Map<String, String> json=new HashMap<>();
			json.put("ssss", "ffffff");
			json.put("ss1ss", "fff3fff");
			json.put("ss2ss", "fff54fff");
			json.put("ss4ss", "fff76fff");
			json.put("ss5ss", "fff8fff");
			String con = post(url, json);
			System.out.println(con);
		}

	}

	String bowlingJson(String player1, String player2) {
		return "{'winCondition':'HIGH_SCORE'," + "'name':'Bowling'," + "'round':4," + "'lastSaved':1367702411696,"
				+ "'dateStarted':1367702378785," + "'players':[" + "{'name':'" + player1
				+ "','history':[10,8,6,7,8],'color':-13388315,'total':39}," + "{'name':'" + player2
				+ "','history':[6,10,5,10,10],'color':-48060,'total':41}" + "]}";
	}

	String post(String url, Map<String, String> json) throws IOException {
		// RequestBody body = RequestBody.create(JSON, json);
		// System.out.println(body.contentLength());
		Builder builder = new FormBody.Builder();
		json.forEach((k, v) -> {
			builder.add(k, v);
		});
		RequestBody formBody = builder.build();

		Request request = new Request.Builder().url(url).post(formBody).build();

		Response response = client.newCall(request).execute();
		return response.body().string();
	}
}
