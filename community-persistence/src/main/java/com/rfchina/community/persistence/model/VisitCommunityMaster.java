package com.rfchina.community.persistence.model;

import java.io.Serializable;

public class VisitCommunityMaster implements Serializable {
    private Long masterId;

    private Integer roleCount;

    private Integer canVisit;

    private static final long serialVersionUID = 1L;

    public Long getMasterId() {
        return masterId;
    }

    public void setMasterId(Long masterId) {
        this.masterId = masterId;
    }

    public Integer getRoleCount() {
        return roleCount;
    }

    public void setRoleCount(Integer roleCount) {
        this.roleCount = roleCount;
    }

    public Integer getCanVisit() {
        return canVisit;
    }

    public void setCanVisit(Integer canVisit) {
        this.canVisit = canVisit;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", masterId=").append(masterId);
        sb.append(", roleCount=").append(roleCount);
        sb.append(", canVisit=").append(canVisit);
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
        VisitCommunityMaster other = (VisitCommunityMaster) that;
        return (this.getMasterId() == null ? other.getMasterId() == null : this.getMasterId().equals(other.getMasterId()))
            && (this.getRoleCount() == null ? other.getRoleCount() == null : this.getRoleCount().equals(other.getRoleCount()))
            && (this.getCanVisit() == null ? other.getCanVisit() == null : this.getCanVisit().equals(other.getCanVisit()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMasterId() == null) ? 0 : getMasterId().hashCode());
        result = prime * result + ((getRoleCount() == null) ? 0 : getRoleCount().hashCode());
        result = prime * result + ((getCanVisit() == null) ? 0 : getCanVisit().hashCode());
        return result;
    }
}