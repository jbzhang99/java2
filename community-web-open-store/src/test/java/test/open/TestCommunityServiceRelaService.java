package test.open;

import com.rfchina.community.openstore.service.CommunityServiceRelaService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestCommunityServiceRelaService extends TestBase {
    @Autowired
    public CommunityServiceRelaService communityServiceRelaService;
    @Test
    public void isRelate(){System.out.println(communityServiceRelaService.isRelate(1,1));}

    @Test
    public void checkCount(){System.out.println(communityServiceRelaService.checkCount(1,1));}

    @Test
    public void checkService(){System.out.println(communityServiceRelaService.checkService(1,1));}
}
