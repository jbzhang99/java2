package com.rfchina.community.base;

public class OpenRefundConstant {
	//退款方式
	public static interface SameWayStatus {
		// 1原路退回，2非原路退回
		public int original = 1;
		public int no_original = 2;
	}
	
	//退款来源
	public static interface Source {
		// 
		public String user = "user";
		public String business = "business";
		public String platform = "platform";
	}
	
	//退款表状态
	//1:审批中, 2:审批成功, 3:审批失败, 4:退款进行中, 5:退款处理完成, 6:退款处理结束(核对出错或失败) 7撤销
	public static interface Status {
		public int init = 0;
		public int audit_ing = 1;
		public int audit_pass = 2;
		public int audit_fail = 3;
		public int refund_ing = 4;
		public int refund_success = 5;
		public int refund_error = 6;
		public int refund_reback = 7; //7撤销
	}

	
}
