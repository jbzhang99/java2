package com.rfchina.community.openstore.controller;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.openstore.entity.ext.ExtMutiStoreShoppingCart;
import com.rfchina.community.openstore.service.CommunityService;
import com.rfchina.community.openstore.service.OpenStoreShoppingCartService;
import com.rfchina.community.persistence.model.Community;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:fukangwen
 * @Description: 购物车controller
 */
@RestController
@RequestMapping(value = {Constant.ROOT_PATH_OPENSTORE})
public class OpenStoreShoppingCartController extends BaseController {
	@Autowired
	private OpenStoreShoppingCartService openStoreShoppingCartService;
	@Autowired
	private CommunityService communityService;

	/**
	 * @author:fukangwen
	 * @Description: 增加购物车记录或者数量
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping(value = {"/cart_add_or_increase"})
	public Result<?> cartAddOrIncrease(
			@RequestParam(value = "goodId", required = true) int goodId,
			@RequestParam(value = "clientType", required = false, defaultValue="APP") String clientType,
			@RequestParam(value = "access_token", required = false) String accessToken,
			HttpServletRequest request
			) {
		logger.info("method ： cartAddOrIncrease; goodId={}, clientType={}, access_token={}", goodId, clientType, accessToken);
		validator(goodId < 0, "参数错误");
		
		Long uid = validateAndGetUid(clientType, accessToken);
		String openId = null;
		openStoreShoppingCartService.cartAddOrIncrease(openId, goodId, uid);
		return Result.success();
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 设置购物车数量
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping(value = {"/cart_set_amount"})
	public Result<?> setCartAmount(
			@RequestParam(value = "cartId", required = true) int cartId,
			@RequestParam(value = "amount", required = true) int amount,
			@RequestParam(value = "clientType", required = false, defaultValue="APP") String clientType,
			@RequestParam(value = "access_token", required = false) String accessToken,
			HttpServletRequest request
			) {
		logger.info("method ： setCartAmount; cartId={},amount={}", cartId, amount);
		validator(cartId <= 0 || amount <= 0, "参数错误");
		
		validateAndGetUid(clientType, accessToken);
		
		openStoreShoppingCartService.setCartAmount(cartId, amount);
		return Result.success();
	}
	
	
	/**
	 * @author:fukangwen
	 * @Description: 减少购物车该商品数量
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping(value = {"/cart_reduce"})
	public Result<?> cartReduce(
			@RequestParam(value = "cartId", required = true) int cartId,
			@RequestParam(value = "clientType", required = false, defaultValue="APP") String clientType,
			@RequestParam(value = "access_token", required = false) String accessToken
			) {
		logger.info("method ： cartReduce; cartId={},clientType={}", cartId,clientType);
		validator(cartId < 0, "参数错误");
		
		Long uid = validateAndGetUid(clientType, accessToken);
		
		openStoreShoppingCartService.cartReduce(cartId, uid);
		return Result.success();
	}

	
	/**
	 * @author:fukangwen
	 * @Description: 删除购物车商品
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping(value = {"/cart_delete"})
	public Result<?> cartDelete(
			@RequestParam(value = "cartIds", required = true) String cartIds,
			@RequestParam(value = "clientType", required = false, defaultValue="APP") String clientType,
			@RequestParam(value = "access_token", required = false) String accessToken
			) {
		logger.info("method ： cartDelete; cartIds={},clientType={}", cartIds, clientType);
		
		Long uid = validateAndGetUid(clientType, accessToken);
		
		openStoreShoppingCartService.cartDelete(cartIds, uid);
		return Result.success();
	}
	
	
	/**
	 * @author:fukangwen
	 * @Description: 购物车列表
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping(value = {"/muti_store_cart_list"})
	public Result<?> mutiStoreCartList(
			@RequestParam(value = "communityId", required = true) int communityId,
			@RequestParam(value = "clientType", required = false, defaultValue="APP") String clientType,
			@RequestParam(value = "access_token", required = false) String accessToken) {
		logger.info("method ： muti_store_cart_list; communityId={}, clientType={}", communityId,clientType);
		
		Long uid = validateAndGetUid(clientType, accessToken);
		
		Map<String, Object> map = new HashMap<>();
		List<ExtMutiStoreShoppingCart> list = openStoreShoppingCartService.mutiStoreCartList(communityId, uid);
		map.put("list", list);
		Community community = communityService.getCommunity(communityId);
		map.put("communityName", community == null ? "" : community.getName());
		return Result.successData(map);
	}
	
	
	/**
	 * @author:fukangwen
	 * @Description: 获取购物车数量
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping(value = {"/get_cart_num"})
	public Result<?> getCartNum(
			@RequestParam(value = "clientType", required = false, defaultValue="APP") String clientType,
			@RequestParam(value = "access_token", required = false) String accessToken) {
		Long uid = 0L;
		try {
			uid = validateAndGetUid(clientType, accessToken);
		} catch (Exception e) {
			return Result.successData(0L);
		}
		
		return Result.successData(openStoreShoppingCartService.getCartNum(uid));
	}
	
}
