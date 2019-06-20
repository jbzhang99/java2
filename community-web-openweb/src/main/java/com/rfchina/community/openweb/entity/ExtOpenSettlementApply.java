package com.rfchina.community.openweb.entity;

import java.math.BigDecimal;

import com.rfchina.community.persistence.model.OpenSettlementApply;

public class ExtOpenSettlementApply extends OpenSettlementApply{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String serviceName;
	
	private BigDecimal platformServiceFee;
	

	public BigDecimal getPlatformServiceFee() {
		return platformServiceFee;
	}

	public void setPlatformServiceFee(BigDecimal platformServiceFee) {
		this.platformServiceFee = platformServiceFee;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	
}
