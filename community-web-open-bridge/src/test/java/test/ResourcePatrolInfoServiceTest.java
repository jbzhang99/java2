package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rfchina.community.open.bridge.RfCommunityOpenBridgeApiApplication;
import com.rfchina.community.open.bridge.service.ResourcePatrolInfoService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RfCommunityOpenBridgeApiApplication.class})
public class ResourcePatrolInfoServiceTest {
	@Autowired
	private ResourcePatrolInfoService resourcePatrolInfoService;
	
	@Test
	public void initPatrolInfo() {
		resourcePatrolInfoService.initPatrolInfo(1002L, 2);
	}
	
}