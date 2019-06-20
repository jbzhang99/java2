package test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.rfchina.community.base.util.DateTimeUtils;

public class OpenApiTest {

	@Before
	public void setUp() throws Exception {
	}

	// @Test
	// public void test() {
	// fail("Not yet implemented");
	// }

	@Test
	public void date() {

		// 2017-8-22 14:43:21
		// 2017-8-21 14:43:21
		// 2017-8-21 14:43:21
		String time = "2017-8-22 14:43:21";
		time = "2017-8-21 14:43:21";
		time = "2017-8-20 19:43:21";

		Date create = DateTimeUtils.parseDateTime(time);
		int day = 1;
		Date lastTime = new Date(create.getTime() + day * 24 * 3600 * 1000L);
		Date last17 = DateTimeUtils.date(lastTime, 17, 0, 0);
		if (lastTime.after(last17)) {
			lastTime = last17;
		}
		//
		if (lastTime.before(DateTimeUtils.parseDateTime("2017-8-21 19:22:45"))) {
			System.out.println("错过最后退款时间,该订单创建时间:" + DateTimeUtils.formatDateTime(create) + ",最后退款时间:"
					+ DateTimeUtils.formatDateTime(lastTime));
		}

		System.out.println("该订单创建时间:" + DateTimeUtils.formatDateTime(create) + ",最后退款时间:"
				+ DateTimeUtils.formatDateTime(lastTime));
	}
}
