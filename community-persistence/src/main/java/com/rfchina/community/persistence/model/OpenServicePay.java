package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class OpenServicePay implements Serializable {
    private Integer serviceId;

    private BigDecimal platformFee;

    private BigDecimal thinkRate;

    private BigDecimal communityRate;

    private static final long serialVersionUID = 1L;

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public BigDecimal getPlatformFee() {
        return platformFee;
    }

    public void setPlatformFee(BigDecimal platformFee) {
        this.platformFee = platformFee;
    }

    public BigDecimal getThinkRate() {
        return thinkRate;
    }

    public void setThinkRate(BigDecimal thinkRate) {
        this.thinkRate = thinkRate;
    }

    public BigDecimal getCommunityRate() {
        return communityRate;
    }

    public void setCommunityRate(BigDecimal communityRate) {
        this.communityRate = communityRate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serviceId=").append(serviceId);
        sb.append(", platformFee=").append(platformFee);
        sb.append(", thinkRate=").append(thinkRate);
        sb.append(", communityRate=").append(communityRate);
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
        OpenServicePay other = (OpenServicePay) that;
        return (this.getServiceId() == null ? other.getServiceId() == null : this.getServiceId().equals(other.getServiceId()))
            && (this.getPlatformFee() == null ? other.getPlatformFee() == null : this.getPlatformFee().equals(other.getPlatformFee()))
            && (this.getThinkRate() == null ? other.getThinkRate() == null : this.getThinkRate().equals(other.getThinkRate()))
            && (this.getCommunityRate() == null ? other.getCommunityRate() == null : this.getCommunityRate().equals(other.getCommunityRate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getServiceId() == null) ? 0 : getServiceId().hashCode());
        result = prime * result + ((getPlatformFee() == null) ? 0 : getPlatformFee().hashCode());
        result = prime * result + ((getThinkRate() == null) ? 0 : getThinkRate().hashCode());
        result = prime * result + ((getCommunityRate() == null) ? 0 : getCommunityRate().hashCode());
        return result;
    }
}