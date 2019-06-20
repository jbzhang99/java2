package com.rfchina.community.component.parking;

/**
 */
public class GetRealTimeResponse extends AbstractParkingResponse {

    private Long totalCount;

    private Long availableCount;

    private Long freeDuration;

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Long getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(Long availableCount) {
        this.availableCount = availableCount;
    }

    public Long getFreeDuration() {
        return freeDuration;
    }

    public void setFreeDuration(Long freeDuration) {
        this.freeDuration = freeDuration;
    }
}
