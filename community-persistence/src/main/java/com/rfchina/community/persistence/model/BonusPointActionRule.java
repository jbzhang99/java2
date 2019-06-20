package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class BonusPointActionRule implements Serializable {
    private Integer id;

    private String action;

    private String bpRule;

    private Integer bpValue;

    private String bpRuleDesc;

    private String rewardRule;

    private Integer rewardValue;

    private Date startActiveTime;

    private Date endActiveTime;

    private Boolean active;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getBpRule() {
        return bpRule;
    }

    public void setBpRule(String bpRule) {
        this.bpRule = bpRule;
    }

    public Integer getBpValue() {
        return bpValue;
    }

    public void setBpValue(Integer bpValue) {
        this.bpValue = bpValue;
    }

    public String getBpRuleDesc() {
        return bpRuleDesc;
    }

    public void setBpRuleDesc(String bpRuleDesc) {
        this.bpRuleDesc = bpRuleDesc;
    }

    public String getRewardRule() {
        return rewardRule;
    }

    public void setRewardRule(String rewardRule) {
        this.rewardRule = rewardRule;
    }

    public Integer getRewardValue() {
        return rewardValue;
    }

    public void setRewardValue(Integer rewardValue) {
        this.rewardValue = rewardValue;
    }

    public Date getStartActiveTime() {
        return startActiveTime;
    }

    public void setStartActiveTime(Date startActiveTime) {
        this.startActiveTime = startActiveTime;
    }

    public Date getEndActiveTime() {
        return endActiveTime;
    }

    public void setEndActiveTime(Date endActiveTime) {
        this.endActiveTime = endActiveTime;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", action=").append(action);
        sb.append(", bpRule=").append(bpRule);
        sb.append(", bpValue=").append(bpValue);
        sb.append(", bpRuleDesc=").append(bpRuleDesc);
        sb.append(", rewardRule=").append(rewardRule);
        sb.append(", rewardValue=").append(rewardValue);
        sb.append(", startActiveTime=").append(startActiveTime);
        sb.append(", endActiveTime=").append(endActiveTime);
        sb.append(", active=").append(active);
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
        BonusPointActionRule other = (BonusPointActionRule) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAction() == null ? other.getAction() == null : this.getAction().equals(other.getAction()))
            && (this.getBpRule() == null ? other.getBpRule() == null : this.getBpRule().equals(other.getBpRule()))
            && (this.getBpValue() == null ? other.getBpValue() == null : this.getBpValue().equals(other.getBpValue()))
            && (this.getBpRuleDesc() == null ? other.getBpRuleDesc() == null : this.getBpRuleDesc().equals(other.getBpRuleDesc()))
            && (this.getRewardRule() == null ? other.getRewardRule() == null : this.getRewardRule().equals(other.getRewardRule()))
            && (this.getRewardValue() == null ? other.getRewardValue() == null : this.getRewardValue().equals(other.getRewardValue()))
            && (this.getStartActiveTime() == null ? other.getStartActiveTime() == null : this.getStartActiveTime().equals(other.getStartActiveTime()))
            && (this.getEndActiveTime() == null ? other.getEndActiveTime() == null : this.getEndActiveTime().equals(other.getEndActiveTime()))
            && (this.getActive() == null ? other.getActive() == null : this.getActive().equals(other.getActive()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAction() == null) ? 0 : getAction().hashCode());
        result = prime * result + ((getBpRule() == null) ? 0 : getBpRule().hashCode());
        result = prime * result + ((getBpValue() == null) ? 0 : getBpValue().hashCode());
        result = prime * result + ((getBpRuleDesc() == null) ? 0 : getBpRuleDesc().hashCode());
        result = prime * result + ((getRewardRule() == null) ? 0 : getRewardRule().hashCode());
        result = prime * result + ((getRewardValue() == null) ? 0 : getRewardValue().hashCode());
        result = prime * result + ((getStartActiveTime() == null) ? 0 : getStartActiveTime().hashCode());
        result = prime * result + ((getEndActiveTime() == null) ? 0 : getEndActiveTime().hashCode());
        result = prime * result + ((getActive() == null) ? 0 : getActive().hashCode());
        return result;
    }
}