package com.rfchina.community.brothers.entity;

import java.util.List;

public class SettleConfirm {
    private String bill_id;
    private int type;

    private List<SettleConfirm> refund_bill_list;

    public List<SettleConfirm> getRefund_bill_list() {
        return refund_bill_list;
    }

    public void setRefund_bill_list(List<SettleConfirm> refund_bill_list) {
        this.refund_bill_list = refund_bill_list;
    }

    public String getBill_id() {
        return bill_id;
    }

    public void setBill_id(String bill_id) {
        this.bill_id = bill_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "SettleConfirm{" +
                "bill_id='" + bill_id + '\'' +
                ", type=" + type +
                '}';
    }
}
