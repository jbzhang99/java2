package com.rfchina.community.openapi.entity;

import com.rfchina.community.persistence.model.OpenSettlementApply;

public class ExtOpenSettlementApply extends OpenSettlementApply{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String serviceName;

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	
}
