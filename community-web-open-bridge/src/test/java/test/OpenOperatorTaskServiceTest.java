package test;

import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.open.bridge.RfCommunityOpenBridgeApiApplication;
import com.rfchina.community.open.bridge.service.OpenOperatorTaskService;
import com.rfchina.community.open.bridge.service.OpenOrderService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RfCommunityOpenBridgeApiApplication.class})
public class OpenOperatorTaskServiceTest {
	@Autowired
	private OpenOperatorTaskService openOperatorTaskService;
	@Autowired
	private OpenOrderService openOrderService;

	@Test
	@Ignore
	public void insertTaskBatch() throws Exception {
		String startTime = "2018-09-10";
		String endTime = "2018-09-15";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate = DateTimeUtils.date000000(sdf.parse(startTime));
		Date endDate = DateTimeUtils.date235959(sdf.parse(endTime));
		openOperatorTaskService.insertTaskBatch(1, 1,1015, "413,71",
				"", "", beginDate, endDate);
	}

	@Test
	public void pageQuery(){
		System.out.println(openOperatorTaskService.pageQuery(0,0,"","",0,
				null,"",null,1,1, 1, 10));
	}

	@Test
	@Ignore
	public void getTaskDetail(){
		System.out.println(openOperatorTaskService.getTaskDetail(3L));
	}

	@Test
	@Ignore
	public void updateReleaseStatus(){
		openOperatorTaskService.updateReleaseStatus(3L,2);
	}

	@Test
	@Ignore
	public void sumAmount(){
		openOrderService.sumAmount(1L,null,"123", true);
	}

	@Test
	@Ignore
	public void taskOrderStat(){
		System.out.print(openOrderService.taskOrderStat(1L,null,"123"));
	}

	@Test
	@Ignore
	public void taskOrderList(){
		System.out.print(openOrderService.taskOrderList(1L,null,"123", 1, 10));
	}

	@Test
	@Ignore
	public void editTask() throws Exception{
		openOperatorTaskService.editTask(3L,"123","",
				null, null);
	}
	@Test
	public void getOperatorStat() throws Exception{
		System.out.print(openOrderService.getOperatorStat("123"));
	}

	@Test
	public void listOperatorOrder() throws Exception{
		System.out.print(openOrderService.listOperatorOrder("",
				"","",null,null,4,
				null,"",1,10
				));
	}


	@Test
	public void updateTaskAndOperator(){
		openOperatorTaskService.updateTaskAndOperator("8F3D51E6-4B7E-49A8-AE38-85A997FCCF33","1");
	}

}