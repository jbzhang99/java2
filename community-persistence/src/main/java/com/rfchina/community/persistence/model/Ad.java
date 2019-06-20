package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class Ad implements Serializable {
    private Integer id;

    private Integer categoryId;

    private Integer communityId;

    private String name;

    private String imgUrl;

    private String link;

    private Integer sorting;

    private Integer status;

    private Integer srcType;

    private Integer clickCount;

    private String intro;

    private String reason;

    private String platformReason;

    private String leaderReason;

    private Date startTime;

    private Date endTime;

    private Date createTime;

    private Date auditTime;

    private Date leaderAuditTime;

    private Date platformAuditTime;

    private Date publishTime;

    private Integer autoPublish;

    private Date autoPublishTime;

    private Integer autoRepeal;

    private Date autoRepealTime;

    private Long applyAdminId;

    private Date applyTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getSorting() {
        return sorting;
    }

    public void setSorting(Integer sorting) {
        this.sorting = sorting;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSrcType() {
        return srcType;
    }

    public void setSrcType(Integer srcType) {
        this.srcType = srcType;
    }

    public Integer getClickCount() {
        return clickCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getPlatformReason() {
        return platformReason;
    }

    public void setPlatformReason(String platformReason) {
        this.platformReason = platformReason;
    }

    public String getLeaderReason() {
        return leaderReason;
    }

    public void setLeaderReason(String leaderReason) {
        this.leaderReason = leaderReason;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Date getLeaderAuditTime() {
        return leaderAuditTime;
    }

    public void setLeaderAuditTime(Date leaderAuditTime) {
        this.leaderAuditTime = leaderAuditTime;
    }

    public Date getPlatformAuditTime() {
        return platformAuditTime;
    }

    public void setPlatformAuditTime(Date platformAuditTime) {
        this.platformAuditTime = platformAuditTime;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getAutoPublish() {
        return autoPublish;
    }

    public void setAutoPublish(Integer autoPublish) {
        this.autoPublish = autoPublish;
    }

    public Date getAutoPublishTime() {
        return autoPublishTime;
    }

    public void setAutoPublishTime(Date autoPublishTime) {
        this.autoPublishTime = autoPublishTime;
    }

    public Integer getAutoRepeal() {
        return autoRepeal;
    }

    public void setAutoRepeal(Integer autoRepeal) {
        this.autoRepeal = autoRepeal;
    }

    public Date getAutoRepealTime() {
        return autoRepealTime;
    }

    public void setAutoRepealTime(Date autoRepealTime) {
        this.autoRepealTime = autoRepealTime;
    }

    public Long getApplyAdminId() {
        return applyAdminId;
    }

    public void setApplyAdminId(Long applyAdminId) {
        this.applyAdminId = applyAdminId;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", communityId=").append(communityId);
        sb.append(", name=").append(name);
        sb.append(", imgUrl=").append(imgUrl);
        sb.append(", link=").append(link);
        sb.append(", sorting=").append(sorting);
        sb.append(", status=").append(status);
        sb.append(", srcType=").append(srcType);
        sb.append(", clickCount=").append(clickCount);
        sb.append(", intro=").append(intro);
        sb.append(", reason=").append(reason);
        sb.append(", platformReason=").append(platformReason);
        sb.append(", leaderReason=").append(leaderReason);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", auditTime=").append(auditTime);
        sb.append(", leaderAuditTime=").append(leaderAuditTime);
        sb.append(", platformAuditTime=").append(platformAuditTime);
        sb.append(", publishTime=").append(publishTime);
        sb.append(", autoPublish=").append(autoPublish);
        sb.append(", autoPublishTime=").append(autoPublishTime);
        sb.append(", autoRepeal=").append(autoRepeal);
        sb.append(", autoRepealTime=").append(autoRepealTime);
        sb.append(", applyAdminId=").append(applyAdminId);
        sb.append(", applyTime=").append(applyTime);
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
        Ad other = (Ad) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getImgUrl() == null ? other.getImgUrl() == null : this.getImgUrl().equals(other.getImgUrl()))
            && (this.getLink() == null ? other.getLink() == null : this.getLink().equals(other.getLink()))
            && (this.getSorting() == null ? other.getSorting() == null : this.getSorting().equals(other.getSorting()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getSrcType() == null ? other.getSrcType() == null : this.getSrcType().equals(other.getSrcType()))
            && (this.getClickCount() == null ? other.getClickCount() == null : this.getClickCount().equals(other.getClickCount()))
            && (this.getIntro() == null ? other.getIntro() == null : this.getIntro().equals(other.getIntro()))
            && (this.getReason() == null ? other.getReason() == null : this.getReason().equals(other.getReason()))
            && (this.getPlatformReason() == null ? other.getPlatformReason() == null : this.getPlatformReason().equals(other.getPlatformReason()))
            && (this.getLeaderReason() == null ? other.getLeaderReason() == null : this.getLeaderReason().equals(other.getLeaderReason()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getAuditTime() == null ? other.getAuditTime() == null : this.getAuditTime().equals(other.getAuditTime()))
            && (this.getLeaderAuditTime() == null ? other.getLeaderAuditTime() == null : this.getLeaderAuditTime().equals(other.getLeaderAuditTime()))
            && (this.getPlatformAuditTime() == null ? other.getPlatformAuditTime() == null : this.getPlatformAuditTime().equals(other.getPlatformAuditTime()))
            && (this.getPublishTime() == null ? other.getPublishTime() == null : this.getPublishTime().equals(other.getPublishTime()))
            && (this.getAutoPublish() == null ? other.getAutoPublish() == null : this.getAutoPublish().equals(other.getAutoPublish()))
            && (this.getAutoPublishTime() == null ? other.getAutoPublishTime() == null : this.getAutoPublishTime().equals(other.getAutoPublishTime()))
            && (this.getAutoRepeal() == null ? other.getAutoRepeal() == null : this.getAutoRepeal().equals(other.getAutoRepeal()))
            && (this.getAutoRepealTime() == null ? other.getAutoRepealTime() == null : this.getAutoRepealTime().equals(other.getAutoRepealTime()))
            && (this.getApplyAdminId() == null ? other.getApplyAdminId() == null : this.getApplyAdminId().equals(other.getApplyAdminId()))
            && (this.getApplyTime() == null ? other.getApplyTime() == null : this.getApplyTime().equals(other.getApplyTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getImgUrl() == null) ? 0 : getImgUrl().hashCode());
        result = prime * result + ((getLink() == null) ? 0 : getLink().hashCode());
        result = prime * result + ((getSorting() == null) ? 0 : getSorting().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getSrcType() == null) ? 0 : getSrcType().hashCode());
        result = prime * result + ((getClickCount() == null) ? 0 : getClickCount().hashCode());
        result = prime * result + ((getIntro() == null) ? 0 : getIntro().hashCode());
        result = prime * result + ((getReason() == null) ? 0 : getReason().hashCode());
        result = prime * result + ((getPlatformReason() == null) ? 0 : getPlatformReason().hashCode());
        result = prime * result + ((getLeaderReason() == null) ? 0 : getLeaderReason().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getAuditTime() == null) ? 0 : getAuditTime().hashCode());
        result = prime * result + ((getLeaderAuditTime() == null) ? 0 : getLeaderAuditTime().hashCode());
        result = prime * result + ((getPlatformAuditTime() == null) ? 0 : getPlatformAuditTime().hashCode());
        result = prime * result + ((getPublishTime() == null) ? 0 : getPublishTime().hashCode());
        result = prime * result + ((getAutoPublish() == null) ? 0 : getAutoPublish().hashCode());
        result = prime * result + ((getAutoPublishTime() == null) ? 0 : getAutoPublishTime().hashCode());
        result = prime * result + ((getAutoRepeal() == null) ? 0 : getAutoRepeal().hashCode());
        result = prime * result + ((getAutoRepealTime() == null) ? 0 : getAutoRepealTime().hashCode());
        result = prime * result + ((getApplyAdminId() == null) ? 0 : getApplyAdminId().hashCode());
        result = prime * result + ((getApplyTime() == null) ? 0 : getApplyTime().hashCode());
        return result;
    }
}