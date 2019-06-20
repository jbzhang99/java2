package com.rfchina.community.component.mobike;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 */
public class PartnerloginRequest extends  AbstractMobikeRequest {

    private String mobileNo;

    private String channelNo;

    private String cityCode;

    @Override
    public Map<String, String> toMap() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("access_token", this.accesstoken);
        map.put("channelNo", this.channelNo);
        map.put("cityCode", this.cityCode);
        map.put("mobileNo", this.mobileNo);
        return map;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    @Override
    public String toString() {
        return "PartnerloginRequest{" +
                "mobileNo='" + mobileNo + '\'' +
                ", channelNo='" + channelNo + '\'' +
                ", cityCode='" + cityCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PartnerloginRequest that = (PartnerloginRequest) o;

        if (mobileNo != null ? !mobileNo.equals(that.mobileNo) : that.mobileNo != null) return false;
        if (channelNo != null ? !channelNo.equals(that.channelNo) : that.channelNo != null) return false;
        return cityCode != null ? cityCode.equals(that.cityCode) : that.cityCode == null;
    }

    @Override
    public int hashCode() {
        int result = mobileNo != null ? mobileNo.hashCode() : 0;
        result = 31 * result + (channelNo != null ? channelNo.hashCode() : 0);
        result = 31 * result + (cityCode != null ? cityCode.hashCode() : 0);
        return result;
    }
}
