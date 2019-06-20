package com.rfchina.community.openweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.service.openser.CmStoreCouponRecordService;
import com.rfchina.community.service.openser.CmStoreCouponService;

@RestController
@RequestMapping(value = Constant.ROOT_PATH_OPENWEB)
public class CmStoreCouponRecordController extends BaseController {

	@Autowired
	private CmStoreCouponRecordService cmStoreCouponRecordService;

	@Autowired
	private CmStoreCouponService cmStoreCouponService;

	@RequestMapping(value = { "/store_coupon_record_page_list" })
	public Result<?> pageList(@RequestParam(value = "service_id", required = true) int service_id,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size, Long coupon_id) {
		authorityCheck(service_id);
//		example.put("service_id", service_id+"");
//		MyUtils.likeMap(example, "merchant_name","service_name","coupon_name");
		cmStoreCouponService.checkCoupon(coupon_id, service_id);
//		Map<String, Object> example = null;
		return Result.successData(cmStoreCouponRecordService.pageList(coupon_id, index, size, true).convert());
	}

}
