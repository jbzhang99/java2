package com.rfchina.community.entity.wo;

import java.io.Serializable;

/**
 */
public class GetBusinessStateReq implements Serializable {

    private String orderNo;

    private String tskCode;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getTskCode() {
        return tskCode;
    }

    public void setTskCode(String tskCode) {
        this.tskCode = tskCode;
    }

    @Override
    public String toString() {
        return "GetBusinessStateReq{" +
                "orderNo='" + orderNo + '\'' +
                ", tskCode='" + tskCode + '\'' +
                '}';
    }
}
