package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class RepairRecordState implements Serializable {
    private Long id;

    private String tskCode;

    private String tskState;

    private Integer tskIstate;

    private Integer tskComplete;

    private String tskDesc;

    private Date tskCompleteTime;

    private Integer formType;

    private String outReason;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTskCode() {
        return tskCode;
    }

    public void setTskCode(String tskCode) {
        this.tskCode = tskCode;
    }

    public String getTskState() {
        return tskState;
    }

    public void setTskState(String tskState) {
        this.tskState = tskState;
    }

    public Integer getTskIstate() {
        return tskIstate;
    }

    public void setTskIstate(Integer tskIstate) {
        this.tskIstate = tskIstate;
    }

    public Integer getTskComplete() {
        return tskComplete;
    }

    public void setTskComplete(Integer tskComplete) {
        this.tskComplete = tskComplete;
    }

    public String getTskDesc() {
        return tskDesc;
    }

    public void setTskDesc(String tskDesc) {
        this.tskDesc = tskDesc;
    }

    public Date getTskCompleteTime() {
        return tskCompleteTime;
    }

    public void setTskCompleteTime(Date tskCompleteTime) {
        this.tskCompleteTime = tskCompleteTime;
    }

    public Integer getFormType() {
        return formType;
    }

    public void setFormType(Integer formType) {
        this.formType = formType;
    }

    public String getOutReason() {
        return outReason;
    }

    public void setOutReason(String outReason) {
        this.outReason = outReason;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tskCode=").append(tskCode);
        sb.append(", tskState=").append(tskState);
        sb.append(", tskIstate=").append(tskIstate);
        sb.append(", tskComplete=").append(tskComplete);
        sb.append(", tskDesc=").append(tskDesc);
        sb.append(", tskCompleteTime=").append(tskCompleteTime);
        sb.append(", formType=").append(formType);
        sb.append(", outReason=").append(outReason);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        RepairRecordState other = (RepairRecordState) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTskCode() == null ? other.getTskCode() == null : this.getTskCode().equals(other.getTskCode()))
            && (this.getTskState() == null ? other.getTskState() == null : this.getTskState().equals(other.getTskState()))
            && (this.getTskIstate() == null ? other.getTskIstate() == null : this.getTskIstate().equals(other.getTskIstate()))
            && (this.getTskComplete() == null ? other.getTskComplete() == null : this.getTskComplete().equals(other.getTskComplete()))
            && (this.getTskDesc() == null ? other.getTskDesc() == null : this.getTskDesc().equals(other.getTskDesc()))
            && (this.getTskCompleteTime() == null ? other.getTskCompleteTime() == null : this.getTskCompleteTime().equals(other.getTskCompleteTime()))
            && (this.getFormType() == null ? other.getFormType() == null : this.getFormType().equals(other.getFormType()))
            && (this.getOutReason() == null ? other.getOutReason() == null : this.getOutReason().equals(other.getOutReason()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTskCode() == null) ? 0 : getTskCode().hashCode());
        result = prime * result + ((getTskState() == null) ? 0 : getTskState().hashCode());
        result = prime * result + ((getTskIstate() == null) ? 0 : getTskIstate().hashCode());
        result = prime * result + ((getTskComplete() == null) ? 0 : getTskComplete().hashCode());
        result = prime * result + ((getTskDesc() == null) ? 0 : getTskDesc().hashCode());
        result = prime * result + ((getTskCompleteTime() == null) ? 0 : getTskCompleteTime().hashCode());
        result = prime * result + ((getFormType() == null) ? 0 : getFormType().hashCode());
        result = prime * result + ((getOutReason() == null) ? 0 : getOutReason().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}