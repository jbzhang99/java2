package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class CardInfo implements Serializable {
    private Long id;

    private Integer categoryId;

    private Integer templateId;

    private Integer communityId;

    private String operationId;

    private String title;

    private String content;

    private Integer status;

    private Integer auditStatus;

    private String auditReason;

    private String squareAuditReason;

    private Integer squareAuditStatus;

    private Date squareAuditTime;

    private Date squarePublishTime;

    private Date publishTime;

    private String attachment;

    private Long subjectId;

    private String subjectName;

    private Integer subjectType;

    private String subjectIcon;

    private Integer pubToSquare;

    private String source;

    private Long creatorId;

    private Long cid;

    private Date applyTime;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getAuditReason() {
        return auditReason;
    }

    public void setAuditReason(String auditReason) {
        this.auditReason = auditReason;
    }

    public String getSquareAuditReason() {
        return squareAuditReason;
    }

    public void setSquareAuditReason(String squareAuditReason) {
        this.squareAuditReason = squareAuditReason;
    }

    public Integer getSquareAuditStatus() {
        return squareAuditStatus;
    }

    public void setSquareAuditStatus(Integer squareAuditStatus) {
        this.squareAuditStatus = squareAuditStatus;
    }

    public Date getSquareAuditTime() {
        return squareAuditTime;
    }

    public void setSquareAuditTime(Date squareAuditTime) {
        this.squareAuditTime = squareAuditTime;
    }

    public Date getSquarePublishTime() {
        return squarePublishTime;
    }

    public void setSquarePublishTime(Date squarePublishTime) {
        this.squarePublishTime = squarePublishTime;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(Integer subjectType) {
        this.subjectType = subjectType;
    }

    public String getSubjectIcon() {
        return subjectIcon;
    }

    public void setSubjectIcon(String subjectIcon) {
        this.subjectIcon = subjectIcon;
    }

    public Integer getPubToSquare() {
        return pubToSquare;
    }

    public void setPubToSquare(Integer pubToSquare) {
        this.pubToSquare = pubToSquare;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", templateId=").append(templateId);
        sb.append(", communityId=").append(communityId);
        sb.append(", operationId=").append(operationId);
        sb.append(", title=").append(title);
        sb.append(", content=").append(content);
        sb.append(", status=").append(status);
        sb.append(", auditStatus=").append(auditStatus);
        sb.append(", auditReason=").append(auditReason);
        sb.append(", squareAuditReason=").append(squareAuditReason);
        sb.append(", squareAuditStatus=").append(squareAuditStatus);
        sb.append(", squareAuditTime=").append(squareAuditTime);
        sb.append(", squarePublishTime=").append(squarePublishTime);
        sb.append(", publishTime=").append(publishTime);
        sb.append(", attachment=").append(attachment);
        sb.append(", subjectId=").append(subjectId);
        sb.append(", subjectName=").append(subjectName);
        sb.append(", subjectType=").append(subjectType);
        sb.append(", subjectIcon=").append(subjectIcon);
        sb.append(", pubToSquare=").append(pubToSquare);
        sb.append(", source=").append(source);
        sb.append(", creatorId=").append(creatorId);
        sb.append(", cid=").append(cid);
        sb.append(", applyTime=").append(applyTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteTime=").append(deleteTime);
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
        CardInfo other = (CardInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getTemplateId() == null ? other.getTemplateId() == null : this.getTemplateId().equals(other.getTemplateId()))
            && (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getOperationId() == null ? other.getOperationId() == null : this.getOperationId().equals(other.getOperationId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getAuditStatus() == null ? other.getAuditStatus() == null : this.getAuditStatus().equals(other.getAuditStatus()))
            && (this.getAuditReason() == null ? other.getAuditReason() == null : this.getAuditReason().equals(other.getAuditReason()))
            && (this.getSquareAuditReason() == null ? other.getSquareAuditReason() == null : this.getSquareAuditReason().equals(other.getSquareAuditReason()))
            && (this.getSquareAuditStatus() == null ? other.getSquareAuditStatus() == null : this.getSquareAuditStatus().equals(other.getSquareAuditStatus()))
            && (this.getSquareAuditTime() == null ? other.getSquareAuditTime() == null : this.getSquareAuditTime().equals(other.getSquareAuditTime()))
            && (this.getSquarePublishTime() == null ? other.getSquarePublishTime() == null : this.getSquarePublishTime().equals(other.getSquarePublishTime()))
            && (this.getPublishTime() == null ? other.getPublishTime() == null : this.getPublishTime().equals(other.getPublishTime()))
            && (this.getAttachment() == null ? other.getAttachment() == null : this.getAttachment().equals(other.getAttachment()))
            && (this.getSubjectId() == null ? other.getSubjectId() == null : this.getSubjectId().equals(other.getSubjectId()))
            && (this.getSubjectName() == null ? other.getSubjectName() == null : this.getSubjectName().equals(other.getSubjectName()))
            && (this.getSubjectType() == null ? other.getSubjectType() == null : this.getSubjectType().equals(other.getSubjectType()))
            && (this.getSubjectIcon() == null ? other.getSubjectIcon() == null : this.getSubjectIcon().equals(other.getSubjectIcon()))
            && (this.getPubToSquare() == null ? other.getPubToSquare() == null : this.getPubToSquare().equals(other.getPubToSquare()))
            && (this.getSource() == null ? other.getSource() == null : this.getSource().equals(other.getSource()))
            && (this.getCreatorId() == null ? other.getCreatorId() == null : this.getCreatorId().equals(other.getCreatorId()))
            && (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
            && (this.getApplyTime() == null ? other.getApplyTime() == null : this.getApplyTime().equals(other.getApplyTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleteTime() == null ? other.getDeleteTime() == null : this.getDeleteTime().equals(other.getDeleteTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getTemplateId() == null) ? 0 : getTemplateId().hashCode());
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getOperationId() == null) ? 0 : getOperationId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAuditStatus() == null) ? 0 : getAuditStatus().hashCode());
        result = prime * result + ((getAuditReason() == null) ? 0 : getAuditReason().hashCode());
        result = prime * result + ((getSquareAuditReason() == null) ? 0 : getSquareAuditReason().hashCode());
        result = prime * result + ((getSquareAuditStatus() == null) ? 0 : getSquareAuditStatus().hashCode());
        result = prime * result + ((getSquareAuditTime() == null) ? 0 : getSquareAuditTime().hashCode());
        result = prime * result + ((getSquarePublishTime() == null) ? 0 : getSquarePublishTime().hashCode());
        result = prime * result + ((getPublishTime() == null) ? 0 : getPublishTime().hashCode());
        result = prime * result + ((getAttachment() == null) ? 0 : getAttachment().hashCode());
        result = prime * result + ((getSubjectId() == null) ? 0 : getSubjectId().hashCode());
        result = prime * result + ((getSubjectName() == null) ? 0 : getSubjectName().hashCode());
        result = prime * result + ((getSubjectType() == null) ? 0 : getSubjectType().hashCode());
        result = prime * result + ((getSubjectIcon() == null) ? 0 : getSubjectIcon().hashCode());
        result = prime * result + ((getPubToSquare() == null) ? 0 : getPubToSquare().hashCode());
        result = prime * result + ((getSource() == null) ? 0 : getSource().hashCode());
        result = prime * result + ((getCreatorId() == null) ? 0 : getCreatorId().hashCode());
        result = prime * result + ((getCid() == null) ? 0 : getCid().hashCode());
        result = prime * result + ((getApplyTime() == null) ? 0 : getApplyTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDeleteTime() == null) ? 0 : getDeleteTime().hashCode());
        return result;
    }
}