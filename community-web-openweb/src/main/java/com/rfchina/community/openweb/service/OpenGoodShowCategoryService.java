package com.rfchina.community.openweb.service;

import com.rfchina.community.entity.ServiceCategory;
import com.rfchina.community.persistence.mapper.OpenCategoryGoodRelMapper;
import com.rfchina.community.persistence.mapper.OpenGoodShowCategoryMapper;
import com.rfchina.community.persistence.mapper.ext.ExtOpenGoodShowCategoryMapper;
import com.rfchina.community.persistence.model.OpenCategoryGoodRel;
import com.rfchina.community.persistence.model.OpenCategoryGoodRelExample;
import com.rfchina.community.persistence.model.OpenGoodShowCategory;
import com.rfchina.community.persistence.model.OpenGoodShowCategoryExample;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OpenGoodShowCategoryService extends BaseService {
	@Autowired
	private OpenGoodShowCategoryMapper openGoodShowCategoryMapper;
	@Autowired
	private OpenCategoryGoodRelMapper openCategoryGoodRelMapper;
	@Autowired
	private ExtOpenGoodShowCategoryMapper extOpenGoodShowCategoryMapper;
	@Autowired
	private UploadFileService uploadFileService;

	public static final String defaultPic = "http://fts.p.thinkinpower.com/_f/openweb/fcdc6b14-43e8-4cc1-964e-4e7ae3eaa050.jpeg";
	public static final int showLimitCount = 20; //展示数量最多20个
	public static final int limitCount = 50; //总数不能超过50
	/**
	 * 新增
	 * @param serviceId
	 * @param categoryName
	 * @param sorting
	 * @param isShow
	 */
	public void insert(int serviceId, String categoryName, int sorting, String picUrl, int isShow){
		if(isShow == 1) {
			long count = this.getCount(serviceId, isShow);
			validator(count >= showLimitCount, "修改失败：首页展示的分类已达到20个上限。");
		}

		long count = this.getCount(serviceId, null);
		validator(count >= limitCount, "添加失败，添加的分类已达到50个上限。");

		OpenGoodShowCategory category = new OpenGoodShowCategory();
		category.setCategoryName(categoryName);
		category.setServiceId(serviceId);
		category.setCreateTime(new Date());
		category.setUpdateTime(category.getCreateTime());
		category.setIsShow(isShow);
		category.setSorting(sorting);
		if(StringUtils.isBlank(picUrl)){
			picUrl = defaultPic;
		}
		category.setPicUrl(picUrl);
		category.setPicInfo(this.getImgInfo(picUrl));
		openGoodShowCategoryMapper.insertSelective(category);
	}

	private long getCount(int serviceId, Integer isShow){
		OpenGoodShowCategoryExample example = new OpenGoodShowCategoryExample();
		if(isShow != null) {
			example.createCriteria().andServiceIdEqualTo(serviceId).andIsShowEqualTo(isShow);
		}else{
			example.createCriteria().andServiceIdEqualTo(serviceId);
		}
		return openGoodShowCategoryMapper.countByExample(example);
	}

	/**
	 * 获取图片信息
	 * @param url
	 * @return
	 */
	private String getImgInfo(String url){
		if(StringUtils.isBlank(url)){
			return "";
		}
		String[] fileKeys = url.split("/");
		String fileKey = fileKeys[fileKeys.length - 1];
		String imgInfo = "";
		try {
			imgInfo = uploadFileService.getImgInfo(fileKey);
		}catch (IOException e){
			logger.info(e.getMessage());
			return "";
		}
		return imgInfo;
	}

	/**
	 * 更新
	 * @param categoryId
	 * @param categoryName
	 * @param sorting
	 * @param isShow
	 */
	public void update(int serviceId, long categoryId, String categoryName, int sorting, String picUrl, int isShow){
		if(isShow == 1) {
			long count = this.getCount(serviceId, isShow);
			validator(count >= showLimitCount, "修改失败：首页展示的分类已达到20个上限。");
		}

		OpenGoodShowCategory category = openGoodShowCategoryMapper.selectByPrimaryKey(categoryId);
		validator(category == null, "分类不存在");
		category.setCategoryName(categoryName);
		if(!category.getPicUrl().equals(picUrl) || StringUtils.isBlank(category.getPicInfo())){
			category.setPicInfo(this.getImgInfo(picUrl));
		}
		category.setPicUrl(picUrl);
		category.setSorting(sorting);
		category.setIsShow(isShow);
		category.setUpdateTime(new Date());
		openGoodShowCategoryMapper.updateByPrimaryKey(category);
	}

	public PageList<OpenGoodShowCategory> pageQuery(int serviceId, int index, int size){
		PageBounds pageBounds = new PageBounds(index, size);

		Map<String, Object> param = new HashMap<>();
		param.put("serviceId", serviceId);
		PageList<OpenGoodShowCategory> list = extOpenGoodShowCategoryMapper.pageByCondition(param, pageBounds);
		return list;
	}

	public List<OpenGoodShowCategory> categoryList(int serviceId){
		OpenGoodShowCategoryExample example = new OpenGoodShowCategoryExample();
		example.createCriteria().andServiceIdEqualTo(serviceId);
		return openGoodShowCategoryMapper.selectByExample(example);
	}

	/**
	 * 删除
	 * @param categoryId
	 */
	public void delete(long categoryId){
		openGoodShowCategoryMapper.deleteByPrimaryKey(categoryId);

		//该目录关联表删除
		OpenCategoryGoodRelExample example = new OpenCategoryGoodRelExample();
		example.createCriteria().andShowCategoryIdEqualTo(categoryId);
		openCategoryGoodRelMapper.deleteByExample(example);
	}

	/**
	 * 根据商品id和对应的店内展示分类idList新增或删除
	 */
	public void insertOrDeleteCategoryGoodRel(int goodId, List<Long> categoryList){
		//把没有选到的删除掉
		OpenCategoryGoodRelExample example = new OpenCategoryGoodRelExample();
		OpenCategoryGoodRelExample.Criteria criteria = example.createCriteria().andGoodIdEqualTo(goodId);
		if(categoryList != null && !categoryList.isEmpty()){
			criteria.andShowCategoryIdNotIn(categoryList);
		}
		openCategoryGoodRelMapper.deleteByExample(example);

		//把选到的且在数据库有记录的用map装起来，并用categoryId为key
		OpenCategoryGoodRelExample example1 = new OpenCategoryGoodRelExample();
		OpenCategoryGoodRelExample.Criteria criteria1 = example1.createCriteria().andGoodIdEqualTo(goodId);
		if(categoryList != null && !categoryList.isEmpty()){
			criteria1.andShowCategoryIdIn(categoryList);
		}
		List<OpenCategoryGoodRel> relList = openCategoryGoodRelMapper.selectByExample(example1);

		Map<Long, List<OpenCategoryGoodRel>> groupBy = relList.stream().collect(Collectors.groupingBy(OpenCategoryGoodRel::getShowCategoryId));

		//把没有在map里面的全部新增
		for(Long categoryId : categoryList){
			if(categoryId != null && groupBy.get(categoryId) == null){
				OpenCategoryGoodRel rel = new OpenCategoryGoodRel();
				rel.setCreateTime(new Date());
				rel.setShowCategoryId(categoryId);
				rel.setGoodId(goodId);
				openCategoryGoodRelMapper.insertSelective(rel);
			}
		}
	}

	public List<ServiceCategory> getGoodCategoryList(int goodId){
		return extOpenGoodShowCategoryMapper.getGoodCategoryList(goodId);
	}

	public List<Long> getGoodCategoryIdList(int goodId){
		return extOpenGoodShowCategoryMapper.getGoodCategoryIdList(goodId);
	}

	/**
	 * 删除商品时，删除关联分类表
	 */
	public void deleteByGoodId(int goodId){
		OpenCategoryGoodRelExample example = new OpenCategoryGoodRelExample();
		example.createCriteria().andGoodIdEqualTo(goodId);
		openCategoryGoodRelMapper.deleteByExample(example);
	}
}
