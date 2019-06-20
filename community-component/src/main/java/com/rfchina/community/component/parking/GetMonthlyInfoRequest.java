package com.rfchina.community.component.parking;

import java.util.HashMap;
import java.util.Map;

/**
 */
public class GetMonthlyInfoRequest extends AbstractParkingRequest {

    private String parkingCode;

    private String carPlateNo;

    private String cardNo;

    private String mobile;

    public GetMonthlyInfoRequest(String parkingCode, String carPlateNo, String cardNo, String mobile) {
        this.parkingCode = parkingCode;
        this.carPlateNo = carPlateNo;
        this.cardNo = cardNo;
        this.mobile = mobile;
    }

    public GetMonthlyInfoRequest() {

    }

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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public Map<String, String> toMap() {
        Map<String, String> map = super.toMap();
        map.put("parkingCode", this.parkingCode);
        map.put("carPlateNo", this.carPlateNo);
        map.put("cardNo", this.cardNo);
        map.put("mobile", this.mobile);
        return map;
    }
}
