package com.rfchina.community.service.openser.entity;

import java.io.Serializable;

public class OpenServiceDetailTab implements Serializable {
    private Integer serviceId;

    private Integer type;
    
    private String typeName;
    
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

   
}