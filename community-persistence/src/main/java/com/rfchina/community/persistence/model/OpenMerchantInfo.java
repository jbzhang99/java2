package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class OpenMerchantInfo implements Serializable {
    private Long id;

    private String email;

    private Integer type;

    private String title;

    private String titleSimple;

    private String introduction;

    private String businessScope;

    private Date createTime;

    private Date updateTime;

    private String registrationNumber;

    private String organizationCode;

    private String texRegistrationNo;

    private String businessLicense;

    private Integer isOtherLicense;

    private String otherLicense;

    private Long targetMonthTurnover;

    private String contactPerson;

    private String contactPhone;

    private Integer provinceAreaId;

    private Integer cityAreaId;

    private Integer areaId;

    private String areaInfo;

    private Integer status;

    private String statusContent;

    private String bankTitle;

    private String bankAccountName;

    private String bankAccount;

    private String idNumber;

    private String idPositive;

    private String idObverse;

    private String mchId;

    private Long accountId;

    private Integer xfsjStatus;

    private String legalName;

    private String legalIdCard;

    private String legalIdPositive;

    private String legalIdBack;

    private String srcBusiness;

    private Integer srcCity;

    private Integer isMandatary;

    private String mandataryName;

    private String mandataryIdCard;

    private String mandataryIdPositive;

    private String mandataryIdBack;

    private String mandataryOther;

    private String userName;

    private String tel;

    private String auditStatus;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleSimple() {
        return titleSimple;
    }

    public void setTitleSimple(String titleSimple) {
        this.titleSimple = titleSimple;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
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

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getTexRegistrationNo() {
        return texRegistrationNo;
    }

    public void setTexRegistrationNo(String texRegistrationNo) {
        this.texRegistrationNo = texRegistrationNo;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public Integer getIsOtherLicense() {
        return isOtherLicense;
    }

    public void setIsOtherLicense(Integer isOtherLicense) {
        this.isOtherLicense = isOtherLicense;
    }

    public String getOtherLicense() {
        return otherLicense;
    }

    public void setOtherLicense(String otherLicense) {
        this.otherLicense = otherLicense;
    }

    public Long getTargetMonthTurnover() {
        return targetMonthTurnover;
    }

    public void setTargetMonthTurnover(Long targetMonthTurnover) {
        this.targetMonthTurnover = targetMonthTurnover;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public Integer getProvinceAreaId() {
        return provinceAreaId;
    }

    public void setProvinceAreaId(Integer provinceAreaId) {
        this.provinceAreaId = provinceAreaId;
    }

    public Integer getCityAreaId() {
        return cityAreaId;
    }

    public void setCityAreaId(Integer cityAreaId) {
        this.cityAreaId = cityAreaId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaInfo() {
        return areaInfo;
    }

    public void setAreaInfo(String areaInfo) {
        this.areaInfo = areaInfo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusContent() {
        return statusContent;
    }

    public void setStatusContent(String statusContent) {
        this.statusContent = statusContent;
    }

    public String getBankTitle() {
        return bankTitle;
    }

    public void setBankTitle(String bankTitle) {
        this.bankTitle = bankTitle;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIdPositive() {
        return idPositive;
    }

    public void setIdPositive(String idPositive) {
        this.idPositive = idPositive;
    }

    public String getIdObverse() {
        return idObverse;
    }

    public void setIdObverse(String idObverse) {
        this.idObverse = idObverse;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Integer getXfsjStatus() {
        return xfsjStatus;
    }

    public void setXfsjStatus(Integer xfsjStatus) {
        this.xfsjStatus = xfsjStatus;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getLegalIdCard() {
        return legalIdCard;
    }

    public void setLegalIdCard(String legalIdCard) {
        this.legalIdCard = legalIdCard;
    }

    public String getLegalIdPositive() {
        return legalIdPositive;
    }

    public void setLegalIdPositive(String legalIdPositive) {
        this.legalIdPositive = legalIdPositive;
    }

    public String getLegalIdBack() {
        return legalIdBack;
    }

    public void setLegalIdBack(String legalIdBack) {
        this.legalIdBack = legalIdBack;
    }

    public String getSrcBusiness() {
        return srcBusiness;
    }

    public void setSrcBusiness(String srcBusiness) {
        this.srcBusiness = srcBusiness;
    }

    public Integer getSrcCity() {
        return srcCity;
    }

    public void setSrcCity(Integer srcCity) {
        this.srcCity = srcCity;
    }

    public Integer getIsMandatary() {
        return isMandatary;
    }

    public void setIsMandatary(Integer isMandatary) {
        this.isMandatary = isMandatary;
    }

    public String getMandataryName() {
        return mandataryName;
    }

    public void setMandataryName(String mandataryName) {
        this.mandataryName = mandataryName;
    }

    public String getMandataryIdCard() {
        return mandataryIdCard;
    }

    public void setMandataryIdCard(String mandataryIdCard) {
        this.mandataryIdCard = mandataryIdCard;
    }

    public String getMandataryIdPositive() {
        return mandataryIdPositive;
    }

    public void setMandataryIdPositive(String mandataryIdPositive) {
        this.mandataryIdPositive = mandataryIdPositive;
    }

    public String getMandataryIdBack() {
        return mandataryIdBack;
    }

    public void setMandataryIdBack(String mandataryIdBack) {
        this.mandataryIdBack = mandataryIdBack;
    }

    public String getMandataryOther() {
        return mandataryOther;
    }

    public void setMandataryOther(String mandataryOther) {
        this.mandataryOther = mandataryOther;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", email=").append(email);
        sb.append(", type=").append(type);
        sb.append(", title=").append(title);
        sb.append(", titleSimple=").append(titleSimple);
        sb.append(", introduction=").append(introduction);
        sb.append(", businessScope=").append(businessScope);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", registrationNumber=").append(registrationNumber);
        sb.append(", organizationCode=").append(organizationCode);
        sb.append(", texRegistrationNo=").append(texRegistrationNo);
        sb.append(", businessLicense=").append(businessLicense);
        sb.append(", isOtherLicense=").append(isOtherLicense);
        sb.append(", otherLicense=").append(otherLicense);
        sb.append(", targetMonthTurnover=").append(targetMonthTurnover);
        sb.append(", contactPerson=").append(contactPerson);
        sb.append(", contactPhone=").append(contactPhone);
        sb.append(", provinceAreaId=").append(provinceAreaId);
        sb.append(", cityAreaId=").append(cityAreaId);
        sb.append(", areaId=").append(areaId);
        sb.append(", areaInfo=").append(areaInfo);
        sb.append(", status=").append(status);
        sb.append(", statusContent=").append(statusContent);
        sb.append(", bankTitle=").append(bankTitle);
        sb.append(", bankAccountName=").append(bankAccountName);
        sb.append(", bankAccount=").append(bankAccount);
        sb.append(", idNumber=").append(idNumber);
        sb.append(", idPositive=").append(idPositive);
        sb.append(", idObverse=").append(idObverse);
        sb.append(", mchId=").append(mchId);
        sb.append(", accountId=").append(accountId);
        sb.append(", xfsjStatus=").append(xfsjStatus);
        sb.append(", legalName=").append(legalName);
        sb.append(", legalIdCard=").append(legalIdCard);
        sb.append(", legalIdPositive=").append(legalIdPositive);
        sb.append(", legalIdBack=").append(legalIdBack);
        sb.append(", srcBusiness=").append(srcBusiness);
        sb.append(", srcCity=").append(srcCity);
        sb.append(", isMandatary=").append(isMandatary);
        sb.append(", mandataryName=").append(mandataryName);
        sb.append(", mandataryIdCard=").append(mandataryIdCard);
        sb.append(", mandataryIdPositive=").append(mandataryIdPositive);
        sb.append(", mandataryIdBack=").append(mandataryIdBack);
        sb.append(", mandataryOther=").append(mandataryOther);
        sb.append(", userName=").append(userName);
        sb.append(", tel=").append(tel);
        sb.append(", auditStatus=").append(auditStatus);
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
        OpenMerchantInfo other = (OpenMerchantInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getTitleSimple() == null ? other.getTitleSimple() == null : this.getTitleSimple().equals(other.getTitleSimple()))
            && (this.getIntroduction() == null ? other.getIntroduction() == null : this.getIntroduction().equals(other.getIntroduction()))
            && (this.getBusinessScope() == null ? other.getBusinessScope() == null : this.getBusinessScope().equals(other.getBusinessScope()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getRegistrationNumber() == null ? other.getRegistrationNumber() == null : this.getRegistrationNumber().equals(other.getRegistrationNumber()))
            && (this.getOrganizationCode() == null ? other.getOrganizationCode() == null : this.getOrganizationCode().equals(other.getOrganizationCode()))
            && (this.getTexRegistrationNo() == null ? other.getTexRegistrationNo() == null : this.getTexRegistrationNo().equals(other.getTexRegistrationNo()))
            && (this.getBusinessLicense() == null ? other.getBusinessLicense() == null : this.getBusinessLicense().equals(other.getBusinessLicense()))
            && (this.getIsOtherLicense() == null ? other.getIsOtherLicense() == null : this.getIsOtherLicense().equals(other.getIsOtherLicense()))
            && (this.getOtherLicense() == null ? other.getOtherLicense() == null : this.getOtherLicense().equals(other.getOtherLicense()))
            && (this.getTargetMonthTurnover() == null ? other.getTargetMonthTurnover() == null : this.getTargetMonthTurnover().equals(other.getTargetMonthTurnover()))
            && (this.getContactPerson() == null ? other.getContactPerson() == null : this.getContactPerson().equals(other.getContactPerson()))
            && (this.getContactPhone() == null ? other.getContactPhone() == null : this.getContactPhone().equals(other.getContactPhone()))
            && (this.getProvinceAreaId() == null ? other.getProvinceAreaId() == null : this.getProvinceAreaId().equals(other.getProvinceAreaId()))
            && (this.getCityAreaId() == null ? other.getCityAreaId() == null : this.getCityAreaId().equals(other.getCityAreaId()))
            && (this.getAreaId() == null ? other.getAreaId() == null : this.getAreaId().equals(other.getAreaId()))
            && (this.getAreaInfo() == null ? other.getAreaInfo() == null : this.getAreaInfo().equals(other.getAreaInfo()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getStatusContent() == null ? other.getStatusContent() == null : this.getStatusContent().equals(other.getStatusContent()))
            && (this.getBankTitle() == null ? other.getBankTitle() == null : this.getBankTitle().equals(other.getBankTitle()))
            && (this.getBankAccountName() == null ? other.getBankAccountName() == null : this.getBankAccountName().equals(other.getBankAccountName()))
            && (this.getBankAccount() == null ? other.getBankAccount() == null : this.getBankAccount().equals(other.getBankAccount()))
            && (this.getIdNumber() == null ? other.getIdNumber() == null : this.getIdNumber().equals(other.getIdNumber()))
            && (this.getIdPositive() == null ? other.getIdPositive() == null : this.getIdPositive().equals(other.getIdPositive()))
            && (this.getIdObverse() == null ? other.getIdObverse() == null : this.getIdObverse().equals(other.getIdObverse()))
            && (this.getMchId() == null ? other.getMchId() == null : this.getMchId().equals(other.getMchId()))
            && (this.getAccountId() == null ? other.getAccountId() == null : this.getAccountId().equals(other.getAccountId()))
            && (this.getXfsjStatus() == null ? other.getXfsjStatus() == null : this.getXfsjStatus().equals(other.getXfsjStatus()))
            && (this.getLegalName() == null ? other.getLegalName() == null : this.getLegalName().equals(other.getLegalName()))
            && (this.getLegalIdCard() == null ? other.getLegalIdCard() == null : this.getLegalIdCard().equals(other.getLegalIdCard()))
            && (this.getLegalIdPositive() == null ? other.getLegalIdPositive() == null : this.getLegalIdPositive().equals(other.getLegalIdPositive()))
            && (this.getLegalIdBack() == null ? other.getLegalIdBack() == null : this.getLegalIdBack().equals(other.getLegalIdBack()))
            && (this.getSrcBusiness() == null ? other.getSrcBusiness() == null : this.getSrcBusiness().equals(other.getSrcBusiness()))
            && (this.getSrcCity() == null ? other.getSrcCity() == null : this.getSrcCity().equals(other.getSrcCity()))
            && (this.getIsMandatary() == null ? other.getIsMandatary() == null : this.getIsMandatary().equals(other.getIsMandatary()))
            && (this.getMandataryName() == null ? other.getMandataryName() == null : this.getMandataryName().equals(other.getMandataryName()))
            && (this.getMandataryIdCard() == null ? other.getMandataryIdCard() == null : this.getMandataryIdCard().equals(other.getMandataryIdCard()))
            && (this.getMandataryIdPositive() == null ? other.getMandataryIdPositive() == null : this.getMandataryIdPositive().equals(other.getMandataryIdPositive()))
            && (this.getMandataryIdBack() == null ? other.getMandataryIdBack() == null : this.getMandataryIdBack().equals(other.getMandataryIdBack()))
            && (this.getMandataryOther() == null ? other.getMandataryOther() == null : this.getMandataryOther().equals(other.getMandataryOther()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getTel() == null ? other.getTel() == null : this.getTel().equals(other.getTel()))
            && (this.getAuditStatus() == null ? other.getAuditStatus() == null : this.getAuditStatus().equals(other.getAuditStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getTitleSimple() == null) ? 0 : getTitleSimple().hashCode());
        result = prime * result + ((getIntroduction() == null) ? 0 : getIntroduction().hashCode());
        result = prime * result + ((getBusinessScope() == null) ? 0 : getBusinessScope().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getRegistrationNumber() == null) ? 0 : getRegistrationNumber().hashCode());
        result = prime * result + ((getOrganizationCode() == null) ? 0 : getOrganizationCode().hashCode());
        result = prime * result + ((getTexRegistrationNo() == null) ? 0 : getTexRegistrationNo().hashCode());
        result = prime * result + ((getBusinessLicense() == null) ? 0 : getBusinessLicense().hashCode());
        result = prime * result + ((getIsOtherLicense() == null) ? 0 : getIsOtherLicense().hashCode());
        result = prime * result + ((getOtherLicense() == null) ? 0 : getOtherLicense().hashCode());
        result = prime * result + ((getTargetMonthTurnover() == null) ? 0 : getTargetMonthTurnover().hashCode());
        result = prime * result + ((getContactPerson() == null) ? 0 : getContactPerson().hashCode());
        result = prime * result + ((getContactPhone() == null) ? 0 : getContactPhone().hashCode());
        result = prime * result + ((getProvinceAreaId() == null) ? 0 : getProvinceAreaId().hashCode());
        result = prime * result + ((getCityAreaId() == null) ? 0 : getCityAreaId().hashCode());
        result = prime * result + ((getAreaId() == null) ? 0 : getAreaId().hashCode());
        result = prime * result + ((getAreaInfo() == null) ? 0 : getAreaInfo().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getStatusContent() == null) ? 0 : getStatusContent().hashCode());
        result = prime * result + ((getBankTitle() == null) ? 0 : getBankTitle().hashCode());
        result = prime * result + ((getBankAccountName() == null) ? 0 : getBankAccountName().hashCode());
        result = prime * result + ((getBankAccount() == null) ? 0 : getBankAccount().hashCode());
        result = prime * result + ((getIdNumber() == null) ? 0 : getIdNumber().hashCode());
        result = prime * result + ((getIdPositive() == null) ? 0 : getIdPositive().hashCode());
        result = prime * result + ((getIdObverse() == null) ? 0 : getIdObverse().hashCode());
        result = prime * result + ((getMchId() == null) ? 0 : getMchId().hashCode());
        result = prime * result + ((getAccountId() == null) ? 0 : getAccountId().hashCode());
        result = prime * result + ((getXfsjStatus() == null) ? 0 : getXfsjStatus().hashCode());
        result = prime * result + ((getLegalName() == null) ? 0 : getLegalName().hashCode());
        result = prime * result + ((getLegalIdCard() == null) ? 0 : getLegalIdCard().hashCode());
        result = prime * result + ((getLegalIdPositive() == null) ? 0 : getLegalIdPositive().hashCode());
        result = prime * result + ((getLegalIdBack() == null) ? 0 : getLegalIdBack().hashCode());
        result = prime * result + ((getSrcBusiness() == null) ? 0 : getSrcBusiness().hashCode());
        result = prime * result + ((getSrcCity() == null) ? 0 : getSrcCity().hashCode());
        result = prime * result + ((getIsMandatary() == null) ? 0 : getIsMandatary().hashCode());
        result = prime * result + ((getMandataryName() == null) ? 0 : getMandataryName().hashCode());
        result = prime * result + ((getMandataryIdCard() == null) ? 0 : getMandataryIdCard().hashCode());
        result = prime * result + ((getMandataryIdPositive() == null) ? 0 : getMandataryIdPositive().hashCode());
        result = prime * result + ((getMandataryIdBack() == null) ? 0 : getMandataryIdBack().hashCode());
        result = prime * result + ((getMandataryOther() == null) ? 0 : getMandataryOther().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getTel() == null) ? 0 : getTel().hashCode());
        result = prime * result + ((getAuditStatus() == null) ? 0 : getAuditStatus().hashCode());
        return result;
    }
}