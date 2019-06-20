package com.rfchina.community.entity.wo;

import java.io.Serializable;

/**
 */
public class GetClientCusTypeListReq implements Serializable {

    private String parentGuid;

    public String getParentGuid() {
        return parentGuid;
    }

    public void setParentGuid(String parentGuid) {
        this.parentGuid = parentGuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GetClientCusTypeListReq that = (GetClientCusTypeListReq) o;

        return parentGuid != null ? parentGuid.equals(that.parentGuid) : that.parentGuid == null;

    }

    @Override
    public int hashCode() {
        return parentGuid != null ? parentGuid.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "GetClientCusTypeListReq{" +
                "parentGuid='" + parentGuid + '\'' +
                '}';
    }
}
