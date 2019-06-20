package com.rfchina.community.openapi.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.persistence.mapper.OpenConfMapper;
import com.rfchina.community.persistence.model.OpenConf;
import com.rfchina.community.persistence.model.OpenConfExample;

/**
 * @author:fukangwen
 * @Description: 配置开关service
 */
@Service
public class OpenConfService {
	
	@Autowired
	private OpenConfMapper openConfMapper;
	
	public static int CODE_VALID = 1;//有效 
	public static int CODE_INVALID = 0;//无效 
	
	/**
	 * @author:fukangwen
	 * @Description: 获取开关状态，
	 * @return Boolean
	 * @throws
	 */
	public Boolean getCodeByType(String type) {
		OpenConfExample example = new OpenConfExample();
		example.createCriteria().andTypeEqualTo(type);
		List<OpenConf> list = openConfMapper.selectByExample(example);
		if(list.isEmpty())
			return false;//默认关闭
		if(Integer.parseInt(list.get(0).getCode()) == CODE_VALID)
			return true;
		
		return false;
	}
	
	public enum Type{
		POINT,FIRST_POINT;
	}
	
}
