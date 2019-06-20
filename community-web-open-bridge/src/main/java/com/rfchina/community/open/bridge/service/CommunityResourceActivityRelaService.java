package com.rfchina.community.open.bridge.service;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.persistence.mapper.CommunityResourceActivityRelaMapper;
import com.rfchina.community.persistence.model.CommunityResourceActivityRela;

@Service
public class CommunityResourceActivityRelaService extends BaseService {
	@Autowired
	private CommunityResourceActivityRelaMapper communityResourceActivityRelaMapper;

	/**
	 * @author:fukangwen
	 * @Description: 新增资源市集关系记录
	 * @return void
	 * @throws
	 */
	public void insert(Integer communityId, Integer cityId, Long xfsjId, int resourceId) {
		CommunityResourceActivityRela rela = new CommunityResourceActivityRela();
		rela.setActivityId(xfsjId);
		rela.setCommunityId(communityId);
		rela.setCityId(cityId);
		rela.setCommunityResourceId(resourceId);
		rela.setCreateTime(new Date());
		communityResourceActivityRelaMapper.insert(rela);
	}

	/**
	 * @author:fukangwen
	 * @Description: 批量新增资源市集关系表
	 * @return void
	 * @throws
	 */
	public void batchInsert(Integer cityId, Integer communityId, Long xfsjId, String resource) {
		if(StringUtils.isBlank(resource)) {
			return;
		}
		String[] resourceIds = resource.split(",");
		for(int i = 0; i < resourceIds.length; i++) {
			int resourceId = Integer.parseInt(resourceIds[i]);
			this.insert(cityId, communityId, xfsjId, resourceId);
		}
		
	}

}
