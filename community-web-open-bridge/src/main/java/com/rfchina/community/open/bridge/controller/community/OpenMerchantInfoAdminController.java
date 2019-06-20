package com.rfchina.community.open.bridge.controller.community;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.open.bridge.service.OpenMerchantInfoService;

@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_COMMUNITY)
public class OpenMerchantInfoAdminController extends BaseController {

	@Autowired
	private OpenMerchantInfoService openMerchantInfoService;

	@RequestMapping(value = { "/searchMerchantInfoList" }, method = { RequestMethod.POST })
	public Result<?> getMerchantInfoList(
			@RequestParam("keyword") String keyword) {
		return Result.successData(openMerchantInfoService.searchMerchantInfoList(keyword));
	}

}
