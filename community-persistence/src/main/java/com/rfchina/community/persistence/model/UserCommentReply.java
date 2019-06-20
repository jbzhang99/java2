package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class UserCommentReply implements Serializable {
    private Long id;

    private Long commentId;

    private Long replyTarget;

    private String status;

    private Date createTime;

    private Long commentator;

    private String replyComment;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getReplyTarget() {
        return replyTarget;
    }

    public void setReplyTarget(Long replyTarget) {
        this.replyTarget = replyTarget;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCommentator() {
        return commentator;
    }

    public void setCommentator(Long commentator) {
        this.commentator = commentator;
    }

    public String getReplyComment() {
        return replyComment;
    }

    public void setReplyComment(String replyComment) {
        this.replyComment = replyComment;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", commentId=").append(commentId);
        sb.append(", replyTarget=").append(replyTarget);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", commentator=").append(commentator);
        sb.append(", replyComment=").append(replyComment);
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
        UserCommentReply other = (UserCommentReply) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCommentId() == null ? other.getCommentId() == null : this.getCommentId().equals(other.getCommentId()))
            && (this.getReplyTarget() == null ? other.getReplyTarget() == null : this.getReplyTarget().equals(other.getReplyTarget()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCommentator() == null ? other.getCommentator() == null : this.getCommentator().equals(other.getCommentator()))
            && (this.getReplyComment() == null ? other.getReplyComment() == null : this.getReplyComment().equals(other.getReplyComment()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCommentId() == null) ? 0 : getCommentId().hashCode());
        result = prime * result + ((getReplyTarget() == null) ? 0 : getReplyTarget().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCommentator() == null) ? 0 : getCommentator().hashCode());
        result = prime * result + ((getReplyComment() == null) ? 0 : getReplyComment().hashCode());
        return result;
    }
}