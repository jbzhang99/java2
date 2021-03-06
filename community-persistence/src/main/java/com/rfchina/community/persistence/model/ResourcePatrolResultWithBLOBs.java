package com.rfchina.community.persistence.model;

import java.io.Serializable;

public class ResourcePatrolResultWithBLOBs extends ResourcePatrolResult implements Serializable {
    private String patrolImg;

    private String patrolDetail;

    private static final long serialVersionUID = 1L;

    public String getPatrolImg() {
        return patrolImg;
    }

    public void setPatrolImg(String patrolImg) {
        this.patrolImg = patrolImg;
    }

    public String getPatrolDetail() {
        return patrolDetail;
    }

    public void setPatrolDetail(String patrolDetail) {
        this.patrolDetail = patrolDetail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", patrolImg=").append(patrolImg);
        sb.append(", patrolDetail=").append(patrolDetail);
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
        ResourcePatrolResultWithBLOBs other = (ResourcePatrolResultWithBLOBs) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPatrolId() == null ? other.getPatrolId() == null : this.getPatrolId().equals(other.getPatrolId()))
            && (this.getPatrolType() == null ? other.getPatrolType() == null : this.getPatrolType().equals(other.getPatrolType()))
            && (this.getPatrolResult() == null ? other.getPatrolResult() == null : this.getPatrolResult().equals(other.getPatrolResult()))
            && (this.getPatrolImg() == null ? other.getPatrolImg() == null : this.getPatrolImg().equals(other.getPatrolImg()))
            && (this.getPatrolDetail() == null ? other.getPatrolDetail() == null : this.getPatrolDetail().equals(other.getPatrolDetail()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPatrolId() == null) ? 0 : getPatrolId().hashCode());
        result = prime * result + ((getPatrolType() == null) ? 0 : getPatrolType().hashCode());
        result = prime * result + ((getPatrolResult() == null) ? 0 : getPatrolResult().hashCode());
        result = prime * result + ((getPatrolImg() == null) ? 0 : getPatrolImg().hashCode());
        result = prime * result + ((getPatrolDetail() == null) ? 0 : getPatrolDetail().hashCode());
        return result;
    }
}