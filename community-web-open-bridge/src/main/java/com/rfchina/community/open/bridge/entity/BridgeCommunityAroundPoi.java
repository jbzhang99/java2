package com.rfchina.community.open.bridge.entity;

import com.rfchina.community.persistence.model.CommunityAroundPoi;


public class BridgeCommunityAroundPoi extends CommunityAroundPoi {

    private Double rating;

    private Double cost;

    private String shopHours;

    private String baiduDetailUrl;

    private String featuredService;

    private String tag;

    //判断是新增还是修改
    private Boolean addFlag;

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getShopHours() {
        return shopHours;
    }

    public void setShopHours(String shopHours) {
        this.shopHours = shopHours;
    }

    public String getBaiduDetailUrl() {
        return baiduDetailUrl;
    }

    public void setBaiduDetailUrl(String baiduDetailUrl) {
        this.baiduDetailUrl = baiduDetailUrl;
    }

    public String getFeaturedService() {
        return featuredService;
    }

    public void setFeaturedService(String featuredService) {
        this.featuredService = featuredService;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Boolean getAddFlag() {
        return addFlag;
    }

    public void setAddFlag(Boolean addFlag) {
        this.addFlag = addFlag;
    }
}
