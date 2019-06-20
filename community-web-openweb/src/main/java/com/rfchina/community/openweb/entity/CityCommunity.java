package com.rfchina.community.openweb.entity;

import java.io.Serializable;
import java.util.List;

public class CityCommunity implements Serializable {

    private Integer cityId;

    private String cityName;

    private List<SimCommunity> communityList;

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<SimCommunity> getCommunityList() {
        return communityList;
    }

    public void setCommunityList(List<SimCommunity> communityList) {
        this.communityList = communityList;
    }
}
