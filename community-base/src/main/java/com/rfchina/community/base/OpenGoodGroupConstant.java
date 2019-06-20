package com.rfchina.community.base;

public class OpenGoodGroupConstant {
	//团购状态
	public static interface status {
		public int start = 1;
		public int forbidden = 2;
	}

	//团购活动状态 用户显示
	public static interface groupInfoStatus {
		public int un_start = 0;
		public int ing = 1;
		public int forbidden = 2;
		public int over = 3;
	}

	//成团情况
	public static interface dataStatus {
		public int un_success = 0;
		public int success = 1;
		public int fail = 2;
	}

	//成团方式
	public static interface dataType {
		public String user = "user";
		public String system = "system";
	}

	//订单成团方式
	public static interface dataOrderType {
		public String user = "user";
		public String system = "virtual";
	}

	/**
	 * 团主状态
	 */
	public static interface groupMasterStatus {
		public int no = 0;
		public int yes = 1;
	}

	/**
	 * 是否本人
	 */
	public static interface meStatus {
		public int no = 0;
		public int yes = 1;
	}

	/**
	 * 订单下单方式
	 */
	public static interface groupOrderStatus {
		public int no_group = 0;
		public int group = 1;
	}

	/**
	 * 库存引用方式
	 */
	public static interface groupStockStatus {
		public int good_stock = 0;
		public int group_stock = 1;
	}

	/**
	 * 库存引用方式
	 */
	public static interface stockType {
		public String good = "good";
		public String group = "group";
		public String groupdata = "groupdata";
	}

}
