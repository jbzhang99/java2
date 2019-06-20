package test.open;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.rfchina.api.ApiClient;
import com.rfchina.api.request.app.CreateServiceRequest;
import com.rfchina.api.request.app.GetAccessTokenRequest;
import com.rfchina.api.request.app.GetAppServiceListRequest;
import com.rfchina.api.response.ResponseData;
import com.rfchina.api.response.model.app.CreateServiceResponseModel;
import com.rfchina.api.response.model.app.GetAccessTokenReponseModel;
import com.rfchina.api.response.model.app.GetAppServiceListResponseModel;
import com.rfchina.api.response.model.app.base.ServiceModel;

public class PlatformTest {

	ApiClient apiClient = null;

	String accessToken;

	@Before
	public void setUp() throws Exception {
		String rfpayHost = "http://test.p.rfmember.net";
		Long rfpayAppId = 99831765L;
		String rfpayAppSecret = "280d01d54adfb4da142b055fef91535d";
		apiClient = new ApiClient(rfpayHost, rfpayAppId, rfpayAppSecret);
		GetAccessTokenRequest request = new GetAccessTokenRequest(rfpayAppId, rfpayAppSecret);
		ResponseData<GetAccessTokenReponseModel> req = apiClient.execute(request);
//		SERVICE ID：
//		75488384
//		SERVICE KEY：
//		231179e04dd14ef86c53a44447cb0c92
		accessToken = req.getData().getAccessToken();
	}

	@Test
	public void test() {

		// platform.admin.appId=99831765
		// platform.admin.appSecret=280d01d54adfb4da142b055fef91535d
		// #platform.admin.appId=42682567
		// #platform.admin.appSecret=e05e7af563d9f94dc26d942363e45fa4
		// platform.host=http://test.p.rfmember.net

		// GetServiceListRequest req = new GetServiceListRequest(accessToken,
		// title, status);
		// System.out.println(JSON.toJSONString(req));

		long rfpayAppId = 99831765L;

		GetAppServiceListResponseModel list = getCatalogListRequest(accessToken, rfpayAppId);
		for (ServiceModel serviceModel : list) {
			System.out.println(JSON.toJSONString(serviceModel));
		}

		Integer serviceId = 100;

		String title = "自在信息查询分组";
		String desc = "自在支付接口分组";
		createServiceRequest(accessToken, serviceId, title, desc);

	}

	private GetAppServiceListResponseModel getCatalogListRequest(String accessToken, long rfpayAppId) {

		GetAppServiceListRequest req1 = new GetAppServiceListRequest(accessToken, rfpayAppId, null);
		ResponseData<GetAppServiceListResponseModel> aa = apiClient.execute(req1);
		System.out.println(JSON.toJSONString(aa));
		return aa.getData();

	}

	private CreateServiceResponseModel createServiceRequest(String accessToken, Integer serviceId, String title,
			String desc) {
		CreateServiceRequest req = new CreateServiceRequest(accessToken, serviceId, title, desc);

		ResponseData<CreateServiceResponseModel> aa = apiClient.execute(req);
		System.out.println(JSON.toJSONString(aa));
		return aa.getData();
	}

}
