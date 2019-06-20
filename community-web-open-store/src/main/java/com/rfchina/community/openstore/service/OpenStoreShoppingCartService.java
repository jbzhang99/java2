package com.rfchina.community.openstore.service;

import com.rfchina.community.base.OpenGoodGroupConstant;
import com.rfchina.community.openstore.entity.ext.ExtMutiStoreShoppingCart;
import com.rfchina.community.openstore.entity.ext.ExtOpenStoreShoppingCart;
import com.rfchina.community.openstore.mapper.ext.ExtOpenStoreShoppingCartMapper;
import com.rfchina.community.persistence.mapper.OpenStoreServiceTempleteMapper;
import com.rfchina.community.persistence.mapper.OpenStoreShoppingCartMapper;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author:fukangwen
 * @Description: 购物车service
 */
@Service
public class OpenStoreShoppingCartService extends BaseService{

	@Autowired
	private OpenStoreShoppingCartMapper openStoreShoppingCartMapper;
	@Autowired
	private ExtOpenStoreShoppingCartMapper extOpenStoreShoppingCartMapper;
	@Autowired
	private OpenStoreGoodService openStoreGoodService;
	@Autowired
	private CommunityServiceService communityServiceService;
	@Autowired
	private OpenStoreServiceDiscountService openStoreServiceDiscountService;
	@Autowired
	private CommunityServiceRelaService communityServiceRelaService;
	@Autowired
	private OpenStoreServiceTempleteMapper openStoreServiceTempleteMapper;
	@Autowired
	private OpenStoreGoodGroupInfoService openStoreGoodGroupInfoService;

	
	public static final int LIMIT_CART_AMOUNT = 999999;
	/**
	 * @author:fukangwen
	 * @Description: 新增记录或者增加购物车数量
	 * @return void
	 * @throws
	 */
	public void cartAddOrIncrease(String openId, int goodId, Long uid) {
		OpenStoreGood good = openStoreGoodService.getById(goodId);
		validator(good == null, "商品不存在");
		validator(good.getStatus() != 1, "商品下架或已删除");
		validator(good.getStock() < 1, "商品库存不足");
		OpenStoreShoppingCartExample example = new OpenStoreShoppingCartExample();
		example.createCriteria().andGoodIdEqualTo(goodId).andUserIdEqualTo(uid).andValidStatusEqualTo(ValidStatus.VALID.code);
		List<OpenStoreShoppingCart> list = openStoreShoppingCartMapper.selectByExample(example);
		if(list.isEmpty()) {
			//新增一条记录
			insert(good.getServiceId(), openId, goodId, uid);
		}else {
			//原有基础数量加1
			increase(list.get(0), uid);
		}
	}
	/**
	 * @author:fukangwen
	 * @Description: 设置购物车数量
	 * @return void
	 * @throws
	 */
	public void setCartAmount(int cartId, int amount) {
		OpenStoreShoppingCart cart = openStoreShoppingCartMapper.selectByPrimaryKey(cartId);
		validator(cart == null, "购物车不存在");
		OpenStoreGood good = openStoreGoodService.getById(cart.getGoodId());
		validator(good == null, "商品不存在");
		validator(good.getStatus() != 1, "商品下架或已删除");
		validator(good.getStock() < amount, "商品库存不足");
		//设置数量
		cart.setAmount(amount);
		cart.setUpdateTime(new Date());
		openStoreShoppingCartMapper.updateByPrimaryKeySelective(cart);
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 给购物车记录增加数量
	 * @return void
	 * @throws
	 */
	private void increase(OpenStoreShoppingCart cart, Long uid) {
		//
		if(cart.getAmount() > LIMIT_CART_AMOUNT)
			return;
		if(cart.getUserId().longValue() != uid.longValue())
			return;
		cart.setAmount(cart.getAmount() + 1);
		cart.setUpdateTime(new Date());
		openStoreShoppingCartMapper.updateByPrimaryKeySelective(cart);
		
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 新增一条购物车记录
	 * @return void
	 * @throws
	 */
	private void insert(int serviceId, String openId, int goodId, Long uid) {
		OpenStoreShoppingCart cart = new OpenStoreShoppingCart();
		cart.setAmount(1);//默认新增加1
		cart.setCreateTime(new Date());
		cart.setGoodId(goodId);
		cart.setOpenId(openId);
		cart.setUserId(uid);
		cart.setServiceId(serviceId);
		cart.setValidStatus(ValidStatus.VALID.code);
		cart.setUpdateTime(new Date());
		openStoreShoppingCartMapper.insert(cart);
	}

	public enum ValidStatus{
		VALID(1,"有效"),INVALID(0, "无效");
		private int code;
		private String label;
		ValidStatus(int key, String label){
			this.code = key;
			this.label = label;
		}
		public int getCode() {
			return code;
		}
		public void setCode(int code) {
			this.code = code;
		}
		public String getLabel() {
			return label;
		}
		public void setLabel(String label) {
			this.label = label;
		}
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 减少购物车数量
	 * @return void
	 * @throws
	 */
	public void cartReduce(int cartId, long userId) {
		OpenStoreShoppingCart cart = openStoreShoppingCartMapper.selectByPrimaryKey(cartId);
		if(cart == null) return;
		
		OpenStoreGood good = openStoreGoodService.getById(cart.getGoodId());
		validator(good == null, "商品不存在");
		validator(good.getStatus() != 1, "商品下架或已删除");
		
		if(cart.getUserId().longValue() != userId) return;
		if(cart.getAmount() <= 1) return;
		
		cart.setAmount(cart.getAmount() - 1);
		cart.setUpdateTime(new Date());
		openStoreShoppingCartMapper.updateByPrimaryKeySelective(cart);
	}

	/**
	 * @author:fukangwen
	 * @Description: 删除购物车
	 * @return void
	 * @throws
	 */
	public void cartDelete(String cartIds, long userId) {
		String[] ids = cartIds.split(",");
		if(ids.length <= 0)
			return;
		for(String id : ids) {
			validator(!StringUtils.isNumeric(id), "参数有误");	
			int cartId = Integer.parseInt(id);
			OpenStoreShoppingCart openStoreShoppingCart = openStoreShoppingCartMapper.selectByPrimaryKey(cartId);
			if(openStoreShoppingCart.getUserId().longValue() != userId)
				return;
			openStoreShoppingCart.setValidStatus(ValidStatus.INVALID.code);
			openStoreShoppingCartMapper.updateByPrimaryKey(openStoreShoppingCart);
		}
		
	}

	/**
	 * @author:fukangwen
	 * @Description: 购物车列表
	 * @return Result<?>
	 * @throws
	 */
	public List<ExtOpenStoreShoppingCart> cartList(int serviceId, Long userId) {
		OpenStoreShoppingCartExample example = new OpenStoreShoppingCartExample();
		example.createCriteria().andServiceIdEqualTo(serviceId).andUserIdEqualTo(userId).andValidStatusEqualTo(ValidStatus.VALID.code);
		example.setOrderByClause("create_time desc");
		List<OpenStoreShoppingCart> list = openStoreShoppingCartMapper.selectByExample(example);
		if(list.isEmpty())
			return new ArrayList<ExtOpenStoreShoppingCart>();
		List<ExtOpenStoreShoppingCart> returnList = new ArrayList<ExtOpenStoreShoppingCart>();
		for(OpenStoreShoppingCart cart : list) {
			OpenStoreGood openStoreGood = openStoreGoodService.getById(cart.getGoodId());
			validator(openStoreGood == null, "商品不存在");
			//商品状态下架时过滤掉该商品的购物车
			if(openStoreGood.getStatus() == OpenStoreGoodService.Status.UNDER.getKey() ||
					openStoreGood.getStatus() == OpenStoreGoodService.Status.DEL.getKey() || openStoreGood.getStock() <= 0) {
				continue;
			}
			ExtOpenStoreShoppingCart extCart = new ExtOpenStoreShoppingCart();
			BeanUtils.copyProperties(cart, extCart);
			String[] urls = openStoreGood.getPicUrl().split(",");
			extCart.setPicUrl(urls[0]);
			extCart.setName(openStoreGood.getName());
			extCart.setPrePrice(openStoreGood.getPrePrice());
			extCart.setPrice(openStoreGood.getPrice());
			returnList.add(extCart);
		}
		return returnList;
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 购物车列表(多店铺列表)
	 * @return Result<?>
	 * @throws
	 */
	public List<ExtMutiStoreShoppingCart> mutiStoreCartList(int communityId, Long userId) {
		//在获取时候要去掉商品删除或下架的
		List<OpenStoreShoppingCart> list = extOpenStoreShoppingCartMapper.getOpenStoreCartList(userId);
		if(list.isEmpty())
			return new ArrayList<ExtMutiStoreShoppingCart>();
		
		Map<Integer, List<OpenStoreShoppingCart>> cartListMap = list.stream()
                .distinct()
                .collect(Collectors.groupingBy(OpenStoreShoppingCart::getServiceId));
		
		
		List<ExtMutiStoreShoppingCart> mutiCartList = new ArrayList<>();
		
		cartListMap.forEach((serviceId, v) -> {
			CommunityService service = communityServiceService.getCommunityServiceByPrimaryKey(serviceId);
            if(service == null)
            	return;
            ExtMutiStoreShoppingCart ext = new ExtMutiStoreShoppingCart();
            ext.setServiceId(serviceId);
            ext.setTitle(service.getTitle());
            OpenStoreServiceTemplete templete = openStoreServiceTempleteMapper.selectByPrimaryKey(serviceId);
            ext.setExpressMoney(templete.getExpressMoney());
            ext.setOpenStoreServiceDiscount(openStoreServiceDiscountService.getByServiceId(serviceId));
            ext.setIsRelate(communityServiceRelaService.isRelate(serviceId, communityId));
			ext.setCartList(v.stream().map(cart -> {
            	OpenStoreGood openStoreGood = openStoreGoodService.getById(cart.getGoodId());
    			ExtOpenStoreShoppingCart extCart = new ExtOpenStoreShoppingCart();
    			BeanUtils.copyProperties(cart, extCart);
    			String[] urls = openStoreGood.getPicUrl().split(",");
    			extCart.setPicUrl(urls[0]);
    			extCart.setName(openStoreGood.getName());
    			extCart.setPrePrice(openStoreGood.getPrePrice());
				OpenStoreGoodGroupInfo groupInfo = openStoreGoodGroupInfoService.getValidGoodGroupInfo(cart.getGoodId());
				if(groupInfo != null){
					extCart.setPrice(groupInfo.getPrice());
				}else{
					extCart.setPrice(openStoreGood.getPrice());
				}

                return extCart;
            }).distinct().collect(Collectors.toList()));
			if(!ext.getCartList().isEmpty()) {
				mutiCartList.add(ext);
			}
        });
		
		Collections.sort(mutiCartList);
		return mutiCartList;
	}

	/**
	 * @author:fukangwen
	 * @Description: 多个购物车致为无效
	 * @return void
	 * @throws
	 */
	public void invalidShoppingCart(List<Integer> shoppingCartIdList) {
		OpenStoreShoppingCartExample example = new OpenStoreShoppingCartExample();
		example.createCriteria().andIdIn(shoppingCartIdList);
		OpenStoreShoppingCart cart = new OpenStoreShoppingCart();
		cart.setValidStatus(ValidStatus.INVALID.code);
		openStoreShoppingCartMapper.updateByExampleSelective(cart, example);
	}
	
	public long getCartNum(Long uid) {
		return extOpenStoreShoppingCartMapper.getCartNum(uid);
	}
}
