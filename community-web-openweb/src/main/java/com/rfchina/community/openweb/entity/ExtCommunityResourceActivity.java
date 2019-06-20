package com.rfchina.community.openweb.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class ExtCommunityResourceActivity implements Serializable {
    private Integer id;

    private Integer cityId;

    private Integer communityId;

    private String resourceTypeTitle;

	private String addrDetail;

    private String resourceDesc;

    private BigDecimal resourceFee;

    private String imgs;

    private static final long serialVersionUID = 1L;
    
    public String getResourceTypeTitle() {
		return resourceTypeTitle;
	}

	public void setResourceTypeTitle(String resourceTypeTitle) {
		this.resourceTypeTitle = resourceTypeTitle;
	}

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", cityId=").append(cityId);
        sb.append(", communityId=").append(communityId);
        sb.append(", addrDetail=").append(addrDetail);
        sb.append(", resourceDesc=").append(resourceDesc);
        sb.append(", resourceFee=").append(resourceFee);
        sb.append(", imgs=").append(imgs);
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
        ExtCommunityResourceActivity other = (ExtCommunityResourceActivity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCityId() == null ? other.getCityId() == null : this.getCityId().equals(other.getCityId()))
            && (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getAddrDetail() == null ? other.getAddrDetail() == null : this.getAddrDetail().equals(other.getAddrDetail()))
            && (this.getResourceDesc() == null ? other.getResourceDesc() == null : this.getResourceDesc().equals(other.getResourceDesc()))
            && (this.getResourceFee() == null ? other.getResourceFee() == null : this.getResourceFee().equals(other.getResourceFee()))
            && (this.getImgs() == null ? other.getImgs() == null : this.getImgs().equals(other.getImgs()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCityId() == null) ? 0 : getCityId().hashCode());
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getAddrDetail() == null) ? 0 : getAddrDetail().hashCode());
        result = prime * result + ((getResourceDesc() == null) ? 0 : getResourceDesc().hashCode());
        result = prime * result + ((getResourceFee() == null) ? 0 : getResourceFee().hashCode());
        result = prime * result + ((getImgs() == null) ? 0 : getImgs().hashCode());
        return result;
    }
}