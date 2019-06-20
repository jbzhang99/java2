package com.rfchina.community.persistence.model.ext;

import com.rfchina.community.persistence.model.CommunityAroundPoiRel;

public class ExtCommunityAroundPoiRel extends CommunityAroundPoiRel {

    private String longitude; //经度

    private String latitude; //纬度

    private String poiLongitude; //纬度

    private String poiLatitude; //纬度

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getPoiLongitude() {
        return poiLongitude;
    }

    public void setPoiLongitude(String poiLongitude) {
        this.poiLongitude = poiLongitude;
    }

    public String getPoiLatitude() {
        return poiLatitude;
    }

    public void setPoiLatitude(String poiLatitude) {
        this.poiLatitude = poiLatitude;
    }
}