package com.rfchina.community.component.mobike;

import java.util.List;

/**
 */
public class GetOpenCityListResponse extends AbstractMobikeResponse {

    private List<OpenCityObject> cityCode;

    public List<OpenCityObject> getCityCode() {
        return cityCode;
    }

    public void setCityCode(List<OpenCityObject> cityCode) {
        this.cityCode = cityCode;
    }
}
