package com.rfchina.community.open.bridge.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.base.OpenXFSJConstant;
import com.rfchina.community.component.AreaComponent;
import com.rfchina.community.open.bridge.entity.ExtOpenXFSJAreaConfig;
import com.rfchina.community.persistence.mapper.OpenXFSJAreaConfigMapper;
import com.rfchina.community.persistence.mapper.OpenXFSJGroupConfigMapper;
import com.rfchina.community.persistence.model.OpenXFSJAreaConfig;
import com.rfchina.community.persistence.model.OpenXFSJAreaConfigExample;
import com.rfchina.community.persistence.model.OpenXFSJGroupConfig;

/**
 * @author:fukangwen
 * @Description: 地区主题配置
 */
@Service
public class OpenXFSJAreaConfigService extends BaseService {

	@Autowired
	private OpenXFSJAreaConfigMapper openXFSJAreaConfigMapper;
	@Autowired
	private OpenXFSJGroupConfigMapper openXFSJGroupConfigMapper;
	@Autowired
	private AreaComponent areaComponent;

	/**
	 * @author:fukangwen
	 * @Description: 
	 * @return List<OpenXFSJAreaConfig>
	 * @throws
	 */
	public List<OpenXFSJAreaConfig> listAreaConfig(int cityId, long groupConfigId) {
		OpenXFSJAreaConfigExample example = new OpenXFSJAreaConfigExample();
		example.createCriteria().andCityIdEqualTo(cityId)
			.andGroupConfigIdEqualTo(groupConfigId)
			.andStatusEqualTo(OpenXFSJConstant.AreaConfigStatus.STATUS_VALID);
		List<OpenXFSJAreaConfig> list = openXFSJAreaConfigMapper.selectByExample(example);
		return list;
	}

	
	/**
	 * @author:fukangwen
	 * @Description: 
	 * @return List<OpenXFSJAreaConfig>
	 * @throws
	 */
	public List<ExtOpenXFSJAreaConfig> areaConfigList2ExtList(List<OpenXFSJAreaConfig> list) {
		List<ExtOpenXFSJAreaConfig> extList = new ArrayList<ExtOpenXFSJAreaConfig>();
		for(OpenXFSJAreaConfig config : list) {
			ExtOpenXFSJAreaConfig extConfig = new ExtOpenXFSJAreaConfig();
			BeanUtils.copyProperties(config, extConfig);
			extConfig.setCityName(areaComponent.getAreaName(config.getCityId()));
			OpenXFSJGroupConfig groupConfig = openXFSJGroupConfigMapper.selectByPrimaryKey(config.getGroupConfigId());
			extConfig.setGroupConfigName(groupConfig == null ? "" : groupConfig.getName());
			extList.add(extConfig);
		}
		return extList;
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 新增
	 * @return void
	 * @throws
	 */
	public void insertAreaConfig(int cityId, long groupConfigId, String name) {
		check(cityId, groupConfigId);
		OpenXFSJAreaConfig config = new OpenXFSJAreaConfig();
		config.setCityId(cityId);
		config.setCreateTime(new Date());
		config.setGroupConfigId(groupConfigId);
		config.setName(name);
		config.setStatus(OpenXFSJConstant.AreaConfigStatus.STATUS_VALID);
		openXFSJAreaConfigMapper.insert(config);
	}

	
	private void check(int cityId, long groupConfigId) {
		OpenXFSJAreaConfigExample example = new OpenXFSJAreaConfigExample();
		example.createCriteria().andCityIdEqualTo(cityId)
			.andGroupConfigIdEqualTo(groupConfigId)
			.andStatusEqualTo(OpenXFSJConstant.AreaConfigStatus.STATUS_VALID);
		
		long count = openXFSJAreaConfigMapper.countByExample(example);
		if(count > 0)
			error("已存在对应配置");
	}


	/**
	 * @author:fukangwen
	 * @Description: 更新
	 * @return void
	 * @throws
	 */
	public void updateAreaConfig(Long id, String name) {
		OpenXFSJAreaConfig config = openXFSJAreaConfigMapper.selectByPrimaryKey(id);
		config.setName(name);
		openXFSJAreaConfigMapper.updateByPrimaryKeySelective(config);
	}

}
