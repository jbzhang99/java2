package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CommunityServiceCategory implements Serializable {
    private Integer id;

    private String name;

    private Date createTime;

    private Integer type;

    private Integer sort;

    private Integer exposure;

    private Integer pid;

    private String link;

    private String png;

    private BigDecimal communityFee;

    private Integer premiumNum;

    private Integer validStatus;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getExposure() {
        return exposure;
    }

    public void setExposure(Integer exposure) {
        this.exposure = exposure;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPng() {
        return png;
    }

    public void setPng(String png) {
        this.png = png;
    }

    public BigDecimal getCommunityFee() {
        return communityFee;
    }

    public void setCommunityFee(BigDecimal communityFee) {
        this.communityFee = communityFee;
    }

    public Integer getPremiumNum() {
        return premiumNum;
    }

    public void setPremiumNum(Integer premiumNum) {
        this.premiumNum = premiumNum;
    }

    public Integer getValidStatus() {
        return validStatus;
    }

    public void setValidStatus(Integer validStatus) {
        this.validStatus = validStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", createTime=").append(createTime);
        sb.append(", type=").append(type);
        sb.append(", sort=").append(sort);
        sb.append(", exposure=").append(exposure);
        sb.append(", pid=").append(pid);
        sb.append(", link=").append(link);
        sb.append(", png=").append(png);
        sb.append(", communityFee=").append(communityFee);
        sb.append(", premiumNum=").append(premiumNum);
        sb.append(", validStatus=").append(validStatus);
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
        CommunityServiceCategory other = (CommunityServiceCategory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getExposure() == null ? other.getExposure() == null : this.getExposure().equals(other.getExposure()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getLink() == null ? other.getLink() == null : this.getLink().equals(other.getLink()))
            && (this.getPng() == null ? other.getPng() == null : this.getPng().equals(other.getPng()))
            && (this.getCommunityFee() == null ? other.getCommunityFee() == null : this.getCommunityFee().equals(other.getCommunityFee()))
            && (this.getPremiumNum() == null ? other.getPremiumNum() == null : this.getPremiumNum().equals(other.getPremiumNum()))
            && (this.getValidStatus() == null ? other.getValidStatus() == null : this.getValidStatus().equals(other.getValidStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getExposure() == null) ? 0 : getExposure().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getLink() == null) ? 0 : getLink().hashCode());
        result = prime * result + ((getPng() == null) ? 0 : getPng().hashCode());
        result = prime * result + ((getCommunityFee() == null) ? 0 : getCommunityFee().hashCode());
        result = prime * result + ((getPremiumNum() == null) ? 0 : getPremiumNum().hashCode());
        result = prime * result + ((getValidStatus() == null) ? 0 : getValidStatus().hashCode());
        return result;
    }
}