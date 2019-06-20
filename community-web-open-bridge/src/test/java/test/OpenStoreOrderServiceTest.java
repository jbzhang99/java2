package test;

import com.rfchina.community.open.bridge.RfCommunityOpenBridgeApiApplication;
import com.rfchina.community.open.bridge.service.OpenStoreOrderService;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.paginator.model.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RfCommunityOpenBridgeApiApplication.class})
public class OpenStoreOrderServiceTest {
	@Autowired
	private OpenStoreOrderService openStoreOrderService;

	
	@Test
	public void pageQuery() {
		Map<String, Object> param = new HashMap<>();
//		param.put("type", type);
		param.put("communityIdList", "1,2");
		int serviceId = 59;
		int merchantId=455;
		int communityId=1;
		Integer payStatus= null;
		Integer sendStatus=null;
		String orderCode = "";
		String outTradeNo = "";
		Integer groupStatus = 0;
		String startCreateDate = null;
		String endCreateDate = null;
		if (serviceId != 0) {
			param.put("serviceId", serviceId);
		}
		if (merchantId != 0) {
			param.put("merchantId", merchantId);
		}
		if (communityId != 0) {
			param.put("communityId", communityId);
		}
		if (payStatus != null) {
			param.put("payStatus", payStatus);
		}
		if (sendStatus != null) {
			param.put("sendStatus", sendStatus);
		}
		if (StringUtils.isNotBlank(orderCode)) {
			param.put("orderCode", "%" + orderCode + "%");
		}
		if (StringUtils.isNotBlank(outTradeNo)) {
			param.put("outTradeNo", "%" + outTradeNo + "%");
		}
		if (startCreateDate != null) {
			param.put("startCreateDate", startCreateDate);
		}
		if (endCreateDate != null) {
			param.put("endCreateDate", endCreateDate);
		}
		if (groupStatus != null) {
			param.put("groupStatus", groupStatus);
		}
		PageBounds pageBounds = new PageBounds(1, 10);

		System.out.println(openStoreOrderService.pageQuery(param, pageBounds));
	}

}