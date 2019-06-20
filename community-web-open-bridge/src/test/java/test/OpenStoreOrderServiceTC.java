package test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.paginator.model.Page;
import org.mybatis.paginator.model.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.rfchina.community.open.bridge.RfCommunityOpenBridgeApiApplication;
import com.rfchina.community.open.bridge.entity.ExtOpenStoreOrder;
import com.rfchina.community.open.bridge.service.OpenStoreOrderService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { RfCommunityOpenBridgeApiApplication.class })
public class OpenStoreOrderServiceTC {
	@Autowired
	private OpenStoreOrderService openStoreOrderService;

	@Test
	public void pageList() {
		Map<String, Object> param = new HashMap<>();
		
			param.put("goodId", 1);
		 
		PageBounds pageBounds = new PageBounds(1, 11);
		
		Page<ExtOpenStoreOrder> page = openStoreOrderService.pageQuery(param, pageBounds);
		System.out.println("---------------");
		System.out.println(JSON.toJSONString(page));
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