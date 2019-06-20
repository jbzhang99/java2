package com.rfchina.community.entity.wo;

import java.util.List;

/**
 */
public class GetClientPtyListRsp extends WoCommonRsp {

    private List<PmProperty> ptyList;

    public List<PmProperty> getPtyList() {
        return ptyList;
    }

    public void setPtyList(List<PmProperty> ptyList) {
        this.ptyList = ptyList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GetClientPtyListRsp that = (GetClientPtyListRsp) o;

        return ptyList != null ? ptyList.equals(that.ptyList) : that.ptyList == null;

    }

    @Override
    public int hashCode() {
        return ptyList != null ? ptyList.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "GetClientPtyListRsp{" +
                "ptyList=" + ptyList +
                '}';
    }
}
