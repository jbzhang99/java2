package com.rfchina.community.persistence.model;

import java.io.Serializable;

public class VisitCommunity implements Serializable {
    private Integer communityId;

    private Integer followMax;

    private Integer followMust;

    private String openTime;

    private String closingTime;

    private Integer isEntranceGuard;

    private Integer entranceGuardType;

    private static final long serialVersionUID = 1L;

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public Integer getFollowMax() {
        return followMax;
    }

    public void setFollowMax(Integer followMax) {
        this.followMax = followMax;
    }

    public Integer getFollowMust() {
        return followMust;
    }

    public void setFollowMust(Integer followMust) {
        this.followMust = followMust;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

    public Integer getIsEntranceGuard() {
        return isEntranceGuard;
    }

    public void setIsEntranceGuard(Integer isEntranceGuard) {
        this.isEntranceGuard = isEntranceGuard;
    }

    public Integer getEntranceGuardType() {
        return entranceGuardType;
    }

    public void setEntranceGuardType(Integer entranceGuardType) {
        this.entranceGuardType = entranceGuardType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", communityId=").append(communityId);
        sb.append(", followMax=").append(followMax);
        sb.append(", followMust=").append(followMust);
        sb.append(", openTime=").append(openTime);
        sb.append(", closingTime=").append(closingTime);
        sb.append(", isEntranceGuard=").append(isEntranceGuard);
        sb.append(", entranceGuardType=").append(entranceGuardType);
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
        VisitCommunity other = (VisitCommunity) that;
        return (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getFollowMax() == null ? other.getFollowMax() == null : this.getFollowMax().equals(other.getFollowMax()))
            && (this.getFollowMust() == null ? other.getFollowMust() == null : this.getFollowMust().equals(other.getFollowMust()))
            && (this.getOpenTime() == null ? other.getOpenTime() == null : this.getOpenTime().equals(other.getOpenTime()))
            && (this.getClosingTime() == null ? other.getClosingTime() == null : this.getClosingTime().equals(other.getClosingTime()))
            && (this.getIsEntranceGuard() == null ? other.getIsEntranceGuard() == null : this.getIsEntranceGuard().equals(other.getIsEntranceGuard()))
            && (this.getEntranceGuardType() == null ? other.getEntranceGuardType() == null : this.getEntranceGuardType().equals(other.getEntranceGuardType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getFollowMax() == null) ? 0 : getFollowMax().hashCode());
        result = prime * result + ((getFollowMust() == null) ? 0 : getFollowMust().hashCode());
        result = prime * result + ((getOpenTime() == null) ? 0 : getOpenTime().hashCode());
        result = prime * result + ((getClosingTime() == null) ? 0 : getClosingTime().hashCode());
        result = prime * result + ((getIsEntranceGuard() == null) ? 0 : getIsEntranceGuard().hashCode());
        result = prime * result + ((getEntranceGuardType() == null) ? 0 : getEntranceGuardType().hashCode());
        return result;
    }
}