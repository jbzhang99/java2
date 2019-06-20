package com.rfchina.community.openapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.persistence.mapper.CommunityMapper;
import com.rfchina.community.persistence.model.Community;

@Service
public class CommunityService {

	@Autowired
	private CommunityMapper communityMapper;
	
	public Community getCommunity(int id){
		return communityMapper.selectByPrimaryKey(id);
	}
}
