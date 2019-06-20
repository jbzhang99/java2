package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class WaterOrder implements Serializable {
    private Long id;

    private Integer communityId;

    private String serialNo;

    private Long waterBrandId;

    private Long uid;

    private Long roomId;

    private String roomOwner;

    private Long masterChildId;

    private String contact;

    private String phone;

    private String tel;

    private Integer num;

    private Integer orderType;

    private Integer orderStatus;

    private Integer orderSrc;

    private Date orderTime;

    private Integer payType;

    private Integer payStatus;

    private Date payTime;

    private String payBody;

    private String billId;

    private Date billCloseTime;

    private Date billCreateTime;

    private String notifyId;

    private String wechatTradeNo;

    private String alipayTradeNo;

    private BigDecimal totalFee;

    private Integer takeWater;

    private Date takeWaterTime;

    private Integer receiptTicket;

    private Date receiptTicketTime;

    private Integer issueTicket;

    private Date issueTicketTime;

    private String staffName;

    private String staffPhone;

    private Integer orderWater;

    private Integer orderWaterNum;

    private String remark;

    private String rfpayAccount;

    private BigDecimal rfpayFeeRate;

    private BigDecimal rfpayClearingFee;

    private Long rfpayActualClearingFee;

    private Date createTime;

    private Date updateTime;

    private Integer deleteStatus;

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

    public Long getWaterBrandId() {
        return waterBrandId;
    }

    public void setWaterBrandId(Long waterBrandId) {
        this.waterBrandId = waterBrandId;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getRoomOwner() {
        return roomOwner;
    }

    public void setRoomOwner(String roomOwner) {
        this.roomOwner = roomOwner;
    }

    public Long getMasterChildId() {
        return masterChildId;
    }

    public void setMasterChildId(Long masterChildId) {
        this.masterChildId = masterChildId;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
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

    public Integer getOrderSrc() {
        return orderSrc;
    }

    public void setOrderSrc(Integer orderSrc) {
        this.orderSrc = orderSrc;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
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

    public String getPayBody() {
        return payBody;
    }

    public void setPayBody(String payBody) {
        this.payBody = payBody;
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

    public String getWechatTradeNo() {
        return wechatTradeNo;
    }

    public void setWechatTradeNo(String wechatTradeNo) {
        this.wechatTradeNo = wechatTradeNo;
    }

    public String getAlipayTradeNo() {
        return alipayTradeNo;
    }

    public void setAlipayTradeNo(String alipayTradeNo) {
        this.alipayTradeNo = alipayTradeNo;
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public Integer getTakeWater() {
        return takeWater;
    }

    public void setTakeWater(Integer takeWater) {
        this.takeWater = takeWater;
    }

    public Date getTakeWaterTime() {
        return takeWaterTime;
    }

    public void setTakeWaterTime(Date takeWaterTime) {
        this.takeWaterTime = takeWaterTime;
    }

    public Integer getReceiptTicket() {
        return receiptTicket;
    }

    public void setReceiptTicket(Integer receiptTicket) {
        this.receiptTicket = receiptTicket;
    }

    public Date getReceiptTicketTime() {
        return receiptTicketTime;
    }

    public void setReceiptTicketTime(Date receiptTicketTime) {
        this.receiptTicketTime = receiptTicketTime;
    }

    public Integer getIssueTicket() {
        return issueTicket;
    }

    public void setIssueTicket(Integer issueTicket) {
        this.issueTicket = issueTicket;
    }

    public Date getIssueTicketTime() {
        return issueTicketTime;
    }

    public void setIssueTicketTime(Date issueTicketTime) {
        this.issueTicketTime = issueTicketTime;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }

    public Integer getOrderWater() {
        return orderWater;
    }

    public void setOrderWater(Integer orderWater) {
        this.orderWater = orderWater;
    }

    public Integer getOrderWaterNum() {
        return orderWaterNum;
    }

    public void setOrderWaterNum(Integer orderWaterNum) {
        this.orderWaterNum = orderWaterNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
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
        sb.append(", waterBrandId=").append(waterBrandId);
        sb.append(", uid=").append(uid);
        sb.append(", roomId=").append(roomId);
        sb.append(", roomOwner=").append(roomOwner);
        sb.append(", masterChildId=").append(masterChildId);
        sb.append(", contact=").append(contact);
        sb.append(", phone=").append(phone);
        sb.append(", tel=").append(tel);
        sb.append(", num=").append(num);
        sb.append(", orderType=").append(orderType);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", orderSrc=").append(orderSrc);
        sb.append(", orderTime=").append(orderTime);
        sb.append(", payType=").append(payType);
        sb.append(", payStatus=").append(payStatus);
        sb.append(", payTime=").append(payTime);
        sb.append(", payBody=").append(payBody);
        sb.append(", billId=").append(billId);
        sb.append(", billCloseTime=").append(billCloseTime);
        sb.append(", billCreateTime=").append(billCreateTime);
        sb.append(", notifyId=").append(notifyId);
        sb.append(", wechatTradeNo=").append(wechatTradeNo);
        sb.append(", alipayTradeNo=").append(alipayTradeNo);
        sb.append(", totalFee=").append(totalFee);
        sb.append(", takeWater=").append(takeWater);
        sb.append(", takeWaterTime=").append(takeWaterTime);
        sb.append(", receiptTicket=").append(receiptTicket);
        sb.append(", receiptTicketTime=").append(receiptTicketTime);
        sb.append(", issueTicket=").append(issueTicket);
        sb.append(", issueTicketTime=").append(issueTicketTime);
        sb.append(", staffName=").append(staffName);
        sb.append(", staffPhone=").append(staffPhone);
        sb.append(", orderWater=").append(orderWater);
        sb.append(", orderWaterNum=").append(orderWaterNum);
        sb.append(", remark=").append(remark);
        sb.append(", rfpayAccount=").append(rfpayAccount);
        sb.append(", rfpayFeeRate=").append(rfpayFeeRate);
        sb.append(", rfpayClearingFee=").append(rfpayClearingFee);
        sb.append(", rfpayActualClearingFee=").append(rfpayActualClearingFee);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteStatus=").append(deleteStatus);
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
        WaterOrder other = (WaterOrder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getSerialNo() == null ? other.getSerialNo() == null : this.getSerialNo().equals(other.getSerialNo()))
            && (this.getWaterBrandId() == null ? other.getWaterBrandId() == null : this.getWaterBrandId().equals(other.getWaterBrandId()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getRoomId() == null ? other.getRoomId() == null : this.getRoomId().equals(other.getRoomId()))
            && (this.getRoomOwner() == null ? other.getRoomOwner() == null : this.getRoomOwner().equals(other.getRoomOwner()))
            && (this.getMasterChildId() == null ? other.getMasterChildId() == null : this.getMasterChildId().equals(other.getMasterChildId()))
            && (this.getContact() == null ? other.getContact() == null : this.getContact().equals(other.getContact()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getTel() == null ? other.getTel() == null : this.getTel().equals(other.getTel()))
            && (this.getNum() == null ? other.getNum() == null : this.getNum().equals(other.getNum()))
            && (this.getOrderType() == null ? other.getOrderType() == null : this.getOrderType().equals(other.getOrderType()))
            && (this.getOrderStatus() == null ? other.getOrderStatus() == null : this.getOrderStatus().equals(other.getOrderStatus()))
            && (this.getOrderSrc() == null ? other.getOrderSrc() == null : this.getOrderSrc().equals(other.getOrderSrc()))
            && (this.getOrderTime() == null ? other.getOrderTime() == null : this.getOrderTime().equals(other.getOrderTime()))
            && (this.getPayType() == null ? other.getPayType() == null : this.getPayType().equals(other.getPayType()))
            && (this.getPayStatus() == null ? other.getPayStatus() == null : this.getPayStatus().equals(other.getPayStatus()))
            && (this.getPayTime() == null ? other.getPayTime() == null : this.getPayTime().equals(other.getPayTime()))
            && (this.getPayBody() == null ? other.getPayBody() == null : this.getPayBody().equals(other.getPayBody()))
            && (this.getBillId() == null ? other.getBillId() == null : this.getBillId().equals(other.getBillId()))
            && (this.getBillCloseTime() == null ? other.getBillCloseTime() == null : this.getBillCloseTime().equals(other.getBillCloseTime()))
            && (this.getBillCreateTime() == null ? other.getBillCreateTime() == null : this.getBillCreateTime().equals(other.getBillCreateTime()))
            && (this.getNotifyId() == null ? other.getNotifyId() == null : this.getNotifyId().equals(other.getNotifyId()))
            && (this.getWechatTradeNo() == null ? other.getWechatTradeNo() == null : this.getWechatTradeNo().equals(other.getWechatTradeNo()))
            && (this.getAlipayTradeNo() == null ? other.getAlipayTradeNo() == null : this.getAlipayTradeNo().equals(other.getAlipayTradeNo()))
            && (this.getTotalFee() == null ? other.getTotalFee() == null : this.getTotalFee().equals(other.getTotalFee()))
            && (this.getTakeWater() == null ? other.getTakeWater() == null : this.getTakeWater().equals(other.getTakeWater()))
            && (this.getTakeWaterTime() == null ? other.getTakeWaterTime() == null : this.getTakeWaterTime().equals(other.getTakeWaterTime()))
            && (this.getReceiptTicket() == null ? other.getReceiptTicket() == null : this.getReceiptTicket().equals(other.getReceiptTicket()))
            && (this.getReceiptTicketTime() == null ? other.getReceiptTicketTime() == null : this.getReceiptTicketTime().equals(other.getReceiptTicketTime()))
            && (this.getIssueTicket() == null ? other.getIssueTicket() == null : this.getIssueTicket().equals(other.getIssueTicket()))
            && (this.getIssueTicketTime() == null ? other.getIssueTicketTime() == null : this.getIssueTicketTime().equals(other.getIssueTicketTime()))
            && (this.getStaffName() == null ? other.getStaffName() == null : this.getStaffName().equals(other.getStaffName()))
            && (this.getStaffPhone() == null ? other.getStaffPhone() == null : this.getStaffPhone().equals(other.getStaffPhone()))
            && (this.getOrderWater() == null ? other.getOrderWater() == null : this.getOrderWater().equals(other.getOrderWater()))
            && (this.getOrderWaterNum() == null ? other.getOrderWaterNum() == null : this.getOrderWaterNum().equals(other.getOrderWaterNum()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getRfpayAccount() == null ? other.getRfpayAccount() == null : this.getRfpayAccount().equals(other.getRfpayAccount()))
            && (this.getRfpayFeeRate() == null ? other.getRfpayFeeRate() == null : this.getRfpayFeeRate().equals(other.getRfpayFeeRate()))
            && (this.getRfpayClearingFee() == null ? other.getRfpayClearingFee() == null : this.getRfpayClearingFee().equals(other.getRfpayClearingFee()))
            && (this.getRfpayActualClearingFee() == null ? other.getRfpayActualClearingFee() == null : this.getRfpayActualClearingFee().equals(other.getRfpayActualClearingFee()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleteStatus() == null ? other.getDeleteStatus() == null : this.getDeleteStatus().equals(other.getDeleteStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getSerialNo() == null) ? 0 : getSerialNo().hashCode());
        result = prime * result + ((getWaterBrandId() == null) ? 0 : getWaterBrandId().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getRoomId() == null) ? 0 : getRoomId().hashCode());
        result = prime * result + ((getRoomOwner() == null) ? 0 : getRoomOwner().hashCode());
        result = prime * result + ((getMasterChildId() == null) ? 0 : getMasterChildId().hashCode());
        result = prime * result + ((getContact() == null) ? 0 : getContact().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getTel() == null) ? 0 : getTel().hashCode());
        result = prime * result + ((getNum() == null) ? 0 : getNum().hashCode());
        result = prime * result + ((getOrderType() == null) ? 0 : getOrderType().hashCode());
        result = prime * result + ((getOrderStatus() == null) ? 0 : getOrderStatus().hashCode());
        result = prime * result + ((getOrderSrc() == null) ? 0 : getOrderSrc().hashCode());
        result = prime * result + ((getOrderTime() == null) ? 0 : getOrderTime().hashCode());
        result = prime * result + ((getPayType() == null) ? 0 : getPayType().hashCode());
        result = prime * result + ((getPayStatus() == null) ? 0 : getPayStatus().hashCode());
        result = prime * result + ((getPayTime() == null) ? 0 : getPayTime().hashCode());
        result = prime * result + ((getPayBody() == null) ? 0 : getPayBody().hashCode());
        result = prime * result + ((getBillId() == null) ? 0 : getBillId().hashCode());
        result = prime * result + ((getBillCloseTime() == null) ? 0 : getBillCloseTime().hashCode());
        result = prime * result + ((getBillCreateTime() == null) ? 0 : getBillCreateTime().hashCode());
        result = prime * result + ((getNotifyId() == null) ? 0 : getNotifyId().hashCode());
        result = prime * result + ((getWechatTradeNo() == null) ? 0 : getWechatTradeNo().hashCode());
        result = prime * result + ((getAlipayTradeNo() == null) ? 0 : getAlipayTradeNo().hashCode());
        result = prime * result + ((getTotalFee() == null) ? 0 : getTotalFee().hashCode());
        result = prime * result + ((getTakeWater() == null) ? 0 : getTakeWater().hashCode());
        result = prime * result + ((getTakeWaterTime() == null) ? 0 : getTakeWaterTime().hashCode());
        result = prime * result + ((getReceiptTicket() == null) ? 0 : getReceiptTicket().hashCode());
        result = prime * result + ((getReceiptTicketTime() == null) ? 0 : getReceiptTicketTime().hashCode());
        result = prime * result + ((getIssueTicket() == null) ? 0 : getIssueTicket().hashCode());
        result = prime * result + ((getIssueTicketTime() == null) ? 0 : getIssueTicketTime().hashCode());
        result = prime * result + ((getStaffName() == null) ? 0 : getStaffName().hashCode());
        result = prime * result + ((getStaffPhone() == null) ? 0 : getStaffPhone().hashCode());
        result = prime * result + ((getOrderWater() == null) ? 0 : getOrderWater().hashCode());
        result = prime * result + ((getOrderWaterNum() == null) ? 0 : getOrderWaterNum().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getRfpayAccount() == null) ? 0 : getRfpayAccount().hashCode());
        result = prime * result + ((getRfpayFeeRate() == null) ? 0 : getRfpayFeeRate().hashCode());
        result = prime * result + ((getRfpayClearingFee() == null) ? 0 : getRfpayClearingFee().hashCode());
        result = prime * result + ((getRfpayActualClearingFee() == null) ? 0 : getRfpayActualClearingFee().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDeleteStatus() == null) ? 0 : getDeleteStatus().hashCode());
        return result;
    }
}