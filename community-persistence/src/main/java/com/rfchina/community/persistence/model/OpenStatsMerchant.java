package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class OpenStatsMerchant implements Serializable {
    private Date statDate;

    private Integer statWreek;

    private Integer statMonth;

    private Integer merchantCount;

    private Integer shelvesCount;

    private Integer merchantTotal;

    private Integer shelvesTotal;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Date getStatDate() {
        return statDate;
    }

    public void setStatDate(Date statDate) {
        this.statDate = statDate;
    }

    public Integer getStatWreek() {
        return statWreek;
    }

    public void setStatWreek(Integer statWreek) {
        this.statWreek = statWreek;
    }

    public Integer getStatMonth() {
        return statMonth;
    }

    public void setStatMonth(Integer statMonth) {
        this.statMonth = statMonth;
    }

    public Integer getMerchantCount() {
        return merchantCount;
    }

    public void setMerchantCount(Integer merchantCount) {
        this.merchantCount = merchantCount;
    }

    public Integer getShelvesCount() {
        return shelvesCount;
    }

    public void setShelvesCount(Integer shelvesCount) {
        this.shelvesCount = shelvesCount;
    }

    public Integer getMerchantTotal() {
        return merchantTotal;
    }

    public void setMerchantTotal(Integer merchantTotal) {
        this.merchantTotal = merchantTotal;
    }

    public Integer getShelvesTotal() {
        return shelvesTotal;
    }

    public void setShelvesTotal(Integer shelvesTotal) {
        this.shelvesTotal = shelvesTotal;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", statDate=").append(statDate);
        sb.append(", statWreek=").append(statWreek);
        sb.append(", statMonth=").append(statMonth);
        sb.append(", merchantCount=").append(merchantCount);
        sb.append(", shelvesCount=").append(shelvesCount);
        sb.append(", merchantTotal=").append(merchantTotal);
        sb.append(", shelvesTotal=").append(shelvesTotal);
        sb.append(", createTime=").append(createTime);
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
        OpenStatsMerchant other = (OpenStatsMerchant) that;
        return (this.getStatDate() == null ? other.getStatDate() == null : this.getStatDate().equals(other.getStatDate()))
            && (this.getStatWreek() == null ? other.getStatWreek() == null : this.getStatWreek().equals(other.getStatWreek()))
            && (this.getStatMonth() == null ? other.getStatMonth() == null : this.getStatMonth().equals(other.getStatMonth()))
            && (this.getMerchantCount() == null ? other.getMerchantCount() == null : this.getMerchantCount().equals(other.getMerchantCount()))
            && (this.getShelvesCount() == null ? other.getShelvesCount() == null : this.getShelvesCount().equals(other.getShelvesCount()))
            && (this.getMerchantTotal() == null ? other.getMerchantTotal() == null : this.getMerchantTotal().equals(other.getMerchantTotal()))
            && (this.getShelvesTotal() == null ? other.getShelvesTotal() == null : this.getShelvesTotal().equals(other.getShelvesTotal()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStatDate() == null) ? 0 : getStatDate().hashCode());
        result = prime * result + ((getStatWreek() == null) ? 0 : getStatWreek().hashCode());
        result = prime * result + ((getStatMonth() == null) ? 0 : getStatMonth().hashCode());
        result = prime * result + ((getMerchantCount() == null) ? 0 : getMerchantCount().hashCode());
        result = prime * result + ((getShelvesCount() == null) ? 0 : getShelvesCount().hashCode());
        result = prime * result + ((getMerchantTotal() == null) ? 0 : getMerchantTotal().hashCode());
        result = prime * result + ((getShelvesTotal() == null) ? 0 : getShelvesTotal().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}