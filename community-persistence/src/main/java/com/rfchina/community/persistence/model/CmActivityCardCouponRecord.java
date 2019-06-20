package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class CmActivityCardCouponRecord implements Serializable {
    private Long id;

    private Long activityId;

    private Long cardCouponId;

    private Long couponId;

    private String couponSn;

    private Long uid;

    private Date validFromDate;

    private Date validToDate;

    private Integer couponType;

    private Integer itemType;

    private Integer useChannel;

    private Integer source;

    private Integer confirmStatus;

    private String remark;

    private String confirmCode;

    private Date confirmTime;

    private Long confirmUid;

    private String idcardNo;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private String operatorName;

    private String operatorPhone;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Long getCardCouponId() {
        return cardCouponId;
    }

    public void setCardCouponId(Long cardCouponId) {
        this.cardCouponId = cardCouponId;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public String getCouponSn() {
        return couponSn;
    }

    public void setCouponSn(String couponSn) {
        this.couponSn = couponSn;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Date getValidFromDate() {
        return validFromDate;
    }

    public void setValidFromDate(Date validFromDate) {
        this.validFromDate = validFromDate;
    }

    public Date getValidToDate() {
        return validToDate;
    }

    public void setValidToDate(Date validToDate) {
        this.validToDate = validToDate;
    }

    public Integer getCouponType() {
        return couponType;
    }

    public void setCouponType(Integer couponType) {
        this.couponType = couponType;
    }

    public Integer getItemType() {
        return itemType;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }

    public Integer getUseChannel() {
        return useChannel;
    }

    public void setUseChannel(Integer useChannel) {
        this.useChannel = useChannel;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getConfirmStatus() {
        return confirmStatus;
    }

    public void setConfirmStatus(Integer confirmStatus) {
        this.confirmStatus = confirmStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getConfirmCode() {
        return confirmCode;
    }

    public void setConfirmCode(String confirmCode) {
        this.confirmCode = confirmCode;
    }

    public Date getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }

    public Long getConfirmUid() {
        return confirmUid;
    }

    public void setConfirmUid(Long confirmUid) {
        this.confirmUid = confirmUid;
    }

    public String getIdcardNo() {
        return idcardNo;
    }

    public void setIdcardNo(String idcardNo) {
        this.idcardNo = idcardNo;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOperatorPhone() {
        return operatorPhone;
    }

    public void setOperatorPhone(String operatorPhone) {
        this.operatorPhone = operatorPhone;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", activityId=").append(activityId);
        sb.append(", cardCouponId=").append(cardCouponId);
        sb.append(", couponId=").append(couponId);
        sb.append(", couponSn=").append(couponSn);
        sb.append(", uid=").append(uid);
        sb.append(", validFromDate=").append(validFromDate);
        sb.append(", validToDate=").append(validToDate);
        sb.append(", couponType=").append(couponType);
        sb.append(", itemType=").append(itemType);
        sb.append(", useChannel=").append(useChannel);
        sb.append(", source=").append(source);
        sb.append(", confirmStatus=").append(confirmStatus);
        sb.append(", remark=").append(remark);
        sb.append(", confirmCode=").append(confirmCode);
        sb.append(", confirmTime=").append(confirmTime);
        sb.append(", confirmUid=").append(confirmUid);
        sb.append(", idcardNo=").append(idcardNo);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", operatorName=").append(operatorName);
        sb.append(", operatorPhone=").append(operatorPhone);
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
        CmActivityCardCouponRecord other = (CmActivityCardCouponRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getActivityId() == null ? other.getActivityId() == null : this.getActivityId().equals(other.getActivityId()))
            && (this.getCardCouponId() == null ? other.getCardCouponId() == null : this.getCardCouponId().equals(other.getCardCouponId()))
            && (this.getCouponId() == null ? other.getCouponId() == null : this.getCouponId().equals(other.getCouponId()))
            && (this.getCouponSn() == null ? other.getCouponSn() == null : this.getCouponSn().equals(other.getCouponSn()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getValidFromDate() == null ? other.getValidFromDate() == null : this.getValidFromDate().equals(other.getValidFromDate()))
            && (this.getValidToDate() == null ? other.getValidToDate() == null : this.getValidToDate().equals(other.getValidToDate()))
            && (this.getCouponType() == null ? other.getCouponType() == null : this.getCouponType().equals(other.getCouponType()))
            && (this.getItemType() == null ? other.getItemType() == null : this.getItemType().equals(other.getItemType()))
            && (this.getUseChannel() == null ? other.getUseChannel() == null : this.getUseChannel().equals(other.getUseChannel()))
            && (this.getSource() == null ? other.getSource() == null : this.getSource().equals(other.getSource()))
            && (this.getConfirmStatus() == null ? other.getConfirmStatus() == null : this.getConfirmStatus().equals(other.getConfirmStatus()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getConfirmCode() == null ? other.getConfirmCode() == null : this.getConfirmCode().equals(other.getConfirmCode()))
            && (this.getConfirmTime() == null ? other.getConfirmTime() == null : this.getConfirmTime().equals(other.getConfirmTime()))
            && (this.getConfirmUid() == null ? other.getConfirmUid() == null : this.getConfirmUid().equals(other.getConfirmUid()))
            && (this.getIdcardNo() == null ? other.getIdcardNo() == null : this.getIdcardNo().equals(other.getIdcardNo()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getOperatorName() == null ? other.getOperatorName() == null : this.getOperatorName().equals(other.getOperatorName()))
            && (this.getOperatorPhone() == null ? other.getOperatorPhone() == null : this.getOperatorPhone().equals(other.getOperatorPhone()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getActivityId() == null) ? 0 : getActivityId().hashCode());
        result = prime * result + ((getCardCouponId() == null) ? 0 : getCardCouponId().hashCode());
        result = prime * result + ((getCouponId() == null) ? 0 : getCouponId().hashCode());
        result = prime * result + ((getCouponSn() == null) ? 0 : getCouponSn().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getValidFromDate() == null) ? 0 : getValidFromDate().hashCode());
        result = prime * result + ((getValidToDate() == null) ? 0 : getValidToDate().hashCode());
        result = prime * result + ((getCouponType() == null) ? 0 : getCouponType().hashCode());
        result = prime * result + ((getItemType() == null) ? 0 : getItemType().hashCode());
        result = prime * result + ((getUseChannel() == null) ? 0 : getUseChannel().hashCode());
        result = prime * result + ((getSource() == null) ? 0 : getSource().hashCode());
        result = prime * result + ((getConfirmStatus() == null) ? 0 : getConfirmStatus().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getConfirmCode() == null) ? 0 : getConfirmCode().hashCode());
        result = prime * result + ((getConfirmTime() == null) ? 0 : getConfirmTime().hashCode());
        result = prime * result + ((getConfirmUid() == null) ? 0 : getConfirmUid().hashCode());
        result = prime * result + ((getIdcardNo() == null) ? 0 : getIdcardNo().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getOperatorName() == null) ? 0 : getOperatorName().hashCode());
        result = prime * result + ((getOperatorPhone() == null) ? 0 : getOperatorPhone().hashCode());
        return result;
    }
}