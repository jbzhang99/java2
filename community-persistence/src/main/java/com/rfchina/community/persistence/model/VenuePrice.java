package com.rfchina.community.persistence.model;

import java.io.Serializable;

public class VenuePrice extends VenuePriceKey implements Serializable {
    private Double price;

    private static final long serialVersionUID = 1L;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", price=").append(price);
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
        VenuePrice other = (VenuePrice) that;
        return (this.getVenueId() == null ? other.getVenueId() == null : this.getVenueId().equals(other.getVenueId()))
            && (this.getWeek() == null ? other.getWeek() == null : this.getWeek().equals(other.getWeek()))
            && (this.getTimeSlice() == null ? other.getTimeSlice() == null : this.getTimeSlice().equals(other.getTimeSlice()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getVenueId() == null) ? 0 : getVenueId().hashCode());
        result = prime * result + ((getWeek() == null) ? 0 : getWeek().hashCode());
        result = prime * result + ((getTimeSlice() == null) ? 0 : getTimeSlice().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        return result;
    }
}