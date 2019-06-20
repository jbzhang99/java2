package com.rfchina.community.persistence.model.ext;

import com.rfchina.community.persistence.model.BuildingInfo;

/**
 */
public class BuildingInfoExt extends BuildingInfo {

    private String communityName;

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }
}
