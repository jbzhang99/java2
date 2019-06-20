package com.rfchina.community.open.bridge.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.base.Constant;
import com.rfchina.community.open.bridge.entity.KeyValueDomain;
import com.rfchina.community.open.bridge.mapper.ext.ExtCommunityBridgeMapper;
import com.rfchina.community.persistence.mapper.CommunityMapper;
import com.rfchina.community.persistence.model.Community;
import com.rfchina.community.persistence.model.CommunityExample;

@Service
public class CommunityBridgeService {

	@Autowired
	private ExtCommunityBridgeMapper extCommunityMapper;
	@Autowired
	private CommunityMapper communityMapper;

	private static Logger logger = LoggerFactory.getLogger(CommunityBridgeService.class);

	public List<Map<String, Object>> searchCityByCommuntiy() {
		return extCommunityMapper.searchCityByCommuntiy();
	}

	public List<Community> getCommunityList(Integer category) {

		CommunityExample example = new CommunityExample();
		//实体社区
		example.createCriteria().andStatusEqualTo(1).andCategoryEqualTo(category);

		return communityMapper.selectByExample(example);
	}

	public Community getCommunity(int id) {
		return communityMapper.selectByPrimaryKey(id);
	}

	public List<KeyValueDomain> listVirturalCommunity(Integer category) {
		List<Community> list = this.getCommunityList(category);
		List<KeyValueDomain> vList = new ArrayList<>();
		for(Community c : list) {
			KeyValueDomain d = new KeyValueDomain();
			d.setKey(c.getId());
			d.setValue(c.getName());
			vList.add(d);
		}
		return vList;
	}

}
