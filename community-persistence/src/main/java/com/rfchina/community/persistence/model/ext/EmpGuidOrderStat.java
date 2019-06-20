package com.rfchina.community.persistence.model.ext;

import java.math.BigDecimal;

public class EmpGuidOrderStat {
    private String empGuid;
    private BigDecimal empTotal;
    private int empCount;

    public String getEmpGuid() {
        return empGuid;
    }

    public void setEmpGuid(String empGuid) {
        this.empGuid = empGuid;
    }

    public BigDecimal getEmpTotal() {
        return empTotal;
    }

    public void setEmpTotal(BigDecimal empTotal) {
        this.empTotal = empTotal;
    }

    public int getEmpCount() {
        return empCount;
    }

    public void setEmpCount(int empCount) {
        this.empCount = empCount;
    }
}
