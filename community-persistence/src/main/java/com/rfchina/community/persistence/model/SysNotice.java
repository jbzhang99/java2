package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class SysNotice implements Serializable {
    private Long id;

    private Integer createComm;

    private Long createId;

    private Date createTime;

    private String title;

    private Long platformUid;

    private Long commUid;

    private Long masterUid;

    private Long sellerUid;

    private Integer status;

    private String content;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCreateComm() {
        return createComm;
    }

    public void setCreateComm(Integer createComm) {
        this.createComm = createComm;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPlatformUid() {
        return platformUid;
    }

    public void setPlatformUid(Long platformUid) {
        this.platformUid = platformUid;
    }

    public Long getCommUid() {
        return commUid;
    }

    public void setCommUid(Long commUid) {
        this.commUid = commUid;
    }

    public Long getMasterUid() {
        return masterUid;
    }

    public void setMasterUid(Long masterUid) {
        this.masterUid = masterUid;
    }

    public Long getSellerUid() {
        return sellerUid;
    }

    public void setSellerUid(Long sellerUid) {
        this.sellerUid = sellerUid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createComm=").append(createComm);
        sb.append(", createId=").append(createId);
        sb.append(", createTime=").append(createTime);
        sb.append(", title=").append(title);
        sb.append(", platformUid=").append(platformUid);
        sb.append(", commUid=").append(commUid);
        sb.append(", masterUid=").append(masterUid);
        sb.append(", sellerUid=").append(sellerUid);
        sb.append(", status=").append(status);
        sb.append(", content=").append(content);
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
        SysNotice other = (SysNotice) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateComm() == null ? other.getCreateComm() == null : this.getCreateComm().equals(other.getCreateComm()))
            && (this.getCreateId() == null ? other.getCreateId() == null : this.getCreateId().equals(other.getCreateId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getPlatformUid() == null ? other.getPlatformUid() == null : this.getPlatformUid().equals(other.getPlatformUid()))
            && (this.getCommUid() == null ? other.getCommUid() == null : this.getCommUid().equals(other.getCommUid()))
            && (this.getMasterUid() == null ? other.getMasterUid() == null : this.getMasterUid().equals(other.getMasterUid()))
            && (this.getSellerUid() == null ? other.getSellerUid() == null : this.getSellerUid().equals(other.getSellerUid()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateComm() == null) ? 0 : getCreateComm().hashCode());
        result = prime * result + ((getCreateId() == null) ? 0 : getCreateId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getPlatformUid() == null) ? 0 : getPlatformUid().hashCode());
        result = prime * result + ((getCommUid() == null) ? 0 : getCommUid().hashCode());
        result = prime * result + ((getMasterUid() == null) ? 0 : getMasterUid().hashCode());
        result = prime * result + ((getSellerUid() == null) ? 0 : getSellerUid().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        return result;
    }
}