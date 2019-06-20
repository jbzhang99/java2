package com.rfchina.community.openweb.entity;


import com.rfchina.community.persistence.model.OpenStoreGood;

import java.io.Serializable;

/**
 */
public class StoreCardInfoExt extends CardInfoExt implements Serializable {

    private OpenStoreGood good;

    private String serviceName;

    private String merchantName;

    private String goodName;

    public OpenStoreGood getGood() {
        return good;
    }

    public void setGood(OpenStoreGood good) {
        this.good = good;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }
}
