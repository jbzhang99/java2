package com.rfchina.community.component.parking;

import java.util.HashMap;
import java.util.Map;

/**
 */
public class GetRealTimeRequest extends AbstractParkingRequest {

    private String parkingCode;

    public String getParkingCode() {
        return parkingCode;
    }

    public void setParkingCode(String parkingCode) {
        this.parkingCode = parkingCode;
    }

    @Override
    public Map<String, String> toMap() {
        Map<String, String> map = super.toMap();
        map.put("parkingCode", this.parkingCode);
        return map;
    }
}
