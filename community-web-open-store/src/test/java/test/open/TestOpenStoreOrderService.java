package test.open;

import com.rfchina.community.openstore.service.OpenStoreOrderService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestOpenStoreOrderService extends TestBase {
    @Autowired
    OpenStoreOrderService openStoreOrderService;
    @Test
    public void list(){System.out.println(openStoreOrderService.list(32636L,5,1,5));}
    @Test
    public void countByUserId(){System.out.println(openStoreOrderService.countByUserId(32636L));}

    @Test
    public void getDetail(){System.out.println(openStoreOrderService.getDetail(1,32636L));}

    @Test
    public void getDetailByCommunityOutTradeNo(){System.out.println(openStoreOrderService.getDetailByCommunityOutTradeNo("life_18051915121623182697852"));}

    @Test
    public void getPayDetail(){System.out.println(openStoreOrderService.getPayDetail("THIRD_STORE_PAY_1783893433198964284423527"));}

    @Test
    public void createOrderCode(){System.out.println(openStoreOrderService.createOrderCode(112242));}

    @Test
    public void getOpenStoreOrder(){System.out.println(openStoreOrderService.getOpenStoreOrder(1));}


    @Test
    public void  test(){
        System.out.println(openStoreOrderService.getGoodPayTimes(1, 1, 1L));
    }




}
