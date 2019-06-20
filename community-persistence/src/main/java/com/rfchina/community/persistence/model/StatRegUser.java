package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class StatRegUser implements Serializable {
    private Long id;

    private Date statTime;

    private Integer accCount;

    private Integer appCount;

    private Integer otherCount;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStatTime() {
        return statTime;
    }

    public void setStatTime(Date statTime) {
        this.statTime = statTime;
    }

    public Integer getAccCount() {
        return accCount;
    }

    public void setAccCount(Integer accCount) {
        this.accCount = accCount;
    }

    public Integer getAppCount() {
        return appCount;
    }

    public void setAppCount(Integer appCount) {
        this.appCount = appCount;
    }

    public Integer getOtherCount() {
        return otherCount;
    }

    public void setOtherCount(Integer otherCount) {
        this.otherCount = otherCount;
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
        sb.append(", id=").append(id);
        sb.append(", statTime=").append(statTime);
        sb.append(", accCount=").append(accCount);
        sb.append(", appCount=").append(appCount);
        sb.append(", otherCount=").append(otherCount);
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
        StatRegUser other = (StatRegUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStatTime() == null ? other.getStatTime() == null : this.getStatTime().equals(other.getStatTime()))
            && (this.getAccCount() == null ? other.getAccCount() == null : this.getAccCount().equals(other.getAccCount()))
            && (this.getAppCount() == null ? other.getAppCount() == null : this.getAppCount().equals(other.getAppCount()))
            && (this.getOtherCount() == null ? other.getOtherCount() == null : this.getOtherCount().equals(other.getOtherCount()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStatTime() == null) ? 0 : getStatTime().hashCode());
        result = prime * result + ((getAccCount() == null) ? 0 : getAccCount().hashCode());
        result = prime * result + ((getAppCount() == null) ? 0 : getAppCount().hashCode());
        result = prime * result + ((getOtherCount() == null) ? 0 : getOtherCount().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}