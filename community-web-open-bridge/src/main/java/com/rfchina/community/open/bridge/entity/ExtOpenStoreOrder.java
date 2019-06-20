package com.rfchina.community.open.bridge.entity;

import com.rfchina.community.persistence.model.OpenStoreGoodOrderRel;
import com.rfchina.community.persistence.model.OpenStoreOrder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ExtOpenStoreOrder extends OpenStoreOrder implements Serializable {

	private List<OpenStoreGoodOrderRel> goodList;
	private String serviceTitle;
	private Long merchantId;
	private String merchantTitle;
	private String communityTitle;
	private String refundId;
	private String billId;
	private Date billFinishTime;
	private String communityTradeNo;
	private String activityTitle;
    private BigDecimal platformCharge;
    private BigDecimal serviceCharge;
    private BigDecimal receiptAmount;
    private BigDecimal refundMoney;
    private String userPhone;
	private BigDecimal thinkCharge;

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public BigDecimal getReceiptAmount() {
		return receiptAmount;
	}

	public void setReceiptAmount(BigDecimal receiptAmount) {
		this.receiptAmount = receiptAmount;
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

	public String getActivityTitle() {
		return activityTitle;
	}

	public void setActivityTitle(String activityTitle) {
		this.activityTitle = activityTitle;
	}

	public String getCommunityTradeNo() {
		return communityTradeNo;
	}

	public void setCommunityTradeNo(String communityTradeNo) {
		this.communityTradeNo = communityTradeNo;
	}

	public Date getBillFinishTime() {
		return billFinishTime;
	}

	public void setBillFinishTime(Date billFinishTime) {
		this.billFinishTime = billFinishTime;
	}

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	private static final long serialVersionUID = 1L;

	public String getRefundId() {
		return refundId;
	}

	public void setRefundId(String refundId) {
		this.refundId = refundId;
	}

	public String getCommunityTitle() {
		return communityTitle;
	}

	public void setCommunityTitle(String communityTitle) {
		this.communityTitle = communityTitle;
	}

	public List<OpenStoreGoodOrderRel> getGoodList() {
		return goodList;
	}

	public void setGoodList(List<OpenStoreGoodOrderRel> goodList) {
		this.goodList = goodList;
	}

	public String getServiceTitle() {
		return serviceTitle;
	}

	public void setServiceTitle(String serviceTitle) {
		this.serviceTitle = serviceTitle;
	}

	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}

	public String getMerchantTitle() {
		return merchantTitle;
	}

	public void setMerchantTitle(String merchantTitle) {
		this.merchantTitle = merchantTitle;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public BigDecimal getThinkCharge() {
		return thinkCharge;
	}

	public void setThinkCharge(BigDecimal thinkCharge) {
		this.thinkCharge = thinkCharge;
	}
}