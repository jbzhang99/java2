package com.rfchina.community.entity.wo;

import java.io.Serializable;

/**
 */
public class ClientGetCusTaskDetailReq implements Serializable {

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientGetCusTaskDetailReq that = (ClientGetCusTaskDetailReq) o;

        if (orderNo != null ? !orderNo.equals(that.orderNo) : that.orderNo != null) return false;
        return tskCode != null ? tskCode.equals(that.tskCode) : that.tskCode == null;

    }

    @Override
    public int hashCode() {
        int result = orderNo != null ? orderNo.hashCode() : 0;
        result = 31 * result + (tskCode != null ? tskCode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ClientGetCusTaskDetailReq{" +
                "orderNo='" + orderNo + '\'' +
                ", tskCode='" + tskCode + '\'' +
                '}';
    }
}
