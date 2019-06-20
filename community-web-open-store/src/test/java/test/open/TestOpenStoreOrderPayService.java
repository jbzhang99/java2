package test.open;
import com.rfchina.community.openstore.service.OpenStoreOrderPayService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
public class TestOpenStoreOrderPayService extends TestBase{
    @Autowired
    public OpenStoreOrderPayService openStoreOrderPayService;
    @Test
    public void getByOutTradeNo(){System.out.println(openStoreOrderPayService.getByOutTradeNo("THIRD_STORE_PAY_1783893433198964284423527"));}

    @Test
    public void successPayByid(){System.out.println(openStoreOrderPayService.successPayByid(1,1));}

    @Test
    public void getById(){System.out.println(openStoreOrderPayService.getById(1));}

}
