package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class MasterParking implements Serializable {
    private Long id;

    private Long ownerMasterId;

    private Long ownerMasterChildId;

    private Integer ownerType;

    private Long tenantMasterChildId;

    private String tenantName;

    private String tenantPhone;

    private String tenantStartDate;

    private String tenantEndDate;

    private String carPlateNo;

    private String cardNo;

    private Integer type;

    private Integer status;

    private String remark;

    private String importBody;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOwnerMasterId() {
        return ownerMasterId;
    }

    public void setOwnerMasterId(Long ownerMasterId) {
        this.ownerMasterId = ownerMasterId;
    }

    public Long getOwnerMasterChildId() {
        return ownerMasterChildId;
    }

    public void setOwnerMasterChildId(Long ownerMasterChildId) {
        this.ownerMasterChildId = ownerMasterChildId;
    }

    public Integer getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(Integer ownerType) {
        this.ownerType = ownerType;
    }

    public Long getTenantMasterChildId() {
        return tenantMasterChildId;
    }

    public void setTenantMasterChildId(Long tenantMasterChildId) {
        this.tenantMasterChildId = tenantMasterChildId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getTenantPhone() {
        return tenantPhone;
    }

    public void setTenantPhone(String tenantPhone) {
        this.tenantPhone = tenantPhone;
    }

    public String getTenantStartDate() {
        return tenantStartDate;
    }

    public void setTenantStartDate(String tenantStartDate) {
        this.tenantStartDate = tenantStartDate;
    }

    public String getTenantEndDate() {
        return tenantEndDate;
    }

    public void setTenantEndDate(String tenantEndDate) {
        this.tenantEndDate = tenantEndDate;
    }

    public String getCarPlateNo() {
        return carPlateNo;
    }

    public void setCarPlateNo(String carPlateNo) {
        this.carPlateNo = carPlateNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getImportBody() {
        return importBody;
    }

    public void setImportBody(String importBody) {
        this.importBody = importBody;
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
        sb.append(", ownerMasterId=").append(ownerMasterId);
        sb.append(", ownerMasterChildId=").append(ownerMasterChildId);
        sb.append(", ownerType=").append(ownerType);
        sb.append(", tenantMasterChildId=").append(tenantMasterChildId);
        sb.append(", tenantName=").append(tenantName);
        sb.append(", tenantPhone=").append(tenantPhone);
        sb.append(", tenantStartDate=").append(tenantStartDate);
        sb.append(", tenantEndDate=").append(tenantEndDate);
        sb.append(", carPlateNo=").append(carPlateNo);
        sb.append(", cardNo=").append(cardNo);
        sb.append(", type=").append(type);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
        sb.append(", importBody=").append(importBody);
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
        MasterParking other = (MasterParking) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOwnerMasterId() == null ? other.getOwnerMasterId() == null : this.getOwnerMasterId().equals(other.getOwnerMasterId()))
            && (this.getOwnerMasterChildId() == null ? other.getOwnerMasterChildId() == null : this.getOwnerMasterChildId().equals(other.getOwnerMasterChildId()))
            && (this.getOwnerType() == null ? other.getOwnerType() == null : this.getOwnerType().equals(other.getOwnerType()))
            && (this.getTenantMasterChildId() == null ? other.getTenantMasterChildId() == null : this.getTenantMasterChildId().equals(other.getTenantMasterChildId()))
            && (this.getTenantName() == null ? other.getTenantName() == null : this.getTenantName().equals(other.getTenantName()))
            && (this.getTenantPhone() == null ? other.getTenantPhone() == null : this.getTenantPhone().equals(other.getTenantPhone()))
            && (this.getTenantStartDate() == null ? other.getTenantStartDate() == null : this.getTenantStartDate().equals(other.getTenantStartDate()))
            && (this.getTenantEndDate() == null ? other.getTenantEndDate() == null : this.getTenantEndDate().equals(other.getTenantEndDate()))
            && (this.getCarPlateNo() == null ? other.getCarPlateNo() == null : this.getCarPlateNo().equals(other.getCarPlateNo()))
            && (this.getCardNo() == null ? other.getCardNo() == null : this.getCardNo().equals(other.getCardNo()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getImportBody() == null ? other.getImportBody() == null : this.getImportBody().equals(other.getImportBody()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOwnerMasterId() == null) ? 0 : getOwnerMasterId().hashCode());
        result = prime * result + ((getOwnerMasterChildId() == null) ? 0 : getOwnerMasterChildId().hashCode());
        result = prime * result + ((getOwnerType() == null) ? 0 : getOwnerType().hashCode());
        result = prime * result + ((getTenantMasterChildId() == null) ? 0 : getTenantMasterChildId().hashCode());
        result = prime * result + ((getTenantName() == null) ? 0 : getTenantName().hashCode());
        result = prime * result + ((getTenantPhone() == null) ? 0 : getTenantPhone().hashCode());
        result = prime * result + ((getTenantStartDate() == null) ? 0 : getTenantStartDate().hashCode());
        result = prime * result + ((getTenantEndDate() == null) ? 0 : getTenantEndDate().hashCode());
        result = prime * result + ((getCarPlateNo() == null) ? 0 : getCarPlateNo().hashCode());
        result = prime * result + ((getCardNo() == null) ? 0 : getCardNo().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getImportBody() == null) ? 0 : getImportBody().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}