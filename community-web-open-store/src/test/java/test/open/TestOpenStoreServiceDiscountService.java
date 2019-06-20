package test.open;

import com.rfchina.community.openstore.service.OpenStoreServiceDiscountService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class TestOpenStoreServiceDiscountService extends TestBase {
    @Autowired
    public OpenStoreServiceDiscountService openStoreServiceDiscountService;
    @Test
    public void getByServiceId(){
        System.out.println(openStoreServiceDiscountService.getByServiceId(1));
    }

    @Test
    public void getDiscountPrice(){
        System.out.println(openStoreServiceDiscountService.getDiscountPrice(new BigDecimal(1),1));
    }
}
