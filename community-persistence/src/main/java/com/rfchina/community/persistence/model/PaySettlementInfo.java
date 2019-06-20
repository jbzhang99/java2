package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class PaySettlementInfo implements Serializable {
    private String id;

    private String myId;

    private String myType;

    private Date myCreateTime;

    private Integer myStatus;

    private String mchId;

    private String mchName;

    private String mchAccountId;

    private Date createTime;

    private String appId;

    private String appName;

    private String title;

    private Integer status;

    private Date confirmTime;

    private Date revokeTime;

    private String fromBillDate;

    private String toBillDate;

    private String confirmComment;

    private String revokeComment;

    private Integer confirmStatus;

    private Date startTime;

    private String endTime;

    private String errorMsg;

    private Integer tradeTotal;

    private Long tradeTotalAmount;

    private Long tradeReceiptAmount;

    private Long tradeBussinessReceiptAmount;

    private Long tradeFeeAmount;

    private String depositName;

    private String depositBank;

    private String bankAccount;

    private Long tradeRefundTotal;

    private Long tradeRefundFee;

    private Long bussinessSettleAmount;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMyId() {
        return myId;
    }

    public void setMyId(String myId) {
        this.myId = myId;
    }

    public String getMyType() {
        return myType;
    }

    public void setMyType(String myType) {
        this.myType = myType;
    }

    public Date getMyCreateTime() {
        return myCreateTime;
    }

    public void setMyCreateTime(Date myCreateTime) {
        this.myCreateTime = myCreateTime;
    }

    public Integer getMyStatus() {
        return myStatus;
    }

    public void setMyStatus(Integer myStatus) {
        this.myStatus = myStatus;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getMchName() {
        return mchName;
    }

    public void setMchName(String mchName) {
        this.mchName = mchName;
    }

    public String getMchAccountId() {
        return mchAccountId;
    }

    public void setMchAccountId(String mchAccountId) {
        this.mchAccountId = mchAccountId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }

    public Date getRevokeTime() {
        return revokeTime;
    }

    public void setRevokeTime(Date revokeTime) {
        this.revokeTime = revokeTime;
    }

    public String getFromBillDate() {
        return fromBillDate;
    }

    public void setFromBillDate(String fromBillDate) {
        this.fromBillDate = fromBillDate;
    }

    public String getToBillDate() {
        return toBillDate;
    }

    public void setToBillDate(String toBillDate) {
        this.toBillDate = toBillDate;
    }

    public String getConfirmComment() {
        return confirmComment;
    }

    public void setConfirmComment(String confirmComment) {
        this.confirmComment = confirmComment;
    }

    public String getRevokeComment() {
        return revokeComment;
    }

    public void setRevokeComment(String revokeComment) {
        this.revokeComment = revokeComment;
    }

    public Integer getConfirmStatus() {
        return confirmStatus;
    }

    public void setConfirmStatus(Integer confirmStatus) {
        this.confirmStatus = confirmStatus;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Integer getTradeTotal() {
        return tradeTotal;
    }

    public void setTradeTotal(Integer tradeTotal) {
        this.tradeTotal = tradeTotal;
    }

    public Long getTradeTotalAmount() {
        return tradeTotalAmount;
    }

    public void setTradeTotalAmount(Long tradeTotalAmount) {
        this.tradeTotalAmount = tradeTotalAmount;
    }

    public Long getTradeReceiptAmount() {
        return tradeReceiptAmount;
    }

    public void setTradeReceiptAmount(Long tradeReceiptAmount) {
        this.tradeReceiptAmount = tradeReceiptAmount;
    }

    public Long getTradeBussinessReceiptAmount() {
        return tradeBussinessReceiptAmount;
    }

    public void setTradeBussinessReceiptAmount(Long tradeBussinessReceiptAmount) {
        this.tradeBussinessReceiptAmount = tradeBussinessReceiptAmount;
    }

    public Long getTradeFeeAmount() {
        return tradeFeeAmount;
    }

    public void setTradeFeeAmount(Long tradeFeeAmount) {
        this.tradeFeeAmount = tradeFeeAmount;
    }

    public String getDepositName() {
        return depositName;
    }

    public void setDepositName(String depositName) {
        this.depositName = depositName;
    }

    public String getDepositBank() {
        return depositBank;
    }

    public void setDepositBank(String depositBank) {
        this.depositBank = depositBank;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Long getTradeRefundTotal() {
        return tradeRefundTotal;
    }

    public void setTradeRefundTotal(Long tradeRefundTotal) {
        this.tradeRefundTotal = tradeRefundTotal;
    }

    public Long getTradeRefundFee() {
        return tradeRefundFee;
    }

    public void setTradeRefundFee(Long tradeRefundFee) {
        this.tradeRefundFee = tradeRefundFee;
    }

    public Long getBussinessSettleAmount() {
        return bussinessSettleAmount;
    }

    public void setBussinessSettleAmount(Long bussinessSettleAmount) {
        this.bussinessSettleAmount = bussinessSettleAmount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", myId=").append(myId);
        sb.append(", myType=").append(myType);
        sb.append(", myCreateTime=").append(myCreateTime);
        sb.append(", myStatus=").append(myStatus);
        sb.append(", mchId=").append(mchId);
        sb.append(", mchName=").append(mchName);
        sb.append(", mchAccountId=").append(mchAccountId);
        sb.append(", createTime=").append(createTime);
        sb.append(", appId=").append(appId);
        sb.append(", appName=").append(appName);
        sb.append(", title=").append(title);
        sb.append(", status=").append(status);
        sb.append(", confirmTime=").append(confirmTime);
        sb.append(", revokeTime=").append(revokeTime);
        sb.append(", fromBillDate=").append(fromBillDate);
        sb.append(", toBillDate=").append(toBillDate);
        sb.append(", confirmComment=").append(confirmComment);
        sb.append(", revokeComment=").append(revokeComment);
        sb.append(", confirmStatus=").append(confirmStatus);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", errorMsg=").append(errorMsg);
        sb.append(", tradeTotal=").append(tradeTotal);
        sb.append(", tradeTotalAmount=").append(tradeTotalAmount);
        sb.append(", tradeReceiptAmount=").append(tradeReceiptAmount);
        sb.append(", tradeBussinessReceiptAmount=").append(tradeBussinessReceiptAmount);
        sb.append(", tradeFeeAmount=").append(tradeFeeAmount);
        sb.append(", depositName=").append(depositName);
        sb.append(", depositBank=").append(depositBank);
        sb.append(", bankAccount=").append(bankAccount);
        sb.append(", tradeRefundTotal=").append(tradeRefundTotal);
        sb.append(", tradeRefundFee=").append(tradeRefundFee);
        sb.append(", bussinessSettleAmount=").append(bussinessSettleAmount);
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
        PaySettlementInfo other = (PaySettlementInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMyId() == null ? other.getMyId() == null : this.getMyId().equals(other.getMyId()))
            && (this.getMyType() == null ? other.getMyType() == null : this.getMyType().equals(other.getMyType()))
            && (this.getMyCreateTime() == null ? other.getMyCreateTime() == null : this.getMyCreateTime().equals(other.getMyCreateTime()))
            && (this.getMyStatus() == null ? other.getMyStatus() == null : this.getMyStatus().equals(other.getMyStatus()))
            && (this.getMchId() == null ? other.getMchId() == null : this.getMchId().equals(other.getMchId()))
            && (this.getMchName() == null ? other.getMchName() == null : this.getMchName().equals(other.getMchName()))
            && (this.getMchAccountId() == null ? other.getMchAccountId() == null : this.getMchAccountId().equals(other.getMchAccountId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getAppId() == null ? other.getAppId() == null : this.getAppId().equals(other.getAppId()))
            && (this.getAppName() == null ? other.getAppName() == null : this.getAppName().equals(other.getAppName()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getConfirmTime() == null ? other.getConfirmTime() == null : this.getConfirmTime().equals(other.getConfirmTime()))
            && (this.getRevokeTime() == null ? other.getRevokeTime() == null : this.getRevokeTime().equals(other.getRevokeTime()))
            && (this.getFromBillDate() == null ? other.getFromBillDate() == null : this.getFromBillDate().equals(other.getFromBillDate()))
            && (this.getToBillDate() == null ? other.getToBillDate() == null : this.getToBillDate().equals(other.getToBillDate()))
            && (this.getConfirmComment() == null ? other.getConfirmComment() == null : this.getConfirmComment().equals(other.getConfirmComment()))
            && (this.getRevokeComment() == null ? other.getRevokeComment() == null : this.getRevokeComment().equals(other.getRevokeComment()))
            && (this.getConfirmStatus() == null ? other.getConfirmStatus() == null : this.getConfirmStatus().equals(other.getConfirmStatus()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getErrorMsg() == null ? other.getErrorMsg() == null : this.getErrorMsg().equals(other.getErrorMsg()))
            && (this.getTradeTotal() == null ? other.getTradeTotal() == null : this.getTradeTotal().equals(other.getTradeTotal()))
            && (this.getTradeTotalAmount() == null ? other.getTradeTotalAmount() == null : this.getTradeTotalAmount().equals(other.getTradeTotalAmount()))
            && (this.getTradeReceiptAmount() == null ? other.getTradeReceiptAmount() == null : this.getTradeReceiptAmount().equals(other.getTradeReceiptAmount()))
            && (this.getTradeBussinessReceiptAmount() == null ? other.getTradeBussinessReceiptAmount() == null : this.getTradeBussinessReceiptAmount().equals(other.getTradeBussinessReceiptAmount()))
            && (this.getTradeFeeAmount() == null ? other.getTradeFeeAmount() == null : this.getTradeFeeAmount().equals(other.getTradeFeeAmount()))
            && (this.getDepositName() == null ? other.getDepositName() == null : this.getDepositName().equals(other.getDepositName()))
            && (this.getDepositBank() == null ? other.getDepositBank() == null : this.getDepositBank().equals(other.getDepositBank()))
            && (this.getBankAccount() == null ? other.getBankAccount() == null : this.getBankAccount().equals(other.getBankAccount()))
            && (this.getTradeRefundTotal() == null ? other.getTradeRefundTotal() == null : this.getTradeRefundTotal().equals(other.getTradeRefundTotal()))
            && (this.getTradeRefundFee() == null ? other.getTradeRefundFee() == null : this.getTradeRefundFee().equals(other.getTradeRefundFee()))
            && (this.getBussinessSettleAmount() == null ? other.getBussinessSettleAmount() == null : this.getBussinessSettleAmount().equals(other.getBussinessSettleAmount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMyId() == null) ? 0 : getMyId().hashCode());
        result = prime * result + ((getMyType() == null) ? 0 : getMyType().hashCode());
        result = prime * result + ((getMyCreateTime() == null) ? 0 : getMyCreateTime().hashCode());
        result = prime * result + ((getMyStatus() == null) ? 0 : getMyStatus().hashCode());
        result = prime * result + ((getMchId() == null) ? 0 : getMchId().hashCode());
        result = prime * result + ((getMchName() == null) ? 0 : getMchName().hashCode());
        result = prime * result + ((getMchAccountId() == null) ? 0 : getMchAccountId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getAppId() == null) ? 0 : getAppId().hashCode());
        result = prime * result + ((getAppName() == null) ? 0 : getAppName().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getConfirmTime() == null) ? 0 : getConfirmTime().hashCode());
        result = prime * result + ((getRevokeTime() == null) ? 0 : getRevokeTime().hashCode());
        result = prime * result + ((getFromBillDate() == null) ? 0 : getFromBillDate().hashCode());
        result = prime * result + ((getToBillDate() == null) ? 0 : getToBillDate().hashCode());
        result = prime * result + ((getConfirmComment() == null) ? 0 : getConfirmComment().hashCode());
        result = prime * result + ((getRevokeComment() == null) ? 0 : getRevokeComment().hashCode());
        result = prime * result + ((getConfirmStatus() == null) ? 0 : getConfirmStatus().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getErrorMsg() == null) ? 0 : getErrorMsg().hashCode());
        result = prime * result + ((getTradeTotal() == null) ? 0 : getTradeTotal().hashCode());
        result = prime * result + ((getTradeTotalAmount() == null) ? 0 : getTradeTotalAmount().hashCode());
        result = prime * result + ((getTradeReceiptAmount() == null) ? 0 : getTradeReceiptAmount().hashCode());
        result = prime * result + ((getTradeBussinessReceiptAmount() == null) ? 0 : getTradeBussinessReceiptAmount().hashCode());
        result = prime * result + ((getTradeFeeAmount() == null) ? 0 : getTradeFeeAmount().hashCode());
        result = prime * result + ((getDepositName() == null) ? 0 : getDepositName().hashCode());
        result = prime * result + ((getDepositBank() == null) ? 0 : getDepositBank().hashCode());
        result = prime * result + ((getBankAccount() == null) ? 0 : getBankAccount().hashCode());
        result = prime * result + ((getTradeRefundTotal() == null) ? 0 : getTradeRefundTotal().hashCode());
        result = prime * result + ((getTradeRefundFee() == null) ? 0 : getTradeRefundFee().hashCode());
        result = prime * result + ((getBussinessSettleAmount() == null) ? 0 : getBussinessSettleAmount().hashCode());
        return result;
    }
}