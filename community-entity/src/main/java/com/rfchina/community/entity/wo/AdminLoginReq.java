package com.rfchina.community.entity.wo;

import java.io.Serializable;

public class AdminLoginReq implements Serializable {

    private String userName;

    private String userPwd;

    private String empGuid;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getEmpGuid() {
        return empGuid;
    }

    public void setEmpGuid(String empGuid) {
        this.empGuid = empGuid;
    }

    @Override
    public String toString() {
        return "AdminLoginReq{" +
                "userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", empGuid='" + empGuid + '\'' +
                '}';
    }
}
