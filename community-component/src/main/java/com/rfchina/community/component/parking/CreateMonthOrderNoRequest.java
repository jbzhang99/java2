package com.rfchina.community.component.parking;

import java.util.HashMap;
import java.util.Map;

/**
 */
public class CreateMonthOrderNoRequest extends AbstractParkingRequest {

    private String parkingCode;

    private String carPlateNo;

    private String cardNo;

    public String getParkingCode() {
        return parkingCode;
    }

    public void setParkingCode(String parkingCode) {
        this.parkingCode = parkingCode;
    }

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

    @Override
    public String toString() {
        return "CreateMonthOrderNoRequest{" +
                "parkingCode='" + parkingCode + '\'' +
                ", carPlateNo='" + carPlateNo + '\'' +
                ", cardNo='" + cardNo + '\'' +
                '}';
    }

    @Override
    public Map<String, String> toMap() {
        Map<String, String> map = super.toMap();
        map.put("parkingCode", this.parkingCode);
        map.put("carPlateNo", this.carPlateNo);
        map.put("cardNo", this.cardNo);
        return map;
    }
}
