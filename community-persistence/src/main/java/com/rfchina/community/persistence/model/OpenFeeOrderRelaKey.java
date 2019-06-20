package com.rfchina.community.persistence.model;

import java.io.Serializable;

public class OpenFeeOrderRelaKey implements Serializable {
    private Long feeId;

    private Long payId;

    private static final long serialVersionUID = 1L;

    public Long getFeeId() {
        return feeId;
    }

    public void setFeeId(Long feeId) {
        this.feeId = feeId;
    }

    public Long getPayId() {
        return payId;
    }

    public void setPayId(Long payId) {
        this.payId = payId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", feeId=").append(feeId);
        sb.append(", payId=").append(payId);
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
        OpenFeeOrderRelaKey other = (OpenFeeOrderRelaKey) that;
        return (this.getFeeId() == null ? other.getFeeId() == null : this.getFeeId().equals(other.getFeeId()))
            && (this.getPayId() == null ? other.getPayId() == null : this.getPayId().equals(other.getPayId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFeeId() == null) ? 0 : getFeeId().hashCode());
        result = prime * result + ((getPayId() == null) ? 0 : getPayId().hashCode());
        return result;
    }
}