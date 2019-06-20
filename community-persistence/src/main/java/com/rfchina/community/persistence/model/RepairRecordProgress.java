package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class RepairRecordProgress implements Serializable {

    private Long id;

    private String tradeNo;

    private String orderNo;

    private String outId;

    private String processor;

    private String processorMobile;

    private Date processorTime;

    private String remark;

    private String outDetail;

    private Date createTime;

    private Integer status;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOutId() {
        return outId;
    }

    public void setOutId(String outId) {
        this.outId = outId;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getProcessorMobile() {
        return processorMobile;
    }

    public void setProcessorMobile(String processorMobile) {
        this.processorMobile = processorMobile;
    }

    public Date getProcessorTime() {
        return processorTime;
    }

    public void setProcessorTime(Date processorTime) {
        this.processorTime = processorTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOutDetail() {
        return outDetail;
    }

    public void setOutDetail(String outDetail) {
        this.outDetail = outDetail;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tradeNo=").append(tradeNo);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", outId=").append(outId);
        sb.append(", processor=").append(processor);
        sb.append(", processorMobile=").append(processorMobile);
        sb.append(", processorTime=").append(processorTime);
        sb.append(", remark=").append(remark);
        sb.append(", outDetail=").append(outDetail);
        sb.append(", createTime=").append(createTime);
        sb.append(", status=").append(status);
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
        RepairRecordProgress other = (RepairRecordProgress) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTradeNo() == null ? other.getTradeNo() == null : this.getTradeNo().equals(other.getTradeNo()))
            && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
            && (this.getOutId() == null ? other.getOutId() == null : this.getOutId().equals(other.getOutId()))
            && (this.getProcessor() == null ? other.getProcessor() == null : this.getProcessor().equals(other.getProcessor()))
            && (this.getProcessorMobile() == null ? other.getProcessorMobile() == null : this.getProcessorMobile().equals(other.getProcessorMobile()))
            && (this.getProcessorTime() == null ? other.getProcessorTime() == null : this.getProcessorTime().equals(other.getProcessorTime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getOutDetail() == null ? other.getOutDetail() == null : this.getOutDetail().equals(other.getOutDetail()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTradeNo() == null) ? 0 : getTradeNo().hashCode());
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getOutId() == null) ? 0 : getOutId().hashCode());
        result = prime * result + ((getProcessor() == null) ? 0 : getProcessor().hashCode());
        result = prime * result + ((getProcessorMobile() == null) ? 0 : getProcessorMobile().hashCode());
        result = prime * result + ((getProcessorTime() == null) ? 0 : getProcessorTime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getOutDetail() == null) ? 0 : getOutDetail().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }
}