package com.rfchina.community.persistence.model.ext;

import com.rfchina.community.persistence.model.CommunityAroundPoiType;

public class ExtCommunityAroundPoiType extends CommunityAroundPoiType {

    private String poiType;

    private Integer parentSort;

    public String getPoiType() {
        return poiType;
    }

    public void setPoiType(String poiType) {
        this.poiType = poiType;
    }

    public Integer getParentSort() {
        return parentSort;
    }

    public void setParentSort(Integer parentSort) {
        this.parentSort = parentSort;
    }
}