package com.rfchina.community.open.bridge.entity;

import com.rfchina.community.persistence.model.OpenStoreGroupData;

public class ExtOpenStoreGroupData extends OpenStoreGroupData {
    private String goodName;
    private String serviceName;

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }


}
