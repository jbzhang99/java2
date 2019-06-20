package com.rfchina.community.entity.wo;


/**
 */
public class ClientCusTaskAddRsp extends WoCommonRsp {

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
        if (!super.equals(o)) return false;

        ClientCusTaskAddRsp that = (ClientCusTaskAddRsp) o;

        return tskCode != null ? tskCode.equals(that.tskCode) : that.tskCode == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (tskCode != null ? tskCode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ClientCusTaskAddRsp{" +
                "tskCode='" + tskCode + '\'' +
                '}';
    }
}
