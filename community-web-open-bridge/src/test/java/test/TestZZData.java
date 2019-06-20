package test;

import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.open.bridge.RfCommunityOpenBridgeApiApplication;
import com.rfchina.community.open.bridge.service.ExtOpenStatsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RfCommunityOpenBridgeApiApplication.class )
public class TestZZData {
	@Autowired
	private ExtOpenStatsService extOpenStatsService;

	@Test
	public void testZZServiceTotalData() {
		System.out.println(JSONObject.toJSONString(extOpenStatsService.getZZServiceTotalData()));
	}
}