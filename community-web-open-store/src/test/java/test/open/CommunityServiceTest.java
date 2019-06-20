package test.open;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.rfchina.community.openstore.CommunityOpenStoreApplication;
import com.rfchina.community.openstore.service.OpenQuickOrderService;
import com.rfchina.community.persistence.model.ext.ExtOpenQuickOrder;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { CommunityOpenStoreApplication.class })
public class CommunityServiceTest {

	@Autowired
	private OpenQuickOrderService penQuickOrderService;

	@Test
	public void listQuickOrderTest() {
		Map<String, Object> example = new HashMap<>();
		int page = 1;
		int limit = 10;
		boolean phoneHide = true;
		PageInfo<ExtOpenQuickOrder> data = penQuickOrderService.listQuickOrder(example, page, limit, phoneHide);
		System.out.println(JSON.toJSONString(data));

	}

	@Test
	public void getQuickOrder(){System.out.println(penQuickOrderService.getQuickOrder(1L,1,1l));}

}