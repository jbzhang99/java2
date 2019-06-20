package test.open.service;

import com.rfchina.community.openstore.CommunityOpenStoreApplication;
import com.rfchina.community.service.SmsGlobalService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName OrderGroupServiceTest
 * @Description 拼团测试用例
 * @Author wlrllr
 * @Date 2019/5/28 17:53
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { CommunityOpenStoreApplication.class })
public class OrderGroupServiceTest {
    @Autowired
    private SmsGlobalService smsGlobalService;
    @Test
    public void testSendMsg(){
        smsGlobalService.sendSms("15011851446", SmsGlobalService.SmsType.group_complete_success,
                "测试商品", 123, 1);
    }
}
