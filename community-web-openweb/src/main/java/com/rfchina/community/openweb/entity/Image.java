package com.rfchina.community.openweb.entity;

import java.io.Serializable;

/**
 */
public class Image implements Serializable {

    private String imgUrl = "";

    private String link = "";

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
