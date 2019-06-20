package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class StatCommunityAttention implements Serializable {
    private Long id;

    private Integer areaId;

    private Integer communityId;

    private Integer communityType;

    private Long currentAppUserCount;

    private Long currentServerUserCount;

    private Long incrAppUserCount;

    private Long incrServerUserCount;

    private Long delAppUserCount;

    private Long delServerUserCount;

    private Date createTime;

    private Date statTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public Integer getCommunityType() {
        return communityType;
    }

    public void setCommunityType(Integer communityType) {
        this.communityType = communityType;
    }

    public Long getCurrentAppUserCount() {
        return currentAppUserCount;
    }

    public void setCurrentAppUserCount(Long currentAppUserCount) {
        this.currentAppUserCount = currentAppUserCount;
    }

    public Long getCurrentServerUserCount() {
        return currentServerUserCount;
    }

    public void setCurrentServerUserCount(Long currentServerUserCount) {
        this.currentServerUserCount = currentServerUserCount;
    }

    public Long getIncrAppUserCount() {
        return incrAppUserCount;
    }

    public void setIncrAppUserCount(Long incrAppUserCount) {
        this.incrAppUserCount = incrAppUserCount;
    }

    public Long getIncrServerUserCount() {
        return incrServerUserCount;
    }

    public void setIncrServerUserCount(Long incrServerUserCount) {
        this.incrServerUserCount = incrServerUserCount;
    }

    public Long getDelAppUserCount() {
        return delAppUserCount;
    }

    public void setDelAppUserCount(Long delAppUserCount) {
        this.delAppUserCount = delAppUserCount;
    }

    public Long getDelServerUserCount() {
        return delServerUserCount;
    }

    public void setDelServerUserCount(Long delServerUserCount) {
        this.delServerUserCount = delServerUserCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getStatTime() {
        return statTime;
    }

    public void setStatTime(Date statTime) {
        this.statTime = statTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", areaId=").append(areaId);
        sb.append(", communityId=").append(communityId);
        sb.append(", communityType=").append(communityType);
        sb.append(", currentAppUserCount=").append(currentAppUserCount);
        sb.append(", currentServerUserCount=").append(currentServerUserCount);
        sb.append(", incrAppUserCount=").append(incrAppUserCount);
        sb.append(", incrServerUserCount=").append(incrServerUserCount);
        sb.append(", delAppUserCount=").append(delAppUserCount);
        sb.append(", delServerUserCount=").append(delServerUserCount);
        sb.append(", createTime=").append(createTime);
        sb.append(", statTime=").append(statTime);
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
        StatCommunityAttention other = (StatCommunityAttention) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAreaId() == null ? other.getAreaId() == null : this.getAreaId().equals(other.getAreaId()))
            && (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getCommunityType() == null ? other.getCommunityType() == null : this.getCommunityType().equals(other.getCommunityType()))
            && (this.getCurrentAppUserCount() == null ? other.getCurrentAppUserCount() == null : this.getCurrentAppUserCount().equals(other.getCurrentAppUserCount()))
            && (this.getCurrentServerUserCount() == null ? other.getCurrentServerUserCount() == null : this.getCurrentServerUserCount().equals(other.getCurrentServerUserCount()))
            && (this.getIncrAppUserCount() == null ? other.getIncrAppUserCount() == null : this.getIncrAppUserCount().equals(other.getIncrAppUserCount()))
            && (this.getIncrServerUserCount() == null ? other.getIncrServerUserCount() == null : this.getIncrServerUserCount().equals(other.getIncrServerUserCount()))
            && (this.getDelAppUserCount() == null ? other.getDelAppUserCount() == null : this.getDelAppUserCount().equals(other.getDelAppUserCount()))
            && (this.getDelServerUserCount() == null ? other.getDelServerUserCount() == null : this.getDelServerUserCount().equals(other.getDelServerUserCount()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getStatTime() == null ? other.getStatTime() == null : this.getStatTime().equals(other.getStatTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAreaId() == null) ? 0 : getAreaId().hashCode());
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getCommunityType() == null) ? 0 : getCommunityType().hashCode());
        result = prime * result + ((getCurrentAppUserCount() == null) ? 0 : getCurrentAppUserCount().hashCode());
        result = prime * result + ((getCurrentServerUserCount() == null) ? 0 : getCurrentServerUserCount().hashCode());
        result = prime * result + ((getIncrAppUserCount() == null) ? 0 : getIncrAppUserCount().hashCode());
        result = prime * result + ((getIncrServerUserCount() == null) ? 0 : getIncrServerUserCount().hashCode());
        result = prime * result + ((getDelAppUserCount() == null) ? 0 : getDelAppUserCount().hashCode());
        result = prime * result + ((getDelServerUserCount() == null) ? 0 : getDelServerUserCount().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getStatTime() == null) ? 0 : getStatTime().hashCode());
        return result;
    }
}