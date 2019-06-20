package com.rfchina.community.openweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.persistence.mapper.OpenDebugUserMapper;
import com.rfchina.community.persistence.model.OpenDebugUser;
import com.rfchina.community.persistence.model.OpenDebugUserExample;

@Service
public class OpenDebugUserService {

	@Autowired
	private OpenDebugUserMapper openDebugUserMapper;

	public void addOpenDebugUser(OpenDebugUser openDebugUser) {
		openDebugUserMapper.insertSelective(openDebugUser);
	}

	public OpenDebugUser getOpenDebugUser(Integer id) {
		return openDebugUserMapper.selectByPrimaryKey(id);
	}

	public void deleteOpenDebugUser(int id) {
		openDebugUserMapper.deleteByPrimaryKey(id);
	}

	public long getOpenDebugUserCount(int serviceId) {
		OpenDebugUserExample example = new OpenDebugUserExample();

		example.createCriteria().andServiceIdEqualTo(serviceId);

		return openDebugUserMapper.countByExample(example);
	}

	public List<OpenDebugUser> getOpenDebugUserList(int serviceId, Long mid) {
		OpenDebugUserExample example = new OpenDebugUserExample();

		example.createCriteria().andServiceIdEqualTo(serviceId).andMerchantIdEqualTo(mid);

		return openDebugUserMapper.selectByExample(example);
	}
	
	public long getOpenDebugUserCount(int serviceId ,String phone){
		OpenDebugUserExample example = new OpenDebugUserExample();

		example.createCriteria().andServiceIdEqualTo(serviceId).andPhoneEqualTo(phone);

		return openDebugUserMapper.countByExample(example);
	}
}
