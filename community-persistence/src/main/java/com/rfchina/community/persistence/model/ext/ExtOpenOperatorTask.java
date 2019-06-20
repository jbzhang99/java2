package com.rfchina.community.persistence.model.ext;

import com.rfchina.community.persistence.model.OpenOperatorTask;

import java.io.Serializable;
import java.math.BigDecimal;

public class ExtOpenOperatorTask extends OpenOperatorTask implements Serializable {
    private String cityName;
    private String communityName;
    private String type;
    private String actTitile;
    private String merchantName;
    private String serviceName;
    private int activityStatus;
    private BigDecimal sumAmount;
    private int rateStatus;//进度状态
    private int timeStatus;
    private String categoryName;
    private int categoryId;

    public int getTimeStatus() {
        return timeStatus;
    }

    public void setTimeStatus(int timeStatus) {
        this.timeStatus = timeStatus;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public BigDecimal getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(BigDecimal sumAmount) {
        this.sumAmount = sumAmount;
    }

    public int getRateStatus() {
        return rateStatus;
    }

    public void setRateStatus(int rateStatus) {
        this.rateStatus = rateStatus;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getActTitile() {
        return actTitile;
    }

    public void setActTitile(String actTitile) {
        this.actTitile = actTitile;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(int activityStatus) {
        this.activityStatus = activityStatus;
    }
}