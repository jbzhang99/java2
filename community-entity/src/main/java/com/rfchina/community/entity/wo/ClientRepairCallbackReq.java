package com.rfchina.community.entity.wo;

import java.io.Serializable;

/**
 */
public class ClientRepairCallbackReq implements Serializable {

    private String tskdCode;

    private String tskdDesc;

    private String tskdState;

    private Integer tskdIstate;

    private Integer tskdComplete;

    private String tskdCompleteTime;

    public String getTskdCode() {
        return tskdCode;
    }

    public void setTskdCode(String tskdCode) {
        this.tskdCode = tskdCode;
    }

    public String getTskdDesc() {
        return tskdDesc;
    }

    public void setTskdDesc(String tskdDesc) {
        this.tskdDesc = tskdDesc;
    }

    public String getTskdState() {
        return tskdState;
    }

    public void setTskdState(String tskdState) {
        this.tskdState = tskdState;
    }

    public Integer getTskdIstate() {
        return tskdIstate;
    }

    public void setTskdIstate(Integer tskdIstate) {
        this.tskdIstate = tskdIstate;
    }

    public Integer getTskdComplete() {
        return tskdComplete;
    }

    public void setTskdComplete(Integer tskdComplete) {
        this.tskdComplete = tskdComplete;
    }

    public String getTskdCompleteTime() {
        return tskdCompleteTime;
    }

    public void setTskdCompleteTime(String tskdCompleteTime) {
        this.tskdCompleteTime = tskdCompleteTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientRepairCallbackReq that = (ClientRepairCallbackReq) o;

        if (tskdCode != null ? !tskdCode.equals(that.tskdCode) : that.tskdCode != null) return false;
        if (tskdDesc != null ? !tskdDesc.equals(that.tskdDesc) : that.tskdDesc != null) return false;
        if (tskdState != null ? !tskdState.equals(that.tskdState) : that.tskdState != null) return false;
        if (tskdIstate != null ? !tskdIstate.equals(that.tskdIstate) : that.tskdIstate != null) return false;
        if (tskdComplete != null ? !tskdComplete.equals(that.tskdComplete) : that.tskdComplete != null) return false;
        return tskdCompleteTime != null ? tskdCompleteTime.equals(that.tskdCompleteTime) : that.tskdCompleteTime == null;

    }

    @Override
    public int hashCode() {
        int result = tskdCode != null ? tskdCode.hashCode() : 0;
        result = 31 * result + (tskdDesc != null ? tskdDesc.hashCode() : 0);
        result = 31 * result + (tskdState != null ? tskdState.hashCode() : 0);
        result = 31 * result + (tskdIstate != null ? tskdIstate.hashCode() : 0);
        result = 31 * result + (tskdComplete != null ? tskdComplete.hashCode() : 0);
        result = 31 * result + (tskdCompleteTime != null ? tskdCompleteTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ClientRepairCallbackReq{" +
                "tskdCode='" + tskdCode + '\'' +
                ", tskdDesc='" + tskdDesc + '\'' +
                ", tskdState='" + tskdState + '\'' +
                ", tskdIstate=" + tskdIstate +
                ", tskdComplete=" + tskdComplete +
                ", tskdCompleteTime='" + tskdCompleteTime + '\'' +
                '}';
    }
}
