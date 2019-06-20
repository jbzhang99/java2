package com.rfchina.community.persistence.model.ext;

import java.util.List;

import com.rfchina.community.persistence.model.OpenFeeOrderPay;

public class ExtOpenFeeOrderPay extends OpenFeeOrderPay{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String serviceName;
	private String merchantName;
	private List<SimOpenFeeOrder> orderList;
	
	public List<SimOpenFeeOrder> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<SimOpenFeeOrder> orderList) {
		this.orderList = orderList;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	
	
}
