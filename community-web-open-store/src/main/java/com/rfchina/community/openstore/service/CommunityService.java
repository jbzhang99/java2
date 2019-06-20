package com.rfchina.community.openstore.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.rfchina.community.service.openser.CommunityBaseService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.rfchina.community.base.Constant;
import com.rfchina.community.component.AreaComponent;
import com.rfchina.community.openstore.entity.UidCommunityCount;
import com.rfchina.community.openstore.entity.ext.ExtXFSJCommunity;
import com.rfchina.community.openstore.mapper.ext.ExtCommunityMapper;
import com.rfchina.community.openstore.mapper.ext.ExtMasterChild2Mapper;
import com.rfchina.community.persistence.mapper.CommunityAttentionMapper;
import com.rfchina.community.persistence.mapper.CommunityMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceRelaMapper;
import com.rfchina.community.persistence.mapper.MasterChildMapper;
import com.rfchina.community.persistence.mapper.OpenUserServiceMapper;
import com.rfchina.community.persistence.model.Area;
import com.rfchina.community.persistence.model.Community;
import com.rfchina.community.persistence.model.CommunityAttentionExample;
import com.rfchina.community.persistence.model.CommunityServiceRelaExample;
import com.rfchina.community.persistence.model.MasterChildExample;
import com.rfchina.community.persistence.model.OpenUserService;
import com.rfchina.community.persistence.model.OpenUserServiceKey;

@Service
public class CommunityService extends CommunityBaseService {

	@Autowired
	private ExtCommunityMapper extCommunityMapper;
	@Autowired
	private CommunityMapper communityMapper;
	@Autowired
	private CommunityAttentionMapper communityAttentionMapper;
	@Autowired
	private CommunityServiceRelaMapper communityServiceRelaMapper;
	@Autowired
	private MasterChildMapper masterChildMapper;
	@Autowired
	private AreaComponent areaComponent;
	@Autowired
	private OpenUserServiceMapper openUserServiceMapper;
	@Autowired
	private ExtMasterChild2Mapper extMasterChild2Mapper;

	public Community getCommunity(int id){
		return communityMapper.selectByPrimaryKey(id);
	}


	public PageList<ExtXFSJCommunity> getXFSJCommunity(Long uid, String clientLng, String clientLat, int index, int size) {
		PageBounds pageBounds = new PageBounds(index, size);
		// 有小富市集全部社区
		PageList<Community> communityList = extCommunityMapper.getXFSJCommunity(pageBounds);
		PageList<ExtXFSJCommunity> extCommunityList = getExtCommunity(communityList, uid);
		if (CollectionUtils.isNotEmpty(communityList)) {
			int lastUseCommunity = getLastUseCommunity(uid);
			List<Integer> communityIdList = getCommunityIdList(extCommunityList, lastUseCommunity);
			//是否认证社区
			isAuthentication(uid, extCommunityList, communityIdList);
			sort(extCommunityList);
		}
		logger.info(
				"uid:{}, clientLng:{}, clientLat:{}, index:{}, size:{}",
				uid, clientLng, clientLat, index, size);
		PageList<ExtXFSJCommunity> list = new PageList<ExtXFSJCommunity>(extCommunityList, communityList.getPaginator());
		return list;
	}

	private void sort(PageList<ExtXFSJCommunity> extCommunityList) {
		Collections.sort(extCommunityList, (a1, a2) -> {
			int i = a2.getIsLastUserOpen().compareTo(a1.getIsLastUserOpen());
			if (i != 0)
				return i;
			i = a2.getIsAuthentication().compareTo(a1.getIsAuthentication());
			if (i != 0)
				return i;
			i = a2.getUserAttention().compareTo(a1.getUserAttention());
			if (i != 0)
				return i;
			return a2.getAttentionCount().compareTo(a1.getAttentionCount());
		});
	}

	private void isAuthentication(Long uid, PageList<ExtXFSJCommunity> extCommunityList, List<Integer> communityIdList) {
		if (uid != null && uid > 0) {
			List<UidCommunityCount> mapUid = extMasterChild2Mapper.groupCommunityByUid(uid, communityIdList);
			logger.info("uid:{},communityIdList:{},mapUid:{}", uid, communityIdList, mapUid);
			for (ExtXFSJCommunity item : extCommunityList) {
				for (UidCommunityCount uidCommunityCount : mapUid) {
					if (uidCommunityCount.getCommunityId() == item.getId()) {
						item.setIsAuthentication(1);
					}
				}
			}
		}
	}

