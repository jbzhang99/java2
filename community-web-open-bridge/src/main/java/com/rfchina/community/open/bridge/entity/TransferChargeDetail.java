package com.rfchina.community.open.bridge.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TransferChargeDetail implements Serializable {
    private Long id;

    private String outTradeNo;

    private String communityTradeNo;

    private BigDecimal platformCharge;

    private BigDecimal serviceCharge;

    private Integer billSplitStatus;//是否拆单，1：是，2：否
    
    private Date billSplitTime;
    
    private Double platformChargeRate; //平台手续费比例
    
    private Double serviceChargeRate; //社区手续费比例

	private BigDecimal thinkChargeRate;

	private BigDecimal thinkCharge;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getCommunityTradeNo() {
		return communityTradeNo;
	}

	public void setCommunityTradeNo(String communityTradeNo) {
		this.communityTradeNo = communityTradeNo;
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

	public Integer getBillSplitStatus() {
		return billSplitStatus;
	}

	public void setBillSplitStatus(Integer billSplitStatus) {
		this.billSplitStatus = billSplitStatus;
	}

	public Date getBillSplitTime() {
		return billSplitTime;
	}

	public void setBillSplitTime(Date billSplitTime) {
		this.billSplitTime = billSplitTime;
	}

	public Double getPlatformChargeRate() {
		return platformChargeRate;
	}

	public void setPlatformChargeRate(Double platformChargeRate) {
		this.platformChargeRate = platformChargeRate;
	}

	public Double getServiceChargeRate() {
		return serviceChargeRate;
	}

	public void setServiceChargeRate(Double serviceChargeRate) {
		this.serviceChargeRate = serviceChargeRate;
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