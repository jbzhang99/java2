package com.rfchina.community.persistence.model.ext;

import java.math.BigDecimal;

public class TaskOrderStat {
    private BigDecimal totalAmount;
    private BigDecimal refundAmount;
    private BigDecimal noRefundAmount;
    private int orderAmount;

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public BigDecimal getNoRefundAmount() {
        return noRefundAmount;
    }

    public void setNoRefundAmount(BigDecimal noRefundAmount) {
        this.noRefundAmount = noRefundAmount;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    @Override
    public String toString() {
        return "TaskOrderStat{" +
                "totalAmount=" + totalAmount +
                ", refundAmount=" + refundAmount +
                ", noRefundAmount=" + noRefundAmount +
                ", orderAmount=" + orderAmount +
                '}';
    }
}
