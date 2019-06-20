package com.rfchina.community.persistence.model;

import java.io.Serializable;

public class OpenTempletInfo implements Serializable {
    private String templeteName;

    private String title;

    private Integer orderby;

    private String remarks;

    private String installBank;

    private Integer status;

    private String pic;

    private String qrcodPic;

    private String tags;

    private static final long serialVersionUID = 1L;

    public String getTempleteName() {
        return templeteName;
    }

    public void setTempleteName(String templeteName) {
        this.templeteName = templeteName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getOrderby() {
        return orderby;
    }

    public void setOrderby(Integer orderby) {
        this.orderby = orderby;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getInstallBank() {
        return installBank;
    }

    public void setInstallBank(String installBank) {
        this.installBank = installBank;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getQrcodPic() {
        return qrcodPic;
    }

    public void setQrcodPic(String qrcodPic) {
        this.qrcodPic = qrcodPic;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", templeteName=").append(templeteName);
        sb.append(", title=").append(title);
        sb.append(", orderby=").append(orderby);
        sb.append(", remarks=").append(remarks);
        sb.append(", installBank=").append(installBank);
        sb.append(", status=").append(status);
        sb.append(", pic=").append(pic);
        sb.append(", qrcodPic=").append(qrcodPic);
        sb.append(", tags=").append(tags);
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
        OpenTempletInfo other = (OpenTempletInfo) that;
        return (this.getTempleteName() == null ? other.getTempleteName() == null : this.getTempleteName().equals(other.getTempleteName()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getOrderby() == null ? other.getOrderby() == null : this.getOrderby().equals(other.getOrderby()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
            && (this.getInstallBank() == null ? other.getInstallBank() == null : this.getInstallBank().equals(other.getInstallBank()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getPic() == null ? other.getPic() == null : this.getPic().equals(other.getPic()))
            && (this.getQrcodPic() == null ? other.getQrcodPic() == null : this.getQrcodPic().equals(other.getQrcodPic()))
            && (this.getTags() == null ? other.getTags() == null : this.getTags().equals(other.getTags()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTempleteName() == null) ? 0 : getTempleteName().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getOrderby() == null) ? 0 : getOrderby().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getInstallBank() == null) ? 0 : getInstallBank().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getPic() == null) ? 0 : getPic().hashCode());
        result = prime * result + ((getQrcodPic() == null) ? 0 : getQrcodPic().hashCode());
        result = prime * result + ((getTags() == null) ? 0 : getTags().hashCode());
        return result;
    }
}