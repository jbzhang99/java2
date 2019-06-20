package com.rfchina.community.open.bridge.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SimOpenOrder implements Serializable {
    private Long id;

    private Integer serviceId;

    private Long uid;

    private String payChannel;

    private String outTradeNo;

    private Integer billStatus;

    private String communityTradeNo;

    private BigDecimal totalAmount;

    private BigDecimal platformCharge;

    private BigDecimal serviceCharge;

    private BigDecimal receiptAmount;

    private Integer refundStatus;

    private BigDecimal refundMoney;
    
    private String merchantName;
    
    private String storeName;
    
    private String refundId;

	private BigDecimal thinkChargeRate;

	private BigDecimal thinkCharge;

	public String getRefundId() {
		return refundId;
	}

	public void setRefundId(String refundId) {
		this.refundId = refundId;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getPayChannel() {
		return payChannel;
	}

	public void setPayChannel(String payChannel) {
		this.payChannel = payChannel;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public Integer getBillStatus() {
		return billStatus;
	}

	public void setBillStatus(Integer billStatus) {
		this.billStatus = billStatus;
	}

	public String getCommunityTradeNo() {
		return communityTradeNo;
	}

	public void setCommunityTradeNo(String communityTradeNo) {
		this.communityTradeNo = communityTradeNo;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
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

	public Integer getRefundStatus() {
		return refundStatus;
	}

	public void setRefundStatus(Integer refundStatus) {
		this.refundStatus = refundStatus;
	}

	public BigDecimal getRefundMoney() {
		return refundMoney;
	}

	public void setRefundMoney(BigDecimal refundMoney) {
		this.refundMoney = refundMoney;
	}

	public BigDecimal getThinkChargeRate() {
		return thinkChargeRate;
	}

	public void setThinkChargeRate(BigDecimal thinkChargeRate) {
		this.thinkChargeRate = thinkChargeRate;
	}

	public BigDecimal getThinkCharge() {
		return thinkCharge;
	}

	public void setThinkCharge(BigDecimal thinkCharge) {
		this.thinkCharge = thinkCharge;
	}
}