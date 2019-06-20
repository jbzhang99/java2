package com.rfchina.community.entity.wo;

import java.io.Serializable;
import java.util.List;

/**
 */
public class ClientCusTaskVerifReq implements Serializable {

    private String orderNo;
    private String tskCode;
    private Integer satisfaction;
    private String comments;
    private List<RTaskFile> files;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getTskCode() {
        return tskCode;
    }

    public void setTskCode(String tskCode) {
        this.tskCode = tskCode;
    }

    public Integer getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(Integer satisfaction) {
        this.satisfaction = satisfaction;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public List<RTaskFile> getFiles() {
        return files;
    }

    public void setFiles(List<RTaskFile> files) {
        this.files = files;
    }
}
