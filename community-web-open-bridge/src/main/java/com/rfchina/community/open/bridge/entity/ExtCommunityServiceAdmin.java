package com.rfchina.community.open.bridge.entity;

import java.util.Date;

import com.rfchina.community.persistence.model.CommunityService;

public class ExtCommunityServiceAdmin extends CommunityService {


    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String categoryName;

    private String merchantName;

    private int merchantType;

    private int likeCount;

    private int unlikeCount;

    private int communityCount;

    private int communityAddedCount;

    private int selectStatus;

    private int communityAuditStatus;

    private Date applyTime;

    private String communityAuditComment;

    private int communityServiceStatus;

    private int isMenuShow;

    private int communityServiceReorder;

    public int getIsMenuShow() {
        return isMenuShow;
    }

    public void setIsMenuShow(int isMenuShow) {
        this.isMenuShow = isMenuShow;
    }

    public int getCommunityServiceReorder() {
        return communityServiceReorder;
    }

    public void setCommunityServiceReorder(int communityServiceReorder) {
        this.communityServiceReorder = communityServiceReorder;
    }

    public int getCommunityServiceStatus() {
        return communityServiceStatus;
    }

    public void setCommunityServiceStatus(int communityServiceStatus) {
        this.communityServiceStatus = communityServiceStatus;
    }

    public String getCommunityAuditComment() {
        return communityAuditComment;
    }

    public void setCommunityAuditComment(String communityAuditComment) {
        this.communityAuditComment = communityAuditComment;
    }

    public int getCommunityAuditStatus() {
        return communityAuditStatus;
    }

    public void setCommunityAuditStatus(int communityAuditStatus) {
        this.communityAuditStatus = communityAuditStatus;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
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

    public int getCommunityCount() {
        return communityCount;
    }

    public void setCommunityCount(int communityCount) {
        this.communityCount = communityCount;
    }

    public int getCommunityAddedCount() {
        return communityAddedCount;
    }

    public void setCommunityAddedCount(int communityAddedCount) {
        this.communityAddedCount = communityAddedCount;
    }

    public int getSelectStatus() {
        return selectStatus;
    }

    public void setSelectStatus(int selectStatus) {
        this.selectStatus = selectStatus;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
