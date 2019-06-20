package test.open;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rfchina.community.openweb.CommunityOpenWebApplication;
import com.rfchina.community.openweb.service.OpenXFSJActivityService;
import com.rfchina.community.persistence.mapper.OpenOrderTotalMapper;
import com.rfchina.community.persistence.model.OpenOrderTotal;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CommunityOpenWebApplication.class})
public class OpenXFSJActivityServiceTest {
	@Autowired
	private OpenXFSJActivityService openXFSJActivityService;
	@Autowired
	private OpenOrderTotalMapper openOrderTotalMapper;
	
	@Test
	@Ignore
	public void listOpenXFSJStoreGood() {
		System.out.println(openXFSJActivityService.listOpenXFSJStoreGood(1007L, 40));
	}
	@Test
	public void createOpenXFSJStoreGood() {
		openXFSJActivityService.createOpenXFSJStoreGood(1007L, 28, 40);
	}
	@Test
	@Ignore
	public void signUp() {
		System.out.println(openXFSJActivityService.deleteOpenXFSJStoreGood(5051L));
	}
	
	@Test
	public void test() {
		OpenOrderTotal oot = new OpenOrderTotal();
		oot.setId(10056L);
		oot.setRefundCount(1);
		openOrderTotalMapper.updateByPrimaryKeySelective(oot);
	}
	
}