package com.rfchina.community.component.parking;

import java.util.HashMap;
import java.util.Map;

/**
 */
public class ListMonthlyInfosRequest extends AbstractParkingRequest {

    private String parkingCode;

    private Integer pageIndex;

    private Integer pageSize;

    public String getParkingCode() {
        return parkingCode;
    }

    public void setParkingCode(String parkingCode) {
        this.parkingCode = parkingCode;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public Map<String, String> toMap() {
        Map<String, String> map = super.toMap();
        map.put("parkingCode", this.parkingCode);
        map.put("pageIndex", String.valueOf(this.pageIndex));
        map.put("pageSize", String.valueOf(this.pageSize));
        return map;
    }
}
