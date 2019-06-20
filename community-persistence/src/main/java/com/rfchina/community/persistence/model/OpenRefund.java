package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class OpenRefund implements Serializable {
    private Long id;

    private Long openId;

    private String billId;

    private String refundId;

    private Date createTime;

    private Date updateTime;

    private Integer status;

    private String revokeCode;

    private String refundBillId;

    private String refundAccountId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOpenId() {
        return openId;
    }

    public void setOpenId(Long openId) {
        this.openId = openId;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRevokeCode() {
        return revokeCode;
    }

    public void setRevokeCode(String revokeCode) {
        this.revokeCode = revokeCode;
    }

    public String getRefundBillId() {
        return refundBillId;
    }

    public void setRefundBillId(String refundBillId) {
        this.refundBillId = refundBillId;
    }

    public String getRefundAccountId() {
        return refundAccountId;
    }

    public void setRefundAccountId(String refundAccountId) {
        this.refundAccountId = refundAccountId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", openId=").append(openId);
        sb.append(", billId=").append(billId);
        sb.append(", refundId=").append(refundId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", status=").append(status);
        sb.append(", revokeCode=").append(revokeCode);
        sb.append(", refundBillId=").append(refundBillId);
        sb.append(", refundAccountId=").append(refundAccountId);
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
        OpenRefund other = (OpenRefund) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOpenId() == null ? other.getOpenId() == null : this.getOpenId().equals(other.getOpenId()))
            && (this.getBillId() == null ? other.getBillId() == null : this.getBillId().equals(other.getBillId()))
            && (this.getRefundId() == null ? other.getRefundId() == null : this.getRefundId().equals(other.getRefundId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRevokeCode() == null ? other.getRevokeCode() == null : this.getRevokeCode().equals(other.getRevokeCode()))
            && (this.getRefundBillId() == null ? other.getRefundBillId() == null : this.getRefundBillId().equals(other.getRefundBillId()))
            && (this.getRefundAccountId() == null ? other.getRefundAccountId() == null : this.getRefundAccountId().equals(other.getRefundAccountId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOpenId() == null) ? 0 : getOpenId().hashCode());
        result = prime * result + ((getBillId() == null) ? 0 : getBillId().hashCode());
        result = prime * result + ((getRefundId() == null) ? 0 : getRefundId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRevokeCode() == null) ? 0 : getRevokeCode().hashCode());
        result = prime * result + ((getRefundBillId() == null) ? 0 : getRefundBillId().hashCode());
        result = prime * result + ((getRefundAccountId() == null) ? 0 : getRefundAccountId().hashCode());
        return result;
    }
}