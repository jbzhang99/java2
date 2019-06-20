package com.rfchina.community.persistence.model;

import java.io.Serializable;

public class OpenServiceDetail implements Serializable {
    private Integer serviceId;

    private String developType;

    private String templeteName;

    private Integer templeteStatus;

    private Integer appIndexSort;

    private Integer appCatSort;

    private Integer rfchinaCode;

    private Integer cautionRefundStatus;

    private String cautionRefundReason;

    private Integer xfsjStatus;

    private Integer categorySecondType;

    private String protocolUrl;

    private String verifyRole;

    private static final long serialVersionUID = 1L;

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getDevelopType() {
        return developType;
    }

    public void setDevelopType(String developType) {
        this.developType = developType;
    }

    public String getTempleteName() {
        return templeteName;
    }

    public void setTempleteName(String templeteName) {
        this.templeteName = templeteName;
    }

    public Integer getTempleteStatus() {
        return templeteStatus;
    }

    public void setTempleteStatus(Integer templeteStatus) {
        this.templeteStatus = templeteStatus;
    }

    public Integer getAppIndexSort() {
        return appIndexSort;
    }

    public void setAppIndexSort(Integer appIndexSort) {
        this.appIndexSort = appIndexSort;
    }

    public Integer getAppCatSort() {
        return appCatSort;
    }

    public void setAppCatSort(Integer appCatSort) {
        this.appCatSort = appCatSort;
    }

    public Integer getRfchinaCode() {
        return rfchinaCode;
    }

    public void setRfchinaCode(Integer rfchinaCode) {
        this.rfchinaCode = rfchinaCode;
    }

    public Integer getCautionRefundStatus() {
        return cautionRefundStatus;
    }

    public void setCautionRefundStatus(Integer cautionRefundStatus) {
        this.cautionRefundStatus = cautionRefundStatus;
    }

    public String getCautionRefundReason() {
        return cautionRefundReason;
    }

    public void setCautionRefundReason(String cautionRefundReason) {
        this.cautionRefundReason = cautionRefundReason;
    }

    public Integer getXfsjStatus() {
        return xfsjStatus;
    }

    public void setXfsjStatus(Integer xfsjStatus) {
        this.xfsjStatus = xfsjStatus;
    }

    public Integer getCategorySecondType() {
        return categorySecondType;
    }

    public void setCategorySecondType(Integer categorySecondType) {
        this.categorySecondType = categorySecondType;
    }

    public String getProtocolUrl() {
        return protocolUrl;
    }

    public void setProtocolUrl(String protocolUrl) {
        this.protocolUrl = protocolUrl;
    }

    public String getVerifyRole() {
        return verifyRole;
    }

    public void setVerifyRole(String verifyRole) {
        this.verifyRole = verifyRole;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serviceId=").append(serviceId);
        sb.append(", developType=").append(developType);
        sb.append(", templeteName=").append(templeteName);
        sb.append(", templeteStatus=").append(templeteStatus);
        sb.append(", appIndexSort=").append(appIndexSort);
        sb.append(", appCatSort=").append(appCatSort);
        sb.append(", rfchinaCode=").append(rfchinaCode);
        sb.append(", cautionRefundStatus=").append(cautionRefundStatus);
        sb.append(", cautionRefundReason=").append(cautionRefundReason);
        sb.append(", xfsjStatus=").append(xfsjStatus);
        sb.append(", categorySecondType=").append(categorySecondType);
        sb.append(", protocolUrl=").append(protocolUrl);
        sb.append(", verifyRole=").append(verifyRole);
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
        OpenServiceDetail other = (OpenServiceDetail) that;
        return (this.getServiceId() == null ? other.getServiceId() == null : this.getServiceId().equals(other.getServiceId()))
            && (this.getDevelopType() == null ? other.getDevelopType() == null : this.getDevelopType().equals(other.getDevelopType()))
            && (this.getTempleteName() == null ? other.getTempleteName() == null : this.getTempleteName().equals(other.getTempleteName()))
            && (this.getTempleteStatus() == null ? other.getTempleteStatus() == null : this.getTempleteStatus().equals(other.getTempleteStatus()))
            && (this.getAppIndexSort() == null ? other.getAppIndexSort() == null : this.getAppIndexSort().equals(other.getAppIndexSort()))
            && (this.getAppCatSort() == null ? other.getAppCatSort() == null : this.getAppCatSort().equals(other.getAppCatSort()))
            && (this.getRfchinaCode() == null ? other.getRfchinaCode() == null : this.getRfchinaCode().equals(other.getRfchinaCode()))
            && (this.getCautionRefundStatus() == null ? other.getCautionRefundStatus() == null : this.getCautionRefundStatus().equals(other.getCautionRefundStatus()))
            && (this.getCautionRefundReason() == null ? other.getCautionRefundReason() == null : this.getCautionRefundReason().equals(other.getCautionRefundReason()))
            && (this.getXfsjStatus() == null ? other.getXfsjStatus() == null : this.getXfsjStatus().equals(other.getXfsjStatus()))
            && (this.getCategorySecondType() == null ? other.getCategorySecondType() == null : this.getCategorySecondType().equals(other.getCategorySecondType()))
            && (this.getProtocolUrl() == null ? other.getProtocolUrl() == null : this.getProtocolUrl().equals(other.getProtocolUrl()))
            && (this.getVerifyRole() == null ? other.getVerifyRole() == null : this.getVerifyRole().equals(other.getVerifyRole()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getServiceId() == null) ? 0 : getServiceId().hashCode());
        result = prime * result + ((getDevelopType() == null) ? 0 : getDevelopType().hashCode());
        result = prime * result + ((getTempleteName() == null) ? 0 : getTempleteName().hashCode());
        result = prime * result + ((getTempleteStatus() == null) ? 0 : getTempleteStatus().hashCode());
        result = prime * result + ((getAppIndexSort() == null) ? 0 : getAppIndexSort().hashCode());
        result = prime * result + ((getAppCatSort() == null) ? 0 : getAppCatSort().hashCode());
        result = prime * result + ((getRfchinaCode() == null) ? 0 : getRfchinaCode().hashCode());
        result = prime * result + ((getCautionRefundStatus() == null) ? 0 : getCautionRefundStatus().hashCode());
        result = prime * result + ((getCautionRefundReason() == null) ? 0 : getCautionRefundReason().hashCode());
        result = prime * result + ((getXfsjStatus() == null) ? 0 : getXfsjStatus().hashCode());
        result = prime * result + ((getCategorySecondType() == null) ? 0 : getCategorySecondType().hashCode());
        result = prime * result + ((getProtocolUrl() == null) ? 0 : getProtocolUrl().hashCode());
        result = prime * result + ((getVerifyRole() == null) ? 0 : getVerifyRole().hashCode());
        return result;
    }
}