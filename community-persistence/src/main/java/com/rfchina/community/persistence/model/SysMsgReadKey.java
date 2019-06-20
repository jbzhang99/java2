package com.rfchina.community.persistence.model;

import java.io.Serializable;

public class SysMsgReadKey implements Serializable {
    private Long adminUid;

    private Long msgId;

    private static final long serialVersionUID = 1L;

    public Long getAdminUid() {
        return adminUid;
    }

    public void setAdminUid(Long adminUid) {
        this.adminUid = adminUid;
    }

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", adminUid=").append(adminUid);
        sb.append(", msgId=").append(msgId);
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
        SysMsgReadKey other = (SysMsgReadKey) that;
        return (this.getAdminUid() == null ? other.getAdminUid() == null : this.getAdminUid().equals(other.getAdminUid()))
            && (this.getMsgId() == null ? other.getMsgId() == null : this.getMsgId().equals(other.getMsgId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAdminUid() == null) ? 0 : getAdminUid().hashCode());
        result = prime * result + ((getMsgId() == null) ? 0 : getMsgId().hashCode());
        return result;
    }
}