package test;

import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.open.bridge.RfCommunityOpenBridgeApiApplication;
import com.rfchina.community.open.bridge.mapper.ext.ExtOpenOrderFinanceMapper;
import com.rfchina.community.open.bridge.service.OpenRefundService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * @ClassName OpenRefundServiceTest
 * @Description TODO
 * @Author wlrllr
 * @Date 2019/1/4 15:42
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { RfCommunityOpenBridgeApiApplication.class })
public class OpenRefundServiceTest {

    @Autowired
    private OpenRefundService openRefundService;
    @Autowired
    private ExtOpenOrderFinanceMapper extOpenOrderFinanceMapper;


    /**
     * @Author wlrllr
     * @Description //校验详情
     * @Date 2019/1/4
     * @Param []
     * @return void
     **/
    @Test
    public void testRefundDetail(){
        JSONObject result = openRefundService.getRefundDetailAndAuditList(1);
        System.out.println(result.toJSONString());
    }

    @Test
    public void testOrderFinance(){
        List<Map<String, Object>> list = extOpenOrderFinanceMapper.listOrderFinance(null, null, 0, 10);
        System.out.println(JSONObject.toJSONString(list));
    }

}
