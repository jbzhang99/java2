package com.rfchina.community.persistence.model;

import java.io.Serializable;

public class OpenUserService extends OpenUserServiceKey implements Serializable {
    private Integer lastUseCommunityId;

    private static final long serialVersionUID = 1L;

    public Integer getLastUseCommunityId() {
        return lastUseCommunityId;
    }

    public void setLastUseCommunityId(Integer lastUseCommunityId) {
        this.lastUseCommunityId = lastUseCommunityId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", lastUseCommunityId=").append(lastUseCommunityId);
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
        OpenUserService other = (OpenUserService) that;
        return (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getServiceId() == null ? other.getServiceId() == null : this.getServiceId().equals(other.getServiceId()))
            && (this.getLastUseCommunityId() == null ? other.getLastUseCommunityId() == null : this.getLastUseCommunityId().equals(other.getLastUseCommunityId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getServiceId() == null) ? 0 : getServiceId().hashCode());
        result = prime * result + ((getLastUseCommunityId() == null) ? 0 : getLastUseCommunityId().hashCode());
        return result;
    }
}