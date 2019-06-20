package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class PayConfirmRecord implements Serializable {
    private String billId;

    private String origBillId;

    private Integer type;

    private Integer scanStatus;

    private Integer resultStatus;

    private String remark;

    private Date scanTime;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getOrigBillId() {
        return origBillId;
    }

    public void setOrigBillId(String origBillId) {
        this.origBillId = origBillId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getScanStatus() {
        return scanStatus;
    }

    public void setScanStatus(Integer scanStatus) {
        this.scanStatus = scanStatus;
    }

    public Integer getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(Integer resultStatus) {
        this.resultStatus = resultStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getScanTime() {
        return scanTime;
    }

    public void setScanTime(Date scanTime) {
        this.scanTime = scanTime;
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
        sb.append(", billId=").append(billId);
        sb.append(", origBillId=").append(origBillId);
        sb.append(", type=").append(type);
        sb.append(", scanStatus=").append(scanStatus);
        sb.append(", resultStatus=").append(resultStatus);
        sb.append(", remark=").append(remark);
        sb.append(", scanTime=").append(scanTime);
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
        PayConfirmRecord other = (PayConfirmRecord) that;
        return (this.getBillId() == null ? other.getBillId() == null : this.getBillId().equals(other.getBillId()))
            && (this.getOrigBillId() == null ? other.getOrigBillId() == null : this.getOrigBillId().equals(other.getOrigBillId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getScanStatus() == null ? other.getScanStatus() == null : this.getScanStatus().equals(other.getScanStatus()))
            && (this.getResultStatus() == null ? other.getResultStatus() == null : this.getResultStatus().equals(other.getResultStatus()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getScanTime() == null ? other.getScanTime() == null : this.getScanTime().equals(other.getScanTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBillId() == null) ? 0 : getBillId().hashCode());
        result = prime * result + ((getOrigBillId() == null) ? 0 : getOrigBillId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getScanStatus() == null) ? 0 : getScanStatus().hashCode());
        result = prime * result + ((getResultStatus() == null) ? 0 : getResultStatus().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getScanTime() == null) ? 0 : getScanTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}