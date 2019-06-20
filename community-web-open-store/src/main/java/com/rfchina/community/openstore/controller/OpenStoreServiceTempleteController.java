package com.rfchina.community.openstore.controller;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.openstore.service.OpenServiceDetailService;
import com.rfchina.community.openstore.service.OpenStoreServiceDiscountService;
import com.rfchina.community.openstore.service.OpenStoreServiceTempleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 */
@RestController
@RequestMapping(value = { Constant.ROOT_PATH_OPENSTORE })
public class OpenStoreServiceTempleteController extends BaseController {

	@Autowired
	private OpenStoreServiceTempleteService openStoreServiceTempleteService;
	@Autowired
	private OpenServiceDetailService openServiceDetailService;
	@Autowired
	private OpenStoreServiceDiscountService openStoreServiceDiscountService;

	/**
	 * @author:fukangwen @Description: 获取店铺资料信息 @throws
	 */
	@RequestMapping(value = { "/get_store_templete_info" })
	public Result<?> getStoreTempleteInfo(@RequestParam(value = "serviceId", required = true) int serviceId) {
		logger.info("method ： getStoreTempleteInfo; serviceId={}", serviceId);
		validator(serviceId < 0, "参数有误");

		// 判断模式是否是模板开发
		Boolean isTemplete = openServiceDetailService.isTemplete(serviceId);
		validator(!isTemplete, "该服务不是使用模板开发");

		return Result.successData(openStoreServiceTempleteService.getTempleteInfo(serviceId));
	}

	@RequestMapping(value = { "/getStoreServiceDiscount" })
	public Result<?> getStoreServiceDiscount(@RequestParam(value = "serviceId", required = true) int serviceId) {
		logger.info("method ： getStoreServiceDiscount; serviceId={}", serviceId);
		validator(serviceId < 0, "参数有误");
		// 判断模式是否是模板开发
		Boolean isTemplete = openServiceDetailService.isTemplete(serviceId);
		validator(!isTemplete, "该服务不是使用模板开发");
		return Result.successData(openStoreServiceDiscountService.getByServiceId(serviceId));
	}



}
