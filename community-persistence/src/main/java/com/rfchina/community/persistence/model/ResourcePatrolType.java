package com.rfchina.community.persistence.model;

import java.io.Serializable;

public class ResourcePatrolType implements Serializable {
    private Integer patrolType;

    private String typeName;

    private Integer status;

    private static final long serialVersionUID = 1L;

    public Integer getPatrolType() {
        return patrolType;
    }

    public void setPatrolType(Integer patrolType) {
        this.patrolType = patrolType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", patrolType=").append(patrolType);
        sb.append(", typeName=").append(typeName);
        sb.append(", status=").append(status);
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
        ResourcePatrolType other = (ResourcePatrolType) that;
        return (this.getPatrolType() == null ? other.getPatrolType() == null : this.getPatrolType().equals(other.getPatrolType()))
            && (this.getTypeName() == null ? other.getTypeName() == null : this.getTypeName().equals(other.getTypeName()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPatrolType() == null) ? 0 : getPatrolType().hashCode());
        result = prime * result + ((getTypeName() == null) ? 0 : getTypeName().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }
}