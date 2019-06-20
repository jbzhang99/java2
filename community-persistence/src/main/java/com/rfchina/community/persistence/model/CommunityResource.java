package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CommunityResource implements Serializable {
    private Integer id;

    private Integer cityId;

    private Integer communityId;

    private Integer resourceTypeId;

    private String addrDetail;

    private String resourceDesc;

    private Integer resourceTotal;

    private Integer resourceUsed;

    private BigDecimal resourceFee;

    private String imgs;

    private Byte resourceStatus;

    private Date createTime;

    private Integer createrId;

    private Date modifyTime;

    private Integer modifierId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getResourceTypeId() {
        return resourceTypeId;
    }

    public void setResourceTypeId(Integer resourceTypeId) {
        this.resourceTypeId = resourceTypeId;
    }

    public String getAddrDetail() {
        return addrDetail;
    }

    public void setAddrDetail(String addrDetail) {
        this.addrDetail = addrDetail;
    }

    public String getResourceDesc() {
        return resourceDesc;
    }

    public void setResourceDesc(String resourceDesc) {
        this.resourceDesc = resourceDesc;
    }

    public Integer getResourceTotal() {
        return resourceTotal;
    }

    public void setResourceTotal(Integer resourceTotal) {
        this.resourceTotal = resourceTotal;
    }

    public Integer getResourceUsed() {
        return resourceUsed;
    }

    public void setResourceUsed(Integer resourceUsed) {
        this.resourceUsed = resourceUsed;
    }

    public BigDecimal getResourceFee() {
        return resourceFee;
    }

    public void setResourceFee(BigDecimal resourceFee) {
        this.resourceFee = resourceFee;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public Byte getResourceStatus() {
        return resourceStatus;
    }

    public void setResourceStatus(Byte resourceStatus) {
        this.resourceStatus = resourceStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreaterId() {
        return createrId;
    }

    public void setCreaterId(Integer createrId) {
        this.createrId = createrId;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getModifierId() {
        return modifierId;
    }

    public void setModifierId(Integer modifierId) {
        this.modifierId = modifierId;
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
        sb.append(", resourceTypeId=").append(resourceTypeId);
        sb.append(", addrDetail=").append(addrDetail);
        sb.append(", resourceDesc=").append(resourceDesc);
        sb.append(", resourceTotal=").append(resourceTotal);
        sb.append(", resourceUsed=").append(resourceUsed);
        sb.append(", resourceFee=").append(resourceFee);
        sb.append(", imgs=").append(imgs);
        sb.append(", resourceStatus=").append(resourceStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", createrId=").append(createrId);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", modifierId=").append(modifierId);
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
        CommunityResource other = (CommunityResource) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCityId() == null ? other.getCityId() == null : this.getCityId().equals(other.getCityId()))
            && (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getResourceTypeId() == null ? other.getResourceTypeId() == null : this.getResourceTypeId().equals(other.getResourceTypeId()))
            && (this.getAddrDetail() == null ? other.getAddrDetail() == null : this.getAddrDetail().equals(other.getAddrDetail()))
            && (this.getResourceDesc() == null ? other.getResourceDesc() == null : this.getResourceDesc().equals(other.getResourceDesc()))
            && (this.getResourceTotal() == null ? other.getResourceTotal() == null : this.getResourceTotal().equals(other.getResourceTotal()))
            && (this.getResourceUsed() == null ? other.getResourceUsed() == null : this.getResourceUsed().equals(other.getResourceUsed()))
            && (this.getResourceFee() == null ? other.getResourceFee() == null : this.getResourceFee().equals(other.getResourceFee()))
            && (this.getImgs() == null ? other.getImgs() == null : this.getImgs().equals(other.getImgs()))
            && (this.getResourceStatus() == null ? other.getResourceStatus() == null : this.getResourceStatus().equals(other.getResourceStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreaterId() == null ? other.getCreaterId() == null : this.getCreaterId().equals(other.getCreaterId()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()))
            && (this.getModifierId() == null ? other.getModifierId() == null : this.getModifierId().equals(other.getModifierId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCityId() == null) ? 0 : getCityId().hashCode());
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getResourceTypeId() == null) ? 0 : getResourceTypeId().hashCode());
        result = prime * result + ((getAddrDetail() == null) ? 0 : getAddrDetail().hashCode());
        result = prime * result + ((getResourceDesc() == null) ? 0 : getResourceDesc().hashCode());
        result = prime * result + ((getResourceTotal() == null) ? 0 : getResourceTotal().hashCode());
        result = prime * result + ((getResourceUsed() == null) ? 0 : getResourceUsed().hashCode());
        result = prime * result + ((getResourceFee() == null) ? 0 : getResourceFee().hashCode());
        result = prime * result + ((getImgs() == null) ? 0 : getImgs().hashCode());
        result = prime * result + ((getResourceStatus() == null) ? 0 : getResourceStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreaterId() == null) ? 0 : getCreaterId().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        result = prime * result + ((getModifierId() == null) ? 0 : getModifierId().hashCode());
        return result;
    }
}