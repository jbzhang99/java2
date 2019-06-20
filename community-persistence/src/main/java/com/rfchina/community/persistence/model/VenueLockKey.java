package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class VenueLockKey implements Serializable {
    private Long venueId;

    private String timeSlice;

    private Date playDate;

    private static final long serialVersionUID = 1L;

    public Long getVenueId() {
        return venueId;
    }

    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }

    public String getTimeSlice() {
        return timeSlice;
    }

    public void setTimeSlice(String timeSlice) {
        this.timeSlice = timeSlice;
    }

    public Date getPlayDate() {
        return playDate;
    }

    public void setPlayDate(Date playDate) {
        this.playDate = playDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", venueId=").append(venueId);
        sb.append(", timeSlice=").append(timeSlice);
        sb.append(", playDate=").append(playDate);
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
        VenueLockKey other = (VenueLockKey) that;
        return (this.getVenueId() == null ? other.getVenueId() == null : this.getVenueId().equals(other.getVenueId()))
            && (this.getTimeSlice() == null ? other.getTimeSlice() == null : this.getTimeSlice().equals(other.getTimeSlice()))
            && (this.getPlayDate() == null ? other.getPlayDate() == null : this.getPlayDate().equals(other.getPlayDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getVenueId() == null) ? 0 : getVenueId().hashCode());
        result = prime * result + ((getTimeSlice() == null) ? 0 : getTimeSlice().hashCode());
        result = prime * result + ((getPlayDate() == null) ? 0 : getPlayDate().hashCode());
        return result;
    }
}