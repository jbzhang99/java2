package com.rfchina.community.base.util;
import org.apache.commons.lang3.StringUtils;

import com.rfchina.community.base.exception.WorkRunTimeException;
public class ValidatorUtil {

	public static void verify(String val, String title, boolean must, Integer min, Integer max, String[] regex) {
		if (must && StringUtils.isBlank(val)) {
			throw new WorkRunTimeException(title + "不能为空!");
		}
		if (val == null) {
			return;
		}
		if (min != null && min > 0 && val.length() < min) {
			throw new WorkRunTimeException(title + "长度必须大于等于" + min + "位");
		}
		if (max != null && max > 0 && val.length() > max) {
			throw new WorkRunTimeException(title + "长度不能大于" + max + "位");
		}
		if (regex != null && !val.matches(regex[0])) {
			throw new WorkRunTimeException(title + "格式不对," + regex[1]);
		}
	}

	public static void equals(String val1, String val2, String title) {
		if (StringUtils.isBlank(val1) || StringUtils.isBlank(val2)) {
			throw new WorkRunTimeException(title + "2次输入不一致");
		}
		if (!val1.equals(val2)) {
			throw new WorkRunTimeException(title + "2次输入不相同");
		}
	}

	public static void notEquals(String val1, String val2, String title) {
		if (StringUtils.isBlank(val1) || StringUtils.isBlank(val2)) {
			throw new WorkRunTimeException(title + "2次输入不一致");
		}
		if (val1.equals(val2)) {
			throw new WorkRunTimeException(title + "输入相同");
		}
	}

	public static void verify(String val, String title) {
		verify(val, title, true, null, null, null);
	}

	public static void verify(String val, String title, String[] regex) {
		verify(val, title, true, null, null, regex);
	}

	public static void verify(Integer val, String title, Integer... val2) {
		if (val != null) {
			for (Integer integer : val2) {
				if (integer.intValue() == val.intValue()) {
					return;
				}
			}
		}
		throw new WorkRunTimeException(title);
	}

	public static void between(Long val, String title, Long min, Long max) {
		if (val != null) {
			if (min != null && val <= min) {
				throw new WorkRunTimeException(title + "必须大于" + min);
			}
			if (max != null && val >= max) {
				throw new WorkRunTimeException(title + "必须小于" + max);
			}
			return;
		}
		throw new WorkRunTimeException(title + "不能为空");
	}

	public static void verify(Long val, String title, Long... val2) {
		if (val != null) {
			for (Long integer : val2) {
				if (integer.longValue() == val.longValue()) {
					return;
				}
			}
		}
		throw new WorkRunTimeException(title);
	}

	public static void verify(String val, String title, boolean must, Integer min, Integer max) {
		verify(val, title, must, min, max, null);
	}

	public static void matches(String val, String title, String regex) {
		if (val == null || !val.matches(regex)) {
			throw new WorkRunTimeException(title);
		}
	}

	public static void matchesImage(String val, String title, boolean must) {
		if (must) {
			if (val == null || val.trim().length() == 0)
				throw new WorkRunTimeException(title + "不能为空");
			if (val != null && !val.matches("http.+\\.(jpg|gif|png|jpeg)")) {
				throw new WorkRunTimeException(title + "格式不正确");
			}
		} else {
			if (val != null && !val.matches("http.+\\.(jpg|gif|png|jpeg)")) {
				throw new WorkRunTimeException(title + "格式不正确");
			}
		}
	}

	public static void matchesEmail(String val, String title, boolean must) {
		if (must) {
			if (val == null || val.trim().length() == 0)
				throw new WorkRunTimeException(title + "不能为空");
			if (val != null && !val.matches(RegexUtils.emailAddressPattern)) {
				throw new WorkRunTimeException(title + "格式不正确");
			}
		} else {
			if (val != null && !val.matches(RegexUtils.emailAddressPattern)) {
				throw new WorkRunTimeException(title + "格式不正确");
			}
		}
	}
}
