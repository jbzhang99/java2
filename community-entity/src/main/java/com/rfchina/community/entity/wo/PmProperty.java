package com.rfchina.community.entity.wo;

import java.io.Serializable;

/**
 */
public class PmProperty implements Serializable {

    private Integer ptyAutoId;//INT ID
    private String ptyCode;//String 编码
    private String ptyGuid;//String 项目Guid
    private String ptyParentGuid;//String 上一级GUID
    private Integer ptyParentAutoId;//INT 上一级ID
    private String ptyName;//   String 项目名称
    private Integer ptyType;//  INT 类型
    private Integer ptyOrder;//INT 排序
    private String ptyAddTime;//String  
    private String ptyModTime;//String

    public Integer getPtyAutoId() {
        return ptyAutoId;
    }

    public void setPtyAutoId(Integer ptyAutoId) {
        this.ptyAutoId = ptyAutoId;
    }

    public String getPtyCode() {
        return ptyCode;
    }

    public void setPtyCode(String ptyCode) {
        this.ptyCode = ptyCode;
    }

    public String getPtyGuid() {
        return ptyGuid;
    }

    public void setPtyGuid(String ptyGuid) {
        this.ptyGuid = ptyGuid;
    }

    public String getPtyParentGuid() {
        return ptyParentGuid;
    }

    public void setPtyParentGuid(String ptyParentGuid) {
        this.ptyParentGuid = ptyParentGuid;
    }

    public Integer getPtyParentAutoId() {
        return ptyParentAutoId;
    }

    public void setPtyParentAutoId(Integer ptyParentAutoId) {
        this.ptyParentAutoId = ptyParentAutoId;
    }

    public String getPtyName() {
        return ptyName;
    }

    public void setPtyName(String ptyName) {
        this.ptyName = ptyName;
    }

    public Integer getPtyType() {
        return ptyType;
    }

    public void setPtyType(Integer ptyType) {
        this.ptyType = ptyType;
    }

    public Integer getPtyOrder() {
        return ptyOrder;
    }

    public void setPtyOrder(Integer ptyOrder) {
        this.ptyOrder = ptyOrder;
    }

    public String getPtyAddTime() {
        return ptyAddTime;
    }

    public void setPtyAddTime(String ptyAddTime) {
        this.ptyAddTime = ptyAddTime;
    }

    public String getPtyModTime() {
        return ptyModTime;
    }

    public void setPtyModTime(String ptyModTime) {
        this.ptyModTime = ptyModTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PmProperty that = (PmProperty) o;

        if (ptyAutoId != null ? !ptyAutoId.equals(that.ptyAutoId) : that.ptyAutoId != null) return false;
        if (ptyCode != null ? !ptyCode.equals(that.ptyCode) : that.ptyCode != null) return false;
        if (ptyGuid != null ? !ptyGuid.equals(that.ptyGuid) : that.ptyGuid != null) return false;
        if (ptyParentGuid != null ? !ptyParentGuid.equals(that.ptyParentGuid) : that.ptyParentGuid != null)
            return false;
        if (ptyParentAutoId != null ? !ptyParentAutoId.equals(that.ptyParentAutoId) : that.ptyParentAutoId != null)
            return false;
        if (ptyName != null ? !ptyName.equals(that.ptyName) : that.ptyName != null) return false;
        if (ptyType != null ? !ptyType.equals(that.ptyType) : that.ptyType != null) return false;
        if (ptyOrder != null ? !ptyOrder.equals(that.ptyOrder) : that.ptyOrder != null) return false;
        if (ptyAddTime != null ? !ptyAddTime.equals(that.ptyAddTime) : that.ptyAddTime != null) return false;
        return ptyModTime != null ? ptyModTime.equals(that.ptyModTime) : that.ptyModTime == null;

    }

    @Override
    public int hashCode() {
        int result = ptyAutoId != null ? ptyAutoId.hashCode() : 0;
        result = 31 * result + (ptyCode != null ? ptyCode.hashCode() : 0);
        result = 31 * result + (ptyGuid != null ? ptyGuid.hashCode() : 0);
        result = 31 * result + (ptyParentGuid != null ? ptyParentGuid.hashCode() : 0);
        result = 31 * result + (ptyParentAutoId != null ? ptyParentAutoId.hashCode() : 0);
        result = 31 * result + (ptyName != null ? ptyName.hashCode() : 0);
        result = 31 * result + (ptyType != null ? ptyType.hashCode() : 0);
        result = 31 * result + (ptyOrder != null ? ptyOrder.hashCode() : 0);
        result = 31 * result + (ptyAddTime != null ? ptyAddTime.hashCode() : 0);
        result = 31 * result + (ptyModTime != null ? ptyModTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PmProperty{" +
                "ptyAutoId=" + ptyAutoId +
                ", ptyCode='" + ptyCode + '\'' +
                ", ptyGuid='" + ptyGuid + '\'' +
                ", ptyParentGuid='" + ptyParentGuid + '\'' +
                ", ptyParentAutoId=" + ptyParentAutoId +
                ", ptyName='" + ptyName + '\'' +
                ", ptyType=" + ptyType +
                ", ptyOrder=" + ptyOrder +
                ", ptyAddTime='" + ptyAddTime + '\'' +
                ", ptyModTime='" + ptyModTime + '\'' +
                '}';
    }
}
