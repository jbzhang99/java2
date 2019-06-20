package com.rfchina.community.persistence.model.ext;

import java.math.BigDecimal;
import java.util.Date;

public class TaskOrder {
    private Long id;
    private String outTradeNo;
    private BigDecimal totalAmount;
    private int refundStatus;
    private Date billFinishedTime;

    public Date getBillFinishedTime() {
        return billFinishedTime;
    }

    public void setBillFinishedTime(Date billFinishedTime) {
        this.billFinishedTime = billFinishedTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(int refundStatus) {
        this.refundStatus = refundStatus;
    }
}
