package com.rfchina.community.openapi.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class ExtServiceMerchantInfo  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String accountId;
	Long appId;
	int serviceId;
	BigDecimal communityRate;
	BigDecimal platformFee;
	BigDecimal thinkRate;

	public BigDecimal getThinkRate() {
		return thinkRate;
	}

	public void setThinkRate(BigDecimal thinkRate) {
		this.thinkRate = thinkRate;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public BigDecimal getCommunityRate() {
		return communityRate;
	}

	public void setCommunityRate(BigDecimal communityRate) {
		this.communityRate = communityRate;
	}

	public BigDecimal getPlatformFee() {
		return platformFee;
	}

	public void setPlatformFee(BigDecimal platformFee) {
		this.platformFee = platformFee;
	}
}
