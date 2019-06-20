package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class OpenUserAddrInfo implements Serializable {
    private Integer id;

    private Long userId;

    private String userName;

    private String mobile;

    private String detailAddr;

    private Integer isDefault;

    private Integer validStatus;

    private Date createTime;

    private String provinceAreaId;

    private String cityAreaId;

    private String areaId;

    private String areaInfo;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDetailAddr() {
        return detailAddr;
    }

    public void setDetailAddr(String detailAddr) {
        this.detailAddr = detailAddr;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getValidStatus() {
        return validStatus;
    }

    public void setValidStatus(Integer validStatus) {
        this.validStatus = validStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getProvinceAreaId() {
        return provinceAreaId;
    }

    public void setProvinceAreaId(String provinceAreaId) {
        this.provinceAreaId = provinceAreaId;
    }

    public String getCityAreaId() {
        return cityAreaId;
    }

    public void setCityAreaId(String cityAreaId) {
        this.cityAreaId = cityAreaId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaInfo() {
        return areaInfo;
    }

    public void setAreaInfo(String areaInfo) {
        this.areaInfo = areaInfo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", mobile=").append(mobile);
        sb.append(", detailAddr=").append(detailAddr);
        sb.append(", isDefault=").append(isDefault);
        sb.append(", validStatus=").append(validStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", provinceAreaId=").append(provinceAreaId);
        sb.append(", cityAreaId=").append(cityAreaId);
        sb.append(", areaId=").append(areaId);
        sb.append(", areaInfo=").append(areaInfo);
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
        OpenUserAddrInfo other = (OpenUserAddrInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getDetailAddr() == null ? other.getDetailAddr() == null : this.getDetailAddr().equals(other.getDetailAddr()))
            && (this.getIsDefault() == null ? other.getIsDefault() == null : this.getIsDefault().equals(other.getIsDefault()))
            && (this.getValidStatus() == null ? other.getValidStatus() == null : this.getValidStatus().equals(other.getValidStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getProvinceAreaId() == null ? other.getProvinceAreaId() == null : this.getProvinceAreaId().equals(other.getProvinceAreaId()))
            && (this.getCityAreaId() == null ? other.getCityAreaId() == null : this.getCityAreaId().equals(other.getCityAreaId()))
            && (this.getAreaId() == null ? other.getAreaId() == null : this.getAreaId().equals(other.getAreaId()))
            && (this.getAreaInfo() == null ? other.getAreaInfo() == null : this.getAreaInfo().equals(other.getAreaInfo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getDetailAddr() == null) ? 0 : getDetailAddr().hashCode());
        result = prime * result + ((getIsDefault() == null) ? 0 : getIsDefault().hashCode());
        result = prime * result + ((getValidStatus() == null) ? 0 : getValidStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getProvinceAreaId() == null) ? 0 : getProvinceAreaId().hashCode());
        result = prime * result + ((getCityAreaId() == null) ? 0 : getCityAreaId().hashCode());
        result = prime * result + ((getAreaId() == null) ? 0 : getAreaId().hashCode());
        result = prime * result + ((getAreaInfo() == null) ? 0 : getAreaInfo().hashCode());
        return result;
    }
}