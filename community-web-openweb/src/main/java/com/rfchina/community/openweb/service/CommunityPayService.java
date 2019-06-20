package com.rfchina.community.openweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.persistence.mapper.CommunityPayMapper;
import com.rfchina.community.persistence.model.CommunityPay;

@Service
public class CommunityPayService {
	
	@Autowired
	private CommunityPayMapper communityPayMapper;

	public CommunityPay getCommunityPay(int communityId){
		return communityPayMapper.selectByPrimaryKey(communityId);
	}
}
