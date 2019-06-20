package com.rfchina.community.persistence.model;

import java.io.Serializable;

public class OpenFeeOrderWithBLOBs extends OpenFeeOrder implements Serializable {
    private String goodsDetail;

    private String salesContract;

    private static final long serialVersionUID = 1L;

    public String getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    public String getSalesContract() {
        return salesContract;
    }

    public void setSalesContract(String salesContract) {
        this.salesContract = salesContract;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", goodsDetail=").append(goodsDetail);
        sb.append(", salesContract=").append(salesContract);
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
        OpenFeeOrderWithBLOBs other = (OpenFeeOrderWithBLOBs) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getServiceId() == null ? other.getServiceId() == null : this.getServiceId().equals(other.getServiceId()))
            && (this.getVerifyNo() == null ? other.getVerifyNo() == null : this.getVerifyNo().equals(other.getVerifyNo()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
            && (this.getStoreOrderId() == null ? other.getStoreOrderId() == null : this.getStoreOrderId().equals(other.getStoreOrderId()))
            && (this.getTradeAmount() == null ? other.getTradeAmount() == null : this.getTradeAmount().equals(other.getTradeAmount()))
            && (this.getPlatformCharge() == null ? other.getPlatformCharge() == null : this.getPlatformCharge().equals(other.getPlatformCharge()))
            && (this.getPlatformChargeRate() == null ? other.getPlatformChargeRate() == null : this.getPlatformChargeRate().equals(other.getPlatformChargeRate()))
            && (this.getServiceCharge() == null ? other.getServiceCharge() == null : this.getServiceCharge().equals(other.getServiceCharge()))
            && (this.getServiceChargeRate() == null ? other.getServiceChargeRate() == null : this.getServiceChargeRate().equals(other.getServiceChargeRate()))
            && (this.getPayAmount() == null ? other.getPayAmount() == null : this.getPayAmount().equals(other.getPayAmount()))
            && (this.getPayId() == null ? other.getPayId() == null : this.getPayId().equals(other.getPayId()))
            && (this.getPayStatus() == null ? other.getPayStatus() == null : this.getPayStatus().equals(other.getPayStatus()))
            && (this.getPayTime() == null ? other.getPayTime() == null : this.getPayTime().equals(other.getPayTime()))
            && (this.getOrderExplain() == null ? other.getOrderExplain() == null : this.getOrderExplain().equals(other.getOrderExplain()))
            && (this.getGoodsDetail() == null ? other.getGoodsDetail() == null : this.getGoodsDetail().equals(other.getGoodsDetail()))
            && (this.getSalesContract() == null ? other.getSalesContract() == null : this.getSalesContract().equals(other.getSalesContract()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getServiceId() == null) ? 0 : getServiceId().hashCode());
        result = prime * result + ((getVerifyNo() == null) ? 0 : getVerifyNo().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getStoreOrderId() == null) ? 0 : getStoreOrderId().hashCode());
        result = prime * result + ((getTradeAmount() == null) ? 0 : getTradeAmount().hashCode());
        result = prime * result + ((getPlatformCharge() == null) ? 0 : getPlatformCharge().hashCode());
        result = prime * result + ((getPlatformChargeRate() == null) ? 0 : getPlatformChargeRate().hashCode());
        result = prime * result + ((getServiceCharge() == null) ? 0 : getServiceCharge().hashCode());
        result = prime * result + ((getServiceChargeRate() == null) ? 0 : getServiceChargeRate().hashCode());
        result = prime * result + ((getPayAmount() == null) ? 0 : getPayAmount().hashCode());
        result = prime * result + ((getPayId() == null) ? 0 : getPayId().hashCode());
        result = prime * result + ((getPayStatus() == null) ? 0 : getPayStatus().hashCode());
        result = prime * result + ((getPayTime() == null) ? 0 : getPayTime().hashCode());
        result = prime * result + ((getOrderExplain() == null) ? 0 : getOrderExplain().hashCode());
        result = prime * result + ((getGoodsDetail() == null) ? 0 : getGoodsDetail().hashCode());
        result = prime * result + ((getSalesContract() == null) ? 0 : getSalesContract().hashCode());
        return result;
    }
}