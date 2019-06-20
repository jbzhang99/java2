package com.rfchina.community.open.bridge.controller.community;

import java.math.BigDecimal;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.open.bridge.service.BusinessManagerAdminService;

//商家管理
@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_COMMUNITY)
public class BusinessManagerAdminController extends BaseController {

 

	@Autowired
	private BusinessManagerAdminService businessManagerAdminService;
	
	@RequestMapping("/listBusinessManagerAdmin")
	public Result<?> listBusinessManagerAdmin(@RequestParam(value = "id", required = false, defaultValue = "0") int id,
			@RequestParam(value = "category_second_type", required = false, defaultValue = "0") int category_second_type,
			@RequestParam(value = "service_title", required = false, defaultValue = "") String service_title,
			@RequestParam(value = "merchant_title", required = false, defaultValue = "") String merchant_title,
			// @RequestParam(value = "merchantId", required = false, defaultValue = "0") int
			// merchantId,
			// @RequestParam(value = "startCreateTime", required = false, defaultValue = "")
			// String startCreateTime,
			// @RequestParam(value = "endCreateTime", required = false, defaultValue = "")
			// String endCreateTime,
			// //保证金状态
			// @RequestParam(value = "cautionMoneyStatus", required = false, defaultValue =
			// "0") int cautionMoneyStatus,
			// //上架状态
			// @RequestParam(value = "groundAuditStatus", required = false, defaultValue =
			// "0") int groundAuditStatus,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) throws ParseException {
		 
		return Result.successData(businessManagerAdminService.businessManagerAdminList(category_second_type,service_title,merchant_title,index,size).convert());
	}
	
	//商家管理-拎包、自在e站、平台
	@RequestMapping("/listBusinessManager_{type}")
	public Result<?> listBusinessManager(
			@RequestParam(value = "type", required = true) int type,
			@RequestParam(value = "category_id", required = false, defaultValue = "0") int category_id,
			@RequestParam(value = "service_title", required = false, defaultValue = "") String service_title,
			@RequestParam(value = "merchant_title", required = false, defaultValue = "") String merchant_title,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) throws ParseException {
		 
		return Result.successData(businessManagerAdminService.businessManagerListByType(category_id,
				service_title,merchant_title,type,index,size).convert());
	}

	// ## 单个商家数据接口
	@RequestMapping("/getBusinessManagerAdmin")
	public Result<?> getBusinessManagerAdmin(@RequestParam(value = "id", required = true) int id) {
		return Result.successData(businessManagerAdminService.getBusinessManagerAdmin(id));
	}

	// ## 修改店铺分类功能
	@RequestMapping("/updateServiceByCategorySecondType")
	public Result<?> updateServiceByCategorySecondType(@RequestParam(value = "id", required = true) int id,
			@RequestParam(value = "categorySecondType", required = true) int CategorySecondType) {
		return Result.successData(businessManagerAdminService.updateServiceByCategorySecondType(id,CategorySecondType));
	}

	// ## 修改社区服务费功能
	@RequestMapping("/updateServiceByCommunityFee")
	public Result<?> updateServiceByCommunityFee(@RequestParam(value = "id", required = true) int id,
			@RequestParam(value = "communityFee", required = true) BigDecimal communityFee) {
		return Result.successData(businessManagerAdminService.updateServiceByCommunityFee(id,communityFee));
	}

	// ## 修改商品溢价幅度功能
	@RequestMapping("/updateServiceByPremiumNum")
	public Result<?> updateServiceByPremiumNum(@RequestParam(value = "id", required = true) int id,
			@RequestParam(value = "premiumNum", required = true) int premiumNum) {
		return Result.successData(businessManagerAdminService.updateServiceByPremiumNum(id,premiumNum));
	}

	// ## 商店停用启用功能
	@RequestMapping("/updateServiceByStatus")
	public Result<?> updateServiceByStatus(@RequestParam(value = "id", required = true) int id,
			@RequestParam(value = "status", required = true) Integer status) {
		return Result.successData(businessManagerAdminService.updateServiceByStatus(id,status));
	}

}
