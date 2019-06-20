package test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.paginator.model.Page;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.open.bridge.RfCommunityOpenBridgeApiApplication;
import com.rfchina.community.persistence.mapper.open.CmActivityCardCouponRecordGlobalMapper;
import com.rfchina.community.persistence.model.ext.EXTCmActivityCardCouponRecord;
import com.rfchina.community.persistence.model.ext.SimCmActivityCardCouponRecord;
import com.rfchina.community.service.openser.CmStoreCouponRecordService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { RfCommunityOpenBridgeApiApplication.class })
public class CmStoreCouponRecordTC {
	@Autowired
	private CmStoreCouponRecordService cmStoreCouponRecordService;
	@Autowired
	private CmActivityCardCouponRecordGlobalMapper cmActivityCardCouponRecordGlobalMapper;

	@Test
	@Ignore
	public void pageList() {
		

//		example.put("merchant_name", "%果%");
//		example.put("service_name", "");
		int index = 1;
		int limit = 10;
		Long id=1L;
		PageList<EXTCmActivityCardCouponRecord> page = cmStoreCouponRecordService.pageList(id, index, limit, true);
		System.out.println("---------------");
		System.out.println(JSON.toJSONString(page.convert()));
		System.out.println("---------------");
	}
	
	@Test
	public void userCouponRecordList() {
		System.out.println(cmStoreCouponRecordService.userCouponRecordList(1L, 0, 1, 10));
	}

	 

}