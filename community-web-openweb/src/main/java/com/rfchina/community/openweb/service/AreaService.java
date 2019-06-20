package com.rfchina.community.openweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.persistence.mapper.AreaMapper;
import com.rfchina.community.persistence.model.Area;

@Service
public class AreaService extends BaseService{

	@Autowired
	private AreaMapper areaMapper;
	
	public Area getArea(int id){
		return areaMapper.selectByPrimaryKey(id);
	}
	
	public void checkArea(Integer provinceAreaId, Integer cityAreaId, Integer areaId) {
		Area province = areaMapper.selectByPrimaryKey(provinceAreaId);
		validator(province == null, "该省不存在!");
		Area city = areaMapper.selectByPrimaryKey(cityAreaId);
		validator(city == null, "该城市不存在!");
		validator(city.getParentId().intValue() != provinceAreaId,
				"选择错误数据," + province.getName() + "下面没有" + city.getName());
		Area area = areaMapper.selectByPrimaryKey(areaId);
		validator(area == null, "该区不存在!");
		validator(area.getParentId().intValue() != cityAreaId, "选择错误数据," + city.getName() + "下面没有" + area.getName());
	}
}
