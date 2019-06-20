package com.rfchina.community.openstore.entity.ext;

import java.math.BigDecimal;
import java.util.List;

public class MutiOrderCreateParam {
	private int serviceId;
	private BigDecimal totalAmount;	//实付金额
	private BigDecimal expressMoney;	//运费金额
	private BigDecimal discountPrice;	//满减金额
	private BigDecimal goodTotal;
	private String goodList;
	private List<ParamOpenStoreGood> storeGoodList;
	private String remark;
	private BigDecimal originalPrice;	//原价
	private long couponRecordId;	//用户优惠券id
	private BigDecimal couponSubPrice;	//优惠券减免价格
	private Long groupInfoId;

	public Long getGroupInfoId() {

		return groupInfoId;
	}

	public void setGroupInfoId(Long groupInfoId) {
		this.groupInfoId = groupInfoId;
	}

	public long getCouponRecordId() {
		return couponRecordId;
	}
	public void setCouponRecordId(long couponRecordId) {
		this.couponRecordId = couponRecordId;
	}
	public BigDecimal getCouponSubPrice() {
		return couponSubPrice;
	}
	public void setCouponSubPrice(BigDecimal couponSubPrice) {
		this.couponSubPrice = couponSubPrice;
	}
	public BigDecimal getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}
	public BigDecimal getGoodTotal() {
		return goodTotal;
	}
	public void setGoodTotal(BigDecimal goodTotal) {
		this.goodTotal = goodTotal;
	}
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public List<ParamOpenStoreGood> getStoreGoodList() {
		return storeGoodList;
	}
	public void setStoreGoodList(List<ParamOpenStoreGood> storeGoodList) {
		this.storeGoodList = storeGoodList;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount.setScale(2, BigDecimal.ROUND_HALF_DOWN);
	}
	public BigDecimal getExpressMoney() {
		return expressMoney;
	}
	public void setExpressMoney(BigDecimal expressMoney) {
		this.expressMoney = expressMoney.setScale(2, BigDecimal.ROUND_HALF_DOWN);
	}
	public BigDecimal getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(BigDecimal discountPrice) {
		this.discountPrice = discountPrice.setScale(2, BigDecimal.ROUND_HALF_DOWN);
	}
	
	public String getGoodList() {
		return goodList;
	}
	public void setGoodList(String goodList) {
		this.goodList = goodList;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
