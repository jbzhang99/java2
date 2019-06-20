package com.rfchina.community.entity.wo;

import java.io.Serializable;
import java.util.List;

/**
 */
public class DoorCardTransactReq implements Serializable {

    private String orderNo;

    private String projectGuid;

    private String addr;

    private String contact;

    private String contactTel;

    private String contactIdentity;

    private List<WaitingBean> waitingList;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getProjectGuid() {
        return projectGuid;
    }

    public void setProjectGuid(String projectGuid) {
        this.projectGuid = projectGuid;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    public String getContactIdentity() {
        return contactIdentity;
    }

    public void setContactIdentity(String contactIdentity) {
        this.contactIdentity = contactIdentity;
    }

    public List<WaitingBean> getWaitingList() {
        return waitingList;
    }

    public void setWaitingList(List<WaitingBean> waitingList) {
        this.waitingList = waitingList;
    }

    @Override
    public String toString() {
        return "DoorCardTransactReq{" +
                "orderNo='" + orderNo + '\'' +
                ", projectGuid='" + projectGuid + '\'' +
                ", addr='" + addr + '\'' +
                ", contact='" + contact + '\'' +
                ", contactTel='" + contactTel + '\'' +
                ", contactIdentity='" + contactIdentity + '\'' +
                ", waitingList=" + waitingList +
                '}';
    }
}
