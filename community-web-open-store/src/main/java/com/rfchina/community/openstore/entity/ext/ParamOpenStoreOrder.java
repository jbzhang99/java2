package com.rfchina.community.openstore.entity.ext;

import java.math.BigDecimal;
import java.util.List;

public class ParamOpenStoreOrder {
	private long communityId;//社区id
	
	private String payChannel; //支付渠道
	
	private BigDecimal totalAmount;//总费用=总价 + 运费
	
	private String tradeType;
	
	private BigDecimal expressMoney; //运费
	
	private List<ParamOpenStoreGood> goodList; // 商品List
	
	private List<Integer> shoppingCartIdList; //购物车进来需要传递购物车的id进来
	
	private int addrInfoId;
	
	private String addrInfo;
	
	private String addrDetail;
	
	
	private BigDecimal goodsTotal; //商品总价
	
	private String remark;
	
	private String userName;
	
	private String mobile;
	
	private int serviceId;
	
	private BigDecimal originalPrice;
	
	private BigDecimal discountPrice;
	
	private List<MutiOrderCreateParam> mutiOrderCreateParam;
	
	
	
	public List<MutiOrderCreateParam> getMutiOrderCreateParam() {
		return mutiOrderCreateParam;
	}

	public void setMutiOrderCreateParam(List<MutiOrderCreateParam> mutiOrderCreateParam) {
		this.mutiOrderCreateParam = mutiOrderCreateParam;
	}

	public BigDecimal getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}

	public BigDecimal getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(BigDecimal discountPrice) {
		this.discountPrice = discountPrice;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getAddrDetail() {
		return addrDetail;
	}

	public void setAddrDetail(String addrDetail) {
		this.addrDetail = addrDetail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public BigDecimal getGoodsTotal() {
		return goodsTotal;
	}

	public void setGoodsTotal(BigDecimal goodsTotal) {
		this.goodsTotal = goodsTotal;
	}

	public int getAddrInfoId() {
		return addrInfoId;
	}

	public void setAddrInfoId(int addrInfoId) {
		this.addrInfoId = addrInfoId;
	}

	public String getAddrInfo() {
		return addrInfo;
	}

	public void setAddrInfo(String addrInfo) {
		this.addrInfo = addrInfo;
	}

	public List<Integer> getShoppingCartIdList() {
		return shoppingCartIdList;
	}

	public void setShoppingCartIdList(List<Integer> shoppingCartIdList) {
		this.shoppingCartIdList = shoppingCartIdList;
	}

	public long getCommunityId() {
		return communityId;
	}

	public void setCommunityId(long communityId) {
		this.communityId = communityId;
	}

	public String getPayChannel() {
		return payChannel;
	}

	public void setPayChannel(String payChannel) {
		this.payChannel = payChannel;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public BigDecimal getExpressMoney() {
		return expressMoney;
	}

	public void setExpressMoney(BigDecimal expressMoney) {
		this.expressMoney = expressMoney;
	}

	public List<ParamOpenStoreGood> getGoodList() {
		return goodList;
	}

	public void setGoodList(List<ParamOpenStoreGood> goodList) {
		this.goodList = goodList;
	}

	@Override
	public String toString() {
		return "ParamOpenStoreOrder [communityId=" + communityId + ", payChannel=" + payChannel + ", totalAmount="
				+ totalAmount + ", tradeType=" + tradeType + ", expressMoney=" + expressMoney + ", goodList=" + goodList
				+ ", shoppingCartIdList=" + shoppingCartIdList + ", addrInfoId=" + addrInfoId + ", addrInfo=" + addrInfo
				+ ", addrDetail=" + addrDetail + ", goodsTotal=" + goodsTotal + ", remark=" + remark + ", userName="
				+ userName + ", mobile=" + mobile + ", serviceId=" + serviceId + ", originalPrice=" + originalPrice
				+ ", discountPrice=" + discountPrice + "]";
	}

	
}
