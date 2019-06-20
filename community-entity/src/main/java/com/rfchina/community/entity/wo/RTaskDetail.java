package com.rfchina.community.entity.wo;

import java.io.Serializable;

/**
 */
public class RTaskDetail implements Serializable {

    private String tskdCode;

    private String tskdDesc;

    private String tskdEmpCnName;

    private String tskdState;

    private Integer tskdIstate;

    private Integer tskdComplete;

    private String tskdFromEmpCnName;

    private String tskdCompleteTime;

    private String tskdAddTime;

    private String tskdEmpMobile;

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

    public String getTskdEmpCnName() {
        return tskdEmpCnName;
    }

    public void setTskdEmpCnName(String tskdEmpCnName) {
        this.tskdEmpCnName = tskdEmpCnName;
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

    public String getTskdFromEmpCnName() {
        return tskdFromEmpCnName;
    }

    public void setTskdFromEmpCnName(String tskdFromEmpCnName) {
        this.tskdFromEmpCnName = tskdFromEmpCnName;
    }

    public String getTskdCompleteTime() {
        return tskdCompleteTime;
    }

    public void setTskdCompleteTime(String tskdCompleteTime) {
        this.tskdCompleteTime = tskdCompleteTime;
    }

    public String getTskdAddTime() {
        return tskdAddTime;
    }

    public void setTskdAddTime(String tskdAddTime) {
        this.tskdAddTime = tskdAddTime;
    }

    public String getTskdEmpMobile() {
        return tskdEmpMobile;
    }

    public void setTskdEmpMobile(String tskdEmpMobile) {
        this.tskdEmpMobile = tskdEmpMobile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RTaskDetail that = (RTaskDetail) o;

        if (tskdCode != null ? !tskdCode.equals(that.tskdCode) : that.tskdCode != null) return false;
        if (tskdDesc != null ? !tskdDesc.equals(that.tskdDesc) : that.tskdDesc != null) return false;
        if (tskdEmpCnName != null ? !tskdEmpCnName.equals(that.tskdEmpCnName) : that.tskdEmpCnName != null)
            return false;
        if (tskdState != null ? !tskdState.equals(that.tskdState) : that.tskdState != null) return false;
        if (tskdIstate != null ? !tskdIstate.equals(that.tskdIstate) : that.tskdIstate != null) return false;
        if (tskdComplete != null ? !tskdComplete.equals(that.tskdComplete) : that.tskdComplete != null) return false;
        if (tskdFromEmpCnName != null ? !tskdFromEmpCnName.equals(that.tskdFromEmpCnName) : that.tskdFromEmpCnName != null)
            return false;
        if (tskdCompleteTime != null ? !tskdCompleteTime.equals(that.tskdCompleteTime) : that.tskdCompleteTime != null)
            return false;
        if (tskdAddTime != null ? !tskdAddTime.equals(that.tskdAddTime) : that.tskdAddTime != null) return false;
        return tskdEmpMobile != null ? tskdEmpMobile.equals(that.tskdEmpMobile) : that.tskdEmpMobile == null;

    }

    @Override
    public int hashCode() {
        int result = tskdCode != null ? tskdCode.hashCode() : 0;
        result = 31 * result + (tskdDesc != null ? tskdDesc.hashCode() : 0);
        result = 31 * result + (tskdEmpCnName != null ? tskdEmpCnName.hashCode() : 0);
        result = 31 * result + (tskdState != null ? tskdState.hashCode() : 0);
        result = 31 * result + (tskdIstate != null ? tskdIstate.hashCode() : 0);
        result = 31 * result + (tskdComplete != null ? tskdComplete.hashCode() : 0);
        result = 31 * result + (tskdFromEmpCnName != null ? tskdFromEmpCnName.hashCode() : 0);
        result = 31 * result + (tskdCompleteTime != null ? tskdCompleteTime.hashCode() : 0);
        result = 31 * result + (tskdAddTime != null ? tskdAddTime.hashCode() : 0);
        result = 31 * result + (tskdEmpMobile != null ? tskdEmpMobile.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RTaskDetail{" +
                "tskdCode='" + tskdCode + '\'' +
                ", tskdDesc='" + tskdDesc + '\'' +
                ", tskdEmpCnName='" + tskdEmpCnName + '\'' +
                ", tskdState='" + tskdState + '\'' +
                ", tskdIstate='" + tskdIstate + '\'' +
                ", tskdComplete='" + tskdComplete + '\'' +
                ", tskdFromEmpCnName='" + tskdFromEmpCnName + '\'' +
                ", tskdCompleteTime='" + tskdCompleteTime + '\'' +
                ", tskdAddTime='" + tskdAddTime + '\'' +
                ", tskdEmpMobile='" + tskdEmpMobile + '\'' +
                '}';
    }
}
