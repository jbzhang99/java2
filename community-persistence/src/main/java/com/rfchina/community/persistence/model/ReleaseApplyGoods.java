package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class ReleaseApplyGoods implements Serializable {
    private Integer id;

    private String applicantName;

    private String applicantPhone;

    private String carrierName;

    private String carrierPhone;

    private Date releaseEndTime;

    private Date releaseStartTime;

    private Date createTime;

    private Integer status;

    private Date auditTime;

    private Long auditUid;

    private String auditContent;

    private Long createUid;

    private Integer communityId;

    private Long masterId;

    private String exePhone;

    private String goodsJson;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getApplicantPhone() {
        return applicantPhone;
    }

    public void setApplicantPhone(String applicantPhone) {
        this.applicantPhone = applicantPhone;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public String getCarrierPhone() {
        return carrierPhone;
    }

    public void setCarrierPhone(String carrierPhone) {
        this.carrierPhone = carrierPhone;
    }

    public Date getReleaseEndTime() {
        return releaseEndTime;
    }

    public void setReleaseEndTime(Date releaseEndTime) {
        this.releaseEndTime = releaseEndTime;
    }

    public Date getReleaseStartTime() {
        return releaseStartTime;
    }

    public void setReleaseStartTime(Date releaseStartTime) {
        this.releaseStartTime = releaseStartTime;
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

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Long getAuditUid() {
        return auditUid;
    }

    public void setAuditUid(Long auditUid) {
        this.auditUid = auditUid;
    }

    public String getAuditContent() {
        return auditContent;
    }

    public void setAuditContent(String auditContent) {
        this.auditContent = auditContent;
    }

    public Long getCreateUid() {
        return createUid;
    }

    public void setCreateUid(Long createUid) {
        this.createUid = createUid;
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

    public String getExePhone() {
        return exePhone;
    }

    public void setExePhone(String exePhone) {
        this.exePhone = exePhone;
    }

    public String getGoodsJson() {
        return goodsJson;
    }

    public void setGoodsJson(String goodsJson) {
        this.goodsJson = goodsJson;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", applicantName=").append(applicantName);
        sb.append(", applicantPhone=").append(applicantPhone);
        sb.append(", carrierName=").append(carrierName);
        sb.append(", carrierPhone=").append(carrierPhone);
        sb.append(", releaseEndTime=").append(releaseEndTime);
        sb.append(", releaseStartTime=").append(releaseStartTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", status=").append(status);
        sb.append(", auditTime=").append(auditTime);
        sb.append(", auditUid=").append(auditUid);
        sb.append(", auditContent=").append(auditContent);
        sb.append(", createUid=").append(createUid);
        sb.append(", communityId=").append(communityId);
        sb.append(", masterId=").append(masterId);
        sb.append(", exePhone=").append(exePhone);
        sb.append(", goodsJson=").append(goodsJson);
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
        ReleaseApplyGoods other = (ReleaseApplyGoods) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getApplicantName() == null ? other.getApplicantName() == null : this.getApplicantName().equals(other.getApplicantName()))
            && (this.getApplicantPhone() == null ? other.getApplicantPhone() == null : this.getApplicantPhone().equals(other.getApplicantPhone()))
            && (this.getCarrierName() == null ? other.getCarrierName() == null : this.getCarrierName().equals(other.getCarrierName()))
            && (this.getCarrierPhone() == null ? other.getCarrierPhone() == null : this.getCarrierPhone().equals(other.getCarrierPhone()))
            && (this.getReleaseEndTime() == null ? other.getReleaseEndTime() == null : this.getReleaseEndTime().equals(other.getReleaseEndTime()))
            && (this.getReleaseStartTime() == null ? other.getReleaseStartTime() == null : this.getReleaseStartTime().equals(other.getReleaseStartTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getAuditTime() == null ? other.getAuditTime() == null : this.getAuditTime().equals(other.getAuditTime()))
            && (this.getAuditUid() == null ? other.getAuditUid() == null : this.getAuditUid().equals(other.getAuditUid()))
            && (this.getAuditContent() == null ? other.getAuditContent() == null : this.getAuditContent().equals(other.getAuditContent()))
            && (this.getCreateUid() == null ? other.getCreateUid() == null : this.getCreateUid().equals(other.getCreateUid()))
            && (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getMasterId() == null ? other.getMasterId() == null : this.getMasterId().equals(other.getMasterId()))
            && (this.getExePhone() == null ? other.getExePhone() == null : this.getExePhone().equals(other.getExePhone()))
            && (this.getGoodsJson() == null ? other.getGoodsJson() == null : this.getGoodsJson().equals(other.getGoodsJson()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getApplicantName() == null) ? 0 : getApplicantName().hashCode());
        result = prime * result + ((getApplicantPhone() == null) ? 0 : getApplicantPhone().hashCode());
        result = prime * result + ((getCarrierName() == null) ? 0 : getCarrierName().hashCode());
        result = prime * result + ((getCarrierPhone() == null) ? 0 : getCarrierPhone().hashCode());
        result = prime * result + ((getReleaseEndTime() == null) ? 0 : getReleaseEndTime().hashCode());
        result = prime * result + ((getReleaseStartTime() == null) ? 0 : getReleaseStartTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAuditTime() == null) ? 0 : getAuditTime().hashCode());
        result = prime * result + ((getAuditUid() == null) ? 0 : getAuditUid().hashCode());
        result = prime * result + ((getAuditContent() == null) ? 0 : getAuditContent().hashCode());
        result = prime * result + ((getCreateUid() == null) ? 0 : getCreateUid().hashCode());
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getMasterId() == null) ? 0 : getMasterId().hashCode());
        result = prime * result + ((getExePhone() == null) ? 0 : getExePhone().hashCode());
        result = prime * result + ((getGoodsJson() == null) ? 0 : getGoodsJson().hashCode());
        return result;
    }
}