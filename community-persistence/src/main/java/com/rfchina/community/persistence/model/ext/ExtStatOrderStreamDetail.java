package com.rfchina.community.persistence.model.ext;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.type.JdbcType;

public class ExtStatOrderStreamDetail {
	private BigDecimal totalAmount;
	private BigDecimal refundMoney;
	private BigDecimal platformCharge;
	private BigDecimal serviceCharge;
	private BigDecimal receiptAmount;
	
	private int serviceId;
	private String title;
	private int categoryId;
	private int categorySecondType;
	private String merchantName;
	private int type;
	private int orderCount;
	private int refundCount;
	
	private String categoryName;
	private String secondCategoryName;
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getSecondCategoryName() {
		return secondCategoryName;
	}
	public void setSecondCategoryName(String secondCategoryName) {
		this.secondCategoryName = secondCategoryName;
	}
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getCategorySecondType() {
		return categorySecondType;
	}
	public void setCategorySecondType(int categorySecondType) {
		this.categorySecondType = categorySecondType;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	public int getRefundCount() {
		return refundCount;
	}
	public void setRefundCount(int refundCount) {
		this.refundCount = refundCount;
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
