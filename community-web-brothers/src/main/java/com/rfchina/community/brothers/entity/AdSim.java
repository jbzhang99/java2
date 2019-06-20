package com.rfchina.community.brothers.entity;

import java.io.Serializable;

import com.rfchina.community.persistence.model.Ad;

/**
 */
public class AdSim extends Ad implements Serializable {

    private String communityName;

    private String categoryName;

    private String applyAdminName;

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getApplyAdminName() {
        return applyAdminName;
    }

    public void setApplyAdminName(String applyAdminName) {
        this.applyAdminName = applyAdminName;
    }
}
