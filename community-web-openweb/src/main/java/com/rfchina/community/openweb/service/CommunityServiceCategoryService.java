package com.rfchina.community.openweb.service;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.openweb.mapper.ext.ExtCommunityServiceCategoryMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceCategoryMapper;
import com.rfchina.community.persistence.model.CommunityServiceCategory;
import com.rfchina.community.persistence.model.CommunityServiceCategoryExample;
import com.rfchina.community.persistence.model.CommunityServiceCategoryExample.Criteria;

@Service
public class CommunityServiceCategoryService{

	@Autowired
	private ExtCommunityServiceCategoryMapper extCommunityServiceCategoryMapper;
	@Autowired
	private CommunityServiceCategoryMapper communityServiceCategoryMapper;
	
	public PageList<CommunityServiceCategory> getCommunityServiceCategoryList(int index , int size, int type){
		
		CommunityServiceCategoryExample example = new CommunityServiceCategoryExample();
		Criteria criteria = example.createCriteria().andTypeEqualTo(type).andValidStatusEqualTo(1);
		if(type != 5) {//非商品类型需要曝光才显示
			criteria.andExposureEqualTo(1);
		}
		example.setOrderByClause("create_time desc");
		
		PageBounds pageBounds = new PageBounds(index, size);
		
		return extCommunityServiceCategoryMapper.pageCommunityServiceCategory(example, pageBounds);
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
	
}
