package com.rfchina.community.openweb.entity;

import java.io.Serializable;

public class SimCommunity implements Serializable {

    private Integer communityId;

    private String communityName;


    public SimCommunity(Integer cityId, String cityName, Integer communityId, String communityName) {
        this.communityId = communityId;
        this.communityName = communityName;
    }

    public SimCommunity() {
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }
}
