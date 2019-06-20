package test;

import com.rfchina.community.open.bridge.RfCommunityOpenBridgeApiApplication;
import com.rfchina.community.open.bridge.service.OpenXFSJActivityService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RfCommunityOpenBridgeApiApplication.class})
public class OpenPlatformActivityServiceTest {
	@Autowired
	private OpenXFSJActivityService openXFSJActivityService;
	
	@Test
	@Ignore
	public void listPlatformActivity() {
		System.out.println(openXFSJActivityService.listPlatformActivity(440100,"", null,0,0,1, 10).convert());
	}
	
	@Test
	@Ignore
	public void createOpenXFSJInfo() {
		Date now =  new Date();
		System.out.println(openXFSJActivityService.createOpenXFSJInfo("community", 0, 1, "123",
				"http://192.168.197.28:10086/G1/M00/00/29/wKjFHFnIqACASc0qAA1rIuRd3Es412.jpg", 
				"qijian", "单元测试",
				"1",now , now, now, 1, new BigDecimal(0.01),
				"1,2", "http://192.168.197.28:10086/G1/M00/00/29/wKjFHFnIqACASc0qAA1rIuRd3Es412.jpg", "1", "15915735055", "", 0L, 0L));
	}
	@Test
	@Ignore
	public void createPlatformActivity() {
		Date now =  new Date();
		System.out.println(openXFSJActivityService.createPlatformActivity("platform", 45, 1, "单元",
				"http://192.168.197.28:10086/G1/M00/00/29/wKjFHFnIqACASc0qAA1rIuRd3Es412.jpg", 
				"单元测试",
				"1", now, now));
	}
	
	@Test
	@Ignore
	public void getPatrolInfo() {
		System.out.println(openXFSJActivityService.getPatrolInfo(1013L));
	}



	@Test
	@Ignore
	public void listValidActivity() {
		System.out.println(openXFSJActivityService.listValidActivity(null,1,1,10));
	}

	@Test
	public void getStoreList() {
		System.out.println(openXFSJActivityService.getStoreList(1015));
	}
}