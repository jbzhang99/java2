package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OpenStoreGood implements Serializable {
    private Integer id;

    private Integer serviceId;

    private String code;

    private String name;

    private String shortDetail;

    private BigDecimal prePrice;

    private BigDecimal price;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private Integer stock;

    private Integer saleAmount;

    private Integer virtualSaleAmount;

    private Integer totalSaleAmount;

    private Integer categoryId;

    private Integer verifyTimes;

    private Date verifyStartTime;

    private Date verifyEndTime;

    private Integer sorting;

    private Integer likeSorting;

    private Integer limitTimes;

    private String picUrl;

    private static final long serialVersionUID = 1L;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDetail() {
        return shortDetail;
    }

    public void setShortDetail(String shortDetail) {
        this.shortDetail = shortDetail;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(Integer saleAmount) {
        this.saleAmount = saleAmount;
    }

    public Integer getVirtualSaleAmount() {
        return virtualSaleAmount;
    }

    public void setVirtualSaleAmount(Integer virtualSaleAmount) {
        this.virtualSaleAmount = virtualSaleAmount;
    }

    public Integer getTotalSaleAmount() {
        return totalSaleAmount;
    }

    public void setTotalSaleAmount(Integer totalSaleAmount) {
        this.totalSaleAmount = totalSaleAmount;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getVerifyTimes() {
        return verifyTimes;
    }

    public void setVerifyTimes(Integer verifyTimes) {
        this.verifyTimes = verifyTimes;
    }

    public Date getVerifyStartTime() {
        return verifyStartTime;
    }

    public void setVerifyStartTime(Date verifyStartTime) {
        this.verifyStartTime = verifyStartTime;
    }

    public Date getVerifyEndTime() {
        return verifyEndTime;
    }

    public void setVerifyEndTime(Date verifyEndTime) {
        this.verifyEndTime = verifyEndTime;
    }

    public Integer getSorting() {
        return sorting;
    }

    public void setSorting(Integer sorting) {
        this.sorting = sorting;
    }

    public Integer getLikeSorting() {
        return likeSorting;
    }

    public void setLikeSorting(Integer likeSorting) {
        this.likeSorting = likeSorting;
    }

    public Integer getLimitTimes() {
        return limitTimes;
    }

    public void setLimitTimes(Integer limitTimes) {
        this.limitTimes = limitTimes;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", serviceId=").append(serviceId);
        sb.append(", code=").append(code);
        sb.append(", name=").append(name);
        sb.append(", shortDetail=").append(shortDetail);
        sb.append(", prePrice=").append(prePrice);
        sb.append(", price=").append(price);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", stock=").append(stock);
        sb.append(", saleAmount=").append(saleAmount);
        sb.append(", virtualSaleAmount=").append(virtualSaleAmount);
        sb.append(", totalSaleAmount=").append(totalSaleAmount);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", verifyTimes=").append(verifyTimes);
        sb.append(", verifyStartTime=").append(verifyStartTime);
        sb.append(", verifyEndTime=").append(verifyEndTime);
        sb.append(", sorting=").append(sorting);
        sb.append(", likeSorting=").append(likeSorting);
        sb.append(", limitTimes=").append(limitTimes);
        sb.append(", picUrl=").append(picUrl);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        OpenStoreGood other = (OpenStoreGood) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getServiceId() == null ? other.getServiceId() == null : this.getServiceId().equals(other.getServiceId()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getShortDetail() == null ? other.getShortDetail() == null : this.getShortDetail().equals(other.getShortDetail()))
            && (this.getPrePrice() == null ? other.getPrePrice() == null : this.getPrePrice().equals(other.getPrePrice()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getStock() == null ? other.getStock() == null : this.getStock().equals(other.getStock()))
            && (this.getSaleAmount() == null ? other.getSaleAmount() == null : this.getSaleAmount().equals(other.getSaleAmount()))
            && (this.getVirtualSaleAmount() == null ? other.getVirtualSaleAmount() == null : this.getVirtualSaleAmount().equals(other.getVirtualSaleAmount()))
            && (this.getTotalSaleAmount() == null ? other.getTotalSaleAmount() == null : this.getTotalSaleAmount().equals(other.getTotalSaleAmount()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getVerifyTimes() == null ? other.getVerifyTimes() == null : this.getVerifyTimes().equals(other.getVerifyTimes()))
            && (this.getVerifyStartTime() == null ? other.getVerifyStartTime() == null : this.getVerifyStartTime().equals(other.getVerifyStartTime()))
            && (this.getVerifyEndTime() == null ? other.getVerifyEndTime() == null : this.getVerifyEndTime().equals(other.getVerifyEndTime()))
            && (this.getSorting() == null ? other.getSorting() == null : this.getSorting().equals(other.getSorting()))
            && (this.getLikeSorting() == null ? other.getLikeSorting() == null : this.getLikeSorting().equals(other.getLikeSorting()))
            && (this.getLimitTimes() == null ? other.getLimitTimes() == null : this.getLimitTimes().equals(other.getLimitTimes()))
            && (this.getPicUrl() == null ? other.getPicUrl() == null : this.getPicUrl().equals(other.getPicUrl()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getServiceId() == null) ? 0 : getServiceId().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getShortDetail() == null) ? 0 : getShortDetail().hashCode());
        result = prime * result + ((getPrePrice() == null) ? 0 : getPrePrice().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getStock() == null) ? 0 : getStock().hashCode());
        result = prime * result + ((getSaleAmount() == null) ? 0 : getSaleAmount().hashCode());
        result = prime * result + ((getVirtualSaleAmount() == null) ? 0 : getVirtualSaleAmount().hashCode());
        result = prime * result + ((getTotalSaleAmount() == null) ? 0 : getTotalSaleAmount().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getVerifyTimes() == null) ? 0 : getVerifyTimes().hashCode());
        result = prime * result + ((getVerifyStartTime() == null) ? 0 : getVerifyStartTime().hashCode());
        result = prime * result + ((getVerifyEndTime() == null) ? 0 : getVerifyEndTime().hashCode());
        result = prime * result + ((getSorting() == null) ? 0 : getSorting().hashCode());
        result = prime * result + ((getLikeSorting() == null) ? 0 : getLikeSorting().hashCode());
        result = prime * result + ((getLimitTimes() == null) ? 0 : getLimitTimes().hashCode());
        result = prime * result + ((getPicUrl() == null) ? 0 : getPicUrl().hashCode());
        return result;
    }
}