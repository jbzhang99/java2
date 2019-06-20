package test.open;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rfchina.community.component.HttpClientComponent;
import com.rfchina.community.openstore.service.OpenConfService;

public class TestOpenConfService extends TestBase{
	@Autowired
	public OpenConfService openConfService;
	@Autowired
	public HttpClientComponent httpClientComponent;
	
	@Test
	
	public void getOpenPoint() {
		BigDecimal discountMoney = new BigDecimal(100);
		BigDecimal serverGoodTotal = new BigDecimal(300.01);
		BigDecimal discountPrice = new BigDecimal(300.00);
		System.out.println(serverGoodTotal.divide(discountPrice, 0, BigDecimal.ROUND_DOWN));
		BigDecimal sumDiscountMoney = discountMoney.multiply(
				new BigDecimal(serverGoodTotal.divide(discountPrice, 2, BigDecimal.ROUND_HALF_DOWN).intValue())
			);
		BigDecimal price = new BigDecimal(2.99);
		System.out.println(sumDiscountMoney);
//		System.out.println(openConfService.getOpenPoint(price));
	}


	@Test
	@Ignore
	public void getOpenStr() {
		long orderId = 1684;
		System.out.println(openConfService.getOpenPointByOrderId(orderId, 123L));
	}
	@Test
	public void isFirst(){System.out.println(openConfService.isFirst(1l));}

	@Test
	public void test() {
		String url = "http://callback.test.thinkinpower.net/ServletCallBack/CallBackServlet";
		Map<String, String> map = new HashMap<String, String>();
		map.put("123", "123");
		map.put("456", "456");
		map.put("789", "789");
		try {
			HttpClientComponent.send(url, map, "UTF-8");
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		System.out.println(httpClientComponent.postTestConnection(url, "{\"community_trade_no\":\"life_18062518470812731865670\",\"out_trade_no\":\"STORE_374252451560706176707007362\",\"total_amount\":\"2\",\"notify_scene\":\"TRADE_PAID_SUCCESS\",\"refund_fee\":\"2\",\"trade_status\":\"TRADE_PAID_SUCCESS\",\"pay_channel\":\"AliPay\",\"receipt_amount\":\"2\",\"pay_time\":\"1529923628193\"}"));
	}
}