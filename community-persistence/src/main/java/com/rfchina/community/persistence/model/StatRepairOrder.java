package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class StatRepairOrder implements Serializable {
    private Long id;

    private Integer areaId;

    private Integer communityId;

    private Integer communityType;

    private Integer repairUserCount;

    private Integer repairRoomCount;

    private Integer repairOrderCount;

    private Integer issueUserCount;

    private Integer issueRoomCount;

    private Integer issueOrderCount;

    private Date statTime;

    private Date createTime;

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

    public Integer getRepairUserCount() {
        return repairUserCount;
    }

    public void setRepairUserCount(Integer repairUserCount) {
        this.repairUserCount = repairUserCount;
    }

    public Integer getRepairRoomCount() {
        return repairRoomCount;
    }

    public void setRepairRoomCount(Integer repairRoomCount) {
        this.repairRoomCount = repairRoomCount;
    }

    public Integer getRepairOrderCount() {
        return repairOrderCount;
    }

    public void setRepairOrderCount(Integer repairOrderCount) {
        this.repairOrderCount = repairOrderCount;
    }

    public Integer getIssueUserCount() {
        return issueUserCount;
    }

    public void setIssueUserCount(Integer issueUserCount) {
        this.issueUserCount = issueUserCount;
    }

    public Integer getIssueRoomCount() {
        return issueRoomCount;
    }

    public void setIssueRoomCount(Integer issueRoomCount) {
        this.issueRoomCount = issueRoomCount;
    }

    public Integer getIssueOrderCount() {
        return issueOrderCount;
    }

    public void setIssueOrderCount(Integer issueOrderCount) {
        this.issueOrderCount = issueOrderCount;
    }

    public Date getStatTime() {
        return statTime;
    }

    public void setStatTime(Date statTime) {
        this.statTime = statTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
        sb.append(", repairUserCount=").append(repairUserCount);
        sb.append(", repairRoomCount=").append(repairRoomCount);
        sb.append(", repairOrderCount=").append(repairOrderCount);
        sb.append(", issueUserCount=").append(issueUserCount);
        sb.append(", issueRoomCount=").append(issueRoomCount);
        sb.append(", issueOrderCount=").append(issueOrderCount);
        sb.append(", statTime=").append(statTime);
        sb.append(", createTime=").append(createTime);
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
        StatRepairOrder other = (StatRepairOrder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAreaId() == null ? other.getAreaId() == null : this.getAreaId().equals(other.getAreaId()))
            && (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getCommunityType() == null ? other.getCommunityType() == null : this.getCommunityType().equals(other.getCommunityType()))
            && (this.getRepairUserCount() == null ? other.getRepairUserCount() == null : this.getRepairUserCount().equals(other.getRepairUserCount()))
            && (this.getRepairRoomCount() == null ? other.getRepairRoomCount() == null : this.getRepairRoomCount().equals(other.getRepairRoomCount()))
            && (this.getRepairOrderCount() == null ? other.getRepairOrderCount() == null : this.getRepairOrderCount().equals(other.getRepairOrderCount()))
            && (this.getIssueUserCount() == null ? other.getIssueUserCount() == null : this.getIssueUserCount().equals(other.getIssueUserCount()))
            && (this.getIssueRoomCount() == null ? other.getIssueRoomCount() == null : this.getIssueRoomCount().equals(other.getIssueRoomCount()))
            && (this.getIssueOrderCount() == null ? other.getIssueOrderCount() == null : this.getIssueOrderCount().equals(other.getIssueOrderCount()))
            && (this.getStatTime() == null ? other.getStatTime() == null : this.getStatTime().equals(other.getStatTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAreaId() == null) ? 0 : getAreaId().hashCode());
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getCommunityType() == null) ? 0 : getCommunityType().hashCode());
        result = prime * result + ((getRepairUserCount() == null) ? 0 : getRepairUserCount().hashCode());
        result = prime * result + ((getRepairRoomCount() == null) ? 0 : getRepairRoomCount().hashCode());
        result = prime * result + ((getRepairOrderCount() == null) ? 0 : getRepairOrderCount().hashCode());
        result = prime * result + ((getIssueUserCount() == null) ? 0 : getIssueUserCount().hashCode());
        result = prime * result + ((getIssueRoomCount() == null) ? 0 : getIssueRoomCount().hashCode());
        result = prime * result + ((getIssueOrderCount() == null) ? 0 : getIssueOrderCount().hashCode());
        result = prime * result + ((getStatTime() == null) ? 0 : getStatTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}