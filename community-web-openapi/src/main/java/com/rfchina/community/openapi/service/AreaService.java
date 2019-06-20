package com.rfchina.community.openapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.persistence.mapper.AreaMapper;
import com.rfchina.community.persistence.model.Area;

@Service
public class AreaService {

	@Autowired
	private AreaMapper areaMapper;
	
	public Area getArea(int id){
		return areaMapper.selectByPrimaryKey(id);
	}
}
