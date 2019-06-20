package com.rfchina.community.entity.wo;

import java.io.Serializable;
import java.util.List;

/**
 */
public class ClientCusTaskAddReq implements Serializable {

    public interface From {
        String CLIENT = "client";
        String BIZ_APPLY = "yewubanli";
    }

    private String orderNo;
    private String projectGuid;
    private String contact;
    private String contactTel;
    private String addr;
    private String msgTypeGuid;
    private String msgTypeName;
    private String msgContent;
    private String from;
    private List<RTaskFile> files;

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

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getMsgTypeGuid() {
        return msgTypeGuid;
    }

    public void setMsgTypeGuid(String msgTypeGuid) {
        this.msgTypeGuid = msgTypeGuid;
    }

    public String getMsgTypeName() {
        return msgTypeName;
    }

    public void setMsgTypeName(String msgTypeName) {
        this.msgTypeName = msgTypeName;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public List<RTaskFile> getFiles() {
        return files;
    }

    public void setFiles(List<RTaskFile> files) {
        this.files = files;
    }

    @Override
    public String toString() {
        return "ClientCusTaskAddReq{" +
                "orderNo='" + orderNo + '\'' +
                ", projectGuid='" + projectGuid + '\'' +
                ", contact='" + contact + '\'' +
                ", contactTel='" + contactTel + '\'' +
                ", addr='" + addr + '\'' +
                ", msgTypeGuid='" + msgTypeGuid + '\'' +
                ", msgTypeName='" + msgTypeName + '\'' +
                ", msgContent='" + msgContent + '\'' +
                ", from='" + from + '\'' +
                ", files=" + files +
                '}';
    }
}
