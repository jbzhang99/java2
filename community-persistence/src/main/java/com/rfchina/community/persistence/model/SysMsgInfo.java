package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class SysMsgInfo implements Serializable {
    private Long id;

    private String content;

    private String objectKey;

    private String objectType;

    private Date createTime;

    private Integer createCommunityId;

    private String msgSourceType;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getObjectKey() {
        return objectKey;
    }

    public void setObjectKey(String objectKey) {
        this.objectKey = objectKey;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateCommunityId() {
        return createCommunityId;
    }

    public void setCreateCommunityId(Integer createCommunityId) {
        this.createCommunityId = createCommunityId;
    }

    public String getMsgSourceType() {
        return msgSourceType;
    }

    public void setMsgSourceType(String msgSourceType) {
        this.msgSourceType = msgSourceType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", content=").append(content);
        sb.append(", objectKey=").append(objectKey);
        sb.append(", objectType=").append(objectType);
        sb.append(", createTime=").append(createTime);
        sb.append(", createCommunityId=").append(createCommunityId);
        sb.append(", msgSourceType=").append(msgSourceType);
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
        SysMsgInfo other = (SysMsgInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getObjectKey() == null ? other.getObjectKey() == null : this.getObjectKey().equals(other.getObjectKey()))
            && (this.getObjectType() == null ? other.getObjectType() == null : this.getObjectType().equals(other.getObjectType()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateCommunityId() == null ? other.getCreateCommunityId() == null : this.getCreateCommunityId().equals(other.getCreateCommunityId()))
            && (this.getMsgSourceType() == null ? other.getMsgSourceType() == null : this.getMsgSourceType().equals(other.getMsgSourceType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getObjectKey() == null) ? 0 : getObjectKey().hashCode());
        result = prime * result + ((getObjectType() == null) ? 0 : getObjectType().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateCommunityId() == null) ? 0 : getCreateCommunityId().hashCode());
        result = prime * result + ((getMsgSourceType() == null) ? 0 : getMsgSourceType().hashCode());
        return result;
    }
}