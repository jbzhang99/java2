package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class VisitCommunityQrcode implements Serializable {
    private Long id;

    private Integer communityId;

    private String content;

    private Date createTime;

    private Date expTime;

    private Date validDate;

    private Long adminId;

    private Integer useInCount;

    private Date useInTime;

    private Integer useOutCount;

    private Date useOutTime;

    private String createIp;

    private String createPhone;

    private Long createUid;

    private Integer isPrint;

    private Date printTime;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getExpTime() {
        return expTime;
    }

    public void setExpTime(Date expTime) {
        this.expTime = expTime;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public Integer getUseInCount() {
        return useInCount;
    }

    public void setUseInCount(Integer useInCount) {
        this.useInCount = useInCount;
    }

    public Date getUseInTime() {
        return useInTime;
    }

    public void setUseInTime(Date useInTime) {
        this.useInTime = useInTime;
    }

    public Integer getUseOutCount() {
        return useOutCount;
    }

    public void setUseOutCount(Integer useOutCount) {
        this.useOutCount = useOutCount;
    }

    public Date getUseOutTime() {
        return useOutTime;
    }

    public void setUseOutTime(Date useOutTime) {
        this.useOutTime = useOutTime;
    }

    public String getCreateIp() {
        return createIp;
    }

    public void setCreateIp(String createIp) {
        this.createIp = createIp;
    }

    public String getCreatePhone() {
        return createPhone;
    }

    public void setCreatePhone(String createPhone) {
        this.createPhone = createPhone;
    }

    public Long getCreateUid() {
        return createUid;
    }

    public void setCreateUid(Long createUid) {
        this.createUid = createUid;
    }

    public Integer getIsPrint() {
        return isPrint;
    }

    public void setIsPrint(Integer isPrint) {
        this.isPrint = isPrint;
    }

    public Date getPrintTime() {
        return printTime;
    }

    public void setPrintTime(Date printTime) {
        this.printTime = printTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", communityId=").append(communityId);
        sb.append(", content=").append(content);
        sb.append(", createTime=").append(createTime);
        sb.append(", expTime=").append(expTime);
        sb.append(", validDate=").append(validDate);
        sb.append(", adminId=").append(adminId);
        sb.append(", useInCount=").append(useInCount);
        sb.append(", useInTime=").append(useInTime);
        sb.append(", useOutCount=").append(useOutCount);
        sb.append(", useOutTime=").append(useOutTime);
        sb.append(", createIp=").append(createIp);
        sb.append(", createPhone=").append(createPhone);
        sb.append(", createUid=").append(createUid);
        sb.append(", isPrint=").append(isPrint);
        sb.append(", printTime=").append(printTime);
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
        VisitCommunityQrcode other = (VisitCommunityQrcode) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getExpTime() == null ? other.getExpTime() == null : this.getExpTime().equals(other.getExpTime()))
            && (this.getValidDate() == null ? other.getValidDate() == null : this.getValidDate().equals(other.getValidDate()))
            && (this.getAdminId() == null ? other.getAdminId() == null : this.getAdminId().equals(other.getAdminId()))
            && (this.getUseInCount() == null ? other.getUseInCount() == null : this.getUseInCount().equals(other.getUseInCount()))
            && (this.getUseInTime() == null ? other.getUseInTime() == null : this.getUseInTime().equals(other.getUseInTime()))
            && (this.getUseOutCount() == null ? other.getUseOutCount() == null : this.getUseOutCount().equals(other.getUseOutCount()))
            && (this.getUseOutTime() == null ? other.getUseOutTime() == null : this.getUseOutTime().equals(other.getUseOutTime()))
            && (this.getCreateIp() == null ? other.getCreateIp() == null : this.getCreateIp().equals(other.getCreateIp()))
            && (this.getCreatePhone() == null ? other.getCreatePhone() == null : this.getCreatePhone().equals(other.getCreatePhone()))
            && (this.getCreateUid() == null ? other.getCreateUid() == null : this.getCreateUid().equals(other.getCreateUid()))
            && (this.getIsPrint() == null ? other.getIsPrint() == null : this.getIsPrint().equals(other.getIsPrint()))
            && (this.getPrintTime() == null ? other.getPrintTime() == null : this.getPrintTime().equals(other.getPrintTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getExpTime() == null) ? 0 : getExpTime().hashCode());
        result = prime * result + ((getValidDate() == null) ? 0 : getValidDate().hashCode());
        result = prime * result + ((getAdminId() == null) ? 0 : getAdminId().hashCode());
        result = prime * result + ((getUseInCount() == null) ? 0 : getUseInCount().hashCode());
        result = prime * result + ((getUseInTime() == null) ? 0 : getUseInTime().hashCode());
        result = prime * result + ((getUseOutCount() == null) ? 0 : getUseOutCount().hashCode());
        result = prime * result + ((getUseOutTime() == null) ? 0 : getUseOutTime().hashCode());
        result = prime * result + ((getCreateIp() == null) ? 0 : getCreateIp().hashCode());
        result = prime * result + ((getCreatePhone() == null) ? 0 : getCreatePhone().hashCode());
        result = prime * result + ((getCreateUid() == null) ? 0 : getCreateUid().hashCode());
        result = prime * result + ((getIsPrint() == null) ? 0 : getIsPrint().hashCode());
        result = prime * result + ((getPrintTime() == null) ? 0 : getPrintTime().hashCode());
        return result;
    }
}