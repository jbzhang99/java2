package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class UserComment implements Serializable {
    private Long id;

    private String commentTargetType;

    private Long commentTarget;

    private String outTradeNo;

    private String picUrl;

    private Integer logisticsGrade;

    private Integer serviceGrade;

    private Integer goodsGrade;

    private Long commentator;

    private Date createTime;

    private String comment;

    private String status;

    private String replyStatus;

    private String userName;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentTargetType() {
        return commentTargetType;
    }

    public void setCommentTargetType(String commentTargetType) {
        this.commentTargetType = commentTargetType;
    }

    public Long getCommentTarget() {
        return commentTarget;
    }

    public void setCommentTarget(Long commentTarget) {
        this.commentTarget = commentTarget;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Integer getLogisticsGrade() {
        return logisticsGrade;
    }

    public void setLogisticsGrade(Integer logisticsGrade) {
        this.logisticsGrade = logisticsGrade;
    }

    public Integer getServiceGrade() {
        return serviceGrade;
    }

    public void setServiceGrade(Integer serviceGrade) {
        this.serviceGrade = serviceGrade;
    }

    public Integer getGoodsGrade() {
        return goodsGrade;
    }

    public void setGoodsGrade(Integer goodsGrade) {
        this.goodsGrade = goodsGrade;
    }

    public Long getCommentator() {
        return commentator;
    }

    public void setCommentator(Long commentator) {
        this.commentator = commentator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReplyStatus() {
        return replyStatus;
    }

    public void setReplyStatus(String replyStatus) {
        this.replyStatus = replyStatus;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", commentTargetType=").append(commentTargetType);
        sb.append(", commentTarget=").append(commentTarget);
        sb.append(", outTradeNo=").append(outTradeNo);
        sb.append(", picUrl=").append(picUrl);
        sb.append(", logisticsGrade=").append(logisticsGrade);
        sb.append(", serviceGrade=").append(serviceGrade);
        sb.append(", goodsGrade=").append(goodsGrade);
        sb.append(", commentator=").append(commentator);
        sb.append(", createTime=").append(createTime);
        sb.append(", comment=").append(comment);
        sb.append(", status=").append(status);
        sb.append(", replyStatus=").append(replyStatus);
        sb.append(", userName=").append(userName);
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
        UserComment other = (UserComment) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCommentTargetType() == null ? other.getCommentTargetType() == null : this.getCommentTargetType().equals(other.getCommentTargetType()))
            && (this.getCommentTarget() == null ? other.getCommentTarget() == null : this.getCommentTarget().equals(other.getCommentTarget()))
            && (this.getOutTradeNo() == null ? other.getOutTradeNo() == null : this.getOutTradeNo().equals(other.getOutTradeNo()))
            && (this.getPicUrl() == null ? other.getPicUrl() == null : this.getPicUrl().equals(other.getPicUrl()))
            && (this.getLogisticsGrade() == null ? other.getLogisticsGrade() == null : this.getLogisticsGrade().equals(other.getLogisticsGrade()))
            && (this.getServiceGrade() == null ? other.getServiceGrade() == null : this.getServiceGrade().equals(other.getServiceGrade()))
            && (this.getGoodsGrade() == null ? other.getGoodsGrade() == null : this.getGoodsGrade().equals(other.getGoodsGrade()))
            && (this.getCommentator() == null ? other.getCommentator() == null : this.getCommentator().equals(other.getCommentator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getComment() == null ? other.getComment() == null : this.getComment().equals(other.getComment()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getReplyStatus() == null ? other.getReplyStatus() == null : this.getReplyStatus().equals(other.getReplyStatus()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCommentTargetType() == null) ? 0 : getCommentTargetType().hashCode());
        result = prime * result + ((getCommentTarget() == null) ? 0 : getCommentTarget().hashCode());
        result = prime * result + ((getOutTradeNo() == null) ? 0 : getOutTradeNo().hashCode());
        result = prime * result + ((getPicUrl() == null) ? 0 : getPicUrl().hashCode());
        result = prime * result + ((getLogisticsGrade() == null) ? 0 : getLogisticsGrade().hashCode());
        result = prime * result + ((getServiceGrade() == null) ? 0 : getServiceGrade().hashCode());
        result = prime * result + ((getGoodsGrade() == null) ? 0 : getGoodsGrade().hashCode());
        result = prime * result + ((getCommentator() == null) ? 0 : getCommentator().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getComment() == null) ? 0 : getComment().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getReplyStatus() == null) ? 0 : getReplyStatus().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        return result;
    }
}