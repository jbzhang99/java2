package com.rfchina.community.openweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.persistence.mapper.MasterChildMapper;
import com.rfchina.community.persistence.model.MasterChild;
import com.rfchina.community.persistence.model.MasterChildExample;

@Service
public class MasterChildService {

	@Autowired
	private MasterChildMapper masterChildMapper;
	
	
	public void addMasterChild(MasterChild masterChild){
		masterChildMapper.insertSelective(masterChild);
	}
	
	public MasterChild getMasterChild(int communityId , long masterId , String phone){
		MasterChildExample example = new MasterChildExample();
		example.createCriteria().andCommunityIdEqualTo(communityId).andMasterIdEqualTo(masterId).andPhoneEqualTo(phone);
		List<MasterChild> list = masterChildMapper.selectByExample(example);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		
		return null;
	}
}
