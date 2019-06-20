package test.open;
import com.rfchina.community.openstore.service.OpenStoreGoodOrderRelService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class TestOpenStoreGoodOrderRelService extends TestBase {
    @Autowired
    public OpenStoreGoodOrderRelService openStoreGoodOrderRelService;
    @Test
    public void getlist(){System.out.println(openStoreGoodOrderRelService.getList(2));}

    @Test
    public void getVOList(){System.out.println(openStoreGoodOrderRelService.getVOList(1));}

    @Test
    public void getImgList(){System.out.println(openStoreGoodOrderRelService.getImgList(1));}

    @Test
    public void update(){openStoreGoodOrderRelService.update(1,1l,1,new BigDecimal(1),new BigDecimal(1),1);}











}
