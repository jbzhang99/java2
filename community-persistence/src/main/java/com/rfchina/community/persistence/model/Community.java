package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class Community implements Serializable {
    private Integer id;

    private String name;

    private String phone;

    private String tel;

    private Integer cityId;

    private String cityName;

    private Integer areaId;

    private String address;

    private String intro;

    private Integer status;

    private String projectGuid;

    private Integer category;

    private Integer sort;

    private Integer syncFlag;

    private String qrcodeUrl;

    private String longitude;

    private String latitude;

    private Long adminId;

    private Integer type;

    private String buildingArea;

    private String practicalArea;

    private String typeDesc;

    private String logoUrl;

    private String backgroundUrl;

    private Integer topicAudit;

    private Date createTime;

    private Long cid;

    private String weixin;

    private String propertyCompany;

    private String businessPerson;

    private String businessPhone;

    private String businessEmail;

    private String pinyin;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getProjectGuid() {
        return projectGuid;
    }

    public void setProjectGuid(String projectGuid) {
        this.projectGuid = projectGuid;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getSyncFlag() {
        return syncFlag;
    }

    public void setSyncFlag(Integer syncFlag) {
        this.syncFlag = syncFlag;
    }

    public String getQrcodeUrl() {
        return qrcodeUrl;
    }

    public void setQrcodeUrl(String qrcodeUrl) {
        this.qrcodeUrl = qrcodeUrl;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getBuildingArea() {
        return buildingArea;
    }

    public void setBuildingArea(String buildingArea) {
        this.buildingArea = buildingArea;
    }

    public String getPracticalArea() {
        return practicalArea;
    }

    public void setPracticalArea(String practicalArea) {
        this.practicalArea = practicalArea;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getBackgroundUrl() {
        return backgroundUrl;
    }

    public void setBackgroundUrl(String backgroundUrl) {
        this.backgroundUrl = backgroundUrl;
    }

    public Integer getTopicAudit() {
        return topicAudit;
    }

    public void setTopicAudit(Integer topicAudit) {
        this.topicAudit = topicAudit;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getPropertyCompany() {
        return propertyCompany;
    }

    public void setPropertyCompany(String propertyCompany) {
        this.propertyCompany = propertyCompany;
    }

    public String getBusinessPerson() {
        return businessPerson;
    }

    public void setBusinessPerson(String businessPerson) {
        this.businessPerson = businessPerson;
    }

    public String getBusinessPhone() {
        return businessPhone;
    }

    public void setBusinessPhone(String businessPhone) {
        this.businessPhone = businessPhone;
    }

    public String getBusinessEmail() {
        return businessEmail;
    }

    public void setBusinessEmail(String businessEmail) {
        this.businessEmail = businessEmail;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", phone=").append(phone);
        sb.append(", tel=").append(tel);
        sb.append(", cityId=").append(cityId);
        sb.append(", cityName=").append(cityName);
        sb.append(", areaId=").append(areaId);
        sb.append(", address=").append(address);
        sb.append(", intro=").append(intro);
        sb.append(", status=").append(status);
        sb.append(", projectGuid=").append(projectGuid);
        sb.append(", category=").append(category);
        sb.append(", sort=").append(sort);
        sb.append(", syncFlag=").append(syncFlag);
        sb.append(", qrcodeUrl=").append(qrcodeUrl);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", adminId=").append(adminId);
        sb.append(", type=").append(type);
        sb.append(", buildingArea=").append(buildingArea);
        sb.append(", practicalArea=").append(practicalArea);
        sb.append(", typeDesc=").append(typeDesc);
        sb.append(", logoUrl=").append(logoUrl);
        sb.append(", backgroundUrl=").append(backgroundUrl);
        sb.append(", topicAudit=").append(topicAudit);
        sb.append(", createTime=").append(createTime);
        sb.append(", cid=").append(cid);
        sb.append(", weixin=").append(weixin);
        sb.append(", propertyCompany=").append(propertyCompany);
        sb.append(", businessPerson=").append(businessPerson);
        sb.append(", businessPhone=").append(businessPhone);
        sb.append(", businessEmail=").append(businessEmail);
        sb.append(", pinyin=").append(pinyin);
        sb.append(", updateTime=").append(updateTime);
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
        Community other = (Community) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getTel() == null ? other.getTel() == null : this.getTel().equals(other.getTel()))
            && (this.getCityId() == null ? other.getCityId() == null : this.getCityId().equals(other.getCityId()))
            && (this.getCityName() == null ? other.getCityName() == null : this.getCityName().equals(other.getCityName()))
            && (this.getAreaId() == null ? other.getAreaId() == null : this.getAreaId().equals(other.getAreaId()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getIntro() == null ? other.getIntro() == null : this.getIntro().equals(other.getIntro()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getProjectGuid() == null ? other.getProjectGuid() == null : this.getProjectGuid().equals(other.getProjectGuid()))
            && (this.getCategory() == null ? other.getCategory() == null : this.getCategory().equals(other.getCategory()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getSyncFlag() == null ? other.getSyncFlag() == null : this.getSyncFlag().equals(other.getSyncFlag()))
            && (this.getQrcodeUrl() == null ? other.getQrcodeUrl() == null : this.getQrcodeUrl().equals(other.getQrcodeUrl()))
            && (this.getLongitude() == null ? other.getLongitude() == null : this.getLongitude().equals(other.getLongitude()))
            && (this.getLatitude() == null ? other.getLatitude() == null : this.getLatitude().equals(other.getLatitude()))
            && (this.getAdminId() == null ? other.getAdminId() == null : this.getAdminId().equals(other.getAdminId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getBuildingArea() == null ? other.getBuildingArea() == null : this.getBuildingArea().equals(other.getBuildingArea()))
            && (this.getPracticalArea() == null ? other.getPracticalArea() == null : this.getPracticalArea().equals(other.getPracticalArea()))
            && (this.getTypeDesc() == null ? other.getTypeDesc() == null : this.getTypeDesc().equals(other.getTypeDesc()))
            && (this.getLogoUrl() == null ? other.getLogoUrl() == null : this.getLogoUrl().equals(other.getLogoUrl()))
            && (this.getBackgroundUrl() == null ? other.getBackgroundUrl() == null : this.getBackgroundUrl().equals(other.getBackgroundUrl()))
            && (this.getTopicAudit() == null ? other.getTopicAudit() == null : this.getTopicAudit().equals(other.getTopicAudit()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
            && (this.getWeixin() == null ? other.getWeixin() == null : this.getWeixin().equals(other.getWeixin()))
            && (this.getPropertyCompany() == null ? other.getPropertyCompany() == null : this.getPropertyCompany().equals(other.getPropertyCompany()))
            && (this.getBusinessPerson() == null ? other.getBusinessPerson() == null : this.getBusinessPerson().equals(other.getBusinessPerson()))
            && (this.getBusinessPhone() == null ? other.getBusinessPhone() == null : this.getBusinessPhone().equals(other.getBusinessPhone()))
            && (this.getBusinessEmail() == null ? other.getBusinessEmail() == null : this.getBusinessEmail().equals(other.getBusinessEmail()))
            && (this.getPinyin() == null ? other.getPinyin() == null : this.getPinyin().equals(other.getPinyin()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getTel() == null) ? 0 : getTel().hashCode());
        result = prime * result + ((getCityId() == null) ? 0 : getCityId().hashCode());
        result = prime * result + ((getCityName() == null) ? 0 : getCityName().hashCode());
        result = prime * result + ((getAreaId() == null) ? 0 : getAreaId().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getIntro() == null) ? 0 : getIntro().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getProjectGuid() == null) ? 0 : getProjectGuid().hashCode());
        result = prime * result + ((getCategory() == null) ? 0 : getCategory().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getSyncFlag() == null) ? 0 : getSyncFlag().hashCode());
        result = prime * result + ((getQrcodeUrl() == null) ? 0 : getQrcodeUrl().hashCode());
        result = prime * result + ((getLongitude() == null) ? 0 : getLongitude().hashCode());
        result = prime * result + ((getLatitude() == null) ? 0 : getLatitude().hashCode());
        result = prime * result + ((getAdminId() == null) ? 0 : getAdminId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getBuildingArea() == null) ? 0 : getBuildingArea().hashCode());
        result = prime * result + ((getPracticalArea() == null) ? 0 : getPracticalArea().hashCode());
        result = prime * result + ((getTypeDesc() == null) ? 0 : getTypeDesc().hashCode());
        result = prime * result + ((getLogoUrl() == null) ? 0 : getLogoUrl().hashCode());
        result = prime * result + ((getBackgroundUrl() == null) ? 0 : getBackgroundUrl().hashCode());
        result = prime * result + ((getTopicAudit() == null) ? 0 : getTopicAudit().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCid() == null) ? 0 : getCid().hashCode());
        result = prime * result + ((getWeixin() == null) ? 0 : getWeixin().hashCode());
        result = prime * result + ((getPropertyCompany() == null) ? 0 : getPropertyCompany().hashCode());
        result = prime * result + ((getBusinessPerson() == null) ? 0 : getBusinessPerson().hashCode());
        result = prime * result + ((getBusinessPhone() == null) ? 0 : getBusinessPhone().hashCode());
        result = prime * result + ((getBusinessEmail() == null) ? 0 : getBusinessEmail().hashCode());
        result = prime * result + ((getPinyin() == null) ? 0 : getPinyin().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}