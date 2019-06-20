package com.rfchina.community.persistence.model.ext;

import com.rfchina.community.persistence.model.BizApplyOrder;

import java.util.Date;
import java.util.List;

/**
 */
public class BizApplyOrderExt extends BizApplyOrder {

    private List<BizApplyOrderApplicant> applicantList;

    private Date billExpireTime;

    public List<BizApplyOrderApplicant> getApplicantList() {
        return applicantList;
    }

    public void setApplicantList(List<BizApplyOrderApplicant> applicantList) {
        this.applicantList = applicantList;
    }

    public Date getBillExpireTime() {
        return billExpireTime;
    }

    public void setBillExpireTime(Date billExpireTime) {
        this.billExpireTime = billExpireTime;
    }
}
