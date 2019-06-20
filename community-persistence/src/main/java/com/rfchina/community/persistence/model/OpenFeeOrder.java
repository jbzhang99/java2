package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OpenFeeOrder implements Serializable {
    private Long id;

    private Integer communityId;

    private Integer serviceId;

    private String verifyNo;

    private Date createTime;

    private String type;

    private String orderNo;

    private Integer storeOrderId;

    private BigDecimal tradeAmount;

    private BigDecimal platformCharge;

    private BigDecimal platformChargeRate;

    private BigDecimal serviceCharge;

    private BigDecimal serviceChargeRate;

    private BigDecimal payAmount;

    private Long payId;

    private String payStatus;

    private Date payTime;

    private String orderExplain;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getVerifyNo() {
        return verifyNo;
    }

    public void setVerifyNo(String verifyNo) {
        this.verifyNo = verifyNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getStoreOrderId() {
        return storeOrderId;
    }

    public void setStoreOrderId(Integer storeOrderId) {
        this.storeOrderId = storeOrderId;
    }

    public BigDecimal getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(BigDecimal tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public BigDecimal getPlatformCharge() {
        return platformCharge;
    }

    public void setPlatformCharge(BigDecimal platformCharge) {
        this.platformCharge = platformCharge;
    }

    public BigDecimal getPlatformChargeRate() {
        return platformChargeRate;
    }

    public void setPlatformChargeRate(BigDecimal platformChargeRate) {
        this.platformChargeRate = platformChargeRate;
    }

    public BigDecimal getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(BigDecimal serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public BigDecimal getServiceChargeRate() {
        return serviceChargeRate;
    }

    public void setServiceChargeRate(BigDecimal serviceChargeRate) {
        this.serviceChargeRate = serviceChargeRate;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public Long getPayId() {
        return payId;
    }

    public void setPayId(Long payId) {
        this.payId = payId;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getOrderExplain() {
        return orderExplain;
    }

    public void setOrderExplain(String orderExplain) {
        this.orderExplain = orderExplain;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", communityId=").append(communityId);
        sb.append(", serviceId=").append(serviceId);
        sb.append(", verifyNo=").append(verifyNo);
        sb.append(", createTime=").append(createTime);
        sb.append(", type=").append(type);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", storeOrderId=").append(storeOrderId);
        sb.append(", tradeAmount=").append(tradeAmount);
        sb.append(", platformCharge=").append(platformCharge);
        sb.append(", platformChargeRate=").append(platformChargeRate);
        sb.append(", serviceCharge=").append(serviceCharge);
        sb.append(", serviceChargeRate=").append(serviceChargeRate);
        sb.append(", payAmount=").append(payAmount);
        sb.append(", payId=").append(payId);
        sb.append(", payStatus=").append(payStatus);
        sb.append(", payTime=").append(payTime);
        sb.append(", orderExplain=").append(orderExplain);
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
        OpenFeeOrder other = (OpenFeeOrder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getServiceId() == null ? other.getServiceId() == null : this.getServiceId().equals(other.getServiceId()))
            && (this.getVerifyNo() == null ? other.getVerifyNo() == null : this.getVerifyNo().equals(other.getVerifyNo()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
            && (this.getStoreOrderId() == null ? other.getStoreOrderId() == null : this.getStoreOrderId().equals(other.getStoreOrderId()))
            && (this.getTradeAmount() == null ? other.getTradeAmount() == null : this.getTradeAmount().equals(other.getTradeAmount()))
            && (this.getPlatformCharge() == null ? other.getPlatformCharge() == null : this.getPlatformCharge().equals(other.getPlatformCharge()))
            && (this.getPlatformChargeRate() == null ? other.getPlatformChargeRate() == null : this.getPlatformChargeRate().equals(other.getPlatformChargeRate()))
            && (this.getServiceCharge() == null ? other.getServiceCharge() == null : this.getServiceCharge().equals(other.getServiceCharge()))
            && (this.getServiceChargeRate() == null ? other.getServiceChargeRate() == null : this.getServiceChargeRate().equals(other.getServiceChargeRate()))
            && (this.getPayAmount() == null ? other.getPayAmount() == null : this.getPayAmount().equals(other.getPayAmount()))
            && (this.getPayId() == null ? other.getPayId() == null : this.getPayId().equals(other.getPayId()))
            && (this.getPayStatus() == null ? other.getPayStatus() == null : this.getPayStatus().equals(other.getPayStatus()))
            && (this.getPayTime() == null ? other.getPayTime() == null : this.getPayTime().equals(other.getPayTime()))
            && (this.getOrderExplain() == null ? other.getOrderExplain() == null : this.getOrderExplain().equals(other.getOrderExplain()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getServiceId() == null) ? 0 : getServiceId().hashCode());
        result = prime * result + ((getVerifyNo() == null) ? 0 : getVerifyNo().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getStoreOrderId() == null) ? 0 : getStoreOrderId().hashCode());
        result = prime * result + ((getTradeAmount() == null) ? 0 : getTradeAmount().hashCode());
        result = prime * result + ((getPlatformCharge() == null) ? 0 : getPlatformCharge().hashCode());
        result = prime * result + ((getPlatformChargeRate() == null) ? 0 : getPlatformChargeRate().hashCode());
        result = prime * result + ((getServiceCharge() == null) ? 0 : getServiceCharge().hashCode());
        result = prime * result + ((getServiceChargeRate() == null) ? 0 : getServiceChargeRate().hashCode());
        result = prime * result + ((getPayAmount() == null) ? 0 : getPayAmount().hashCode());
        result = prime * result + ((getPayId() == null) ? 0 : getPayId().hashCode());
        result = prime * result + ((getPayStatus() == null) ? 0 : getPayStatus().hashCode());
        result = prime * result + ((getPayTime() == null) ? 0 : getPayTime().hashCode());
        result = prime * result + ((getOrderExplain() == null) ? 0 : getOrderExplain().hashCode());
        return result;
    }
}