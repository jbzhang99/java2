package com.rfchina.community.open.bridge.entity;

import com.rfchina.community.persistence.model.OpenStoreGoodGroupInfo;

public class ExtOpenStoreGoodGroupInfo extends OpenStoreGoodGroupInfo{
    private String goodName;
    private String serviceName;
    private String merchantName;
    private long groupDataCount;
    private int groupInfoStatus;

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

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public long getGroupDataCount() {
        return groupDataCount;
    }

    public void setGroupDataCount(long groupDataCount) {
        this.groupDataCount = groupDataCount;
    }

    public int getGroupInfoStatus() {
        return groupInfoStatus;
    }

    public void setGroupInfoStatus(int groupInfoStatus) {
        this.groupInfoStatus = groupInfoStatus;
    }
}
