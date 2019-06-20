package test;

import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.open.bridge.RfCommunityOpenBridgeApiApplication;
import com.rfchina.community.open.bridge.service.ExtOpenStatsService;
import com.rfchina.community.open.bridge.service.OpenOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RfCommunityOpenBridgeApiApplication.class )
public class TestOpenOrderService {
	@Autowired
	private OpenOrderService openOrderService;

	@Test
	public void testUpdateRefundStatus() {
		openOrderService.updateRefundStatus("02011201901255772851504160001195","02011201901265772851416090000790",6);
	}
}