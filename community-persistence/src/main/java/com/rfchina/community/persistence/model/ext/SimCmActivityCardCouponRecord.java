package com.rfchina.community.persistence.model.ext;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SimCmActivityCardCouponRecord implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

    private Long cardCouponId;

    private Long couponId;

    private Long uid;

    private Date validFromDate;

    private Date validToDate;

    private Integer couponType;

    private Integer itemType;

    private Date createTime;
    
    private String couponName;

    private String useRule;
    
    private int confirmStatus;
    
    private int status;
    
    private BigDecimal payAmount;
    
    private BigDecimal tempPrice;
    
    private BigDecimal limitMoney;
    
    private BigDecimal couponDiscountPrice;
    
    private Boolean canUse;
    
	public BigDecimal getCouponDiscountPrice() {
		return couponDiscountPrice;
	}

	public void setCouponDiscountPrice(BigDecimal couponDiscountPrice) {
		this.couponDiscountPrice = couponDiscountPrice;
	}

	public Boolean getCanUse() {
		return canUse;
	}

	public void setCanUse(Boolean canUse) {
		this.canUse = canUse;
	}

	public BigDecimal getLimitMoney() {
		return limitMoney;
	}

	public void setLimitMoney(BigDecimal limitMoney) {
		this.limitMoney = limitMoney;
	}

	public BigDecimal getTempPrice() {
		return tempPrice;
	}

	public void setTempPrice(BigDecimal tempPrice) {
		this.tempPrice = tempPrice;
	}

	public BigDecimal getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getConfirmStatus() {
		return confirmStatus;
	}

	public void setConfirmStatus(int confirmStatus) {
		this.confirmStatus = confirmStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCardCouponId() {
		return cardCouponId;
	}

	public void setCardCouponId(Long cardCouponId) {
		this.cardCouponId = cardCouponId;
	}

	public Long getCouponId() {
		return couponId;
	}

	public void setCouponId(Long couponId) {
		this.couponId = couponId;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Date getValidFromDate() {
		return validFromDate;
	}

	public void setValidFromDate(Date validFromDate) {
		this.validFromDate = validFromDate;
	}

	public Date getValidToDate() {
		return validToDate;
	}

	public void setValidToDate(Date validToDate) {
		this.validToDate = validToDate;
	}

	public Integer getCouponType() {
		return couponType;
	}

	public void setCouponType(Integer couponType) {
		this.couponType = couponType;
	}

	public Integer getItemType() {
		return itemType;
	}

	public void setItemType(Integer itemType) {
		this.itemType = itemType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public String getUseRule() {
		return useRule;
	}

	public void setUseRule(String useRule) {
		this.useRule = useRule;
	}
    
}