package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OpenOrder implements Serializable {
    private Long id;

    private Long totalId;

    private String accountId;

    private String thinkAccountId;

    private Long communityId;

    private Long appId;

    private Integer serviceId;

    private Long uid;

    private Long cautionId;

    private String payChannel;

    private String outTradeNo;

    private String clientIp;

    private String projectType;

    private String tradeType;

    private String weixinOpenId;

    private Date expireTime;

    private Integer bussinessType;

    private Date createTime;

    private Date updateTime;

    private Integer billStatus;

    private String billId;

    private Date billCreateTime;

    private String communityTradeNo;

    private Date billFinishedTime;

    private BigDecimal totalAmount;

    private BigDecimal platformCharge;

    private BigDecimal platformChargeRate;

    private BigDecimal serviceCharge;

    private BigDecimal serviceChargeRate;

    private BigDecimal receiptAmount;

    private BigDecimal thinkChargeRate;

    private BigDecimal thinkCharge;

    private String tixianThrid;

    private String tixianCommunity;

    private Integer refundStatus;

    private String refundReason;

    private String refundId;

    private String refundRemark;

    private Date refundCreateTime;

    private BigDecimal refundMoney;

    private String refundBillId;

    private String refundSubBillId;

    private String refundAccountId;

    private Integer sameWay;

    private Integer withdrawStatus;

    private Integer type;

    private Integer serviceChargeStatus;

    private Integer balanceStatus;

    private String serviceChargeBillId;

    private String serviceAccount;

    private String serviceAccountMchid;

    private String merchantBillId;

    private String thinkBillId;

    private Integer billSplitStatus;

    private Date billSplitTime;

    private BigDecimal splitAmount;

    private String openId;

    private Integer outStatus;

    private String outStatusContent;

    private String settleId;

    private Integer pfBalanceStatus;

    private Integer pfBussinessBalanceStatus;

    private Integer pfRefundStatus;

    private Date pfRefundTime;

    private String subject;

    private String body;

    private String detail;

    private Long taskId;

    private String empGuid;

    private String empPhone;

    private String empName;

    private Long taskRelId;

    private String goodsDetail;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTotalId() {
        return totalId;
    }

    public void setTotalId(Long totalId) {
        this.totalId = totalId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getThinkAccountId() {
        return thinkAccountId;
    }

    public void setThinkAccountId(String thinkAccountId) {
        this.thinkAccountId = thinkAccountId;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getCautionId() {
        return cautionId;
    }

    public void setCautionId(Long cautionId) {
        this.cautionId = cautionId;
    }

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getWeixinOpenId() {
        return weixinOpenId;
    }

    public void setWeixinOpenId(String weixinOpenId) {
        this.weixinOpenId = weixinOpenId;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Integer getBussinessType() {
        return bussinessType;
    }

    public void setBussinessType(Integer bussinessType) {
        this.bussinessType = bussinessType;
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

    public Integer getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(Integer billStatus) {
        this.billStatus = billStatus;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public Date getBillCreateTime() {
        return billCreateTime;
    }

    public void setBillCreateTime(Date billCreateTime) {
        this.billCreateTime = billCreateTime;
    }

    public String getCommunityTradeNo() {
        return communityTradeNo;
    }

    public void setCommunityTradeNo(String communityTradeNo) {
        this.communityTradeNo = communityTradeNo;
    }

    public Date getBillFinishedTime() {
        return billFinishedTime;
    }

    public void setBillFinishedTime(Date billFinishedTime) {
        this.billFinishedTime = billFinishedTime;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getPlatformCharge() {
        return platformCharge;
    }

    public void setPlatformCharge(BigDecimal platformCharge) {
        this.platformCharge = platformCharge;
    }

    public BigDecimal getPlatformChargeRate() {
        return platformChargeRate;
    }

    public void setPlatformChargeRate(BigDecimal platformChargeRate) {
        this.platformChargeRate = platformChargeRate;
    }

    public BigDecimal getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(BigDecimal serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public BigDecimal getServiceChargeRate() {
        return serviceChargeRate;
    }

    public void setServiceChargeRate(BigDecimal serviceChargeRate) {
        this.serviceChargeRate = serviceChargeRate;
    }

    public BigDecimal getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptAmount(BigDecimal receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    public BigDecimal getThinkChargeRate() {
        return thinkChargeRate;
    }

    public void setThinkChargeRate(BigDecimal thinkChargeRate) {
        this.thinkChargeRate = thinkChargeRate;
    }

    public BigDecimal getThinkCharge() {
        return thinkCharge;
    }

    public void setThinkCharge(BigDecimal thinkCharge) {
        this.thinkCharge = thinkCharge;
    }

    public String getTixianThrid() {
        return tixianThrid;
    }

    public void setTixianThrid(String tixianThrid) {
        this.tixianThrid = tixianThrid;
    }

    public String getTixianCommunity() {
        return tixianCommunity;
    }

    public void setTixianCommunity(String tixianCommunity) {
        this.tixianCommunity = tixianCommunity;
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public String getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public String getRefundRemark() {
        return refundRemark;
    }

    public void setRefundRemark(String refundRemark) {
        this.refundRemark = refundRemark;
    }

    public Date getRefundCreateTime() {
        return refundCreateTime;
    }

    public void setRefundCreateTime(Date refundCreateTime) {
        this.refundCreateTime = refundCreateTime;
    }

    public BigDecimal getRefundMoney() {
        return refundMoney;
    }

    public void setRefundMoney(BigDecimal refundMoney) {
        this.refundMoney = refundMoney;
    }

    public String getRefundBillId() {
        return refundBillId;
    }

    public void setRefundBillId(String refundBillId) {
        this.refundBillId = refundBillId;
    }

    public String getRefundSubBillId() {
        return refundSubBillId;
    }

    public void setRefundSubBillId(String refundSubBillId) {
        this.refundSubBillId = refundSubBillId;
    }

    public String getRefundAccountId() {
        return refundAccountId;
    }

    public void setRefundAccountId(String refundAccountId) {
        this.refundAccountId = refundAccountId;
    }

    public Integer getSameWay() {
        return sameWay;
    }

    public void setSameWay(Integer sameWay) {
        this.sameWay = sameWay;
    }

    public Integer getWithdrawStatus() {
        return withdrawStatus;
    }

    public void setWithdrawStatus(Integer withdrawStatus) {
        this.withdrawStatus = withdrawStatus;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getServiceChargeStatus() {
        return serviceChargeStatus;
    }

    public void setServiceChargeStatus(Integer serviceChargeStatus) {
        this.serviceChargeStatus = serviceChargeStatus;
    }

    public Integer getBalanceStatus() {
        return balanceStatus;
    }

    public void setBalanceStatus(Integer balanceStatus) {
        this.balanceStatus = balanceStatus;
    }

    public String getServiceChargeBillId() {
        return serviceChargeBillId;
    }

    public void setServiceChargeBillId(String serviceChargeBillId) {
        this.serviceChargeBillId = serviceChargeBillId;
    }

    public String getServiceAccount() {
        return serviceAccount;
    }

    public void setServiceAccount(String serviceAccount) {
        this.serviceAccount = serviceAccount;
    }

    public String getServiceAccountMchid() {
        return serviceAccountMchid;
    }

    public void setServiceAccountMchid(String serviceAccountMchid) {
        this.serviceAccountMchid = serviceAccountMchid;
    }

    public String getMerchantBillId() {
        return merchantBillId;
    }

    public void setMerchantBillId(String merchantBillId) {
        this.merchantBillId = merchantBillId;
    }

    public String getThinkBillId() {
        return thinkBillId;
    }

    public void setThinkBillId(String thinkBillId) {
        this.thinkBillId = thinkBillId;
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

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Integer getOutStatus() {
        return outStatus;
    }

    public void setOutStatus(Integer outStatus) {
        this.outStatus = outStatus;
    }

    public String getOutStatusContent() {
        return outStatusContent;
    }

    public void setOutStatusContent(String outStatusContent) {
        this.outStatusContent = outStatusContent;
    }

    public String getSettleId() {
        return settleId;
    }

    public void setSettleId(String settleId) {
        this.settleId = settleId;
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

    public Integer getPfRefundStatus() {
        return pfRefundStatus;
    }

    public void setPfRefundStatus(Integer pfRefundStatus) {
        this.pfRefundStatus = pfRefundStatus;
    }

    public Date getPfRefundTime() {
        return pfRefundTime;
    }

    public void setPfRefundTime(Date pfRefundTime) {
        this.pfRefundTime = pfRefundTime;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getEmpGuid() {
        return empGuid;
    }

    public void setEmpGuid(String empGuid) {
        this.empGuid = empGuid;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Long getTaskRelId() {
        return taskRelId;
    }

    public void setTaskRelId(Long taskRelId) {
        this.taskRelId = taskRelId;
    }

    public String getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", totalId=").append(totalId);
        sb.append(", accountId=").append(accountId);
        sb.append(", thinkAccountId=").append(thinkAccountId);
        sb.append(", communityId=").append(communityId);
        sb.append(", appId=").append(appId);
        sb.append(", serviceId=").append(serviceId);
        sb.append(", uid=").append(uid);
        sb.append(", cautionId=").append(cautionId);
        sb.append(", payChannel=").append(payChannel);
        sb.append(", outTradeNo=").append(outTradeNo);
        sb.append(", clientIp=").append(clientIp);
        sb.append(", projectType=").append(projectType);
        sb.append(", tradeType=").append(tradeType);
        sb.append(", weixinOpenId=").append(weixinOpenId);
        sb.append(", expireTime=").append(expireTime);
        sb.append(", bussinessType=").append(bussinessType);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", billStatus=").append(billStatus);
        sb.append(", billId=").append(billId);
        sb.append(", billCreateTime=").append(billCreateTime);
        sb.append(", communityTradeNo=").append(communityTradeNo);
        sb.append(", billFinishedTime=").append(billFinishedTime);
        sb.append(", totalAmount=").append(totalAmount);
        sb.append(", platformCharge=").append(platformCharge);
        sb.append(", platformChargeRate=").append(platformChargeRate);
        sb.append(", serviceCharge=").append(serviceCharge);
        sb.append(", serviceChargeRate=").append(serviceChargeRate);
        sb.append(", receiptAmount=").append(receiptAmount);
        sb.append(", thinkChargeRate=").append(thinkChargeRate);
        sb.append(", thinkCharge=").append(thinkCharge);
        sb.append(", tixianThrid=").append(tixianThrid);
        sb.append(", tixianCommunity=").append(tixianCommunity);
        sb.append(", refundStatus=").append(refundStatus);
        sb.append(", refundReason=").append(refundReason);
        sb.append(", refundId=").append(refundId);
        sb.append(", refundRemark=").append(refundRemark);
        sb.append(", refundCreateTime=").append(refundCreateTime);
        sb.append(", refundMoney=").append(refundMoney);
        sb.append(", refundBillId=").append(refundBillId);
        sb.append(", refundSubBillId=").append(refundSubBillId);
        sb.append(", refundAccountId=").append(refundAccountId);
        sb.append(", sameWay=").append(sameWay);
        sb.append(", withdrawStatus=").append(withdrawStatus);
        sb.append(", type=").append(type);
        sb.append(", serviceChargeStatus=").append(serviceChargeStatus);
        sb.append(", balanceStatus=").append(balanceStatus);
        sb.append(", serviceChargeBillId=").append(serviceChargeBillId);
        sb.append(", serviceAccount=").append(serviceAccount);
        sb.append(", serviceAccountMchid=").append(serviceAccountMchid);
        sb.append(", merchantBillId=").append(merchantBillId);
        sb.append(", thinkBillId=").append(thinkBillId);
        sb.append(", billSplitStatus=").append(billSplitStatus);
        sb.append(", billSplitTime=").append(billSplitTime);
        sb.append(", splitAmount=").append(splitAmount);
        sb.append(", openId=").append(openId);
        sb.append(", outStatus=").append(outStatus);
        sb.append(", outStatusContent=").append(outStatusContent);
        sb.append(", settleId=").append(settleId);
        sb.append(", pfBalanceStatus=").append(pfBalanceStatus);
        sb.append(", pfBussinessBalanceStatus=").append(pfBussinessBalanceStatus);
        sb.append(", pfRefundStatus=").append(pfRefundStatus);
        sb.append(", pfRefundTime=").append(pfRefundTime);
        sb.append(", subject=").append(subject);
        sb.append(", body=").append(body);
        sb.append(", detail=").append(detail);
        sb.append(", taskId=").append(taskId);
        sb.append(", empGuid=").append(empGuid);
        sb.append(", empPhone=").append(empPhone);
        sb.append(", empName=").append(empName);
        sb.append(", taskRelId=").append(taskRelId);
        sb.append(", goodsDetail=").append(goodsDetail);
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
        OpenOrder other = (OpenOrder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTotalId() == null ? other.getTotalId() == null : this.getTotalId().equals(other.getTotalId()))
            && (this.getAccountId() == null ? other.getAccountId() == null : this.getAccountId().equals(other.getAccountId()))
            && (this.getThinkAccountId() == null ? other.getThinkAccountId() == null : this.getThinkAccountId().equals(other.getThinkAccountId()))
            && (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getAppId() == null ? other.getAppId() == null : this.getAppId().equals(other.getAppId()))
            && (this.getServiceId() == null ? other.getServiceId() == null : this.getServiceId().equals(other.getServiceId()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getCautionId() == null ? other.getCautionId() == null : this.getCautionId().equals(other.getCautionId()))
            && (this.getPayChannel() == null ? other.getPayChannel() == null : this.getPayChannel().equals(other.getPayChannel()))
            && (this.getOutTradeNo() == null ? other.getOutTradeNo() == null : this.getOutTradeNo().equals(other.getOutTradeNo()))
            && (this.getClientIp() == null ? other.getClientIp() == null : this.getClientIp().equals(other.getClientIp()))
            && (this.getProjectType() == null ? other.getProjectType() == null : this.getProjectType().equals(other.getProjectType()))
            && (this.getTradeType() == null ? other.getTradeType() == null : this.getTradeType().equals(other.getTradeType()))
            && (this.getWeixinOpenId() == null ? other.getWeixinOpenId() == null : this.getWeixinOpenId().equals(other.getWeixinOpenId()))
            && (this.getExpireTime() == null ? other.getExpireTime() == null : this.getExpireTime().equals(other.getExpireTime()))
            && (this.getBussinessType() == null ? other.getBussinessType() == null : this.getBussinessType().equals(other.getBussinessType()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getBillStatus() == null ? other.getBillStatus() == null : this.getBillStatus().equals(other.getBillStatus()))
            && (this.getBillId() == null ? other.getBillId() == null : this.getBillId().equals(other.getBillId()))
            && (this.getBillCreateTime() == null ? other.getBillCreateTime() == null : this.getBillCreateTime().equals(other.getBillCreateTime()))
            && (this.getCommunityTradeNo() == null ? other.getCommunityTradeNo() == null : this.getCommunityTradeNo().equals(other.getCommunityTradeNo()))
            && (this.getBillFinishedTime() == null ? other.getBillFinishedTime() == null : this.getBillFinishedTime().equals(other.getBillFinishedTime()))
            && (this.getTotalAmount() == null ? other.getTotalAmount() == null : this.getTotalAmount().equals(other.getTotalAmount()))
            && (this.getPlatformCharge() == null ? other.getPlatformCharge() == null : this.getPlatformCharge().equals(other.getPlatformCharge()))
            && (this.getPlatformChargeRate() == null ? other.getPlatformChargeRate() == null : this.getPlatformChargeRate().equals(other.getPlatformChargeRate()))
            && (this.getServiceCharge() == null ? other.getServiceCharge() == null : this.getServiceCharge().equals(other.getServiceCharge()))
            && (this.getServiceChargeRate() == null ? other.getServiceChargeRate() == null : this.getServiceChargeRate().equals(other.getServiceChargeRate()))
            && (this.getReceiptAmount() == null ? other.getReceiptAmount() == null : this.getReceiptAmount().equals(other.getReceiptAmount()))
            && (this.getThinkChargeRate() == null ? other.getThinkChargeRate() == null : this.getThinkChargeRate().equals(other.getThinkChargeRate()))
            && (this.getThinkCharge() == null ? other.getThinkCharge() == null : this.getThinkCharge().equals(other.getThinkCharge()))
            && (this.getTixianThrid() == null ? other.getTixianThrid() == null : this.getTixianThrid().equals(other.getTixianThrid()))
            && (this.getTixianCommunity() == null ? other.getTixianCommunity() == null : this.getTixianCommunity().equals(other.getTixianCommunity()))
            && (this.getRefundStatus() == null ? other.getRefundStatus() == null : this.getRefundStatus().equals(other.getRefundStatus()))
            && (this.getRefundReason() == null ? other.getRefundReason() == null : this.getRefundReason().equals(other.getRefundReason()))
            && (this.getRefundId() == null ? other.getRefundId() == null : this.getRefundId().equals(other.getRefundId()))
            && (this.getRefundRemark() == null ? other.getRefundRemark() == null : this.getRefundRemark().equals(other.getRefundRemark()))
            && (this.getRefundCreateTime() == null ? other.getRefundCreateTime() == null : this.getRefundCreateTime().equals(other.getRefundCreateTime()))
            && (this.getRefundMoney() == null ? other.getRefundMoney() == null : this.getRefundMoney().equals(other.getRefundMoney()))
            && (this.getRefundBillId() == null ? other.getRefundBillId() == null : this.getRefundBillId().equals(other.getRefundBillId()))
            && (this.getRefundSubBillId() == null ? other.getRefundSubBillId() == null : this.getRefundSubBillId().equals(other.getRefundSubBillId()))
            && (this.getRefundAccountId() == null ? other.getRefundAccountId() == null : this.getRefundAccountId().equals(other.getRefundAccountId()))
            && (this.getSameWay() == null ? other.getSameWay() == null : this.getSameWay().equals(other.getSameWay()))
            && (this.getWithdrawStatus() == null ? other.getWithdrawStatus() == null : this.getWithdrawStatus().equals(other.getWithdrawStatus()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getServiceChargeStatus() == null ? other.getServiceChargeStatus() == null : this.getServiceChargeStatus().equals(other.getServiceChargeStatus()))
            && (this.getBalanceStatus() == null ? other.getBalanceStatus() == null : this.getBalanceStatus().equals(other.getBalanceStatus()))
            && (this.getServiceChargeBillId() == null ? other.getServiceChargeBillId() == null : this.getServiceChargeBillId().equals(other.getServiceChargeBillId()))
            && (this.getServiceAccount() == null ? other.getServiceAccount() == null : this.getServiceAccount().equals(other.getServiceAccount()))
            && (this.getServiceAccountMchid() == null ? other.getServiceAccountMchid() == null : this.getServiceAccountMchid().equals(other.getServiceAccountMchid()))
            && (this.getMerchantBillId() == null ? other.getMerchantBillId() == null : this.getMerchantBillId().equals(other.getMerchantBillId()))
            && (this.getThinkBillId() == null ? other.getThinkBillId() == null : this.getThinkBillId().equals(other.getThinkBillId()))
            && (this.getBillSplitStatus() == null ? other.getBillSplitStatus() == null : this.getBillSplitStatus().equals(other.getBillSplitStatus()))
            && (this.getBillSplitTime() == null ? other.getBillSplitTime() == null : this.getBillSplitTime().equals(other.getBillSplitTime()))
            && (this.getSplitAmount() == null ? other.getSplitAmount() == null : this.getSplitAmount().equals(other.getSplitAmount()))
            && (this.getOpenId() == null ? other.getOpenId() == null : this.getOpenId().equals(other.getOpenId()))
            && (this.getOutStatus() == null ? other.getOutStatus() == null : this.getOutStatus().equals(other.getOutStatus()))
            && (this.getOutStatusContent() == null ? other.getOutStatusContent() == null : this.getOutStatusContent().equals(other.getOutStatusContent()))
            && (this.getSettleId() == null ? other.getSettleId() == null : this.getSettleId().equals(other.getSettleId()))
            && (this.getPfBalanceStatus() == null ? other.getPfBalanceStatus() == null : this.getPfBalanceStatus().equals(other.getPfBalanceStatus()))
            && (this.getPfBussinessBalanceStatus() == null ? other.getPfBussinessBalanceStatus() == null : this.getPfBussinessBalanceStatus().equals(other.getPfBussinessBalanceStatus()))
            && (this.getPfRefundStatus() == null ? other.getPfRefundStatus() == null : this.getPfRefundStatus().equals(other.getPfRefundStatus()))
            && (this.getPfRefundTime() == null ? other.getPfRefundTime() == null : this.getPfRefundTime().equals(other.getPfRefundTime()))
            && (this.getSubject() == null ? other.getSubject() == null : this.getSubject().equals(other.getSubject()))
            && (this.getBody() == null ? other.getBody() == null : this.getBody().equals(other.getBody()))
            && (this.getDetail() == null ? other.getDetail() == null : this.getDetail().equals(other.getDetail()))
            && (this.getTaskId() == null ? other.getTaskId() == null : this.getTaskId().equals(other.getTaskId()))
            && (this.getEmpGuid() == null ? other.getEmpGuid() == null : this.getEmpGuid().equals(other.getEmpGuid()))
            && (this.getEmpPhone() == null ? other.getEmpPhone() == null : this.getEmpPhone().equals(other.getEmpPhone()))
            && (this.getEmpName() == null ? other.getEmpName() == null : this.getEmpName().equals(other.getEmpName()))
            && (this.getTaskRelId() == null ? other.getTaskRelId() == null : this.getTaskRelId().equals(other.getTaskRelId()))
            && (this.getGoodsDetail() == null ? other.getGoodsDetail() == null : this.getGoodsDetail().equals(other.getGoodsDetail()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTotalId() == null) ? 0 : getTotalId().hashCode());
        result = prime * result + ((getAccountId() == null) ? 0 : getAccountId().hashCode());
        result = prime * result + ((getThinkAccountId() == null) ? 0 : getThinkAccountId().hashCode());
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getAppId() == null) ? 0 : getAppId().hashCode());
        result = prime * result + ((getServiceId() == null) ? 0 : getServiceId().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getCautionId() == null) ? 0 : getCautionId().hashCode());
        result = prime * result + ((getPayChannel() == null) ? 0 : getPayChannel().hashCode());
        result = prime * result + ((getOutTradeNo() == null) ? 0 : getOutTradeNo().hashCode());
        result = prime * result + ((getClientIp() == null) ? 0 : getClientIp().hashCode());
        result = prime * result + ((getProjectType() == null) ? 0 : getProjectType().hashCode());
        result = prime * result + ((getTradeType() == null) ? 0 : getTradeType().hashCode());
        result = prime * result + ((getWeixinOpenId() == null) ? 0 : getWeixinOpenId().hashCode());
        result = prime * result + ((getExpireTime() == null) ? 0 : getExpireTime().hashCode());
        result = prime * result + ((getBussinessType() == null) ? 0 : getBussinessType().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getBillStatus() == null) ? 0 : getBillStatus().hashCode());
        result = prime * result + ((getBillId() == null) ? 0 : getBillId().hashCode());
        result = prime * result + ((getBillCreateTime() == null) ? 0 : getBillCreateTime().hashCode());
        result = prime * result + ((getCommunityTradeNo() == null) ? 0 : getCommunityTradeNo().hashCode());
        result = prime * result + ((getBillFinishedTime() == null) ? 0 : getBillFinishedTime().hashCode());
        result = prime * result + ((getTotalAmount() == null) ? 0 : getTotalAmount().hashCode());
        result = prime * result + ((getPlatformCharge() == null) ? 0 : getPlatformCharge().hashCode());
        result = prime * result + ((getPlatformChargeRate() == null) ? 0 : getPlatformChargeRate().hashCode());
        result = prime * result + ((getServiceCharge() == null) ? 0 : getServiceCharge().hashCode());
        result = prime * result + ((getServiceChargeRate() == null) ? 0 : getServiceChargeRate().hashCode());
        result = prime * result + ((getReceiptAmount() == null) ? 0 : getReceiptAmount().hashCode());
        result = prime * result + ((getThinkChargeRate() == null) ? 0 : getThinkChargeRate().hashCode());
        result = prime * result + ((getThinkCharge() == null) ? 0 : getThinkCharge().hashCode());
        result = prime * result + ((getTixianThrid() == null) ? 0 : getTixianThrid().hashCode());
        result = prime * result + ((getTixianCommunity() == null) ? 0 : getTixianCommunity().hashCode());
        result = prime * result + ((getRefundStatus() == null) ? 0 : getRefundStatus().hashCode());
        result = prime * result + ((getRefundReason() == null) ? 0 : getRefundReason().hashCode());
        result = prime * result + ((getRefundId() == null) ? 0 : getRefundId().hashCode());
        result = prime * result + ((getRefundRemark() == null) ? 0 : getRefundRemark().hashCode());
        result = prime * result + ((getRefundCreateTime() == null) ? 0 : getRefundCreateTime().hashCode());
        result = prime * result + ((getRefundMoney() == null) ? 0 : getRefundMoney().hashCode());
        result = prime * result + ((getRefundBillId() == null) ? 0 : getRefundBillId().hashCode());
        result = prime * result + ((getRefundSubBillId() == null) ? 0 : getRefundSubBillId().hashCode());
        result = prime * result + ((getRefundAccountId() == null) ? 0 : getRefundAccountId().hashCode());
        result = prime * result + ((getSameWay() == null) ? 0 : getSameWay().hashCode());
        result = prime * result + ((getWithdrawStatus() == null) ? 0 : getWithdrawStatus().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getServiceChargeStatus() == null) ? 0 : getServiceChargeStatus().hashCode());
        result = prime * result + ((getBalanceStatus() == null) ? 0 : getBalanceStatus().hashCode());
        result = prime * result + ((getServiceChargeBillId() == null) ? 0 : getServiceChargeBillId().hashCode());
        result = prime * result + ((getServiceAccount() == null) ? 0 : getServiceAccount().hashCode());
        result = prime * result + ((getServiceAccountMchid() == null) ? 0 : getServiceAccountMchid().hashCode());
        result = prime * result + ((getMerchantBillId() == null) ? 0 : getMerchantBillId().hashCode());
        result = prime * result + ((getThinkBillId() == null) ? 0 : getThinkBillId().hashCode());
        result = prime * result + ((getBillSplitStatus() == null) ? 0 : getBillSplitStatus().hashCode());
        result = prime * result + ((getBillSplitTime() == null) ? 0 : getBillSplitTime().hashCode());
        result = prime * result + ((getSplitAmount() == null) ? 0 : getSplitAmount().hashCode());
        result = prime * result + ((getOpenId() == null) ? 0 : getOpenId().hashCode());
        result = prime * result + ((getOutStatus() == null) ? 0 : getOutStatus().hashCode());
        result = prime * result + ((getOutStatusContent() == null) ? 0 : getOutStatusContent().hashCode());
        result = prime * result + ((getSettleId() == null) ? 0 : getSettleId().hashCode());
        result = prime * result + ((getPfBalanceStatus() == null) ? 0 : getPfBalanceStatus().hashCode());
        result = prime * result + ((getPfBussinessBalanceStatus() == null) ? 0 : getPfBussinessBalanceStatus().hashCode());
        result = prime * result + ((getPfRefundStatus() == null) ? 0 : getPfRefundStatus().hashCode());
        result = prime * result + ((getPfRefundTime() == null) ? 0 : getPfRefundTime().hashCode());
        result = prime * result + ((getSubject() == null) ? 0 : getSubject().hashCode());
        result = prime * result + ((getBody() == null) ? 0 : getBody().hashCode());
        result = prime * result + ((getDetail() == null) ? 0 : getDetail().hashCode());
        result = prime * result + ((getTaskId() == null) ? 0 : getTaskId().hashCode());
        result = prime * result + ((getEmpGuid() == null) ? 0 : getEmpGuid().hashCode());
        result = prime * result + ((getEmpPhone() == null) ? 0 : getEmpPhone().hashCode());
        result = prime * result + ((getEmpName() == null) ? 0 : getEmpName().hashCode());
        result = prime * result + ((getTaskRelId() == null) ? 0 : getTaskRelId().hashCode());
        result = prime * result + ((getGoodsDetail() == null) ? 0 : getGoodsDetail().hashCode());
        return result;
    }
}