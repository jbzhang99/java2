package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class StatMasterInfo implements Serializable {
    private Long id;

    private Integer areaId;

    private Integer communityId;

    private Integer communityType;

    private Integer userCount;

    private Integer masterCount;

    private Integer roomCount;

    private Integer parkingCount;

    private Integer masterChildCount;

    private Integer ownerCount;

    private Integer bizOwnerCount;

    private Integer tenantCount;

    private Integer familyCount;

    private Integer staffCount;

    private Integer siteStaffCount;

    private Integer otherCount;

    private Integer type;

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

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }

    public Integer getMasterCount() {
        return masterCount;
    }

    public void setMasterCount(Integer masterCount) {
        this.masterCount = masterCount;
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

    public Integer getMasterChildCount() {
        return masterChildCount;
    }

    public void setMasterChildCount(Integer masterChildCount) {
        this.masterChildCount = masterChildCount;
    }

    public Integer getOwnerCount() {
        return ownerCount;
    }

    public void setOwnerCount(Integer ownerCount) {
        this.ownerCount = ownerCount;
    }

    public Integer getBizOwnerCount() {
        return bizOwnerCount;
    }

    public void setBizOwnerCount(Integer bizOwnerCount) {
        this.bizOwnerCount = bizOwnerCount;
    }

    public Integer getTenantCount() {
        return tenantCount;
    }

    public void setTenantCount(Integer tenantCount) {
        this.tenantCount = tenantCount;
    }

    public Integer getFamilyCount() {
        return familyCount;
    }

    public void setFamilyCount(Integer familyCount) {
        this.familyCount = familyCount;
    }

    public Integer getStaffCount() {
        return staffCount;
    }

    public void setStaffCount(Integer staffCount) {
        this.staffCount = staffCount;
    }

    public Integer getSiteStaffCount() {
        return siteStaffCount;
    }

    public void setSiteStaffCount(Integer siteStaffCount) {
        this.siteStaffCount = siteStaffCount;
    }

    public Integer getOtherCount() {
        return otherCount;
    }

    public void setOtherCount(Integer otherCount) {
        this.otherCount = otherCount;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
        sb.append(", userCount=").append(userCount);
        sb.append(", masterCount=").append(masterCount);
        sb.append(", roomCount=").append(roomCount);
        sb.append(", parkingCount=").append(parkingCount);
        sb.append(", masterChildCount=").append(masterChildCount);
        sb.append(", ownerCount=").append(ownerCount);
        sb.append(", bizOwnerCount=").append(bizOwnerCount);
        sb.append(", tenantCount=").append(tenantCount);
        sb.append(", familyCount=").append(familyCount);
        sb.append(", staffCount=").append(staffCount);
        sb.append(", siteStaffCount=").append(siteStaffCount);
        sb.append(", otherCount=").append(otherCount);
        sb.append(", type=").append(type);
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
        StatMasterInfo other = (StatMasterInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAreaId() == null ? other.getAreaId() == null : this.getAreaId().equals(other.getAreaId()))
            && (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getCommunityType() == null ? other.getCommunityType() == null : this.getCommunityType().equals(other.getCommunityType()))
            && (this.getUserCount() == null ? other.getUserCount() == null : this.getUserCount().equals(other.getUserCount()))
            && (this.getMasterCount() == null ? other.getMasterCount() == null : this.getMasterCount().equals(other.getMasterCount()))
            && (this.getRoomCount() == null ? other.getRoomCount() == null : this.getRoomCount().equals(other.getRoomCount()))
            && (this.getParkingCount() == null ? other.getParkingCount() == null : this.getParkingCount().equals(other.getParkingCount()))
            && (this.getMasterChildCount() == null ? other.getMasterChildCount() == null : this.getMasterChildCount().equals(other.getMasterChildCount()))
            && (this.getOwnerCount() == null ? other.getOwnerCount() == null : this.getOwnerCount().equals(other.getOwnerCount()))
            && (this.getBizOwnerCount() == null ? other.getBizOwnerCount() == null : this.getBizOwnerCount().equals(other.getBizOwnerCount()))
            && (this.getTenantCount() == null ? other.getTenantCount() == null : this.getTenantCount().equals(other.getTenantCount()))
            && (this.getFamilyCount() == null ? other.getFamilyCount() == null : this.getFamilyCount().equals(other.getFamilyCount()))
            && (this.getStaffCount() == null ? other.getStaffCount() == null : this.getStaffCount().equals(other.getStaffCount()))
            && (this.getSiteStaffCount() == null ? other.getSiteStaffCount() == null : this.getSiteStaffCount().equals(other.getSiteStaffCount()))
            && (this.getOtherCount() == null ? other.getOtherCount() == null : this.getOtherCount().equals(other.getOtherCount()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
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
        result = prime * result + ((getUserCount() == null) ? 0 : getUserCount().hashCode());
        result = prime * result + ((getMasterCount() == null) ? 0 : getMasterCount().hashCode());
        result = prime * result + ((getRoomCount() == null) ? 0 : getRoomCount().hashCode());
        result = prime * result + ((getParkingCount() == null) ? 0 : getParkingCount().hashCode());
        result = prime * result + ((getMasterChildCount() == null) ? 0 : getMasterChildCount().hashCode());
        result = prime * result + ((getOwnerCount() == null) ? 0 : getOwnerCount().hashCode());
        result = prime * result + ((getBizOwnerCount() == null) ? 0 : getBizOwnerCount().hashCode());
        result = prime * result + ((getTenantCount() == null) ? 0 : getTenantCount().hashCode());
        result = prime * result + ((getFamilyCount() == null) ? 0 : getFamilyCount().hashCode());
        result = prime * result + ((getStaffCount() == null) ? 0 : getStaffCount().hashCode());
        result = prime * result + ((getSiteStaffCount() == null) ? 0 : getSiteStaffCount().hashCode());
        result = prime * result + ((getOtherCount() == null) ? 0 : getOtherCount().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getPropType() == null) ? 0 : getPropType().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getStatTime() == null) ? 0 : getStatTime().hashCode());
        return result;
    }
}