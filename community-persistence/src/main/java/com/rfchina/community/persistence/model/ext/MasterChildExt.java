package com.rfchina.community.persistence.model.ext;

import com.rfchina.community.persistence.model.MasterChild;

/**
 */
public class MasterChildExt extends MasterChild {

    private Integer regStatus;

    private Integer gagStatus;

    public Integer getRegStatus() {
        return regStatus;
    }

    public void setRegStatus(Integer regStatus) {
        this.regStatus = regStatus;
    }

    public Integer getGagStatus() {
        return gagStatus;
    }

    public void setGagStatus(Integer gagStatus) {
        this.gagStatus = gagStatus;
    }
}
