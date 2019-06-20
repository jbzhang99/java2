package com.rfchina.community.openweb.controller;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.openweb.service.CommunityServiceService;
import com.rfchina.community.openweb.service.OpenServiceDetailService;
import com.rfchina.community.openweb.service.OpenStoreServiceTempleteService;
import com.rfchina.community.persistence.mapper.AreaMapper;
import com.rfchina.community.persistence.model.Area;

/**
 */
@RestController
@RequestMapping(value = { Constant.ROOT_PATH_OPENWEB })
public class OpenStoreServiceTempleteController extends BaseController {

	@Autowired
	private OpenStoreServiceTempleteService openStoreServiceTempleteService;
	@Autowired
	private CommunityServiceService communityServiceService;
	@Autowired
	private OpenServiceDetailService openServiceDetailService;
	@Autowired
	private AreaMapper areaMapper;

	/**
	 * @author:fukangwen @Description: 新增或保存店铺资料 @throws
	 */
	@RequestMapping(value = { "/save_store_templete" })
	public Result<?> saveStoreTemplete(@RequestParam(value = "serviceId", required = true) int serviceId,
			@RequestParam(value = "expressMoney", required = false, defaultValue = "0") String expressMoney,
			@RequestParam(value = "phone", required = true) String phone,
			@RequestParam(value = "bannerUrl", required = false, defaultValue = "") String bannerUrl) {
		validator(serviceId < 0, "参数有误");
		validator(StringUtils.isBlank(expressMoney), "运费不能为空");
		validator(Double.parseDouble(expressMoney) < 0, "邮费不能为负数");
		validator(Double.parseDouble(expressMoney) > 10000, "邮费不能超过10000");
		validator(StringUtils.isBlank(phone), "请输入联系方式");
		// 图片最多5张
		String[] urls = bannerUrl.split(",");
		validator(urls.length > 5, "图片最多上传5张");

		// 权限检查
		authorityCheck(serviceId);

		// 判断模式是否是模板开发
		Boolean isTemplete = openServiceDetailService.isTemplete(serviceId);
		validator(!isTemplete, "只有模板开发才能生成店铺资料");

		openStoreServiceTempleteService.insertOrUpdate(serviceId, new BigDecimal(expressMoney), phone, bannerUrl, 0);

		return Result.success();
	}

	@RequestMapping(value = { "/save_store_address" })
	public Result<?> saveStoreAddress(@RequestParam(value = "serviceId", required = true) int serviceId,
			@RequestParam(value = "address_province", required = false, defaultValue = "0") int province,
			@RequestParam(value = "address_city", required = false, defaultValue = "0") int city,
			@RequestParam(value = "address_area", required = false, defaultValue = "0") int area,
			@RequestParam(value = "address_info", required = false, defaultValue = "") String address_info,
			@RequestParam(value = "open_time", required = false, defaultValue = "") String open_time,
			@RequestParam(value = "close_time", required = false, defaultValue = "") String close_time,
			@RequestParam(value = "store_pic", required = false, defaultValue = "") String store_pic) {
		validator(serviceId < 0, "参数有误");

		validator(province > 0 && areaMapper.selectByPrimaryKey(province) == null, "该省不存在");
		validator(city > 0 && areaMapper.selectByPrimaryKey(city) == null, "该市不存在");
		String address_all_info = address_info;
		if(area > 0) {
			Area areaRecord = areaMapper.selectByPrimaryKey(area);
			validator(areaRecord == null, "该区不存在");
			address_all_info = areaRecord.getMergerName() + address_all_info;
		}
		
		// 图片最多5张
		String[] urls = store_pic.split(",");
		validator(urls.length > 9, "图片最多上传9张");

		// 权限检查
		authorityCheck(serviceId);

		// 判断模式是否是模板开发
		Boolean isTemplete = openServiceDetailService.isTemplete(serviceId);
		validator(!isTemplete, "只有模板开发才能设置门店信息");

		int i = openStoreServiceTempleteService.insertOrUpdateAddress(serviceId, province, city, area, address_info,address_all_info,
				open_time, close_time, store_pic);

		return Result.successData(i);
	}

	/**
	 * @author:fukangwen @Description: 获取店铺资料 @throws
	 */
	@RequestMapping(value = { "/get_store_templete" })
	public Result<?> getStoreTemplete(@RequestParam(value = "serviceId", required = true) int serviceId) {
		validator(serviceId < 0, "参数有误");

		// 判断模式是否是模板开发
		Boolean isTemplete = openServiceDetailService.isTemplete(serviceId);
		validator(!isTemplete, "只有模板开发才能生成店铺资料");
		logger.info("getStoreTemplete: serviceId:{}",serviceId);
		return Result.successData(openStoreServiceTempleteService.getTemplete(serviceId));
	}

	/**
	 * @author:fukangwen @Description: 获取服务商店铺 @throws
	 */
	@RequestMapping(value = { "/get_service_templete_list" })
	public Result<?> getServiceTemplete(@RequestParam(value = "status", required = true) int status) {
		Long adminid = getAdminId();
		if (adminid < 0 || status < 0) {
			error("参数有误");
		}
		return Result.successData(openStoreServiceTempleteService.getTempleteList(adminid, status, null));
	}
	
	/**
	 * @author:fukangwen
	 *  @Description: 设置运费
	 *   @throws
	 */
	@RequestMapping(value = { "/save_express_money" })
	public Result<?> saveExpressMoney
		(@RequestParam(value = "serviceId", required = true) int serviceId,
		@RequestParam(value = "expressMoney", required = true) String expressMoney) {
		
		validator(serviceId < 0, "参数有误");
		validator(StringUtils.isBlank(expressMoney), "运费不能为空");
		validator(Double.parseDouble(expressMoney) < 0, "邮费不能为负数");
		validator(Double.parseDouble(expressMoney) > 10000, "邮费不能超过10000");

		// 权限检查
		authorityCheck(serviceId);

		openStoreServiceTempleteService.saveExpressMoney(serviceId, new BigDecimal(expressMoney));

		return Result.success();
	}

}
