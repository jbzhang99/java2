package com.rfchina.community.persistence.model;

import java.io.Serializable;

public class VenueInfo implements Serializable {
    private Long id;

    private Integer communityId;

    private Integer serviceType;

    private String title;

    private Integer chargeType;

    private Integer reorder;

    private Integer status;

    private String businessBegin;

    private String businessEnd;

    private String weekPart;

    private String address;

    private String intro;

    private Double defPrice;

    private String ppv;

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

    public Integer getServiceType() {
        return serviceType;
    }

    public void setServiceType(Integer serviceType) {
        this.serviceType = serviceType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getChargeType() {
        return chargeType;
    }

    public void setChargeType(Integer chargeType) {
        this.chargeType = chargeType;
    }

    public Integer getReorder() {
        return reorder;
    }

    public void setReorder(Integer reorder) {
        this.reorder = reorder;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBusinessBegin() {
        return businessBegin;
    }

    public void setBusinessBegin(String businessBegin) {
        this.businessBegin = businessBegin;
    }

    public String getBusinessEnd() {
        return businessEnd;
    }

    public void setBusinessEnd(String businessEnd) {
        this.businessEnd = businessEnd;
    }

    public String getWeekPart() {
        return weekPart;
    }

    public void setWeekPart(String weekPart) {
        this.weekPart = weekPart;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Double getDefPrice() {
        return defPrice;
    }

    public void setDefPrice(Double defPrice) {
        this.defPrice = defPrice;
    }

    public String getPpv() {
        return ppv;
    }

    public void setPpv(String ppv) {
        this.ppv = ppv;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", communityId=").append(communityId);
        sb.append(", serviceType=").append(serviceType);
        sb.append(", title=").append(title);
        sb.append(", chargeType=").append(chargeType);
        sb.append(", reorder=").append(reorder);
        sb.append(", status=").append(status);
        sb.append(", businessBegin=").append(businessBegin);
        sb.append(", businessEnd=").append(businessEnd);
        sb.append(", weekPart=").append(weekPart);
        sb.append(", address=").append(address);
        sb.append(", intro=").append(intro);
        sb.append(", defPrice=").append(defPrice);
        sb.append(", ppv=").append(ppv);
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
        VenueInfo other = (VenueInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getServiceType() == null ? other.getServiceType() == null : this.getServiceType().equals(other.getServiceType()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getChargeType() == null ? other.getChargeType() == null : this.getChargeType().equals(other.getChargeType()))
            && (this.getReorder() == null ? other.getReorder() == null : this.getReorder().equals(other.getReorder()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getBusinessBegin() == null ? other.getBusinessBegin() == null : this.getBusinessBegin().equals(other.getBusinessBegin()))
            && (this.getBusinessEnd() == null ? other.getBusinessEnd() == null : this.getBusinessEnd().equals(other.getBusinessEnd()))
            && (this.getWeekPart() == null ? other.getWeekPart() == null : this.getWeekPart().equals(other.getWeekPart()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getIntro() == null ? other.getIntro() == null : this.getIntro().equals(other.getIntro()))
            && (this.getDefPrice() == null ? other.getDefPrice() == null : this.getDefPrice().equals(other.getDefPrice()))
            && (this.getPpv() == null ? other.getPpv() == null : this.getPpv().equals(other.getPpv()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getServiceType() == null) ? 0 : getServiceType().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getChargeType() == null) ? 0 : getChargeType().hashCode());
        result = prime * result + ((getReorder() == null) ? 0 : getReorder().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getBusinessBegin() == null) ? 0 : getBusinessBegin().hashCode());
        result = prime * result + ((getBusinessEnd() == null) ? 0 : getBusinessEnd().hashCode());
        result = prime * result + ((getWeekPart() == null) ? 0 : getWeekPart().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getIntro() == null) ? 0 : getIntro().hashCode());
        result = prime * result + ((getDefPrice() == null) ? 0 : getDefPrice().hashCode());
        result = prime * result + ((getPpv() == null) ? 0 : getPpv().hashCode());
        return result;
    }
}