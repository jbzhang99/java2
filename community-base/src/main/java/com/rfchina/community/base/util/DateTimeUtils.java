package com.rfchina.community.base.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtils {

	public static String DATE_FORMAT = "yyyy-MM-dd";
	public static String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static Date parseDate(String str) {
		return parse(str, DATE_FORMAT);
	}

	public static Date parseDateTime(String str) {
		return parse(str, DATETIME_FORMAT);
	}

	public static Date parse(String str, String format) {
		try {
			return new SimpleDateFormat(format).parse(str);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	public static String format(Date date, String format) {
		if (date == null)
			return "";
		return new SimpleDateFormat(format).format(date);
	}

	public static String formatDate(Date date) {
		return format(date, DATE_FORMAT);
	}

	public static String formatDate(Long time) {
		return format(new Date(time), DATE_FORMAT);
	}

	public static String formatDateTime(Date date) {

		return format(date, DATETIME_FORMAT);
	}

	public static String formatDate() {
		return format(new Date(), DATE_FORMAT);
	}

	public static String formatDateTime() {
		return format(new Date(), DATETIME_FORMAT);
	}

	public static Date date235959(Date date) {
		return date(date, 23, 59, 59);
	}

	public static Date date(Date date, int h, int m, int s) {
		Calendar d = Calendar.getInstance();
		d.setTime(date);
		d.set(Calendar.HOUR_OF_DAY, h);
		d.set(Calendar.MINUTE, m);
		d.set(Calendar.SECOND, s);
		d.set(Calendar.MILLISECOND, 0);
		return d.getTime();
	}

	public static boolean compareSameDay(Date date1, Date date2) {
		return formatDate(date1).equals(formatDate(date2));
	}

	public static Date date000000(Date date) {
		return date(date, 0, 0, 0);
	}

	public static String translate(Date date, String format) {
		if (date == null)
			return "";
		long now = System.currentTimeMillis();
		long s = now - date.getTime();
		if (s < 0) {
			return format(date, format);
		}
		if (s < 1000L * 60) {
			return "刚刚";
		}
		if (s < 60 * 1000L * 60) {
			return (s / (1000L * 60)) + "分钟前";
		}
		if (s < 24 * 1000L * 3600) {
			return (s / (1000L * 3600)) + "小时前";
		}
		if (s < 7 * 24 * 1000L * 3600) {
			return (s / (24 * 1000L * 3600)) + "天前";
		}

		return format(date, format);
	}
	
	 /** 
     * 计算两个日期之间相差的天数   
     * @param smdate 较小的时间  
     * @param bdate  较大的时间  
     * @return 相差天数  
     * calendar 对日期进行时间操作 
     * getTimeInMillis() 获取日期的毫秒显示形式 
     */  
    public static int daysBetween(Date smdate,Date bdate){ 
    	if(smdate == null || bdate == null)
    		return 1;
        Calendar cal = Calendar.getInstance();  
        cal.setTime(smdate);  
        long time1 = cal.getTimeInMillis();  
        cal.setTime(bdate);  
        long time2 = cal.getTimeInMillis();        
        long between_days=(time2-time1)/(1000*3600*24);    
        return Integer.parseInt(String.valueOf(between_days)) + 1;             
    } 
    
    
    public static Date getFirstDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        if (date != null)
            cal.setTime(date);

        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
    }

    public static Date addHours(Date date, int hour) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR, hour);// 24小时制
		return  cal.getTime();
	}

	public static Date addDay(Date date, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, day);
		return  cal.getTime();
	}
}
