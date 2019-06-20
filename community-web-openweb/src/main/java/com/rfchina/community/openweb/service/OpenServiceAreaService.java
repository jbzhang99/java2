package com.rfchina.community.openweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.persistence.mapper.OpenServiceAreaMapper;
import com.rfchina.community.persistence.model.OpenServiceArea;
import com.rfchina.community.persistence.model.OpenServiceAreaExample;

@Service
public class OpenServiceAreaService {

	@Autowired
	private OpenServiceAreaMapper openServiceAreaMapper;
	
	public void addOpenServiceArea(OpenServiceArea openServiceArea){
		openServiceAreaMapper.insertSelective(openServiceArea);
	}
	
	
	public List<OpenServiceArea> getOpenServiceAreaList(int serviceId){
		OpenServiceAreaExample example = new OpenServiceAreaExample();
		example.createCriteria().andServiceIdEqualTo(serviceId);
		
		return openServiceAreaMapper.selectByExample(example);
	}
	
	
	public OpenServiceArea getOpenServiceArea(int serviceId , int areaId){
		OpenServiceAreaExample example = new OpenServiceAreaExample();
		example.createCriteria().andServiceIdEqualTo(serviceId).andAreaIdEqualTo(areaId);
		
		List<OpenServiceArea> list = openServiceAreaMapper.selectByExample(example);
		
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}


	public void deleteServiceArea(int serviceId) {
		OpenServiceAreaExample example = new OpenServiceAreaExample();
		example.createCriteria().andServiceIdEqualTo(serviceId);
		openServiceAreaMapper.deleteByExample(example);
	}
}
