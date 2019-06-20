package com.rfchina.community.persistence.model.ext;

import com.rfchina.community.persistence.model.UserInfo;

/**
 */
public class UserInfoExt extends UserInfo {

    private Long communityAttention;

    private Long masterChildAttention;

    public Long getCommunityAttention() {
        return communityAttention;
    }

    public void setCommunityAttention(Long communityAttention) {
        this.communityAttention = communityAttention;
    }

    public Long getMasterChildAttention() {
        return masterChildAttention;
    }

    public void setMasterChildAttention(Long masterChildAttention) {
        this.masterChildAttention = masterChildAttention;
    }
}
