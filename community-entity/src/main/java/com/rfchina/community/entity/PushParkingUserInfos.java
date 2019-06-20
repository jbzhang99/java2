package com.rfchina.community.entity;

import java.io.Serializable;
import java.util.List;

/**
 */
public class PushParkingUserInfos implements Serializable {

    private String parkingCode;

    private List<ParkingUserInfo> data;

    public String getParkingCode() {
        return parkingCode;
    }

    public void setParkingCode(String parkingCode) {
        this.parkingCode = parkingCode;
    }

    public List<ParkingUserInfo> getData() {
        return data;
    }

    public void setData(List<ParkingUserInfo> data) {
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
