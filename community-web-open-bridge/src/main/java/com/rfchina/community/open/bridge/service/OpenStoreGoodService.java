package com.rfchina.community.open.bridge.service;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.open.bridge.entity.ExtOpenStoreGood;
import com.rfchina.community.open.bridge.entity.SimOpenStoreGood;
import com.rfchina.community.open.bridge.mapper.ext.ExtOpenStoreGoodMapper;
import com.rfchina.community.persistence.mapper.OpenStoreGoodDetailMapper;
import com.rfchina.community.persistence.mapper.OpenStoreGoodMapper;
import com.rfchina.community.persistence.model.CommunityServiceCategory;
import com.rfchina.community.persistence.model.OpenStoreGood;
import com.rfchina.community.persistence.model.OpenStoreGoodDetail;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.Page;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:fukangwen
 * @Description: 服务商模板service
 */
@Service
public class OpenStoreGoodService extends BaseService{

	@Autowired
	private OpenStoreGoodMapper openStoreGoodMapper;
	@Autowired
	private ExtOpenStoreGoodMapper extOpenStoreGoodMapper;
	@Autowired
	private OpenStoreGoodDetailMapper openStoreGoodDetailMapper;
	@Autowired
	private OpenGoodShowCategoryService openGoodShowCategoryService;
	@Autowired
	private CommunityServiceCategoryService communityServiceCategoryService;

	/**
	 * @author:fukangwen
	 * @Description: 更改商品状态
	 * @return void
	 * @throws
	 */
	public void changeStatus(int goodId, int status) {
		OpenStoreGood domain = openStoreGoodMapper.selectByPrimaryKey(goodId);
		validator(domain == null, "商品不存在" + goodId);
		validator(domain.getStatus() == OpenConstant.GoodStatus.DEL.key, "该商品已经被删除");
		
		domain.setStatus(status);
		domain.setUpdateTime(new Date());
		openStoreGoodMapper.updateByPrimaryKeySelective(domain);
	}


	/**
	 * @author:fukangwen
	 * @Description: 商品管理列表
	 * @return Page<ExtOpenStoreGood>
	 * @throws
	 */
	public PageList<ExtOpenStoreGood> pageQuery1(String storeName, String merchantName, String name, int categoryId, int status, int index, int size) {
		Map<String, Object> param = new HashMap<>();
		if(StringUtils.isNotBlank(storeName)){
			param.put("storeName", "%" + storeName + "%");
		}
		if(StringUtils.isNotBlank(merchantName)){
			param.put("merchantName", "%" + merchantName + "%");
		}
		if(StringUtils.isNotBlank(name)){
			param.put("name", "%" + name + "%");
		}
		if(status > 0){
			param.put("status", status);
		}
		if(categoryId > 0){
			param.put("categoryId", categoryId);
		}
		PageBounds pageBounds = new PageBounds(index, size);
		
		 
		
		return  extOpenStoreGoodMapper.pageByCondition(param, pageBounds);
	}
	
	
	public OpenStoreGood selectByPrimaryKey(int goodId) {
		return openStoreGoodMapper.selectByPrimaryKey(goodId);
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 获取有效的商品
	 * @return OpenStoreGood
	 * @throws
	 */
	public Page<SimOpenStoreGood> listStoreGood(int serviceId, String goodName, int index, int size) {
		Map<String, Object> param = new HashMap<>();
		if(StringUtils.isNotBlank(goodName)){
			param.put("goodName", "%" + goodName + "%");
		}
		if(serviceId > 0){
			param.put("serviceId", serviceId);
		}
		PageBounds pageBounds = new PageBounds(index, size);
		
		PageList<SimOpenStoreGood> list = extOpenStoreGoodMapper.listStoreGoodByCondition(param, pageBounds);
		
		return list.convert();
	}


	//更新产品的排序
	public int updateGoodSorting(Integer id, Integer sorting, int likeSorting){

		OpenStoreGood record=new OpenStoreGood();
		record.setId(id);
		record.setSorting(sorting);
		record.setLikeSorting(likeSorting);
		return 	openStoreGoodMapper.updateByPrimaryKeySelective(record);
	}


	//设置虚拟销量
	public int addVirtualSaleAmount(Integer id, int amount){
		OpenStoreGood record = openStoreGoodMapper.selectByPrimaryKey(id);
		validator(record == null, "商品不存在");
		record.setVirtualSaleAmount(record.getVirtualSaleAmount() + amount);
		record.setTotalSaleAmount(record.getTotalSaleAmount() + amount);
		return 	openStoreGoodMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * @author:fukangwen
	 * @Description: 获取商品详情
	 * @return ExtOpenStoreGood
	 * @throws
	 */
	public ExtOpenStoreGood getGoodDetail(int goodId) {
		OpenStoreGood domain = openStoreGoodMapper.selectByPrimaryKey(goodId);
		validator(domain == null, "商品不存在");
		ExtOpenStoreGood extOpenStoreGood = new ExtOpenStoreGood();
		BeanUtils.copyProperties(domain, extOpenStoreGood);
		//详情
		OpenStoreGoodDetail goodDetail = openStoreGoodDetailMapper.selectByPrimaryKey(goodId);
		extOpenStoreGood.setDetail(goodDetail == null ? "" : goodDetail.getDetail());
		//店内分类list
		extOpenStoreGood.setShowCategoryList(openGoodShowCategoryService.getShowCategoryList(goodId));

		//商品分类
		CommunityServiceCategory category = communityServiceCategoryService.getCommunityServiceCategory(domain.getCategoryId());
		extOpenStoreGood.setCategoryName(category == null ? "" : category.getName());

		return extOpenStoreGood;
	}
}
