package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class OpenQuickOrderPay implements Serializable {
    private String outTradeNo;

    private Long quickId;

    private String communityTradeNo;

    private String billId;

    private Date createTime;

    private Integer status;

    private String payChannel;

    private String tradeType;

    private Date successTime;

    private static final long serialVersionUID = 1L;

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public Long getQuickId() {
        return quickId;
    }

    public void setQuickId(Long quickId) {
        this.quickId = quickId;
    }

    public String getCommunityTradeNo() {
        return communityTradeNo;
    }

    public void setCommunityTradeNo(String communityTradeNo) {
        this.communityTradeNo = communityTradeNo;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
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

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public Date getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(Date successTime) {
        this.successTime = successTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", outTradeNo=").append(outTradeNo);
        sb.append(", quickId=").append(quickId);
        sb.append(", communityTradeNo=").append(communityTradeNo);
        sb.append(", billId=").append(billId);
        sb.append(", createTime=").append(createTime);
        sb.append(", status=").append(status);
        sb.append(", payChannel=").append(payChannel);
        sb.append(", tradeType=").append(tradeType);
        sb.append(", successTime=").append(successTime);
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
        OpenQuickOrderPay other = (OpenQuickOrderPay) that;
        return (this.getOutTradeNo() == null ? other.getOutTradeNo() == null : this.getOutTradeNo().equals(other.getOutTradeNo()))
            && (this.getQuickId() == null ? other.getQuickId() == null : this.getQuickId().equals(other.getQuickId()))
            && (this.getCommunityTradeNo() == null ? other.getCommunityTradeNo() == null : this.getCommunityTradeNo().equals(other.getCommunityTradeNo()))
            && (this.getBillId() == null ? other.getBillId() == null : this.getBillId().equals(other.getBillId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getPayChannel() == null ? other.getPayChannel() == null : this.getPayChannel().equals(other.getPayChannel()))
            && (this.getTradeType() == null ? other.getTradeType() == null : this.getTradeType().equals(other.getTradeType()))
            && (this.getSuccessTime() == null ? other.getSuccessTime() == null : this.getSuccessTime().equals(other.getSuccessTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOutTradeNo() == null) ? 0 : getOutTradeNo().hashCode());
        result = prime * result + ((getQuickId() == null) ? 0 : getQuickId().hashCode());
        result = prime * result + ((getCommunityTradeNo() == null) ? 0 : getCommunityTradeNo().hashCode());
        result = prime * result + ((getBillId() == null) ? 0 : getBillId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getPayChannel() == null) ? 0 : getPayChannel().hashCode());
        result = prime * result + ((getTradeType() == null) ? 0 : getTradeType().hashCode());
        result = prime * result + ((getSuccessTime() == null) ? 0 : getSuccessTime().hashCode());
        return result;
    }
}