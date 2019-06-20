package com.rfchina.community.entity;

import java.io.Serializable;
import java.util.List;

/**
 */
public class TempFeeObject implements Serializable {

    private String chargeDate;

    private List<TempFeeItem> feeItemList;

    public String getChargeDate() {
        return chargeDate;
    }

    public void setChargeDate(String chargeDate) {
        this.chargeDate = chargeDate;
    }

    public List<TempFeeItem> getFeeItemList() {
        return feeItemList;
    }

    public void setFeeItemList(List<TempFeeItem> feeItemList) {
        this.feeItemList = feeItemList;
    }

    @Override
    public String toString() {
        return "TempFeeObject{" +
                "chargeDate='" + chargeDate + '\'' +
                ", feeItemList=" + feeItemList +
                '}';
    }
}
