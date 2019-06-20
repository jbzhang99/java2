package com.rfchina.community.persistence.model.ext;

import com.rfchina.community.persistence.model.MasterInfo;

/**
 */
public class MasterInfoExt extends MasterInfo {

    private String communityName;

    private String userName;

    private String phone;

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
