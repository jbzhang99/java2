package com.rfchina.community.openweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.persistence.mapper.CommunityServiceCountMapper;
import com.rfchina.community.persistence.model.CommunityServiceCount;

@Service
public class CommunityServiceCountService {

	@Autowired
	private CommunityServiceCountMapper communityServiceCountMapper;
	
	public CommunityServiceCount getCommunityServiceCount(int serviceId){
		return communityServiceCountMapper.selectByPrimaryKey(serviceId);
	}
}
