package test.open;

import com.rfchina.community.openstore.service.FuPayService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestFuPayService extends TestBase{
    @Autowired
    public FuPayService fupayservice;
    @Test
    public void getClientTicket(){System.out.println(fupayservice.getClientTicket(1));}
    @Test
    public void getUidFromOpenId(){System.out.println(fupayservice.getUidFromOpenId("fu_74427b4929ec0dc95ffa7476607c5c55",402));}
}
