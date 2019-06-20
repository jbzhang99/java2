package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class VisitAppointment implements Serializable {
    private Long id;

    private Integer communityId;

    private Long masterId;

    private String visitor;

    private String visitorPhone;

    private Long visitorUid;

    private Integer visitorReadStatus;

    private Integer followQty;

    private Integer type;

    private Integer duration;

    private Long createUid;

    private Date createDate;

    private Date appointmentDate;

    private Integer masterAuditStatus;

    private Date masterAuditTime;

    private Long masterAuditUid;

    private String masterAuditPhone;

    private Date communityAuditTime;

    private Long communityAuditUid;

    private Integer communityAuditStatus;

    private Date visitorAuditTime;

    private Long visitorAuditUid;

    private Integer visitorAuditStatus;

    private Date renewAuditTime;

    private Long renewAuditUid;

    private Integer renewAuditStatus;

    private Integer status;

    private String token;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public Long getMasterId() {
        return masterId;
    }

    public void setMasterId(Long masterId) {
        this.masterId = masterId;
    }

    public String getVisitor() {
        return visitor;
    }

    public void setVisitor(String visitor) {
        this.visitor = visitor;
    }

    public String getVisitorPhone() {
        return visitorPhone;
    }

    public void setVisitorPhone(String visitorPhone) {
        this.visitorPhone = visitorPhone;
    }

    public Long getVisitorUid() {
        return visitorUid;
    }

    public void setVisitorUid(Long visitorUid) {
        this.visitorUid = visitorUid;
    }

    public Integer getVisitorReadStatus() {
        return visitorReadStatus;
    }

    public void setVisitorReadStatus(Integer visitorReadStatus) {
        this.visitorReadStatus = visitorReadStatus;
    }

    public Integer getFollowQty() {
        return followQty;
    }

    public void setFollowQty(Integer followQty) {
        this.followQty = followQty;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Long getCreateUid() {
        return createUid;
    }

    public void setCreateUid(Long createUid) {
        this.createUid = createUid;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Integer getMasterAuditStatus() {
        return masterAuditStatus;
    }

    public void setMasterAuditStatus(Integer masterAuditStatus) {
        this.masterAuditStatus = masterAuditStatus;
    }

    public Date getMasterAuditTime() {
        return masterAuditTime;
    }

    public void setMasterAuditTime(Date masterAuditTime) {
        this.masterAuditTime = masterAuditTime;
    }

    public Long getMasterAuditUid() {
        return masterAuditUid;
    }

    public void setMasterAuditUid(Long masterAuditUid) {
        this.masterAuditUid = masterAuditUid;
    }

    public String getMasterAuditPhone() {
        return masterAuditPhone;
    }

    public void setMasterAuditPhone(String masterAuditPhone) {
        this.masterAuditPhone = masterAuditPhone;
    }

    public Date getCommunityAuditTime() {
        return communityAuditTime;
    }

    public void setCommunityAuditTime(Date communityAuditTime) {
        this.communityAuditTime = communityAuditTime;
    }

    public Long getCommunityAuditUid() {
        return communityAuditUid;
    }

    public void setCommunityAuditUid(Long communityAuditUid) {
        this.communityAuditUid = communityAuditUid;
    }

    public Integer getCommunityAuditStatus() {
        return communityAuditStatus;
    }

    public void setCommunityAuditStatus(Integer communityAuditStatus) {
        this.communityAuditStatus = communityAuditStatus;
    }

    public Date getVisitorAuditTime() {
        return visitorAuditTime;
    }

    public void setVisitorAuditTime(Date visitorAuditTime) {
        this.visitorAuditTime = visitorAuditTime;
    }

    public Long getVisitorAuditUid() {
        return visitorAuditUid;
    }

    public void setVisitorAuditUid(Long visitorAuditUid) {
        this.visitorAuditUid = visitorAuditUid;
    }

    public Integer getVisitorAuditStatus() {
        return visitorAuditStatus;
    }

    public void setVisitorAuditStatus(Integer visitorAuditStatus) {
        this.visitorAuditStatus = visitorAuditStatus;
    }

    public Date getRenewAuditTime() {
        return renewAuditTime;
    }

    public void setRenewAuditTime(Date renewAuditTime) {
        this.renewAuditTime = renewAuditTime;
    }

    public Long getRenewAuditUid() {
        return renewAuditUid;
    }

    public void setRenewAuditUid(Long renewAuditUid) {
        this.renewAuditUid = renewAuditUid;
    }

    public Integer getRenewAuditStatus() {
        return renewAuditStatus;
    }

    public void setRenewAuditStatus(Integer renewAuditStatus) {
        this.renewAuditStatus = renewAuditStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", communityId=").append(communityId);
        sb.append(", masterId=").append(masterId);
        sb.append(", visitor=").append(visitor);
        sb.append(", visitorPhone=").append(visitorPhone);
        sb.append(", visitorUid=").append(visitorUid);
        sb.append(", visitorReadStatus=").append(visitorReadStatus);
        sb.append(", followQty=").append(followQty);
        sb.append(", type=").append(type);
        sb.append(", duration=").append(duration);
        sb.append(", createUid=").append(createUid);
        sb.append(", createDate=").append(createDate);
        sb.append(", appointmentDate=").append(appointmentDate);
        sb.append(", masterAuditStatus=").append(masterAuditStatus);
        sb.append(", masterAuditTime=").append(masterAuditTime);
        sb.append(", masterAuditUid=").append(masterAuditUid);
        sb.append(", masterAuditPhone=").append(masterAuditPhone);
        sb.append(", communityAuditTime=").append(communityAuditTime);
        sb.append(", communityAuditUid=").append(communityAuditUid);
        sb.append(", communityAuditStatus=").append(communityAuditStatus);
        sb.append(", visitorAuditTime=").append(visitorAuditTime);
        sb.append(", visitorAuditUid=").append(visitorAuditUid);
        sb.append(", visitorAuditStatus=").append(visitorAuditStatus);
        sb.append(", renewAuditTime=").append(renewAuditTime);
        sb.append(", renewAuditUid=").append(renewAuditUid);
        sb.append(", renewAuditStatus=").append(renewAuditStatus);
        sb.append(", status=").append(status);
        sb.append(", token=").append(token);
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
        VisitAppointment other = (VisitAppointment) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getMasterId() == null ? other.getMasterId() == null : this.getMasterId().equals(other.getMasterId()))
            && (this.getVisitor() == null ? other.getVisitor() == null : this.getVisitor().equals(other.getVisitor()))
            && (this.getVisitorPhone() == null ? other.getVisitorPhone() == null : this.getVisitorPhone().equals(other.getVisitorPhone()))
            && (this.getVisitorUid() == null ? other.getVisitorUid() == null : this.getVisitorUid().equals(other.getVisitorUid()))
            && (this.getVisitorReadStatus() == null ? other.getVisitorReadStatus() == null : this.getVisitorReadStatus().equals(other.getVisitorReadStatus()))
            && (this.getFollowQty() == null ? other.getFollowQty() == null : this.getFollowQty().equals(other.getFollowQty()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getDuration() == null ? other.getDuration() == null : this.getDuration().equals(other.getDuration()))
            && (this.getCreateUid() == null ? other.getCreateUid() == null : this.getCreateUid().equals(other.getCreateUid()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getAppointmentDate() == null ? other.getAppointmentDate() == null : this.getAppointmentDate().equals(other.getAppointmentDate()))
            && (this.getMasterAuditStatus() == null ? other.getMasterAuditStatus() == null : this.getMasterAuditStatus().equals(other.getMasterAuditStatus()))
            && (this.getMasterAuditTime() == null ? other.getMasterAuditTime() == null : this.getMasterAuditTime().equals(other.getMasterAuditTime()))
            && (this.getMasterAuditUid() == null ? other.getMasterAuditUid() == null : this.getMasterAuditUid().equals(other.getMasterAuditUid()))
            && (this.getMasterAuditPhone() == null ? other.getMasterAuditPhone() == null : this.getMasterAuditPhone().equals(other.getMasterAuditPhone()))
            && (this.getCommunityAuditTime() == null ? other.getCommunityAuditTime() == null : this.getCommunityAuditTime().equals(other.getCommunityAuditTime()))
            && (this.getCommunityAuditUid() == null ? other.getCommunityAuditUid() == null : this.getCommunityAuditUid().equals(other.getCommunityAuditUid()))
            && (this.getCommunityAuditStatus() == null ? other.getCommunityAuditStatus() == null : this.getCommunityAuditStatus().equals(other.getCommunityAuditStatus()))
            && (this.getVisitorAuditTime() == null ? other.getVisitorAuditTime() == null : this.getVisitorAuditTime().equals(other.getVisitorAuditTime()))
            && (this.getVisitorAuditUid() == null ? other.getVisitorAuditUid() == null : this.getVisitorAuditUid().equals(other.getVisitorAuditUid()))
            && (this.getVisitorAuditStatus() == null ? other.getVisitorAuditStatus() == null : this.getVisitorAuditStatus().equals(other.getVisitorAuditStatus()))
            && (this.getRenewAuditTime() == null ? other.getRenewAuditTime() == null : this.getRenewAuditTime().equals(other.getRenewAuditTime()))
            && (this.getRenewAuditUid() == null ? other.getRenewAuditUid() == null : this.getRenewAuditUid().equals(other.getRenewAuditUid()))
            && (this.getRenewAuditStatus() == null ? other.getRenewAuditStatus() == null : this.getRenewAuditStatus().equals(other.getRenewAuditStatus()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getToken() == null ? other.getToken() == null : this.getToken().equals(other.getToken()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getMasterId() == null) ? 0 : getMasterId().hashCode());
        result = prime * result + ((getVisitor() == null) ? 0 : getVisitor().hashCode());
        result = prime * result + ((getVisitorPhone() == null) ? 0 : getVisitorPhone().hashCode());
        result = prime * result + ((getVisitorUid() == null) ? 0 : getVisitorUid().hashCode());
        result = prime * result + ((getVisitorReadStatus() == null) ? 0 : getVisitorReadStatus().hashCode());
        result = prime * result + ((getFollowQty() == null) ? 0 : getFollowQty().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getDuration() == null) ? 0 : getDuration().hashCode());
        result = prime * result + ((getCreateUid() == null) ? 0 : getCreateUid().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getAppointmentDate() == null) ? 0 : getAppointmentDate().hashCode());
        result = prime * result + ((getMasterAuditStatus() == null) ? 0 : getMasterAuditStatus().hashCode());
        result = prime * result + ((getMasterAuditTime() == null) ? 0 : getMasterAuditTime().hashCode());
        result = prime * result + ((getMasterAuditUid() == null) ? 0 : getMasterAuditUid().hashCode());
        result = prime * result + ((getMasterAuditPhone() == null) ? 0 : getMasterAuditPhone().hashCode());
        result = prime * result + ((getCommunityAuditTime() == null) ? 0 : getCommunityAuditTime().hashCode());
        result = prime * result + ((getCommunityAuditUid() == null) ? 0 : getCommunityAuditUid().hashCode());
        result = prime * result + ((getCommunityAuditStatus() == null) ? 0 : getCommunityAuditStatus().hashCode());
        result = prime * result + ((getVisitorAuditTime() == null) ? 0 : getVisitorAuditTime().hashCode());
        result = prime * result + ((getVisitorAuditUid() == null) ? 0 : getVisitorAuditUid().hashCode());
        result = prime * result + ((getVisitorAuditStatus() == null) ? 0 : getVisitorAuditStatus().hashCode());
        result = prime * result + ((getRenewAuditTime() == null) ? 0 : getRenewAuditTime().hashCode());
        result = prime * result + ((getRenewAuditUid() == null) ? 0 : getRenewAuditUid().hashCode());
        result = prime * result + ((getRenewAuditStatus() == null) ? 0 : getRenewAuditStatus().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getToken() == null) ? 0 : getToken().hashCode());
        return result;
    }
}