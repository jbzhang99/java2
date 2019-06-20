package com.rfchina.community.persistence.model.ext;

import java.math.BigDecimal;

public class ExtStatOrderStream {
	private BigDecimal totalAmount;
	private BigDecimal refundMoney;
	private BigDecimal platformCharge;
	private BigDecimal serviceCharge;
	private BigDecimal receiptAmount;
	private String statDate;
	
	public String getStatDate() {
		return statDate;
	}
	public void setStatDate(String statDate) {
		this.statDate = statDate;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	public BigDecimal getRefundMoney() {
		return refundMoney;
	}
	public void setRefundMoney(BigDecimal refundMoney) {
		this.refundMoney = refundMoney;
	}
	public BigDecimal getPlatformCharge() {
		return platformCharge;
	}
	public void setPlatformCharge(BigDecimal platformCharge) {
		this.platformCharge = platformCharge;
	}
	public BigDecimal getServiceCharge() {
		return serviceCharge;
	}
	public void setServiceCharge(BigDecimal serviceCharge) {
		this.serviceCharge = serviceCharge;
	}
	public BigDecimal getReceiptAmount() {
		return receiptAmount;
	}
	public void setReceiptAmount(BigDecimal receiptAmount) {
		this.receiptAmount = receiptAmount;
	}
	
	
}
