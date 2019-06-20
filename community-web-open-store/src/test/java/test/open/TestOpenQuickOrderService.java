package test.open;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.rfchina.community.openstore.service.OpenQuickOrderService;
import com.rfchina.community.persistence.model.ext.ExtOpenQuickOrder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class TestOpenQuickOrderService extends TestBase{
    @Autowired
    public OpenQuickOrderService openQuickOrderService;
    @Test
    public void listQuickOrder(){
        Map<String, Object> example = new HashMap<>();
        PageInfo<ExtOpenQuickOrder> data = openQuickOrderService.listQuickOrder(example, 1, 10, true);
        System.out.println(JSON.toJSONString(data));
    }

    @Test
    public void getQuickOrder(){System.out.println(openQuickOrderService.getQuickOrder(1l,1,1l));}
}
