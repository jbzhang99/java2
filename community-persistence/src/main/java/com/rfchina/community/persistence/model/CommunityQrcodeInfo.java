package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class CommunityQrcodeInfo implements Serializable {
    private Integer communityId;

    private Integer otherCommunity;

    private Integer status;

    private Integer type;

    private Integer canCount;

    private Integer idKey;

    private String privateKey;

    private String publicKey;

    private Date syncTime;

    private static final long serialVersionUID = 1L;

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public Integer getOtherCommunity() {
        return otherCommunity;
    }

    public void setOtherCommunity(Integer otherCommunity) {
        this.otherCommunity = otherCommunity;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCanCount() {
        return canCount;
    }

    public void setCanCount(Integer canCount) {
        this.canCount = canCount;
    }

    public Integer getIdKey() {
        return idKey;
    }

    public void setIdKey(Integer idKey) {
        this.idKey = idKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public Date getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(Date syncTime) {
        this.syncTime = syncTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", communityId=").append(communityId);
        sb.append(", otherCommunity=").append(otherCommunity);
        sb.append(", status=").append(status);
        sb.append(", type=").append(type);
        sb.append(", canCount=").append(canCount);
        sb.append(", idKey=").append(idKey);
        sb.append(", privateKey=").append(privateKey);
        sb.append(", publicKey=").append(publicKey);
        sb.append(", syncTime=").append(syncTime);
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
        CommunityQrcodeInfo other = (CommunityQrcodeInfo) that;
        return (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getOtherCommunity() == null ? other.getOtherCommunity() == null : this.getOtherCommunity().equals(other.getOtherCommunity()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getCanCount() == null ? other.getCanCount() == null : this.getCanCount().equals(other.getCanCount()))
            && (this.getIdKey() == null ? other.getIdKey() == null : this.getIdKey().equals(other.getIdKey()))
            && (this.getPrivateKey() == null ? other.getPrivateKey() == null : this.getPrivateKey().equals(other.getPrivateKey()))
            && (this.getPublicKey() == null ? other.getPublicKey() == null : this.getPublicKey().equals(other.getPublicKey()))
            && (this.getSyncTime() == null ? other.getSyncTime() == null : this.getSyncTime().equals(other.getSyncTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getOtherCommunity() == null) ? 0 : getOtherCommunity().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getCanCount() == null) ? 0 : getCanCount().hashCode());
        result = prime * result + ((getIdKey() == null) ? 0 : getIdKey().hashCode());
        result = prime * result + ((getPrivateKey() == null) ? 0 : getPrivateKey().hashCode());
        result = prime * result + ((getPublicKey() == null) ? 0 : getPublicKey().hashCode());
        result = prime * result + ((getSyncTime() == null) ? 0 : getSyncTime().hashCode());
        return result;
    }
}