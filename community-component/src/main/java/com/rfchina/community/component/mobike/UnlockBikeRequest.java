package com.rfchina.community.component.mobike;


import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.*;

/**
 */
public class UnlockBikeRequest extends AbstractMobikeRequest {

    private String bikecode;

    private String citycode;

    private String latitude;

    private String longitude;

    private String userid;

    private String epdata;

    private String partnerChannelNo;

    @Override
    public Map<String, String> toMap() {
        Map<String, String> map = new LinkedHashMap<>();
//        map.put("accesstoken", this.accesstoken);
        map.put("bikecode", this.bikecode);
        map.put("citycode", this.citycode);
        map.put("epdata", this.epdata);
        map.put("partnerChannelNo", this.partnerChannelNo);
        map.put("latitude", this.latitude);
        map.put("longitude", this.longitude);
        map.put("userid", this.userid);
        return map;
    }

    public String getBikecode() {
        return bikecode;
    }

    public void setBikecode(String bikecode) {
        this.bikecode = bikecode;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getEpdata() {
        return epdata;
    }

    public void setEpdata(String epdata) {
        this.epdata = epdata;
    }

    public String getPartnerChannelNo() {
        return partnerChannelNo;
    }

    public void setPartnerChannelNo(String partnerChannelNo) {
        this.partnerChannelNo = partnerChannelNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnlockBikeRequest that = (UnlockBikeRequest) o;

        if (bikecode != null ? !bikecode.equals(that.bikecode) : that.bikecode != null) return false;
        if (citycode != null ? !citycode.equals(that.citycode) : that.citycode != null) return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;
        if (epdata != null ? !epdata.equals(that.epdata) : that.epdata != null) return false;
        return partnerChannelNo != null ? partnerChannelNo.equals(that.partnerChannelNo) : that.partnerChannelNo == null;
    }

    @Override
    public int hashCode() {
        int result = bikecode != null ? bikecode.hashCode() : 0;
        result = 31 * result + (citycode != null ? citycode.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (epdata != null ? epdata.hashCode() : 0);
        result = 31 * result + (partnerChannelNo != null ? partnerChannelNo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UnlockBikeRequest{" +
                "bikecode='" + bikecode + '\'' +
                ", citycode='" + citycode + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", userid='" + userid + '\'' +
                ", epdata='" + epdata + '\'' +
                ", partnerChannelNo='" + partnerChannelNo + '\'' +
                '}';
    }
}
