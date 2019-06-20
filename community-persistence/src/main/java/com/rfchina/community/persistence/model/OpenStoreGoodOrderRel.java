package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OpenStoreGoodOrderRel implements Serializable {
    private Integer id;

    private Integer orderId;

    private Integer goodId;

    private BigDecimal currentSinglePrice;

    private Integer amount;

    private String goodName;

    private String goodCode;

    private String goodImgUrl;

    private Integer verifyTimes;

    private Date verifyStartTime;

    private Date verifyEndTime;

    private Integer payStatus;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public BigDecimal getCurrentSinglePrice() {
        return currentSinglePrice;
    }

    public void setCurrentSinglePrice(BigDecimal currentSinglePrice) {
        this.currentSinglePrice = currentSinglePrice;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getGoodCode() {
        return goodCode;
    }

    public void setGoodCode(String goodCode) {
        this.goodCode = goodCode;
    }

    public String getGoodImgUrl() {
        return goodImgUrl;
    }

    public void setGoodImgUrl(String goodImgUrl) {
        this.goodImgUrl = goodImgUrl;
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

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderId=").append(orderId);
        sb.append(", goodId=").append(goodId);
        sb.append(", currentSinglePrice=").append(currentSinglePrice);
        sb.append(", amount=").append(amount);
        sb.append(", goodName=").append(goodName);
        sb.append(", goodCode=").append(goodCode);
        sb.append(", goodImgUrl=").append(goodImgUrl);
        sb.append(", verifyTimes=").append(verifyTimes);
        sb.append(", verifyStartTime=").append(verifyStartTime);
        sb.append(", verifyEndTime=").append(verifyEndTime);
        sb.append(", payStatus=").append(payStatus);
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
        OpenStoreGoodOrderRel other = (OpenStoreGoodOrderRel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getGoodId() == null ? other.getGoodId() == null : this.getGoodId().equals(other.getGoodId()))
            && (this.getCurrentSinglePrice() == null ? other.getCurrentSinglePrice() == null : this.getCurrentSinglePrice().equals(other.getCurrentSinglePrice()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getGoodName() == null ? other.getGoodName() == null : this.getGoodName().equals(other.getGoodName()))
            && (this.getGoodCode() == null ? other.getGoodCode() == null : this.getGoodCode().equals(other.getGoodCode()))
            && (this.getGoodImgUrl() == null ? other.getGoodImgUrl() == null : this.getGoodImgUrl().equals(other.getGoodImgUrl()))
            && (this.getVerifyTimes() == null ? other.getVerifyTimes() == null : this.getVerifyTimes().equals(other.getVerifyTimes()))
            && (this.getVerifyStartTime() == null ? other.getVerifyStartTime() == null : this.getVerifyStartTime().equals(other.getVerifyStartTime()))
            && (this.getVerifyEndTime() == null ? other.getVerifyEndTime() == null : this.getVerifyEndTime().equals(other.getVerifyEndTime()))
            && (this.getPayStatus() == null ? other.getPayStatus() == null : this.getPayStatus().equals(other.getPayStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getGoodId() == null) ? 0 : getGoodId().hashCode());
        result = prime * result + ((getCurrentSinglePrice() == null) ? 0 : getCurrentSinglePrice().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getGoodName() == null) ? 0 : getGoodName().hashCode());
        result = prime * result + ((getGoodCode() == null) ? 0 : getGoodCode().hashCode());
        result = prime * result + ((getGoodImgUrl() == null) ? 0 : getGoodImgUrl().hashCode());
        result = prime * result + ((getVerifyTimes() == null) ? 0 : getVerifyTimes().hashCode());
        result = prime * result + ((getVerifyStartTime() == null) ? 0 : getVerifyStartTime().hashCode());
        result = prime * result + ((getVerifyEndTime() == null) ? 0 : getVerifyEndTime().hashCode());
        result = prime * result + ((getPayStatus() == null) ? 0 : getPayStatus().hashCode());
        return result;
    }
}