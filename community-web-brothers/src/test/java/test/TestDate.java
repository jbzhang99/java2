package test;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.util.DateTimeUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TestDate {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Calendar now1 = Calendar.getInstance();

		Date startDate = DateTimeUtils
				.date000000(DateUtils.addDays(now1.getTime(), -OpenConstant.communtiy_test_BATCH_RUN_day));
		System.out.println(startDate);
	}

	@Test
	public void xx(){
		List<Integer> confirmList = new ArrayList<Integer>();
		for(int i = 0; i <1; i++){
			confirmList.add(i);
		}
		if(confirmList.isEmpty()) {
			return;
		}
		List<Integer> subList = new ArrayList<Integer>();
		for(int i = 0; i < confirmList.size(); i++) {
			subList.add(i);
			if(subList.size() % 50 == 0){
				System.out.print(subList.size());
				subList.clear();
			}
		}

		if(subList.size() > 0){
			System.out.print(subList.size() + "-");
		}
	}

}
