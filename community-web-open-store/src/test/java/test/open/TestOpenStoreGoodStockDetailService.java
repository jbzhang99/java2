package test.open;

import com.rfchina.community.base.OpenGoodGroupConstant;
import com.rfchina.community.openstore.entity.ext.ParamOpenStoreGood;
import com.rfchina.community.service.openser.OpenStoreGoodStockDetailService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
public class TestOpenStoreGoodStockDetailService extends TestBase{
    @Autowired
    public OpenStoreGoodStockDetailService openStoreGoodStockDetailService;
    @Test
    public void insert(){
        ParamOpenStoreGood good = new ParamOpenStoreGood();
        good.setStock(2);
        good.setGroupInfoId(1);
        good.setGroupStockStatus(OpenGoodGroupConstant.groupStockStatus.group_stock);


//        openStoreGoodStockDetailService.insert(good,1,"1","1",1);
    }
}
