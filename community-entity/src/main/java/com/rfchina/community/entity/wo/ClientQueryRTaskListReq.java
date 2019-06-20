package com.rfchina.community.entity.wo;

import java.io.Serializable;

/**
 */
public class ClientQueryRTaskListReq implements Serializable {

    private String repairPhone;

    private String starDate;

    private String endDate;

    private String tskCode;

    private String orderNo;

    private Integer pageSize;

    private Integer startRow;

    public String getRepairPhone() {
        return repairPhone;
    }

    public void setRepairPhone(String repairPhone) {
        this.repairPhone = repairPhone;
    }

    public String getStarDate() {
        return starDate;
    }

    public void setStarDate(String starDate) {
        this.starDate = starDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTskCode() {
        return tskCode;
    }

    public void setTskCode(String tskCode) {
        this.tskCode = tskCode;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientQueryRTaskListReq that = (ClientQueryRTaskListReq) o;

        if (repairPhone != null ? !repairPhone.equals(that.repairPhone) : that.repairPhone != null) return false;
        if (starDate != null ? !starDate.equals(that.starDate) : that.starDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (tskCode != null ? !tskCode.equals(that.tskCode) : that.tskCode != null) return false;
        if (orderNo != null ? !orderNo.equals(that.orderNo) : that.orderNo != null) return false;
        if (pageSize != null ? !pageSize.equals(that.pageSize) : that.pageSize != null) return false;
        return startRow != null ? startRow.equals(that.startRow) : that.startRow == null;

    }

    @Override
    public int hashCode() {
        int result = repairPhone != null ? repairPhone.hashCode() : 0;
        result = 31 * result + (starDate != null ? starDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (tskCode != null ? tskCode.hashCode() : 0);
        result = 31 * result + (orderNo != null ? orderNo.hashCode() : 0);
        result = 31 * result + (pageSize != null ? pageSize.hashCode() : 0);
        result = 31 * result + (startRow != null ? startRow.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ClientQueryRTaskListReq{" +
                "repairPhone='" + repairPhone + '\'' +
                ", starDate='" + starDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", tskCode='" + tskCode + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", pageSize=" + pageSize +
                ", startRow=" + startRow +
                '}';
    }
}
