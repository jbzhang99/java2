package com.rfchina.community.entity.wo;

import java.io.Serializable;

public class EmpBean implements Serializable {

    public interface EmpState {
        Integer AUDIT_NOTPASS = -2;
        Integer FORBIDDEN = -1;
        Integer UNAUDIT = 0;
        Integer NORMAL = 1;
    }

    private Long empAutoId;
    private String empGuid;
    private String empComGuid;
    private String empLoginName;
    private String empName;
    private String empEmail;
    private String empSex;
    private String empMobile;
    private Integer empState;
    private String empFaceImgUrl;
    private String empComName;
    private String empProjectGuid;
    private String empProjectName;
    private String empDepName;
    private Integer empComIsLeader;
    private Integer empProjectIsLeader;
    private Integer empDepIsLeader;
    private String token;
    private String cityCode;
    private String cityName;

    public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Long getEmpAutoId() {
        return empAutoId;
    }

    public void setEmpAutoId(Long empAutoId) {
        this.empAutoId = empAutoId;
    }

    public String getEmpGuid() {
        return empGuid;
    }

    public void setEmpGuid(String empGuid) {
        this.empGuid = empGuid;
    }

    public String getEmpComGuid() {
        return empComGuid;
    }

    public void setEmpComGuid(String empComGuid) {
        this.empComGuid = empComGuid;
    }

    public String getEmpLoginName() {
        return empLoginName;
    }

    public void setEmpLoginName(String empLoginName) {
        this.empLoginName = empLoginName;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpSex() {
        return empSex;
    }

    public void setEmpSex(String empSex) {
        this.empSex = empSex;
    }

    public String getEmpMobile() {
        return empMobile;
    }

    public void setEmpMobile(String empMobile) {
        this.empMobile = empMobile;
    }

    public Integer getEmpState() {
        return empState;
    }

    public void setEmpState(Integer empState) {
        this.empState = empState;
    }

    public String getEmpFaceImgUrl() {
        return empFaceImgUrl;
    }

    public void setEmpFaceImgUrl(String empFaceImgUrl) {
        this.empFaceImgUrl = empFaceImgUrl;
    }

    public String getEmpComName() {
        return empComName;
    }

    public void setEmpComName(String empComName) {
        this.empComName = empComName;
    }

    public String getEmpProjectGuid() {
        return empProjectGuid;
    }

    public void setEmpProjectGuid(String empProjectGuid) {
        this.empProjectGuid = empProjectGuid;
    }

    public String getEmpProjectName() {
        return empProjectName;
    }

    public void setEmpProjectName(String empProjectName) {
        this.empProjectName = empProjectName;
    }

    public String getEmpDepName() {
        return empDepName;
    }

    public void setEmpDepName(String empDepName) {
        this.empDepName = empDepName;
    }

    public Integer getEmpComIsLeader() {
        return empComIsLeader;
    }

    public void setEmpComIsLeader(Integer empComIsLeader) {
        this.empComIsLeader = empComIsLeader;
    }

    public Integer getEmpProjectIsLeader() {
        return empProjectIsLeader;
    }

    public void setEmpProjectIsLeader(Integer empProjectIsLeader) {
        this.empProjectIsLeader = empProjectIsLeader;
    }

    public Integer getEmpDepIsLeader() {
        return empDepIsLeader;
    }

    public void setEmpDepIsLeader(Integer empDepIsLeader) {
        this.empDepIsLeader = empDepIsLeader;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "EmpBean{" +
                "empAutoId=" + empAutoId +
                ", empGuid='" + empGuid + '\'' +
                ", empComGuid='" + empComGuid + '\'' +
                ", empLoginName='" + empLoginName + '\'' +
                ", empName='" + empName + '\'' +
                ", empEmail='" + empEmail + '\'' +
                ", empSex='" + empSex + '\'' +
                ", empMobile='" + empMobile + '\'' +
                ", empState=" + empState +
                ", empFaceImgUrl='" + empFaceImgUrl + '\'' +
                ", empComName='" + empComName + '\'' +
                ", empProjectGuid='" + empProjectGuid + '\'' +
                ", empProjectName='" + empProjectName + '\'' +
                ", empDepName='" + empDepName + '\'' +
                ", empComIsLeader=" + empComIsLeader +
                ", empProjectIsLeader=" + empProjectIsLeader +
                ", empDepIsLeader=" + empDepIsLeader +
                ", token='" + token + '\'' +
                '}';
    }
}
