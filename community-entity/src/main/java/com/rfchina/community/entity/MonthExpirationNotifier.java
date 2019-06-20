package com.rfchina.community.entity;

import java.io.Serializable;
import java.util.List;

/**
 */
public class MonthExpirationNotifier implements Serializable {

    private String parkingCode;

    private List<MonthlyInfo> data;

    public String getParkingCode() {
        return parkingCode;
    }

    public void setParkingCode(String parkingCode) {
        this.parkingCode = parkingCode;
    }

    public List<MonthlyInfo> getData() {
        return data;
    }

    public void setData(List<MonthlyInfo> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MonthExpirationNotifier{" +
                "parkingCode='" + parkingCode + '\'' +
                ", data=" + data +
                '}';
    }
}
