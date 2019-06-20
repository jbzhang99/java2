package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BizApplyOrder implements Serializable {
    private Long id;

    private String tradeNo;

    private String tskCode;

    private Integer communityId;

    private Long masterId;

    private Long masterChildId;

    private Long uid;

    private String contact;

    private String phone;

    private String title;

    private Integer orderType;

    private Integer orderStatus;

    private Integer payStatus;

    private String payType;

    private BigDecimal payPrice;

    private BigDecimal payAmount;

    private Date payTime;

    private String attachment;

    private Date applyTime;

    private Integer applyNum;

    private String applyAddress;

    private String obtainAddress;

    private Date obtainTime;

    private Integer auditStatus;

    private String auditReason;

    private Date auditTime;

    private String validationCode;

    private String issueTskCode;

    private String issueBody;

    private String rfpayBillId;

    private String rfpayTradeNo;

    private String rfpayBody;

    private String rfpayType;

    private Date rfpayCreateTime;

    private Date rfpayCloseTime;

    private String rfpayAccount;

    private BigDecimal rfpayFeeRate;

    private BigDecimal rfpayClearingFee;

    private Long rfpayActualClearingFee;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getTskCode() {
        return tskCode;
    }

    public void setTskCode(String tskCode) {
        this.tskCode = tskCode;
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

    public Long getMasterChildId() {
        return masterChildId;
    }

    public void setMasterChildId(Long masterChildId) {
        this.masterChildId = masterChildId;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public BigDecimal getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Integer getApplyNum() {
        return applyNum;
    }

    public void setApplyNum(Integer applyNum) {
        this.applyNum = applyNum;
    }

    public String getApplyAddress() {
        return applyAddress;
    }

    public void setApplyAddress(String applyAddress) {
        this.applyAddress = applyAddress;
    }

    public String getObtainAddress() {
        return obtainAddress;
    }

    public void setObtainAddress(String obtainAddress) {
        this.obtainAddress = obtainAddress;
    }

    public Date getObtainTime() {
        return obtainTime;
    }

    public void setObtainTime(Date obtainTime) {
        this.obtainTime = obtainTime;
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

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public String getValidationCode() {
        return validationCode;
    }

    public void setValidationCode(String validationCode) {
        this.validationCode = validationCode;
    }

    public String getIssueTskCode() {
        return issueTskCode;
    }

    public void setIssueTskCode(String issueTskCode) {
        this.issueTskCode = issueTskCode;
    }

    public String getIssueBody() {
        return issueBody;
    }

    public void setIssueBody(String issueBody) {
        this.issueBody = issueBody;
    }

    public String getRfpayBillId() {
        return rfpayBillId;
    }

    public void setRfpayBillId(String rfpayBillId) {
        this.rfpayBillId = rfpayBillId;
    }

    public String getRfpayTradeNo() {
        return rfpayTradeNo;
    }

    public void setRfpayTradeNo(String rfpayTradeNo) {
        this.rfpayTradeNo = rfpayTradeNo;
    }

    public String getRfpayBody() {
        return rfpayBody;
    }

    public void setRfpayBody(String rfpayBody) {
        this.rfpayBody = rfpayBody;
    }

    public String getRfpayType() {
        return rfpayType;
    }

    public void setRfpayType(String rfpayType) {
        this.rfpayType = rfpayType;
    }

    public Date getRfpayCreateTime() {
        return rfpayCreateTime;
    }

    public void setRfpayCreateTime(Date rfpayCreateTime) {
        this.rfpayCreateTime = rfpayCreateTime;
    }

    public Date getRfpayCloseTime() {
        return rfpayCloseTime;
    }

    public void setRfpayCloseTime(Date rfpayCloseTime) {
        this.rfpayCloseTime = rfpayCloseTime;
    }

    public String getRfpayAccount() {
        return rfpayAccount;
    }

    public void setRfpayAccount(String rfpayAccount) {
        this.rfpayAccount = rfpayAccount;
    }

    public BigDecimal getRfpayFeeRate() {
        return rfpayFeeRate;
    }

    public void setRfpayFeeRate(BigDecimal rfpayFeeRate) {
        this.rfpayFeeRate = rfpayFeeRate;
    }

    public BigDecimal getRfpayClearingFee() {
        return rfpayClearingFee;
    }

    public void setRfpayClearingFee(BigDecimal rfpayClearingFee) {
        this.rfpayClearingFee = rfpayClearingFee;
    }

    public Long getRfpayActualClearingFee() {
        return rfpayActualClearingFee;
    }

    public void setRfpayActualClearingFee(Long rfpayActualClearingFee) {
        this.rfpayActualClearingFee = rfpayActualClearingFee;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tradeNo=").append(tradeNo);
        sb.append(", tskCode=").append(tskCode);
        sb.append(", communityId=").append(communityId);
        sb.append(", masterId=").append(masterId);
        sb.append(", masterChildId=").append(masterChildId);
        sb.append(", uid=").append(uid);
        sb.append(", contact=").append(contact);
        sb.append(", phone=").append(phone);
        sb.append(", title=").append(title);
        sb.append(", orderType=").append(orderType);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", payStatus=").append(payStatus);
        sb.append(", payType=").append(payType);
        sb.append(", payPrice=").append(payPrice);
        sb.append(", payAmount=").append(payAmount);
        sb.append(", payTime=").append(payTime);
        sb.append(", attachment=").append(attachment);
        sb.append(", applyTime=").append(applyTime);
        sb.append(", applyNum=").append(applyNum);
        sb.append(", applyAddress=").append(applyAddress);
        sb.append(", obtainAddress=").append(obtainAddress);
        sb.append(", obtainTime=").append(obtainTime);
        sb.append(", auditStatus=").append(auditStatus);
        sb.append(", auditReason=").append(auditReason);
        sb.append(", auditTime=").append(auditTime);
        sb.append(", validationCode=").append(validationCode);
        sb.append(", issueTskCode=").append(issueTskCode);
        sb.append(", issueBody=").append(issueBody);
        sb.append(", rfpayBillId=").append(rfpayBillId);
        sb.append(", rfpayTradeNo=").append(rfpayTradeNo);
        sb.append(", rfpayBody=").append(rfpayBody);
        sb.append(", rfpayType=").append(rfpayType);
        sb.append(", rfpayCreateTime=").append(rfpayCreateTime);
        sb.append(", rfpayCloseTime=").append(rfpayCloseTime);
        sb.append(", rfpayAccount=").append(rfpayAccount);
        sb.append(", rfpayFeeRate=").append(rfpayFeeRate);
        sb.append(", rfpayClearingFee=").append(rfpayClearingFee);
        sb.append(", rfpayActualClearingFee=").append(rfpayActualClearingFee);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
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
        BizApplyOrder other = (BizApplyOrder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTradeNo() == null ? other.getTradeNo() == null : this.getTradeNo().equals(other.getTradeNo()))
            && (this.getTskCode() == null ? other.getTskCode() == null : this.getTskCode().equals(other.getTskCode()))
            && (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getMasterId() == null ? other.getMasterId() == null : this.getMasterId().equals(other.getMasterId()))
            && (this.getMasterChildId() == null ? other.getMasterChildId() == null : this.getMasterChildId().equals(other.getMasterChildId()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getContact() == null ? other.getContact() == null : this.getContact().equals(other.getContact()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getOrderType() == null ? other.getOrderType() == null : this.getOrderType().equals(other.getOrderType()))
            && (this.getOrderStatus() == null ? other.getOrderStatus() == null : this.getOrderStatus().equals(other.getOrderStatus()))
            && (this.getPayStatus() == null ? other.getPayStatus() == null : this.getPayStatus().equals(other.getPayStatus()))
            && (this.getPayType() == null ? other.getPayType() == null : this.getPayType().equals(other.getPayType()))
            && (this.getPayPrice() == null ? other.getPayPrice() == null : this.getPayPrice().equals(other.getPayPrice()))
            && (this.getPayAmount() == null ? other.getPayAmount() == null : this.getPayAmount().equals(other.getPayAmount()))
            && (this.getPayTime() == null ? other.getPayTime() == null : this.getPayTime().equals(other.getPayTime()))
            && (this.getAttachment() == null ? other.getAttachment() == null : this.getAttachment().equals(other.getAttachment()))
            && (this.getApplyTime() == null ? other.getApplyTime() == null : this.getApplyTime().equals(other.getApplyTime()))
            && (this.getApplyNum() == null ? other.getApplyNum() == null : this.getApplyNum().equals(other.getApplyNum()))
            && (this.getApplyAddress() == null ? other.getApplyAddress() == null : this.getApplyAddress().equals(other.getApplyAddress()))
            && (this.getObtainAddress() == null ? other.getObtainAddress() == null : this.getObtainAddress().equals(other.getObtainAddress()))
            && (this.getObtainTime() == null ? other.getObtainTime() == null : this.getObtainTime().equals(other.getObtainTime()))
            && (this.getAuditStatus() == null ? other.getAuditStatus() == null : this.getAuditStatus().equals(other.getAuditStatus()))
            && (this.getAuditReason() == null ? other.getAuditReason() == null : this.getAuditReason().equals(other.getAuditReason()))
            && (this.getAuditTime() == null ? other.getAuditTime() == null : this.getAuditTime().equals(other.getAuditTime()))
            && (this.getValidationCode() == null ? other.getValidationCode() == null : this.getValidationCode().equals(other.getValidationCode()))
            && (this.getIssueTskCode() == null ? other.getIssueTskCode() == null : this.getIssueTskCode().equals(other.getIssueTskCode()))
            && (this.getIssueBody() == null ? other.getIssueBody() == null : this.getIssueBody().equals(other.getIssueBody()))
            && (this.getRfpayBillId() == null ? other.getRfpayBillId() == null : this.getRfpayBillId().equals(other.getRfpayBillId()))
            && (this.getRfpayTradeNo() == null ? other.getRfpayTradeNo() == null : this.getRfpayTradeNo().equals(other.getRfpayTradeNo()))
            && (this.getRfpayBody() == null ? other.getRfpayBody() == null : this.getRfpayBody().equals(other.getRfpayBody()))
            && (this.getRfpayType() == null ? other.getRfpayType() == null : this.getRfpayType().equals(other.getRfpayType()))
            && (this.getRfpayCreateTime() == null ? other.getRfpayCreateTime() == null : this.getRfpayCreateTime().equals(other.getRfpayCreateTime()))
            && (this.getRfpayCloseTime() == null ? other.getRfpayCloseTime() == null : this.getRfpayCloseTime().equals(other.getRfpayCloseTime()))
            && (this.getRfpayAccount() == null ? other.getRfpayAccount() == null : this.getRfpayAccount().equals(other.getRfpayAccount()))
            && (this.getRfpayFeeRate() == null ? other.getRfpayFeeRate() == null : this.getRfpayFeeRate().equals(other.getRfpayFeeRate()))
            && (this.getRfpayClearingFee() == null ? other.getRfpayClearingFee() == null : this.getRfpayClearingFee().equals(other.getRfpayClearingFee()))
            && (this.getRfpayActualClearingFee() == null ? other.getRfpayActualClearingFee() == null : this.getRfpayActualClearingFee().equals(other.getRfpayActualClearingFee()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTradeNo() == null) ? 0 : getTradeNo().hashCode());
        result = prime * result + ((getTskCode() == null) ? 0 : getTskCode().hashCode());
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getMasterId() == null) ? 0 : getMasterId().hashCode());
        result = prime * result + ((getMasterChildId() == null) ? 0 : getMasterChildId().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getContact() == null) ? 0 : getContact().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getOrderType() == null) ? 0 : getOrderType().hashCode());
        result = prime * result + ((getOrderStatus() == null) ? 0 : getOrderStatus().hashCode());
        result = prime * result + ((getPayStatus() == null) ? 0 : getPayStatus().hashCode());
        result = prime * result + ((getPayType() == null) ? 0 : getPayType().hashCode());
        result = prime * result + ((getPayPrice() == null) ? 0 : getPayPrice().hashCode());
        result = prime * result + ((getPayAmount() == null) ? 0 : getPayAmount().hashCode());
        result = prime * result + ((getPayTime() == null) ? 0 : getPayTime().hashCode());
        result = prime * result + ((getAttachment() == null) ? 0 : getAttachment().hashCode());
        result = prime * result + ((getApplyTime() == null) ? 0 : getApplyTime().hashCode());
        result = prime * result + ((getApplyNum() == null) ? 0 : getApplyNum().hashCode());
        result = prime * result + ((getApplyAddress() == null) ? 0 : getApplyAddress().hashCode());
        result = prime * result + ((getObtainAddress() == null) ? 0 : getObtainAddress().hashCode());
        result = prime * result + ((getObtainTime() == null) ? 0 : getObtainTime().hashCode());
        result = prime * result + ((getAuditStatus() == null) ? 0 : getAuditStatus().hashCode());
        result = prime * result + ((getAuditReason() == null) ? 0 : getAuditReason().hashCode());
        result = prime * result + ((getAuditTime() == null) ? 0 : getAuditTime().hashCode());
        result = prime * result + ((getValidationCode() == null) ? 0 : getValidationCode().hashCode());
        result = prime * result + ((getIssueTskCode() == null) ? 0 : getIssueTskCode().hashCode());
        result = prime * result + ((getIssueBody() == null) ? 0 : getIssueBody().hashCode());
        result = prime * result + ((getRfpayBillId() == null) ? 0 : getRfpayBillId().hashCode());
        result = prime * result + ((getRfpayTradeNo() == null) ? 0 : getRfpayTradeNo().hashCode());
        result = prime * result + ((getRfpayBody() == null) ? 0 : getRfpayBody().hashCode());
        result = prime * result + ((getRfpayType() == null) ? 0 : getRfpayType().hashCode());
        result = prime * result + ((getRfpayCreateTime() == null) ? 0 : getRfpayCreateTime().hashCode());
        result = prime * result + ((getRfpayCloseTime() == null) ? 0 : getRfpayCloseTime().hashCode());
        result = prime * result + ((getRfpayAccount() == null) ? 0 : getRfpayAccount().hashCode());
        result = prime * result + ((getRfpayFeeRate() == null) ? 0 : getRfpayFeeRate().hashCode());
        result = prime * result + ((getRfpayClearingFee() == null) ? 0 : getRfpayClearingFee().hashCode());
        result = prime * result + ((getRfpayActualClearingFee() == null) ? 0 : getRfpayActualClearingFee().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}