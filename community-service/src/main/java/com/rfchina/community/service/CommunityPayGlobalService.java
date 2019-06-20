package com.rfchina.community.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.persistence.mapper.CommunityPayMapper;
import com.rfchina.community.persistence.model.CommunityPay;

@Service
public class CommunityPayGlobalService {
	
	@Autowired
	private CommunityPayMapper communityPayMapper;

	public CommunityPay getCommunityPay(int communityId){
		return communityPayMapper.selectByPrimaryKey(communityId);
	}
}
