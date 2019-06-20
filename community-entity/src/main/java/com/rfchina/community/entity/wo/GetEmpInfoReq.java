package com.rfchina.community.entity.wo;

import java.io.Serializable;
import java.util.List;

public class GetEmpInfoReq implements Serializable {

    private String mobile;

    private List<String> empGuids;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public List<String> getEmpGuids() {
        return empGuids;
    }

    public void setEmpGuids(List<String> empGuids) {
        this.empGuids = empGuids;
    }

    @Override
    public String toString() {
        return "GetEmpInfoReq{" +
                "mobile='" + mobile + '\'' +
                ", empGuids=" + empGuids +
                '}';
    }
}
