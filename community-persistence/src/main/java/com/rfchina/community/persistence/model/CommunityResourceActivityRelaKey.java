package com.rfchina.community.persistence.model;

import java.io.Serializable;

public class CommunityResourceActivityRelaKey implements Serializable {
    private Integer communityId;

    private Integer communityResourceId;

    private Long activityId;

    private static final long serialVersionUID = 1L;

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public Integer getCommunityResourceId() {
        return communityResourceId;
    }

    public void setCommunityResourceId(Integer communityResourceId) {
        this.communityResourceId = communityResourceId;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", communityId=").append(communityId);
        sb.append(", communityResourceId=").append(communityResourceId);
        sb.append(", activityId=").append(activityId);
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
        CommunityResourceActivityRelaKey other = (CommunityResourceActivityRelaKey) that;
        return (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getCommunityResourceId() == null ? other.getCommunityResourceId() == null : this.getCommunityResourceId().equals(other.getCommunityResourceId()))
            && (this.getActivityId() == null ? other.getActivityId() == null : this.getActivityId().equals(other.getActivityId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getCommunityResourceId() == null) ? 0 : getCommunityResourceId().hashCode());
        result = prime * result + ((getActivityId() == null) ? 0 : getActivityId().hashCode());
        return result;
    }
}