package com.rfchina.community.openapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.persistence.mapper.CommunityServiceMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceTempMapper;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.CommunityServiceExample;
import com.rfchina.community.persistence.model.CommunityServiceTemp;
import com.rfchina.community.persistence.model.CommunityServiceTempExample;

@Service
public class CommunityServiceService {

	
	@Autowired
	private CommunityServiceTempMapper communityServiceTempMapper;
	
	@Autowired
	private CommunityServiceMapper communityServiceMapper;
	
	public List<CommunityServiceTemp> getCommunityServiceTempList(Long merchantId){
		CommunityServiceTempExample example = new CommunityServiceTempExample();
		example.createCriteria().andMerchantIdEqualTo(merchantId);
		return communityServiceTempMapper.selectByExample(example);
	}
	
	public void addCommunityServiceTemp(CommunityServiceTemp communityServiceTemp){
		communityServiceTempMapper.insertSelective(communityServiceTemp);
	}
	
	public CommunityServiceTemp getCommunityServiceTempByPrimaryKey(int serviceId){
		return communityServiceTempMapper.selectByPrimaryKey(serviceId);
	}
	
	
	public void updateCommunityServiceTemp(CommunityServiceTemp communityServiceTemp){
		communityServiceTempMapper.updateByPrimaryKeySelective(communityServiceTemp);
	}
	
	
	public CommunityService getCommunityServiceByPrimaryKey(int serviceId){
		return communityServiceMapper.selectByPrimaryKey(serviceId);
	}
	
	
	public void addCommunityService(CommunityService communityService){
		communityServiceMapper.insertSelective(communityService);
	}
	
	public void updateCommunityService(CommunityService communityService){
		communityServiceMapper.updateByPrimaryKeySelective(communityService);
	}
	
	
	
}
