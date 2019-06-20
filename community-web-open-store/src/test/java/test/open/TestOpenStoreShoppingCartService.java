package test.open;

import com.rfchina.community.openstore.CommunityOpenStoreApplication;
import com.rfchina.community.openstore.entity.ext.ParamOpenStoreGood;
import com.rfchina.community.openstore.service.*;
import com.rfchina.community.service.openser.OpenServiceBusinessService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CommunityOpenStoreApplication.class})
public class TestOpenStoreShoppingCartService {
	@Autowired
	private OpenStoreShoppingCartService openStoreShoppingCartService;
	@Autowired
	private OpenStoreGoodService openStoreGoodService;
	@Autowired
	private FuPayService fuPayService;
	@Autowired
	private OpenServiceDetailService openServiceDetailService;
	@Autowired
	private OpenStoreOrderService openStoreOrderService;

	@Autowired
	private OpenServiceBusinessService openServiceBusinessService;


	@Test

	@Rollback(false)
	public void testCartList() {
		System.out.println(openStoreShoppingCartService.cartList(1, 1L));
	}
	
	@Test
	@Ignore
	public void test() {
		fuPayService.getUidFromOpenId("fu_74427b4929ec0dc95ffa7476607c5c55",402);
	}
	
	@Test
	@Ignore
	public void testListGoodId() {
		System.out.println(openStoreGoodService.listGoodBeforePay("26"));
	}
	@Test
	@Ignore
	public void getByServiceId() {
		System.out.println(openServiceDetailService.getByServiceId(59));
	}

	@Test
	@Ignore
	public void createOrderCode() {
		System.out.println(openStoreOrderService.createOrderCode(2231231));
	}
	@Test
	@Ignore
	public void setCartAmount() {
		openStoreShoppingCartService.setCartAmount(1, 50);
	}
	@Test
	@Ignore
	public void getGoodDetails() {
		//OpenStoreOrder openStoreOrder = new OpenStoreOrder();
		//openStoreOrder.setId(6);
		//openStoreOrder.setExpressMoney(new BigDecimal(1));
		//System.out.println(openStoreOrderService.getGoodDetails(openStoreOrder));
	}
	@Test
	@Ignore
	public void reduceStock() {
		List<ParamOpenStoreGood> goodList = new ArrayList<ParamOpenStoreGood>();
		ParamOpenStoreGood good = new ParamOpenStoreGood();
		good.setGoodId(1);
		good.setAmount(2);
		goodList.add(good);
		//openStoreGoodService.reduceStock(goodList, null);
	}
	
	@Test
	@Ignore
	public void xxs() {
		openServiceBusinessService.sendPaySuccessEmail(1L, new Date(), "123");
	}
	
	@Test
	@Ignore
	public void xx2() {
		System.out.println(new Date(1523607943000L));
	}
	
	@Test
	@Ignore
	@Rollback(false)
	public void testMutiCartList() {
		System.out.println(openStoreShoppingCartService.mutiStoreCartList(1,1L));
	}
	
	@Test
	@Rollback(false)
	public void getCartNum() {
		System.out.println(openStoreShoppingCartService.getCartNum(1L));
	}
	
}