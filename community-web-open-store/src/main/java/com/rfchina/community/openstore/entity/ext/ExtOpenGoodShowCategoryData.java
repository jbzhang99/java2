package com.rfchina.community.openstore.entity.ext;

import com.rfchina.community.persistence.model.OpenGoodShowCategory;

import java.util.List;

public class ExtOpenGoodShowCategoryData extends OpenGoodShowCategory{
    private List<ExtOpenStoreGood> goodList;

    public List<ExtOpenStoreGood> getGoodList() {
        return goodList;
    }

    public void setGoodList(List<ExtOpenStoreGood> goodList) {
        this.goodList = goodList;
    }
}
