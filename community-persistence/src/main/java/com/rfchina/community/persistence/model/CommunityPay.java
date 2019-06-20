package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class CommunityPay implements Serializable {
    private Integer id;

    private String payAccount;

    private String merchantId;

    private String openPayAccount;

    private String openMerchantId;

    private BigDecimal feeRate;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getOpenPayAccount() {
        return openPayAccount;
    }

    public void setOpenPayAccount(String openPayAccount) {
        this.openPayAccount = openPayAccount;
    }

    public String getOpenMerchantId() {
        return openMerchantId;
    }

    public void setOpenMerchantId(String openMerchantId) {
        this.openMerchantId = openMerchantId;
    }

    public BigDecimal getFeeRate() {
        return feeRate;
    }

    public void setFeeRate(BigDecimal feeRate) {
        this.feeRate = feeRate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", payAccount=").append(payAccount);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", openPayAccount=").append(openPayAccount);
        sb.append(", openMerchantId=").append(openMerchantId);
        sb.append(", feeRate=").append(feeRate);
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
        CommunityPay other = (CommunityPay) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPayAccount() == null ? other.getPayAccount() == null : this.getPayAccount().equals(other.getPayAccount()))
            && (this.getMerchantId() == null ? other.getMerchantId() == null : this.getMerchantId().equals(other.getMerchantId()))
            && (this.getOpenPayAccount() == null ? other.getOpenPayAccount() == null : this.getOpenPayAccount().equals(other.getOpenPayAccount()))
            && (this.getOpenMerchantId() == null ? other.getOpenMerchantId() == null : this.getOpenMerchantId().equals(other.getOpenMerchantId()))
            && (this.getFeeRate() == null ? other.getFeeRate() == null : this.getFeeRate().equals(other.getFeeRate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPayAccount() == null) ? 0 : getPayAccount().hashCode());
        result = prime * result + ((getMerchantId() == null) ? 0 : getMerchantId().hashCode());
        result = prime * result + ((getOpenPayAccount() == null) ? 0 : getOpenPayAccount().hashCode());
        result = prime * result + ((getOpenMerchantId() == null) ? 0 : getOpenMerchantId().hashCode());
        result = prime * result + ((getFeeRate() == null) ? 0 : getFeeRate().hashCode());
        return result;
    }
}