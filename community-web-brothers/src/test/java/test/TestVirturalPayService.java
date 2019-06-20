package test;

import com.rfchina.community.service.openser.OpenStoreGroupDataSerService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestVirturalPayService extends TestBase{
    @Autowired
    public OpenStoreGroupDataSerService openStoreGroupDataSerService;

    @Test
    public void getCommunity(){
        openStoreGroupDataSerService.virtualJoinInGroupPay();
    }

}
