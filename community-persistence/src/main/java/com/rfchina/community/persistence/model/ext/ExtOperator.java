package com.rfchina.community.persistence.model.ext;

import com.rfchina.community.persistence.model.OpenOperatorTaskRel;

import java.math.BigDecimal;
import java.util.Date;

public class ExtOperator extends OpenOperatorTaskRel{
    private BigDecimal sumAmount;
    private int activityStatus;
    private String actTitile;

    private int status;
    private long xfsjId;
    private int serviceId;
    private Date startTime;

    private Date endTime;
    private int releaseStatus;

    public int getReleaseStatus() {
        return releaseStatus;
    }

    public void setReleaseStatus(int releaseStatus) {
        this.releaseStatus = releaseStatus;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getActTitile() {
        return actTitile;
    }

    public void setActTitile(String actTitile) {
        this.actTitile = actTitile;
    }

    public long getXfsjId() {
        return xfsjId;
    }

    public void setXfsjId(long xfsjId) {
        this.xfsjId = xfsjId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public BigDecimal getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(BigDecimal sumAmount) {
        this.sumAmount = sumAmount;
    }

    public int getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(int activityStatus) {
        this.activityStatus = activityStatus;
    }
}
