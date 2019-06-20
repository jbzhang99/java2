package com.rfchina.community.entity.wo;


import java.util.List;

/**
 */
public class GetClientCusTypeListRsp extends WoCommonRsp {

    private List<MsgTypeBean> beans;

    public List<MsgTypeBean> getBeans() {
        return beans;
    }

    public void setBeans(List<MsgTypeBean> beans) {
        this.beans = beans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GetClientCusTypeListRsp that = (GetClientCusTypeListRsp) o;

        return beans != null ? beans.equals(that.beans) : that.beans == null;

    }

    @Override
    public int hashCode() {
        return beans != null ? beans.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "GetClientCusTypeListRsp{" +
                "beans=" + beans +
                '}';
    }
}
