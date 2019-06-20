package test.open;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rfchina.community.base.OpenXFSJConstant;
import com.rfchina.community.openweb.CommunityOpenWebApplication;
import com.rfchina.community.openweb.service.XFSJBusinessInfoService;
import com.rfchina.community.service.openser.OpenStoreVerifyCardService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CommunityOpenWebApplication.class})
public class OpenXFSJBusinessInfoServiceTest {
	@Autowired
	private XFSJBusinessInfoService businessInfoService;
	@Autowired
	private OpenStoreVerifyCardService openStoreVerifyCardService;
	
	@Test
	@Ignore
	public void listBusinessInfo() {
		System.out.println(businessInfoService.listBusinessInfo(1008L, 110000, 1, null, null,0, 0,0,OpenXFSJConstant.ActivityType.community,
				1, 10));
	}
	
	@Test
	@Ignore
	public void listMyBusinessInfo() {
		System.out.println(businessInfoService.listMyBusinessInfo(100,110000, 1, "", null, 0,0,
				1, 10));
	}
	
	@Test
	@Ignore
	public void getOpenXFSJBusinessInfo() {
		System.out.println(businessInfoService.getOpenXFSJBusinessInfo(1008L, 1L,0));
	}
	
	@Test
	public void verify() {
		openStoreVerifyCardService.verify(1L, 413);
	}
}