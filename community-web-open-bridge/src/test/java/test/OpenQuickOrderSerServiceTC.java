package test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.paginator.model.Page;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.rfchina.community.base.OpenConstant.CouponStatus;
import com.rfchina.community.open.bridge.RfCommunityOpenBridgeApiApplication;
import com.rfchina.community.persistence.model.ext.ExtOpenQuickOrder;
import com.rfchina.community.persistence.model.ext.ExtStoreCoupon;
import com.rfchina.community.service.openser.OpenQuickOrderSerService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { RfCommunityOpenBridgeApiApplication.class })
public class OpenQuickOrderSerServiceTC {
	@Autowired
	private OpenQuickOrderSerService openQuickOrderSerService;

	@Test
	public void pageList() {
		Map<String, Object> example = new HashMap<String, Object>();

//		example.put("merchant_name", "%果%");
		example.put("out_trade_no", "QUICK1808101000319840192");
		int index = 1;
		int limit = 10;
		PageList<ExtOpenQuickOrder> page = openQuickOrderSerService.listQuickOrder(example, index, limit,false);
		System.out.println("---------------");
		System.out.println(JSON.toJSONString(page.convert()));
		System.out.println("---------------");
	}

//	@Test
//	public void updateStoreCoupon() {
//		CouponStatus status=CouponStatus.disabled ;
//		Long id=1L;
//		int page = cmStoreCouponService.updateStoreCoupon(id, status);
//		System.out.println("---------------");
//		System.out.println(page);
//		System.out.println("---------------");
//	}

}