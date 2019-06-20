package com.rfchina.community.openstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.base.Constant;
import com.rfchina.community.entity.communityService.ExtCommunityServiceTemp;
import com.rfchina.community.persistence.mapper.CommunityServiceMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceTempMapper;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.CommunityServiceTemp;
import com.rfchina.community.persistence.model.CommunityServiceTempExample;

@Service
public class CommunityServiceService extends com.rfchina.community.component.CommunityServiceComponent{

	
	@Autowired
	private CommunityServiceTempMapper communityServiceTempMapper;
	
	@Autowired
	private CommunityServiceMapper communityServiceMapper;
	
	public List<ExtCommunityServiceTemp> getCommunityServiceTempList(int merchantId){
		return getCommunityServiceTempList(0, null, null, merchantId, 0, 0, null,null,1, 10);
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
	
	
	public List<CommunityServiceTemp> getCommunityServiceTemp(String title){
		CommunityServiceTempExample example = new CommunityServiceTempExample();
		example.createCriteria().andTitleEqualTo(title);
		
		return communityServiceTempMapper.selectByExample(example);
	}
	
	
	public long getCommunityServiceTempCount(Long merchantId){
		CommunityServiceTempExample example = new CommunityServiceTempExample();
		example.createCriteria().andMerchantIdEqualTo(merchantId).andStatusNotEqualTo(Constant.OpenAdmin.CommunityServiceGroundStatus.DELETE);
		
		return communityServiceTempMapper.countByExample(example);
	}
	
	
	public ExtCommunityServiceTemp getCommunityServiceTempInfo(int serviceId){
		List<ExtCommunityServiceTemp> list = getCommunityServiceTempList(serviceId, null, null, 0, 0, 0, null,null,1, 10);
		
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		
		return null;
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 判断服务是否上架，状态为1时，服务已上架
	 * @return Boolean
	 * @throws
	 */
	public Boolean hadPutOnSale(int serviceId) {
		CommunityService serviceDomain = this.getCommunityServiceByPrimaryKey(serviceId);
		if(serviceDomain == null)
			return false;
		if(serviceDomain.getStatus() == 1)
			return true;
		return false;
	}
	
}
