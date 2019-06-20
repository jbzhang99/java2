package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OpenStoreVerifyCard implements Serializable {
    private Long id;

    private Integer serviceId;

    private Integer orderId;

    private Long uid;

    private Integer goodId;

    private Integer goodOrderRelId;

    private String goodCode;

    private String goodName;

    private String code;

    private Date verifyStartTime;

    private Date verifyEndTime;

    private Integer verifyStatus;

    private Date createTime;

    private Date verifyTime;

    private BigDecimal singleScalePrice;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public Integer getGoodOrderRelId() {
        return goodOrderRelId;
    }

    public void setGoodOrderRelId(Integer goodOrderRelId) {
        this.goodOrderRelId = goodOrderRelId;
    }

    public String getGoodCode() {
        return goodCode;
    }

    public void setGoodCode(String goodCode) {
        this.goodCode = goodCode;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Integer getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(Integer verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getVerifyTime() {
        return verifyTime;
    }

    public void setVerifyTime(Date verifyTime) {
        this.verifyTime = verifyTime;
    }

    public BigDecimal getSingleScalePrice() {
        return singleScalePrice;
    }

    public void setSingleScalePrice(BigDecimal singleScalePrice) {
        this.singleScalePrice = singleScalePrice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", serviceId=").append(serviceId);
        sb.append(", orderId=").append(orderId);
        sb.append(", uid=").append(uid);
        sb.append(", goodId=").append(goodId);
        sb.append(", goodOrderRelId=").append(goodOrderRelId);
        sb.append(", goodCode=").append(goodCode);
        sb.append(", goodName=").append(goodName);
        sb.append(", code=").append(code);
        sb.append(", verifyStartTime=").append(verifyStartTime);
        sb.append(", verifyEndTime=").append(verifyEndTime);
        sb.append(", verifyStatus=").append(verifyStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", verifyTime=").append(verifyTime);
        sb.append(", singleScalePrice=").append(singleScalePrice);
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
        OpenStoreVerifyCard other = (OpenStoreVerifyCard) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getServiceId() == null ? other.getServiceId() == null : this.getServiceId().equals(other.getServiceId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getGoodId() == null ? other.getGoodId() == null : this.getGoodId().equals(other.getGoodId()))
            && (this.getGoodOrderRelId() == null ? other.getGoodOrderRelId() == null : this.getGoodOrderRelId().equals(other.getGoodOrderRelId()))
            && (this.getGoodCode() == null ? other.getGoodCode() == null : this.getGoodCode().equals(other.getGoodCode()))
            && (this.getGoodName() == null ? other.getGoodName() == null : this.getGoodName().equals(other.getGoodName()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getVerifyStartTime() == null ? other.getVerifyStartTime() == null : this.getVerifyStartTime().equals(other.getVerifyStartTime()))
            && (this.getVerifyEndTime() == null ? other.getVerifyEndTime() == null : this.getVerifyEndTime().equals(other.getVerifyEndTime()))
            && (this.getVerifyStatus() == null ? other.getVerifyStatus() == null : this.getVerifyStatus().equals(other.getVerifyStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getVerifyTime() == null ? other.getVerifyTime() == null : this.getVerifyTime().equals(other.getVerifyTime()))
            && (this.getSingleScalePrice() == null ? other.getSingleScalePrice() == null : this.getSingleScalePrice().equals(other.getSingleScalePrice()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getServiceId() == null) ? 0 : getServiceId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getGoodId() == null) ? 0 : getGoodId().hashCode());
        result = prime * result + ((getGoodOrderRelId() == null) ? 0 : getGoodOrderRelId().hashCode());
        result = prime * result + ((getGoodCode() == null) ? 0 : getGoodCode().hashCode());
        result = prime * result + ((getGoodName() == null) ? 0 : getGoodName().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getVerifyStartTime() == null) ? 0 : getVerifyStartTime().hashCode());
        result = prime * result + ((getVerifyEndTime() == null) ? 0 : getVerifyEndTime().hashCode());
        result = prime * result + ((getVerifyStatus() == null) ? 0 : getVerifyStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getVerifyTime() == null) ? 0 : getVerifyTime().hashCode());
        result = prime * result + ((getSingleScalePrice() == null) ? 0 : getSingleScalePrice().hashCode());
        return result;
    }
}