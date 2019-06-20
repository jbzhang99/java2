package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OpenXFSJBusinessInfo implements Serializable {
    private Long xfsjId;

    private Integer amount;

    private BigDecimal serviceFee;

    private String type;

    private String contactPhone;

    private Date signUpEndTime;

    private Integer signUpStatus;

    private String localeDetail;

    private String localeImg;

    private static final long serialVersionUID = 1L;

    public Long getXfsjId() {
        return xfsjId;
    }

    public void setXfsjId(Long xfsjId) {
        this.xfsjId = xfsjId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public Date getSignUpEndTime() {
        return signUpEndTime;
    }

    public void setSignUpEndTime(Date signUpEndTime) {
        this.signUpEndTime = signUpEndTime;
    }

    public Integer getSignUpStatus() {
        return signUpStatus;
    }

    public void setSignUpStatus(Integer signUpStatus) {
        this.signUpStatus = signUpStatus;
    }

    public String getLocaleDetail() {
        return localeDetail;
    }

    public void setLocaleDetail(String localeDetail) {
        this.localeDetail = localeDetail;
    }

    public String getLocaleImg() {
        return localeImg;
    }

    public void setLocaleImg(String localeImg) {
        this.localeImg = localeImg;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", xfsjId=").append(xfsjId);
        sb.append(", amount=").append(amount);
        sb.append(", serviceFee=").append(serviceFee);
        sb.append(", type=").append(type);
        sb.append(", contactPhone=").append(contactPhone);
        sb.append(", signUpEndTime=").append(signUpEndTime);
        sb.append(", signUpStatus=").append(signUpStatus);
        sb.append(", localeDetail=").append(localeDetail);
        sb.append(", localeImg=").append(localeImg);
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
        OpenXFSJBusinessInfo other = (OpenXFSJBusinessInfo) that;
        return (this.getXfsjId() == null ? other.getXfsjId() == null : this.getXfsjId().equals(other.getXfsjId()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getServiceFee() == null ? other.getServiceFee() == null : this.getServiceFee().equals(other.getServiceFee()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getContactPhone() == null ? other.getContactPhone() == null : this.getContactPhone().equals(other.getContactPhone()))
            && (this.getSignUpEndTime() == null ? other.getSignUpEndTime() == null : this.getSignUpEndTime().equals(other.getSignUpEndTime()))
            && (this.getSignUpStatus() == null ? other.getSignUpStatus() == null : this.getSignUpStatus().equals(other.getSignUpStatus()))
            && (this.getLocaleDetail() == null ? other.getLocaleDetail() == null : this.getLocaleDetail().equals(other.getLocaleDetail()))
            && (this.getLocaleImg() == null ? other.getLocaleImg() == null : this.getLocaleImg().equals(other.getLocaleImg()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getXfsjId() == null) ? 0 : getXfsjId().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getServiceFee() == null) ? 0 : getServiceFee().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getContactPhone() == null) ? 0 : getContactPhone().hashCode());
        result = prime * result + ((getSignUpEndTime() == null) ? 0 : getSignUpEndTime().hashCode());
        result = prime * result + ((getSignUpStatus() == null) ? 0 : getSignUpStatus().hashCode());
        result = prime * result + ((getLocaleDetail() == null) ? 0 : getLocaleDetail().hashCode());
        result = prime * result + ((getLocaleImg() == null) ? 0 : getLocaleImg().hashCode());
        return result;
    }
}