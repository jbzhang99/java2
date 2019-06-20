package test.open;

import com.rfchina.community.openstore.service.CommunityService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestCommunityService extends TestBase{
    @Autowired
    public CommunityService communityService;

    @Test
    public void getCommunity(){System.out.println(communityService.getCommunity(1));}

    @Test
    public void getXFSJCommunity(){System.out.println(communityService.getXFSJCommunity(1l,"1","1",1,2));}

    @Test
    public void getCommunityAttentionCount(){System.out.println(communityService.getCommunityAttentionCount(1));}

    @Test
    public void isMasterUser(){System.out.println(communityService.isMasterUser(1l,1));}

    @Test
    public void isCommunityAttention(){System.out.println(communityService.isCommunityAttention(1L,1));}
}
