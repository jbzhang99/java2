package com.rfchina.community.open.bridge.service;

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
	
	public List<OpenServiceInterface> getServiceInterfaceList(int serviceId , int status){
		OpenServiceInterfaceExample example = new OpenServiceInterfaceExample();
		example.createCriteria().andServiceIdEqualTo(serviceId).andStatusEqualTo(status);
		
		return openServiceInterfaceMapper.selectByExample(example);
	}
	
	
	public OpenServiceInterface getServiceInterface(int id){
		return openServiceInterfaceMapper.selectByPrimaryKey(id);
	}
	
	
	public void updateServiceInterface(OpenServiceInterface openServiceInterface){
		openServiceInterfaceMapper.updateByPrimaryKeySelective(openServiceInterface);
	}
}
