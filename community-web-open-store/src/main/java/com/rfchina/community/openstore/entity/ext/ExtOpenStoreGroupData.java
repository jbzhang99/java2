package com.rfchina.community.openstore.entity.ext;

import com.rfchina.community.persistence.model.OpenStoreGroupData;

import java.math.BigDecimal;

public class ExtOpenStoreGroupData extends OpenStoreGroupData {

    private Long duration;

    private String pic;

    private String userName;

    private BigDecimal groupPrice;

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public BigDecimal getGroupPrice() {
        return groupPrice;
    }

    public void setGroupPrice(BigDecimal groupPrice) {
        this.groupPrice = groupPrice;
    }
}