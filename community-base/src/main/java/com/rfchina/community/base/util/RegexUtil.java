package com.rfchina.community.base.util;

import java.util.regex.Pattern;

/**
 * @author huangtiande@rfchina.com
 * @date 2016/9/18
 */
public class RegexUtil {
	/**
	 * 手机号正则表达式
	 */
	public final static Pattern MOBILE = Pattern.compile("^1[34578]\\d{9}$");
	/**
	 * 固定电话
	 */
	public final static Pattern TEL = Pattern.compile("^[0-9-()]+$");
	/**
	 * URL地址正则表达式
	 */
	public final static Pattern URL = Pattern
			.compile("(?<Protocol>\\w+):\\/\\/(?<Domain>[\\w@][\\w.:@]+)\\/?[\\w\\.?=%&=\\-@/$,]*");

	public static String email = "^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w+)+)$";
	public static String phone = "^1(\\d){10}$";

	public static String user_name = "[a-zA-z][a-zA-Z0-9_]{4,19}";
	public static String[] user_names = { user_name, "字母开头,5-20位" };
	public static String[] phones = { phone, "1开头的11位手机号码" };
	public static String[] urls = { "(?<Protocol>\\w+):\\/\\/(?<Domain>[\\w@][\\w.:@]+)\\/?[\\w\\.?=%&=\\-@/$,]*", "如:http://OutRepairStatus.com/aa.jpg" };
	public static String[] tels = { "^[0-9-()]+$", "如:020-38882777-010" };

	public static String[] emails = { email, "如:123456@qq.com" };
	public static String[] DATE= { "^\\d{4}(\\-|\\/|\\.)\\d{1,2}\\1\\d{1,2}$", "格式:2016-12-31" };
	
	public static boolean matches(String str, String regex) {
		if (str == null)
			return false;
		return str.matches(regex);
	}
}
