package test.open.email;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rfchina.community.component.JavaMailComponent;
import com.rfchina.community.openstore.CommunityOpenStoreApplication;
/**
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CommunityOpenStoreApplication.class})
public class DataLoadComponentTest {

	@Autowired
	private JavaMailComponent javaMailComponent;

	@Test
	public void testSendEmail() throws Exception {
		String template = "test.ftl";
		Map<String, Object> model = new HashMap<>();
//		javaMailComponent.sendEmail("liyicun@qq.com", "标题：发送Html内容" + RandomStringUtils.randomAlphanumeric(30), template, model);
	}
}
