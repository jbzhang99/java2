package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class CommunityServiceRela extends CommunityServiceRelaKey implements Serializable {
    private Integer reorder;

    private String remark;

    private Date createTime;

    private Integer status;

    private Date updateTime;

    private Date groundTime;

    private Integer auditStatus;

    private Date applyTime;

    private String serviceContactsName;

    private String serviceContactsPhone;

    private String serviceContactsEmail;

    private String communityContactsName;

    private String communityContactsPhone;

    private String communityContactsEmail;

    private Date interviewTime;

    private String interviewAddress;

    private Integer selectStatus;

    private String auditComment;

    private Integer isMenuShow;

    private Date notifyTime;

    private String contactWay;

    private static final long serialVersionUID = 1L;

    public Integer getReorder() {
        return reorder;
    }

    public void setReorder(Integer reorder) {
        this.reorder = reorder;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getGroundTime() {
        return groundTime;
    }

    public void setGroundTime(Date groundTime) {
        this.groundTime = groundTime;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public String getServiceContactsName() {
        return serviceContactsName;
    }

    public void setServiceContactsName(String serviceContactsName) {
        this.serviceContactsName = serviceContactsName;
    }

    public String getServiceContactsPhone() {
        return serviceContactsPhone;
    }

    public void setServiceContactsPhone(String serviceContactsPhone) {
        this.serviceContactsPhone = serviceContactsPhone;
    }

    public String getServiceContactsEmail() {
        return serviceContactsEmail;
    }

    public void setServiceContactsEmail(String serviceContactsEmail) {
        this.serviceContactsEmail = serviceContactsEmail;
    }

    public String getCommunityContactsName() {
        return communityContactsName;
    }

    public void setCommunityContactsName(String communityContactsName) {
        this.communityContactsName = communityContactsName;
    }

    public String getCommunityContactsPhone() {
        return communityContactsPhone;
    }

    public void setCommunityContactsPhone(String communityContactsPhone) {
        this.communityContactsPhone = communityContactsPhone;
    }

    public String getCommunityContactsEmail() {
        return communityContactsEmail;
    }

    public void setCommunityContactsEmail(String communityContactsEmail) {
        this.communityContactsEmail = communityContactsEmail;
    }

    public Date getInterviewTime() {
        return interviewTime;
    }

    public void setInterviewTime(Date interviewTime) {
        this.interviewTime = interviewTime;
    }

    public String getInterviewAddress() {
        return interviewAddress;
    }

    public void setInterviewAddress(String interviewAddress) {
        this.interviewAddress = interviewAddress;
    }

    public Integer getSelectStatus() {
        return selectStatus;
    }

    public void setSelectStatus(Integer selectStatus) {
        this.selectStatus = selectStatus;
    }

    public String getAuditComment() {
        return auditComment;
    }

    public void setAuditComment(String auditComment) {
        this.auditComment = auditComment;
    }

    public Integer getIsMenuShow() {
        return isMenuShow;
    }

    public void setIsMenuShow(Integer isMenuShow) {
        this.isMenuShow = isMenuShow;
    }

    public Date getNotifyTime() {
        return notifyTime;
    }

    public void setNotifyTime(Date notifyTime) {
        this.notifyTime = notifyTime;
    }

    public String getContactWay() {
        return contactWay;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", reorder=").append(reorder);
        sb.append(", remark=").append(remark);
        sb.append(", createTime=").append(createTime);
        sb.append(", status=").append(status);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", groundTime=").append(groundTime);
        sb.append(", auditStatus=").append(auditStatus);
        sb.append(", applyTime=").append(applyTime);
        sb.append(", serviceContactsName=").append(serviceContactsName);
        sb.append(", serviceContactsPhone=").append(serviceContactsPhone);
        sb.append(", serviceContactsEmail=").append(serviceContactsEmail);
        sb.append(", communityContactsName=").append(communityContactsName);
        sb.append(", communityContactsPhone=").append(communityContactsPhone);
        sb.append(", communityContactsEmail=").append(communityContactsEmail);
        sb.append(", interviewTime=").append(interviewTime);
        sb.append(", interviewAddress=").append(interviewAddress);
        sb.append(", selectStatus=").append(selectStatus);
        sb.append(", auditComment=").append(auditComment);
        sb.append(", isMenuShow=").append(isMenuShow);
        sb.append(", notifyTime=").append(notifyTime);
        sb.append(", contactWay=").append(contactWay);
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
        CommunityServiceRela other = (CommunityServiceRela) that;
        return (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getServiceId() == null ? other.getServiceId() == null : this.getServiceId().equals(other.getServiceId()))
            && (this.getReorder() == null ? other.getReorder() == null : this.getReorder().equals(other.getReorder()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getGroundTime() == null ? other.getGroundTime() == null : this.getGroundTime().equals(other.getGroundTime()))
            && (this.getAuditStatus() == null ? other.getAuditStatus() == null : this.getAuditStatus().equals(other.getAuditStatus()))
            && (this.getApplyTime() == null ? other.getApplyTime() == null : this.getApplyTime().equals(other.getApplyTime()))
            && (this.getServiceContactsName() == null ? other.getServiceContactsName() == null : this.getServiceContactsName().equals(other.getServiceContactsName()))
            && (this.getServiceContactsPhone() == null ? other.getServiceContactsPhone() == null : this.getServiceContactsPhone().equals(other.getServiceContactsPhone()))
            && (this.getServiceContactsEmail() == null ? other.getServiceContactsEmail() == null : this.getServiceContactsEmail().equals(other.getServiceContactsEmail()))
            && (this.getCommunityContactsName() == null ? other.getCommunityContactsName() == null : this.getCommunityContactsName().equals(other.getCommunityContactsName()))
            && (this.getCommunityContactsPhone() == null ? other.getCommunityContactsPhone() == null : this.getCommunityContactsPhone().equals(other.getCommunityContactsPhone()))
            && (this.getCommunityContactsEmail() == null ? other.getCommunityContactsEmail() == null : this.getCommunityContactsEmail().equals(other.getCommunityContactsEmail()))
            && (this.getInterviewTime() == null ? other.getInterviewTime() == null : this.getInterviewTime().equals(other.getInterviewTime()))
            && (this.getInterviewAddress() == null ? other.getInterviewAddress() == null : this.getInterviewAddress().equals(other.getInterviewAddress()))
            && (this.getSelectStatus() == null ? other.getSelectStatus() == null : this.getSelectStatus().equals(other.getSelectStatus()))
            && (this.getAuditComment() == null ? other.getAuditComment() == null : this.getAuditComment().equals(other.getAuditComment()))
            && (this.getIsMenuShow() == null ? other.getIsMenuShow() == null : this.getIsMenuShow().equals(other.getIsMenuShow()))
            && (this.getNotifyTime() == null ? other.getNotifyTime() == null : this.getNotifyTime().equals(other.getNotifyTime()))
            && (this.getContactWay() == null ? other.getContactWay() == null : this.getContactWay().equals(other.getContactWay()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getServiceId() == null) ? 0 : getServiceId().hashCode());
        result = prime * result + ((getReorder() == null) ? 0 : getReorder().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getGroundTime() == null) ? 0 : getGroundTime().hashCode());
        result = prime * result + ((getAuditStatus() == null) ? 0 : getAuditStatus().hashCode());
        result = prime * result + ((getApplyTime() == null) ? 0 : getApplyTime().hashCode());
        result = prime * result + ((getServiceContactsName() == null) ? 0 : getServiceContactsName().hashCode());
        result = prime * result + ((getServiceContactsPhone() == null) ? 0 : getServiceContactsPhone().hashCode());
        result = prime * result + ((getServiceContactsEmail() == null) ? 0 : getServiceContactsEmail().hashCode());
        result = prime * result + ((getCommunityContactsName() == null) ? 0 : getCommunityContactsName().hashCode());
        result = prime * result + ((getCommunityContactsPhone() == null) ? 0 : getCommunityContactsPhone().hashCode());
        result = prime * result + ((getCommunityContactsEmail() == null) ? 0 : getCommunityContactsEmail().hashCode());
        result = prime * result + ((getInterviewTime() == null) ? 0 : getInterviewTime().hashCode());
        result = prime * result + ((getInterviewAddress() == null) ? 0 : getInterviewAddress().hashCode());
        result = prime * result + ((getSelectStatus() == null) ? 0 : getSelectStatus().hashCode());
        result = prime * result + ((getAuditComment() == null) ? 0 : getAuditComment().hashCode());
        result = prime * result + ((getIsMenuShow() == null) ? 0 : getIsMenuShow().hashCode());
        result = prime * result + ((getNotifyTime() == null) ? 0 : getNotifyTime().hashCode());
        result = prime * result + ((getContactWay() == null) ? 0 : getContactWay().hashCode());
        return result;
    }
}