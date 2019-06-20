package com.rfchina.community.entity.wo;

import java.io.Serializable;

public class OperatorTaskPush implements Serializable {
    private int type;
    private Long communityId;
    private Long tskId;
    private Long tskdId;
    private String activityName;
    private String empGuid;

    public Long getTskdId() {
        return tskdId;
    }

    public void setTskdId(Long tskdId) {
        this.tskdId = tskdId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public Long getTskId() {
        return tskId;
    }

    public void setTskId(Long tskId) {
        this.tskId = tskId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getEmpGuid() {
        return empGuid;
    }

    public void setEmpGuid(String empGuid) {
        this.empGuid = empGuid;
    }

    @Override
    public String toString() {
        return "OperatorTaskPush{" +
                "type=" + type +
                ", communityId=" + communityId +
                ", tskId=" + tskId +
                ", activityName='" + activityName + '\'' +
                ", empGuid='" + empGuid + '\'' +
                '}';
    }
}
