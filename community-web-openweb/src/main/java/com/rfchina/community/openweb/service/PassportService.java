package com.rfchina.community.openweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.base.Constant;
import com.rfchina.community.persistence.mapper.PassportMapper;
import com.rfchina.community.persistence.model.PassportExample;

/**
 * @author:fukangwen
 * @Description: 账户service
 */
@Service
public class PassportService {

	@Autowired
	private PassportMapper passportMapper;
	
	/**
	 * @author:fukangwen
	 * @Description: 判断用户是否存在
	 * @return Boolean
	 * @throws
	 */
	public Boolean isExist(String userName) {
		PassportExample example = new PassportExample();
		example.createCriteria().andUsernameEqualTo(userName).andAppIdEqualTo(Constant.App.Id.OPEN_MERCHANT.value());
		long count = passportMapper.countByExample(example);
		if(count > 0)
			return true;
		return false;
	}
}
