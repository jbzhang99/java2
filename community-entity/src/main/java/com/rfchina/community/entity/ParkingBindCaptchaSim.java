package com.rfchina.community.entity;

import java.io.Serializable;

/**
 */
public class ParkingBindCaptchaSim implements Serializable {

    private Integer status;

    private String salt;

    private String token;

    private String message;

    public ParkingBindCaptchaSim(Integer status, String salt, String token, String message) {
        this.status = status;
        this.salt = salt;
        this.token = token;
        this.message = message;
    }

    public ParkingBindCaptchaSim() {

    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
