package com.rfchina.community.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.persistence.mapper.UserInfoMapper;
import com.rfchina.community.persistence.model.UserInfo;
import com.rfchina.community.persistence.model.UserInfoExample;

@Service
public class UserInfoSerService extends BaseService {

	@Autowired
	private UserInfoMapper userInfoMapper;

	public UserInfo getUserInfo(Long uid) {
		return userInfoMapper.selectByPrimaryKey(uid);
	}

	public Long userInfoByPhone(String phone) {
		if (StringUtils.isBlank(phone))
			return 0L;
		UserInfoExample example = new UserInfoExample();
		example.createCriteria().andPhoneEqualTo(phone);
		List<UserInfo> list = userInfoMapper.selectByExample(example);
		if (!list.isEmpty()) {
			for (UserInfo userInfo : list) {
				return userInfo.getId();
			}
		}
		return 0L;

	}

}
