package com.rfchina.community.entity.communityService;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ExtCommunityServiceTemp implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String title;

    private String png;

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

    private Integer merchantId;

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

//    private BigDecimal commissionRate;

    private BigDecimal communityRate;

    private Integer userRange;

    private String categoryName;

    private String merchantName;

    private int merchantType;

    private int likeCount;

    private int unlikeCount;

    private int communityCount;

    private Integer groundAuditStatus;

    private String shot;

    private String accountReceivableProject;

    private int communityAddedCount;

    private String underReason;

    private String communityIds;

    private String notifyUrl;

    private String balanceReceiveEmail;

    private Date groundTime;

    private int payStatus;

    private String payComment;

    private BigDecimal platformServiceFee;

    private String serviceNeed;

    private String keyword;

    private String bannerUrl;

    private Integer subCategoryId;

    private String subCategoryName;

    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Integer subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     *
     */
    private Object openServiceDetail;

    public BigDecimal getPlatformServiceFee() {
        return platformServiceFee;
    }

    public void setPlatformServiceFee(BigDecimal platformServiceFee) {
        this.platformServiceFee = platformServiceFee;
    }

    public String getPayComment() {
        return payComment;
    }

    public void setPayComment(String payComment) {
        this.payComment = payComment;
    }

    public int getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(int payStatus) {
        this.payStatus = payStatus;
    }

    public Date getGroundTime() {
        return groundTime;
    }

    public void setGroundTime(Date groundTime) {
        this.groundTime = groundTime;
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

    public String getCommunityIds() {
        return communityIds;
    }

    public void setCommunityIds(String communityIds) {
        this.communityIds = communityIds;
    }


    public String getUnderReason() {
        return underReason;
    }

    public void setUnderReason(String underReason) {
        this.underReason = underReason;
    }

    public int getCommunityAddedCount() {
        return communityAddedCount;
    }

    public void setCommunityAddedCount(int communityAddedCount) {
        this.communityAddedCount = communityAddedCount;
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

    public int getCommunityCount() {
        return communityCount;
    }

    public void setCommunityCount(int communityCount) {
        this.communityCount = communityCount;
    }

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

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
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

//	public BigDecimal getCommissionRate() {
//		return commissionRate;
//	}
//
//	public void setCommissionRate(BigDecimal commissionRate) {
//		this.commissionRate = commissionRate;
//	}

    public Integer getUserRange() {
        return userRange;
    }

    public void setUserRange(Integer userRange) {
        this.userRange = userRange;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public int getMerchantType() {
        return merchantType;
    }

    public void setMerchantType(int merchantType) {
        this.merchantType = merchantType;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getUnlikeCount() {
        return unlikeCount;
    }

    public void setUnlikeCount(int unlikeCount) {
        this.unlikeCount = unlikeCount;
    }

    public String getServiceNeed() {
        return serviceNeed;
    }

    public void setServiceNeed(String serviceNeed) {
        this.serviceNeed = serviceNeed;
    }


    public Object getOpenServiceDetail() {
        return openServiceDetail;
    }

    public void setOpenServiceDetail(Object openServiceDetail) {
        this.openServiceDetail = openServiceDetail;
    }

    public BigDecimal getCommunityRate() {
        return communityRate;
    }

    public void setCommunityRate(BigDecimal communityRate) {
        this.communityRate = communityRate;
    }

}
