package com.rfchina.community.entity.wo;

import java.io.Serializable;
import java.util.List;

/**
 */
public class ClientRepairTaskVerifReq implements Serializable {

    private String orderNo;
    private String tskCode;
    private String comments;
    private Integer satisfaction;
    private List<RTaskFile> files;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getTskCode() {
        return tskCode;
    }

    public void setTskCode(String tskCode) {
        this.tskCode = tskCode;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(Integer satisfaction) {
        this.satisfaction = satisfaction;
    }

    public List<RTaskFile> getFiles() {
        return files;
    }

    public void setFiles(List<RTaskFile> files) {
        this.files = files;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientRepairTaskVerifReq that = (ClientRepairTaskVerifReq) o;

        if (orderNo != null ? !orderNo.equals(that.orderNo) : that.orderNo != null) return false;
        if (tskCode != null ? !tskCode.equals(that.tskCode) : that.tskCode != null) return false;
        if (comments != null ? !comments.equals(that.comments) : that.comments != null) return false;
        if (satisfaction != null ? !satisfaction.equals(that.satisfaction) : that.satisfaction != null) return false;
        return files != null ? files.equals(that.files) : that.files == null;

    }

    @Override
    public int hashCode() {
        int result = orderNo != null ? orderNo.hashCode() : 0;
        result = 31 * result + (tskCode != null ? tskCode.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (satisfaction != null ? satisfaction.hashCode() : 0);
        result = 31 * result + (files != null ? files.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ClientRepairTaskVerifReq{" +
                "orderNo='" + orderNo + '\'' +
                ", tskCode='" + tskCode + '\'' +
                ", comments='" + comments + '\'' +
                ", satisfaction='" + satisfaction + '\'' +
                ", files=" + files +
                '}';
    }
}
