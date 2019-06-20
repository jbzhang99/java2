package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class VenueLock extends VenueLockKey implements Serializable {
    private Integer week;

    private Long orderId;

    private Date createTime;

    private String uuid;

    private static final long serialVersionUID = 1L;

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", week=").append(week);
        sb.append(", orderId=").append(orderId);
        sb.append(", createTime=").append(createTime);
        sb.append(", uuid=").append(uuid);
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
        VenueLock other = (VenueLock) that;
        return (this.getVenueId() == null ? other.getVenueId() == null : this.getVenueId().equals(other.getVenueId()))
            && (this.getTimeSlice() == null ? other.getTimeSlice() == null : this.getTimeSlice().equals(other.getTimeSlice()))
            && (this.getPlayDate() == null ? other.getPlayDate() == null : this.getPlayDate().equals(other.getPlayDate()))
            && (this.getWeek() == null ? other.getWeek() == null : this.getWeek().equals(other.getWeek()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getVenueId() == null) ? 0 : getVenueId().hashCode());
        result = prime * result + ((getTimeSlice() == null) ? 0 : getTimeSlice().hashCode());
        result = prime * result + ((getPlayDate() == null) ? 0 : getPlayDate().hashCode());
        result = prime * result + ((getWeek() == null) ? 0 : getWeek().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        return result;
    }
}