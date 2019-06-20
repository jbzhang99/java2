package com.rfchina.community.persistence.model.ext;

import com.rfchina.community.persistence.model.OpenMiniAdInfo;

import java.util.List;

public class ExtOpenMiniAdInfo extends OpenMiniAdInfo{
    private List<ExtOpenMiniAdTab> tabList;

    private List<SimCommunity> communityList;

    public List<SimCommunity> getCommunityList() {
        return communityList;
    }

    public void setCommunityList(List<SimCommunity> communityList) {
        this.communityList = communityList;
    }

    public List<ExtOpenMiniAdTab> getTabList() {
        return tabList;
    }

    public void setTabList(List<ExtOpenMiniAdTab> tabList) {
        this.tabList = tabList;
    }
}
