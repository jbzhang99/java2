package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CommunityService implements Serializable {
    private Integer id;

    private String title;

    private String png;

    private String disablePng;

    private Integer reorder;

    private String clause;

    private Integer type;

    private Integer isAccount;

    private String link;

    private Integer provideType;

    private Integer status;

    private Long appId;

    private String description;

    private String auditComment;

    private Date createTime;

    private Date updateTime;

    private Date auditTime;

    private Integer categoryId;

    private Integer isNeedHardware;

    private BigDecimal targetMonthTurnover;

    private BigDecimal paidCautionMoney;

    private Integer cautionMoneyStatus;

    private Integer groundMode;

    private Long merchantId;

    private String accountId;

    private Integer auditStatus;

    private Integer clauseId;

    private String appSecret;

    private BigDecimal receivableCautionMoney;

    private Double recommendLevel;

    private Integer cautionMoneyType;

    private String cautionMoneyPic;

    private String remark;

    private String cautionBillId;

    private Integer userRange;

    private Integer groundAuditStatus;

    private String shot;

    private String accountReceivableProject;

    private String notifyUrl;

    private String balanceReceiveEmail;

    private String underReason;

    private Date groundTime;

    private String maxIosVersion;

    private String minIosVersion;

    private String maxAndoirdVersion;

    private String minAndoirdVersion;

    private String serviceNeed;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPng() {
        return png;
    }

    public void setPng(String png) {
        this.png = png;
    }

    public String getDisablePng() {
        return disablePng;
    }

    public void setDisablePng(String disablePng) {
        this.disablePng = disablePng;
    }

    public Integer getReorder() {
        return reorder;
    }

    public void setReorder(Integer reorder) {
        this.reorder = reorder;
    }

    public String getClause() {
        return clause;
    }

    public void setClause(String clause) {
        this.clause = clause;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIsAccount() {
        return isAccount;
    }

    public void setIsAccount(Integer isAccount) {
        this.isAccount = isAccount;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getProvideType() {
        return provideType;
    }

    public void setProvideType(Integer provideType) {
        this.provideType = provideType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuditComment() {
        return auditComment;
    }

    public void setAuditComment(String auditComment) {
        this.auditComment = auditComment;
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

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getIsNeedHardware() {
        return isNeedHardware;
    }

    public void setIsNeedHardware(Integer isNeedHardware) {
        this.isNeedHardware = isNeedHardware;
    }

    public BigDecimal getTargetMonthTurnover() {
        return targetMonthTurnover;
    }

    public void setTargetMonthTurnover(BigDecimal targetMonthTurnover) {
        this.targetMonthTurnover = targetMonthTurnover;
    }

    public BigDecimal getPaidCautionMoney() {
        return paidCautionMoney;
    }

    public void setPaidCautionMoney(BigDecimal paidCautionMoney) {
        this.paidCautionMoney = paidCautionMoney;
    }

    public Integer getCautionMoneyStatus() {
        return cautionMoneyStatus;
    }

    public void setCautionMoneyStatus(Integer cautionMoneyStatus) {
        this.cautionMoneyStatus = cautionMoneyStatus;
    }

    public Integer getGroundMode() {
        return groundMode;
    }

    public void setGroundMode(Integer groundMode) {
        this.groundMode = groundMode;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Integer getClauseId() {
        return clauseId;
    }

    public void setClauseId(Integer clauseId) {
        this.clauseId = clauseId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public BigDecimal getReceivableCautionMoney() {
        return receivableCautionMoney;
    }

    public void setReceivableCautionMoney(BigDecimal receivableCautionMoney) {
        this.receivableCautionMoney = receivableCautionMoney;
    }

    public Double getRecommendLevel() {
        return recommendLevel;
    }

    public void setRecommendLevel(Double recommendLevel) {
        this.recommendLevel = recommendLevel;
    }

    public Integer getCautionMoneyType() {
        return cautionMoneyType;
    }

    public void setCautionMoneyType(Integer cautionMoneyType) {
        this.cautionMoneyType = cautionMoneyType;
    }

    public String getCautionMoneyPic() {
        return cautionMoneyPic;
    }

    public void setCautionMoneyPic(String cautionMoneyPic) {
        this.cautionMoneyPic = cautionMoneyPic;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCautionBillId() {
        return cautionBillId;
    }

    public void setCautionBillId(String cautionBillId) {
        this.cautionBillId = cautionBillId;
    }

    public Integer getUserRange() {
        return userRange;
    }

    public void setUserRange(Integer userRange) {
        this.userRange = userRange;
    }

    public Integer getGroundAuditStatus() {
        return groundAuditStatus;
    }

    public void setGroundAuditStatus(Integer groundAuditStatus) {
        this.groundAuditStatus = groundAuditStatus;
    }

    public String getShot() {
        return shot;
    }

    public void setShot(String shot) {
        this.shot = shot;
    }

    public String getAccountReceivableProject() {
        return accountReceivableProject;
    }

    public void setAccountReceivableProject(String accountReceivableProject) {
        this.accountReceivableProject = accountReceivableProject;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getBalanceReceiveEmail() {
        return balanceReceiveEmail;
    }

    public void setBalanceReceiveEmail(String balanceReceiveEmail) {
        this.balanceReceiveEmail = balanceReceiveEmail;
    }

    public String getUnderReason() {
        return underReason;
    }

    public void setUnderReason(String underReason) {
        this.underReason = underReason;
    }

    public Date getGroundTime() {
        return groundTime;
    }

    public void setGroundTime(Date groundTime) {
        this.groundTime = groundTime;
    }

    public String getMaxIosVersion() {
        return maxIosVersion;
    }

    public void setMaxIosVersion(String maxIosVersion) {
        this.maxIosVersion = maxIosVersion;
    }

    public String getMinIosVersion() {
        return minIosVersion;
    }

    public void setMinIosVersion(String minIosVersion) {
        this.minIosVersion = minIosVersion;
    }

    public String getMaxAndoirdVersion() {
        return maxAndoirdVersion;
    }

    public void setMaxAndoirdVersion(String maxAndoirdVersion) {
        this.maxAndoirdVersion = maxAndoirdVersion;
    }

    public String getMinAndoirdVersion() {
        return minAndoirdVersion;
    }

    public void setMinAndoirdVersion(String minAndoirdVersion) {
        this.minAndoirdVersion = minAndoirdVersion;
    }

    public String getServiceNeed() {
        return serviceNeed;
    }

    public void setServiceNeed(String serviceNeed) {
        this.serviceNeed = serviceNeed;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", png=").append(png);
        sb.append(", disablePng=").append(disablePng);
        sb.append(", reorder=").append(reorder);
        sb.append(", clause=").append(clause);
        sb.append(", type=").append(type);
        sb.append(", isAccount=").append(isAccount);
        sb.append(", link=").append(link);
        sb.append(", provideType=").append(provideType);
        sb.append(", status=").append(status);
        sb.append(", appId=").append(appId);
        sb.append(", description=").append(description);
        sb.append(", auditComment=").append(auditComment);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", auditTime=").append(auditTime);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", isNeedHardware=").append(isNeedHardware);
        sb.append(", targetMonthTurnover=").append(targetMonthTurnover);
        sb.append(", paidCautionMoney=").append(paidCautionMoney);
        sb.append(", cautionMoneyStatus=").append(cautionMoneyStatus);
        sb.append(", groundMode=").append(groundMode);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", accountId=").append(accountId);
        sb.append(", auditStatus=").append(auditStatus);
        sb.append(", clauseId=").append(clauseId);
        sb.append(", appSecret=").append(appSecret);
        sb.append(", receivableCautionMoney=").append(receivableCautionMoney);
        sb.append(", recommendLevel=").append(recommendLevel);
        sb.append(", cautionMoneyType=").append(cautionMoneyType);
        sb.append(", cautionMoneyPic=").append(cautionMoneyPic);
        sb.append(", remark=").append(remark);
        sb.append(", cautionBillId=").append(cautionBillId);
        sb.append(", userRange=").append(userRange);
        sb.append(", groundAuditStatus=").append(groundAuditStatus);
        sb.append(", shot=").append(shot);
        sb.append(", accountReceivableProject=").append(accountReceivableProject);
        sb.append(", notifyUrl=").append(notifyUrl);
        sb.append(", balanceReceiveEmail=").append(balanceReceiveEmail);
        sb.append(", underReason=").append(underReason);
        sb.append(", groundTime=").append(groundTime);
        sb.append(", maxIosVersion=").append(maxIosVersion);
        sb.append(", minIosVersion=").append(minIosVersion);
        sb.append(", maxAndoirdVersion=").append(maxAndoirdVersion);
        sb.append(", minAndoirdVersion=").append(minAndoirdVersion);
        sb.append(", serviceNeed=").append(serviceNeed);
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
        CommunityService other = (CommunityService) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getPng() == null ? other.getPng() == null : this.getPng().equals(other.getPng()))
            && (this.getDisablePng() == null ? other.getDisablePng() == null : this.getDisablePng().equals(other.getDisablePng()))
            && (this.getReorder() == null ? other.getReorder() == null : this.getReorder().equals(other.getReorder()))
            && (this.getClause() == null ? other.getClause() == null : this.getClause().equals(other.getClause()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getIsAccount() == null ? other.getIsAccount() == null : this.getIsAccount().equals(other.getIsAccount()))
            && (this.getLink() == null ? other.getLink() == null : this.getLink().equals(other.getLink()))
            && (this.getProvideType() == null ? other.getProvideType() == null : this.getProvideType().equals(other.getProvideType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getAppId() == null ? other.getAppId() == null : this.getAppId().equals(other.getAppId()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
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
            && (this.getAppSecret() == null ? other.getAppSecret() == null : this.getAppSecret().equals(other.getAppSecret()))
            && (this.getReceivableCautionMoney() == null ? other.getReceivableCautionMoney() == null : this.getReceivableCautionMoney().equals(other.getReceivableCautionMoney()))
            && (this.getRecommendLevel() == null ? other.getRecommendLevel() == null : this.getRecommendLevel().equals(other.getRecommendLevel()))
            && (this.getCautionMoneyType() == null ? other.getCautionMoneyType() == null : this.getCautionMoneyType().equals(other.getCautionMoneyType()))
            && (this.getCautionMoneyPic() == null ? other.getCautionMoneyPic() == null : this.getCautionMoneyPic().equals(other.getCautionMoneyPic()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCautionBillId() == null ? other.getCautionBillId() == null : this.getCautionBillId().equals(other.getCautionBillId()))
            && (this.getUserRange() == null ? other.getUserRange() == null : this.getUserRange().equals(other.getUserRange()))
            && (this.getGroundAuditStatus() == null ? other.getGroundAuditStatus() == null : this.getGroundAuditStatus().equals(other.getGroundAuditStatus()))
            && (this.getShot() == null ? other.getShot() == null : this.getShot().equals(other.getShot()))
            && (this.getAccountReceivableProject() == null ? other.getAccountReceivableProject() == null : this.getAccountReceivableProject().equals(other.getAccountReceivableProject()))
            && (this.getNotifyUrl() == null ? other.getNotifyUrl() == null : this.getNotifyUrl().equals(other.getNotifyUrl()))
            && (this.getBalanceReceiveEmail() == null ? other.getBalanceReceiveEmail() == null : this.getBalanceReceiveEmail().equals(other.getBalanceReceiveEmail()))
            && (this.getUnderReason() == null ? other.getUnderReason() == null : this.getUnderReason().equals(other.getUnderReason()))
            && (this.getGroundTime() == null ? other.getGroundTime() == null : this.getGroundTime().equals(other.getGroundTime()))
            && (this.getMaxIosVersion() == null ? other.getMaxIosVersion() == null : this.getMaxIosVersion().equals(other.getMaxIosVersion()))
            && (this.getMinIosVersion() == null ? other.getMinIosVersion() == null : this.getMinIosVersion().equals(other.getMinIosVersion()))
            && (this.getMaxAndoirdVersion() == null ? other.getMaxAndoirdVersion() == null : this.getMaxAndoirdVersion().equals(other.getMaxAndoirdVersion()))
            && (this.getMinAndoirdVersion() == null ? other.getMinAndoirdVersion() == null : this.getMinAndoirdVersion().equals(other.getMinAndoirdVersion()))
            && (this.getServiceNeed() == null ? other.getServiceNeed() == null : this.getServiceNeed().equals(other.getServiceNeed()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getPng() == null) ? 0 : getPng().hashCode());
        result = prime * result + ((getDisablePng() == null) ? 0 : getDisablePng().hashCode());
        result = prime * result + ((getReorder() == null) ? 0 : getReorder().hashCode());
        result = prime * result + ((getClause() == null) ? 0 : getClause().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getIsAccount() == null) ? 0 : getIsAccount().hashCode());
        result = prime * result + ((getLink() == null) ? 0 : getLink().hashCode());
        result = prime * result + ((getProvideType() == null) ? 0 : getProvideType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAppId() == null) ? 0 : getAppId().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
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
        result = prime * result + ((getAppSecret() == null) ? 0 : getAppSecret().hashCode());
        result = prime * result + ((getReceivableCautionMoney() == null) ? 0 : getReceivableCautionMoney().hashCode());
        result = prime * result + ((getRecommendLevel() == null) ? 0 : getRecommendLevel().hashCode());
        result = prime * result + ((getCautionMoneyType() == null) ? 0 : getCautionMoneyType().hashCode());
        result = prime * result + ((getCautionMoneyPic() == null) ? 0 : getCautionMoneyPic().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCautionBillId() == null) ? 0 : getCautionBillId().hashCode());
        result = prime * result + ((getUserRange() == null) ? 0 : getUserRange().hashCode());
        result = prime * result + ((getGroundAuditStatus() == null) ? 0 : getGroundAuditStatus().hashCode());
        result = prime * result + ((getShot() == null) ? 0 : getShot().hashCode());
        result = prime * result + ((getAccountReceivableProject() == null) ? 0 : getAccountReceivableProject().hashCode());
        result = prime * result + ((getNotifyUrl() == null) ? 0 : getNotifyUrl().hashCode());
        result = prime * result + ((getBalanceReceiveEmail() == null) ? 0 : getBalanceReceiveEmail().hashCode());
        result = prime * result + ((getUnderReason() == null) ? 0 : getUnderReason().hashCode());
        result = prime * result + ((getGroundTime() == null) ? 0 : getGroundTime().hashCode());
        result = prime * result + ((getMaxIosVersion() == null) ? 0 : getMaxIosVersion().hashCode());
        result = prime * result + ((getMinIosVersion() == null) ? 0 : getMinIosVersion().hashCode());
        result = prime * result + ((getMaxAndoirdVersion() == null) ? 0 : getMaxAndoirdVersion().hashCode());
        result = prime * result + ((getMinAndoirdVersion() == null) ? 0 : getMinAndoirdVersion().hashCode());
        result = prime * result + ((getServiceNeed() == null) ? 0 : getServiceNeed().hashCode());
        return result;
    }
}