package com.rfchina.community.openstore.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SimOpenOrderTotal implements Serializable {
    private Long id;
    private Long communityId;

    private Date createTime;

    private Date updateTime;

    private String billId;
    
    private Integer billStatus;

    private String communityTradeNo;

    private BigDecimal totalAmount;
    
	public Integer getBillStatus() {
		return billStatus;
	}

	public void setBillStatus(Integer billStatus) {
		this.billStatus = billStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCommunityId() {
		return communityId;
	}

	public void setCommunityId(Long communityId) {
		this.communityId = communityId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
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
    
    
}