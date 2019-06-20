package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class ParkingConf implements Serializable {
    private Integer communityId;

    private String parkingCode;

    private String vendor;

    private String account;

    private String password;

    private String ifaceUrl;

    private String priceImgUrl;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public String getParkingCode() {
        return parkingCode;
    }

    public void setParkingCode(String parkingCode) {
        this.parkingCode = parkingCode;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIfaceUrl() {
        return ifaceUrl;
    }

    public void setIfaceUrl(String ifaceUrl) {
        this.ifaceUrl = ifaceUrl;
    }

    public String getPriceImgUrl() {
        return priceImgUrl;
    }

    public void setPriceImgUrl(String priceImgUrl) {
        this.priceImgUrl = priceImgUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", communityId=").append(communityId);
        sb.append(", parkingCode=").append(parkingCode);
        sb.append(", vendor=").append(vendor);
        sb.append(", account=").append(account);
        sb.append(", password=").append(password);
        sb.append(", ifaceUrl=").append(ifaceUrl);
        sb.append(", priceImgUrl=").append(priceImgUrl);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
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
        ParkingConf other = (ParkingConf) that;
        return (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getParkingCode() == null ? other.getParkingCode() == null : this.getParkingCode().equals(other.getParkingCode()))
            && (this.getVendor() == null ? other.getVendor() == null : this.getVendor().equals(other.getVendor()))
            && (this.getAccount() == null ? other.getAccount() == null : this.getAccount().equals(other.getAccount()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getIfaceUrl() == null ? other.getIfaceUrl() == null : this.getIfaceUrl().equals(other.getIfaceUrl()))
            && (this.getPriceImgUrl() == null ? other.getPriceImgUrl() == null : this.getPriceImgUrl().equals(other.getPriceImgUrl()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getParkingCode() == null) ? 0 : getParkingCode().hashCode());
        result = prime * result + ((getVendor() == null) ? 0 : getVendor().hashCode());
        result = prime * result + ((getAccount() == null) ? 0 : getAccount().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getIfaceUrl() == null) ? 0 : getIfaceUrl().hashCode());
        result = prime * result + ((getPriceImgUrl() == null) ? 0 : getPriceImgUrl().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}