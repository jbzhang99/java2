package com.rfchina.community.entity;

/**
 */
public class TempFeeItem {

    private Integer zizaiCommunityId;

    private String chargeId;

    private String cityName;

    private String buildingName;

    private String projectName;

    private Long chargeTime;

    private String chargeFee;

    public Integer getZizaiCommunityId() {
        return zizaiCommunityId;
    }

    public void setZizaiCommunityId(Integer zizaiCommunityId) {
        this.zizaiCommunityId = zizaiCommunityId;
    }

    public String getChargeId() {
        return chargeId;
    }

    public void setChargeId(String chargeId) {
        this.chargeId = chargeId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getChargeTime() {
        return chargeTime;
    }

    public void setChargeTime(Long chargeTime) {
        this.chargeTime = chargeTime;
    }

    public String getChargeFee() {
        return chargeFee;
    }

    public void setChargeFee(String chargeFee) {
        this.chargeFee = chargeFee;
    }

    @Override
    public String toString() {
        return "TempFeeItem{" +
                "zizaiCommunityId=" + zizaiCommunityId +
                ", chargeId='" + chargeId + '\'' +
                ", cityName='" + cityName + '\'' +
                ", buildingName='" + buildingName + '\'' +
                ", projectName='" + projectName + '\'' +
                ", chargeTime=" + chargeTime +
                ", chargeFee='" + chargeFee + '\'' +
                '}';
    }
}
