package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class OpenOperatorTask implements Serializable {
    private Long id;

    private Integer cityId;

    private Integer communityId;

    private Long xfsjId;

    private Integer serviceId;

    private Long merchantId;

    private Date startTime;

    private Date endTime;

    private Integer releaseStatus;

    private Date releaseTime;

    private Integer receiveStatus;

    private String empGuid;

    private String empPhone;

    private String empName;

    private Date becomeTime;

    private String address;

    private Date createTime;

    private String helpDetail;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public Long getXfsjId() {
        return xfsjId;
    }

    public void setXfsjId(Long xfsjId) {
        this.xfsjId = xfsjId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getReleaseStatus() {
        return releaseStatus;
    }

    public void setReleaseStatus(Integer releaseStatus) {
        this.releaseStatus = releaseStatus;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Integer getReceiveStatus() {
        return receiveStatus;
    }

    public void setReceiveStatus(Integer receiveStatus) {
        this.receiveStatus = receiveStatus;
    }

    public String getEmpGuid() {
        return empGuid;
    }

    public void setEmpGuid(String empGuid) {
        this.empGuid = empGuid;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Date getBecomeTime() {
        return becomeTime;
    }

    public void setBecomeTime(Date becomeTime) {
        this.becomeTime = becomeTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getHelpDetail() {
        return helpDetail;
    }

    public void setHelpDetail(String helpDetail) {
        this.helpDetail = helpDetail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", cityId=").append(cityId);
        sb.append(", communityId=").append(communityId);
        sb.append(", xfsjId=").append(xfsjId);
        sb.append(", serviceId=").append(serviceId);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", releaseStatus=").append(releaseStatus);
        sb.append(", releaseTime=").append(releaseTime);
        sb.append(", receiveStatus=").append(receiveStatus);
        sb.append(", empGuid=").append(empGuid);
        sb.append(", empPhone=").append(empPhone);
        sb.append(", empName=").append(empName);
        sb.append(", becomeTime=").append(becomeTime);
        sb.append(", address=").append(address);
        sb.append(", createTime=").append(createTime);
        sb.append(", helpDetail=").append(helpDetail);
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
        OpenOperatorTask other = (OpenOperatorTask) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCityId() == null ? other.getCityId() == null : this.getCityId().equals(other.getCityId()))
            && (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getXfsjId() == null ? other.getXfsjId() == null : this.getXfsjId().equals(other.getXfsjId()))
            && (this.getServiceId() == null ? other.getServiceId() == null : this.getServiceId().equals(other.getServiceId()))
            && (this.getMerchantId() == null ? other.getMerchantId() == null : this.getMerchantId().equals(other.getMerchantId()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getReleaseStatus() == null ? other.getReleaseStatus() == null : this.getReleaseStatus().equals(other.getReleaseStatus()))
            && (this.getReleaseTime() == null ? other.getReleaseTime() == null : this.getReleaseTime().equals(other.getReleaseTime()))
            && (this.getReceiveStatus() == null ? other.getReceiveStatus() == null : this.getReceiveStatus().equals(other.getReceiveStatus()))
            && (this.getEmpGuid() == null ? other.getEmpGuid() == null : this.getEmpGuid().equals(other.getEmpGuid()))
            && (this.getEmpPhone() == null ? other.getEmpPhone() == null : this.getEmpPhone().equals(other.getEmpPhone()))
            && (this.getEmpName() == null ? other.getEmpName() == null : this.getEmpName().equals(other.getEmpName()))
            && (this.getBecomeTime() == null ? other.getBecomeTime() == null : this.getBecomeTime().equals(other.getBecomeTime()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getHelpDetail() == null ? other.getHelpDetail() == null : this.getHelpDetail().equals(other.getHelpDetail()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCityId() == null) ? 0 : getCityId().hashCode());
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getXfsjId() == null) ? 0 : getXfsjId().hashCode());
        result = prime * result + ((getServiceId() == null) ? 0 : getServiceId().hashCode());
        result = prime * result + ((getMerchantId() == null) ? 0 : getMerchantId().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getReleaseStatus() == null) ? 0 : getReleaseStatus().hashCode());
        result = prime * result + ((getReleaseTime() == null) ? 0 : getReleaseTime().hashCode());
        result = prime * result + ((getReceiveStatus() == null) ? 0 : getReceiveStatus().hashCode());
        result = prime * result + ((getEmpGuid() == null) ? 0 : getEmpGuid().hashCode());
        result = prime * result + ((getEmpPhone() == null) ? 0 : getEmpPhone().hashCode());
        result = prime * result + ((getEmpName() == null) ? 0 : getEmpName().hashCode());
        result = prime * result + ((getBecomeTime() == null) ? 0 : getBecomeTime().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getHelpDetail() == null) ? 0 : getHelpDetail().hashCode());
        return result;
    }
}