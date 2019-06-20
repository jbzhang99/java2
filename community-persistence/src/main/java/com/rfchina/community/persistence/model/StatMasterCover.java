package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class StatMasterCover implements Serializable {
    private Long id;

    private Integer areaId;

    private Integer communityId;

    private Integer communityType;

    private Integer masterCount;

    private Integer masterChildCount;

    private Integer roomCount;

    private Integer parkingCount;

    private Integer propType;

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

    public Integer getMasterCount() {
        return masterCount;
    }

    public void setMasterCount(Integer masterCount) {
        this.masterCount = masterCount;
    }

    public Integer getMasterChildCount() {
        return masterChildCount;
    }

    public void setMasterChildCount(Integer masterChildCount) {
        this.masterChildCount = masterChildCount;
    }

    public Integer getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(Integer roomCount) {
        this.roomCount = roomCount;
    }

    public Integer getParkingCount() {
        return parkingCount;
    }

    public void setParkingCount(Integer parkingCount) {
        this.parkingCount = parkingCount;
    }

    public Integer getPropType() {
        return propType;
    }

    public void setPropType(Integer propType) {
        this.propType = propType;
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
        sb.append(", masterCount=").append(masterCount);
        sb.append(", masterChildCount=").append(masterChildCount);
        sb.append(", roomCount=").append(roomCount);
        sb.append(", parkingCount=").append(parkingCount);
        sb.append(", propType=").append(propType);
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
        StatMasterCover other = (StatMasterCover) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAreaId() == null ? other.getAreaId() == null : this.getAreaId().equals(other.getAreaId()))
            && (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getCommunityType() == null ? other.getCommunityType() == null : this.getCommunityType().equals(other.getCommunityType()))
            && (this.getMasterCount() == null ? other.getMasterCount() == null : this.getMasterCount().equals(other.getMasterCount()))
            && (this.getMasterChildCount() == null ? other.getMasterChildCount() == null : this.getMasterChildCount().equals(other.getMasterChildCount()))
            && (this.getRoomCount() == null ? other.getRoomCount() == null : this.getRoomCount().equals(other.getRoomCount()))
            && (this.getParkingCount() == null ? other.getParkingCount() == null : this.getParkingCount().equals(other.getParkingCount()))
            && (this.getPropType() == null ? other.getPropType() == null : this.getPropType().equals(other.getPropType()))
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
        result = prime * result + ((getMasterCount() == null) ? 0 : getMasterCount().hashCode());
        result = prime * result + ((getMasterChildCount() == null) ? 0 : getMasterChildCount().hashCode());
        result = prime * result + ((getRoomCount() == null) ? 0 : getRoomCount().hashCode());
        result = prime * result + ((getParkingCount() == null) ? 0 : getParkingCount().hashCode());
        result = prime * result + ((getPropType() == null) ? 0 : getPropType().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getStatTime() == null) ? 0 : getStatTime().hashCode());
        return result;
    }
}