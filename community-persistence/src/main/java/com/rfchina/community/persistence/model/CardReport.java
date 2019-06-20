package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class CardReport implements Serializable {
    private Long id;

    private Long cardId;

    private Integer categoryId;

    private Integer communityId;

    private Long ruid;

    private String rfullname;

    private String rphone;

    private Long suid;

    private Integer stype;

    private String sfullname;

    private String sphone;

    private String content;

    private String cardContent;

    private String cardAttachment;

    private Integer status;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
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

    public Long getRuid() {
        return ruid;
    }

    public void setRuid(Long ruid) {
        this.ruid = ruid;
    }

    public String getRfullname() {
        return rfullname;
    }

    public void setRfullname(String rfullname) {
        this.rfullname = rfullname;
    }

    public String getRphone() {
        return rphone;
    }

    public void setRphone(String rphone) {
        this.rphone = rphone;
    }

    public Long getSuid() {
        return suid;
    }

    public void setSuid(Long suid) {
        this.suid = suid;
    }

    public Integer getStype() {
        return stype;
    }

    public void setStype(Integer stype) {
        this.stype = stype;
    }

    public String getSfullname() {
        return sfullname;
    }

    public void setSfullname(String sfullname) {
        this.sfullname = sfullname;
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCardContent() {
        return cardContent;
    }

    public void setCardContent(String cardContent) {
        this.cardContent = cardContent;
    }

    public String getCardAttachment() {
        return cardAttachment;
    }

    public void setCardAttachment(String cardAttachment) {
        this.cardAttachment = cardAttachment;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", cardId=").append(cardId);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", communityId=").append(communityId);
        sb.append(", ruid=").append(ruid);
        sb.append(", rfullname=").append(rfullname);
        sb.append(", rphone=").append(rphone);
        sb.append(", suid=").append(suid);
        sb.append(", stype=").append(stype);
        sb.append(", sfullname=").append(sfullname);
        sb.append(", sphone=").append(sphone);
        sb.append(", content=").append(content);
        sb.append(", cardContent=").append(cardContent);
        sb.append(", cardAttachment=").append(cardAttachment);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
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
        CardReport other = (CardReport) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCardId() == null ? other.getCardId() == null : this.getCardId().equals(other.getCardId()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getRuid() == null ? other.getRuid() == null : this.getRuid().equals(other.getRuid()))
            && (this.getRfullname() == null ? other.getRfullname() == null : this.getRfullname().equals(other.getRfullname()))
            && (this.getRphone() == null ? other.getRphone() == null : this.getRphone().equals(other.getRphone()))
            && (this.getSuid() == null ? other.getSuid() == null : this.getSuid().equals(other.getSuid()))
            && (this.getStype() == null ? other.getStype() == null : this.getStype().equals(other.getStype()))
            && (this.getSfullname() == null ? other.getSfullname() == null : this.getSfullname().equals(other.getSfullname()))
            && (this.getSphone() == null ? other.getSphone() == null : this.getSphone().equals(other.getSphone()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getCardContent() == null ? other.getCardContent() == null : this.getCardContent().equals(other.getCardContent()))
            && (this.getCardAttachment() == null ? other.getCardAttachment() == null : this.getCardAttachment().equals(other.getCardAttachment()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCardId() == null) ? 0 : getCardId().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getRuid() == null) ? 0 : getRuid().hashCode());
        result = prime * result + ((getRfullname() == null) ? 0 : getRfullname().hashCode());
        result = prime * result + ((getRphone() == null) ? 0 : getRphone().hashCode());
        result = prime * result + ((getSuid() == null) ? 0 : getSuid().hashCode());
        result = prime * result + ((getStype() == null) ? 0 : getStype().hashCode());
        result = prime * result + ((getSfullname() == null) ? 0 : getSfullname().hashCode());
        result = prime * result + ((getSphone() == null) ? 0 : getSphone().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getCardContent() == null) ? 0 : getCardContent().hashCode());
        result = prime * result + ((getCardAttachment() == null) ? 0 : getCardAttachment().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}