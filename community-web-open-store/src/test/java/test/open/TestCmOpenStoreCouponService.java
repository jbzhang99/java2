package test.open;

import java.math.BigDecimal;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rfchina.community.component.HttpClientComponent;
import com.rfchina.community.openstore.service.CmOpenStoreCouponService;
import com.rfchina.community.service.openser.CmStoreCouponRecordService;

public class TestCmOpenStoreCouponService extends TestBase{
	@Autowired
	public CmOpenStoreCouponService cmOpenStoreCouponService;
	@Autowired
	public CmStoreCouponRecordService cmStoreCouponRecordService;
	
	@Test
	@Ignore
	public void getValidStoreCouponList() {
		System.out.println(cmOpenStoreCouponService.getValidStoreCouponList(413));
	}
	
	@Test
	@Ignore
	public void receiveStoreCoupon() {
		cmOpenStoreCouponService.receiveStoreCoupon(1L, 9, 413);
	}
	@Test
	public void userValidCouponRecordList() {
		System.out.println(cmStoreCouponRecordService.userValidCouponRecordList(1L, 413, new BigDecimal(100)));
	}
	@Test
//	@Ignore
	public void getCouponDiscountMoney() {
		System.out.println(cmOpenStoreCouponService.getCouponDiscountMoney(4L, new BigDecimal(10), 1L, 413));
	}
	@Test
	@Ignore
	public void userCouponRecordList() {
		System.out.println(cmStoreCouponRecordService.userCouponRecordList(1L, 0, 1, 10));
	}

}