package com.rfchina.community.persistence.model.ext;

import java.math.BigDecimal;
import java.util.Date;

import com.rfchina.community.persistence.model.OpenQuickOrder;

public class ExtOpenQuickOrder extends OpenQuickOrder {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String merchantName;
	private String serviceName;

	private String payChannel;

	private String tradeType;
	private String communityName;

//	private BigDecimal PlatformFee;
//	private BigDecimal communityFee;

	private String storePhone;
	private String phone;
	private String nickname;
	
	public String getStorePhone() {
		return storePhone;
	}

	public void setStorePhone(String storePhone) {
		this.storePhone = storePhone;
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

	public String getPayChannel() {
		return payChannel;
	}

	public void setPayChannel(String payChannel) {
		this.payChannel = payChannel;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
