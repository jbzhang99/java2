package com.rfchina.community.openweb.service;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.OpenGoodGroupConstant;
import com.rfchina.community.base.util.DecimalUtils;
import com.rfchina.community.openweb.entity.ExtOpenStoreGood;
import com.rfchina.community.openweb.mapper.ext.ExtOpenStoreGoodMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceCategoryMapper;
import com.rfchina.community.persistence.mapper.OpenStoreGoodDetailMapper;
import com.rfchina.community.persistence.mapper.OpenStoreGoodMapper;
import com.rfchina.community.persistence.mapper.OpenStoreShoppingCartMapper;
import com.rfchina.community.persistence.model.*;
import com.rfchina.community.service.openser.OpenStoreGoodStockDetailService;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.Page;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
	private OpenStoreGoodDetailMapper openStoreGoodDetailMapper;
	@Autowired
	private ExtOpenStoreGoodMapper extOpenStoreGoodMapper;
	@Autowired
	private OpenStoreShoppingCartMapper openStoreShoppingCartMapper;
	@Autowired
	private OpenStoreGoodStockDetailService openStoreGoodStockDetailService;
	@Autowired
	private CommunityServiceCategoryMapper communityServiceCategoryMapper;
	@Autowired
	private OpenGoodShowCategoryService openGoodShowCategoryService;
	@Autowired
	private OpenStoreGoodRecommendService openStoreGoodRecommendService;

	public static int STORE_GOOD_STOCK = 999999;
	/**
	 * @author:fukangwen
	 * @Description: 新增商品
	 * @return void
	 * @throws
	 */
	@Transactional
	public void insert(int serviceId, String code, String name, BigDecimal prePrice, BigDecimal price,
					   String picUrl, String detail, int stock, int categoryId, List<Long> list, int limitTimes) {
		OpenStoreGood domain = new OpenStoreGood();
		domain.setServiceId(serviceId);
		domain.setCode(code);
		domain.setName(name);
		domain.setPrePrice(prePrice);
		domain.setPrice(price);
		domain.setPicUrl(picUrl);
		domain.setCreateTime(new Date());
		domain.setUpdateTime(domain.getCreateTime());
		domain.setStatus(OpenConstant.GoodStatus.GROUNDING.key);//改成默认上架20180208
		domain.setStock(stock);
		domain.setSaleAmount(0);//实际销量默认0
		domain.setTotalSaleAmount(0);//虚拟销量+实际销量
		domain.setVirtualSaleAmount(0);//销量虚拟销量
		domain.setCategoryId(categoryId);
		domain.setLimitTimes(limitTimes);
		openStoreGoodMapper.insertSelective(domain);
		
		OpenStoreGoodDetail goodDetail = new OpenStoreGoodDetail();
		goodDetail.setGoodId(domain.getId());
		goodDetail.setDetail(detail);
		openStoreGoodDetailMapper.insert(goodDetail);

		//更新店内分类
		openGoodShowCategoryService.insertOrDeleteCategoryGoodRel(domain.getId(), list);
	}

	/**
	 * @author:fukangwen
	 * @Description: 更新商品信息
	 * @return void
	 * @throws
	 */
	public void update(int goodId, String code, String name, BigDecimal prePrice, BigDecimal price,
			String picUrl, String detail, Integer stock, Integer categoryId, List<Long> list, int limitTimes) {
		OpenStoreGood domain = openStoreGoodMapper.selectByPrimaryKey(goodId);
		validator(domain == null, "商品不存在" + goodId);
		domain.setCode(code);
		domain.setName(name);
		domain.setPrePrice(prePrice);
		domain.setPrice(price);
		domain.setPicUrl(picUrl);
		domain.setLimitTimes(limitTimes);
		domain.setUpdateTime(new Date());
		if(stock != null) {
			domain.setStock(stock);
		}
		if(categoryId != null) {
			domain.setCategoryId(categoryId);
		}
		openStoreGoodMapper.updateByPrimaryKeySelective(domain);
		
		OpenStoreGoodDetail goodDetail = openStoreGoodDetailMapper.selectByPrimaryKey(goodId);
		validator(goodDetail == null, "商品不存在" + goodId);
		goodDetail.setDetail(detail);
		openStoreGoodDetailMapper.updateByPrimaryKeySelective(goodDetail);

		//更新店内分类
		openGoodShowCategoryService.insertOrDeleteCategoryGoodRel(domain.getId(), list);
	}
	

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
		
		//商品删除时，更新该商品购物车的状态
		if(domain.getStatus() == OpenConstant.GoodStatus.DEL.key) {
			OpenStoreShoppingCart cart = new OpenStoreShoppingCart();
			cart.setValidStatus(0);//设置为无效
			OpenStoreShoppingCartExample example = new OpenStoreShoppingCartExample();
			example.createCriteria().andValidStatusEqualTo(1).andGoodIdEqualTo(goodId);
			openStoreShoppingCartMapper.updateByExampleSelective(cart, example);

			//删除商品店内分类关联表
			openGoodShowCategoryService.deleteByGoodId(goodId);
		}
	}

	/**
	 * @author:fukangwen
	 * @Description: 获取商品详情
	 * @return ExtOpenStoreGood
	 * @throws
	 */
	public ExtOpenStoreGood getGoodDetail(int goodId) {
		OpenStoreGood domain = openStoreGoodMapper.selectByPrimaryKey(goodId);
		validator(domain == null || domain.getStatus() == OpenConstant.GoodStatus.DEL.key, "商品不存在" + goodId);
		
		ExtOpenStoreGood extOpenStoreGood = new ExtOpenStoreGood();
		BeanUtils.copyProperties(domain, extOpenStoreGood);
		
		CommunityServiceCategory category = communityServiceCategoryMapper.selectByPrimaryKey(domain.getCategoryId());
		extOpenStoreGood.setCategoryName(category == null ? "" : category.getName());

		extOpenStoreGood.setShowCategoryIdList(openGoodShowCategoryService.getGoodCategoryIdList(goodId));
		//详情
		OpenStoreGoodDetail goodDetail = openStoreGoodDetailMapper.selectByPrimaryKey(goodId);
		validator(domain == null, "商品不存在" + goodId);
		extOpenStoreGood.setDetail(goodDetail.getDetail());
		return extOpenStoreGood;
	}

	/**
	 * @author:fukangwen
	 * @Description: 商品管理列表
	 * @return Page<ExtOpenStoreGood>
	 * @throws
	 */
	public Page<ExtOpenStoreGood> pageQuery(int serviceId, String name, String code, int status,
			Long showCategoryId, Integer recommendStatus, Date startCreateDate,
			Date endCreateDate, int index, int size) {
		Map<String, Object> param = new HashMap<>();
		if(serviceId > 0){
			param.put("serviceId", serviceId);
		}
		if(StringUtils.isNotBlank(name)){
			param.put("name", "%" + name + "%");
		}
		if(StringUtils.isNotBlank(code)){
			param.put("code", "%" + code + "%");
		}
		if(status > 0){
			param.put("status", status);
		}
		if(showCategoryId > 0){
			param.put("showCategoryId", showCategoryId);
		}
		if(recommendStatus != null){
			param.put("recommendStatus", recommendStatus);
		}
		if(startCreateDate != null){
			param.put("startCreateDate", startCreateDate);
		}
		if(endCreateDate != null){
			param.put("endCreateDate", endCreateDate);
		}
		PageBounds pageBounds = new PageBounds(index, size);
		
		PageList<ExtOpenStoreGood> list = extOpenStoreGoodMapper.pageByCondition(param, pageBounds);
		list = setPremiumPrice(list);
		return domainList2VoList(list).convert();
	}
	
	/**
	 * 设置溢价
	 * @author maixingnian
	 * @param list
	 * @return
	 */
	private PageList<ExtOpenStoreGood> setPremiumPrice(PageList<ExtOpenStoreGood> list) {
		for(ExtOpenStoreGood eosg : list) {
			if(eosg.getPremiumNum() > 0 && eosg.getPrice() != null) {
				//溢价计算
				BigDecimal b1 = DecimalUtils.obj2BigDecimal(eosg.getPremiumNum());
				b1 = DecimalUtils.mul(b1, eosg.getPrice()); //相乘
				b1 = DecimalUtils.div(b1, DecimalUtils.obj2BigDecimal(100)); //相除
				b1 = DecimalUtils.add(b1, eosg.getPrice());//相加
				b1 = DecimalUtils.bigDecimalScale(b1, 2, BigDecimal.ROUND_UP); //向上取整
				eosg.setPremiumPrice(b1);//设值
			} else {
				//没溢价(不需处理)
				//eosg.setPrice(eosg.getPrice());
			}
		}
		return list;
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 完善返回参数
	 * @return PageList<ExtOpenStoreGood>
	 * @throws
	 */
	private PageList<ExtOpenStoreGood> domainList2VoList(PageList<ExtOpenStoreGood> list) {
		if(list.isEmpty())
			return list;
		for(ExtOpenStoreGood extOpenStoreGood : list) {
			String[] urls = extOpenStoreGood.getPicUrl().split(",");
			extOpenStoreGood.setPicUrl(urls[0]);
		}
		return list;
	}
	
	
	public OpenStoreGood selectByPrimaryKey(int goodId) {
		return openStoreGoodMapper.selectByPrimaryKey(goodId);
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 给商品设置库存数量
	 * @return void
	 * @throws
	 */
	public void setStock(int goodId, int stockNum) {
		OpenStoreGood openStoreGood = openStoreGoodMapper.selectByPrimaryKey(goodId);
		validator(openStoreGood == null, "商品不存在");
		int before = openStoreGood.getStock();
		openStoreGood.setStock(stockNum);
		openStoreGoodMapper.updateByPrimaryKey(openStoreGood);
		
		openStoreGoodStockDetailService.insert(goodId,0, before, stockNum, 0, OpenGoodGroupConstant.stockType.good,
				OpenConstant.StockOperate.SET.toString(), OpenConstant.StockSource.ADMIN.toString(), null);

	}

	//更新产品的排序
	public int updateGoodSorting(Integer id, Integer sorting){

		OpenStoreGood record=new OpenStoreGood();
		record.setId(id);
		record.setSorting(sorting);
		return 	openStoreGoodMapper.updateByPrimaryKeySelective(record);
	}
}
