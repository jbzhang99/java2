package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class PaySettlementDetail implements Serializable {
    private Long myId;

    private Date myCreateTime;

    private Integer myCompare;

    private Long id;

    private String sid;

    private String billId;

    private String accountId;

    private String mchId;

    private Long appId;

    private String subject;

    private String outTradeNo;

    private String cmpOutTradeNo;

    private Long totalAmount;

    private Long receiptAmount;

    private Long feeAmount;

    private Long cmpTotalAmount;

    private Long cmpReceiptAmount;

    private Long cmpFeeAmount;

    private Long cmpRefundFee;

    private Date billCreateTime;

    private Date createTime;

    private Integer status;

    private Integer payChannelId;

    private String payChannel;

    private Integer balanceStatus;

    private Integer bussinessBalanceStatus;

    private String tradeType;

    private Integer refundStatus;

    private String body;

    private static final long serialVersionUID = 1L;

    public Long getMyId() {
        return myId;
    }

    public void setMyId(Long myId) {
        this.myId = myId;
    }

    public Date getMyCreateTime() {
        return myCreateTime;
    }

    public void setMyCreateTime(Date myCreateTime) {
        this.myCreateTime = myCreateTime;
    }

    public Integer getMyCompare() {
        return myCompare;
    }

    public void setMyCompare(Integer myCompare) {
        this.myCompare = myCompare;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getCmpOutTradeNo() {
        return cmpOutTradeNo;
    }

    public void setCmpOutTradeNo(String cmpOutTradeNo) {
        this.cmpOutTradeNo = cmpOutTradeNo;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptAmount(Long receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    public Long getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(Long feeAmount) {
        this.feeAmount = feeAmount;
    }

    public Long getCmpTotalAmount() {
        return cmpTotalAmount;
    }

    public void setCmpTotalAmount(Long cmpTotalAmount) {
        this.cmpTotalAmount = cmpTotalAmount;
    }

    public Long getCmpReceiptAmount() {
        return cmpReceiptAmount;
    }

    public void setCmpReceiptAmount(Long cmpReceiptAmount) {
        this.cmpReceiptAmount = cmpReceiptAmount;
    }

    public Long getCmpFeeAmount() {
        return cmpFeeAmount;
    }

    public void setCmpFeeAmount(Long cmpFeeAmount) {
        this.cmpFeeAmount = cmpFeeAmount;
    }

    public Long getCmpRefundFee() {
        return cmpRefundFee;
    }

    public void setCmpRefundFee(Long cmpRefundFee) {
        this.cmpRefundFee = cmpRefundFee;
    }

    public Date getBillCreateTime() {
        return billCreateTime;
    }

    public void setBillCreateTime(Date billCreateTime) {
        this.billCreateTime = billCreateTime;
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

    public Integer getPayChannelId() {
        return payChannelId;
    }

    public void setPayChannelId(Integer payChannelId) {
        this.payChannelId = payChannelId;
    }

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }

    public Integer getBalanceStatus() {
        return balanceStatus;
    }

    public void setBalanceStatus(Integer balanceStatus) {
        this.balanceStatus = balanceStatus;
    }

    public Integer getBussinessBalanceStatus() {
        return bussinessBalanceStatus;
    }

    public void setBussinessBalanceStatus(Integer bussinessBalanceStatus) {
        this.bussinessBalanceStatus = bussinessBalanceStatus;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", myId=").append(myId);
        sb.append(", myCreateTime=").append(myCreateTime);
        sb.append(", myCompare=").append(myCompare);
        sb.append(", id=").append(id);
        sb.append(", sid=").append(sid);
        sb.append(", billId=").append(billId);
        sb.append(", accountId=").append(accountId);
        sb.append(", mchId=").append(mchId);
        sb.append(", appId=").append(appId);
        sb.append(", subject=").append(subject);
        sb.append(", outTradeNo=").append(outTradeNo);
        sb.append(", cmpOutTradeNo=").append(cmpOutTradeNo);
        sb.append(", totalAmount=").append(totalAmount);
        sb.append(", receiptAmount=").append(receiptAmount);
        sb.append(", feeAmount=").append(feeAmount);
        sb.append(", cmpTotalAmount=").append(cmpTotalAmount);
        sb.append(", cmpReceiptAmount=").append(cmpReceiptAmount);
        sb.append(", cmpFeeAmount=").append(cmpFeeAmount);
        sb.append(", cmpRefundFee=").append(cmpRefundFee);
        sb.append(", billCreateTime=").append(billCreateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", status=").append(status);
        sb.append(", payChannelId=").append(payChannelId);
        sb.append(", payChannel=").append(payChannel);
        sb.append(", balanceStatus=").append(balanceStatus);
        sb.append(", bussinessBalanceStatus=").append(bussinessBalanceStatus);
        sb.append(", tradeType=").append(tradeType);
        sb.append(", refundStatus=").append(refundStatus);
        sb.append(", body=").append(body);
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
        PaySettlementDetail other = (PaySettlementDetail) that;
        return (this.getMyId() == null ? other.getMyId() == null : this.getMyId().equals(other.getMyId()))
            && (this.getMyCreateTime() == null ? other.getMyCreateTime() == null : this.getMyCreateTime().equals(other.getMyCreateTime()))
            && (this.getMyCompare() == null ? other.getMyCompare() == null : this.getMyCompare().equals(other.getMyCompare()))
            && (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSid() == null ? other.getSid() == null : this.getSid().equals(other.getSid()))
            && (this.getBillId() == null ? other.getBillId() == null : this.getBillId().equals(other.getBillId()))
            && (this.getAccountId() == null ? other.getAccountId() == null : this.getAccountId().equals(other.getAccountId()))
            && (this.getMchId() == null ? other.getMchId() == null : this.getMchId().equals(other.getMchId()))
            && (this.getAppId() == null ? other.getAppId() == null : this.getAppId().equals(other.getAppId()))
            && (this.getSubject() == null ? other.getSubject() == null : this.getSubject().equals(other.getSubject()))
            && (this.getOutTradeNo() == null ? other.getOutTradeNo() == null : this.getOutTradeNo().equals(other.getOutTradeNo()))
            && (this.getCmpOutTradeNo() == null ? other.getCmpOutTradeNo() == null : this.getCmpOutTradeNo().equals(other.getCmpOutTradeNo()))
            && (this.getTotalAmount() == null ? other.getTotalAmount() == null : this.getTotalAmount().equals(other.getTotalAmount()))
            && (this.getReceiptAmount() == null ? other.getReceiptAmount() == null : this.getReceiptAmount().equals(other.getReceiptAmount()))
            && (this.getFeeAmount() == null ? other.getFeeAmount() == null : this.getFeeAmount().equals(other.getFeeAmount()))
            && (this.getCmpTotalAmount() == null ? other.getCmpTotalAmount() == null : this.getCmpTotalAmount().equals(other.getCmpTotalAmount()))
            && (this.getCmpReceiptAmount() == null ? other.getCmpReceiptAmount() == null : this.getCmpReceiptAmount().equals(other.getCmpReceiptAmount()))
            && (this.getCmpFeeAmount() == null ? other.getCmpFeeAmount() == null : this.getCmpFeeAmount().equals(other.getCmpFeeAmount()))
            && (this.getCmpRefundFee() == null ? other.getCmpRefundFee() == null : this.getCmpRefundFee().equals(other.getCmpRefundFee()))
            && (this.getBillCreateTime() == null ? other.getBillCreateTime() == null : this.getBillCreateTime().equals(other.getBillCreateTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getPayChannelId() == null ? other.getPayChannelId() == null : this.getPayChannelId().equals(other.getPayChannelId()))
            && (this.getPayChannel() == null ? other.getPayChannel() == null : this.getPayChannel().equals(other.getPayChannel()))
            && (this.getBalanceStatus() == null ? other.getBalanceStatus() == null : this.getBalanceStatus().equals(other.getBalanceStatus()))
            && (this.getBussinessBalanceStatus() == null ? other.getBussinessBalanceStatus() == null : this.getBussinessBalanceStatus().equals(other.getBussinessBalanceStatus()))
            && (this.getTradeType() == null ? other.getTradeType() == null : this.getTradeType().equals(other.getTradeType()))
            && (this.getRefundStatus() == null ? other.getRefundStatus() == null : this.getRefundStatus().equals(other.getRefundStatus()))
            && (this.getBody() == null ? other.getBody() == null : this.getBody().equals(other.getBody()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMyId() == null) ? 0 : getMyId().hashCode());
        result = prime * result + ((getMyCreateTime() == null) ? 0 : getMyCreateTime().hashCode());
        result = prime * result + ((getMyCompare() == null) ? 0 : getMyCompare().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSid() == null) ? 0 : getSid().hashCode());
        result = prime * result + ((getBillId() == null) ? 0 : getBillId().hashCode());
        result = prime * result + ((getAccountId() == null) ? 0 : getAccountId().hashCode());
        result = prime * result + ((getMchId() == null) ? 0 : getMchId().hashCode());
        result = prime * result + ((getAppId() == null) ? 0 : getAppId().hashCode());
        result = prime * result + ((getSubject() == null) ? 0 : getSubject().hashCode());
        result = prime * result + ((getOutTradeNo() == null) ? 0 : getOutTradeNo().hashCode());
        result = prime * result + ((getCmpOutTradeNo() == null) ? 0 : getCmpOutTradeNo().hashCode());
        result = prime * result + ((getTotalAmount() == null) ? 0 : getTotalAmount().hashCode());
        result = prime * result + ((getReceiptAmount() == null) ? 0 : getReceiptAmount().hashCode());
        result = prime * result + ((getFeeAmount() == null) ? 0 : getFeeAmount().hashCode());
        result = prime * result + ((getCmpTotalAmount() == null) ? 0 : getCmpTotalAmount().hashCode());
        result = prime * result + ((getCmpReceiptAmount() == null) ? 0 : getCmpReceiptAmount().hashCode());
        result = prime * result + ((getCmpFeeAmount() == null) ? 0 : getCmpFeeAmount().hashCode());
        result = prime * result + ((getCmpRefundFee() == null) ? 0 : getCmpRefundFee().hashCode());
        result = prime * result + ((getBillCreateTime() == null) ? 0 : getBillCreateTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getPayChannelId() == null) ? 0 : getPayChannelId().hashCode());
        result = prime * result + ((getPayChannel() == null) ? 0 : getPayChannel().hashCode());
        result = prime * result + ((getBalanceStatus() == null) ? 0 : getBalanceStatus().hashCode());
        result = prime * result + ((getBussinessBalanceStatus() == null) ? 0 : getBussinessBalanceStatus().hashCode());
        result = prime * result + ((getTradeType() == null) ? 0 : getTradeType().hashCode());
        result = prime * result + ((getRefundStatus() == null) ? 0 : getRefundStatus().hashCode());
        result = prime * result + ((getBody() == null) ? 0 : getBody().hashCode());
        return result;
    }
}