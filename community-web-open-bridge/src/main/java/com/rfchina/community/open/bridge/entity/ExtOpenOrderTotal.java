package com.rfchina.community.open.bridge.entity;

import java.util.List;

import com.rfchina.community.persistence.model.OpenOrder;
import com.rfchina.community.persistence.model.OpenOrderTotal;

public class ExtOpenOrderTotal extends OpenOrderTotal{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4298461192963475245L;

	private String communityName;
	
	private List<SimOpenOrder> orderList;
	
	private String firstStoreName;
	
	private String phone;
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFirstStoreName() {
		return firstStoreName;
	}

	public void setFirstStoreName(String firstStoreName) {
		this.firstStoreName = firstStoreName;
	}


	public List<SimOpenOrder> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<SimOpenOrder> orderList) {
		this.orderList = orderList;
	}

	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}
	
}
