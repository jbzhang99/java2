package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CmActivityCardCouponItem implements Serializable {
    private Long id;

    private String couponName;

    private Integer couponType;

    private Integer couponNum;

    private Integer stockNum;

    private Date validFromDate;

    private Date validToDate;

    private Date allowFromDate;

    private Date allowToDate;

    private Integer itemType;

    private String useRule;

    private String remark;

    private BigDecimal couponAmount;

    private BigDecimal payAmount;

    private Integer openStatus;

    private Integer deliverNum;

    private Integer userLimit;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public Integer getCouponType() {
        return couponType;
    }

    public void setCouponType(Integer couponType) {
        this.couponType = couponType;
    }

    public Integer getCouponNum() {
        return couponNum;
    }

    public void setCouponNum(Integer couponNum) {
        this.couponNum = couponNum;
    }

    public Integer getStockNum() {
        return stockNum;
    }

    public void setStockNum(Integer stockNum) {
        this.stockNum = stockNum;
    }

    public Date getValidFromDate() {
        return validFromDate;
    }

    public void setValidFromDate(Date validFromDate) {
        this.validFromDate = validFromDate;
    }

    public Date getValidToDate() {
        return validToDate;
    }

    public void setValidToDate(Date validToDate) {
        this.validToDate = validToDate;
    }

    public Date getAllowFromDate() {
        return allowFromDate;
    }

    public void setAllowFromDate(Date allowFromDate) {
        this.allowFromDate = allowFromDate;
    }

    public Date getAllowToDate() {
        return allowToDate;
    }

    public void setAllowToDate(Date allowToDate) {
        this.allowToDate = allowToDate;
    }

    public Integer getItemType() {
        return itemType;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }

    public String getUseRule() {
        return useRule;
    }

    public void setUseRule(String useRule) {
        this.useRule = useRule;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(BigDecimal couponAmount) {
        this.couponAmount = couponAmount;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public Integer getOpenStatus() {
        return openStatus;
    }

    public void setOpenStatus(Integer openStatus) {
        this.openStatus = openStatus;
    }

    public Integer getDeliverNum() {
        return deliverNum;
    }

    public void setDeliverNum(Integer deliverNum) {
        this.deliverNum = deliverNum;
    }

    public Integer getUserLimit() {
        return userLimit;
    }

    public void setUserLimit(Integer userLimit) {
        this.userLimit = userLimit;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", couponName=").append(couponName);
        sb.append(", couponType=").append(couponType);
        sb.append(", couponNum=").append(couponNum);
        sb.append(", stockNum=").append(stockNum);
        sb.append(", validFromDate=").append(validFromDate);
        sb.append(", validToDate=").append(validToDate);
        sb.append(", allowFromDate=").append(allowFromDate);
        sb.append(", allowToDate=").append(allowToDate);
        sb.append(", itemType=").append(itemType);
        sb.append(", useRule=").append(useRule);
        sb.append(", remark=").append(remark);
        sb.append(", couponAmount=").append(couponAmount);
        sb.append(", payAmount=").append(payAmount);
        sb.append(", openStatus=").append(openStatus);
        sb.append(", deliverNum=").append(deliverNum);
        sb.append(", userLimit=").append(userLimit);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
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
        CmActivityCardCouponItem other = (CmActivityCardCouponItem) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCouponName() == null ? other.getCouponName() == null : this.getCouponName().equals(other.getCouponName()))
            && (this.getCouponType() == null ? other.getCouponType() == null : this.getCouponType().equals(other.getCouponType()))
            && (this.getCouponNum() == null ? other.getCouponNum() == null : this.getCouponNum().equals(other.getCouponNum()))
            && (this.getStockNum() == null ? other.getStockNum() == null : this.getStockNum().equals(other.getStockNum()))
            && (this.getValidFromDate() == null ? other.getValidFromDate() == null : this.getValidFromDate().equals(other.getValidFromDate()))
            && (this.getValidToDate() == null ? other.getValidToDate() == null : this.getValidToDate().equals(other.getValidToDate()))
            && (this.getAllowFromDate() == null ? other.getAllowFromDate() == null : this.getAllowFromDate().equals(other.getAllowFromDate()))
            && (this.getAllowToDate() == null ? other.getAllowToDate() == null : this.getAllowToDate().equals(other.getAllowToDate()))
            && (this.getItemType() == null ? other.getItemType() == null : this.getItemType().equals(other.getItemType()))
            && (this.getUseRule() == null ? other.getUseRule() == null : this.getUseRule().equals(other.getUseRule()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCouponAmount() == null ? other.getCouponAmount() == null : this.getCouponAmount().equals(other.getCouponAmount()))
            && (this.getPayAmount() == null ? other.getPayAmount() == null : this.getPayAmount().equals(other.getPayAmount()))
            && (this.getOpenStatus() == null ? other.getOpenStatus() == null : this.getOpenStatus().equals(other.getOpenStatus()))
            && (this.getDeliverNum() == null ? other.getDeliverNum() == null : this.getDeliverNum().equals(other.getDeliverNum()))
            && (this.getUserLimit() == null ? other.getUserLimit() == null : this.getUserLimit().equals(other.getUserLimit()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCouponName() == null) ? 0 : getCouponName().hashCode());
        result = prime * result + ((getCouponType() == null) ? 0 : getCouponType().hashCode());
        result = prime * result + ((getCouponNum() == null) ? 0 : getCouponNum().hashCode());
        result = prime * result + ((getStockNum() == null) ? 0 : getStockNum().hashCode());
        result = prime * result + ((getValidFromDate() == null) ? 0 : getValidFromDate().hashCode());
        result = prime * result + ((getValidToDate() == null) ? 0 : getValidToDate().hashCode());
        result = prime * result + ((getAllowFromDate() == null) ? 0 : getAllowFromDate().hashCode());
        result = prime * result + ((getAllowToDate() == null) ? 0 : getAllowToDate().hashCode());
        result = prime * result + ((getItemType() == null) ? 0 : getItemType().hashCode());
        result = prime * result + ((getUseRule() == null) ? 0 : getUseRule().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCouponAmount() == null) ? 0 : getCouponAmount().hashCode());
        result = prime * result + ((getPayAmount() == null) ? 0 : getPayAmount().hashCode());
        result = prime * result + ((getOpenStatus() == null) ? 0 : getOpenStatus().hashCode());
        result = prime * result + ((getDeliverNum() == null) ? 0 : getDeliverNum().hashCode());
        result = prime * result + ((getUserLimit() == null) ? 0 : getUserLimit().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}