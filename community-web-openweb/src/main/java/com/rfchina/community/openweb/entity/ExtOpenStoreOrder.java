package com.rfchina.community.openweb.entity;

import com.rfchina.community.persistence.model.OpenFeeOrderWithBLOBs;
import com.rfchina.community.persistence.model.OpenStoreGoodOrderRel;
import com.rfchina.community.persistence.model.OpenStoreOrder;

import java.io.Serializable;
import java.util.List;

public class ExtOpenStoreOrder extends OpenStoreOrder implements Serializable {

	private List<OpenStoreGoodOrderRel> goodList;

	private List<OpenFeeOrderWithBLOBs> feeOrderList ;
	
	private Boolean isNeedVerify;
	
	private String reasonCertificate;

	private Long commentId;

	private int groupSuccessStatus;


	public Boolean getNeedVerify() {
		return isNeedVerify;
	}

	public void setNeedVerify(Boolean needVerify) {
		isNeedVerify = needVerify;
	}

	public int getGroupSuccessStatus() {
		return groupSuccessStatus;
	}

	public void setGroupSuccessStatus(int groupSuccessStatus) {
		this.groupSuccessStatus = groupSuccessStatus;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getReasonCertificate() {
		return reasonCertificate;
	}

	public void setReasonCertificate(String reasonCertificate) {
		this.reasonCertificate = reasonCertificate;
	}

	public Boolean getIsNeedVerify() {
		return isNeedVerify;
	}

	public void setIsNeedVerify(Boolean isNeedVerify) {
		this.isNeedVerify = isNeedVerify;
	}

	private static final long serialVersionUID = 1L;

	public List<OpenStoreGoodOrderRel> getGoodList() {
		return goodList;
	}

	public void setGoodList(List<OpenStoreGoodOrderRel> goodList) {
		this.goodList = goodList;
	}

	public List<OpenFeeOrderWithBLOBs> getFeeOrderList() {
		return feeOrderList;
	}

	public void setFeeOrderList(List<OpenFeeOrderWithBLOBs> feeOrderList) {
		this.feeOrderList = feeOrderList;
	}

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
}