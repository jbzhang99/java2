package com.rfchina.community.component.parking;

import java.util.List;

/**
 */
public class ListMonthlyInfosResponse extends AbstractParkingResponse {

    private Long pageTotal;

    private List<MonthlyInfo> data;

    public Long getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Long pageTotal) {
        this.pageTotal = pageTotal;
    }

    public List<MonthlyInfo> getData() {
        return data;
    }

    public void setData(List<MonthlyInfo> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ListMonthlyInfosResponse{" +
                "pageTotal=" + pageTotal +
                ", data=" + data +
                '}';
    }
}
