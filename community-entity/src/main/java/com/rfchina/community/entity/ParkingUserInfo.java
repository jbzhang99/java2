package com.rfchina.community.entity;

import java.io.Serializable;

/**
 */
public class ParkingUserInfo implements Serializable {

    private String carPlateNo;

    private String mobile;

    private String realname;

    public String getCarPlateNo() {
        return carPlateNo;
    }

    public void setCarPlateNo(String carPlateNo) {
        this.carPlateNo = carPlateNo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    @Override
    public String toString() {
        return "ParkingUserInfo{" +
                "carPlateNo='" + carPlateNo + '\'' +
                ", mobile='" + mobile + '\'' +
                ", realname='" + realname + '\'' +
                '}';
    }
}
