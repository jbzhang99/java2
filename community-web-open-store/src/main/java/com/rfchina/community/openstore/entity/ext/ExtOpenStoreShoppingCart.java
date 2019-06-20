package com.rfchina.community.openstore.entity.ext;

import java.math.BigDecimal;

import com.rfchina.community.persistence.model.OpenStoreShoppingCart;

public class ExtOpenStoreShoppingCart extends OpenStoreShoppingCart{
	 private String name;

	 private BigDecimal prePrice;

	 private BigDecimal price;

	 private String picUrl;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrePrice() {
		return prePrice;
	}

	public void setPrePrice(BigDecimal prePrice) {
		this.prePrice = prePrice;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
}
