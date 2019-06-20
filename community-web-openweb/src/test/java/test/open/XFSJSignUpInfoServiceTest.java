package test.open;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rfchina.community.openweb.CommunityOpenWebApplication;
import com.rfchina.community.openweb.service.XFSJBusinessInfoService;
import com.rfchina.community.openweb.service.XFSJSignUpInfoService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CommunityOpenWebApplication.class})
public class XFSJSignUpInfoServiceTest {
	@Autowired
	private XFSJSignUpInfoService signUpInfoService;
	
	@Test
	public void signUp() {
		signUpInfoService.signUp(102L,1, 1008L);
	}
}