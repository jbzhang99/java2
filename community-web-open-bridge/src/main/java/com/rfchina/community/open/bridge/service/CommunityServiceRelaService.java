package com.rfchina.community.open.bridge.service;

import com.rfchina.community.base.Constant;
import com.rfchina.community.open.bridge.mapper.ext.ExtCommunityServiceRelaMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceRelaTempMapper;
import com.rfchina.community.persistence.model.CommunityServiceRela;
import com.rfchina.community.persistence.model.CommunityServiceRelaTemp;
import com.rfchina.community.persistence.model.CommunityServiceRelaTempExample;
import com.rfchina.community.persistence.model.ext.ExtCommunityServiceRela;
import com.rfchina.community.service.openser.CommunityServiceRelaBaseService;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommunityServiceRelaService extends CommunityServiceRelaBaseService {

	@Autowired
	private CommunityServiceRelaTempMapper communityServiceRelaTempMapper;
	@Autowired
	private ExtCommunityServiceRelaMapper extCommunityServiceRelaMapper;


	public CommunityServiceRelaTemp getCommunityServiceRelaTemp(int serviceId , int communityId){
		CommunityServiceRelaTempExample example = new CommunityServiceRelaTempExample();
		example.createCriteria().andServiceIdEqualTo(serviceId).andCommunityIdEqualTo(communityId);
		List<CommunityServiceRelaTemp> list = communityServiceRelaTempMapper.selectByExample(example);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
		
	}
	
	
	
	public void updateCommunityServiceRela(CommunityServiceRela communityServiceRela){
		updateByPrimaryKeySelective(communityServiceRela);
	}

	public void insert(Integer serviceId, Integer communityId, String contactsName, 
			String contactsPhone, String contactsEmail) {
		CommunityServiceRelaTemp communityServiceRelaTemp = new CommunityServiceRelaTemp();
		communityServiceRelaTemp.setServiceId(serviceId);
		communityServiceRelaTemp.setCommunityId(communityId);
		communityServiceRelaTemp.setCreateTime(new Date());
		communityServiceRelaTemp.setAuditStatus(Constant.OpenAdmin.CommunityServiceRelaAuditStatus.AUDIT_PASS);
		communityServiceRelaTemp.setStatus(Constant.OpenAdmin.CommunityServiceRelaStatus.ENABLE);
		communityServiceRelaTemp.setServiceContactsName(contactsName);
		communityServiceRelaTemp.setServiceContactsPhone(contactsPhone);
		communityServiceRelaTemp.setServiceContactsEmail(contactsEmail);
		communityServiceRelaTemp.setReorder(99);
		communityServiceRelaTemp.setSelectStatus(Constant.OpenAdmin.CommunityServiceRelaSelectStatus.ENABLE);
		communityServiceRelaTemp.setGroundTime(communityServiceRelaTemp.getCreateTime());
		this.addCommunityServiceRelaTemp(communityServiceRelaTemp);
		CommunityServiceRela communityServiceRela = new CommunityServiceRela();
		BeanUtils.copyProperties(communityServiceRelaTemp, communityServiceRela);
		this.addCommunityServiceRela(communityServiceRela);
	}

	private void addCommunityServiceRela(CommunityServiceRela communityServiceRela) {
		insertSelective(communityServiceRela);
	}

	private void addCommunityServiceRelaTemp(CommunityServiceRelaTemp communityServiceRelaTemp) {
		CommunityServiceRelaTemp temp = this.getCommunityServiceRelaTemp(communityServiceRelaTemp.getServiceId(), communityServiceRelaTemp.getCommunityId());
		if(temp == null) {
			communityServiceRelaTempMapper.insertSelective(communityServiceRelaTemp);
			return;
		}
		communityServiceRelaTempMapper.updateByPrimaryKeySelective(communityServiceRelaTemp);
	}

	public PageList<ExtCommunityServiceRela> getCommunityServiceRelaTempList(int serviceId, int index, int size) {

		PageBounds pageBounds = new PageBounds(index, size);

		return extCommunityServiceRelaMapper.getCommunityServiceRelaTempList(serviceId, pageBounds);
	}
}