	private List<Integer> getCommunityIdList(PageList<ExtXFSJCommunity> extCommunityList, int lastUseCommunity) {
		List<Integer> communityIdList = new ArrayList<>();
		for (ExtXFSJCommunity item : extCommunityList) {
			if (item.getId() == lastUseCommunity) {
				item.setIsLastUserOpen(1);
			}
			communityIdList.add(item.getId());
			item.setAttentionCount(getCommunityAttentionCount(item.getId()));
		}
		return communityIdList;
	}

	private int getLastUseCommunity(Long uid) {
		int lastUseCommunity = 0;
		if (uid != null && uid > 0) {
			OpenUserServiceKey key = new OpenUserServiceKey();
			key.setServiceId(-1);//小富市集标志
			key.setUid(uid);
			OpenUserService ous = openUserServiceMapper.selectByPrimaryKey(key);
			if (ous != null) {
				lastUseCommunity = ous.getLastUseCommunityId();
			}
		}
		return lastUseCommunity;
	}

	private PageList<ExtXFSJCommunity> getExtCommunity(PageList<Community> communityList, Long uid)  {
		List<ExtXFSJCommunity> resultList = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(communityList)) {
			for (int k = 0; k < communityList.size(); k++) {
				Community item = communityList.get(k);
				Area area = areaComponent.getArea(item.getAreaId());
				String areaName = getAreaName(area);
				boolean isMasterUser = uid != null ? isMasterUser(uid, item.getId()) : false;
				resultList.add(getExtXFSJCommunity(uid, item, areaName, isMasterUser));
			}
		}
		return new PageList<>(resultList, communityList.getPaginator());
	}

	private ExtXFSJCommunity getExtXFSJCommunity(Long uid, Community item, String areaName, boolean isMasterUser) {
		ExtXFSJCommunity newItem = new ExtXFSJCommunity();
		BeanUtils.copyProperties(item, newItem);
		newItem.setAreaName(areaName);
		newItem.setName(StringUtils.defaultIfBlank(areaName, "") + item.getName());
		newItem.setMasterUser(isMasterUser ? Constant.YesOrNo.YES : Constant.YesOrNo.NO);
		// 查询服务数量
		CommunityServiceRelaExample example = new CommunityServiceRelaExample();
		example.createCriteria().andCommunityIdEqualTo(item.getId()).andStatusEqualTo(1);
		long serviceCount = communityServiceRelaMapper.countByExample(example);
		newItem.setServiceCount(serviceCount);
		newItem.setUserAttention(Constant.YesOrNo.NO);
		if (null != uid) {
			boolean attention = isCommunityAttention(uid, item.getId());
			newItem.setUserAttention(attention ? Constant.YesOrNo.YES : Constant.YesOrNo.NO);
		}
		return newItem;
	}

	private String getAreaName(Area area) {
		String areaName = "";
		if (null != area) {
			Integer levelType = area.getLevelType();
			if (2 == levelType) {
				areaName = area.getShortName();
			} else if (3 == levelType) {
				Area parentArea = areaComponent.getArea(area.getParentId());
				areaName = parentArea.getShortName();
			} else {
				areaName = area.getShortName();
			}
		}
		return areaName;
	}


	public Long getCommunityAttentionCount(Integer communityId) {
		CommunityAttentionExample example = new CommunityAttentionExample();
		example.createCriteria().andCommunityIdEqualTo(communityId);
		Long count = communityAttentionMapper.countByExample(example);
		return count;
	}

	public boolean isMasterUser(Long uid, Integer communityId) {
		MasterChildExample example = new MasterChildExample();
		example.createCriteria().andUidEqualTo(uid).andCommunityIdEqualTo(communityId).andStatusEqualTo(Constant.MasterChild.Status.ENABLE);
		long count = masterChildMapper.countByExample(example);
		boolean flag = count > 0;
		logger.debug("uid[{}]-is-master-user:{}", uid, flag);
		return flag;
	}

	public boolean isCommunityAttention(Long uid, Integer communityId) {
		CommunityAttentionExample example = new CommunityAttentionExample();
		example.createCriteria().andCommunityIdEqualTo(communityId).andUidEqualTo(uid);
		boolean flag = communityAttentionMapper.countByExample(example) == 1;
		return flag;
	}


}
