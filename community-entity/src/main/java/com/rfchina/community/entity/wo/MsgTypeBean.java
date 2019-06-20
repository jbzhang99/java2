package com.rfchina.community.entity.wo;

import java.io.Serializable;

/**
 */
public class MsgTypeBean implements Serializable {

    private Integer mtAutoId;
    private String mtGuid;
    private String mtName;
    private Integer mtOrder;

    public Integer getMtAutoId() {
        return mtAutoId;
    }

    public void setMtAutoId(Integer mtAutoId) {
        this.mtAutoId = mtAutoId;
    }

    public String getMtGuid() {
        return mtGuid;
    }

    public void setMtGuid(String mtGuid) {
        this.mtGuid = mtGuid;
    }

    public String getMtName() {
        return mtName;
    }

    public void setMtName(String mtName) {
        this.mtName = mtName;
    }

    public Integer getMtOrder() {
        return mtOrder;
    }

    public void setMtOrder(Integer mtOrder) {
        this.mtOrder = mtOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MsgTypeBean that = (MsgTypeBean) o;

        if (mtGuid != null ? !mtGuid.equals(that.mtGuid) : that.mtGuid != null) return false;
        if (mtName != null ? !mtName.equals(that.mtName) : that.mtName != null) return false;
        return mtOrder != null ? mtOrder.equals(that.mtOrder) : that.mtOrder == null;

    }

    @Override
    public int hashCode() {
        int result = mtGuid != null ? mtGuid.hashCode() : 0;
        result = 31 * result + (mtName != null ? mtName.hashCode() : 0);
        result = 31 * result + (mtOrder != null ? mtOrder.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MsgTypeBean{" +
                "mtGuid='" + mtGuid + '\'' +
                ", mtName='" + mtName + '\'' +
                ", mtOrder=" + mtOrder +
                '}';
    }
}
