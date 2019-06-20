package com.rfchina.community.entity;

import java.io.Serializable;

public class AccountLogoutEvent implements Serializable {

    private Long passportId;

    private Long timestamp;

    public AccountLogoutEvent(Long passportId, Long timestamp) {
        this.passportId = passportId;
        this.timestamp = timestamp;
    }

    public Long getPassportId() {
        return passportId;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "AccountLogoutEvent{" +
                "passportId=" + passportId +
                ", timestamp=" + timestamp +
                '}';
    }
}
