package com.rfchina.community.open.bridge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.persistence.mapper.OpenServiceExtendMapper;
import com.rfchina.community.persistence.mapper.OpenServiceExtendTempMapper;
import com.rfchina.community.persistence.model.OpenServiceExtend;
import com.rfchina.community.persistence.model.OpenServiceExtendTemp;

/**
 * @author:fukangwen
 * @Description: 服务关键词设置
 */
@Service
public class OpenServiceExtendService {

	@Autowired
	private OpenServiceExtendTempMapper openServiceExtendTempMapper;
	@Autowired
	private OpenServiceExtendMapper openServiceExtendMapper;

	/**
	 * @author:fukangwen @Description: 设置审核关键字 @return void @throws
	 */
	public void passKeyword(int serviceId) {
		OpenServiceExtendTemp openServiceExtendTemp = openServiceExtendTempMapper.selectByPrimaryKey(serviceId);
		if (openServiceExtendTemp == null)
			return;
		OpenServiceExtend openServiceExtend = openServiceExtendMapper.selectByPrimaryKey(serviceId);
		if (openServiceExtend == null) {
			OpenServiceExtend domain = new OpenServiceExtend();
			domain.setId(serviceId);
			domain.setKeyword(openServiceExtendTemp.getKeyword());
			openServiceExtendMapper.insert(domain);
			return;
		}

		// 更新
		openServiceExtend.setKeyword(openServiceExtendTemp.getKeyword());
		openServiceExtendMapper.updateByPrimaryKeySelective(openServiceExtend);
	}

}
