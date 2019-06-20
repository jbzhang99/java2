package com.rfchina.community.entity;

import java.io.Serializable;

/**
 */
public class ParkingInfo implements Serializable {

    private String parkingAddress;

    private String parkingPriceUrl;

    public String getParkingAddress() {
        return parkingAddress;
    }

    public void setParkingAddress(String parkingAddress) {
        this.parkingAddress = parkingAddress;
    }

    public String getParkingPriceUrl() {
        return parkingPriceUrl;
    }

    public void setParkingPriceUrl(String parkingPriceUrl) {
        this.parkingPriceUrl = parkingPriceUrl;
    }
}
