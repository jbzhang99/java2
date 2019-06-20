package com.rfchina.community.component.mobike;


/**
 */
public class UnlockBikeResponse extends AbstractMobikeResponse {

    private String h5Url;

    private String bikeid;

    private String orderid;

    public String getH5Url() {
        return h5Url;
    }

    public void setH5Url(String h5Url) {
        this.h5Url = h5Url;
    }

    public String getBikeid() {
        return bikeid;
    }

    public void setBikeid(String bikeid) {
        this.bikeid = bikeid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }
}
