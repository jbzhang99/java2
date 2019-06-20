package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class OpenAuditInfo implements Serializable {
    private Long id;

    private Date createTime;

    private Date updateTime;

    private Long srcUid;

    private String auditType;

    private Integer auditStatus;

    private String auditContent;

    private String objectId;

    private Long auditUid;

    private Integer serviceId;

    private String pagerId;

    private Long merchantId;

    private String auditPhone;

    private String auditName;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getSrcUid() {
        return srcUid;
    }

    public void setSrcUid(Long srcUid) {
        this.srcUid = srcUid;
    }

    public String getAuditType() {
        return auditType;
    }

    public void setAuditType(String auditType) {
        this.auditType = auditType;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getAuditContent() {
        return auditContent;
    }

    public void setAuditContent(String auditContent) {
        this.auditContent = auditContent;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public Long getAuditUid() {
        return auditUid;
    }

    public void setAuditUid(Long auditUid) {
        this.auditUid = auditUid;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getPagerId() {
        return pagerId;
    }

    public void setPagerId(String pagerId) {
        this.pagerId = pagerId;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getAuditPhone() {
        return auditPhone;
    }

    public void setAuditPhone(String auditPhone) {
        this.auditPhone = auditPhone;
    }

    public String getAuditName() {
        return auditName;
    }

    public void setAuditName(String auditName) {
        this.auditName = auditName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", srcUid=").append(srcUid);
        sb.append(", auditType=").append(auditType);
        sb.append(", auditStatus=").append(auditStatus);
        sb.append(", auditContent=").append(auditContent);
        sb.append(", objectId=").append(objectId);
        sb.append(", auditUid=").append(auditUid);
        sb.append(", serviceId=").append(serviceId);
        sb.append(", pagerId=").append(pagerId);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", auditPhone=").append(auditPhone);
        sb.append(", auditName=").append(auditName);
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
        OpenAuditInfo other = (OpenAuditInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getSrcUid() == null ? other.getSrcUid() == null : this.getSrcUid().equals(other.getSrcUid()))
            && (this.getAuditType() == null ? other.getAuditType() == null : this.getAuditType().equals(other.getAuditType()))
            && (this.getAuditStatus() == null ? other.getAuditStatus() == null : this.getAuditStatus().equals(other.getAuditStatus()))
            && (this.getAuditContent() == null ? other.getAuditContent() == null : this.getAuditContent().equals(other.getAuditContent()))
            && (this.getObjectId() == null ? other.getObjectId() == null : this.getObjectId().equals(other.getObjectId()))
            && (this.getAuditUid() == null ? other.getAuditUid() == null : this.getAuditUid().equals(other.getAuditUid()))
            && (this.getServiceId() == null ? other.getServiceId() == null : this.getServiceId().equals(other.getServiceId()))
            && (this.getPagerId() == null ? other.getPagerId() == null : this.getPagerId().equals(other.getPagerId()))
            && (this.getMerchantId() == null ? other.getMerchantId() == null : this.getMerchantId().equals(other.getMerchantId()))
            && (this.getAuditPhone() == null ? other.getAuditPhone() == null : this.getAuditPhone().equals(other.getAuditPhone()))
            && (this.getAuditName() == null ? other.getAuditName() == null : this.getAuditName().equals(other.getAuditName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getSrcUid() == null) ? 0 : getSrcUid().hashCode());
        result = prime * result + ((getAuditType() == null) ? 0 : getAuditType().hashCode());
        result = prime * result + ((getAuditStatus() == null) ? 0 : getAuditStatus().hashCode());
        result = prime * result + ((getAuditContent() == null) ? 0 : getAuditContent().hashCode());
        result = prime * result + ((getObjectId() == null) ? 0 : getObjectId().hashCode());
        result = prime * result + ((getAuditUid() == null) ? 0 : getAuditUid().hashCode());
        result = prime * result + ((getServiceId() == null) ? 0 : getServiceId().hashCode());
        result = prime * result + ((getPagerId() == null) ? 0 : getPagerId().hashCode());
        result = prime * result + ((getMerchantId() == null) ? 0 : getMerchantId().hashCode());
        result = prime * result + ((getAuditPhone() == null) ? 0 : getAuditPhone().hashCode());
        result = prime * result + ((getAuditName() == null) ? 0 : getAuditName().hashCode());
        return result;
    }
}