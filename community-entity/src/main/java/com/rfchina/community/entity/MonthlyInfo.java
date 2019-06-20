package com.rfchina.community.entity;

import java.io.Serializable;

/**
 */
public class MonthlyInfo implements Serializable {

    private String carPlateNo;

    private String cardNo;

    private String mobile;

    private String expireTime;

    private Long remainingDays;

    public String getCarPlateNo() {
        return carPlateNo;
    }

    public void setCarPlateNo(String carPlateNo) {
        this.carPlateNo = carPlateNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public Long getRemainingDays() {
        return remainingDays;
    }

    public void setRemainingDays(Long remainingDays) {
        this.remainingDays = remainingDays;
    }

    @Override
    public String toString() {
        return "MonthlyInfo{" +
                "carPlateNo='" + carPlateNo + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", mobile='" + mobile + '\'' +
                ", expireTime='" + expireTime + '\'' +
                ", remainingDays=" + remainingDays +
                '}';
    }
}
