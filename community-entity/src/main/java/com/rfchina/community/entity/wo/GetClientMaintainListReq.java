package com.rfchina.community.entity.wo;

import java.io.Serializable;

/**
 */
public class GetClientMaintainListReq implements Serializable {

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GetClientMaintainListReq that = (GetClientMaintainListReq) o;

        return type != null ? type.equals(that.type) : that.type == null;

    }

    @Override
    public int hashCode() {
        return type != null ? type.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "GetClientMaintainListReq{" +
                "type='" + type + '\'' +
                '}';
    }
}
