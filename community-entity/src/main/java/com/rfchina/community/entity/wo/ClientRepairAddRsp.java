package com.rfchina.community.entity.wo;

/**
 */
public class ClientRepairAddRsp extends WoCommonRsp {

    private String tskCode;

    public String getTskCode() {
        return tskCode;
    }

    public void setTskCode(String tskCode) {
        this.tskCode = tskCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientRepairAddRsp that = (ClientRepairAddRsp) o;

        return tskCode != null ? tskCode.equals(that.tskCode) : that.tskCode == null;

    }

    @Override
    public int hashCode() {
        return tskCode != null ? tskCode.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ClientRepairAddRsp{" +
                "tskCode='" + tskCode + '\'' +
                '}';
    }
}
