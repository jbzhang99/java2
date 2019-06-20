package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class OpenStoreGoodStockDetail implements Serializable {
    private Long id;

    private String type;

    private Long groupDataId;

    private Long groupInfoId;

    private Integer goodId;

    private String source;

    private String operate;

    private Integer beforeValue;

    private Integer afterValue;

    private Integer amount;

    private Integer targetId;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getGroupDataId() {
        return groupDataId;
    }

    public void setGroupDataId(Long groupDataId) {
        this.groupDataId = groupDataId;
    }

    public Long getGroupInfoId() {
        return groupInfoId;
    }

    public void setGroupInfoId(Long groupInfoId) {
        this.groupInfoId = groupInfoId;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public Integer getBeforeValue() {
        return beforeValue;
    }

    public void setBeforeValue(Integer beforeValue) {
        this.beforeValue = beforeValue;
    }

    public Integer getAfterValue() {
        return afterValue;
    }

    public void setAfterValue(Integer afterValue) {
        this.afterValue = afterValue;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
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
        sb.append(", type=").append(type);
        sb.append(", groupDataId=").append(groupDataId);
        sb.append(", groupInfoId=").append(groupInfoId);
        sb.append(", goodId=").append(goodId);
        sb.append(", source=").append(source);
        sb.append(", operate=").append(operate);
        sb.append(", beforeValue=").append(beforeValue);
        sb.append(", afterValue=").append(afterValue);
        sb.append(", amount=").append(amount);
        sb.append(", targetId=").append(targetId);
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
        OpenStoreGoodStockDetail other = (OpenStoreGoodStockDetail) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getGroupDataId() == null ? other.getGroupDataId() == null : this.getGroupDataId().equals(other.getGroupDataId()))
            && (this.getGroupInfoId() == null ? other.getGroupInfoId() == null : this.getGroupInfoId().equals(other.getGroupInfoId()))
            && (this.getGoodId() == null ? other.getGoodId() == null : this.getGoodId().equals(other.getGoodId()))
            && (this.getSource() == null ? other.getSource() == null : this.getSource().equals(other.getSource()))
            && (this.getOperate() == null ? other.getOperate() == null : this.getOperate().equals(other.getOperate()))
            && (this.getBeforeValue() == null ? other.getBeforeValue() == null : this.getBeforeValue().equals(other.getBeforeValue()))
            && (this.getAfterValue() == null ? other.getAfterValue() == null : this.getAfterValue().equals(other.getAfterValue()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getTargetId() == null ? other.getTargetId() == null : this.getTargetId().equals(other.getTargetId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getGroupDataId() == null) ? 0 : getGroupDataId().hashCode());
        result = prime * result + ((getGroupInfoId() == null) ? 0 : getGroupInfoId().hashCode());
        result = prime * result + ((getGoodId() == null) ? 0 : getGoodId().hashCode());
        result = prime * result + ((getSource() == null) ? 0 : getSource().hashCode());
        result = prime * result + ((getOperate() == null) ? 0 : getOperate().hashCode());
        result = prime * result + ((getBeforeValue() == null) ? 0 : getBeforeValue().hashCode());
        result = prime * result + ((getAfterValue() == null) ? 0 : getAfterValue().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getTargetId() == null) ? 0 : getTargetId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}