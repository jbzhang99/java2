package com.rfchina.community.open.bridge.service;

import com.rfchina.community.persistence.mapper.OpenCategoryGoodRelMapper;
import com.rfchina.community.persistence.mapper.OpenGoodShowCategoryMapper;
import com.rfchina.community.persistence.mapper.ext.ExtOpenGoodShowCategoryMapper;
import com.rfchina.community.persistence.model.OpenCategoryGoodRel;
import com.rfchina.community.persistence.model.OpenCategoryGoodRelExample;
import com.rfchina.community.persistence.model.OpenGoodShowCategory;
import com.rfchina.community.persistence.model.OpenGoodShowCategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OpenGoodShowCategoryService extends BaseService {
	@Autowired
	private OpenGoodShowCategoryMapper openGoodShowCategoryMapper;
	@Autowired
	private OpenCategoryGoodRelMapper openCategoryGoodRelMapper;
	@Autowired
	private ExtOpenGoodShowCategoryMapper extOpenGoodShowCategoryMapper;

	public List<OpenGoodShowCategory> getShowCategoryList(int goodId){
		OpenCategoryGoodRelExample example = new OpenCategoryGoodRelExample();
		example.createCriteria().andGoodIdEqualTo(goodId);
		List<OpenCategoryGoodRel> relList = openCategoryGoodRelMapper.selectByExample(example);
		List<OpenGoodShowCategory> categoryList = new ArrayList<OpenGoodShowCategory>();
		if(relList.isEmpty()){
			return categoryList;
		}

		for(OpenCategoryGoodRel rel : relList){
			categoryList.add(openGoodShowCategoryMapper.selectByPrimaryKey(rel.getShowCategoryId()));
		}

		return categoryList;
	}
}
