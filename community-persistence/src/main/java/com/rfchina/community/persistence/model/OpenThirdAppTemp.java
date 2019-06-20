package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OpenThirdAppTemp implements Serializable {
    private Long appId;

    private String name;

    private String url;

    private String description;

    private String icon;

    private Integer status;

    private String auditComment;

    private Date createTime;

    private Date updateTime;

    private Date auditTime;

    private Long categoryId;

    private Integer isNeedHardware;

    private BigDecimal targetMonthTurnover;

    private BigDecimal paidCautionMoney;

    private Integer cautionMoneyStatus;

    private Integer groundMode;

    private Long merchantId;

    private String accountId;

    private Date submitAuditTime;

    private static final long serialVersionUID = 1L;

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAuditComment() {
        return auditComment;
    }

    public void setAuditComment(String auditComment) {
        this.auditComment = auditComment;
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

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getIsNeedHardware() {
        return isNeedHardware;
    }

    public void setIsNeedHardware(Integer isNeedHardware) {
        this.isNeedHardware = isNeedHardware;
    }

    public BigDecimal getTargetMonthTurnover() {
        return targetMonthTurnover;
    }

    public void setTargetMonthTurnover(BigDecimal targetMonthTurnover) {
        this.targetMonthTurnover = targetMonthTurnover;
    }

    public BigDecimal getPaidCautionMoney() {
        return paidCautionMoney;
    }

    public void setPaidCautionMoney(BigDecimal paidCautionMoney) {
        this.paidCautionMoney = paidCautionMoney;
    }

    public Integer getCautionMoneyStatus() {
        return cautionMoneyStatus;
    }

    public void setCautionMoneyStatus(Integer cautionMoneyStatus) {
        this.cautionMoneyStatus = cautionMoneyStatus;
    }

    public Integer getGroundMode() {
        return groundMode;
    }

    public void setGroundMode(Integer groundMode) {
        this.groundMode = groundMode;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Date getSubmitAuditTime() {
        return submitAuditTime;
    }

    public void setSubmitAuditTime(Date submitAuditTime) {
        this.submitAuditTime = submitAuditTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", appId=").append(appId);
        sb.append(", name=").append(name);
        sb.append(", url=").append(url);
        sb.append(", description=").append(description);
        sb.append(", icon=").append(icon);
        sb.append(", status=").append(status);
        sb.append(", auditComment=").append(auditComment);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", auditTime=").append(auditTime);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", isNeedHardware=").append(isNeedHardware);
        sb.append(", targetMonthTurnover=").append(targetMonthTurnover);
        sb.append(", paidCautionMoney=").append(paidCautionMoney);
        sb.append(", cautionMoneyStatus=").append(cautionMoneyStatus);
        sb.append(", groundMode=").append(groundMode);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", accountId=").append(accountId);
        sb.append(", submitAuditTime=").append(submitAuditTime);
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
        OpenThirdAppTemp other = (OpenThirdAppTemp) that;
        return (this.getAppId() == null ? other.getAppId() == null : this.getAppId().equals(other.getAppId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getIcon() == null ? other.getIcon() == null : this.getIcon().equals(other.getIcon()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getAuditComment() == null ? other.getAuditComment() == null : this.getAuditComment().equals(other.getAuditComment()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getAuditTime() == null ? other.getAuditTime() == null : this.getAuditTime().equals(other.getAuditTime()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getIsNeedHardware() == null ? other.getIsNeedHardware() == null : this.getIsNeedHardware().equals(other.getIsNeedHardware()))
            && (this.getTargetMonthTurnover() == null ? other.getTargetMonthTurnover() == null : this.getTargetMonthTurnover().equals(other.getTargetMonthTurnover()))
            && (this.getPaidCautionMoney() == null ? other.getPaidCautionMoney() == null : this.getPaidCautionMoney().equals(other.getPaidCautionMoney()))
            && (this.getCautionMoneyStatus() == null ? other.getCautionMoneyStatus() == null : this.getCautionMoneyStatus().equals(other.getCautionMoneyStatus()))
            && (this.getGroundMode() == null ? other.getGroundMode() == null : this.getGroundMode().equals(other.getGroundMode()))
            && (this.getMerchantId() == null ? other.getMerchantId() == null : this.getMerchantId().equals(other.getMerchantId()))
            && (this.getAccountId() == null ? other.getAccountId() == null : this.getAccountId().equals(other.getAccountId()))
            && (this.getSubmitAuditTime() == null ? other.getSubmitAuditTime() == null : this.getSubmitAuditTime().equals(other.getSubmitAuditTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAppId() == null) ? 0 : getAppId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getIcon() == null) ? 0 : getIcon().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAuditComment() == null) ? 0 : getAuditComment().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getAuditTime() == null) ? 0 : getAuditTime().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getIsNeedHardware() == null) ? 0 : getIsNeedHardware().hashCode());
        result = prime * result + ((getTargetMonthTurnover() == null) ? 0 : getTargetMonthTurnover().hashCode());
        result = prime * result + ((getPaidCautionMoney() == null) ? 0 : getPaidCautionMoney().hashCode());
        result = prime * result + ((getCautionMoneyStatus() == null) ? 0 : getCautionMoneyStatus().hashCode());
        result = prime * result + ((getGroundMode() == null) ? 0 : getGroundMode().hashCode());
        result = prime * result + ((getMerchantId() == null) ? 0 : getMerchantId().hashCode());
        result = prime * result + ((getAccountId() == null) ? 0 : getAccountId().hashCode());
        result = prime * result + ((getSubmitAuditTime() == null) ? 0 : getSubmitAuditTime().hashCode());
        return result;
    }
}