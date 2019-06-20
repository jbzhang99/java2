package test.open;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.rfchina.community.openstore.CommunityOpenStoreApplication;
import com.rfchina.community.openstore.service.CommunityService;
import com.rfchina.community.openstore.service.OpenStoreOrderService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CommunityOpenStoreApplication.class})
public class OpenQuickOrderServiceTest {
	@Autowired
	private CommunityService communityService;
	@Autowired
	private OpenStoreOrderService openStoreOrderService;


	@Test
	@Rollback(false)
	public void testCartList() {
		System.out.println(communityService.getXFSJCommunity(30434L, null, null, 1, 1000));
	}

	@Test
	public void getCommunityAttentionCount(){System.out.println(communityService.getCommunityAttentionCount(1));}

	@Test
	public void isMasterUser(){System.out.println(communityService.isMasterUser(1L,1));}

	@Test
	public void isCommunityAttention(){System.out.println(communityService.isCommunityAttention(76l,1));}



	
	
}