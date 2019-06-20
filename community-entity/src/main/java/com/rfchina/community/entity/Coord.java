package com.rfchina.community.entity;

import java.io.Serializable;

/**
 */
public final class Coord implements Serializable {

    private String lng;
    private String lat;

    public Coord(String lng, String lat) {
        this.lng = lng;
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return lat + "," + lng;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coord coord = (Coord) o;

        if (lng != null ? !lng.equals(coord.lng) : coord.lng != null) return false;
        return lat != null ? lat.equals(coord.lat) : coord.lat == null;

    }

    @Override
    public int hashCode() {
        int result = lng != null ? lng.hashCode() : 0;
        result = 31 * result + (lat != null ? lat.hashCode() : 0);
        return result;
    }
}