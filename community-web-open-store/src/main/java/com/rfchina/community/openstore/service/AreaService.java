package com.rfchina.community.openstore.service;

import com.rfchina.community.persistence.mapper.ext.ExtAreaMapper;
import com.rfchina.community.persistence.model.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaService {

	@Autowired
	private ExtAreaMapper areaMapper;

	public Area getArea(int id){
		return areaMapper.selectByPrimaryKey(id);
	}
}
