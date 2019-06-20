package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class VenueOrder implements Serializable {
    private Long id;

    private Long uid;

    private String orderNumber;

    private Integer communityId;

    private String orderName;

    private String orderPhone;

    private Long venueId;

    private BigDecimal totalPrice;

    private BigDecimal realPrice;

    private Date createTime;

    private Date playDate;

    private Integer status;

    private String payType;

    private Integer payStatus;

    private Date payTime;

    private Date refundTime;

    private Integer chargeType;

    private Integer children;

    private BigDecimal childrenPrice;

    private Integer adult;

    private BigDecimal adultPrice;

    private Long adminUid;

    private String billId;

    private Date billCloseTime;

    private Date billCreateTime;

    private String notifyId;

    private String verifyCode;

    private Date useTime;

    private Integer reservationChannels;

    private Date cancelTime;

    private String rfpayAccount;

    private BigDecimal rfpayFeeRate;

    private BigDecimal rfpayClearingFee;

    private Long rfpayActualClearingFee;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderPhone() {
        return orderPhone;
    }

    public void setOrderPhone(String orderPhone) {
        this.orderPhone = orderPhone;
    }

    public Long getVenueId() {
        return venueId;
    }

    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(BigDecimal realPrice) {
        this.realPrice = realPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPlayDate() {
        return playDate;
    }

    public void setPlayDate(Date playDate) {
        this.playDate = playDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

    public Integer getChargeType() {
        return chargeType;
    }

    public void setChargeType(Integer chargeType) {
        this.chargeType = chargeType;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    public BigDecimal getChildrenPrice() {
        return childrenPrice;
    }

    public void setChildrenPrice(BigDecimal childrenPrice) {
        this.childrenPrice = childrenPrice;
    }

    public Integer getAdult() {
        return adult;
    }

    public void setAdult(Integer adult) {
        this.adult = adult;
    }

    public BigDecimal getAdultPrice() {
        return adultPrice;
    }

    public void setAdultPrice(BigDecimal adultPrice) {
        this.adultPrice = adultPrice;
    }

    public Long getAdminUid() {
        return adminUid;
    }

    public void setAdminUid(Long adminUid) {
        this.adminUid = adminUid;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public Date getBillCloseTime() {
        return billCloseTime;
    }

    public void setBillCloseTime(Date billCloseTime) {
        this.billCloseTime = billCloseTime;
    }

    public Date getBillCreateTime() {
        return billCreateTime;
    }

    public void setBillCreateTime(Date billCreateTime) {
        this.billCreateTime = billCreateTime;
    }

    public String getNotifyId() {
        return notifyId;
    }

    public void setNotifyId(String notifyId) {
        this.notifyId = notifyId;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public Date getUseTime() {
        return useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }

    public Integer getReservationChannels() {
        return reservationChannels;
    }

    public void setReservationChannels(Integer reservationChannels) {
        this.reservationChannels = reservationChannels;
    }

    public Date getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    public String getRfpayAccount() {
        return rfpayAccount;
    }

    public void setRfpayAccount(String rfpayAccount) {
        this.rfpayAccount = rfpayAccount;
    }

    public BigDecimal getRfpayFeeRate() {
        return rfpayFeeRate;
    }

    public void setRfpayFeeRate(BigDecimal rfpayFeeRate) {
        this.rfpayFeeRate = rfpayFeeRate;
    }

    public BigDecimal getRfpayClearingFee() {
        return rfpayClearingFee;
    }

    public void setRfpayClearingFee(BigDecimal rfpayClearingFee) {
        this.rfpayClearingFee = rfpayClearingFee;
    }

    public Long getRfpayActualClearingFee() {
        return rfpayActualClearingFee;
    }

    public void setRfpayActualClearingFee(Long rfpayActualClearingFee) {
        this.rfpayActualClearingFee = rfpayActualClearingFee;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", uid=").append(uid);
        sb.append(", orderNumber=").append(orderNumber);
        sb.append(", communityId=").append(communityId);
        sb.append(", orderName=").append(orderName);
        sb.append(", orderPhone=").append(orderPhone);
        sb.append(", venueId=").append(venueId);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append(", realPrice=").append(realPrice);
        sb.append(", createTime=").append(createTime);
        sb.append(", playDate=").append(playDate);
        sb.append(", status=").append(status);
        sb.append(", payType=").append(payType);
        sb.append(", payStatus=").append(payStatus);
        sb.append(", payTime=").append(payTime);
        sb.append(", refundTime=").append(refundTime);
        sb.append(", chargeType=").append(chargeType);
        sb.append(", children=").append(children);
        sb.append(", childrenPrice=").append(childrenPrice);
        sb.append(", adult=").append(adult);
        sb.append(", adultPrice=").append(adultPrice);
        sb.append(", adminUid=").append(adminUid);
        sb.append(", billId=").append(billId);
        sb.append(", billCloseTime=").append(billCloseTime);
        sb.append(", billCreateTime=").append(billCreateTime);
        sb.append(", notifyId=").append(notifyId);
        sb.append(", verifyCode=").append(verifyCode);
        sb.append(", useTime=").append(useTime);
        sb.append(", reservationChannels=").append(reservationChannels);
        sb.append(", cancelTime=").append(cancelTime);
        sb.append(", rfpayAccount=").append(rfpayAccount);
        sb.append(", rfpayFeeRate=").append(rfpayFeeRate);
        sb.append(", rfpayClearingFee=").append(rfpayClearingFee);
        sb.append(", rfpayActualClearingFee=").append(rfpayActualClearingFee);
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
        VenueOrder other = (VenueOrder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getOrderNumber() == null ? other.getOrderNumber() == null : this.getOrderNumber().equals(other.getOrderNumber()))
            && (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getOrderName() == null ? other.getOrderName() == null : this.getOrderName().equals(other.getOrderName()))
            && (this.getOrderPhone() == null ? other.getOrderPhone() == null : this.getOrderPhone().equals(other.getOrderPhone()))
            && (this.getVenueId() == null ? other.getVenueId() == null : this.getVenueId().equals(other.getVenueId()))
            && (this.getTotalPrice() == null ? other.getTotalPrice() == null : this.getTotalPrice().equals(other.getTotalPrice()))
            && (this.getRealPrice() == null ? other.getRealPrice() == null : this.getRealPrice().equals(other.getRealPrice()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getPlayDate() == null ? other.getPlayDate() == null : this.getPlayDate().equals(other.getPlayDate()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getPayType() == null ? other.getPayType() == null : this.getPayType().equals(other.getPayType()))
            && (this.getPayStatus() == null ? other.getPayStatus() == null : this.getPayStatus().equals(other.getPayStatus()))
            && (this.getPayTime() == null ? other.getPayTime() == null : this.getPayTime().equals(other.getPayTime()))
            && (this.getRefundTime() == null ? other.getRefundTime() == null : this.getRefundTime().equals(other.getRefundTime()))
            && (this.getChargeType() == null ? other.getChargeType() == null : this.getChargeType().equals(other.getChargeType()))
            && (this.getChildren() == null ? other.getChildren() == null : this.getChildren().equals(other.getChildren()))
            && (this.getChildrenPrice() == null ? other.getChildrenPrice() == null : this.getChildrenPrice().equals(other.getChildrenPrice()))
            && (this.getAdult() == null ? other.getAdult() == null : this.getAdult().equals(other.getAdult()))
            && (this.getAdultPrice() == null ? other.getAdultPrice() == null : this.getAdultPrice().equals(other.getAdultPrice()))
            && (this.getAdminUid() == null ? other.getAdminUid() == null : this.getAdminUid().equals(other.getAdminUid()))
            && (this.getBillId() == null ? other.getBillId() == null : this.getBillId().equals(other.getBillId()))
            && (this.getBillCloseTime() == null ? other.getBillCloseTime() == null : this.getBillCloseTime().equals(other.getBillCloseTime()))
            && (this.getBillCreateTime() == null ? other.getBillCreateTime() == null : this.getBillCreateTime().equals(other.getBillCreateTime()))
            && (this.getNotifyId() == null ? other.getNotifyId() == null : this.getNotifyId().equals(other.getNotifyId()))
            && (this.getVerifyCode() == null ? other.getVerifyCode() == null : this.getVerifyCode().equals(other.getVerifyCode()))
            && (this.getUseTime() == null ? other.getUseTime() == null : this.getUseTime().equals(other.getUseTime()))
            && (this.getReservationChannels() == null ? other.getReservationChannels() == null : this.getReservationChannels().equals(other.getReservationChannels()))
            && (this.getCancelTime() == null ? other.getCancelTime() == null : this.getCancelTime().equals(other.getCancelTime()))
            && (this.getRfpayAccount() == null ? other.getRfpayAccount() == null : this.getRfpayAccount().equals(other.getRfpayAccount()))
            && (this.getRfpayFeeRate() == null ? other.getRfpayFeeRate() == null : this.getRfpayFeeRate().equals(other.getRfpayFeeRate()))
            && (this.getRfpayClearingFee() == null ? other.getRfpayClearingFee() == null : this.getRfpayClearingFee().equals(other.getRfpayClearingFee()))
            && (this.getRfpayActualClearingFee() == null ? other.getRfpayActualClearingFee() == null : this.getRfpayActualClearingFee().equals(other.getRfpayActualClearingFee()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getOrderNumber() == null) ? 0 : getOrderNumber().hashCode());
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getOrderName() == null) ? 0 : getOrderName().hashCode());
        result = prime * result + ((getOrderPhone() == null) ? 0 : getOrderPhone().hashCode());
        result = prime * result + ((getVenueId() == null) ? 0 : getVenueId().hashCode());
        result = prime * result + ((getTotalPrice() == null) ? 0 : getTotalPrice().hashCode());
        result = prime * result + ((getRealPrice() == null) ? 0 : getRealPrice().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getPlayDate() == null) ? 0 : getPlayDate().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getPayType() == null) ? 0 : getPayType().hashCode());
        result = prime * result + ((getPayStatus() == null) ? 0 : getPayStatus().hashCode());
        result = prime * result + ((getPayTime() == null) ? 0 : getPayTime().hashCode());
        result = prime * result + ((getRefundTime() == null) ? 0 : getRefundTime().hashCode());
        result = prime * result + ((getChargeType() == null) ? 0 : getChargeType().hashCode());
        result = prime * result + ((getChildren() == null) ? 0 : getChildren().hashCode());
        result = prime * result + ((getChildrenPrice() == null) ? 0 : getChildrenPrice().hashCode());
        result = prime * result + ((getAdult() == null) ? 0 : getAdult().hashCode());
        result = prime * result + ((getAdultPrice() == null) ? 0 : getAdultPrice().hashCode());
        result = prime * result + ((getAdminUid() == null) ? 0 : getAdminUid().hashCode());
        result = prime * result + ((getBillId() == null) ? 0 : getBillId().hashCode());
        result = prime * result + ((getBillCloseTime() == null) ? 0 : getBillCloseTime().hashCode());
        result = prime * result + ((getBillCreateTime() == null) ? 0 : getBillCreateTime().hashCode());
        result = prime * result + ((getNotifyId() == null) ? 0 : getNotifyId().hashCode());
        result = prime * result + ((getVerifyCode() == null) ? 0 : getVerifyCode().hashCode());
        result = prime * result + ((getUseTime() == null) ? 0 : getUseTime().hashCode());
        result = prime * result + ((getReservationChannels() == null) ? 0 : getReservationChannels().hashCode());
        result = prime * result + ((getCancelTime() == null) ? 0 : getCancelTime().hashCode());
        result = prime * result + ((getRfpayAccount() == null) ? 0 : getRfpayAccount().hashCode());
        result = prime * result + ((getRfpayFeeRate() == null) ? 0 : getRfpayFeeRate().hashCode());
        result = prime * result + ((getRfpayClearingFee() == null) ? 0 : getRfpayClearingFee().hashCode());
        result = prime * result + ((getRfpayActualClearingFee() == null) ? 0 : getRfpayActualClearingFee().hashCode());
        return result;
    }
}