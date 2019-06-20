package com.rfchina.community.open.bridge.entity;

import java.io.Serializable;
import java.util.Date;

public class ExtOpenManagerInviteMerchant implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer merchantId;
	private String merchantTitle;
	private String serviceTitle;
	private Date createTime;

	public Integer getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Integer merchantId) {
		this.merchantId = merchantId;
	}

	public String getMerchantTitle() {
		return merchantTitle;
	}

	public void setMerchantTitle(String merchantTitle) {
		this.merchantTitle = merchantTitle;
	}

	public String getServiceTitle() {
		return serviceTitle;
	}

	public void setServiceTitle(String serviceTitle) {
		this.serviceTitle = serviceTitle;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "ExtOpenManagerInviteMerchant [merchantTitle=" + merchantTitle + ", serviceTitle=" + serviceTitle
				+ ", createTime=" + createTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((merchantTitle == null) ? 0 : merchantTitle.hashCode());
		result = prime * result + ((serviceTitle == null) ? 0 : serviceTitle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExtOpenManagerInviteMerchant other = (ExtOpenManagerInviteMerchant) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (merchantTitle == null) {
			if (other.merchantTitle != null)
				return false;
		} else if (!merchantTitle.equals(other.merchantTitle))
			return false;
		if (serviceTitle == null) {
			if (other.serviceTitle != null)
				return false;
		} else if (!serviceTitle.equals(other.serviceTitle))
			return false;
		return true;
	}

}
