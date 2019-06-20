package com.rfchina.community.open.bridge.controller.platform;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.OpenConstant.CouponStatus;
import com.rfchina.community.base.Result;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.service.openser.CmStoreCouponService;

@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_PLATFORM)
public class CmStoreCouponPFController extends BaseController {

	@Autowired
	private CmStoreCouponService cmStoreCouponService;

	@RequestMapping(value = { "/store_coupon_page_list" })
	public Result<?> pageList(@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size,
			@RequestParam() Map<String, Object> example) {
//		Map<String, Object> example = null;
		return Result.successData(cmStoreCouponService.pageList(example, index, size).convert());
	}

	@RequestMapping(value = { "/store_coupon_update_status" })
	public Result<?> updateStoreCoupon(@RequestParam(value = "id", required = true) Long id,
			@RequestParam(value = "status", required = true) Integer status) {
		return Result.successData(cmStoreCouponService.updateStoreCoupon(id, CouponStatus.trun(status)));
	}

}
