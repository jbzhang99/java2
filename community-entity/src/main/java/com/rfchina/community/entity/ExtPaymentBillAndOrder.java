package com.rfchina.community.entity;

import java.io.Serializable;

public class ExtPaymentBillAndOrder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ExtPaymentBill extPaymentBill;
	
	private ExtHouses extHouses;

	public ExtPaymentBill getExtPaymentBill() {
		return extPaymentBill;
	}

	public void setExtPaymentBill(ExtPaymentBill extPaymentBill) {
		this.extPaymentBill = extPaymentBill;
	}

	public ExtHouses getExtHouses() {
		return extHouses;
	}

	public void setExtHouses(ExtHouses extHouses) {
		this.extHouses = extHouses;
	}
}
