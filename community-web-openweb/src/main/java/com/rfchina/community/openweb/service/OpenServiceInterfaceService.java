package com.rfchina.community.openweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.persistence.mapper.OpenServiceInterfaceMapper;
import com.rfchina.community.persistence.model.OpenServiceInterface;
import com.rfchina.community.persistence.model.OpenServiceInterfaceExample;

@Service
public class OpenServiceInterfaceService {

	@Autowired
	private OpenServiceInterfaceMapper openServiceInterfaceMapper;
	
	public void addServiceInterface(OpenServiceInterface openServiceInterface){
		openServiceInterfaceMapper.insertSelective(openServiceInterface);
	}
	
	
	
	public OpenServiceInterface getServiceInterface(int serviceId , int interfaceId){
		OpenServiceInterfaceExample example = new OpenServiceInterfaceExample();
		example.createCriteria().andServiceIdEqualTo(serviceId).andInterfaceIdEqualTo(interfaceId);
		
		List<OpenServiceInterface> list = openServiceInterfaceMapper.selectByExample(example);
		
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		
		return null;
	}
	
	
	public void updateServiceInterface(OpenServiceInterface openServiceInterface){
		openServiceInterfaceMapper.updateByPrimaryKeySelective(openServiceInterface);
	}
	
}
