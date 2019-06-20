package com.rfchina.community.openstore.service;

import com.github.pagehelper.PageInfo;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.openstore.entity.ext.ExtOpenGoodShowCategoryData;
import com.rfchina.community.openstore.entity.ext.ExtOpenStoreGood;
import com.rfchina.community.openstore.mapper.ext.ExtOpenStoreGoodMapper;
import com.rfchina.community.persistence.mapper.OpenGoodShowCategoryMapper;
import com.rfchina.community.persistence.model.OpenGoodShowCategory;
import com.rfchina.community.persistence.model.OpenGoodShowCategoryExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OpenGoodShowCategoryService extends BaseService {
	@Autowired
	private OpenGoodShowCategoryMapper openGoodShowCategoryMapper;
	@Autowired
	private ExtOpenStoreGoodMapper extOpenStoreGoodMapper;
	@Autowired
	private OpenStoreGoodService openStoreGoodService;

	public static final int CATEGORY_GOOD_LIMIT = 10;

	/**
	 * 获取店内分类数据
	 * @param serviceId
	 * @return
	 */
	public List<ExtOpenGoodShowCategoryData> categoryDataList(int serviceId){
		List<ExtOpenGoodShowCategoryData> returnList = new ArrayList<ExtOpenGoodShowCategoryData>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<OpenGoodShowCategory> categoryList = this.categoryList(serviceId, 1);
		if(!categoryList.isEmpty()){
			for(OpenGoodShowCategory category : categoryList){
				ExtOpenGoodShowCategoryData data = new ExtOpenGoodShowCategoryData();
				BeanUtils.copyProperties(category, data);
				PageInfo<ExtOpenStoreGood> list = openStoreGoodService.pageQuery(serviceId, null, OpenConstant.OpenStoreGoodSortType.GENERAL.getCode(),
						OpenConstant.OpenStoreGoodSort.down, category.getId(), 1, 10);
				data.setGoodList(list.getList());
				returnList.add(data);
			}
		}
		return returnList;
	}


	/**
	 * 获取推荐的商品列表
	 * @param serviceId
	 * @return
	 */
	public List<ExtOpenStoreGood> getRecommendGoodList(int serviceId){
		Map<String, Object> param = new HashMap<>();
		param.put("serviceId", serviceId);
		List<ExtOpenStoreGood> recommendGoodList = extOpenStoreGoodMapper.listRecommendGood(param);
		for(ExtOpenStoreGood good : recommendGoodList){
			good.setPicUrl(good.getPicUrl().split(",")[0]);
			if(good.getIsUseMainPic() == 1){
				good.setShowUrl(good.getPicUrl());
			}

		}
		return recommendGoodList;
	}

	public List<OpenGoodShowCategory> categoryList(int serviceId, Integer isShow){
		OpenGoodShowCategoryExample example = new OpenGoodShowCategoryExample();
		OpenGoodShowCategoryExample.Criteria criteria = example.createCriteria().andServiceIdEqualTo(serviceId);
		if(isShow != null){
			criteria.andIsShowEqualTo(isShow);
		}
		example.setOrderByClause("sorting, create_time");
		return openGoodShowCategoryMapper.selectByExample(example);
	}

}
