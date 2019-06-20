package com.rfchina.community.openstore.entity;

import com.rfchina.community.persistence.model.OpenStoreServiceDiscount;

import java.math.BigDecimal;

/**
 */
public class SearchGoodBean {

	private int goodId;
	private int serviceId;
	private int categoryId;
	private String serviceTitle;
	private String name;
	private String shortDetail;
	private BigDecimal price;
	private BigDecimal prePrice;
	private String picUrl;
	private String thirdParam;
	private OpenStoreServiceDiscount discount;
	private BigDecimal expressMoney;
	private Integer totalSaleAmount;
	private Integer flagship = 0;

	//团购
	private Integer groupStatus;

	//团购价
	private BigDecimal groupPrice;

	public Integer getGroupStatus() {
		return groupStatus;
	}

	public void setGroupStatus(Integer groupStatus) {
		this.groupStatus = groupStatus;
	}

	public BigDecimal getGroupPrice() {
		return groupPrice;
	}

	public void setGroupPrice(BigDecimal groupPrice) {
		this.groupPrice = groupPrice;
	}

	public Integer getTotalSaleAmount() {
		return totalSaleAmount;
	}

	public void setTotalSaleAmount(Integer totalSaleAmount) {
		this.totalSaleAmount = totalSaleAmount;
	}

	public String getThirdParam() {
		return thirdParam;
	}

	public void setThirdParam(String thirdParam) {
		this.thirdParam = thirdParam;
	}

	public String getServiceTitle() {
		return serviceTitle;
	}

	public void setServiceTitle(String serviceTitle) {
		this.serviceTitle = serviceTitle;
	}

	public BigDecimal getPrePrice() {
		return prePrice;
	}

	public void setPrePrice(BigDecimal prePrice) {
		this.prePrice = prePrice;
	}

	public int getGoodId() {
		return goodId;
	}

	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDetail() {
		return shortDetail;
	}

	public void setShortDetail(String shortDetail) {
		this.shortDetail = shortDetail;
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

	public BigDecimal getExpressMoney() {
		return expressMoney;
	}

	public void setExpressMoney(BigDecimal expressMoney) {
		this.expressMoney = expressMoney;
	}

	public OpenStoreServiceDiscount getDiscount() {
		return discount;
	}

	public void setDiscount(OpenStoreServiceDiscount discount) {
		this.discount = discount;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getFlagship() {
		return flagship;
	}

	public void setFlagship(Integer flagship) {
		this.flagship = flagship;
	}
}
