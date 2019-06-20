package com.rfchina.community.open.bridge.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.base.OpenXFSJConstant;
import com.rfchina.community.persistence.mapper.OpenXFSJGroupConfigMapper;
import com.rfchina.community.persistence.model.OpenXFSJGroupConfig;
import com.rfchina.community.persistence.model.OpenXFSJGroupConfigExample;

/**
 * @author:fukangwen
 * @Description: 集团主题配置
 */
@Service
public class OpenXFSJGroupConfigService extends BaseService {
	@Autowired
	private OpenXFSJGroupConfigMapper openXFSJGroupConfigMapper;
	
	/**
	 * @author:fukangwen
	 * @Description: 集团主题配置列表
	 * @return OpenXFSJAreaConfig
	 * @throws
	 */
	public List<OpenXFSJGroupConfig> listGroupConfig() {
		OpenXFSJGroupConfigExample example = new OpenXFSJGroupConfigExample();
		example.createCriteria().andStatusEqualTo(OpenXFSJConstant.GroupConfigStatus.STATUS_VALID);
		example.setOrderByClause("create_time desc");
		return openXFSJGroupConfigMapper.selectByExample(example);
	}

	/**
	 * @author:fukangwen
	 * @Description: 新增集团主题
	 * @return void
	 * @throws
	 */
	public void insertGroupConfig(String name) {
		OpenXFSJGroupConfig config = new OpenXFSJGroupConfig();
		config.setCreateTime(new Date());
		config.setName(name);
		config.setStatus(OpenXFSJConstant.GroupConfigStatus.STATUS_VALID);
		openXFSJGroupConfigMapper.insert(config);
	}

	/**
	 * @author:fukangwen
	 * @Description: 更新集团主题信息
	 * @return void
	 * @throws
	 */
	public void updateGroupConfig(Long id, String name) {
		OpenXFSJGroupConfig config = openXFSJGroupConfigMapper.selectByPrimaryKey(id);
		config.setName(name);
		openXFSJGroupConfigMapper.updateByPrimaryKeySelective(config);
	}

	
}
