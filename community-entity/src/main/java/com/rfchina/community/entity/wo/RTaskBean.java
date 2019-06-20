package com.rfchina.community.entity.wo;

import java.io.Serializable;

/**
 */
public class RTaskBean implements Serializable {

    private String tskCode;
    private String tskMcName;
    private String tskSource;
    private String tskCategory;
    private String tskAddr;
    private String tskDevice;
    private String tskDesc;
    private String tskRepairUser;
    private String tskRepairPhone;
    private Integer tskComplete;
    private String tskCompleteTime;
    private String tskAddTime;
    private String tskRemark;
    private String tskMcName1;
    private String tskMcName2;
    private Integer tskCount;
    private String tskStandTime;
    private String tskIsOrder;
    private String tskIsSecondary;
    private String tskOrderNo;
    private String tskLabourFee;
    private String tskMaterialFee;

    public String getTskCode() {
        return tskCode;
    }

    public void setTskCode(String tskCode) {
        this.tskCode = tskCode;
    }

    public String getTskMcName() {
        return tskMcName;
    }

    public void setTskMcName(String tskMcName) {
        this.tskMcName = tskMcName;
    }

    public String getTskSource() {
        return tskSource;
    }

    public void setTskSource(String tskSource) {
        this.tskSource = tskSource;
    }

    public String getTskCategory() {
        return tskCategory;
    }

    public void setTskCategory(String tskCategory) {
        this.tskCategory = tskCategory;
    }

    public String getTskAddr() {
        return tskAddr;
    }

    public void setTskAddr(String tskAddr) {
        this.tskAddr = tskAddr;
    }

    public String getTskDevice() {
        return tskDevice;
    }

    public void setTskDevice(String tskDevice) {
        this.tskDevice = tskDevice;
    }

    public String getTskDesc() {
        return tskDesc;
    }

    public void setTskDesc(String tskDesc) {
        this.tskDesc = tskDesc;
    }

    public String getTskRepairUser() {
        return tskRepairUser;
    }

    public void setTskRepairUser(String tskRepairUser) {
        this.tskRepairUser = tskRepairUser;
    }

    public String getTskRepairPhone() {
        return tskRepairPhone;
    }

    public void setTskRepairPhone(String tskRepairPhone) {
        this.tskRepairPhone = tskRepairPhone;
    }

    public Integer getTskComplete() {
        return tskComplete;
    }

    public void setTskComplete(Integer tskComplete) {
        this.tskComplete = tskComplete;
    }

    public String getTskCompleteTime() {
        return tskCompleteTime;
    }

    public void setTskCompleteTime(String tskCompleteTime) {
        this.tskCompleteTime = tskCompleteTime;
    }

    public String getTskAddTime() {
        return tskAddTime;
    }

    public void setTskAddTime(String tskAddTime) {
        this.tskAddTime = tskAddTime;
    }

    public String getTskRemark() {
        return tskRemark;
    }

    public void setTskRemark(String tskRemark) {
        this.tskRemark = tskRemark;
    }

    public String getTskMcName1() {
        return tskMcName1;
    }

    public void setTskMcName1(String tskMcName1) {
        this.tskMcName1 = tskMcName1;
    }

    public String getTskMcName2() {
        return tskMcName2;
    }

    public void setTskMcName2(String tskMcName2) {
        this.tskMcName2 = tskMcName2;
    }

    public Integer getTskCount() {
        return tskCount;
    }

    public void setTskCount(Integer tskCount) {
        this.tskCount = tskCount;
    }

    public String getTskStandTime() {
        return tskStandTime;
    }

    public void setTskStandTime(String tskStandTime) {
        this.tskStandTime = tskStandTime;
    }

    public String getTskIsOrder() {
        return tskIsOrder;
    }

    public void setTskIsOrder(String tskIsOrder) {
        this.tskIsOrder = tskIsOrder;
    }

    public String getTskIsSecondary() {
        return tskIsSecondary;
    }

    public void setTskIsSecondary(String tskIsSecondary) {
        this.tskIsSecondary = tskIsSecondary;
    }

    public String getTskOrderNo() {
        return tskOrderNo;
    }

    public void setTskOrderNo(String tskOrderNo) {
        this.tskOrderNo = tskOrderNo;
    }

    public String getTskLabourFee() {
        return tskLabourFee;
    }

    public void setTskLabourFee(String tskLabourFee) {
        this.tskLabourFee = tskLabourFee;
    }

    public String getTskMaterialFee() {
        return tskMaterialFee;
    }

