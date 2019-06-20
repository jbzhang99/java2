package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class ResourcePatrolInfo implements Serializable {
    private Long patrolId;

    private Long xfsjId;

    private Integer communityId;

    private Long adminUid;

    private String empGuid;

    private Date createTime;

    private Date updateTime;

    private Integer status;

    private Integer patrolStatus;

    private static final long serialVersionUID = 1L;

    public Long getPatrolId() {
        return patrolId;
    }

    public void setPatrolId(Long patrolId) {
        this.patrolId = patrolId;
    }

    public Long getXfsjId() {
        return xfsjId;
    }

    public void setXfsjId(Long xfsjId) {
        this.xfsjId = xfsjId;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public Long getAdminUid() {
        return adminUid;
    }

    public void setAdminUid(Long adminUid) {
        this.adminUid = adminUid;
    }

    public String getEmpGuid() {
        return empGuid;
    }

    public void setEmpGuid(String empGuid) {
        this.empGuid = empGuid;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPatrolStatus() {
        return patrolStatus;
    }

    public void setPatrolStatus(Integer patrolStatus) {
        this.patrolStatus = patrolStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", patrolId=").append(patrolId);
        sb.append(", xfsjId=").append(xfsjId);
        sb.append(", communityId=").append(communityId);
        sb.append(", adminUid=").append(adminUid);
        sb.append(", empGuid=").append(empGuid);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", status=").append(status);
        sb.append(", patrolStatus=").append(patrolStatus);
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
        ResourcePatrolInfo other = (ResourcePatrolInfo) that;
        return (this.getPatrolId() == null ? other.getPatrolId() == null : this.getPatrolId().equals(other.getPatrolId()))
            && (this.getXfsjId() == null ? other.getXfsjId() == null : this.getXfsjId().equals(other.getXfsjId()))
            && (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getAdminUid() == null ? other.getAdminUid() == null : this.getAdminUid().equals(other.getAdminUid()))
            && (this.getEmpGuid() == null ? other.getEmpGuid() == null : this.getEmpGuid().equals(other.getEmpGuid()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getPatrolStatus() == null ? other.getPatrolStatus() == null : this.getPatrolStatus().equals(other.getPatrolStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPatrolId() == null) ? 0 : getPatrolId().hashCode());
        result = prime * result + ((getXfsjId() == null) ? 0 : getXfsjId().hashCode());
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getAdminUid() == null) ? 0 : getAdminUid().hashCode());
        result = prime * result + ((getEmpGuid() == null) ? 0 : getEmpGuid().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getPatrolStatus() == null) ? 0 : getPatrolStatus().hashCode());
        return result;
    }
}