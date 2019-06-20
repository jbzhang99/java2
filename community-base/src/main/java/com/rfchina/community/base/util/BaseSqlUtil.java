package com.rfchina.community.base.util;

import org.apache.commons.lang3.StringUtils;

public class BaseSqlUtil {

	public static String whereLike(boolean flag, String value) {
		if (flag) {
			return "%" + value + "%";
		}
		return value;
	}

	public static String whereLike(String value) {
		if (StringUtils.isNotBlank(value)) {
			return "%" + value + "%";
		}
		return value;
	}
}
