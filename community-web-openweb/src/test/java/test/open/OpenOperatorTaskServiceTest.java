package test.open;

import com.rfchina.community.openweb.CommunityOpenWebApplication;
import com.rfchina.community.openweb.service.OpenOperatorTaskService;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CommunityOpenWebApplication.class})
public class OpenOperatorTaskServiceTest {
	@Autowired
	private OpenOperatorTaskService openOperatorTaskService;

	@Test
	@Ignore
	public void operatorList() {
		System.out.println(openOperatorTaskService.operatorList(71,null,null,
				1,10));
	}

	@Test
	public void test() {
		System.out.println(DigestUtils.sha256Hex("12345678"));
	}

	
}