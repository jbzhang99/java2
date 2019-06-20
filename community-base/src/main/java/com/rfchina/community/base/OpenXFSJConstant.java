package com.rfchina.community.base;

import java.util.HashMap;
import java.util.Map;

public class OpenXFSJConstant {
	
	public interface Status {
		int ACT_STATUS_VALID = 1; // 启用
		int ACT_STATUS_INVALID = 2; // 禁用

		public static String translate(int code) {
			Map<Integer, String> map = new HashMap<>();
			map.put(ACT_STATUS_VALID, "启用");
			map.put(ACT_STATUS_INVALID, "禁用");

			return map.getOrDefault(code, "");
		}
	}
	
	public interface Type {
		int SHOP_LIFE = 1; // 生活馆
		int SHOP_BETTER = 2; // 优选馆

		public static String translate(int code) {
			Map<Integer, String> map = new HashMap<>();
			map.put(SHOP_LIFE, "生活馆");
			map.put(SHOP_BETTER, "优选馆");

			return map.getOrDefault(code, "");
		}
	}
	
	public interface SignUpStatus {
		int BUSINESS_STATUS_YES = 1; // 可报名
		int BUSINESS_STATUS_NO = 2; // 不可报名

		public static String translate(int code) {
			Map<Integer, String> map = new HashMap<>();
			map.put(BUSINESS_STATUS_YES, "可报名");
			map.put(BUSINESS_STATUS_NO, "不可报名");

			return map.getOrDefault(code, "");
		}
	}
	
	//集团配置状态
	public interface GroupConfigStatus {
		int STATUS_VALID = 1; // 有效
		int STATUS_INVALID = 0; // 无效

		public static String translate(int code) {
			Map<Integer, String> map = new HashMap<>();
			map.put(STATUS_VALID, "有效");
			map.put(STATUS_INVALID, "无效");

			return map.getOrDefault(code, "");
		}
	}
	
	//地区配置状态
	public interface AreaConfigStatus {
		int STATUS_VALID = 1; // 有效
		int STATUS_INVALID = 0; // 无效
		
		public static String translate(int code) {
			Map<Integer, String> map = new HashMap<>();
			map.put(STATUS_VALID, "有效");
			map.put(STATUS_INVALID, "无效");
			
			return map.getOrDefault(code, "");
		}
	}
	//巡查状态
	public interface PatrolStatus {
		int STATUS_INVALID = 0; // 未巡查
		int STATUS_VALID = 1; // 已巡查
		
		public static String translate(int code) {
			Map<Integer, String> map = new HashMap<>();
			map.put(STATUS_VALID, "已巡查");
			map.put(STATUS_INVALID, "未巡查");
			
			return map.getOrDefault(code, "");
		}
	}
	
	public interface ActivityType {
		String platform = "platform"; // 平台活动
		String community = "community"; // 小富市集活动
	}

	public interface XFSJPlatformType {
		String xfsj = "xfsj"; // 小富市集商家
		String no_xfsj = "no-xfsj"; // 非小富市集商家
	}
	
	public static final int EXPORT_FILE_MAX_ROW_LIMIT= 10000;
}
