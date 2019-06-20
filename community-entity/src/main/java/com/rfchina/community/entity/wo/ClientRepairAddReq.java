package com.rfchina.community.entity.wo;

import java.io.Serializable;
import java.util.List;

/**
 */
public class ClientRepairAddReq implements Serializable {

    private String caseType;

    private String source;

    private String category;

    private String projectGuid;

    private String floor;

    private String addr;

    private String device;

    private String repairUser;

    private String repairPhone;

    private String desc;

    private String orderNo;

    private List<RTaskFile> files;

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProjectGuid() {
        return projectGuid;
    }

    public void setProjectGuid(String projectGuid) {
        this.projectGuid = projectGuid;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getRepairUser() {
        return repairUser;
    }

    public void setRepairUser(String repairUser) {
        this.repairUser = repairUser;
    }

    public String getRepairPhone() {
        return repairPhone;
    }

    public void setRepairPhone(String repairPhone) {
        this.repairPhone = repairPhone;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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

        ClientRepairAddReq that = (ClientRepairAddReq) o;

        if (caseType != null ? !caseType.equals(that.caseType) : that.caseType != null) return false;
        if (source != null ? !source.equals(that.source) : that.source != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (projectGuid != null ? !projectGuid.equals(that.projectGuid) : that.projectGuid != null) return false;
        if (floor != null ? !floor.equals(that.floor) : that.floor != null) return false;
        if (addr != null ? !addr.equals(that.addr) : that.addr != null) return false;
        if (device != null ? !device.equals(that.device) : that.device != null) return false;
        if (repairUser != null ? !repairUser.equals(that.repairUser) : that.repairUser != null) return false;
        if (repairPhone != null ? !repairPhone.equals(that.repairPhone) : that.repairPhone != null) return false;
        if (desc != null ? !desc.equals(that.desc) : that.desc != null) return false;
        if (orderNo != null ? !orderNo.equals(that.orderNo) : that.orderNo != null) return false;
        return files != null ? files.equals(that.files) : that.files == null;

    }

    @Override
    public int hashCode() {
        int result = caseType != null ? caseType.hashCode() : 0;
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (projectGuid != null ? projectGuid.hashCode() : 0);
        result = 31 * result + (floor != null ? floor.hashCode() : 0);
        result = 31 * result + (addr != null ? addr.hashCode() : 0);
        result = 31 * result + (device != null ? device.hashCode() : 0);
        result = 31 * result + (repairUser != null ? repairUser.hashCode() : 0);
        result = 31 * result + (repairPhone != null ? repairPhone.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (orderNo != null ? orderNo.hashCode() : 0);
        result = 31 * result + (files != null ? files.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ClientRepairAddReq{" +
                "caseType='" + caseType + '\'' +
                ", source='" + source + '\'' +
                ", category='" + category + '\'' +
                ", projectGuid='" + projectGuid + '\'' +
                ", floor='" + floor + '\'' +
                ", addr='" + addr + '\'' +
                ", device='" + device + '\'' +
                ", repairUser='" + repairUser + '\'' +
                ", repairPhone='" + repairPhone + '\'' +
                ", desc='" + desc + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", files=" + files +
                '}';
    }
}
