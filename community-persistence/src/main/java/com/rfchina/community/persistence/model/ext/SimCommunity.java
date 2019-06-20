package com.rfchina.community.persistence.model.ext;

import java.io.Serializable;

public class SimCommunity implements Serializable {
    private Integer id;

    private String cityName;

    private String name;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}