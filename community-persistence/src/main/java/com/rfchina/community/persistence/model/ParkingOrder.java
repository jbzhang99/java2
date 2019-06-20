package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ParkingOrder implements Serializable {
    private Long id;

    private Integer communityId;

    private String serialNo;

    private String mobile;

    private Long uid;

    private String carPlateNo;

    private String cardNo;

    private Integer orderType;

    private Integer orderStatus;

    private Integer payStatus;

    private String payType;

    private Date payTime;

    private BigDecimal payAmount;

    private String payPrice;

    private Integer paySrc;

    private String wxOpenid;

    private String duration;

    private String freeDuration;

    private String address;

    private Date enterTime;

    private Date cancelTime;

    private Integer monthlyPayNum;

    private String monthlyPayStartTime;

    private String monthlyPayEndTime;

    private String rfpayBillId;

    private String rfpayTradeNo;

    private String rfpayBody;

    private String rfpayType;

    private Date rfpayCreateTime;

    private Date rfpayCloseTime;

    private String rfpayAccount;

    private BigDecimal rfpayFeeRate;

    private BigDecimal rfpayClearingFee;

    private Long rfpayActualClearingFee;

    private Long prvUid;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getCarPlateNo() {
        return carPlateNo;
    }

    public void setCarPlateNo(String carPlateNo) {
        this.carPlateNo = carPlateNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public String getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(String payPrice) {
        this.payPrice = payPrice;
    }

    public Integer getPaySrc() {
        return paySrc;
    }

    public void setPaySrc(Integer paySrc) {
        this.paySrc = paySrc;
    }

    public String getWxOpenid() {
        return wxOpenid;
    }

    public void setWxOpenid(String wxOpenid) {
        this.wxOpenid = wxOpenid;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFreeDuration() {
        return freeDuration;
    }

    public void setFreeDuration(String freeDuration) {
        this.freeDuration = freeDuration;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Date enterTime) {
        this.enterTime = enterTime;
    }

    public Date getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    public Integer getMonthlyPayNum() {
        return monthlyPayNum;
    }

    public void setMonthlyPayNum(Integer monthlyPayNum) {
        this.monthlyPayNum = monthlyPayNum;
    }

    public String getMonthlyPayStartTime() {
        return monthlyPayStartTime;
    }

    public void setMonthlyPayStartTime(String monthlyPayStartTime) {
        this.monthlyPayStartTime = monthlyPayStartTime;
    }

    public String getMonthlyPayEndTime() {
        return monthlyPayEndTime;
    }

    public void setMonthlyPayEndTime(String monthlyPayEndTime) {
        this.monthlyPayEndTime = monthlyPayEndTime;
    }

    public String getRfpayBillId() {
        return rfpayBillId;
    }

    public void setRfpayBillId(String rfpayBillId) {
        this.rfpayBillId = rfpayBillId;
    }

    public String getRfpayTradeNo() {
        return rfpayTradeNo;
    }

    public void setRfpayTradeNo(String rfpayTradeNo) {
        this.rfpayTradeNo = rfpayTradeNo;
    }

    public String getRfpayBody() {
        return rfpayBody;
    }

    public void setRfpayBody(String rfpayBody) {
        this.rfpayBody = rfpayBody;
    }

    public String getRfpayType() {
        return rfpayType;
    }

    public void setRfpayType(String rfpayType) {
        this.rfpayType = rfpayType;
    }

    public Date getRfpayCreateTime() {
        return rfpayCreateTime;
    }

    public void setRfpayCreateTime(Date rfpayCreateTime) {
        this.rfpayCreateTime = rfpayCreateTime;
    }

    public Date getRfpayCloseTime() {
        return rfpayCloseTime;
    }

    public void setRfpayCloseTime(Date rfpayCloseTime) {
        this.rfpayCloseTime = rfpayCloseTime;
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

    public Long getPrvUid() {
        return prvUid;
    }

    public void setPrvUid(Long prvUid) {
        this.prvUid = prvUid;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", communityId=").append(communityId);
        sb.append(", serialNo=").append(serialNo);
        sb.append(", mobile=").append(mobile);
        sb.append(", uid=").append(uid);
        sb.append(", carPlateNo=").append(carPlateNo);
        sb.append(", cardNo=").append(cardNo);
        sb.append(", orderType=").append(orderType);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", payStatus=").append(payStatus);
        sb.append(", payType=").append(payType);
        sb.append(", payTime=").append(payTime);
        sb.append(", payAmount=").append(payAmount);
        sb.append(", payPrice=").append(payPrice);
        sb.append(", paySrc=").append(paySrc);
        sb.append(", wxOpenid=").append(wxOpenid);
        sb.append(", duration=").append(duration);
        sb.append(", freeDuration=").append(freeDuration);
        sb.append(", address=").append(address);
        sb.append(", enterTime=").append(enterTime);
        sb.append(", cancelTime=").append(cancelTime);
        sb.append(", monthlyPayNum=").append(monthlyPayNum);
        sb.append(", monthlyPayStartTime=").append(monthlyPayStartTime);
        sb.append(", monthlyPayEndTime=").append(monthlyPayEndTime);
        sb.append(", rfpayBillId=").append(rfpayBillId);
        sb.append(", rfpayTradeNo=").append(rfpayTradeNo);
        sb.append(", rfpayBody=").append(rfpayBody);
        sb.append(", rfpayType=").append(rfpayType);
        sb.append(", rfpayCreateTime=").append(rfpayCreateTime);
        sb.append(", rfpayCloseTime=").append(rfpayCloseTime);
        sb.append(", rfpayAccount=").append(rfpayAccount);
        sb.append(", rfpayFeeRate=").append(rfpayFeeRate);
        sb.append(", rfpayClearingFee=").append(rfpayClearingFee);
        sb.append(", rfpayActualClearingFee=").append(rfpayActualClearingFee);
        sb.append(", prvUid=").append(prvUid);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
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
        ParkingOrder other = (ParkingOrder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getSerialNo() == null ? other.getSerialNo() == null : this.getSerialNo().equals(other.getSerialNo()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getCarPlateNo() == null ? other.getCarPlateNo() == null : this.getCarPlateNo().equals(other.getCarPlateNo()))
            && (this.getCardNo() == null ? other.getCardNo() == null : this.getCardNo().equals(other.getCardNo()))
            && (this.getOrderType() == null ? other.getOrderType() == null : this.getOrderType().equals(other.getOrderType()))
            && (this.getOrderStatus() == null ? other.getOrderStatus() == null : this.getOrderStatus().equals(other.getOrderStatus()))
            && (this.getPayStatus() == null ? other.getPayStatus() == null : this.getPayStatus().equals(other.getPayStatus()))
            && (this.getPayType() == null ? other.getPayType() == null : this.getPayType().equals(other.getPayType()))
            && (this.getPayTime() == null ? other.getPayTime() == null : this.getPayTime().equals(other.getPayTime()))
            && (this.getPayAmount() == null ? other.getPayAmount() == null : this.getPayAmount().equals(other.getPayAmount()))
            && (this.getPayPrice() == null ? other.getPayPrice() == null : this.getPayPrice().equals(other.getPayPrice()))
            && (this.getPaySrc() == null ? other.getPaySrc() == null : this.getPaySrc().equals(other.getPaySrc()))
            && (this.getWxOpenid() == null ? other.getWxOpenid() == null : this.getWxOpenid().equals(other.getWxOpenid()))
            && (this.getDuration() == null ? other.getDuration() == null : this.getDuration().equals(other.getDuration()))
            && (this.getFreeDuration() == null ? other.getFreeDuration() == null : this.getFreeDuration().equals(other.getFreeDuration()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getEnterTime() == null ? other.getEnterTime() == null : this.getEnterTime().equals(other.getEnterTime()))
            && (this.getCancelTime() == null ? other.getCancelTime() == null : this.getCancelTime().equals(other.getCancelTime()))
            && (this.getMonthlyPayNum() == null ? other.getMonthlyPayNum() == null : this.getMonthlyPayNum().equals(other.getMonthlyPayNum()))
            && (this.getMonthlyPayStartTime() == null ? other.getMonthlyPayStartTime() == null : this.getMonthlyPayStartTime().equals(other.getMonthlyPayStartTime()))
            && (this.getMonthlyPayEndTime() == null ? other.getMonthlyPayEndTime() == null : this.getMonthlyPayEndTime().equals(other.getMonthlyPayEndTime()))
            && (this.getRfpayBillId() == null ? other.getRfpayBillId() == null : this.getRfpayBillId().equals(other.getRfpayBillId()))
            && (this.getRfpayTradeNo() == null ? other.getRfpayTradeNo() == null : this.getRfpayTradeNo().equals(other.getRfpayTradeNo()))
            && (this.getRfpayBody() == null ? other.getRfpayBody() == null : this.getRfpayBody().equals(other.getRfpayBody()))
            && (this.getRfpayType() == null ? other.getRfpayType() == null : this.getRfpayType().equals(other.getRfpayType()))
            && (this.getRfpayCreateTime() == null ? other.getRfpayCreateTime() == null : this.getRfpayCreateTime().equals(other.getRfpayCreateTime()))
            && (this.getRfpayCloseTime() == null ? other.getRfpayCloseTime() == null : this.getRfpayCloseTime().equals(other.getRfpayCloseTime()))
            && (this.getRfpayAccount() == null ? other.getRfpayAccount() == null : this.getRfpayAccount().equals(other.getRfpayAccount()))
            && (this.getRfpayFeeRate() == null ? other.getRfpayFeeRate() == null : this.getRfpayFeeRate().equals(other.getRfpayFeeRate()))
            && (this.getRfpayClearingFee() == null ? other.getRfpayClearingFee() == null : this.getRfpayClearingFee().equals(other.getRfpayClearingFee()))
            && (this.getRfpayActualClearingFee() == null ? other.getRfpayActualClearingFee() == null : this.getRfpayActualClearingFee().equals(other.getRfpayActualClearingFee()))
            && (this.getPrvUid() == null ? other.getPrvUid() == null : this.getPrvUid().equals(other.getPrvUid()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getSerialNo() == null) ? 0 : getSerialNo().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getCarPlateNo() == null) ? 0 : getCarPlateNo().hashCode());
        result = prime * result + ((getCardNo() == null) ? 0 : getCardNo().hashCode());
        result = prime * result + ((getOrderType() == null) ? 0 : getOrderType().hashCode());
        result = prime * result + ((getOrderStatus() == null) ? 0 : getOrderStatus().hashCode());
        result = prime * result + ((getPayStatus() == null) ? 0 : getPayStatus().hashCode());
        result = prime * result + ((getPayType() == null) ? 0 : getPayType().hashCode());
        result = prime * result + ((getPayTime() == null) ? 0 : getPayTime().hashCode());
        result = prime * result + ((getPayAmount() == null) ? 0 : getPayAmount().hashCode());
        result = prime * result + ((getPayPrice() == null) ? 0 : getPayPrice().hashCode());
        result = prime * result + ((getPaySrc() == null) ? 0 : getPaySrc().hashCode());
        result = prime * result + ((getWxOpenid() == null) ? 0 : getWxOpenid().hashCode());
        result = prime * result + ((getDuration() == null) ? 0 : getDuration().hashCode());
        result = prime * result + ((getFreeDuration() == null) ? 0 : getFreeDuration().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getEnterTime() == null) ? 0 : getEnterTime().hashCode());
        result = prime * result + ((getCancelTime() == null) ? 0 : getCancelTime().hashCode());
        result = prime * result + ((getMonthlyPayNum() == null) ? 0 : getMonthlyPayNum().hashCode());
        result = prime * result + ((getMonthlyPayStartTime() == null) ? 0 : getMonthlyPayStartTime().hashCode());
        result = prime * result + ((getMonthlyPayEndTime() == null) ? 0 : getMonthlyPayEndTime().hashCode());
        result = prime * result + ((getRfpayBillId() == null) ? 0 : getRfpayBillId().hashCode());
        result = prime * result + ((getRfpayTradeNo() == null) ? 0 : getRfpayTradeNo().hashCode());
        result = prime * result + ((getRfpayBody() == null) ? 0 : getRfpayBody().hashCode());
        result = prime * result + ((getRfpayType() == null) ? 0 : getRfpayType().hashCode());
        result = prime * result + ((getRfpayCreateTime() == null) ? 0 : getRfpayCreateTime().hashCode());
        result = prime * result + ((getRfpayCloseTime() == null) ? 0 : getRfpayCloseTime().hashCode());
        result = prime * result + ((getRfpayAccount() == null) ? 0 : getRfpayAccount().hashCode());
        result = prime * result + ((getRfpayFeeRate() == null) ? 0 : getRfpayFeeRate().hashCode());
        result = prime * result + ((getRfpayClearingFee() == null) ? 0 : getRfpayClearingFee().hashCode());
        result = prime * result + ((getRfpayActualClearingFee() == null) ? 0 : getRfpayActualClearingFee().hashCode());
        result = prime * result + ((getPrvUid() == null) ? 0 : getPrvUid().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}