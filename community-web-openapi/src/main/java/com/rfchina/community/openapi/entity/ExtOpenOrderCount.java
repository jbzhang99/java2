package com.rfchina.community.openapi.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class ExtOpenOrderCount implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int orderCount;
	
	private BigDecimal orderAmountCount;
	
	private BigDecimal platformPoundageAmount;
	
	private BigDecimal platformCommissionAmount;
	
	private BigDecimal settlementAmountCount;
	
	private int serviceId;
	
	private int communityId;
	
	private int merchantId;

	public int getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public int getCommunityId() {
		return communityId;
	}

	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}

	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	public BigDecimal getOrderAmountCount() {
		return orderAmountCount;
	}

	public void setOrderAmountCount(BigDecimal orderAmountCount) {
		this.orderAmountCount = orderAmountCount;
	}

	public BigDecimal getPlatformPoundageAmount() {
		return platformPoundageAmount;
	}

	public void setPlatformPoundageAmount(BigDecimal platformPoundageAmount) {
		this.platformPoundageAmount = platformPoundageAmount;
	}

	public BigDecimal getPlatformCommissionAmount() {
		return platformCommissionAmount;
	}

	public void setPlatformCommissionAmount(BigDecimal platformCommissionAmount) {
		this.platformCommissionAmount = platformCommissionAmount;
	}

	public BigDecimal getSettlementAmountCount() {
		return settlementAmountCount;
	}

	public void setSettlementAmountCount(BigDecimal settlementAmountCount) {
		this.settlementAmountCount = settlementAmountCount;
	}

}
