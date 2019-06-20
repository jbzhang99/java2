package com.rfchina.community.open.bridge.entity;

import java.math.BigDecimal;

import com.rfchina.community.persistence.model.OpenSettlementApply;

public class ExtOpenSettlementApply extends OpenSettlementApply{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String serviceName;
	
	private String serviceCategory;
	
	private String merchantName;
	
	private int merchantType;
	
	private BigDecimal communityRate;
	
	private BigDecimal platformFee;

	private BigDecimal thinkRate;

	private BigDecimal totalAmount;

	public BigDecimal getPlatformFee() {
		return platformFee;
	}

	public void setPlatformFee(BigDecimal platformFee) {
		this.platformFee = platformFee;
	}

	public String getServiceCategory() {
		return serviceCategory;
	}

	public void setServiceCategory(String serviceCategory) {
		this.serviceCategory = serviceCategory;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public int getMerchantType() {
		return merchantType;
	}

	public void setMerchantType(int merchantType) {
		this.merchantType = merchantType;
	}



	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public BigDecimal getCommunityRate() {
		return communityRate;
	}

	public void setCommunityRate(BigDecimal communityRate) {
		this.communityRate = communityRate;
	}

	public BigDecimal getThinkRate() {
		return thinkRate;
	}

	public void setThinkRate(BigDecimal thinkRate) {
		this.thinkRate = thinkRate;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
}
