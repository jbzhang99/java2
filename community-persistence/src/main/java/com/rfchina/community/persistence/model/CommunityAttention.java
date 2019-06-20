package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class CommunityAttention extends CommunityAttentionKey implements Serializable {
    private Date createTime;

    private Long idxSeq;

    private Integer addType;

    private static final long serialVersionUID = 1L;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getIdxSeq() {
        return idxSeq;
    }

    public void setIdxSeq(Long idxSeq) {
        this.idxSeq = idxSeq;
    }

    public Integer getAddType() {
        return addType;
    }

    public void setAddType(Integer addType) {
        this.addType = addType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", createTime=").append(createTime);
        sb.append(", idxSeq=").append(idxSeq);
        sb.append(", addType=").append(addType);
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
        CommunityAttention other = (CommunityAttention) that;
        return (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getIdxSeq() == null ? other.getIdxSeq() == null : this.getIdxSeq().equals(other.getIdxSeq()))
            && (this.getAddType() == null ? other.getAddType() == null : this.getAddType().equals(other.getAddType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getIdxSeq() == null) ? 0 : getIdxSeq().hashCode());
        result = prime * result + ((getAddType() == null) ? 0 : getAddType().hashCode());
        return result;
    }
}