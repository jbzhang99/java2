package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OpenStoreServiceTemplete implements Serializable {
    private Integer serviceId;

    private BigDecimal expressMoney;

    private Integer flagship;

    private String phone;

    private String bannerUrl;

    private Date createTime;

    private Integer addressProvince;

    private Integer addressCity;

    private Integer addressArea;

    private String addressInfo;

    private String storePic;

    private String addressAllInfo;

    private String openTime;

    private String closeTime;

    private Integer premiumNum;

    private Integer scanStatus;

    private Integer quickPay;

    private static final long serialVersionUID = 1L;

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public BigDecimal getExpressMoney() {
        return expressMoney;
    }

    public void setExpressMoney(BigDecimal expressMoney) {
        this.expressMoney = expressMoney;
    }

    public Integer getFlagship() {
        return flagship;
    }

    public void setFlagship(Integer flagship) {
        this.flagship = flagship;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getAddressProvince() {
        return addressProvince;
    }

    public void setAddressProvince(Integer addressProvince) {
        this.addressProvince = addressProvince;
    }

    public Integer getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(Integer addressCity) {
        this.addressCity = addressCity;
    }

    public Integer getAddressArea() {
        return addressArea;
    }

    public void setAddressArea(Integer addressArea) {
        this.addressArea = addressArea;
    }

    public String getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(String addressInfo) {
        this.addressInfo = addressInfo;
    }

    public String getStorePic() {
        return storePic;
    }

    public void setStorePic(String storePic) {
        this.storePic = storePic;
    }

    public String getAddressAllInfo() {
        return addressAllInfo;
    }

    public void setAddressAllInfo(String addressAllInfo) {
        this.addressAllInfo = addressAllInfo;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public Integer getPremiumNum() {
        return premiumNum;
    }

    public void setPremiumNum(Integer premiumNum) {
        this.premiumNum = premiumNum;
    }

    public Integer getScanStatus() {
        return scanStatus;
    }

    public void setScanStatus(Integer scanStatus) {
        this.scanStatus = scanStatus;
    }

    public Integer getQuickPay() {
        return quickPay;
    }

    public void setQuickPay(Integer quickPay) {
        this.quickPay = quickPay;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serviceId=").append(serviceId);
        sb.append(", expressMoney=").append(expressMoney);
        sb.append(", flagship=").append(flagship);
        sb.append(", phone=").append(phone);
        sb.append(", bannerUrl=").append(bannerUrl);
        sb.append(", createTime=").append(createTime);
        sb.append(", addressProvince=").append(addressProvince);
        sb.append(", addressCity=").append(addressCity);
        sb.append(", addressArea=").append(addressArea);
        sb.append(", addressInfo=").append(addressInfo);
        sb.append(", storePic=").append(storePic);
        sb.append(", addressAllInfo=").append(addressAllInfo);
        sb.append(", openTime=").append(openTime);
        sb.append(", closeTime=").append(closeTime);
        sb.append(", premiumNum=").append(premiumNum);
        sb.append(", scanStatus=").append(scanStatus);
        sb.append(", quickPay=").append(quickPay);
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
        OpenStoreServiceTemplete other = (OpenStoreServiceTemplete) that;
        return (this.getServiceId() == null ? other.getServiceId() == null : this.getServiceId().equals(other.getServiceId()))
            && (this.getExpressMoney() == null ? other.getExpressMoney() == null : this.getExpressMoney().equals(other.getExpressMoney()))
            && (this.getFlagship() == null ? other.getFlagship() == null : this.getFlagship().equals(other.getFlagship()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getBannerUrl() == null ? other.getBannerUrl() == null : this.getBannerUrl().equals(other.getBannerUrl()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getAddressProvince() == null ? other.getAddressProvince() == null : this.getAddressProvince().equals(other.getAddressProvince()))
            && (this.getAddressCity() == null ? other.getAddressCity() == null : this.getAddressCity().equals(other.getAddressCity()))
            && (this.getAddressArea() == null ? other.getAddressArea() == null : this.getAddressArea().equals(other.getAddressArea()))
            && (this.getAddressInfo() == null ? other.getAddressInfo() == null : this.getAddressInfo().equals(other.getAddressInfo()))
            && (this.getStorePic() == null ? other.getStorePic() == null : this.getStorePic().equals(other.getStorePic()))
            && (this.getAddressAllInfo() == null ? other.getAddressAllInfo() == null : this.getAddressAllInfo().equals(other.getAddressAllInfo()))
            && (this.getOpenTime() == null ? other.getOpenTime() == null : this.getOpenTime().equals(other.getOpenTime()))
            && (this.getCloseTime() == null ? other.getCloseTime() == null : this.getCloseTime().equals(other.getCloseTime()))
            && (this.getPremiumNum() == null ? other.getPremiumNum() == null : this.getPremiumNum().equals(other.getPremiumNum()))
            && (this.getScanStatus() == null ? other.getScanStatus() == null : this.getScanStatus().equals(other.getScanStatus()))
            && (this.getQuickPay() == null ? other.getQuickPay() == null : this.getQuickPay().equals(other.getQuickPay()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getServiceId() == null) ? 0 : getServiceId().hashCode());
        result = prime * result + ((getExpressMoney() == null) ? 0 : getExpressMoney().hashCode());
        result = prime * result + ((getFlagship() == null) ? 0 : getFlagship().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getBannerUrl() == null) ? 0 : getBannerUrl().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getAddressProvince() == null) ? 0 : getAddressProvince().hashCode());
        result = prime * result + ((getAddressCity() == null) ? 0 : getAddressCity().hashCode());
        result = prime * result + ((getAddressArea() == null) ? 0 : getAddressArea().hashCode());
        result = prime * result + ((getAddressInfo() == null) ? 0 : getAddressInfo().hashCode());
        result = prime * result + ((getStorePic() == null) ? 0 : getStorePic().hashCode());
        result = prime * result + ((getAddressAllInfo() == null) ? 0 : getAddressAllInfo().hashCode());
        result = prime * result + ((getOpenTime() == null) ? 0 : getOpenTime().hashCode());
        result = prime * result + ((getCloseTime() == null) ? 0 : getCloseTime().hashCode());
        result = prime * result + ((getPremiumNum() == null) ? 0 : getPremiumNum().hashCode());
        result = prime * result + ((getScanStatus() == null) ? 0 : getScanStatus().hashCode());
        result = prime * result + ((getQuickPay() == null) ? 0 : getQuickPay().hashCode());
        return result;
    }
}