package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class OpenStoreOrderRefundApply implements Serializable {
    private Long id;

    private String refundSource;

    private Integer storeOrderId;

    private String billId;

    private String reasonCertificate;

    private String name;

    private Integer accountType;

    private String accountNo;

    private String depositBank;

    private String confirmLetter;

    private String idCardFront;

    private String idCardRear;

    private String accountPic;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRefundSource() {
        return refundSource;
    }

    public void setRefundSource(String refundSource) {
        this.refundSource = refundSource;
    }

    public Integer getStoreOrderId() {
        return storeOrderId;
    }

    public void setStoreOrderId(Integer storeOrderId) {
        this.storeOrderId = storeOrderId;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getReasonCertificate() {
        return reasonCertificate;
    }

    public void setReasonCertificate(String reasonCertificate) {
        this.reasonCertificate = reasonCertificate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getDepositBank() {
        return depositBank;
    }

    public void setDepositBank(String depositBank) {
        this.depositBank = depositBank;
    }

    public String getConfirmLetter() {
        return confirmLetter;
    }

    public void setConfirmLetter(String confirmLetter) {
        this.confirmLetter = confirmLetter;
    }

    public String getIdCardFront() {
        return idCardFront;
    }

    public void setIdCardFront(String idCardFront) {
        this.idCardFront = idCardFront;
    }

    public String getIdCardRear() {
        return idCardRear;
    }

    public void setIdCardRear(String idCardRear) {
        this.idCardRear = idCardRear;
    }

    public String getAccountPic() {
        return accountPic;
    }

    public void setAccountPic(String accountPic) {
        this.accountPic = accountPic;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", refundSource=").append(refundSource);
        sb.append(", storeOrderId=").append(storeOrderId);
        sb.append(", billId=").append(billId);
        sb.append(", reasonCertificate=").append(reasonCertificate);
        sb.append(", name=").append(name);
        sb.append(", accountType=").append(accountType);
        sb.append(", accountNo=").append(accountNo);
        sb.append(", depositBank=").append(depositBank);
        sb.append(", confirmLetter=").append(confirmLetter);
        sb.append(", idCardFront=").append(idCardFront);
        sb.append(", idCardRear=").append(idCardRear);
        sb.append(", accountPic=").append(accountPic);
        sb.append(", createTime=").append(createTime);
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
        OpenStoreOrderRefundApply other = (OpenStoreOrderRefundApply) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRefundSource() == null ? other.getRefundSource() == null : this.getRefundSource().equals(other.getRefundSource()))
            && (this.getStoreOrderId() == null ? other.getStoreOrderId() == null : this.getStoreOrderId().equals(other.getStoreOrderId()))
            && (this.getBillId() == null ? other.getBillId() == null : this.getBillId().equals(other.getBillId()))
            && (this.getReasonCertificate() == null ? other.getReasonCertificate() == null : this.getReasonCertificate().equals(other.getReasonCertificate()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getAccountType() == null ? other.getAccountType() == null : this.getAccountType().equals(other.getAccountType()))
            && (this.getAccountNo() == null ? other.getAccountNo() == null : this.getAccountNo().equals(other.getAccountNo()))
            && (this.getDepositBank() == null ? other.getDepositBank() == null : this.getDepositBank().equals(other.getDepositBank()))
            && (this.getConfirmLetter() == null ? other.getConfirmLetter() == null : this.getConfirmLetter().equals(other.getConfirmLetter()))
            && (this.getIdCardFront() == null ? other.getIdCardFront() == null : this.getIdCardFront().equals(other.getIdCardFront()))
            && (this.getIdCardRear() == null ? other.getIdCardRear() == null : this.getIdCardRear().equals(other.getIdCardRear()))
            && (this.getAccountPic() == null ? other.getAccountPic() == null : this.getAccountPic().equals(other.getAccountPic()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRefundSource() == null) ? 0 : getRefundSource().hashCode());
        result = prime * result + ((getStoreOrderId() == null) ? 0 : getStoreOrderId().hashCode());
        result = prime * result + ((getBillId() == null) ? 0 : getBillId().hashCode());
        result = prime * result + ((getReasonCertificate() == null) ? 0 : getReasonCertificate().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getAccountType() == null) ? 0 : getAccountType().hashCode());
        result = prime * result + ((getAccountNo() == null) ? 0 : getAccountNo().hashCode());
        result = prime * result + ((getDepositBank() == null) ? 0 : getDepositBank().hashCode());
        result = prime * result + ((getConfirmLetter() == null) ? 0 : getConfirmLetter().hashCode());
        result = prime * result + ((getIdCardFront() == null) ? 0 : getIdCardFront().hashCode());
        result = prime * result + ((getIdCardRear() == null) ? 0 : getIdCardRear().hashCode());
        result = prime * result + ((getAccountPic() == null) ? 0 : getAccountPic().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}