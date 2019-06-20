package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OpenOrderTotal implements Serializable {
    private Long id;

    private String accountId;

    private Long communityId;

    private String communityAccountId;

    private String thinkAccountId;

    private Long uid;

    private Date expireTime;

    private Date createTime;

    private Date updateTime;

    private Integer type;

    private String billId;

    private Integer billStatus;

    private Date billFinishedTime;

    private String communityTradeNo;

    private BigDecimal totalAmount;

    private BigDecimal totalPlatformCharge;

    private BigDecimal totalToServiceCharge;

    private BigDecimal totalServiceCharge;

    private BigDecimal totalToReceiptAmount;

    private BigDecimal totalReceiptAmount;

    private BigDecimal totalThinkToAmount;

    private BigDecimal totalThinkAmount;

    private BigDecimal totalRefundMoney;

    private Integer refundCount;

    private Integer storeCount;

    private Integer billSplitStatus;

    private Date billSplitTime;

    private BigDecimal splitAmount;

    private Integer pfBalanceStatus;

    private Integer pfBussinessBalanceStatus;

    private Integer pfPayStatus;

    private Integer pfRefundStatus;

    private String subject;

    private String payChannel;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public String getCommunityAccountId() {
        return communityAccountId;
    }

    public void setCommunityAccountId(String communityAccountId) {
        this.communityAccountId = communityAccountId;
    }

    public String getThinkAccountId() {
        return thinkAccountId;
    }

    public void setThinkAccountId(String thinkAccountId) {
        this.thinkAccountId = thinkAccountId;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public Integer getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(Integer billStatus) {
        this.billStatus = billStatus;
    }

    public Date getBillFinishedTime() {
        return billFinishedTime;
    }

    public void setBillFinishedTime(Date billFinishedTime) {
        this.billFinishedTime = billFinishedTime;
    }

    public String getCommunityTradeNo() {
        return communityTradeNo;
    }

    public void setCommunityTradeNo(String communityTradeNo) {
        this.communityTradeNo = communityTradeNo;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalPlatformCharge() {
        return totalPlatformCharge;
    }

    public void setTotalPlatformCharge(BigDecimal totalPlatformCharge) {
        this.totalPlatformCharge = totalPlatformCharge;
    }

    public BigDecimal getTotalToServiceCharge() {
        return totalToServiceCharge;
    }

    public void setTotalToServiceCharge(BigDecimal totalToServiceCharge) {
        this.totalToServiceCharge = totalToServiceCharge;
    }

    public BigDecimal getTotalServiceCharge() {
        return totalServiceCharge;
    }

    public void setTotalServiceCharge(BigDecimal totalServiceCharge) {
        this.totalServiceCharge = totalServiceCharge;
    }

    public BigDecimal getTotalToReceiptAmount() {
        return totalToReceiptAmount;
    }

    public void setTotalToReceiptAmount(BigDecimal totalToReceiptAmount) {
        this.totalToReceiptAmount = totalToReceiptAmount;
    }

    public BigDecimal getTotalReceiptAmount() {
        return totalReceiptAmount;
    }

    public void setTotalReceiptAmount(BigDecimal totalReceiptAmount) {
        this.totalReceiptAmount = totalReceiptAmount;
    }

    public BigDecimal getTotalThinkToAmount() {
        return totalThinkToAmount;
    }

    public void setTotalThinkToAmount(BigDecimal totalThinkToAmount) {
        this.totalThinkToAmount = totalThinkToAmount;
    }

    public BigDecimal getTotalThinkAmount() {
        return totalThinkAmount;
    }

    public void setTotalThinkAmount(BigDecimal totalThinkAmount) {
        this.totalThinkAmount = totalThinkAmount;
    }

    public BigDecimal getTotalRefundMoney() {
        return totalRefundMoney;
    }

    public void setTotalRefundMoney(BigDecimal totalRefundMoney) {
        this.totalRefundMoney = totalRefundMoney;
    }

    public Integer getRefundCount() {
        return refundCount;
    }

    public void setRefundCount(Integer refundCount) {
        this.refundCount = refundCount;
    }

    public Integer getStoreCount() {
        return storeCount;
    }

    public void setStoreCount(Integer storeCount) {
        this.storeCount = storeCount;
    }

    public Integer getBillSplitStatus() {
        return billSplitStatus;
    }

    public void setBillSplitStatus(Integer billSplitStatus) {
        this.billSplitStatus = billSplitStatus;
    }

    public Date getBillSplitTime() {
        return billSplitTime;
    }

    public void setBillSplitTime(Date billSplitTime) {
        this.billSplitTime = billSplitTime;
    }

    public BigDecimal getSplitAmount() {
        return splitAmount;
    }

    public void setSplitAmount(BigDecimal splitAmount) {
        this.splitAmount = splitAmount;
    }

    public Integer getPfBalanceStatus() {
        return pfBalanceStatus;
    }

    public void setPfBalanceStatus(Integer pfBalanceStatus) {
        this.pfBalanceStatus = pfBalanceStatus;
    }

    public Integer getPfBussinessBalanceStatus() {
        return pfBussinessBalanceStatus;
    }

    public void setPfBussinessBalanceStatus(Integer pfBussinessBalanceStatus) {
        this.pfBussinessBalanceStatus = pfBussinessBalanceStatus;
    }

    public Integer getPfPayStatus() {
        return pfPayStatus;
    }

    public void setPfPayStatus(Integer pfPayStatus) {
        this.pfPayStatus = pfPayStatus;
    }

    public Integer getPfRefundStatus() {
        return pfRefundStatus;
    }

    public void setPfRefundStatus(Integer pfRefundStatus) {
        this.pfRefundStatus = pfRefundStatus;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", accountId=").append(accountId);
        sb.append(", communityId=").append(communityId);
        sb.append(", communityAccountId=").append(communityAccountId);
        sb.append(", thinkAccountId=").append(thinkAccountId);
        sb.append(", uid=").append(uid);
        sb.append(", expireTime=").append(expireTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", type=").append(type);
        sb.append(", billId=").append(billId);
        sb.append(", billStatus=").append(billStatus);
        sb.append(", billFinishedTime=").append(billFinishedTime);
        sb.append(", communityTradeNo=").append(communityTradeNo);
        sb.append(", totalAmount=").append(totalAmount);
        sb.append(", totalPlatformCharge=").append(totalPlatformCharge);
        sb.append(", totalToServiceCharge=").append(totalToServiceCharge);
        sb.append(", totalServiceCharge=").append(totalServiceCharge);
        sb.append(", totalToReceiptAmount=").append(totalToReceiptAmount);
        sb.append(", totalReceiptAmount=").append(totalReceiptAmount);
        sb.append(", totalThinkToAmount=").append(totalThinkToAmount);
        sb.append(", totalThinkAmount=").append(totalThinkAmount);
        sb.append(", totalRefundMoney=").append(totalRefundMoney);
        sb.append(", refundCount=").append(refundCount);
        sb.append(", storeCount=").append(storeCount);
        sb.append(", billSplitStatus=").append(billSplitStatus);
        sb.append(", billSplitTime=").append(billSplitTime);
        sb.append(", splitAmount=").append(splitAmount);
        sb.append(", pfBalanceStatus=").append(pfBalanceStatus);
        sb.append(", pfBussinessBalanceStatus=").append(pfBussinessBalanceStatus);
        sb.append(", pfPayStatus=").append(pfPayStatus);
        sb.append(", pfRefundStatus=").append(pfRefundStatus);
        sb.append(", subject=").append(subject);
        sb.append(", payChannel=").append(payChannel);
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
        OpenOrderTotal other = (OpenOrderTotal) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAccountId() == null ? other.getAccountId() == null : this.getAccountId().equals(other.getAccountId()))
            && (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getCommunityAccountId() == null ? other.getCommunityAccountId() == null : this.getCommunityAccountId().equals(other.getCommunityAccountId()))
            && (this.getThinkAccountId() == null ? other.getThinkAccountId() == null : this.getThinkAccountId().equals(other.getThinkAccountId()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getExpireTime() == null ? other.getExpireTime() == null : this.getExpireTime().equals(other.getExpireTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getBillId() == null ? other.getBillId() == null : this.getBillId().equals(other.getBillId()))
            && (this.getBillStatus() == null ? other.getBillStatus() == null : this.getBillStatus().equals(other.getBillStatus()))
            && (this.getBillFinishedTime() == null ? other.getBillFinishedTime() == null : this.getBillFinishedTime().equals(other.getBillFinishedTime()))
            && (this.getCommunityTradeNo() == null ? other.getCommunityTradeNo() == null : this.getCommunityTradeNo().equals(other.getCommunityTradeNo()))
            && (this.getTotalAmount() == null ? other.getTotalAmount() == null : this.getTotalAmount().equals(other.getTotalAmount()))
            && (this.getTotalPlatformCharge() == null ? other.getTotalPlatformCharge() == null : this.getTotalPlatformCharge().equals(other.getTotalPlatformCharge()))
            && (this.getTotalToServiceCharge() == null ? other.getTotalToServiceCharge() == null : this.getTotalToServiceCharge().equals(other.getTotalToServiceCharge()))
            && (this.getTotalServiceCharge() == null ? other.getTotalServiceCharge() == null : this.getTotalServiceCharge().equals(other.getTotalServiceCharge()))
            && (this.getTotalToReceiptAmount() == null ? other.getTotalToReceiptAmount() == null : this.getTotalToReceiptAmount().equals(other.getTotalToReceiptAmount()))
            && (this.getTotalReceiptAmount() == null ? other.getTotalReceiptAmount() == null : this.getTotalReceiptAmount().equals(other.getTotalReceiptAmount()))
            && (this.getTotalThinkToAmount() == null ? other.getTotalThinkToAmount() == null : this.getTotalThinkToAmount().equals(other.getTotalThinkToAmount()))
            && (this.getTotalThinkAmount() == null ? other.getTotalThinkAmount() == null : this.getTotalThinkAmount().equals(other.getTotalThinkAmount()))
            && (this.getTotalRefundMoney() == null ? other.getTotalRefundMoney() == null : this.getTotalRefundMoney().equals(other.getTotalRefundMoney()))
            && (this.getRefundCount() == null ? other.getRefundCount() == null : this.getRefundCount().equals(other.getRefundCount()))
            && (this.getStoreCount() == null ? other.getStoreCount() == null : this.getStoreCount().equals(other.getStoreCount()))
            && (this.getBillSplitStatus() == null ? other.getBillSplitStatus() == null : this.getBillSplitStatus().equals(other.getBillSplitStatus()))
            && (this.getBillSplitTime() == null ? other.getBillSplitTime() == null : this.getBillSplitTime().equals(other.getBillSplitTime()))
            && (this.getSplitAmount() == null ? other.getSplitAmount() == null : this.getSplitAmount().equals(other.getSplitAmount()))
            && (this.getPfBalanceStatus() == null ? other.getPfBalanceStatus() == null : this.getPfBalanceStatus().equals(other.getPfBalanceStatus()))
            && (this.getPfBussinessBalanceStatus() == null ? other.getPfBussinessBalanceStatus() == null : this.getPfBussinessBalanceStatus().equals(other.getPfBussinessBalanceStatus()))
            && (this.getPfPayStatus() == null ? other.getPfPayStatus() == null : this.getPfPayStatus().equals(other.getPfPayStatus()))
            && (this.getPfRefundStatus() == null ? other.getPfRefundStatus() == null : this.getPfRefundStatus().equals(other.getPfRefundStatus()))
            && (this.getSubject() == null ? other.getSubject() == null : this.getSubject().equals(other.getSubject()))
            && (this.getPayChannel() == null ? other.getPayChannel() == null : this.getPayChannel().equals(other.getPayChannel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAccountId() == null) ? 0 : getAccountId().hashCode());
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getCommunityAccountId() == null) ? 0 : getCommunityAccountId().hashCode());
        result = prime * result + ((getThinkAccountId() == null) ? 0 : getThinkAccountId().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getExpireTime() == null) ? 0 : getExpireTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getBillId() == null) ? 0 : getBillId().hashCode());
        result = prime * result + ((getBillStatus() == null) ? 0 : getBillStatus().hashCode());
        result = prime * result + ((getBillFinishedTime() == null) ? 0 : getBillFinishedTime().hashCode());
        result = prime * result + ((getCommunityTradeNo() == null) ? 0 : getCommunityTradeNo().hashCode());
        result = prime * result + ((getTotalAmount() == null) ? 0 : getTotalAmount().hashCode());
        result = prime * result + ((getTotalPlatformCharge() == null) ? 0 : getTotalPlatformCharge().hashCode());
        result = prime * result + ((getTotalToServiceCharge() == null) ? 0 : getTotalToServiceCharge().hashCode());
        result = prime * result + ((getTotalServiceCharge() == null) ? 0 : getTotalServiceCharge().hashCode());
        result = prime * result + ((getTotalToReceiptAmount() == null) ? 0 : getTotalToReceiptAmount().hashCode());
        result = prime * result + ((getTotalReceiptAmount() == null) ? 0 : getTotalReceiptAmount().hashCode());
        result = prime * result + ((getTotalThinkToAmount() == null) ? 0 : getTotalThinkToAmount().hashCode());
        result = prime * result + ((getTotalThinkAmount() == null) ? 0 : getTotalThinkAmount().hashCode());
        result = prime * result + ((getTotalRefundMoney() == null) ? 0 : getTotalRefundMoney().hashCode());
        result = prime * result + ((getRefundCount() == null) ? 0 : getRefundCount().hashCode());
        result = prime * result + ((getStoreCount() == null) ? 0 : getStoreCount().hashCode());
        result = prime * result + ((getBillSplitStatus() == null) ? 0 : getBillSplitStatus().hashCode());
        result = prime * result + ((getBillSplitTime() == null) ? 0 : getBillSplitTime().hashCode());
        result = prime * result + ((getSplitAmount() == null) ? 0 : getSplitAmount().hashCode());
        result = prime * result + ((getPfBalanceStatus() == null) ? 0 : getPfBalanceStatus().hashCode());
        result = prime * result + ((getPfBussinessBalanceStatus() == null) ? 0 : getPfBussinessBalanceStatus().hashCode());
        result = prime * result + ((getPfPayStatus() == null) ? 0 : getPfPayStatus().hashCode());
        result = prime * result + ((getPfRefundStatus() == null) ? 0 : getPfRefundStatus().hashCode());
        result = prime * result + ((getSubject() == null) ? 0 : getSubject().hashCode());
        result = prime * result + ((getPayChannel() == null) ? 0 : getPayChannel().hashCode());
        return result;
    }
}