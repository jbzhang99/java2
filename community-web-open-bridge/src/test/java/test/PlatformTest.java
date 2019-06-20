package test;

import com.rfchina.api.ApiClient;
import com.rfchina.api.request.app.GetAccessTokenRequest;
import com.rfchina.api.response.ResponseData;
import com.rfchina.api.response.model.app.GetAccessTokenReponseModel;
import com.rfchina.community.component.PlatformGlobalComponent;
import com.rfchina.community.open.bridge.RfCommunityOpenBridgeApiApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RfCommunityOpenBridgeApiApplication.class})
public class PlatformTest {
	@Autowired
	private PlatformGlobalComponent platformGlobalComponent;
	ApiClient apiClient = null;

	String accessToken;



	@Before
	public void setUp() throws Exception {
		//String rfpayHost = "http://test.p.rfmember.net";
		String rfpayHost = "http://192.168.197.28:10000";
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
	private void business_confirm_record(){

	}
}
