package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OpenStoreOrder implements Serializable {
    private Integer id;

    private Long userId;

    private String openId;

    private Long communityId;

    private Integer serviceId;

    private Integer addrInfoId;

    private String addrInfo;

    private String addrDetail;

    private String userName;

    private String mobile;

    private String orderCode;

    private String outTradeNo;

    private BigDecimal expressMoney;

    private BigDecimal goodsTotal;

    private BigDecimal originalPrice;

    private BigDecimal discountPrice;

    private BigDecimal totalAmount;

    private BigDecimal couponPrice;

    private String verifyStatus;

    private String subject;

    private String body;

    private String detail;

    private String expressType;

    private String expressName;

    private String expressCompanyCode;

    private String expressCode;

    private Integer expressStatus;

    private Date signForTime;

    private String expressTime;

    private String expressArea;

    private String expressPhone;

    private Integer payStatus;

    private String payChannel;

    private Integer sendStatus;

    private Date sendTime;

    private Date refundTime;

    private Date payTime;

    private Integer refundStatus;

    private String refundApproval;

    private String refundComment;

    private String refundRemark;

    private Integer resultStatus;

    private Integer sameWay;

    private Long openRefundId;

    private String remark;

    private Date createTime;

    private Date invalidTime;

    private Date confirmTime;

    private Integer resourceType;

    private Long couponRecordId;

    private String type;

    private Long xfsjId;

    private String commentStatus;

    private Integer groupStatus;

    private Long groupInfoId;

    private Long groupDataId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getAddrInfoId() {
        return addrInfoId;
    }

    public void setAddrInfoId(Integer addrInfoId) {
        this.addrInfoId = addrInfoId;
    }

    public String getAddrInfo() {
        return addrInfo;
    }

    public void setAddrInfo(String addrInfo) {
        this.addrInfo = addrInfo;
    }

    public String getAddrDetail() {
        return addrDetail;
    }

    public void setAddrDetail(String addrDetail) {
        this.addrDetail = addrDetail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public BigDecimal getExpressMoney() {
        return expressMoney;
    }

    public void setExpressMoney(BigDecimal expressMoney) {
        this.expressMoney = expressMoney;
    }

    public BigDecimal getGoodsTotal() {
        return goodsTotal;
    }

    public void setGoodsTotal(BigDecimal goodsTotal) {
        this.goodsTotal = goodsTotal;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(BigDecimal couponPrice) {
        this.couponPrice = couponPrice;
    }

    public String getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(String verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getExpressType() {
        return expressType;
    }

    public void setExpressType(String expressType) {
        this.expressType = expressType;
    }

    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }

    public String getExpressCompanyCode() {
        return expressCompanyCode;
    }

    public void setExpressCompanyCode(String expressCompanyCode) {
        this.expressCompanyCode = expressCompanyCode;
    }

    public String getExpressCode() {
        return expressCode;
    }

    public void setExpressCode(String expressCode) {
        this.expressCode = expressCode;
    }

    public Integer getExpressStatus() {
        return expressStatus;
    }

    public void setExpressStatus(Integer expressStatus) {
        this.expressStatus = expressStatus;
    }

    public Date getSignForTime() {
        return signForTime;
    }

    public void setSignForTime(Date signForTime) {
        this.signForTime = signForTime;
    }

    public String getExpressTime() {
        return expressTime;
    }

    public void setExpressTime(String expressTime) {
        this.expressTime = expressTime;
    }

    public String getExpressArea() {
        return expressArea;
    }

    public void setExpressArea(String expressArea) {
        this.expressArea = expressArea;
    }

    public String getExpressPhone() {
        return expressPhone;
    }

    public void setExpressPhone(String expressPhone) {
        this.expressPhone = expressPhone;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }

    public Integer getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public String getRefundApproval() {
        return refundApproval;
    }

    public void setRefundApproval(String refundApproval) {
        this.refundApproval = refundApproval;
    }

    public String getRefundComment() {
        return refundComment;
    }

    public void setRefundComment(String refundComment) {
        this.refundComment = refundComment;
    }

    public String getRefundRemark() {
        return refundRemark;
    }

    public void setRefundRemark(String refundRemark) {
        this.refundRemark = refundRemark;
    }

    public Integer getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(Integer resultStatus) {
        this.resultStatus = resultStatus;
    }

    public Integer getSameWay() {
        return sameWay;
    }

    public void setSameWay(Integer sameWay) {
        this.sameWay = sameWay;
    }

    public Long getOpenRefundId() {
        return openRefundId;
    }

    public void setOpenRefundId(Long openRefundId) {
        this.openRefundId = openRefundId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getInvalidTime() {
        return invalidTime;
    }

    public void setInvalidTime(Date invalidTime) {
        this.invalidTime = invalidTime;
    }

    public Date getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }

    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }

    public Long getCouponRecordId() {
        return couponRecordId;
    }

    public void setCouponRecordId(Long couponRecordId) {
        this.couponRecordId = couponRecordId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getXfsjId() {
        return xfsjId;
    }

    public void setXfsjId(Long xfsjId) {
        this.xfsjId = xfsjId;
    }

    public String getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(String commentStatus) {
        this.commentStatus = commentStatus;
    }

    public Integer getGroupStatus() {
        return groupStatus;
    }

    public void setGroupStatus(Integer groupStatus) {
        this.groupStatus = groupStatus;
    }

    public Long getGroupInfoId() {
        return groupInfoId;
    }

    public void setGroupInfoId(Long groupInfoId) {
        this.groupInfoId = groupInfoId;
    }

    public Long getGroupDataId() {
        return groupDataId;
    }

    public void setGroupDataId(Long groupDataId) {
        this.groupDataId = groupDataId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", openId=").append(openId);
        sb.append(", communityId=").append(communityId);
        sb.append(", serviceId=").append(serviceId);
        sb.append(", addrInfoId=").append(addrInfoId);
        sb.append(", addrInfo=").append(addrInfo);
        sb.append(", addrDetail=").append(addrDetail);
        sb.append(", userName=").append(userName);
        sb.append(", mobile=").append(mobile);
        sb.append(", orderCode=").append(orderCode);
        sb.append(", outTradeNo=").append(outTradeNo);
        sb.append(", expressMoney=").append(expressMoney);
        sb.append(", goodsTotal=").append(goodsTotal);
        sb.append(", originalPrice=").append(originalPrice);
        sb.append(", discountPrice=").append(discountPrice);
        sb.append(", totalAmount=").append(totalAmount);
        sb.append(", couponPrice=").append(couponPrice);
        sb.append(", verifyStatus=").append(verifyStatus);
        sb.append(", subject=").append(subject);
        sb.append(", body=").append(body);
        sb.append(", detail=").append(detail);
        sb.append(", expressType=").append(expressType);
        sb.append(", expressName=").append(expressName);
        sb.append(", expressCompanyCode=").append(expressCompanyCode);
        sb.append(", expressCode=").append(expressCode);
        sb.append(", expressStatus=").append(expressStatus);
        sb.append(", signForTime=").append(signForTime);
        sb.append(", expressTime=").append(expressTime);
        sb.append(", expressArea=").append(expressArea);
        sb.append(", expressPhone=").append(expressPhone);
        sb.append(", payStatus=").append(payStatus);
        sb.append(", payChannel=").append(payChannel);
        sb.append(", sendStatus=").append(sendStatus);
        sb.append(", sendTime=").append(sendTime);
        sb.append(", refundTime=").append(refundTime);
        sb.append(", payTime=").append(payTime);
        sb.append(", refundStatus=").append(refundStatus);
        sb.append(", refundApproval=").append(refundApproval);
        sb.append(", refundComment=").append(refundComment);
        sb.append(", refundRemark=").append(refundRemark);
        sb.append(", resultStatus=").append(resultStatus);
        sb.append(", sameWay=").append(sameWay);
        sb.append(", openRefundId=").append(openRefundId);
        sb.append(", remark=").append(remark);
        sb.append(", createTime=").append(createTime);
        sb.append(", invalidTime=").append(invalidTime);
        sb.append(", confirmTime=").append(confirmTime);
        sb.append(", resourceType=").append(resourceType);
        sb.append(", couponRecordId=").append(couponRecordId);
        sb.append(", type=").append(type);
        sb.append(", xfsjId=").append(xfsjId);
        sb.append(", commentStatus=").append(commentStatus);
        sb.append(", groupStatus=").append(groupStatus);
        sb.append(", groupInfoId=").append(groupInfoId);
        sb.append(", groupDataId=").append(groupDataId);
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
        OpenStoreOrder other = (OpenStoreOrder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getOpenId() == null ? other.getOpenId() == null : this.getOpenId().equals(other.getOpenId()))
            && (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getServiceId() == null ? other.getServiceId() == null : this.getServiceId().equals(other.getServiceId()))
            && (this.getAddrInfoId() == null ? other.getAddrInfoId() == null : this.getAddrInfoId().equals(other.getAddrInfoId()))
            && (this.getAddrInfo() == null ? other.getAddrInfo() == null : this.getAddrInfo().equals(other.getAddrInfo()))
            && (this.getAddrDetail() == null ? other.getAddrDetail() == null : this.getAddrDetail().equals(other.getAddrDetail()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getOrderCode() == null ? other.getOrderCode() == null : this.getOrderCode().equals(other.getOrderCode()))
            && (this.getOutTradeNo() == null ? other.getOutTradeNo() == null : this.getOutTradeNo().equals(other.getOutTradeNo()))
            && (this.getExpressMoney() == null ? other.getExpressMoney() == null : this.getExpressMoney().equals(other.getExpressMoney()))
            && (this.getGoodsTotal() == null ? other.getGoodsTotal() == null : this.getGoodsTotal().equals(other.getGoodsTotal()))
            && (this.getOriginalPrice() == null ? other.getOriginalPrice() == null : this.getOriginalPrice().equals(other.getOriginalPrice()))
            && (this.getDiscountPrice() == null ? other.getDiscountPrice() == null : this.getDiscountPrice().equals(other.getDiscountPrice()))
            && (this.getTotalAmount() == null ? other.getTotalAmount() == null : this.getTotalAmount().equals(other.getTotalAmount()))
            && (this.getCouponPrice() == null ? other.getCouponPrice() == null : this.getCouponPrice().equals(other.getCouponPrice()))
            && (this.getVerifyStatus() == null ? other.getVerifyStatus() == null : this.getVerifyStatus().equals(other.getVerifyStatus()))
            && (this.getSubject() == null ? other.getSubject() == null : this.getSubject().equals(other.getSubject()))
            && (this.getBody() == null ? other.getBody() == null : this.getBody().equals(other.getBody()))
            && (this.getDetail() == null ? other.getDetail() == null : this.getDetail().equals(other.getDetail()))
            && (this.getExpressType() == null ? other.getExpressType() == null : this.getExpressType().equals(other.getExpressType()))
            && (this.getExpressName() == null ? other.getExpressName() == null : this.getExpressName().equals(other.getExpressName()))
            && (this.getExpressCompanyCode() == null ? other.getExpressCompanyCode() == null : this.getExpressCompanyCode().equals(other.getExpressCompanyCode()))
            && (this.getExpressCode() == null ? other.getExpressCode() == null : this.getExpressCode().equals(other.getExpressCode()))
            && (this.getExpressStatus() == null ? other.getExpressStatus() == null : this.getExpressStatus().equals(other.getExpressStatus()))
            && (this.getSignForTime() == null ? other.getSignForTime() == null : this.getSignForTime().equals(other.getSignForTime()))
            && (this.getExpressTime() == null ? other.getExpressTime() == null : this.getExpressTime().equals(other.getExpressTime()))
            && (this.getExpressArea() == null ? other.getExpressArea() == null : this.getExpressArea().equals(other.getExpressArea()))
            && (this.getExpressPhone() == null ? other.getExpressPhone() == null : this.getExpressPhone().equals(other.getExpressPhone()))
            && (this.getPayStatus() == null ? other.getPayStatus() == null : this.getPayStatus().equals(other.getPayStatus()))
            && (this.getPayChannel() == null ? other.getPayChannel() == null : this.getPayChannel().equals(other.getPayChannel()))
            && (this.getSendStatus() == null ? other.getSendStatus() == null : this.getSendStatus().equals(other.getSendStatus()))
            && (this.getSendTime() == null ? other.getSendTime() == null : this.getSendTime().equals(other.getSendTime()))
            && (this.getRefundTime() == null ? other.getRefundTime() == null : this.getRefundTime().equals(other.getRefundTime()))
            && (this.getPayTime() == null ? other.getPayTime() == null : this.getPayTime().equals(other.getPayTime()))
            && (this.getRefundStatus() == null ? other.getRefundStatus() == null : this.getRefundStatus().equals(other.getRefundStatus()))
            && (this.getRefundApproval() == null ? other.getRefundApproval() == null : this.getRefundApproval().equals(other.getRefundApproval()))
            && (this.getRefundComment() == null ? other.getRefundComment() == null : this.getRefundComment().equals(other.getRefundComment()))
            && (this.getRefundRemark() == null ? other.getRefundRemark() == null : this.getRefundRemark().equals(other.getRefundRemark()))
            && (this.getResultStatus() == null ? other.getResultStatus() == null : this.getResultStatus().equals(other.getResultStatus()))
            && (this.getSameWay() == null ? other.getSameWay() == null : this.getSameWay().equals(other.getSameWay()))
            && (this.getOpenRefundId() == null ? other.getOpenRefundId() == null : this.getOpenRefundId().equals(other.getOpenRefundId()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getInvalidTime() == null ? other.getInvalidTime() == null : this.getInvalidTime().equals(other.getInvalidTime()))
            && (this.getConfirmTime() == null ? other.getConfirmTime() == null : this.getConfirmTime().equals(other.getConfirmTime()))
            && (this.getResourceType() == null ? other.getResourceType() == null : this.getResourceType().equals(other.getResourceType()))
            && (this.getCouponRecordId() == null ? other.getCouponRecordId() == null : this.getCouponRecordId().equals(other.getCouponRecordId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getXfsjId() == null ? other.getXfsjId() == null : this.getXfsjId().equals(other.getXfsjId()))
            && (this.getCommentStatus() == null ? other.getCommentStatus() == null : this.getCommentStatus().equals(other.getCommentStatus()))
            && (this.getGroupStatus() == null ? other.getGroupStatus() == null : this.getGroupStatus().equals(other.getGroupStatus()))
            && (this.getGroupInfoId() == null ? other.getGroupInfoId() == null : this.getGroupInfoId().equals(other.getGroupInfoId()))
            && (this.getGroupDataId() == null ? other.getGroupDataId() == null : this.getGroupDataId().equals(other.getGroupDataId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getOpenId() == null) ? 0 : getOpenId().hashCode());
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getServiceId() == null) ? 0 : getServiceId().hashCode());
        result = prime * result + ((getAddrInfoId() == null) ? 0 : getAddrInfoId().hashCode());
        result = prime * result + ((getAddrInfo() == null) ? 0 : getAddrInfo().hashCode());
        result = prime * result + ((getAddrDetail() == null) ? 0 : getAddrDetail().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getOrderCode() == null) ? 0 : getOrderCode().hashCode());
        result = prime * result + ((getOutTradeNo() == null) ? 0 : getOutTradeNo().hashCode());
        result = prime * result + ((getExpressMoney() == null) ? 0 : getExpressMoney().hashCode());
        result = prime * result + ((getGoodsTotal() == null) ? 0 : getGoodsTotal().hashCode());
        result = prime * result + ((getOriginalPrice() == null) ? 0 : getOriginalPrice().hashCode());
        result = prime * result + ((getDiscountPrice() == null) ? 0 : getDiscountPrice().hashCode());
        result = prime * result + ((getTotalAmount() == null) ? 0 : getTotalAmount().hashCode());
        result = prime * result + ((getCouponPrice() == null) ? 0 : getCouponPrice().hashCode());
        result = prime * result + ((getVerifyStatus() == null) ? 0 : getVerifyStatus().hashCode());
        result = prime * result + ((getSubject() == null) ? 0 : getSubject().hashCode());
        result = prime * result + ((getBody() == null) ? 0 : getBody().hashCode());
        result = prime * result + ((getDetail() == null) ? 0 : getDetail().hashCode());
        result = prime * result + ((getExpressType() == null) ? 0 : getExpressType().hashCode());
        result = prime * result + ((getExpressName() == null) ? 0 : getExpressName().hashCode());
        result = prime * result + ((getExpressCompanyCode() == null) ? 0 : getExpressCompanyCode().hashCode());
        result = prime * result + ((getExpressCode() == null) ? 0 : getExpressCode().hashCode());
        result = prime * result + ((getExpressStatus() == null) ? 0 : getExpressStatus().hashCode());
        result = prime * result + ((getSignForTime() == null) ? 0 : getSignForTime().hashCode());
        result = prime * result + ((getExpressTime() == null) ? 0 : getExpressTime().hashCode());
        result = prime * result + ((getExpressArea() == null) ? 0 : getExpressArea().hashCode());
        result = prime * result + ((getExpressPhone() == null) ? 0 : getExpressPhone().hashCode());
        result = prime * result + ((getPayStatus() == null) ? 0 : getPayStatus().hashCode());
        result = prime * result + ((getPayChannel() == null) ? 0 : getPayChannel().hashCode());
        result = prime * result + ((getSendStatus() == null) ? 0 : getSendStatus().hashCode());
        result = prime * result + ((getSendTime() == null) ? 0 : getSendTime().hashCode());
        result = prime * result + ((getRefundTime() == null) ? 0 : getRefundTime().hashCode());
        result = prime * result + ((getPayTime() == null) ? 0 : getPayTime().hashCode());
        result = prime * result + ((getRefundStatus() == null) ? 0 : getRefundStatus().hashCode());
        result = prime * result + ((getRefundApproval() == null) ? 0 : getRefundApproval().hashCode());
        result = prime * result + ((getRefundComment() == null) ? 0 : getRefundComment().hashCode());
        result = prime * result + ((getRefundRemark() == null) ? 0 : getRefundRemark().hashCode());
        result = prime * result + ((getResultStatus() == null) ? 0 : getResultStatus().hashCode());
        result = prime * result + ((getSameWay() == null) ? 0 : getSameWay().hashCode());
        result = prime * result + ((getOpenRefundId() == null) ? 0 : getOpenRefundId().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getInvalidTime() == null) ? 0 : getInvalidTime().hashCode());
        result = prime * result + ((getConfirmTime() == null) ? 0 : getConfirmTime().hashCode());
        result = prime * result + ((getResourceType() == null) ? 0 : getResourceType().hashCode());
        result = prime * result + ((getCouponRecordId() == null) ? 0 : getCouponRecordId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getXfsjId() == null) ? 0 : getXfsjId().hashCode());
        result = prime * result + ((getCommentStatus() == null) ? 0 : getCommentStatus().hashCode());
        result = prime * result + ((getGroupStatus() == null) ? 0 : getGroupStatus().hashCode());
        result = prime * result + ((getGroupInfoId() == null) ? 0 : getGroupInfoId().hashCode());
        result = prime * result + ((getGroupDataId() == null) ? 0 : getGroupDataId().hashCode());
        return result;
    }
}