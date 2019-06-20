package test.open;

import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import okhttp3.FormBody.Builder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HttpclientTC {

	public static void main(String[] args) throws IOException {
		HttpclientTC a = new HttpclientTC();

		String login = "http://open.zizai.thinkinpower.com/api/openweb/acc/login";
		//fas方式上传
		String uploadUrl = "http://open.zizai.thinkinpower.com/api/openweb/upload_image";

		JSONObject json = new JSONObject();
		json.put("userName", "489503330@qq.com");
		json.put("passwd", "12345678");
		String result = a.post(login, json);
		System.out.println(result);

		JSONObject json1 = new JSONObject();
		json1.put("type", "system");
		json1.put("isThumbnail", "0");

		File rootFile = new File("e:/upload");
		for (File file : rootFile.listFiles()) {

			String result1 = a.postFile(uploadUrl, "upload_file", file, json1);

			System.out.println(file.getName() + "\t" + result1);
		}
	}

	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
	private final HashMap<String, List<Cookie>> cookieStore = new HashMap<>();

	OkHttpClient client = new OkHttpClient.Builder().cookieJar(new CookieJar() {
		@Override
		public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
			cookieStore.put(httpUrl.host(), list);
		}

		@Override
		public List<Cookie> loadForRequest(HttpUrl httpUrl) {
			List<Cookie> cookies = cookieStore.get(httpUrl.host());
			return cookies != null ? cookies : new ArrayList<Cookie>();
		}
	}).build();

	String post(String url, JSONObject json) throws IOException {
		Builder builder = new FormBody.Builder();
		for (String key : json.keySet()) {
			Object obj = json.get(key);
			if (obj != null) {
				builder.add(key, obj.toString());
			}
		}
		RequestBody formBody = builder.build();

		Request request = new Request.Builder().url(url).post(formBody).build();
		Response response = client.newCall(request).execute();
		return response.body().string();
	}

	String postFile(String url, String filename, File filepath, JSONObject json) throws IOException {
		// File file1 = new File(filepath);
		RequestBody fileBody = RequestBody.create(MediaType.parse("image/png"), filepath);
		okhttp3.MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM)
				.addFormDataPart(filename, filepath.getName(), fileBody);
		for (String key : json.keySet()) {
			Object obj = json.get(key);
			if (obj != null) {
				builder.addFormDataPart(key, obj.toString());
			}
		}
		RequestBody formBody = builder.build();

		Request request = new Request.Builder().url(url).post(formBody).build();
		Response response = client.newCall(request).execute();
		return response.body().string();
	}
}
