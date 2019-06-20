package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class SysDataUpload implements Serializable {
    private Integer id;

    private String srcLink;

    private String downLink;

    private Date createTime;

    private Long createUid;

    private Integer communityId;

    private Long masterId;

    private Integer status;

    private Integer xlsxIndex;

    private String userPath;

    private String fileName;

    private Integer testRun;

    private String error;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSrcLink() {
        return srcLink;
    }

    public void setSrcLink(String srcLink) {
        this.srcLink = srcLink;
    }

    public String getDownLink() {
        return downLink;
    }

    public void setDownLink(String downLink) {
        this.downLink = downLink;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUid() {
        return createUid;
    }

    public void setCreateUid(Long createUid) {
        this.createUid = createUid;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public Long getMasterId() {
        return masterId;
    }

    public void setMasterId(Long masterId) {
        this.masterId = masterId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getXlsxIndex() {
        return xlsxIndex;
    }

    public void setXlsxIndex(Integer xlsxIndex) {
        this.xlsxIndex = xlsxIndex;
    }

    public String getUserPath() {
        return userPath;
    }

    public void setUserPath(String userPath) {
        this.userPath = userPath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getTestRun() {
        return testRun;
    }

    public void setTestRun(Integer testRun) {
        this.testRun = testRun;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", srcLink=").append(srcLink);
        sb.append(", downLink=").append(downLink);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUid=").append(createUid);
        sb.append(", communityId=").append(communityId);
        sb.append(", masterId=").append(masterId);
        sb.append(", status=").append(status);
        sb.append(", xlsxIndex=").append(xlsxIndex);
        sb.append(", userPath=").append(userPath);
        sb.append(", fileName=").append(fileName);
        sb.append(", testRun=").append(testRun);
        sb.append(", error=").append(error);
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
        SysDataUpload other = (SysDataUpload) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSrcLink() == null ? other.getSrcLink() == null : this.getSrcLink().equals(other.getSrcLink()))
            && (this.getDownLink() == null ? other.getDownLink() == null : this.getDownLink().equals(other.getDownLink()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateUid() == null ? other.getCreateUid() == null : this.getCreateUid().equals(other.getCreateUid()))
            && (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getMasterId() == null ? other.getMasterId() == null : this.getMasterId().equals(other.getMasterId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getXlsxIndex() == null ? other.getXlsxIndex() == null : this.getXlsxIndex().equals(other.getXlsxIndex()))
            && (this.getUserPath() == null ? other.getUserPath() == null : this.getUserPath().equals(other.getUserPath()))
            && (this.getFileName() == null ? other.getFileName() == null : this.getFileName().equals(other.getFileName()))
            && (this.getTestRun() == null ? other.getTestRun() == null : this.getTestRun().equals(other.getTestRun()))
            && (this.getError() == null ? other.getError() == null : this.getError().equals(other.getError()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSrcLink() == null) ? 0 : getSrcLink().hashCode());
        result = prime * result + ((getDownLink() == null) ? 0 : getDownLink().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateUid() == null) ? 0 : getCreateUid().hashCode());
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getMasterId() == null) ? 0 : getMasterId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getXlsxIndex() == null) ? 0 : getXlsxIndex().hashCode());
        result = prime * result + ((getUserPath() == null) ? 0 : getUserPath().hashCode());
        result = prime * result + ((getFileName() == null) ? 0 : getFileName().hashCode());
        result = prime * result + ((getTestRun() == null) ? 0 : getTestRun().hashCode());
        result = prime * result + ((getError() == null) ? 0 : getError().hashCode());
        return result;
    }
}