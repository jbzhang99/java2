package com.rfchina.community.openapi.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class ExtOrder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String community_trade_no;
	
	private String out_trade_no;
	
	private BigDecimal total_amount;
	
	private int bill_status;
	
	private int refund_status;

	public String getCommunity_trade_no() {
		return community_trade_no;
	}

	public void setCommunity_trade_no(String community_trade_no) {
		this.community_trade_no = community_trade_no;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public BigDecimal getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(BigDecimal total_amount) {
		this.total_amount = total_amount;
	}

	public int getBill_status() {
		return bill_status;
	}

	public void setBill_status(int bill_status) {
		this.bill_status = bill_status;
	}

	public int getRefund_status() {
		return refund_status;
	}

	public void setRefund_status(int refund_status) {
		this.refund_status = refund_status;
	}

	
}
