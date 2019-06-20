package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class OpenXFSJInfo implements Serializable {
    private Long id;

    private String type;

    private Integer categoryId;

    private Integer communityId;

    private String actTitile;

    private String actAddress;

    private String actTime;

    private String actImg;

    private String actUrl;

    private Integer status;

    private Date createTime;

    private Long createUid;

    private Date beginTime;

    private Date endTime;

    private Long groupConfigId;

    private Long areaConfigId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public String getActTitile() {
        return actTitile;
    }

    public void setActTitile(String actTitile) {
        this.actTitile = actTitile;
    }

    public String getActAddress() {
        return actAddress;
    }

    public void setActAddress(String actAddress) {
        this.actAddress = actAddress;
    }

    public String getActTime() {
        return actTime;
    }

    public void setActTime(String actTime) {
        this.actTime = actTime;
    }

    public String getActImg() {
        return actImg;
    }

    public void setActImg(String actImg) {
        this.actImg = actImg;
    }

    public String getActUrl() {
        return actUrl;
    }

    public void setActUrl(String actUrl) {
        this.actUrl = actUrl;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUid() {
        return createUid;
    }

    public void setCreateUid(Long createUid) {
        this.createUid = createUid;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getGroupConfigId() {
        return groupConfigId;
    }

    public void setGroupConfigId(Long groupConfigId) {
        this.groupConfigId = groupConfigId;
    }

    public Long getAreaConfigId() {
        return areaConfigId;
    }

    public void setAreaConfigId(Long areaConfigId) {
        this.areaConfigId = areaConfigId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", communityId=").append(communityId);
        sb.append(", actTitile=").append(actTitile);
        sb.append(", actAddress=").append(actAddress);
        sb.append(", actTime=").append(actTime);
        sb.append(", actImg=").append(actImg);
        sb.append(", actUrl=").append(actUrl);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUid=").append(createUid);
        sb.append(", beginTime=").append(beginTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", groupConfigId=").append(groupConfigId);
        sb.append(", areaConfigId=").append(areaConfigId);
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
        OpenXFSJInfo other = (OpenXFSJInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getActTitile() == null ? other.getActTitile() == null : this.getActTitile().equals(other.getActTitile()))
            && (this.getActAddress() == null ? other.getActAddress() == null : this.getActAddress().equals(other.getActAddress()))
            && (this.getActTime() == null ? other.getActTime() == null : this.getActTime().equals(other.getActTime()))
            && (this.getActImg() == null ? other.getActImg() == null : this.getActImg().equals(other.getActImg()))
            && (this.getActUrl() == null ? other.getActUrl() == null : this.getActUrl().equals(other.getActUrl()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateUid() == null ? other.getCreateUid() == null : this.getCreateUid().equals(other.getCreateUid()))
            && (this.getBeginTime() == null ? other.getBeginTime() == null : this.getBeginTime().equals(other.getBeginTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getGroupConfigId() == null ? other.getGroupConfigId() == null : this.getGroupConfigId().equals(other.getGroupConfigId()))
            && (this.getAreaConfigId() == null ? other.getAreaConfigId() == null : this.getAreaConfigId().equals(other.getAreaConfigId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getActTitile() == null) ? 0 : getActTitile().hashCode());
        result = prime * result + ((getActAddress() == null) ? 0 : getActAddress().hashCode());
        result = prime * result + ((getActTime() == null) ? 0 : getActTime().hashCode());
        result = prime * result + ((getActImg() == null) ? 0 : getActImg().hashCode());
        result = prime * result + ((getActUrl() == null) ? 0 : getActUrl().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateUid() == null) ? 0 : getCreateUid().hashCode());
        result = prime * result + ((getBeginTime() == null) ? 0 : getBeginTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getGroupConfigId() == null) ? 0 : getGroupConfigId().hashCode());
        result = prime * result + ((getAreaConfigId() == null) ? 0 : getAreaConfigId().hashCode());
        return result;
    }
}