package com.rfchina.community.entity.wo;

import java.io.Serializable;

/**
 */
public class BusinessCancelReq implements Serializable {

    private String orderNo;

    private String tskCode;

    private String cancelDesc;

    private String cancelUser;

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

    public String getCancelDesc() {
        return cancelDesc;
    }

    public void setCancelDesc(String cancelDesc) {
        this.cancelDesc = cancelDesc;
    }

    public String getCancelUser() {
        return cancelUser;
    }

    public void setCancelUser(String cancelUser) {
        this.cancelUser = cancelUser;
    }

    @Override
    public String toString() {
        return "BusinessCancelReq{" +
                "orderNo='" + orderNo + '\'' +
                ", tskCode='" + tskCode + '\'' +
                ", cancelDesc='" + cancelDesc + '\'' +
                ", cancelUser='" + cancelUser + '\'' +
                '}';
    }
}
