package com.rfchina.community.persistence.model;

import java.io.Serializable;

public class CommunityServiceWithBLOBs extends CommunityService implements Serializable {
    private String clause;

    private String description;

    private static final long serialVersionUID = 1L;

    public String getClause() {
        return clause;
    }

    public void setClause(String clause) {
        this.clause = clause;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", clause=").append(clause);
        sb.append(", description=").append(description);
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
        CommunityServiceWithBLOBs other = (CommunityServiceWithBLOBs) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getPng() == null ? other.getPng() == null : this.getPng().equals(other.getPng()))
            && (this.getReorder() == null ? other.getReorder() == null : this.getReorder().equals(other.getReorder()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getIsAccount() == null ? other.getIsAccount() == null : this.getIsAccount().equals(other.getIsAccount()))
            && (this.getLink() == null ? other.getLink() == null : this.getLink().equals(other.getLink()))
            && (this.getProvideType() == null ? other.getProvideType() == null : this.getProvideType().equals(other.getProvideType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getAppId() == null ? other.getAppId() == null : this.getAppId().equals(other.getAppId()))
            && (this.getAuditComment() == null ? other.getAuditComment() == null : this.getAuditComment().equals(other.getAuditComment()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getAuditTime() == null ? other.getAuditTime() == null : this.getAuditTime().equals(other.getAuditTime()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getIsNeedHardware() == null ? other.getIsNeedHardware() == null : this.getIsNeedHardware().equals(other.getIsNeedHardware()))
            && (this.getTargetMonthTurnover() == null ? other.getTargetMonthTurnover() == null : this.getTargetMonthTurnover().equals(other.getTargetMonthTurnover()))
            && (this.getPaidCautionMoney() == null ? other.getPaidCautionMoney() == null : this.getPaidCautionMoney().equals(other.getPaidCautionMoney()))
            && (this.getCautionMoneyStatus() == null ? other.getCautionMoneyStatus() == null : this.getCautionMoneyStatus().equals(other.getCautionMoneyStatus()))
            && (this.getGroundMode() == null ? other.getGroundMode() == null : this.getGroundMode().equals(other.getGroundMode()))
            && (this.getMerchantId() == null ? other.getMerchantId() == null : this.getMerchantId().equals(other.getMerchantId()))
            && (this.getAccountId() == null ? other.getAccountId() == null : this.getAccountId().equals(other.getAccountId()))
            && (this.getAuditStatus() == null ? other.getAuditStatus() == null : this.getAuditStatus().equals(other.getAuditStatus()))
            && (this.getClauseId() == null ? other.getClauseId() == null : this.getClauseId().equals(other.getClauseId()))
            && (this.getClause() == null ? other.getClause() == null : this.getClause().equals(other.getClause()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getPng() == null) ? 0 : getPng().hashCode());
        result = prime * result + ((getReorder() == null) ? 0 : getReorder().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getIsAccount() == null) ? 0 : getIsAccount().hashCode());
        result = prime * result + ((getLink() == null) ? 0 : getLink().hashCode());
        result = prime * result + ((getProvideType() == null) ? 0 : getProvideType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAppId() == null) ? 0 : getAppId().hashCode());
        result = prime * result + ((getAuditComment() == null) ? 0 : getAuditComment().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getAuditTime() == null) ? 0 : getAuditTime().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getIsNeedHardware() == null) ? 0 : getIsNeedHardware().hashCode());
        result = prime * result + ((getTargetMonthTurnover() == null) ? 0 : getTargetMonthTurnover().hashCode());
        result = prime * result + ((getPaidCautionMoney() == null) ? 0 : getPaidCautionMoney().hashCode());
        result = prime * result + ((getCautionMoneyStatus() == null) ? 0 : getCautionMoneyStatus().hashCode());
        result = prime * result + ((getGroundMode() == null) ? 0 : getGroundMode().hashCode());
        result = prime * result + ((getMerchantId() == null) ? 0 : getMerchantId().hashCode());
        result = prime * result + ((getAccountId() == null) ? 0 : getAccountId().hashCode());
        result = prime * result + ((getAuditStatus() == null) ? 0 : getAuditStatus().hashCode());
        result = prime * result + ((getClauseId() == null) ? 0 : getClauseId().hashCode());
        result = prime * result + ((getClause() == null) ? 0 : getClause().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        return result;
    }
}