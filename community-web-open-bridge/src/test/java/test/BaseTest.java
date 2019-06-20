package test;

import com.rfchina.community.open.bridge.RfCommunityOpenBridgeApiApplication;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName BaseTest
 * @Description TODO
 * @Author wlrllr
 * @Date 2019/6/12 10:45
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { RfCommunityOpenBridgeApiApplication.class},webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT)
public class BaseTest {

    @Autowired
    protected TestRestTemplate restTemplate;
}
