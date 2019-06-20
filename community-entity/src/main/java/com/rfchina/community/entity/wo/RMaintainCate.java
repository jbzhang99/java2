package com.rfchina.community.entity.wo;

import java.io.Serializable;

/**
 */
public class RMaintainCate implements Serializable {

    private Integer mcAutoId;
    private String mcGuid;
    private String mcCateName;
    private Integer mcParentId;
    private Integer mcSort;
    private Integer mcOddNumber;
    private Integer mcFinishHour;
    private Integer mcState;
    private String mcModTime;

    public Integer getMcAutoId() {
        return mcAutoId;
    }

    public void setMcAutoId(Integer mcAutoId) {
        this.mcAutoId = mcAutoId;
    }

    public String getMcGuid() {
        return mcGuid;
    }

    public void setMcGuid(String mcGuid) {
        this.mcGuid = mcGuid;
    }

    public String getMcCateName() {
        return mcCateName;
    }

    public void setMcCateName(String mcCateName) {
        this.mcCateName = mcCateName;
    }

    public Integer getMcParentId() {
        return mcParentId;
    }

    public void setMcParentId(Integer mcParentId) {
        this.mcParentId = mcParentId;
    }

    public Integer getMcSort() {
        return mcSort;
    }

    public void setMcSort(Integer mcSort) {
        this.mcSort = mcSort;
    }

    public Integer getMcOddNumber() {
        return mcOddNumber;
    }

    public void setMcOddNumber(Integer mcOddNumber) {
        this.mcOddNumber = mcOddNumber;
    }

    public Integer getMcFinishHour() {
        return mcFinishHour;
    }

    public void setMcFinishHour(Integer mcFinishHour) {
        this.mcFinishHour = mcFinishHour;
    }

    public Integer getMcState() {
        return mcState;
    }

    public void setMcState(Integer mcState) {
        this.mcState = mcState;
    }

    public String getMcModTime() {
        return mcModTime;
    }

    public void setMcModTime(String mcModTime) {
        this.mcModTime = mcModTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RMaintainCate that = (RMaintainCate) o;

        if (mcAutoId != null ? !mcAutoId.equals(that.mcAutoId) : that.mcAutoId != null) return false;
        if (mcGuid != null ? !mcGuid.equals(that.mcGuid) : that.mcGuid != null) return false;
        if (mcCateName != null ? !mcCateName.equals(that.mcCateName) : that.mcCateName != null) return false;
        if (mcParentId != null ? !mcParentId.equals(that.mcParentId) : that.mcParentId != null) return false;
        if (mcSort != null ? !mcSort.equals(that.mcSort) : that.mcSort != null) return false;
        if (mcOddNumber != null ? !mcOddNumber.equals(that.mcOddNumber) : that.mcOddNumber != null) return false;
        if (mcFinishHour != null ? !mcFinishHour.equals(that.mcFinishHour) : that.mcFinishHour != null) return false;
        if (mcState != null ? !mcState.equals(that.mcState) : that.mcState != null) return false;
        return mcModTime != null ? mcModTime.equals(that.mcModTime) : that.mcModTime == null;

    }

    @Override
    public int hashCode() {
        int result = mcAutoId != null ? mcAutoId.hashCode() : 0;
        result = 31 * result + (mcGuid != null ? mcGuid.hashCode() : 0);
        result = 31 * result + (mcCateName != null ? mcCateName.hashCode() : 0);
        result = 31 * result + (mcParentId != null ? mcParentId.hashCode() : 0);
        result = 31 * result + (mcSort != null ? mcSort.hashCode() : 0);
        result = 31 * result + (mcOddNumber != null ? mcOddNumber.hashCode() : 0);
        result = 31 * result + (mcFinishHour != null ? mcFinishHour.hashCode() : 0);
        result = 31 * result + (mcState != null ? mcState.hashCode() : 0);
        result = 31 * result + (mcModTime != null ? mcModTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RMaintainCate{" +
                "mcAutoId=" + mcAutoId +
                ", mcGuid='" + mcGuid + '\'' +
                ", mcCateName='" + mcCateName + '\'' +
                ", mcParentId=" + mcParentId +
                ", mcSort=" + mcSort +
                ", mcOddNumber=" + mcOddNumber +
                ", mcFinishHour=" + mcFinishHour +
                ", mcState=" + mcState +
                ", mcModTime='" + mcModTime + '\'' +
                '}';
    }
}
