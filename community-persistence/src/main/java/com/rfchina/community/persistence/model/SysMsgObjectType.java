package com.rfchina.community.persistence.model;

import java.io.Serializable;

public class SysMsgObjectType implements Serializable {
    private String otObjectType;

    private String otTitle;

    private String otTargetPf;

    private String otOpenType;

    private String otContent;

    private Integer otResource;

    private String otSourcePf;

    private static final long serialVersionUID = 1L;

    public String getOtObjectType() {
        return otObjectType;
    }

    public void setOtObjectType(String otObjectType) {
        this.otObjectType = otObjectType;
    }

    public String getOtTitle() {
        return otTitle;
    }

    public void setOtTitle(String otTitle) {
        this.otTitle = otTitle;
    }

    public String getOtTargetPf() {
        return otTargetPf;
    }

    public void setOtTargetPf(String otTargetPf) {
        this.otTargetPf = otTargetPf;
    }

    public String getOtOpenType() {
        return otOpenType;
    }

    public void setOtOpenType(String otOpenType) {
        this.otOpenType = otOpenType;
    }

    public String getOtContent() {
        return otContent;
    }

    public void setOtContent(String otContent) {
        this.otContent = otContent;
    }

    public Integer getOtResource() {
        return otResource;
    }

    public void setOtResource(Integer otResource) {
        this.otResource = otResource;
    }

    public String getOtSourcePf() {
        return otSourcePf;
    }

    public void setOtSourcePf(String otSourcePf) {
        this.otSourcePf = otSourcePf;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", otObjectType=").append(otObjectType);
        sb.append(", otTitle=").append(otTitle);
        sb.append(", otTargetPf=").append(otTargetPf);
        sb.append(", otOpenType=").append(otOpenType);
        sb.append(", otContent=").append(otContent);
        sb.append(", otResource=").append(otResource);
        sb.append(", otSourcePf=").append(otSourcePf);
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
        SysMsgObjectType other = (SysMsgObjectType) that;
        return (this.getOtObjectType() == null ? other.getOtObjectType() == null : this.getOtObjectType().equals(other.getOtObjectType()))
            && (this.getOtTitle() == null ? other.getOtTitle() == null : this.getOtTitle().equals(other.getOtTitle()))
            && (this.getOtTargetPf() == null ? other.getOtTargetPf() == null : this.getOtTargetPf().equals(other.getOtTargetPf()))
            && (this.getOtOpenType() == null ? other.getOtOpenType() == null : this.getOtOpenType().equals(other.getOtOpenType()))
            && (this.getOtContent() == null ? other.getOtContent() == null : this.getOtContent().equals(other.getOtContent()))
            && (this.getOtResource() == null ? other.getOtResource() == null : this.getOtResource().equals(other.getOtResource()))
            && (this.getOtSourcePf() == null ? other.getOtSourcePf() == null : this.getOtSourcePf().equals(other.getOtSourcePf()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOtObjectType() == null) ? 0 : getOtObjectType().hashCode());
        result = prime * result + ((getOtTitle() == null) ? 0 : getOtTitle().hashCode());
        result = prime * result + ((getOtTargetPf() == null) ? 0 : getOtTargetPf().hashCode());
        result = prime * result + ((getOtOpenType() == null) ? 0 : getOtOpenType().hashCode());
        result = prime * result + ((getOtContent() == null) ? 0 : getOtContent().hashCode());
        result = prime * result + ((getOtResource() == null) ? 0 : getOtResource().hashCode());
        result = prime * result + ((getOtSourcePf() == null) ? 0 : getOtSourcePf().hashCode());
        return result;
    }
}