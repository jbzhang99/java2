package com.rfchina.community.openweb.controller;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.openweb.service.OpenStoreServiceDiscountService;

/**
 * @author:fukangwen
 * @Description: 设置优惠满减
 */
@RestController
@RequestMapping(value=Constant.ROOT_PATH_OPENWEB)
public class OpenStoreServiceDiscountController extends BaseController {
	
	@Autowired
	OpenStoreServiceDiscountService openStoreServiceDiscountService;
	
	/**
	 * @author:fukangwen
	 * @Description: 
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping(value={"/update_store_discount"} )
	public Result<?> updateStoreDiscount(
			@RequestParam(value = "serviceId", required = true) int serviceId,
			@RequestParam(value = "discountPrice", required = false, defaultValue = "0") String discountPrice,
			@RequestParam(value = "discountMoney", required = false, defaultValue = "0") String discountMoney,
			@RequestParam(value = "eachMoneyTop", required = false, defaultValue = "0") String eachMoneyTop,
			@RequestParam(value = "status", required = true) int status
			) {
		BigDecimal discountPriceBig = new BigDecimal(0);
		BigDecimal discountMoneyBig = new BigDecimal(0);
		BigDecimal eachMoneyTopBig = new BigDecimal(0);
		
		//status == 1 (discountPrice > 0, discountMoney > 0, eachMoneyTop >=0, discountPrice > discountMoney)
		//status == 0 (discountPrice ==0, discountMoney=0, eachMoneyTop=0)
		
		if(status == OpenConstant.DiscountStatus.valid_status) {
			validator(Double.parseDouble(discountPrice) <= 0, "订单金额每满只能为正数");
			validator(Double.parseDouble(discountMoney) <= 0, "减免只能为正数");
			validator(Double.parseDouble(eachMoneyTop) < 0, "减免上限只能为正数");
			discountPriceBig = new BigDecimal(discountPrice);
			discountMoneyBig = new BigDecimal(discountMoney);
			eachMoneyTopBig = new BigDecimal(eachMoneyTop);
			validator(discountPriceBig.compareTo(discountMoneyBig) <= 0, "每满金额应该大于减免金额");
			if(eachMoneyTopBig.compareTo(new BigDecimal(0))  > 0) {
				//有设置单个订单减免上限
				validator(eachMoneyTopBig.compareTo(discountMoneyBig) < 0, "减免金额应大于等于单个订单减免上限");
			}
			openStoreServiceDiscountService.update(serviceId, discountPriceBig, discountMoneyBig, eachMoneyTopBig, status);
		}else {
			openStoreServiceDiscountService.updateStatus(serviceId, status);
		}
		
		return Result.success();
	}
	
	
	/**
	 * @author:fukangwen @Description: 获取满减信息@throws
	 */
	@RequestMapping(value = { "/get_store_discount" })
	public Result<?> getStoreDiscount(@RequestParam(value = "serviceId", required = true) int serviceId) {
		validator(serviceId < 0, "参数有误");

		//  获取满减信息
		return Result.successData(openStoreServiceDiscountService.getDiscount(serviceId));
	}
}
