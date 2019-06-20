package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class CmStoreCouponExtend implements Serializable {
    private Long cardItemId;

    private Integer serviceId;

    private Long merchantId;

    private BigDecimal limitMoney;

    private static final long serialVersionUID = 1L;

    public Long getCardItemId() {
        return cardItemId;
    }

    public void setCardItemId(Long cardItemId) {
        this.cardItemId = cardItemId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public BigDecimal getLimitMoney() {
        return limitMoney;
    }

    public void setLimitMoney(BigDecimal limitMoney) {
        this.limitMoney = limitMoney;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cardItemId=").append(cardItemId);
        sb.append(", serviceId=").append(serviceId);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", limitMoney=").append(limitMoney);
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
        CmStoreCouponExtend other = (CmStoreCouponExtend) that;
        return (this.getCardItemId() == null ? other.getCardItemId() == null : this.getCardItemId().equals(other.getCardItemId()))
            && (this.getServiceId() == null ? other.getServiceId() == null : this.getServiceId().equals(other.getServiceId()))
            && (this.getMerchantId() == null ? other.getMerchantId() == null : this.getMerchantId().equals(other.getMerchantId()))
            && (this.getLimitMoney() == null ? other.getLimitMoney() == null : this.getLimitMoney().equals(other.getLimitMoney()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCardItemId() == null) ? 0 : getCardItemId().hashCode());
        result = prime * result + ((getServiceId() == null) ? 0 : getServiceId().hashCode());
        result = prime * result + ((getMerchantId() == null) ? 0 : getMerchantId().hashCode());
        result = prime * result + ((getLimitMoney() == null) ? 0 : getLimitMoney().hashCode());
        return result;
    }
}