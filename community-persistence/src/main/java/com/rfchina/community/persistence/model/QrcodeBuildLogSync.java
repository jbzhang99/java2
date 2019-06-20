package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class QrcodeBuildLogSync implements Serializable {
    private Long myId;

    private Date myCreateTime;

    private Integer myCommunityId;

    private Long id;

    private String qrcodeDecoding;

    private Integer communityId;

    private Integer type;

    private Integer canPassCount;

    private Date beginTime;

    private Date endTime;

    private Long qrcodeId;

    private Date createTime;

    private Integer sysGroup;

    private static final long serialVersionUID = 1L;

    public Long getMyId() {
        return myId;
    }

    public void setMyId(Long myId) {
        this.myId = myId;
    }

    public Date getMyCreateTime() {
        return myCreateTime;
    }

    public void setMyCreateTime(Date myCreateTime) {
        this.myCreateTime = myCreateTime;
    }

    public Integer getMyCommunityId() {
        return myCommunityId;
    }

    public void setMyCommunityId(Integer myCommunityId) {
        this.myCommunityId = myCommunityId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQrcodeDecoding() {
        return qrcodeDecoding;
    }

    public void setQrcodeDecoding(String qrcodeDecoding) {
        this.qrcodeDecoding = qrcodeDecoding;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCanPassCount() {
        return canPassCount;
    }

    public void setCanPassCount(Integer canPassCount) {
        this.canPassCount = canPassCount;
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

    public Long getQrcodeId() {
        return qrcodeId;
    }

    public void setQrcodeId(Long qrcodeId) {
        this.qrcodeId = qrcodeId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getSysGroup() {
        return sysGroup;
    }

    public void setSysGroup(Integer sysGroup) {
        this.sysGroup = sysGroup;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", myId=").append(myId);
        sb.append(", myCreateTime=").append(myCreateTime);
        sb.append(", myCommunityId=").append(myCommunityId);
        sb.append(", id=").append(id);
        sb.append(", qrcodeDecoding=").append(qrcodeDecoding);
        sb.append(", communityId=").append(communityId);
        sb.append(", type=").append(type);
        sb.append(", canPassCount=").append(canPassCount);
        sb.append(", beginTime=").append(beginTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", qrcodeId=").append(qrcodeId);
        sb.append(", createTime=").append(createTime);
        sb.append(", sysGroup=").append(sysGroup);
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
        QrcodeBuildLogSync other = (QrcodeBuildLogSync) that;
        return (this.getMyId() == null ? other.getMyId() == null : this.getMyId().equals(other.getMyId()))
            && (this.getMyCreateTime() == null ? other.getMyCreateTime() == null : this.getMyCreateTime().equals(other.getMyCreateTime()))
            && (this.getMyCommunityId() == null ? other.getMyCommunityId() == null : this.getMyCommunityId().equals(other.getMyCommunityId()))
            && (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getQrcodeDecoding() == null ? other.getQrcodeDecoding() == null : this.getQrcodeDecoding().equals(other.getQrcodeDecoding()))
            && (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getCanPassCount() == null ? other.getCanPassCount() == null : this.getCanPassCount().equals(other.getCanPassCount()))
            && (this.getBeginTime() == null ? other.getBeginTime() == null : this.getBeginTime().equals(other.getBeginTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getQrcodeId() == null ? other.getQrcodeId() == null : this.getQrcodeId().equals(other.getQrcodeId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getSysGroup() == null ? other.getSysGroup() == null : this.getSysGroup().equals(other.getSysGroup()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMyId() == null) ? 0 : getMyId().hashCode());
        result = prime * result + ((getMyCreateTime() == null) ? 0 : getMyCreateTime().hashCode());
        result = prime * result + ((getMyCommunityId() == null) ? 0 : getMyCommunityId().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getQrcodeDecoding() == null) ? 0 : getQrcodeDecoding().hashCode());
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getCanPassCount() == null) ? 0 : getCanPassCount().hashCode());
        result = prime * result + ((getBeginTime() == null) ? 0 : getBeginTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getQrcodeId() == null) ? 0 : getQrcodeId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getSysGroup() == null) ? 0 : getSysGroup().hashCode());
        return result;
    }
}