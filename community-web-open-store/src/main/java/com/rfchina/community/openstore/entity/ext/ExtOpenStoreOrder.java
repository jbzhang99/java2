package com.rfchina.community.openstore.entity.ext;

import com.rfchina.community.persistence.model.OpenFeeOrderWithBLOBs;
import com.rfchina.community.persistence.model.OpenStoreOrder;
import com.rfchina.community.service.openser.entity.OpenStoreGoodOrderRelVO;

import java.io.Serializable;
import java.util.List;

public class ExtOpenStoreOrder extends OpenStoreOrder implements Serializable {
    
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<OpenStoreGoodOrderRelVO> goodList;
	
	private int openPoint;
	
	private String billId;
	
	private String storePhone;
	
	private Boolean isNeedVerify;
	
	private List<OpenFeeOrderWithBLOBs> feeOrderList ;

	private Integer billSplitStatus;

	private int groupDataStatus;

	private int groupSuccessHour;

	public int getGroupSuccessHour() {
		return groupSuccessHour;
	}

	public void setGroupSuccessHour(int groupSuccessHour) {
		this.groupSuccessHour = groupSuccessHour;
	}

	public int getGroupDataStatus() {
		return groupDataStatus;
	}

	public void setGroupDataStatus(int groupDataStatus) {
		this.groupDataStatus = groupDataStatus;
	}

	public Integer getBillSplitStatus() {

		return billSplitStatus;
	}

	public void setBillSplitStatus(Integer billSplitStatus) {
		this.billSplitStatus = billSplitStatus;
	}

	public Boolean getIsNeedVerify() {
		return isNeedVerify;
	}

	public void setIsNeedVerify(Boolean isNeedVerify) {
		this.isNeedVerify = isNeedVerify;
	}

	public String getStorePhone() {
		return storePhone;
	}

	public void setStorePhone(String storePhone) {
		this.storePhone = storePhone;
	}

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public int getOpenPoint() {
		return openPoint;
	}

	public void setOpenPoint(int openPoint) {
		this.openPoint = openPoint;
	}


	public List<OpenStoreGoodOrderRelVO> getGoodList() {
		return goodList;
	}

	public void setGoodList(List<OpenStoreGoodOrderRelVO> goodList) {
		this.goodList = goodList;
	}

	public List<OpenFeeOrderWithBLOBs> getFeeOrderList() {
		return feeOrderList;
	}

	public void setFeeOrderList(List<OpenFeeOrderWithBLOBs> feeOrderList) {
		this.feeOrderList = feeOrderList;
	}
    
   
}