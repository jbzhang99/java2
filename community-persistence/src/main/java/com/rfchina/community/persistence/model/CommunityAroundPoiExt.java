package com.rfchina.community.persistence.model;

import java.io.Serializable;

public class CommunityAroundPoiExt implements Serializable {
    private Long poiId;

    private Double rating;

    private Double cost;

    private Double nativeRating;

    private String shopHours;

    private String baiduDetailUrl;

    private String featuredService;

    private Integer syncStatus;

    private String baiduUid;

    private static final long serialVersionUID = 1L;

    public Long getPoiId() {
        return poiId;
    }

    public void setPoiId(Long poiId) {
        this.poiId = poiId;
    }

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

    public Double getNativeRating() {
        return nativeRating;
    }

    public void setNativeRating(Double nativeRating) {
        this.nativeRating = nativeRating;
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

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    public String getBaiduUid() {
        return baiduUid;
    }

    public void setBaiduUid(String baiduUid) {
        this.baiduUid = baiduUid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", poiId=").append(poiId);
        sb.append(", rating=").append(rating);
        sb.append(", cost=").append(cost);
        sb.append(", nativeRating=").append(nativeRating);
        sb.append(", shopHours=").append(shopHours);
        sb.append(", baiduDetailUrl=").append(baiduDetailUrl);
        sb.append(", featuredService=").append(featuredService);
        sb.append(", syncStatus=").append(syncStatus);
        sb.append(", baiduUid=").append(baiduUid);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CommunityAroundPoiExt other = (CommunityAroundPoiExt) that;
        return (this.getPoiId() == null ? other.getPoiId() == null : this.getPoiId().equals(other.getPoiId()))
            && (this.getRating() == null ? other.getRating() == null : this.getRating().equals(other.getRating()))
            && (this.getCost() == null ? other.getCost() == null : this.getCost().equals(other.getCost()))
            && (this.getNativeRating() == null ? other.getNativeRating() == null : this.getNativeRating().equals(other.getNativeRating()))
            && (this.getShopHours() == null ? other.getShopHours() == null : this.getShopHours().equals(other.getShopHours()))
            && (this.getBaiduDetailUrl() == null ? other.getBaiduDetailUrl() == null : this.getBaiduDetailUrl().equals(other.getBaiduDetailUrl()))
            && (this.getFeaturedService() == null ? other.getFeaturedService() == null : this.getFeaturedService().equals(other.getFeaturedService()))
            && (this.getSyncStatus() == null ? other.getSyncStatus() == null : this.getSyncStatus().equals(other.getSyncStatus()))
            && (this.getBaiduUid() == null ? other.getBaiduUid() == null : this.getBaiduUid().equals(other.getBaiduUid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPoiId() == null) ? 0 : getPoiId().hashCode());
        result = prime * result + ((getRating() == null) ? 0 : getRating().hashCode());
        result = prime * result + ((getCost() == null) ? 0 : getCost().hashCode());
        result = prime * result + ((getNativeRating() == null) ? 0 : getNativeRating().hashCode());
        result = prime * result + ((getShopHours() == null) ? 0 : getShopHours().hashCode());
        result = prime * result + ((getBaiduDetailUrl() == null) ? 0 : getBaiduDetailUrl().hashCode());
        result = prime * result + ((getFeaturedService() == null) ? 0 : getFeaturedService().hashCode());
        result = prime * result + ((getSyncStatus() == null) ? 0 : getSyncStatus().hashCode());
        result = prime * result + ((getBaiduUid() == null) ? 0 : getBaiduUid().hashCode());
        return result;
    }
}