package com.rfchina.community.open.bridge.service;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.open.bridge.entity.ExtCommunityServiceCategory;
import com.rfchina.community.open.bridge.mapper.ext.ExtCommunityServiceCategoryMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceCategoryMapper;
import com.rfchina.community.persistence.model.CommunityServiceCategory;
import com.rfchina.community.persistence.model.CommunityServiceCategoryExample;
import com.rfchina.community.service.openser.CommunityServiceCategoryBaseService;
import org.mybatis.paginator.model.Page;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CommunityServiceCategoryService extends CommunityServiceCategoryBaseService {

	@Autowired
	private ExtCommunityServiceCategoryMapper extCommunityServiceCategoryMapper;

	@Autowired
	private CommunityServiceCategoryMapper communityServiceCategoryMapper;

	public List<CommunityServiceCategory> getThirdServiceCategory() {

		CommunityServiceCategoryExample example = new CommunityServiceCategoryExample();
		example.createCriteria().andExposureEqualTo(1).andTypeIn(Arrays.asList(2, 4));
		example.setOrderByClause("sort");
		List<CommunityServiceCategory> list = communityServiceCategoryMapper.selectByExample(example);
		return list;
	}

	public PageList<CommunityServiceCategory> getCommunityServiceCategoryList(int index, int size, Integer type) {

		CommunityServiceCategoryExample example = new CommunityServiceCategoryExample();
		example.createCriteria().andTypeEqualTo(type).andValidStatusEqualTo(OpenConstant.CategoryStatus.valid_status);
		example.setOrderByClause("id desc");

		PageBounds pageBounds = new PageBounds(index, size);

		return extCommunityServiceCategoryMapper.pageCommunityServiceCategory(example, pageBounds);
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 分页
	 * @return PageList<CommunityServiceCategory>
	 * @throws
	 */
	public Page<ExtCommunityServiceCategory> getCategoryList(int index, int size, Integer type) {

		PageBounds pageBounds = new PageBounds(index, size);
		Map<String, Object> param = new HashMap<>();
		if(type > 0) {
			param.put("type", type);
		}
		PageList<ExtCommunityServiceCategory> list = extCommunityServiceCategoryMapper.pageCategory(param, pageBounds);
		return list.convert();
	}
	

	public long getCommunityServiceCategory(String name, Integer id, Integer type) {
		CommunityServiceCategoryExample example = new CommunityServiceCategoryExample();

		example.createCriteria().andNameEqualTo(name).andTypeEqualTo(type).andIdNotEqualTo(id);
		return communityServiceCategoryMapper.countByExample(example);
	}

	public void addCommunityServiceCategory(CommunityServiceCategory communityServiceCategory) {
		communityServiceCategoryMapper.insertSelective(communityServiceCategory);
	}

	public int deleteCommunityServiceCategory(int id) {
	return 	communityServiceCategoryMapper.deleteByPrimaryKey(id);
	}

	public int updateCommunityServiceCategory(CommunityServiceCategory record) {
		return communityServiceCategoryMapper.updateByPrimaryKeySelective(record);
	}

	public CommunityServiceCategory getCommunityServiceCategory(int id) {
		return communityServiceCategoryMapper.selectByPrimaryKey(id);
	}

	public String getBusinessType(String idsStr) {
		String[] ids = idsStr.split(",");
		List<Integer> idList = new ArrayList<Integer>();
		for(String id : ids) {
			idList.add(Integer.parseInt(id));
		}
		CommunityServiceCategoryExample example = new CommunityServiceCategoryExample();
		example.createCriteria().andIdIn(idList);
		List<CommunityServiceCategory> list = communityServiceCategoryMapper.selectByExample(example);
		StringBuffer buff = new StringBuffer();
		for(CommunityServiceCategory domain : list) {
			buff.append(domain.getName());
			buff.append("、");
		}
		return buff.substring(0, buff.length()-1);
	}

	public List<CommunityServiceCategory> getActivityCategoryList(){
		CommunityServiceCategoryExample example = new CommunityServiceCategoryExample();
		example.createCriteria().andTypeEqualTo(6);
		example.or(new CommunityServiceCategoryExample().createCriteria().andIdEqualTo(3));
		return  communityServiceCategoryMapper.selectByExample(example);
	}
}
