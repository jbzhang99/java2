package com.rfchina.community.openweb.entity;

import java.io.Serializable;

/**
 */
public class Video implements Serializable {

    public interface Type {
        String MP4 = "mp4";
    }

    private String imgUrl;

    private String thumbImgUrl;

    private String videoType;

    private String videoUrl;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getThumbImgUrl() {
        return thumbImgUrl;
    }

    public void setThumbImgUrl(String thumbImgUrl) {
        this.thumbImgUrl = thumbImgUrl;
    }

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    @Override
    public String toString() {
        return "Video{" +
                "imgUrl='" + imgUrl + '\'' +
                ", thumbImgUrl='" + thumbImgUrl + '\'' +
                ", videoType='" + videoType + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                '}';
    }
}
