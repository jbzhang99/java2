package com.rfchina.community.persistence.model;

import java.io.Serializable;

public class SysSmsTemplate implements Serializable {
    private String smsType;

    private String smsTemp;

    private Integer appid;

    private static final long serialVersionUID = 1L;

    public String getSmsType() {
        return smsType;
    }

    public void setSmsType(String smsType) {
        this.smsType = smsType;
    }

    public String getSmsTemp() {
        return smsTemp;
    }

    public void setSmsTemp(String smsTemp) {
        this.smsTemp = smsTemp;
    }

    public Integer getAppid() {
        return appid;
    }

    public void setAppid(Integer appid) {
        this.appid = appid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", smsType=").append(smsType);
        sb.append(", smsTemp=").append(smsTemp);
        sb.append(", appid=").append(appid);
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
        SysSmsTemplate other = (SysSmsTemplate) that;
        return (this.getSmsType() == null ? other.getSmsType() == null : this.getSmsType().equals(other.getSmsType()))
            && (this.getSmsTemp() == null ? other.getSmsTemp() == null : this.getSmsTemp().equals(other.getSmsTemp()))
            && (this.getAppid() == null ? other.getAppid() == null : this.getAppid().equals(other.getAppid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSmsType() == null) ? 0 : getSmsType().hashCode());
        result = prime * result + ((getSmsTemp() == null) ? 0 : getSmsTemp().hashCode());
        result = prime * result + ((getAppid() == null) ? 0 : getAppid().hashCode());
        return result;
    }
}