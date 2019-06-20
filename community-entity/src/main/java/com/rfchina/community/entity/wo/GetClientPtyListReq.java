package com.rfchina.community.entity.wo;

import java.io.Serializable;

/**
 */
public class GetClientPtyListReq implements Serializable {

    private String getType;

    private String parentGuid;

    public String getGetType() {
        return getType;
    }

    public void setGetType(String getType) {
        this.getType = getType;
    }

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

        GetClientPtyListReq req = (GetClientPtyListReq) o;

        if (getType != null ? !getType.equals(req.getType) : req.getType != null) return false;
        return parentGuid != null ? parentGuid.equals(req.parentGuid) : req.parentGuid == null;

    }

    @Override
    public int hashCode() {
        int result = getType != null ? getType.hashCode() : 0;
        result = 31 * result + (parentGuid != null ? parentGuid.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GetClientPtyListReq{" +
                "getType='" + getType + '\'' +
                ", parentGuid='" + parentGuid + '\'' +
                '}';
    }
}
