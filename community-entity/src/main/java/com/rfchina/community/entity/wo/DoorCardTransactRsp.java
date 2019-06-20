package com.rfchina.community.entity.wo;

/**
 */
public class DoorCardTransactRsp extends WoCommonRsp {

    private String tskCode;

    public String getTskCode() {
        return tskCode;
    }

    public void setTskCode(String tskCode) {
        this.tskCode = tskCode;
    }

    @Override
    public String toString() {
        return "DoorCardTransactRsp{" +
                "tskCode='" + tskCode + '\'' +
                '}';
    }
}
