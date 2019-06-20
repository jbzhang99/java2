package test.open;

import com.rfchina.community.openstore.service.OpenStoreServiceTempleteService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestOpenStoreServiceTempleteService extends TestBase {
    @Autowired
    public OpenStoreServiceTempleteService openStoreServiceTempleteService;
    @Test
    public void getTempleteInfo(){System.out.println(openStoreServiceTempleteService.getTempleteInfo(45));}

    @Test
    public void isExist(){System.out.println(openStoreServiceTempleteService.isExist(35));}

    @Test
    public void getOpenStoreServiceDiscount(){System.out.println(openStoreServiceTempleteService.getOpenStoreServiceDiscount(45));}
}
