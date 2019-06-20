package com.rfchina.community.entity;

import java.io.Serializable;
import java.util.Date;

/**
 */
public class ParkingOrderFee implements Serializable {

    private String serialNo;

    private Integer queryType;

    private String carPlateNo;

    private String cardNo;

    private String payAmount;

    private String specialAmount;

    private String recAmount;

    private Long duration;

    private Long freeDuration;

    private String enterTime;

    private String parkingAddress;

    private Integer communityId;

    private String monthlyPrice;

    private String monthlyExpireDate;

    private Long monthlyRemainingDays;

    private Integer feeType;

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getCarPlateNo() {
        return carPlateNo;
    }

    public void setCarPlateNo(String carPlateNo) {
        this.carPlateNo = carPlateNo;
    }

    public String getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(String enterTime) {
        this.enterTime = enterTime;
    }

    public String getParkingAddress() {
        return parkingAddress;
    }

    public void setParkingAddress(String parkingAddress) {
        this.parkingAddress = parkingAddress;
    }

    public Integer getQueryType() {
        return queryType;
    }

    public void setQueryType(Integer queryType) {
        this.queryType = queryType;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getSpecialAmount() {
        return specialAmount;
    }

    public void setSpecialAmount(String specialAmount) {
        this.specialAmount = specialAmount;
    }

    public String getRecAmount() {
        return recAmount;
    }

    public void setRecAmount(String recAmount) {
        this.recAmount = recAmount;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public String getMonthlyPrice() {
        return monthlyPrice;
    }

    public void setMonthlyPrice(String monthlyPrice) {
        this.monthlyPrice = monthlyPrice;
    }

    public Integer getFeeType() {
        return feeType;
    }

    public void setFeeType(Integer feeType) {
        this.feeType = feeType;
    }

    public String getMonthlyExpireDate() {
        return monthlyExpireDate;
    }

    public void setMonthlyExpireDate(String monthlyExpireDate) {
        this.monthlyExpireDate = monthlyExpireDate;
    }

    public Long getMonthlyRemainingDays() {
        return monthlyRemainingDays;
    }

    public void setMonthlyRemainingDays(Long monthlyRemainingDays) {
        this.monthlyRemainingDays = monthlyRemainingDays;
    }

    public Long getFreeDuration() {
        return freeDuration;
    }

    public void setFreeDuration(Long freeDuration) {
        this.freeDuration = freeDuration;
    }
}
