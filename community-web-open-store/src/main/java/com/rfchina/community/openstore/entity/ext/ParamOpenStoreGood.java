package com.rfchina.community.openstore.entity.ext;

import java.math.BigDecimal;

public class ParamOpenStoreGood {
	private int goodId; //商品id
	private int amount; //商品数量
	private long groupDataId; //团id
	private long groupInfoId;
	private BigDecimal goodPrice;
	private int stock;
	private int groupStockStatus;
	private int limitTimes;

	private String goodsName;

	public long getGroupInfoId() {
		return groupInfoId;
	}

	public void setGroupInfoId(long groupInfoId) {
		this.groupInfoId = groupInfoId;
	}

	public int getGroupStockStatus() {
		return groupStockStatus;
	}

	public void setGroupStockStatus(int groupStockStatus) {
		this.groupStockStatus = groupStockStatus;
	}

	public int getLimitTimes() {
		return limitTimes;
	}

	public void setLimitTimes(int limitTimes) {
		this.limitTimes = limitTimes;
	}

	public BigDecimal getGoodPrice() {
		return goodPrice;
	}

	public void setGoodPrice(BigDecimal goodPrice) {
		this.goodPrice = goodPrice;
	}

	public long getGroupDataId() {
		return groupDataId;
	}

	public void setGroupDataId(long groupDataId) {
		this.groupDataId = groupDataId;
	}

	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getGoodId() {
		return goodId;
	}
	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	@Override
	public String toString() {
		return "ParamOpenStoreGood [goodId=" + goodId + ", amount=" + amount + ", stock=" + stock + ", goodsName=" + goodsName + "]";
	}
	
	
}
