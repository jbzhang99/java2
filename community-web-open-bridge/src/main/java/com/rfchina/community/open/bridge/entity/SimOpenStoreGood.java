package com.rfchina.community.open.bridge.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SimOpenStoreGood implements Serializable {
    private Integer id;

    private Integer serviceId;

    private String name;
    
    private BigDecimal price;

    private Integer saleAmount;

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getSaleAmount() {
		return saleAmount;
	}

	public void setSaleAmount(Integer saleAmount) {
		this.saleAmount = saleAmount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    
}