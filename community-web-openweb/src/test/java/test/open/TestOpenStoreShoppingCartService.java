package test.open;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.rfchina.api.util.SecurityCoder;
import com.rfchina.community.openweb.CommunityOpenWebApplication;
import com.rfchina.community.openweb.service.OpenStoreGoodService;
import com.rfchina.community.openweb.service.OpenStoreOrderService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CommunityOpenWebApplication.class})
public class TestOpenStoreShoppingCartService {
	@Autowired
	private OpenStoreGoodService openStoreGoodService;
	@Autowired
	private OpenStoreOrderService openStoreOrderService;


	@Test
	@Rollback(false)
	@Ignore
	public void testCartList() {
		openStoreGoodService.changeStatus(30, 3);
	}
	@Test
	public void pageQuery() {
		System.out.println(openStoreGoodService.pageQuery(59, null, null, 0,
				0L, null,null, null, 0, 10));
	}
	@Test
	public void countSaleAmount() {
		String password = "flzx3503hzj";
		String createTimeStr = "2017-06-30 15:39:56";
		String encryptPwd = SecurityCoder
				.md5((SecurityCoder.md5(password.getBytes()) + createTimeStr).getBytes());
		System.out.println(encryptPwd);
		
		//04e6cd6590caed3a2ff5faee565775f5
	}
//	@Test
//	public void test() {
//		File file = new File("D://test.jpg");
//		
//		File file2 = new File("D://test1.jpg");
//		ImageUtil.scale(file, file2, 1f);
//	}

	
	
}