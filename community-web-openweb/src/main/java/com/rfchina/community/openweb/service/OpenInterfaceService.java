package com.rfchina.community.openweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.persistence.mapper.OpenInterfaceMapper;
import com.rfchina.community.persistence.model.OpenInterface;
import com.rfchina.community.persistence.model.OpenInterfaceExample;

@Service
public class OpenInterfaceService {

	@Autowired
	private OpenInterfaceMapper openInterfaceMapper;
	
	public List<OpenInterface> getOpenServiceList(int status){
		
		OpenInterfaceExample example = new OpenInterfaceExample();
		example.createCriteria().andStatusEqualTo(status);
		
		return openInterfaceMapper.selectByExample(example);
	}
	
}