    public void setTskMaterialFee(String tskMaterialFee) {
        this.tskMaterialFee = tskMaterialFee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RTaskBean rTaskBean = (RTaskBean) o;

        if (tskCode != null ? !tskCode.equals(rTaskBean.tskCode) : rTaskBean.tskCode != null) return false;
        if (tskMcName != null ? !tskMcName.equals(rTaskBean.tskMcName) : rTaskBean.tskMcName != null) return false;
        if (tskSource != null ? !tskSource.equals(rTaskBean.tskSource) : rTaskBean.tskSource != null) return false;
        if (tskCategory != null ? !tskCategory.equals(rTaskBean.tskCategory) : rTaskBean.tskCategory != null)
            return false;
        if (tskAddr != null ? !tskAddr.equals(rTaskBean.tskAddr) : rTaskBean.tskAddr != null) return false;
        if (tskDevice != null ? !tskDevice.equals(rTaskBean.tskDevice) : rTaskBean.tskDevice != null) return false;
        if (tskDesc != null ? !tskDesc.equals(rTaskBean.tskDesc) : rTaskBean.tskDesc != null) return false;
        if (tskRepairUser != null ? !tskRepairUser.equals(rTaskBean.tskRepairUser) : rTaskBean.tskRepairUser != null)
            return false;
        if (tskRepairPhone != null ? !tskRepairPhone.equals(rTaskBean.tskRepairPhone) : rTaskBean.tskRepairPhone != null)
            return false;
        if (tskComplete != null ? !tskComplete.equals(rTaskBean.tskComplete) : rTaskBean.tskComplete != null)
            return false;
        if (tskCompleteTime != null ? !tskCompleteTime.equals(rTaskBean.tskCompleteTime) : rTaskBean.tskCompleteTime != null)
            return false;
        if (tskAddTime != null ? !tskAddTime.equals(rTaskBean.tskAddTime) : rTaskBean.tskAddTime != null) return false;
        if (tskRemark != null ? !tskRemark.equals(rTaskBean.tskRemark) : rTaskBean.tskRemark != null) return false;
        if (tskMcName1 != null ? !tskMcName1.equals(rTaskBean.tskMcName1) : rTaskBean.tskMcName1 != null) return false;
        if (tskMcName2 != null ? !tskMcName2.equals(rTaskBean.tskMcName2) : rTaskBean.tskMcName2 != null) return false;
        if (tskCount != null ? !tskCount.equals(rTaskBean.tskCount) : rTaskBean.tskCount != null) return false;
        if (tskStandTime != null ? !tskStandTime.equals(rTaskBean.tskStandTime) : rTaskBean.tskStandTime != null)
            return false;
        if (tskIsOrder != null ? !tskIsOrder.equals(rTaskBean.tskIsOrder) : rTaskBean.tskIsOrder != null) return false;
        if (tskIsSecondary != null ? !tskIsSecondary.equals(rTaskBean.tskIsSecondary) : rTaskBean.tskIsSecondary != null)
            return false;
        if (tskOrderNo != null ? !tskOrderNo.equals(rTaskBean.tskOrderNo) : rTaskBean.tskOrderNo != null) return false;
        if (tskLabourFee != null ? !tskLabourFee.equals(rTaskBean.tskLabourFee) : rTaskBean.tskLabourFee != null)
            return false;
        return tskMaterialFee != null ? tskMaterialFee.equals(rTaskBean.tskMaterialFee) : rTaskBean.tskMaterialFee == null;

    }

    @Override
    public int hashCode() {
        int result = tskCode != null ? tskCode.hashCode() : 0;
        result = 31 * result + (tskMcName != null ? tskMcName.hashCode() : 0);
        result = 31 * result + (tskSource != null ? tskSource.hashCode() : 0);
        result = 31 * result + (tskCategory != null ? tskCategory.hashCode() : 0);
        result = 31 * result + (tskAddr != null ? tskAddr.hashCode() : 0);
        result = 31 * result + (tskDevice != null ? tskDevice.hashCode() : 0);
        result = 31 * result + (tskDesc != null ? tskDesc.hashCode() : 0);
        result = 31 * result + (tskRepairUser != null ? tskRepairUser.hashCode() : 0);
        result = 31 * result + (tskRepairPhone != null ? tskRepairPhone.hashCode() : 0);
        result = 31 * result + (tskComplete != null ? tskComplete.hashCode() : 0);
        result = 31 * result + (tskCompleteTime != null ? tskCompleteTime.hashCode() : 0);
        result = 31 * result + (tskAddTime != null ? tskAddTime.hashCode() : 0);
        result = 31 * result + (tskRemark != null ? tskRemark.hashCode() : 0);
        result = 31 * result + (tskMcName1 != null ? tskMcName1.hashCode() : 0);
        result = 31 * result + (tskMcName2 != null ? tskMcName2.hashCode() : 0);
        result = 31 * result + (tskCount != null ? tskCount.hashCode() : 0);
        result = 31 * result + (tskStandTime != null ? tskStandTime.hashCode() : 0);
        result = 31 * result + (tskIsOrder != null ? tskIsOrder.hashCode() : 0);
        result = 31 * result + (tskIsSecondary != null ? tskIsSecondary.hashCode() : 0);
        result = 31 * result + (tskOrderNo != null ? tskOrderNo.hashCode() : 0);
        result = 31 * result + (tskLabourFee != null ? tskLabourFee.hashCode() : 0);
        result = 31 * result + (tskMaterialFee != null ? tskMaterialFee.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RTaskBean{" +
                "tskCode='" + tskCode + '\'' +
                ", tskMcName='" + tskMcName + '\'' +
                ", tskSource='" + tskSource + '\'' +
                ", tskCategory='" + tskCategory + '\'' +
                ", tskAddr='" + tskAddr + '\'' +
                ", tskDevice='" + tskDevice + '\'' +
                ", tskDesc='" + tskDesc + '\'' +
                ", tskRepairUser='" + tskRepairUser + '\'' +
                ", tskRepairPhone='" + tskRepairPhone + '\'' +
                ", tskComplete=" + tskComplete +
                ", tskCompleteTime='" + tskCompleteTime + '\'' +
                ", tskAddTime='" + tskAddTime + '\'' +
                ", tskRemark='" + tskRemark + '\'' +
                ", tskMcName1='" + tskMcName1 + '\'' +
                ", tskMcName2='" + tskMcName2 + '\'' +
                ", tskCount=" + tskCount +
                ", tskStandTime='" + tskStandTime + '\'' +
                ", tskIsOrder='" + tskIsOrder + '\'' +
                ", tskIsSecondary='" + tskIsSecondary + '\'' +
                ", tskOrderNo='" + tskOrderNo + '\'' +
                ", tskLabourFee='" + tskLabourFee + '\'' +
                ", tskMaterialFee='" + tskMaterialFee + '\'' +
                '}';
    }
}
