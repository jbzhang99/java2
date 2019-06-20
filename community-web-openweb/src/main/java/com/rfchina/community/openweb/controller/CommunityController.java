package com.rfchina.community.openweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.openweb.service.CommunityService;
import com.rfchina.community.persistence.model.OpenMerchantInfo;

@RestController
@RequestMapping(value = Constant.ROOT_PATH_OPENWEB)
public class CommunityController extends BaseController{

	@Autowired
	private CommunityService communityService;

	@RequestMapping("/community_list_area")
	public Result<?> getCommunityListByArea(@RequestParam("area_id") int areaId,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) {
		return Result.successData(communityService.getCommunityList(areaId, index, size).convert());
	}

	
	
	/**
	 * 有效城市
	 * @return
	 */
	@RequestMapping("/acc/city_by_community")
	public Result<?> searchCityByCommuntiy() {
		return Result.successData(communityService.searchCityByCommuntiy());
	}
	
	/**
	 * 核销有效城市
	 * @return
	 */
	@RequestMapping("/fee/community_list")
	public Result<?> getCommunityListByService(@RequestParam("serviceId") int serviceId,
			@RequestParam("areaId") int areaId) {
		return Result.successData(communityService.getCommunityListByfee(serviceId, areaId));
	}
	
	/**
	 * 核销有效社区
	 * @return
	 */
	@RequestMapping("/fee/city_by_service")
	public Result<?> searchCityByFee(@RequestParam("serviceId") int serviceId) {
		return Result.successData(communityService.searchCityByFee(serviceId));
	}

}
