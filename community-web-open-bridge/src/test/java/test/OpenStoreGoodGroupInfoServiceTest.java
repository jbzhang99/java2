package test;

import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.open.bridge.RfCommunityOpenBridgeApiApplication;
import com.rfchina.community.open.bridge.service.OpenStoreGoodGroupInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RfCommunityOpenBridgeApiApplication.class})
public class OpenStoreGoodGroupInfoServiceTest {
	@Autowired
	private OpenStoreGoodGroupInfoService openStoreGoodGroupInfoService;

	@Test
	public void insert(){
		int goodId = 1;
		int peopleNum = 2;
		BigDecimal price = new BigDecimal(1);
		BigDecimal groupPrice = new BigDecimal(0.8);
		int stock = 100;
		Date startDate = new Date();
		Date endDate = DateTimeUtils.date235959(startDate);
		int limitTimes = 2;
		int virturalSuccessHour = 1;
		openStoreGoodGroupInfoService.insert(goodId, peopleNum, price, groupPrice, stock,
				startDate, endDate, limitTimes, virturalSuccessHour);
	}

	@Test
	public void update(){
			long id = 1;
			int goodId = 1;
			int peopleNum = 3;
			BigDecimal price = new BigDecimal(1);
			BigDecimal groupPrice = new BigDecimal(0.8);
			int stock = 100;
			Date startDate = new Date();
			Date endDate = DateTimeUtils.date235959(startDate);
			int limitTimes = 2;
			int virturalSuccessHour = 1;
		openStoreGoodGroupInfoService.update(id, stock,
				endDate);
	}

	@Test
	public void forbidden(){
		long id = 1;
		openStoreGoodGroupInfoService.forbidden(id);
	}


	@Test
	public void getDetail(){
		long id = 1;
		openStoreGoodGroupInfoService.getDetail(id);
	}

	@Test
	public void pageByParam(){
		String goodName = null;
		String serviceName = null;
		String merchantName = null;
		int index = 1;
		int size = 10;
		Integer status = null;
		openStoreGoodGroupInfoService.pageByParam(goodName, serviceName, merchantName, status, index, size);
	}
}