package test.open;

import com.rfchina.community.openweb.CommunityOpenWebApplication;
import com.rfchina.community.openweb.controller.OpenOrderController;
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
public class OpenOrderServiceTest {
	@Autowired
	private OpenOrderController openOrderController;

	@Test
	public void exportDataTest() {
		openOrderController.exportOrder(null,
				null,
				null,
				null,
		890,
		2,
				0,
				0,
				null,
				null);
	}

	@Test
	public void test() {
		System.out.println(DigestUtils.sha256Hex("12345678"));
	}

	
}