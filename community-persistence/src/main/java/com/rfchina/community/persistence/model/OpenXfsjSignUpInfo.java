package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OpenXfsjSignUpInfo implements Serializable {
    private Long id;

    private Long uid;

    private Long xfsjId;

    private Integer serviceId;

    private String billId;

    private Integer billStatus;

    private Date billCreateTime;

    private BigDecimal serviceFee;

    private String refuseContent;

    private Integer status;

    private Date createTime;

    private Long orderId;

    private BigDecimal platformChargeRate;

    private BigDecimal platformCharge;

    private BigDecimal receiptAmount;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getXfsjId() {
        return xfsjId;
    }

    public void setXfsjId(Long xfsjId) {
        this.xfsjId = xfsjId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public Integer getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(Integer billStatus) {
        this.billStatus = billStatus;
    }

    public Date getBillCreateTime() {
        return billCreateTime;
    }

    public void setBillCreateTime(Date billCreateTime) {
        this.billCreateTime = billCreateTime;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    public String getRefuseContent() {
        return refuseContent;
    }

    public void setRefuseContent(String refuseContent) {
        this.refuseContent = refuseContent;
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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getPlatformChargeRate() {
        return platformChargeRate;
    }

    public void setPlatformChargeRate(BigDecimal platformChargeRate) {
        this.platformChargeRate = platformChargeRate;
    }

    public BigDecimal getPlatformCharge() {
        return platformCharge;
    }

    public void setPlatformCharge(BigDecimal platformCharge) {
        this.platformCharge = platformCharge;
    }

    public BigDecimal getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptAmount(BigDecimal receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", uid=").append(uid);
        sb.append(", xfsjId=").append(xfsjId);
        sb.append(", serviceId=").append(serviceId);
        sb.append(", billId=").append(billId);
        sb.append(", billStatus=").append(billStatus);
        sb.append(", billCreateTime=").append(billCreateTime);
        sb.append(", serviceFee=").append(serviceFee);
        sb.append(", refuseContent=").append(refuseContent);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", orderId=").append(orderId);
        sb.append(", platformChargeRate=").append(platformChargeRate);
        sb.append(", platformCharge=").append(platformCharge);
        sb.append(", receiptAmount=").append(receiptAmount);
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
        OpenXfsjSignUpInfo other = (OpenXfsjSignUpInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getXfsjId() == null ? other.getXfsjId() == null : this.getXfsjId().equals(other.getXfsjId()))
            && (this.getServiceId() == null ? other.getServiceId() == null : this.getServiceId().equals(other.getServiceId()))
            && (this.getBillId() == null ? other.getBillId() == null : this.getBillId().equals(other.getBillId()))
            && (this.getBillStatus() == null ? other.getBillStatus() == null : this.getBillStatus().equals(other.getBillStatus()))
            && (this.getBillCreateTime() == null ? other.getBillCreateTime() == null : this.getBillCreateTime().equals(other.getBillCreateTime()))
            && (this.getServiceFee() == null ? other.getServiceFee() == null : this.getServiceFee().equals(other.getServiceFee()))
            && (this.getRefuseContent() == null ? other.getRefuseContent() == null : this.getRefuseContent().equals(other.getRefuseContent()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getPlatformChargeRate() == null ? other.getPlatformChargeRate() == null : this.getPlatformChargeRate().equals(other.getPlatformChargeRate()))
            && (this.getPlatformCharge() == null ? other.getPlatformCharge() == null : this.getPlatformCharge().equals(other.getPlatformCharge()))
            && (this.getReceiptAmount() == null ? other.getReceiptAmount() == null : this.getReceiptAmount().equals(other.getReceiptAmount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getXfsjId() == null) ? 0 : getXfsjId().hashCode());
        result = prime * result + ((getServiceId() == null) ? 0 : getServiceId().hashCode());
        result = prime * result + ((getBillId() == null) ? 0 : getBillId().hashCode());
        result = prime * result + ((getBillStatus() == null) ? 0 : getBillStatus().hashCode());
        result = prime * result + ((getBillCreateTime() == null) ? 0 : getBillCreateTime().hashCode());
        result = prime * result + ((getServiceFee() == null) ? 0 : getServiceFee().hashCode());
        result = prime * result + ((getRefuseContent() == null) ? 0 : getRefuseContent().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getPlatformChargeRate() == null) ? 0 : getPlatformChargeRate().hashCode());
        result = prime * result + ((getPlatformCharge() == null) ? 0 : getPlatformCharge().hashCode());
        result = prime * result + ((getReceiptAmount() == null) ? 0 : getReceiptAmount().hashCode());
        return result;
    }
}