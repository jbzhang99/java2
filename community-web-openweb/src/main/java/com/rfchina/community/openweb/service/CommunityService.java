package com.rfchina.community.openweb.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.base.Constant;
import com.rfchina.community.openweb.mapper.ext.ExtCommunityMapper;
import com.rfchina.community.persistence.mapper.CommunityMapper;
import com.rfchina.community.persistence.model.Community;
import com.rfchina.community.persistence.model.CommunityExample;

@Service
public class CommunityService {

	@Autowired
	private ExtCommunityMapper extCommunityMapper;
	@Autowired
	private CommunityMapper communityMapper;
	
	private static Logger logger = LoggerFactory.getLogger(CommunityService.class);
	
	
	public List<Map<String, Object>> searchCityByCommuntiy() {
		return extCommunityMapper.searchCityByCommuntiy();
	}
	
	public PageList<Community> getCommunityList(int areaId , int index , int size){
		CommunityExample example = new CommunityExample();
		
		example.createCriteria().andAreaIdEqualTo(areaId);
		
		PageBounds pageBounds = new PageBounds(index, size);
		
		return extCommunityMapper.pageByExample(example, pageBounds);
	}
	
	
	public List<Community> getCommunityList(){
		
		CommunityExample example = new CommunityExample();
		
		example.createCriteria().andStatusEqualTo(1).andCityIdIsNotNull().andCategoryEqualTo(Constant.CommunityCategory.ENTITY);
		
		return communityMapper.selectByExample(example);
	}
	
	
	public Community getCommunity(int id){
		return communityMapper.selectByPrimaryKey(id);
	}

	
	public List<Map<String, Object>> searchCityByFee(Integer userId) {
		return extCommunityMapper.searchCityByFee(userId);
	}

	public List<Map<String, Object>> getCommunityListByfee(int serviceId, int areaId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("serviceId", serviceId);
		map.put("areaId", areaId);
		return extCommunityMapper.getCommunityListByfee(map);
	}


}
