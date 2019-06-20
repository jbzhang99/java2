package com.rfchina.community.open.bridge.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.persistence.mapper.OpenXfsjSignUpInfoMapper;
import com.rfchina.community.persistence.model.OpenXfsjSignUpInfoExample;

@Service
public class OpenXFSJSignUpInfoService extends BaseService {
	@Autowired
	private OpenXfsjSignUpInfoMapper openXfsjSignUpInfoMapper;
	
	/**
	 * 根据报名状态获取该小富市集的数量
	 */
	public long getSignUpNumByStatus(Long xfsjId, int status) {
		OpenXfsjSignUpInfoExample example = new OpenXfsjSignUpInfoExample();
		example.createCriteria().andXfsjIdEqualTo(xfsjId).andStatusEqualTo(status);
		return openXfsjSignUpInfoMapper.countByExample(example);
	}
	
	/**
	 * 已报名数量,审核通过才报名称，才算报名数量
	 */
	public long getSignUpNum(Long xfsjId) {
		List<Integer> statusList = new ArrayList<>();
		statusList.add(OpenConstant.SignUpCheckStatus.PASS);
		statusList.add(OpenConstant.SignUpCheckStatus.PAID);
		OpenXfsjSignUpInfoExample example = new OpenXfsjSignUpInfoExample();
		example.createCriteria().andXfsjIdEqualTo(xfsjId).andStatusIn(statusList);
		return openXfsjSignUpInfoMapper.countByExample(example);
	}

}
