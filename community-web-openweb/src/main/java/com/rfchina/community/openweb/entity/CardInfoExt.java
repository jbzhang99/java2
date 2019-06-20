package com.rfchina.community.openweb.entity;


import com.rfchina.community.persistence.model.CardInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 */
public class CardInfoExt extends CardInfo implements Serializable {

    private String cardCategoryName;

    private Integer userFavor;

    private Integer likeCount = 0;

    private Integer unlikeCount = 0;

    private Integer shareCount = 0;

    private Integer commentCount = 0;

    private List<Image> imageList = new ArrayList<>();

    private Video video = null;

    private String communityName;

    private Integer cityId;

    private String cityName;

    public String getCardCategoryName() {
        return cardCategoryName;
    }

    public void setCardCategoryName(String cardCategoryName) {
        this.cardCategoryName = cardCategoryName;
    }

    public Integer getUserFavor() {
        return userFavor;
    }

    public void setUserFavor(Integer userFavor) {
        this.userFavor = userFavor;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getUnlikeCount() {
        return unlikeCount;
    }

    public void setUnlikeCount(Integer unlikeCount) {
        this.unlikeCount = unlikeCount;
    }

    public Integer getShareCount() {
        return shareCount;
    }

    public void setShareCount(Integer shareCount) {
        this.shareCount = shareCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "CardInfoExt{" +
                "cardCategoryName='" + cardCategoryName + '\'' +
                ", userFavor=" + userFavor +
                ", likeCount=" + likeCount +
                ", unlikeCount=" + unlikeCount +
                ", shareCount=" + shareCount +
                ", commentCount=" + commentCount +
                ", imageList=" + imageList +
                ", video=" + video +
                ", cityId=" + cityId +
                ", cityName=" + cityName +
                ", communityName=" + communityName +
                '}';
    }
}
