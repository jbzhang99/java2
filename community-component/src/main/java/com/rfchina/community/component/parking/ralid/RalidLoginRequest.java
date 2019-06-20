package com.rfchina.community.component.parking.ralid;

import com.rfchina.community.component.parking.AbstractParkingRequest;

import java.util.HashMap;
import java.util.Map;

/**
 */
public class RalidLoginRequest extends AbstractParkingRequest {

    private String parkId;

    private String account;

    private String password;

    private String lway;

    public String getParkId() {
        return parkId;
    }

    public void setParkId(String parkId) {
        this.parkId = parkId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLway() {
        return lway;
    }

    public void setLway(String lway) {
        this.lway = lway;
    }

    @Override
    public String toString() {
        return "RalidLoginRequest{" +
                "parkId='" + parkId + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", lway='" + lway + '\'' +
                '}';
    }


    @Override
    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        map.put("parkId", this.parkId);
        map.put("account", this.account);
        map.put("password", this.password);
        map.put("lway", this.lway);
        return map;
    }
}
