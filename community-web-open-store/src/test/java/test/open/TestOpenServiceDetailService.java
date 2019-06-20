package test.open;

import com.rfchina.community.openstore.service.OpenServiceDetailService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestOpenServiceDetailService extends TestBase {
    @Autowired
    OpenServiceDetailService openServiceDetailService;
    @Test
    public void isTemplete(){System.out.println(openServiceDetailService.isTemplete(1));}

    @Test
    public void hadCheck(){System.out.println(openServiceDetailService.hadCheck(1));}

    @Test
    public void getByServiceId(){System.out.println(openServiceDetailService.getByServiceId(1));}
}
