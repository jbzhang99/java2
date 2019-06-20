package com.rfchina.community.openapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.persistence.mapper.CommunityServiceRelaMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceRelaTempMapper;
import com.rfchina.community.persistence.model.CommunityServiceRela;
import com.rfchina.community.persistence.model.CommunityServiceRelaExample;
import com.rfchina.community.persistence.model.CommunityServiceRelaTemp;
import com.rfchina.community.persistence.model.CommunityServiceRelaTempExample;

@Service
public class CommunityServiceRelaService {

	
	@Autowired
	private CommunityServiceRelaTempMapper communityServiceRelaTempMapper;
	
	@Autowired
	private CommunityServiceRelaMapper communityServiceRelaMapper;
	
	public void addCommunityServiceRelaTemp(CommunityServiceRelaTemp communityServiceRelaTemp){
		communityServiceRelaTempMapper.insertSelective(communityServiceRelaTemp);
	}
	
	
	public List<CommunityServiceRelaTemp> getCommunityServiceRelaTempList(int serviceId){
		CommunityServiceRelaTempExample example = new CommunityServiceRelaTempExample();
		example.createCriteria().andServiceIdEqualTo(serviceId);
		return communityServiceRelaTempMapper.selectByExample(example);
	} 
	
	
	public void updateCommunityServiceRelaTemp(CommunityServiceRelaTemp communityServiceRelaTemp){
		communityServiceRelaTempMapper.updateByPrimaryKeySelective(communityServiceRelaTemp);
	}
	
	
	public void deleteCommunityServiceRela(int serviceId){
		CommunityServiceRelaExample example = new CommunityServiceRelaExample();
		example.createCriteria().andServiceIdEqualTo(serviceId);
		communityServiceRelaMapper.deleteByExample(example);
	}
	
	
	public void addCommunityServiceRela(CommunityServiceRela communityServiceRela){
		communityServiceRelaMapper.insertSelective(communityServiceRela);
	}
	
}
