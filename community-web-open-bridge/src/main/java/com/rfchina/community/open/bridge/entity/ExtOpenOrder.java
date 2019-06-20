package com.rfchina.community.open.bridge.entity;

import com.rfchina.community.persistence.model.OpenOrder;

public class ExtOpenOrder extends OpenOrder {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String serviceName;

    private String communityName;

    private String merchantName;

    private String phone;

    //新增城市字段 wlrllr
    private String cityName;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    public String getCityName() {
        return cityName;
    }
}
