package com.rfchina.community.entity.wo;

import java.util.List;

/**
 */
public class GetClientMaintainListRsp extends WoCommonRsp {

    private List<RMaintainCate> rMaintainCates;

    public List<RMaintainCate> getrMaintainCates() {
        return rMaintainCates;
    }

    public void setrMaintainCates(List<RMaintainCate> rMaintainCates) {
        this.rMaintainCates = rMaintainCates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GetClientMaintainListRsp that = (GetClientMaintainListRsp) o;

        return rMaintainCates != null ? rMaintainCates.equals(that.rMaintainCates) : that.rMaintainCates == null;

    }

    @Override
    public int hashCode() {
        return rMaintainCates != null ? rMaintainCates.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "GetClientMaintainListRsp{" +
                "rMaintainCates=" + rMaintainCates +
                '}';
    }
}
