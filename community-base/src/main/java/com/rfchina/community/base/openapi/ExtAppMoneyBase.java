package com.rfchina.community.base.openapi;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rfchina.api.request.pay.FuPayCreateRequest.GoodsDetail;

public class ExtAppMoneyBase {
	

	Long appId;
	Integer openStoreId;
	String rfOpenId;
	Long uid;
	String outTradeNo;
	BigDecimal totalAmount;
	String subject;
	String body;
	String detail;
	List<GoodsDetail> goodsDetails = new ArrayList<>();

	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public List<GoodsDetail> getGoodsDetails() {
		return goodsDetails;
	}

	public void setGoodsDetails(List<GoodsDetail> goodsDetails) {
		this.goodsDetails = goodsDetails;
	}

	public Integer getOpenStoreId() {
		return openStoreId;
	}

	public void setOpenStoreId(Integer openStoreId) {
		this.openStoreId = openStoreId;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getRfOpenId() {
		return rfOpenId;
	}

	public void setRfOpenId(String rfOpenId) {
		this.rfOpenId = rfOpenId;
	}

}
