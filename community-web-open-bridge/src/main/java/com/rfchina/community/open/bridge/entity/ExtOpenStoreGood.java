package com.rfchina.community.open.bridge.entity;

import com.rfchina.community.persistence.model.OpenGoodShowCategory;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ExtOpenStoreGood  implements Serializable {
    private Integer id;

    private Integer serviceId;

    private String name;

    private String storeName;
    
    private String merchantName;

    private BigDecimal prePrice;

    private BigDecimal price;
    
    private int saleAmount;

    private Integer status;
    
    private Date createTime;
    
    private int categoryId;
    
    private String categoryName;


	private Integer commentNum;

	private Integer goodCommentNum;

	private Integer middleCommentNum;

	private Integer badCommentNum;

	private int virtualSaleAmount;

	private int totalSaleAmount;

	private Integer likeSorting;

	private String detail;

	private String picUrl;

	private List<OpenGoodShowCategory> showCategoryList;

	private Integer sorting;

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public List<OpenGoodShowCategory> getShowCategoryList() {
		return showCategoryList;
	}

	public void setShowCategoryList(List<OpenGoodShowCategory> showCategoryList) {
		this.showCategoryList = showCategoryList;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getVirtualSaleAmount() {
		return virtualSaleAmount;
	}

	public void setVirtualSaleAmount(int virtualSaleAmount) {
		this.virtualSaleAmount = virtualSaleAmount;
	}

	public int getTotalSaleAmount() {
		return totalSaleAmount;
	}

	public void setTotalSaleAmount(int totalSaleAmount) {
		this.totalSaleAmount = totalSaleAmount;
	}

	public Integer getLikeSorting() {
		return likeSorting;
	}

	public void setLikeSorting(Integer likeSorting) {
		this.likeSorting = likeSorting;
	}

	public Integer getSorting() {
		return sorting;
	}

	public void setSorting(Integer sorting) {
		this.sorting = sorting;
	}



	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public BigDecimal getPrePrice() {
		return prePrice;
	}

	public void setPrePrice(BigDecimal prePrice) {
		this.prePrice = prePrice;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getSaleAmount() {
		return saleAmount;
	}

	public void setSaleAmount(int saleAmount) {
		this.saleAmount = saleAmount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}

	public Integer getGoodCommentNum() {
		return goodCommentNum;
	}

	public void setGoodCommentNum(Integer goodCommentNum) {
		this.goodCommentNum = goodCommentNum;
	}

	public Integer getMiddleCommentNum() {
		return middleCommentNum;
	}

	public void setMiddleCommentNum(Integer middleCommentNum) {
		this.middleCommentNum = middleCommentNum;
	}

	public Integer getBadCommentNum() {
		return badCommentNum;
	}

	public void setBadCommentNum(Integer badCommentNum) {
		this.badCommentNum = badCommentNum;
	}

}