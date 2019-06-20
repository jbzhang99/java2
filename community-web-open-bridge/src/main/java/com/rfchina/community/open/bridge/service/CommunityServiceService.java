package com.rfchina.community.open.bridge.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;
import com.rfchina.community.persistence.mapper.CommunityServiceTempMapper;
import com.rfchina.community.persistence.model.CommunityServiceTemp;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.Order;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.open.bridge.entity.ExtCommunityService;
import com.rfchina.community.open.bridge.entity.ExtCommunityServiceAdmin;
import com.rfchina.community.open.bridge.entity.SimCommunityService;
import com.rfchina.community.open.bridge.mapper.ext.ExtCommunityServiceMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceCountMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceMapper;
import com.rfchina.community.persistence.mapper.OpenMerchantInfoMapper;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.CommunityServiceCount;
import com.rfchina.community.persistence.model.OpenMerchantInfo;

@Service
public class CommunityServiceService {

	@Autowired
	private ExtCommunityServiceMapper extCommunityServiceMapper;
	@Autowired
	private CommunityServiceMapper communityServiceMapper;
	@Autowired
	private CommunityServiceTempMapper communityServiceTempMapper;
	@Autowired
	private CommunityServiceCountMapper communityServiceCountMapper;
	@Autowired
	private OpenMerchantInfoMapper openMerchantInfoMapper;

	public CommunityService getCommunityService(int id) {
		return communityServiceMapper.selectByPrimaryKey(id);
	}
	public CommunityServiceTemp getCommunityServiceTemp(int id) {
		return communityServiceTempMapper.selectByPrimaryKey(id);
	}

	public OpenMerchantInfo getOpenMerchantInfo(Long id) {
		return openMerchantInfoMapper.selectByPrimaryKey(id);
	}

	/**
	 * @author:fukangwen
	 * @Description: 获取实体服务市场列表
	 * @return PageList<SimCommunityService>
	 * @throws
	 */
	public PageList<SimCommunityService> getSimCommunityServiceList(int categoryId, int status, int communityId, int index,
			int size) {

		Map<String, Object> param = new HashMap<>();

		if (categoryId > 0) {
			param.put("categoryId", categoryId);
		}

		if (status > 0) {
			param.put("status", status);
		}

		if (communityId > 0) {
			param.put("communityId", communityId);
		}

		PageBounds pageBounds = new PageBounds(index, size, Order.formString("recommend_level.desc , title"));

		return extCommunityServiceMapper.getSimCommunityServiceList(param, pageBounds);
	}
	
	/**
	 * @author:fukangwen
	 * @Description:获取虚拟服务市场列表
	 * @return PageList<SimCommunityService>
	 * @throws
	 */
	public PageList<SimCommunityService> getVirtualSimCommunityServiceList(int categoryId, int status, int index,
			int size) {
		
		Map<String, Object> param = new HashMap<>();
		
		if (categoryId > 0) {
			param.put("categoryId", categoryId);
		}
		
		if (status > 0) {
			param.put("status", status);
		}
		PageBounds pageBounds = new PageBounds(index, size, Order.formString("recommend_level.desc , title"));
		
		return extCommunityServiceMapper.getVirtualSimCommunityServiceList(param, pageBounds);
	}

	public PageList<ExtCommunityService> getCommunityServiceApply(int communityId, int categoryId, int merchantId,
			int merchantType, String serviceName, String merchantName, int communityAuditStatus, Date startApplyTime,
			Date endApplyTime, int index, int size) {

		Map<String, Object> param = new HashMap<>();

		if (communityId > 0) {
			param.put("communityId", communityId);
		}

		if (categoryId > 0) {
			param.put("categoryId", categoryId);
		}

		if (merchantId > 0) {
			param.put("merchantId", merchantId);
		}

		if (merchantType > 0) {
			param.put("merchantType", merchantType);
		}

		if (communityAuditStatus > 0) {
			param.put("communityAuditStatus", communityAuditStatus);
		}

		if (startApplyTime != null) {
			param.put("startApplyTime", startApplyTime);
		}

		if (endApplyTime != null) {
			param.put("endApplyTime", endApplyTime);
		}

		if (StringUtils.isNotBlank(serviceName)) {
			param.put("title", serviceName);
		}

		if (StringUtils.isNotBlank(merchantName)) {
			param.put("merchantName", merchantName);
		}

		PageBounds pageBounds = new PageBounds(index, size, Order.formString("apply_time.desc"));

		PageList<ExtCommunityService> plist = extCommunityServiceMapper.getCommunityServiceApplyList(param, pageBounds);
		for (ExtCommunityService extCommunityService : plist) {

			CommunityServiceCount countser = communityServiceCountMapper
					.selectByPrimaryKey(extCommunityService.getId());
			if (countser != null) {
				extCommunityService.setUnlikeCount(countser.getUnlikeCount());
				extCommunityService.setLikeCount(countser.getLikeCount());
			} else {
				extCommunityService.setUnlikeCount(0);
				extCommunityService.setLikeCount(0);
			}
		}
		return plist;
	}

	public PageList<ExtCommunityServiceAdmin> getMyServiceList(int categoryId, int communityId, int merchantType,
			String merchantName, String serviceName, int communityServiceStatus, int index, int size) {

		Map<String, Object> param = new HashMap<>();

		if (categoryId > 0) {
			param.put("categoryId", categoryId);
		}

		if (merchantType > 0) {
			param.put("merchantType", merchantType);
		}

		if (StringUtils.isNotBlank(merchantName)) {
			param.put("merchantName", merchantName);
		}

		if (StringUtils.isNotBlank(serviceName)) {
			param.put("title", serviceName);
		}

		if (communityServiceStatus > 0) {
			param.put("communityServiceStatus", communityServiceStatus);
		}

		if (communityId > 0) {
			param.put("communityId", communityId);
		}

		param.put("selectStatus", 1);
		param.put("status", 1);

		PageBounds pageBounds = new PageBounds(index, size, Order.formString("community_service_reorder,id"));

		PageList<ExtCommunityServiceAdmin> plist = extCommunityServiceMapper.getMyServiceList(param, pageBounds);
		for (ExtCommunityServiceAdmin extCommunityService : plist) {

			CommunityServiceCount countser = communityServiceCountMapper
					.selectByPrimaryKey(extCommunityService.getId());
			if (countser != null) {
				extCommunityService.setUnlikeCount(countser.getUnlikeCount());
				extCommunityService.setLikeCount(countser.getLikeCount());
			} else {
				extCommunityService.setUnlikeCount(0);
				extCommunityService.setLikeCount(0);
			}
		}
		return plist;
	}

	public  List<Map<String,Object>>  getServiceTitle(String title, List<Integer> statusList){
		Map<String, Object> param = Maps.newHashMap();
		param.put("title","%"+title+"%");
		param.put("types",statusList);
		return extCommunityServiceMapper.findServiceTitle(param);
	}

	public CommunityServiceTemp getCommunityServiceTempByPrimaryKey(int serviceId) {
		return communityServiceTempMapper.selectByPrimaryKey(serviceId);
	}
}
