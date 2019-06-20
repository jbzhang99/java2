package com.rfchina.community.persistence.model.ext;

import java.math.BigDecimal;

import com.rfchina.community.persistence.model.CmActivityCardCouponItem;

public class ExtStoreCoupon extends CmActivityCardCouponItem {
	private Long cardItemId;

	private Integer serviceId;

	private Long merchantId;

	private BigDecimal limitMoney;
	String merchantName;
	String serviceName;
	// 领取
	Long drawCount;
	// 使用
	Long useCount;
	
	Boolean isFull;
	
	
	public Boolean getIsFull() {
		return isFull;
	}

	public void setIsFull(Boolean isFull) {
		this.isFull = isFull;
	}

	public Long getCardItemId() {
		return cardItemId;
	}

	public void setCardItemId(Long cardItemId) {
		this.cardItemId = cardItemId;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}

	public BigDecimal getLimitMoney() {
		return limitMoney;
	}

	public void setLimitMoney(BigDecimal limitMoney) {
		this.limitMoney = limitMoney;
	}

	public Long getDrawCount() {
		return drawCount;
	}

	public void setDrawCount(Long drawCount) {
		this.drawCount = drawCount;
	}

	public Long getUseCount() {
		return useCount;
	}

	public void setUseCount(Long useCount) {
		this.useCount = useCount;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
}
