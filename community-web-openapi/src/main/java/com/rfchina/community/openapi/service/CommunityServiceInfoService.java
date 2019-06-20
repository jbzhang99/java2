package com.rfchina.community.openapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.persistence.mapper.CommunityServiceMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceTempMapper;
import com.rfchina.community.persistence.mapper.OpenMerchantInfoMapper;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.CommunityServiceExample;
import com.rfchina.community.persistence.model.CommunityServiceTemp;
import com.rfchina.community.persistence.model.CommunityServiceTempExample;
import com.rfchina.community.persistence.model.OpenMerchantInfo;

@Service
public class CommunityServiceInfoService extends BaseService {

	@Autowired
	private CommunityServiceTempMapper communityServiceTempMapper;

	@Autowired
	private OpenMerchantInfoMapper openMerchantInfoMapper;

	public CommunityServiceTemp getCommunityServiceTemp(Long appId) {
		// 服务是否为正式服务
		CommunityServiceTempExample example = new CommunityServiceTempExample();
		example.createCriteria().andAppIdEqualTo(appId);
		List<CommunityServiceTemp> list = communityServiceTempMapper.selectByExample(example);
		validator(list.isEmpty(), "app_id 不存在," + appId);
		validator(list.size() != 1, "app_id 对应多个服务,请联系系统管理员," + appId);
		return list.get(0);
	}

	public OpenMerchantInfo getOpenMerchantInfo(Long mid, Long appId) {
		// 查询服务商信息
		OpenMerchantInfo openMerchantInfo = openMerchantInfoMapper.selectByPrimaryKey(mid);
		validator(openMerchantInfo == null, "app_id：" + appId + "对应的服务商信息不存在");
		validator(openMerchantInfo.getStatus() != 1, "app_id：" + appId + "对应的服务商信息已经禁用");
		return openMerchantInfo;
	}

}
