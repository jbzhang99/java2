package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OpenStatsOrder extends OpenStatsOrderKey implements Serializable {
    private Integer statWreek;

    private Integer statMonth;

    private Integer orderCount;

    private BigDecimal totalAmount;

    private Integer orderCountTotal;

    private BigDecimal totalAmountTotal;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getStatWreek() {
        return statWreek;
    }

    public void setStatWreek(Integer statWreek) {
        this.statWreek = statWreek;
    }

    public Integer getStatMonth() {
        return statMonth;
    }

    public void setStatMonth(Integer statMonth) {
        this.statMonth = statMonth;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getOrderCountTotal() {
        return orderCountTotal;
    }

    public void setOrderCountTotal(Integer orderCountTotal) {
        this.orderCountTotal = orderCountTotal;
    }

    public BigDecimal getTotalAmountTotal() {
        return totalAmountTotal;
    }

    public void setTotalAmountTotal(BigDecimal totalAmountTotal) {
        this.totalAmountTotal = totalAmountTotal;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", statWreek=").append(statWreek);
        sb.append(", statMonth=").append(statMonth);
        sb.append(", orderCount=").append(orderCount);
        sb.append(", totalAmount=").append(totalAmount);
        sb.append(", orderCountTotal=").append(orderCountTotal);
        sb.append(", totalAmountTotal=").append(totalAmountTotal);
        sb.append(", createTime=").append(createTime);
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
        OpenStatsOrder other = (OpenStatsOrder) that;
        return (this.getStatDate() == null ? other.getStatDate() == null : this.getStatDate().equals(other.getStatDate()))
            && (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getServiceId() == null ? other.getServiceId() == null : this.getServiceId().equals(other.getServiceId()))
            && (this.getStatWreek() == null ? other.getStatWreek() == null : this.getStatWreek().equals(other.getStatWreek()))
            && (this.getStatMonth() == null ? other.getStatMonth() == null : this.getStatMonth().equals(other.getStatMonth()))
            && (this.getOrderCount() == null ? other.getOrderCount() == null : this.getOrderCount().equals(other.getOrderCount()))
            && (this.getTotalAmount() == null ? other.getTotalAmount() == null : this.getTotalAmount().equals(other.getTotalAmount()))
            && (this.getOrderCountTotal() == null ? other.getOrderCountTotal() == null : this.getOrderCountTotal().equals(other.getOrderCountTotal()))
            && (this.getTotalAmountTotal() == null ? other.getTotalAmountTotal() == null : this.getTotalAmountTotal().equals(other.getTotalAmountTotal()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStatDate() == null) ? 0 : getStatDate().hashCode());
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getServiceId() == null) ? 0 : getServiceId().hashCode());
        result = prime * result + ((getStatWreek() == null) ? 0 : getStatWreek().hashCode());
        result = prime * result + ((getStatMonth() == null) ? 0 : getStatMonth().hashCode());
        result = prime * result + ((getOrderCount() == null) ? 0 : getOrderCount().hashCode());
        result = prime * result + ((getTotalAmount() == null) ? 0 : getTotalAmount().hashCode());
        result = prime * result + ((getOrderCountTotal() == null) ? 0 : getOrderCountTotal().hashCode());
        result = prime * result + ((getTotalAmountTotal() == null) ? 0 : getTotalAmountTotal().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}