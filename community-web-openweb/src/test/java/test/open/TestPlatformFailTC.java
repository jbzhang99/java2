//package test.open;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//
//import okhttp3.Cookie;
//import okhttp3.CookieJar;
//import okhttp3.HttpUrl;
//import okhttp3.MediaType;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.RequestBody;
//import okhttp3.Response;
///**
// * @author:fukangwen
// * @Description: 支付中心对账失败条数，以当前时间往前推，多少天根据循环来设定
// */
//public class TestPlatformFailTC {
//public static final MediaType TEXT_MEDIA = MediaType.parse("application/x-www-form-urlencoded; charset=UTF-8");
//public static String URL = "http://test.report.p.rfmember.net";
//public static final ThreadLocal okHttpClient = new ThreadLocal () {
////
//public OkHttpClient initialValue() {//
//	// return new OkHttpClient();
//	OkHttpClient client = new OkHttpClient.Builder().cookieJar(new CookieJar() {
//	private final HashMap<String, List<Cookie>> cookieStore = new HashMap<>();
//			@Override
//			public void saveFromResponse(HttpUrl url, List cookies) {
//				System.out.println("saveFromResponse invoked..."+url.host());
//				System.out.println("url--->"+url +" ; cookies:--->"+cookies);
//				cookieStore.put(url.host(), cookies);
//			}
//			@Override
//			public List loadForRequest(HttpUrl url) {
//				List cookies = cookieStore.get(url.host());
//				return cookies != null ? cookies : new ArrayList ();
//			}
//		}).build();
//	return client;
//	}
//};
//public static void main(String[] args) throws Exception {
//// 1)signin
//	String sessionId = signin("rfchina", "rfchina123", "/rfpay_report/system/user/login");
//// 2)session---保持会话用
//	if (null != sessionId && sessionId.trim().length() > 0) {
//		new Thread(new Runnable() {// 开启session保持线程
//		@Override
//		public void run() {
//			while (true) {// 保证不停的执行
//				try {
//					// getAppList(sessionId, "/api/app/list");//
//					// 间歇性获取appList
//					Thread.currentThread().sleep(6 * 1000);
//				} catch (Exception e) {
//				}
//			}
//		}
//		}).start();
//	}
//	// 3)登陆之后,获取所有app
////	getList(sessionId, "/rfpay_report/pay/bussiness_balance_result");
//	getFailDate(sessionId, "/rfpay_report/pay/bussiness_balance_stat");
//}
//
//private static String cookieHeader(List<Cookie> cookies) {
//	StringBuilder cookieHeader = new StringBuilder();
//	for (int i = 0, size = cookies.size(); i < size; i++) {
//		if (i > 0) {
//			cookieHeader.append("; ");
//		}
//		Cookie cookie = cookies.get(i);
//		cookieHeader.append(cookie.name()).append('=').append(cookie.value());
//	}
//	return cookieHeader.toString();
//}
//public static String signin(String name, String password, String uri) throws Exception {
//	// 构造HTTP请求
//	RequestBody requestBody = RequestBody.create(TEXT_MEDIA,
//	"uname=" + name + "&passwd=" + password);
//	Request.Builder builder = new Request.Builder();
//	Request request = builder.url(URL + uri).post(requestBody).build();
//	// 获取结果
//	Response response = ((OkHttpClient) okHttpClient.get()).newCall(request).execute();
//	boolean success = response.isSuccessful();
//	String body = response.body().string();
//	if (false == success) {
//	throw new Exception("fail to signin--->" + body);
//	}
//	System.out.println("success to login/n" + body);
//	// {"message":{},"sessionId":"929d2637-a49c-4228-a1b2-bb5246e6f462","success":"true","result":{"visitor":{"id":6,"name":"admin","role":null}}}
//	JSONObject responseObject = JSON.parseObject(body);// json字符串转换成jsonobject对象
//	String sessionId = (String) responseObject.get("sessionId");
//	System.out.println("/nsessionId ---> " + sessionId);
//	return sessionId;
//}
//// private static void session(String uri) throws Exception {
//// // 构造HTTP请求
//// Request request = new Request.Builder().url(URL + uri).get().build();
//// // 获取结果
//// Response response = okHttpClient.get().newCall(request).execute();
//// boolean success = response.isSuccessful();
//// String body = response.body().string();
//// if (false == success) {
//// throw new Exception("fail to session--->" + body);
//// }
//// System.out.println("success to session/n" + body);
////
//// }
//public static String format(Date date, String format) {
//	if (date == null)
//		return "";
//	return new SimpleDateFormat(format).format(date);
//}
//public static String DATE_FORMAT = "yyyy-MM-dd";
//
//public static String formatDate(Date date) {
//	return format(date, DATE_FORMAT);
//}
//
//private static String getFailDate(String sessionId, String uri) throws Exception {
//	SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
//	Calendar date = Calendar.getInstance();
//	Date now = new Date();
//	for(int i=0; i < 100; i++) {
//		RequestBody requestBody = RequestBody.create(TEXT_MEDIA,
//		"bill_date=" + formatDate(now)+ "&app_id=347285");
//		Request.Builder builder = new Request.Builder();
//		Request request = builder.url(URL + uri).post(requestBody).build();
//		// 获取结果
//		Response response = ((OkHttpClient) okHttpClient.get()).newCall(request).execute();
//		String body = response.body().string();
//		boolean success = response.isSuccessful();
//		if (false == success) {
//		throw new Exception("fail to getFailDate--->" + body);
//		}
//		System.out.println("success to getFailDate("+formatDate(now) +")" + body);
//
//		date.setTime(now);
//		date.set(Calendar.DATE, date.get(Calendar.DATE) - 1);
//		now = dft.parse(dft.format(date.getTime()));
//	}
//	return null;
//}
//private static String getList(String sessionId, String uri) throws Exception {
//	// 构造HTTP请求
//	RequestBody requestBody = RequestBody.create(TEXT_MEDIA,
//	"bill_date=" + "2018-07-04" + "&limit=10&offset=0&stat=true");
//	Request.Builder builder = new Request.Builder();
//	Request request = builder.url(URL + uri).post(requestBody).build();
//	// 获取结果
//	Response response = ((OkHttpClient) okHttpClient.get()).newCall(request).execute();
//	String body = response.body().string();
//	boolean success = response.isSuccessful();
//	if (false == success) {
//	throw new Exception("fail to getAppList--->" + body);
//	}
//	System.out.println("success to getAppList/n" + body);
//	return body;
//}
//}
