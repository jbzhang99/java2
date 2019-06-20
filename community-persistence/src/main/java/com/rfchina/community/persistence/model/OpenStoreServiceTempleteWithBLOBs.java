package com.rfchina.community.persistence.model;

import java.io.Serializable;

public class OpenStoreServiceTempleteWithBLOBs extends OpenStoreServiceTemplete implements Serializable {
    private String bannerUrl;

    private String storePic;

    private static final long serialVersionUID = 1L;

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public String getStorePic() {
        return storePic;
    }

    public void setStorePic(String storePic) {
        this.storePic = storePic;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bannerUrl=").append(bannerUrl);
        sb.append(", storePic=").append(storePic);
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
        OpenStoreServiceTempleteWithBLOBs other = (OpenStoreServiceTempleteWithBLOBs) that;
        return (this.getServiceId() == null ? other.getServiceId() == null : this.getServiceId().equals(other.getServiceId()))
            && (this.getExpressMoney() == null ? other.getExpressMoney() == null : this.getExpressMoney().equals(other.getExpressMoney()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getAddressProvince() == null ? other.getAddressProvince() == null : this.getAddressProvince().equals(other.getAddressProvince()))
            && (this.getAddressCity() == null ? other.getAddressCity() == null : this.getAddressCity().equals(other.getAddressCity()))
            && (this.getAddressArea() == null ? other.getAddressArea() == null : this.getAddressArea().equals(other.getAddressArea()))
            && (this.getAddressInfo() == null ? other.getAddressInfo() == null : this.getAddressInfo().equals(other.getAddressInfo()))
            && (this.getOpenTime() == null ? other.getOpenTime() == null : this.getOpenTime().equals(other.getOpenTime()))
            && (this.getCloseTime() == null ? other.getCloseTime() == null : this.getCloseTime().equals(other.getCloseTime()))
            && (this.getBannerUrl() == null ? other.getBannerUrl() == null : this.getBannerUrl().equals(other.getBannerUrl()))
            && (this.getStorePic() == null ? other.getStorePic() == null : this.getStorePic().equals(other.getStorePic()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getServiceId() == null) ? 0 : getServiceId().hashCode());
        result = prime * result + ((getExpressMoney() == null) ? 0 : getExpressMoney().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getAddressProvince() == null) ? 0 : getAddressProvince().hashCode());
        result = prime * result + ((getAddressCity() == null) ? 0 : getAddressCity().hashCode());
        result = prime * result + ((getAddressArea() == null) ? 0 : getAddressArea().hashCode());
        result = prime * result + ((getAddressInfo() == null) ? 0 : getAddressInfo().hashCode());
        result = prime * result + ((getOpenTime() == null) ? 0 : getOpenTime().hashCode());
        result = prime * result + ((getCloseTime() == null) ? 0 : getCloseTime().hashCode());
        result = prime * result + ((getBannerUrl() == null) ? 0 : getBannerUrl().hashCode());
        result = prime * result + ((getStorePic() == null) ? 0 : getStorePic().hashCode());
        return result;
    }
}