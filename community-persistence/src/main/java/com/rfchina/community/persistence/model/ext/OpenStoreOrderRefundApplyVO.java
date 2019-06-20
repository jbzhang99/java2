package com.rfchina.community.persistence.model.ext;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.rfchina.community.persistence.model.OpenStoreOrderRefundApply;

public class OpenStoreOrderRefundApplyVO extends  OpenStoreOrderRefundApply implements Serializable {
    private Long id;

    private String billId;

    private Date createTime;

    private Integer status;

    private String revokeCode;

    private String refundBillId;

    private String refundAccountId;

    private String refundSource;

    private Integer auditStatus;
    
    private Date refundTime;

    private Integer refundStatus;

    private String refundApproval;

    private String refundComment;

    private String refundRemark;

    private Integer resultStatus;

    private Integer sameWay;
    
    private BigDecimal refundMoney;
    
    private String outTradeNo;

    private Long openRefundId;
    
    
	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public BigDecimal getRefundMoney() {
		return refundMoney;
	}

	public void setRefundMoney(BigDecimal refundMoney) {
		this.refundMoney = refundMoney;
	}

	public Date getRefundTime() {
		return refundTime;
	}

	public void setRefundTime(Date refundTime) {
		this.refundTime = refundTime;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRevokeCode() {
		return revokeCode;
	}

	public void setRevokeCode(String revokeCode) {
		this.revokeCode = revokeCode;
	}

	public String getRefundBillId() {
		return refundBillId;
	}

	public void setRefundBillId(String refundBillId) {
		this.refundBillId = refundBillId;
	}

	public String getRefundAccountId() {
		return refundAccountId;
	}

	public void setRefundAccountId(String refundAccountId) {
		this.refundAccountId = refundAccountId;
	}

	public String getRefundSource() {
		return refundSource;
	}

	public void setRefundSource(String refundSource) {
		this.refundSource = refundSource;
	}

	public Integer getSameWay() {
		return sameWay;
	}

	public void setSameWay(Integer sameWay) {
		this.sameWay = sameWay;
	}

	public Integer getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}

	public Long getOpenRefundId() {
		return openRefundId;
	}

	public void setOpenRefundId(Long openRefundId) {
		this.openRefundId = openRefundId;
	}
}