package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OpenSettlementApply implements Serializable {
    private Integer id;

    private Integer serviceId;

    private String settlementId;

    private BigDecimal orderAmountCount;

    private BigDecimal platformPoundageAmount;

    private BigDecimal platformCommissionAmount;

    private BigDecimal platformThinkAmount;

    private BigDecimal settlementAmountCount;

    private BigDecimal paidSettlementAmount;

    private BigDecimal refundMoney;

    private Integer status;

    private Date createTime;

    private Date auditTime;

    private Integer orderCount;

    private String invoiceTitle;

    private String contactsName;

    private String contactsPhone;

    private String mailingAddress;

    private Integer invoiceStatus;

    private Date settlementStartTime;

    private Date settlementEndTime;

    private String auditComment;

    private Long merchantId;

    private Integer invoiceType;

    private String companyName;

    private String taxpayerCode;

    private String companyAddress;

    private String companyPhone;

    private String bankName;

    private String bankAccount;

    private Integer type;

    private Integer communityId;

    private String platformSettlementId;

    private String mchId;

    private String accountId;

    private String title;

    private Integer pfStatus;

    private String auditPhone;

    private String auditName;

    private Date settleSuccessTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getSettlementId() {
        return settlementId;
    }

    public void setSettlementId(String settlementId) {
        this.settlementId = settlementId;
    }

    public BigDecimal getOrderAmountCount() {
        return orderAmountCount;
    }

    public void setOrderAmountCount(BigDecimal orderAmountCount) {
        this.orderAmountCount = orderAmountCount;
    }

    public BigDecimal getPlatformPoundageAmount() {
        return platformPoundageAmount;
    }

    public void setPlatformPoundageAmount(BigDecimal platformPoundageAmount) {
        this.platformPoundageAmount = platformPoundageAmount;
    }

    public BigDecimal getPlatformCommissionAmount() {
        return platformCommissionAmount;
    }

    public void setPlatformCommissionAmount(BigDecimal platformCommissionAmount) {
        this.platformCommissionAmount = platformCommissionAmount;
    }

    public BigDecimal getPlatformThinkAmount() {
        return platformThinkAmount;
    }

    public void setPlatformThinkAmount(BigDecimal platformThinkAmount) {
        this.platformThinkAmount = platformThinkAmount;
    }

    public BigDecimal getSettlementAmountCount() {
        return settlementAmountCount;
    }

    public void setSettlementAmountCount(BigDecimal settlementAmountCount) {
        this.settlementAmountCount = settlementAmountCount;
    }

    public BigDecimal getPaidSettlementAmount() {
        return paidSettlementAmount;
    }

    public void setPaidSettlementAmount(BigDecimal paidSettlementAmount) {
        this.paidSettlementAmount = paidSettlementAmount;
    }

    public BigDecimal getRefundMoney() {
        return refundMoney;
    }

    public void setRefundMoney(BigDecimal refundMoney) {
        this.refundMoney = refundMoney;
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

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }

    public String getContactsName() {
        return contactsName;
    }

    public void setContactsName(String contactsName) {
        this.contactsName = contactsName;
    }

    public String getContactsPhone() {
        return contactsPhone;
    }

    public void setContactsPhone(String contactsPhone) {
        this.contactsPhone = contactsPhone;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public Integer getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(Integer invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public Date getSettlementStartTime() {
        return settlementStartTime;
    }

    public void setSettlementStartTime(Date settlementStartTime) {
        this.settlementStartTime = settlementStartTime;
    }

    public Date getSettlementEndTime() {
        return settlementEndTime;
    }

    public void setSettlementEndTime(Date settlementEndTime) {
        this.settlementEndTime = settlementEndTime;
    }

    public String getAuditComment() {
        return auditComment;
    }

    public void setAuditComment(String auditComment) {
        this.auditComment = auditComment;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTaxpayerCode() {
        return taxpayerCode;
    }

    public void setTaxpayerCode(String taxpayerCode) {
        this.taxpayerCode = taxpayerCode;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public String getPlatformSettlementId() {
        return platformSettlementId;
    }

    public void setPlatformSettlementId(String platformSettlementId) {
        this.platformSettlementId = platformSettlementId;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPfStatus() {
        return pfStatus;
    }

    public void setPfStatus(Integer pfStatus) {
        this.pfStatus = pfStatus;
    }

    public String getAuditPhone() {
        return auditPhone;
    }

    public void setAuditPhone(String auditPhone) {
        this.auditPhone = auditPhone;
    }

    public String getAuditName() {
        return auditName;
    }

    public void setAuditName(String auditName) {
        this.auditName = auditName;
    }

    public Date getSettleSuccessTime() {
        return settleSuccessTime;
    }

    public void setSettleSuccessTime(Date settleSuccessTime) {
        this.settleSuccessTime = settleSuccessTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", serviceId=").append(serviceId);
        sb.append(", settlementId=").append(settlementId);
        sb.append(", orderAmountCount=").append(orderAmountCount);
        sb.append(", platformPoundageAmount=").append(platformPoundageAmount);
        sb.append(", platformCommissionAmount=").append(platformCommissionAmount);
        sb.append(", platformThinkAmount=").append(platformThinkAmount);
        sb.append(", settlementAmountCount=").append(settlementAmountCount);
        sb.append(", paidSettlementAmount=").append(paidSettlementAmount);
        sb.append(", refundMoney=").append(refundMoney);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", auditTime=").append(auditTime);
        sb.append(", orderCount=").append(orderCount);
        sb.append(", invoiceTitle=").append(invoiceTitle);
        sb.append(", contactsName=").append(contactsName);
        sb.append(", contactsPhone=").append(contactsPhone);
        sb.append(", mailingAddress=").append(mailingAddress);
        sb.append(", invoiceStatus=").append(invoiceStatus);
        sb.append(", settlementStartTime=").append(settlementStartTime);
        sb.append(", settlementEndTime=").append(settlementEndTime);
        sb.append(", auditComment=").append(auditComment);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", invoiceType=").append(invoiceType);
        sb.append(", companyName=").append(companyName);
        sb.append(", taxpayerCode=").append(taxpayerCode);
        sb.append(", companyAddress=").append(companyAddress);
        sb.append(", companyPhone=").append(companyPhone);
        sb.append(", bankName=").append(bankName);
        sb.append(", bankAccount=").append(bankAccount);
        sb.append(", type=").append(type);
        sb.append(", communityId=").append(communityId);
        sb.append(", platformSettlementId=").append(platformSettlementId);
        sb.append(", mchId=").append(mchId);
        sb.append(", accountId=").append(accountId);
        sb.append(", title=").append(title);
        sb.append(", pfStatus=").append(pfStatus);
        sb.append(", auditPhone=").append(auditPhone);
        sb.append(", auditName=").append(auditName);
        sb.append(", settleSuccessTime=").append(settleSuccessTime);
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
        OpenSettlementApply other = (OpenSettlementApply) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getServiceId() == null ? other.getServiceId() == null : this.getServiceId().equals(other.getServiceId()))
            && (this.getSettlementId() == null ? other.getSettlementId() == null : this.getSettlementId().equals(other.getSettlementId()))
            && (this.getOrderAmountCount() == null ? other.getOrderAmountCount() == null : this.getOrderAmountCount().equals(other.getOrderAmountCount()))
            && (this.getPlatformPoundageAmount() == null ? other.getPlatformPoundageAmount() == null : this.getPlatformPoundageAmount().equals(other.getPlatformPoundageAmount()))
            && (this.getPlatformCommissionAmount() == null ? other.getPlatformCommissionAmount() == null : this.getPlatformCommissionAmount().equals(other.getPlatformCommissionAmount()))
            && (this.getPlatformThinkAmount() == null ? other.getPlatformThinkAmount() == null : this.getPlatformThinkAmount().equals(other.getPlatformThinkAmount()))
            && (this.getSettlementAmountCount() == null ? other.getSettlementAmountCount() == null : this.getSettlementAmountCount().equals(other.getSettlementAmountCount()))
            && (this.getPaidSettlementAmount() == null ? other.getPaidSettlementAmount() == null : this.getPaidSettlementAmount().equals(other.getPaidSettlementAmount()))
            && (this.getRefundMoney() == null ? other.getRefundMoney() == null : this.getRefundMoney().equals(other.getRefundMoney()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getAuditTime() == null ? other.getAuditTime() == null : this.getAuditTime().equals(other.getAuditTime()))
            && (this.getOrderCount() == null ? other.getOrderCount() == null : this.getOrderCount().equals(other.getOrderCount()))
            && (this.getInvoiceTitle() == null ? other.getInvoiceTitle() == null : this.getInvoiceTitle().equals(other.getInvoiceTitle()))
            && (this.getContactsName() == null ? other.getContactsName() == null : this.getContactsName().equals(other.getContactsName()))
            && (this.getContactsPhone() == null ? other.getContactsPhone() == null : this.getContactsPhone().equals(other.getContactsPhone()))
            && (this.getMailingAddress() == null ? other.getMailingAddress() == null : this.getMailingAddress().equals(other.getMailingAddress()))
            && (this.getInvoiceStatus() == null ? other.getInvoiceStatus() == null : this.getInvoiceStatus().equals(other.getInvoiceStatus()))
            && (this.getSettlementStartTime() == null ? other.getSettlementStartTime() == null : this.getSettlementStartTime().equals(other.getSettlementStartTime()))
            && (this.getSettlementEndTime() == null ? other.getSettlementEndTime() == null : this.getSettlementEndTime().equals(other.getSettlementEndTime()))
            && (this.getAuditComment() == null ? other.getAuditComment() == null : this.getAuditComment().equals(other.getAuditComment()))
            && (this.getMerchantId() == null ? other.getMerchantId() == null : this.getMerchantId().equals(other.getMerchantId()))
            && (this.getInvoiceType() == null ? other.getInvoiceType() == null : this.getInvoiceType().equals(other.getInvoiceType()))
            && (this.getCompanyName() == null ? other.getCompanyName() == null : this.getCompanyName().equals(other.getCompanyName()))
            && (this.getTaxpayerCode() == null ? other.getTaxpayerCode() == null : this.getTaxpayerCode().equals(other.getTaxpayerCode()))
            && (this.getCompanyAddress() == null ? other.getCompanyAddress() == null : this.getCompanyAddress().equals(other.getCompanyAddress()))
            && (this.getCompanyPhone() == null ? other.getCompanyPhone() == null : this.getCompanyPhone().equals(other.getCompanyPhone()))
            && (this.getBankName() == null ? other.getBankName() == null : this.getBankName().equals(other.getBankName()))
            && (this.getBankAccount() == null ? other.getBankAccount() == null : this.getBankAccount().equals(other.getBankAccount()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getPlatformSettlementId() == null ? other.getPlatformSettlementId() == null : this.getPlatformSettlementId().equals(other.getPlatformSettlementId()))
            && (this.getMchId() == null ? other.getMchId() == null : this.getMchId().equals(other.getMchId()))
            && (this.getAccountId() == null ? other.getAccountId() == null : this.getAccountId().equals(other.getAccountId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getPfStatus() == null ? other.getPfStatus() == null : this.getPfStatus().equals(other.getPfStatus()))
            && (this.getAuditPhone() == null ? other.getAuditPhone() == null : this.getAuditPhone().equals(other.getAuditPhone()))
            && (this.getAuditName() == null ? other.getAuditName() == null : this.getAuditName().equals(other.getAuditName()))
            && (this.getSettleSuccessTime() == null ? other.getSettleSuccessTime() == null : this.getSettleSuccessTime().equals(other.getSettleSuccessTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getServiceId() == null) ? 0 : getServiceId().hashCode());
        result = prime * result + ((getSettlementId() == null) ? 0 : getSettlementId().hashCode());
        result = prime * result + ((getOrderAmountCount() == null) ? 0 : getOrderAmountCount().hashCode());
        result = prime * result + ((getPlatformPoundageAmount() == null) ? 0 : getPlatformPoundageAmount().hashCode());
        result = prime * result + ((getPlatformCommissionAmount() == null) ? 0 : getPlatformCommissionAmount().hashCode());
        result = prime * result + ((getPlatformThinkAmount() == null) ? 0 : getPlatformThinkAmount().hashCode());
        result = prime * result + ((getSettlementAmountCount() == null) ? 0 : getSettlementAmountCount().hashCode());
        result = prime * result + ((getPaidSettlementAmount() == null) ? 0 : getPaidSettlementAmount().hashCode());
        result = prime * result + ((getRefundMoney() == null) ? 0 : getRefundMoney().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getAuditTime() == null) ? 0 : getAuditTime().hashCode());
        result = prime * result + ((getOrderCount() == null) ? 0 : getOrderCount().hashCode());
        result = prime * result + ((getInvoiceTitle() == null) ? 0 : getInvoiceTitle().hashCode());
        result = prime * result + ((getContactsName() == null) ? 0 : getContactsName().hashCode());
        result = prime * result + ((getContactsPhone() == null) ? 0 : getContactsPhone().hashCode());
        result = prime * result + ((getMailingAddress() == null) ? 0 : getMailingAddress().hashCode());
        result = prime * result + ((getInvoiceStatus() == null) ? 0 : getInvoiceStatus().hashCode());
        result = prime * result + ((getSettlementStartTime() == null) ? 0 : getSettlementStartTime().hashCode());
        result = prime * result + ((getSettlementEndTime() == null) ? 0 : getSettlementEndTime().hashCode());
        result = prime * result + ((getAuditComment() == null) ? 0 : getAuditComment().hashCode());
        result = prime * result + ((getMerchantId() == null) ? 0 : getMerchantId().hashCode());
        result = prime * result + ((getInvoiceType() == null) ? 0 : getInvoiceType().hashCode());
        result = prime * result + ((getCompanyName() == null) ? 0 : getCompanyName().hashCode());
        result = prime * result + ((getTaxpayerCode() == null) ? 0 : getTaxpayerCode().hashCode());
        result = prime * result + ((getCompanyAddress() == null) ? 0 : getCompanyAddress().hashCode());
        result = prime * result + ((getCompanyPhone() == null) ? 0 : getCompanyPhone().hashCode());
        result = prime * result + ((getBankName() == null) ? 0 : getBankName().hashCode());
        result = prime * result + ((getBankAccount() == null) ? 0 : getBankAccount().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getPlatformSettlementId() == null) ? 0 : getPlatformSettlementId().hashCode());
        result = prime * result + ((getMchId() == null) ? 0 : getMchId().hashCode());
        result = prime * result + ((getAccountId() == null) ? 0 : getAccountId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getPfStatus() == null) ? 0 : getPfStatus().hashCode());
        result = prime * result + ((getAuditPhone() == null) ? 0 : getAuditPhone().hashCode());
        result = prime * result + ((getAuditName() == null) ? 0 : getAuditName().hashCode());
        result = prime * result + ((getSettleSuccessTime() == null) ? 0 : getSettleSuccessTime().hashCode());
        return result;
    }
}