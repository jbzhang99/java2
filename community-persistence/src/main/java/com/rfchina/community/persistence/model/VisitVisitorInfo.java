package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class VisitVisitorInfo implements Serializable {
    private Long id;

    private Long aid;

    private String appointment;

    private String appointmentPhone;

    private Long appointmentUid;

    private Integer appointmentReadStatus;

    private Integer isMaster;

    private Date qrcodeCreateTime;

    private Date qrcodeExpireTime;

    private Date qrcodeLastUseTime;

    private Integer qrcodeEntryUseTimes;

    private Integer qrcodeExitUseTimes;

    private Integer qrcodeEntryElapseTimes;

    private Integer qrcodeExitElapseTimes;

    private Integer applyRenewTimes;

    private String qrcodeToken;

    private Date qrcodeTokenTime;

    private String qrcodeTokenIp;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }

    public String getAppointmentPhone() {
        return appointmentPhone;
    }

    public void setAppointmentPhone(String appointmentPhone) {
        this.appointmentPhone = appointmentPhone;
    }

    public Long getAppointmentUid() {
        return appointmentUid;
    }

    public void setAppointmentUid(Long appointmentUid) {
        this.appointmentUid = appointmentUid;
    }

    public Integer getAppointmentReadStatus() {
        return appointmentReadStatus;
    }

    public void setAppointmentReadStatus(Integer appointmentReadStatus) {
        this.appointmentReadStatus = appointmentReadStatus;
    }

    public Integer getIsMaster() {
        return isMaster;
    }

    public void setIsMaster(Integer isMaster) {
        this.isMaster = isMaster;
    }

    public Date getQrcodeCreateTime() {
        return qrcodeCreateTime;
    }

    public void setQrcodeCreateTime(Date qrcodeCreateTime) {
        this.qrcodeCreateTime = qrcodeCreateTime;
    }

    public Date getQrcodeExpireTime() {
        return qrcodeExpireTime;
    }

    public void setQrcodeExpireTime(Date qrcodeExpireTime) {
        this.qrcodeExpireTime = qrcodeExpireTime;
    }

    public Date getQrcodeLastUseTime() {
        return qrcodeLastUseTime;
    }

    public void setQrcodeLastUseTime(Date qrcodeLastUseTime) {
        this.qrcodeLastUseTime = qrcodeLastUseTime;
    }

    public Integer getQrcodeEntryUseTimes() {
        return qrcodeEntryUseTimes;
    }

    public void setQrcodeEntryUseTimes(Integer qrcodeEntryUseTimes) {
        this.qrcodeEntryUseTimes = qrcodeEntryUseTimes;
    }

    public Integer getQrcodeExitUseTimes() {
        return qrcodeExitUseTimes;
    }

    public void setQrcodeExitUseTimes(Integer qrcodeExitUseTimes) {
        this.qrcodeExitUseTimes = qrcodeExitUseTimes;
    }

    public Integer getQrcodeEntryElapseTimes() {
        return qrcodeEntryElapseTimes;
    }

    public void setQrcodeEntryElapseTimes(Integer qrcodeEntryElapseTimes) {
        this.qrcodeEntryElapseTimes = qrcodeEntryElapseTimes;
    }

    public Integer getQrcodeExitElapseTimes() {
        return qrcodeExitElapseTimes;
    }

    public void setQrcodeExitElapseTimes(Integer qrcodeExitElapseTimes) {
        this.qrcodeExitElapseTimes = qrcodeExitElapseTimes;
    }

    public Integer getApplyRenewTimes() {
        return applyRenewTimes;
    }

    public void setApplyRenewTimes(Integer applyRenewTimes) {
        this.applyRenewTimes = applyRenewTimes;
    }

    public String getQrcodeToken() {
        return qrcodeToken;
    }

    public void setQrcodeToken(String qrcodeToken) {
        this.qrcodeToken = qrcodeToken;
    }

    public Date getQrcodeTokenTime() {
        return qrcodeTokenTime;
    }

    public void setQrcodeTokenTime(Date qrcodeTokenTime) {
        this.qrcodeTokenTime = qrcodeTokenTime;
    }

    public String getQrcodeTokenIp() {
        return qrcodeTokenIp;
    }

    public void setQrcodeTokenIp(String qrcodeTokenIp) {
        this.qrcodeTokenIp = qrcodeTokenIp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", aid=").append(aid);
        sb.append(", appointment=").append(appointment);
        sb.append(", appointmentPhone=").append(appointmentPhone);
        sb.append(", appointmentUid=").append(appointmentUid);
        sb.append(", appointmentReadStatus=").append(appointmentReadStatus);
        sb.append(", isMaster=").append(isMaster);
        sb.append(", qrcodeCreateTime=").append(qrcodeCreateTime);
        sb.append(", qrcodeExpireTime=").append(qrcodeExpireTime);
        sb.append(", qrcodeLastUseTime=").append(qrcodeLastUseTime);
        sb.append(", qrcodeEntryUseTimes=").append(qrcodeEntryUseTimes);
        sb.append(", qrcodeExitUseTimes=").append(qrcodeExitUseTimes);
        sb.append(", qrcodeEntryElapseTimes=").append(qrcodeEntryElapseTimes);
        sb.append(", qrcodeExitElapseTimes=").append(qrcodeExitElapseTimes);
        sb.append(", applyRenewTimes=").append(applyRenewTimes);
        sb.append(", qrcodeToken=").append(qrcodeToken);
        sb.append(", qrcodeTokenTime=").append(qrcodeTokenTime);
        sb.append(", qrcodeTokenIp=").append(qrcodeTokenIp);
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
        VisitVisitorInfo other = (VisitVisitorInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAid() == null ? other.getAid() == null : this.getAid().equals(other.getAid()))
            && (this.getAppointment() == null ? other.getAppointment() == null : this.getAppointment().equals(other.getAppointment()))
            && (this.getAppointmentPhone() == null ? other.getAppointmentPhone() == null : this.getAppointmentPhone().equals(other.getAppointmentPhone()))
            && (this.getAppointmentUid() == null ? other.getAppointmentUid() == null : this.getAppointmentUid().equals(other.getAppointmentUid()))
            && (this.getAppointmentReadStatus() == null ? other.getAppointmentReadStatus() == null : this.getAppointmentReadStatus().equals(other.getAppointmentReadStatus()))
            && (this.getIsMaster() == null ? other.getIsMaster() == null : this.getIsMaster().equals(other.getIsMaster()))
            && (this.getQrcodeCreateTime() == null ? other.getQrcodeCreateTime() == null : this.getQrcodeCreateTime().equals(other.getQrcodeCreateTime()))
            && (this.getQrcodeExpireTime() == null ? other.getQrcodeExpireTime() == null : this.getQrcodeExpireTime().equals(other.getQrcodeExpireTime()))
            && (this.getQrcodeLastUseTime() == null ? other.getQrcodeLastUseTime() == null : this.getQrcodeLastUseTime().equals(other.getQrcodeLastUseTime()))
            && (this.getQrcodeEntryUseTimes() == null ? other.getQrcodeEntryUseTimes() == null : this.getQrcodeEntryUseTimes().equals(other.getQrcodeEntryUseTimes()))
            && (this.getQrcodeExitUseTimes() == null ? other.getQrcodeExitUseTimes() == null : this.getQrcodeExitUseTimes().equals(other.getQrcodeExitUseTimes()))
            && (this.getQrcodeEntryElapseTimes() == null ? other.getQrcodeEntryElapseTimes() == null : this.getQrcodeEntryElapseTimes().equals(other.getQrcodeEntryElapseTimes()))
            && (this.getQrcodeExitElapseTimes() == null ? other.getQrcodeExitElapseTimes() == null : this.getQrcodeExitElapseTimes().equals(other.getQrcodeExitElapseTimes()))
            && (this.getApplyRenewTimes() == null ? other.getApplyRenewTimes() == null : this.getApplyRenewTimes().equals(other.getApplyRenewTimes()))
            && (this.getQrcodeToken() == null ? other.getQrcodeToken() == null : this.getQrcodeToken().equals(other.getQrcodeToken()))
            && (this.getQrcodeTokenTime() == null ? other.getQrcodeTokenTime() == null : this.getQrcodeTokenTime().equals(other.getQrcodeTokenTime()))
            && (this.getQrcodeTokenIp() == null ? other.getQrcodeTokenIp() == null : this.getQrcodeTokenIp().equals(other.getQrcodeTokenIp()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAid() == null) ? 0 : getAid().hashCode());
        result = prime * result + ((getAppointment() == null) ? 0 : getAppointment().hashCode());
        result = prime * result + ((getAppointmentPhone() == null) ? 0 : getAppointmentPhone().hashCode());
        result = prime * result + ((getAppointmentUid() == null) ? 0 : getAppointmentUid().hashCode());
        result = prime * result + ((getAppointmentReadStatus() == null) ? 0 : getAppointmentReadStatus().hashCode());
        result = prime * result + ((getIsMaster() == null) ? 0 : getIsMaster().hashCode());
        result = prime * result + ((getQrcodeCreateTime() == null) ? 0 : getQrcodeCreateTime().hashCode());
        result = prime * result + ((getQrcodeExpireTime() == null) ? 0 : getQrcodeExpireTime().hashCode());
        result = prime * result + ((getQrcodeLastUseTime() == null) ? 0 : getQrcodeLastUseTime().hashCode());
        result = prime * result + ((getQrcodeEntryUseTimes() == null) ? 0 : getQrcodeEntryUseTimes().hashCode());
        result = prime * result + ((getQrcodeExitUseTimes() == null) ? 0 : getQrcodeExitUseTimes().hashCode());
        result = prime * result + ((getQrcodeEntryElapseTimes() == null) ? 0 : getQrcodeEntryElapseTimes().hashCode());
        result = prime * result + ((getQrcodeExitElapseTimes() == null) ? 0 : getQrcodeExitElapseTimes().hashCode());
        result = prime * result + ((getApplyRenewTimes() == null) ? 0 : getApplyRenewTimes().hashCode());
        result = prime * result + ((getQrcodeToken() == null) ? 0 : getQrcodeToken().hashCode());
        result = prime * result + ((getQrcodeTokenTime() == null) ? 0 : getQrcodeTokenTime().hashCode());
        result = prime * result + ((getQrcodeTokenIp() == null) ? 0 : getQrcodeTokenIp().hashCode());
        return result;
    }
}