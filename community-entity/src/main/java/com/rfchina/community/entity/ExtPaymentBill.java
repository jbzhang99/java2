package com.rfchina.community.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ExtPaymentBill implements Serializable{

	private Long id;

    private Long housesId;

    private String price;

    private String count;

    private String amount;

    private Date feeTime;

    private Date feeStartTime;

    private Date feeEndTime;

    private String feeProject;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private Date paymentEndTime;

    private String receivableAmount;

    private String paidAmount;

    private String unpaidAmount;

    private String housesOwnerName;

    private String delayingFee;
    
    private Date orderCreateTime;
    
    private String billId;
    
    private Integer billStatus;
    
    private String paymentType;
    
    private String invoiceNo;
    
    private String tradeType;
    
    private String outTradeNo;

    private Long uid;

	private String masterAddress;

	private String invoiceTitle;

	private int invoiceStatus;

	private String zizaiAmount;

    public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getHousesId() {
		return housesId;
	}

	public void setHousesId(Long housesId) {
		this.housesId = housesId;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price.toString();
	}

	public String getCount() {
		return count;
	}

	public void setCount(BigDecimal count) {
		this.count = count.toString();
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount.toString();
	}

	public Date getFeeTime() {
		return feeTime;
	}

	public void setFeeTime(Date feeTime) {
		this.feeTime = feeTime;
	}

	public Date getFeeStartTime() {
		return feeStartTime;
	}

	public void setFeeStartTime(Date feeStartTime) {
		this.feeStartTime = feeStartTime;
	}

	public Date getFeeEndTime() {
		return feeEndTime;
	}

	public void setFeeEndTime(Date feeEndTime) {
		this.feeEndTime = feeEndTime;
	}

	public String getFeeProject() {
		return feeProject;
	}

	public void setFeeProject(String feeProject) {
		this.feeProject = feeProject;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public Date getPaymentEndTime() {
		return paymentEndTime;
	}

	public void setPaymentEndTime(Date paymentEndTime) {
		this.paymentEndTime = paymentEndTime;
	}

	public String getReceivableAmount() {
		return receivableAmount;
	}

	public void setReceivableAmount(BigDecimal receivableAmount) {
		this.receivableAmount = receivableAmount.toString();
	}

	public String getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(BigDecimal paidAmount) {
		this.paidAmount = paidAmount.toString();
	}

	public String getUnpaidAmount() {
		return unpaidAmount;
	}

	public void setUnpaidAmount(BigDecimal unpaidAmount) {
		this.unpaidAmount = unpaidAmount.toString();
	}

	public String getHousesOwnerName() {
		return housesOwnerName;
	}

	public void setHousesOwnerName(String housesOwnerName) {
		this.housesOwnerName = housesOwnerName;
	}

	public String getDelayingFee() {
		return delayingFee;
	}

	public void setDelayingFee(BigDecimal delayingFee) {
		this.delayingFee = delayingFee.toString();
	}

	public Date getOrderCreateTime() {
		return orderCreateTime;
	}

	public void setOrderCreateTime(Date orderCreateTime) {
		this.orderCreateTime = orderCreateTime;
	}

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public Integer getBillStatus() {
		return billStatus;
	}

	public void setBillStatus(Integer billStatus) {
		this.billStatus = billStatus;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	private static final long serialVersionUID = 1L;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getMasterAddress() {
		return masterAddress;
	}

	public void setMasterAddress(String masterAddress) {
		this.masterAddress = masterAddress;
	}

	public String getInvoiceTitle() {
		return invoiceTitle;
	}

	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}

	public int getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(int invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	public String getZizaiAmount() {
		return zizaiAmount;
	}

	public void setZizaiAmount(String zizaiAmount) {
		this.zizaiAmount = zizaiAmount;
	}

	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}
}
