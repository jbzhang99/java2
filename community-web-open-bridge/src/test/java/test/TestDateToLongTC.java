package test;

import java.util.Date;

import com.rfchina.community.base.util.DateTimeUtils;

public class TestDateToLongTC {

	public static void main(String[] args) {
		Date aa = DateTimeUtils.parseDateTime("2018-06-30 17:59:06");
		System.out.println(aa.getTime());
		String aann = "123213";
		String[] a = aann.split("\\|");

	}

}
