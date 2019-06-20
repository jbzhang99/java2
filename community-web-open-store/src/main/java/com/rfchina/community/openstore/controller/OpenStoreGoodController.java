package com.rfchina.community.openstore.controller;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.openstore.entity.ext.ExtMutiBeforePayInfo;
import com.rfchina.community.openstore.entity.ext.ExtOpenStoreServiceTemplete;
import com.rfchina.community.openstore.service.OpenStoreGoodService;
import com.rfchina.community.openstore.service.OpenStoreServiceTempleteService;
import com.rfchina.community.persistence.model.OpenStoreGood;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 模板商品C端controller
 */
@RestController
@RequestMapping(value = {Constant.ROOT_PATH_OPENSTORE})
public class OpenStoreGoodController extends BaseController {

	@Autowired
	private OpenStoreServiceTempleteService openStoreServiceTempleteService;
	@Autowired
	private OpenStoreGoodService openStoreGoodService;
	

	
	/**
	 * @author:fukangwen
	 * @Description: 商品模板C端-商品列表
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping(value = {"/good_page_query"})
	public Result<?> goodPageQuery(
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size,
			@RequestParam(value = "serviceId", required = false, defaultValue = "10") int serviceId,
			@RequestParam(value = "type", required = false, defaultValue = "GENERAL") String type,
			@RequestParam(value = "sort", required = false, defaultValue = OpenConstant.OpenStoreGoodSort.down) String sort,
			@RequestParam(value = "showCategoryId", required = false) Long showCategoryId,
			@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword
			)throws ParseException  {
		logger.info("method ： goodPageQuery; params:serviceId={},index={},size={},type={},sort={}，showCategoryId={},keyword={}"
				,serviceId,index, size, type, sort, showCategoryId, keyword);
		return Result.successData(openStoreGoodService.pageQuery(serviceId, keyword, type, sort, showCategoryId, index, size));
	}
	
	
	/**
	 * @author:fukangwen
	 * @Description: 获取商品详情
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping(value = {"/good_get_detail"})
	public Result<?> getGoodDetail(@RequestParam(value = "goodId") int goodId) {
		validator(goodId < 0 , "参数有误");
		logger.info("method ： getGoodDetail; goodId={}", goodId); 
		return  Result.successData(openStoreGoodService.getGoodDetail(goodId));
	}

	/**
	 * @author:fukangwen
	 * @Description: 加载购物车商品
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping(value = {"/good_list_before_pay"})
	public Map<String, Object> listGoodBeforePay(
			@RequestParam(value = "goodIds") String goodIds
			) {
		logger.info("method ： listGoodBeforePay; goodIds={}", goodIds); 
		Map<String, Object> map = new HashMap<>();
		validator(StringUtils.isBlank(goodIds) , "参数有误");
		List<OpenStoreGood> list = openStoreGoodService.listGoodBeforePay(goodIds);
		map.put("goodList", list);
		if(!list.isEmpty()) {
			OpenStoreGood openStoreGood = list.get(0);
			ExtOpenStoreServiceTemplete templete = openStoreServiceTempleteService.getTempleteInfo(openStoreGood.getServiceId());
			map.put("templete", templete);
		}
		map.put("status", 200);
		map.put("message", "OK");
		return map;
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 加载购物车商品,下单前计算出每个服务的商品价格總價，優惠總價
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping(value = {"/muti_good_list_before_pay"})
	public Result<?> listMutiGoodBeforePay(
			@RequestParam(value = "goodIds") String goodIds
			) {
		logger.info("method ： muti_good_list_before_pay; goodIds={}", goodIds); 
		validator(StringUtils.isBlank(goodIds) , "参数有误");
		
		List<OpenStoreGood> list = openStoreGoodService.listGoodBeforePay(goodIds);
		
		List<ExtMutiBeforePayInfo> returnList = new ArrayList<>();
		if(!list.isEmpty()) {
			Map<Integer, List<OpenStoreGood>> goodListMap = list.stream()
	                .distinct()
	                .collect(Collectors.groupingBy(OpenStoreGood::getServiceId));
			goodListMap.forEach((serviceId, goodList)->{
				ExtMutiBeforePayInfo info = new ExtMutiBeforePayInfo();
				ExtOpenStoreServiceTemplete templete  = openStoreServiceTempleteService.getTempleteInfo(serviceId);
				info.setServiceId(serviceId);
				info.setGoodList(goodList);
				info.setTemplete(templete);
				returnList.add(info);
			});
		}
		return  Result.successData(returnList);
	}
	
}
