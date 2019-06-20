package com.rfchina.community.persistence.model.ext;

import com.rfchina.community.persistence.model.OpenFeeOrderWithBLOBs;

public class ExtOpenFeeOrder extends OpenFeeOrderWithBLOBs {

	String merchantName;
	String serviceName;
	String communityName;
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
	public String getCommunityName() {
		return communityName;
	}
	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}
}
