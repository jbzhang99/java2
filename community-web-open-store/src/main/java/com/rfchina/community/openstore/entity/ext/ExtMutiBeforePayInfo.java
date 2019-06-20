package com.rfchina.community.openstore.entity.ext;

import java.math.BigDecimal;
import java.util.List;

import com.rfchina.community.openstore.entity.SimOpenStoreGood;
import com.rfchina.community.persistence.model.OpenStoreGood;
import com.rfchina.community.persistence.model.ext.SimCmActivityCardCouponRecord;

public class ExtMutiBeforePayInfo {
	private int serviceId;
	
	private List<OpenStoreGood> goodList;
	
	private List<SimOpenStoreGood> simGoodList;
	
	private ExtOpenStoreServiceTemplete templete;
	
	//商品总价
	private BigDecimal goodsPrice;
	//运费
	private BigDecimal expressMoney;
	//满减金额
	private BigDecimal discountPrice;
	//单个服务总价
	private BigDecimal totalAmount;
	
	private List<SimCmActivityCardCouponRecord> cardCouponRecordList;
	
	public List<SimCmActivityCardCouponRecord> getCardCouponRecordList() {
		return cardCouponRecordList;
	}

	public void setCardCouponRecordList(List<SimCmActivityCardCouponRecord> cardCouponRecordList) {
		this.cardCouponRecordList = cardCouponRecordList;
	}

	public BigDecimal getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public BigDecimal getExpressMoney() {
		return expressMoney;
	}

	public void setExpressMoney(BigDecimal expressMoney) {
		this.expressMoney = expressMoney;
	}

	public BigDecimal getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(BigDecimal discountPrice) {
		this.discountPrice = discountPrice;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<SimOpenStoreGood> getSimGoodList() {
		return simGoodList;
	}

	public void setSimGoodList(List<SimOpenStoreGood> simGoodList) {
		this.simGoodList = simGoodList;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public List<OpenStoreGood> getGoodList() {
		return goodList;
	}

	public void setGoodList(List<OpenStoreGood> goodList) {
		this.goodList = goodList;
	}

	public ExtOpenStoreServiceTemplete getTemplete() {
		return templete;
	}

	public void setTemplete(ExtOpenStoreServiceTemplete templete) {
		this.templete = templete;
	}
	
	
}
