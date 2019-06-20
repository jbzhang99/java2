package com.rfchina.community.persistence.model;

import java.io.Serializable;

public class OpenOrderDetail implements Serializable {
    private Long id;

    private String payCreateResponse;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPayCreateResponse() {
        return payCreateResponse;
    }

    public void setPayCreateResponse(String payCreateResponse) {
        this.payCreateResponse = payCreateResponse;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", payCreateResponse=").append(payCreateResponse);
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
        OpenOrderDetail other = (OpenOrderDetail) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPayCreateResponse() == null ? other.getPayCreateResponse() == null : this.getPayCreateResponse().equals(other.getPayCreateResponse()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPayCreateResponse() == null) ? 0 : getPayCreateResponse().hashCode());
        return result;
    }
}