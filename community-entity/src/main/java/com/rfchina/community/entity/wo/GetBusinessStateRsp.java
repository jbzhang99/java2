package com.rfchina.community.entity.wo;

/**
 */
public class GetBusinessStateRsp extends WoCommonRsp {

    private Integer tskIstate;

    private String tskState;

    private String tskRemark;

    public Integer getTskIstate() {
        return tskIstate;
    }

    public void setTskIstate(Integer tskIstate) {
        this.tskIstate = tskIstate;
    }

    public String getTskState() {
        return tskState;
    }

    public void setTskState(String tskState) {
        this.tskState = tskState;
    }

    public String getTskRemark() {
        return tskRemark;
    }

    public void setTskRemark(String tskRemark) {
        this.tskRemark = tskRemark;
    }

    @Override
    public String toString() {
        return "GetBusinessStateRsp{" +
                "tskIstate=" + tskIstate +
                ", tskState='" + tskState + '\'' +
                ", tskRemark='" + tskRemark + '\'' +
                '}';
    }
}
