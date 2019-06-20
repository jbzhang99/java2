package com.rfchina.community.open.bridge.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.mybatis.paginator.model.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.open.bridge.entity.ExtCommunityResourceActivity;
import com.rfchina.community.open.bridge.mapper.ext.ExtCommunityResourceMapper;
import com.rfchina.community.persistence.model.CommunityResource;
import com.rfchina.community.persistence.model.CommunityResourceExample;
import com.rfchina.community.persistence.model.CommunityResourceExample.Criteria;

/**
 * 社区资源服务
 * @author maixingnian
 *
 */
@Service
public class CommunityResourceService extends BaseService{
	
	@Autowired
	private ExtCommunityResourceMapper extCommunityResourceMapper;
	
	/**
	 * 分页获取所有社区资源
	 * @param index
	 * @param size
	 * @return
	 */
	public List<CommunityResource> listCommunityResource(int index, int size) {
		PageBounds pageBounds = new PageBounds(index, size);
		CommunityResourceExample crExample = new CommunityResourceExample();
		return extCommunityResourceMapper.pageByExample(crExample,pageBounds);
	}

	/**
	 * 筛查社区资源
	 * @return
	 */
	public List<CommunityResource> getByCondition(Integer cityId, Integer communityId, String phone, Integer index, Integer size) {
		CommunityResourceExample example = new CommunityResourceExample();
		Criteria criteria = example.createCriteria();
		if(null != cityId) {
			criteria.andCityIdEqualTo(cityId);
		}
		if(null != communityId) {
			criteria.andCommunityIdEqualTo(communityId);
		}
		//根据管家id获取手机号码接口（与管家端对接）
		if(null != phone) {
//			crExample.createCriteria(),
//			List<OpenDebugUser> userList = openDebugUserService.getOpenDebugUserList(extCommunityService.getId());
		}
		PageBounds pageBounds = new PageBounds(index, size);
		example.setOrderByClause("id desc");
		return extCommunityResourceMapper.pageByExample(example,pageBounds);
	}

	/**
	 * 新增社区资源
	 * @return boolean
	 */
	public boolean addCommunityResource(Integer cityId, Integer communityId, Integer resourceTypeId, String addrDetail,
			String resourceDesc, Integer resourceTotal, Integer resourceUsed, BigDecimal resourceFee, String img, Integer createrId) {
		CommunityResource communityResource = new CommunityResource();
		communityResource.setCityId(cityId);
		communityResource.setCommunityId(communityId);
		communityResource.setResourceTypeId(resourceTypeId);
		communityResource.setAddrDetail(addrDetail);
		communityResource.setResourceDesc(resourceDesc);
		communityResource.setResourceTotal(resourceTotal);
		communityResource.setResourceUsed(resourceUsed);
		communityResource.setResourceFee(resourceFee);
		communityResource.setImgs(img);
		communityResource.setResourceStatus((byte)1);
		communityResource.setCreateTime(new Date());
		communityResource.setCreaterId(createrId);
		
		int result = extCommunityResourceMapper.insert(communityResource);
		return result == 1 ? true: false;
	}
	
	/**
	 * 根据资源id更新社区资源
	 * @return
	 */
	public boolean updateCommunityResource(Integer communityResourceId, Integer cityId, Integer communityId, Integer resourceTypeId, String addrDetail, 
			String resourceDesc, Integer resourceTotal, Integer resourceUsed, BigDecimal resourceFee,String img, Integer adminId) {
		
		CommunityResource record = new CommunityResource();
		record.setId(communityResourceId);
		record.setCityId(cityId);
		record.setCommunityId(communityId);
		record.setResourceTypeId(resourceTypeId);
		record.setAddrDetail(addrDetail);
		record.setResourceDesc(resourceDesc);
		record.setResourceTotal(resourceTotal);
		record.setResourceUsed(resourceUsed);
		record.setResourceFee(resourceFee);
		record.setImgs(img);
		record.setResourceStatus((byte)1);
		record.setModifyTime(new Date());
		record.setModifierId(adminId);
		
		CommunityResourceExample example = new CommunityResourceExample();
		example.createCriteria().andIdEqualTo(communityResourceId);
		extCommunityResourceMapper.selectByExample(example);
		int result = extCommunityResourceMapper.updateByExampleSelective(record,example);
		return result == 1 ? true: false;
	}
	
	/**
	 * 根据社区活动id查询资源列表
	 * @param activityId
	 * @return
	 */
	public List<ExtCommunityResourceActivity> listCommunityResourceByActivityId(Long activityId) {
		return extCommunityResourceMapper.getCommunityResourceByActivityId(activityId);
	}

	/**
	 * 根据活动id获取资源详情
	 * @param communityResourceId
	 * @return
	 */
	public CommunityResource getCommunityResourceById(Integer communityResourceId) {
		return extCommunityResourceMapper.selectByPrimaryKey(communityResourceId);
	}

	/**
	 * 根据资源id删除社区资源
	 * @param communityResourceId
	 * @return
	 */
	public boolean deleteCommunityResourceById(Integer communityResourceId, Integer adminId) {
		CommunityResource record = new CommunityResource();
		record.setId(communityResourceId);
		record.setModifierId(adminId);
		int result = extCommunityResourceMapper.deleteBycommunityResourceId(record);
		return result == 1 ? true: false;
	}

}
