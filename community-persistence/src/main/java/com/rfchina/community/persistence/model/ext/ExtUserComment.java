package com.rfchina.community.persistence.model.ext;

import com.rfchina.community.persistence.model.UserComment;
import com.rfchina.community.persistence.model.UserCommentReply;

import java.util.List;

/**
 * @ClassName ExtUserComment
 * @Description TODO
 * @Author wlrllr
 * @Date 2019/2/21 10:44
 * @Version 1.0
 **/
public class ExtUserComment extends UserComment {

    private String userTelephone;

    private String goodsInfo;

    private Double goodsPrice;

    private UserCommentReply reply; //回复内容

    private String serviceName; //店铺

    private String communityName; //社区

    private String userPic;

    private String nickName;

    private String merchantName;

    private List<UserCommentReply> replies;

    private Long totalNum;

    private String goodsPicUrl;

    public String getUserTelephone() {
        return userTelephone;
    }

    public void setUserTelephone(String userTelephone) {
        this.userTelephone = userTelephone;
    }

    public String getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(String goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public UserCommentReply getReply() {
        return reply;
    }

    public void setReply(UserCommentReply reply) {
        this.reply = reply;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public List<UserCommentReply> getReplies() {
        return replies;
    }

    public void setReplies(List<UserCommentReply> replies) {
        this.replies = replies;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public Long getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Long totalNum) {
        this.totalNum = totalNum;
    }

    public String getGoodsPicUrl() {
        return goodsPicUrl;
    }

    public void setGoodsPicUrl(String goodsPicUrl) {
        this.goodsPicUrl = goodsPicUrl;
    }
}
