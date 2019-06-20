package com.rfchina.community.component.parking;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 */
public abstract class AbstractParkingRequest implements Serializable {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        map.put("token", this.token);
        return map;
    }
}
