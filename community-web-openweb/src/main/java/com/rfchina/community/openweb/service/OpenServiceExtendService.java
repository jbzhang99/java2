package com.rfchina.community.openweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.persistence.mapper.OpenServiceExtendTempMapper;
import com.rfchina.community.persistence.model.OpenServiceExtendTemp;
/**
 * @author:fukangwen
 * @Description: 服务关键词设置
 */
@Service
public class OpenServiceExtendService {

	@Autowired
	private OpenServiceExtendTempMapper openServiceExtendTempMapper;
	
	/**
	 * @author:fukangwen
	 * @Description: 设置审核关键字
	 * @return void
	 * @throws
	 */
	public void setKeywordToAudit(int serviceId, String keyword) {
		OpenServiceExtendTemp openServiceExtendTemp = openServiceExtendTempMapper.selectByPrimaryKey(serviceId);
		if(openServiceExtendTemp == null) {
			OpenServiceExtendTemp domain = new OpenServiceExtendTemp();
			domain.setId(serviceId);
			domain.setKeyword(keyword);
			openServiceExtendTempMapper.insert(domain);
			return;
		}
		
		//更新
		openServiceExtendTemp.setKeyword(keyword);
		openServiceExtendTempMapper.updateByPrimaryKeySelective(openServiceExtendTemp);
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 获取关键词
	 * @return String
	 * @throws
	 */
	public String getKeyword(int serviceId) {
		OpenServiceExtendTemp openServiceExtendTemp = openServiceExtendTempMapper.selectByPrimaryKey(serviceId);
		if(openServiceExtendTemp == null) 
			return "";
		return openServiceExtendTemp.getKeyword();
	}
	
}
