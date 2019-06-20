package com.rfchina.community.base;


/**
 * @Author wlrllr
 * @Description //订单支付相关的状态
 * @Date 2019/1/3
 * @Param
 * @return
 **/
public final class OrderPayConstant {

	/**
	 * @Author wlrllr
	 * @Description //退款状态
	 * @Date 2019/1/3
	 * 1：退款审批中，2：退款成功，3：退款失败,4：商家审核中',5：待上传至支付中心，6：待支付中心审核，7：待支付中心确认
	 **/
	public enum RefundStatus{
		REFUND_AUDITING(1),SUCCESS(2), FAILURE(3), MERCHANT_AUDITING(4), PC_UPPING(5), PC_AUDITING(6), PC_CONFIRM(7);
		private int code;
		RefundStatus(int code) {
			this.code = code;
		}
		public int getCode() {
			return code;
		}
	}

	/**
	 * @Author wlrllr
	 * @Description //退款标志 0：有退款，1：无退款
	 * @Date 2019/1/4
	 * @Param
	 * @return
	 **/
	public enum RefundFlag{
		YES(1),NO(0);
		private int code;
		RefundFlag(int code) {
			this.code = code;
		}
		public int getCode() {
			return code;
		}
	}

	/**
	 * @Author wlrllr
	 * @Description //支付状态  0:"未支付",1:"已支付",2:"过期支付",3："支付失败"
	 * @Date 2019/1/14
	 * @Param
	 * @return
	 **/
	public enum PayStatus{
		NO_PAYMENT(0,"未支付"),PAY(1,"已支付"), INVALID(2, "过期支付"),FAILURE(3, "支付失败");
		private int code;
		private String label;

		PayStatus(int code, String label) {
			this.code = code;
			this.label = label;
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}
		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}
	}

	/**
	 * @Author wlrllr
	 * @Description //发货状态：0,"未发货"；1,"已发货"；2,"已完成"
	 * @Date 2019/1/14
	 * @Param
	 * @return
	 **/
	public enum SendStatus{
		NOT_SEND(0,"未发货"),SEND(1,"已发货"),COMPLETE(2,"已完成");
		private int code;
		private String label;

		SendStatus(int code, String label) {
			this.code = code;
			this.label = label;
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}
	}

	public enum VerifyStatus{
		UNVERIFIED("unverified","待核销"),VERIFIED("verified","已核销");
		private String code;
		private String label;

		VerifyStatus(String code, String label) {
			this.code = code;
			this.label = label;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}
	}
}
