package com.rfchina.community.entity.wo;


import java.util.List;

public class GetEmpInfoRsp extends WoCommonRsp {

    private List<EmpBean> empBeans;

    public List<EmpBean> getEmpBeans() {
        return empBeans;
    }

    public void setEmpBeans(List<EmpBean> empBeans) {
        this.empBeans = empBeans;
    }

    @Override
    public String toString() {
        return "GetEmpInfoRsp{" +
                "empBeans=" + empBeans +
                '}';
    }
}
