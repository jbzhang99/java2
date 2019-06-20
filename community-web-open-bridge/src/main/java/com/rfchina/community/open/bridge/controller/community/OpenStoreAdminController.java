package com.rfchina.community.open.bridge.controller.community;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.open.bridge.service.CommunityServiceInfoService;
import com.rfchina.community.open.bridge.service.OpenStoreGoodService;

/**
 * @author:fukangwen
 * @Description: 店铺、商品
 */
@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_COMMUNITY)
public class OpenStoreAdminController {

	@Autowired
	private OpenStoreGoodService openStoreGoodService;
	@Autowired
	private CommunityServiceInfoService communityServiceInfoService;

	/**
	 * 有效店铺
	 * @return
	 */
	@RequestMapping("/list_store")
	public Result<?> listStore(@RequestParam(value = "storeName", required = false, defaultValue="") String storeName,
			@RequestParam(value = "type", required = false, defaultValue="0") Integer type,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) {
		return Result.successData(communityServiceInfoService.listStore(storeName,type, index, size));
	}
	
	/**
	 * 有效的商品
	 * @return
	 */
	@RequestMapping("/list_store_good")
	public Result<?> listStoreGood(@RequestParam(value = "serviceId", required = false, defaultValue="0") int serviceId,
			@RequestParam(value = "goodName", required = false, defaultValue="") String goodName,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) {
		return Result.successData(openStoreGoodService.listStoreGood(serviceId, goodName, index, size));
	}

}
