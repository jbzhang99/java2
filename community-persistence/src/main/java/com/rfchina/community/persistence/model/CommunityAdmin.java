package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class CommunityAdmin implements Serializable {
    private Long id;

    private Long passportId;

    private Integer communityId;

    private String realname;

    private String phone;

    private String tel;

    private String email;

    private String intro;

    private Integer status;

    private String position;

    private String dept;

    private Integer deleteFlag;

    private Date latestLoginTime;

    private Integer agreeProtocol;

    private String communityIds;

    private String defCommunityIds;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPassportId() {
        return passportId;
    }

    public void setPassportId(Long passportId) {
        this.passportId = passportId;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Date getLatestLoginTime() {
        return latestLoginTime;
    }

    public void setLatestLoginTime(Date latestLoginTime) {
        this.latestLoginTime = latestLoginTime;
    }

    public Integer getAgreeProtocol() {
        return agreeProtocol;
    }

    public void setAgreeProtocol(Integer agreeProtocol) {
        this.agreeProtocol = agreeProtocol;
    }

    public String getCommunityIds() {
        return communityIds;
    }

    public void setCommunityIds(String communityIds) {
        this.communityIds = communityIds;
    }

    public String getDefCommunityIds() {
        return defCommunityIds;
    }

    public void setDefCommunityIds(String defCommunityIds) {
        this.defCommunityIds = defCommunityIds;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", passportId=").append(passportId);
        sb.append(", communityId=").append(communityId);
        sb.append(", realname=").append(realname);
        sb.append(", phone=").append(phone);
        sb.append(", tel=").append(tel);
        sb.append(", email=").append(email);
        sb.append(", intro=").append(intro);
        sb.append(", status=").append(status);
        sb.append(", position=").append(position);
        sb.append(", dept=").append(dept);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", latestLoginTime=").append(latestLoginTime);
        sb.append(", agreeProtocol=").append(agreeProtocol);
        sb.append(", communityIds=").append(communityIds);
        sb.append(", defCommunityIds=").append(defCommunityIds);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
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
        CommunityAdmin other = (CommunityAdmin) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPassportId() == null ? other.getPassportId() == null : this.getPassportId().equals(other.getPassportId()))
            && (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getRealname() == null ? other.getRealname() == null : this.getRealname().equals(other.getRealname()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getTel() == null ? other.getTel() == null : this.getTel().equals(other.getTel()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getIntro() == null ? other.getIntro() == null : this.getIntro().equals(other.getIntro()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getPosition() == null ? other.getPosition() == null : this.getPosition().equals(other.getPosition()))
            && (this.getDept() == null ? other.getDept() == null : this.getDept().equals(other.getDept()))
            && (this.getDeleteFlag() == null ? other.getDeleteFlag() == null : this.getDeleteFlag().equals(other.getDeleteFlag()))
            && (this.getLatestLoginTime() == null ? other.getLatestLoginTime() == null : this.getLatestLoginTime().equals(other.getLatestLoginTime()))
            && (this.getAgreeProtocol() == null ? other.getAgreeProtocol() == null : this.getAgreeProtocol().equals(other.getAgreeProtocol()))
            && (this.getCommunityIds() == null ? other.getCommunityIds() == null : this.getCommunityIds().equals(other.getCommunityIds()))
            && (this.getDefCommunityIds() == null ? other.getDefCommunityIds() == null : this.getDefCommunityIds().equals(other.getDefCommunityIds()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPassportId() == null) ? 0 : getPassportId().hashCode());
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getRealname() == null) ? 0 : getRealname().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getTel() == null) ? 0 : getTel().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getIntro() == null) ? 0 : getIntro().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getPosition() == null) ? 0 : getPosition().hashCode());
        result = prime * result + ((getDept() == null) ? 0 : getDept().hashCode());
        result = prime * result + ((getDeleteFlag() == null) ? 0 : getDeleteFlag().hashCode());
        result = prime * result + ((getLatestLoginTime() == null) ? 0 : getLatestLoginTime().hashCode());
        result = prime * result + ((getAgreeProtocol() == null) ? 0 : getAgreeProtocol().hashCode());
        result = prime * result + ((getCommunityIds() == null) ? 0 : getCommunityIds().hashCode());
        result = prime * result + ((getDefCommunityIds() == null) ? 0 : getDefCommunityIds().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}