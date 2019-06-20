package com.rfchina.community.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class StatPaymentOrder implements Serializable {
    private Long id;

    private Integer areaId;

    private Integer communityId;

    private Integer communityType;

    private Integer type;

    private Integer tRoomCount;

    private String tFeeCount;

    private Integer tUserCount;

    private Integer tOrderCount;

    private Integer rRoomCount;

    private String rFeeCount;

    private Integer pRoomCount;

    private String pFeeCount;

    private Integer pUserCount;

    private Integer pOrderCount;

    private Integer alipayOrderCount;

    private Integer wechatOrderCount;

    private String wxFeeCount;

    private Integer wxUserCount;

    private Integer wxOrderCount;

    private Integer wxRoomCount;

    private Date statTime;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public Integer getCommunityType() {
        return communityType;
    }

    public void setCommunityType(Integer communityType) {
        this.communityType = communityType;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getrRoomCount() {
        return rRoomCount;
    }

    public void setrRoomCount(Integer rRoomCount) {
        this.rRoomCount = rRoomCount;
    }

    public String getrFeeCount() {
        return rFeeCount;
    }

    public void setrFeeCount(String rFeeCount) {
        this.rFeeCount = rFeeCount;
    }

    public Integer getpRoomCount() {
        return pRoomCount;
    }

    public void setpRoomCount(Integer pRoomCount) {
        this.pRoomCount = pRoomCount;
    }

    public String getpFeeCount() {
        return pFeeCount;
    }

    public void setpFeeCount(String pFeeCount) {
        this.pFeeCount = pFeeCount;
    }

    public Integer getpUserCount() {
        return pUserCount;
    }

    public void setpUserCount(Integer pUserCount) {
        this.pUserCount = pUserCount;
    }

    public Integer getpOrderCount() {
        return pOrderCount;
    }

    public void setpOrderCount(Integer pOrderCount) {
        this.pOrderCount = pOrderCount;
    }

    public Integer getAlipayOrderCount() {
        return alipayOrderCount;
    }

    public void setAlipayOrderCount(Integer alipayOrderCount) {
        this.alipayOrderCount = alipayOrderCount;
    }

    public Integer getWechatOrderCount() {
        return wechatOrderCount;
    }

    public void setWechatOrderCount(Integer wechatOrderCount) {
        this.wechatOrderCount = wechatOrderCount;
    }

    public String getWxFeeCount() {
        return wxFeeCount;
    }

    public void setWxFeeCount(String wxFeeCount) {
        this.wxFeeCount = wxFeeCount;
    }

    public Integer getWxUserCount() {
        return wxUserCount;
    }

    public void setWxUserCount(Integer wxUserCount) {
        this.wxUserCount = wxUserCount;
    }

    public Integer getWxOrderCount() {
        return wxOrderCount;
    }

    public void setWxOrderCount(Integer wxOrderCount) {
        this.wxOrderCount = wxOrderCount;
    }

    public Date getStatTime() {
        return statTime;
    }

    public void setStatTime(Date statTime) {
        this.statTime = statTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer gettRoomCount() {
        return tRoomCount;
    }

    public void settRoomCount(Integer tRoomCount) {
        this.tRoomCount = tRoomCount;
    }

    public String gettFeeCount() {
        return tFeeCount;
    }

    public void settFeeCount(String tFeeCount) {
        this.tFeeCount = tFeeCount;
    }

    public Integer gettUserCount() {
        return tUserCount;
    }

    public void settUserCount(Integer tUserCount) {
        this.tUserCount = tUserCount;
    }

    public Integer gettOrderCount() {
        return tOrderCount;
    }

    public void settOrderCount(Integer tOrderCount) {
        this.tOrderCount = tOrderCount;
    }

    public Integer getWxRoomCount() {
        return wxRoomCount;
    }

    public void setWxRoomCount(Integer wxRoomCount) {
        this.wxRoomCount = wxRoomCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StatPaymentOrder that = (StatPaymentOrder) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (areaId != null ? !areaId.equals(that.areaId) : that.areaId != null) return false;
        if (communityId != null ? !communityId.equals(that.communityId) : that.communityId != null) return false;
        if (communityType != null ? !communityType.equals(that.communityType) : that.communityType != null)
            return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (tRoomCount != null ? !tRoomCount.equals(that.tRoomCount) : that.tRoomCount != null) return false;
        if (tFeeCount != null ? !tFeeCount.equals(that.tFeeCount) : that.tFeeCount != null) return false;
        if (tUserCount != null ? !tUserCount.equals(that.tUserCount) : that.tUserCount != null) return false;
        if (tOrderCount != null ? !tOrderCount.equals(that.tOrderCount) : that.tOrderCount != null) return false;
        if (rRoomCount != null ? !rRoomCount.equals(that.rRoomCount) : that.rRoomCount != null) return false;
        if (rFeeCount != null ? !rFeeCount.equals(that.rFeeCount) : that.rFeeCount != null) return false;
        if (pRoomCount != null ? !pRoomCount.equals(that.pRoomCount) : that.pRoomCount != null) return false;
        if (pFeeCount != null ? !pFeeCount.equals(that.pFeeCount) : that.pFeeCount != null) return false;
        if (pUserCount != null ? !pUserCount.equals(that.pUserCount) : that.pUserCount != null) return false;
        if (pOrderCount != null ? !pOrderCount.equals(that.pOrderCount) : that.pOrderCount != null) return false;
        if (alipayOrderCount != null ? !alipayOrderCount.equals(that.alipayOrderCount) : that.alipayOrderCount != null)
            return false;
        if (wechatOrderCount != null ? !wechatOrderCount.equals(that.wechatOrderCount) : that.wechatOrderCount != null)
            return false;
        if (wxFeeCount != null ? !wxFeeCount.equals(that.wxFeeCount) : that.wxFeeCount != null) return false;
        if (wxUserCount != null ? !wxUserCount.equals(that.wxUserCount) : that.wxUserCount != null) return false;
        if (wxOrderCount != null ? !wxOrderCount.equals(that.wxOrderCount) : that.wxOrderCount != null) return false;
        if (wxRoomCount != null ? !wxRoomCount.equals(that.wxRoomCount) : that.wxRoomCount != null) return false;
        if (statTime != null ? !statTime.equals(that.statTime) : that.statTime != null) return false;
        return createTime != null ? createTime.equals(that.createTime) : that.createTime == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (areaId != null ? areaId.hashCode() : 0);
        result = 31 * result + (communityId != null ? communityId.hashCode() : 0);
        result = 31 * result + (communityType != null ? communityType.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (tRoomCount != null ? tRoomCount.hashCode() : 0);
        result = 31 * result + (tFeeCount != null ? tFeeCount.hashCode() : 0);
        result = 31 * result + (tUserCount != null ? tUserCount.hashCode() : 0);
        result = 31 * result + (tOrderCount != null ? tOrderCount.hashCode() : 0);
        result = 31 * result + (rRoomCount != null ? rRoomCount.hashCode() : 0);
        result = 31 * result + (rFeeCount != null ? rFeeCount.hashCode() : 0);
        result = 31 * result + (pRoomCount != null ? pRoomCount.hashCode() : 0);
        result = 31 * result + (pFeeCount != null ? pFeeCount.hashCode() : 0);
        result = 31 * result + (pUserCount != null ? pUserCount.hashCode() : 0);
        result = 31 * result + (pOrderCount != null ? pOrderCount.hashCode() : 0);
        result = 31 * result + (alipayOrderCount != null ? alipayOrderCount.hashCode() : 0);
        result = 31 * result + (wechatOrderCount != null ? wechatOrderCount.hashCode() : 0);
        result = 31 * result + (wxFeeCount != null ? wxFeeCount.hashCode() : 0);
        result = 31 * result + (wxUserCount != null ? wxUserCount.hashCode() : 0);
        result = 31 * result + (wxOrderCount != null ? wxOrderCount.hashCode() : 0);
        result = 31 * result + (wxRoomCount != null ? wxRoomCount.hashCode() : 0);
        result = 31 * result + (statTime != null ? statTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StatPaymentOrder{" +
                "id=" + id +
                ", areaId=" + areaId +
                ", communityId=" + communityId +
                ", communityType=" + communityType +
                ", type=" + type +
                ", tRoomCount=" + tRoomCount +
                ", tFeeCount=" + tFeeCount +
                ", tUserCount=" + tUserCount +
                ", tOrderCount=" + tOrderCount +
                ", rRoomCount=" + rRoomCount +
                ", rFeeCount='" + rFeeCount + '\'' +
                ", pRoomCount=" + pRoomCount +
                ", pFeeCount='" + pFeeCount + '\'' +
                ", pUserCount=" + pUserCount +
                ", pOrderCount=" + pOrderCount +
                ", alipayOrderCount=" + alipayOrderCount +
                ", wechatOrderCount=" + wechatOrderCount +
                ", wxFeeCount='" + wxFeeCount + '\'' +
                ", wxUserCount=" + wxUserCount +
                ", wxOrderCount=" + wxOrderCount +
                ", wxRoomCount=" + wxRoomCount +
                ", statTime=" + statTime +
                ", createTime=" + createTime +
                '}';
    }
}