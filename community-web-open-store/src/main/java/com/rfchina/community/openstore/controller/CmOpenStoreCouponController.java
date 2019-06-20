package com.rfchina.community.openstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.openstore.service.CmOpenStoreCouponService;
import com.rfchina.community.service.openser.CmStoreCouponRecordService;
import com.rfchina.community.service.openser.CmStoreCouponService;

@RestController
@RequestMapping(value = Constant.ROOT_PATH_OPENSTORE)
public class CmOpenStoreCouponController extends BaseController {

	@Autowired
	private CmOpenStoreCouponService cmOpenStoreCouponService;
	@Autowired
	private CmStoreCouponService cmStoreCouponService;
	@Autowired
	private CmStoreCouponRecordService cmStoreCouponRecordService;
	
	/**
	 * 领券
	 */
	@RequestMapping("/receive_store_coupon_record")
	public Result<?> receiveStoreCouponRecord(
			@RequestParam(value = "serviceId", required = true) int serviceId,
			@RequestParam(value = "couponItemId", required = true) long couponItemId,
			@RequestParam(value = "accessToken", required = true) String accessToken
			) {
		Long uid = validateAndGetUid(null, accessToken);
		cmOpenStoreCouponService.receiveStoreCoupon(uid, couponItemId, serviceId);
		return Result.success();
	}
	
	
	/**
	 * 店铺列表
	 */
	@RequestMapping("/open_store_coupon_list")
	public Result<?> openStoreCouponList(
			@RequestParam(value = "serviceId", required = true) int serviceId
			) {
		return Result.successData(cmOpenStoreCouponService.getValidStoreCouponList(serviceId));
	}
	
	
	/**
	 * 券详情
	 */
	@RequestMapping("/open_store_coupon_detail")
	public Result<?> openStoreCouponDetail(
			@RequestParam(value = "couponItemId", required = true) long couponItemId,
			@RequestParam(value = "accessToken", required = true) String accessToken
			) {
		validateAndGetUid(null, accessToken);
		return Result.successData(cmStoreCouponService.getStoreCouponInfo(couponItemId));
	}
	
	/**
	 * 我的卡券列表 -- 暂时没用，还有问题，分页需要用open_store自己的分页器，需要 重新写一个
	 */
	@RequestMapping("/user_coupon_record_list")
	public Result<?> userCouponRecordList(
			@RequestParam(value = "index", required = false, defaultValue="1") int index,
			@RequestParam(value = "limit", required = false, defaultValue="10") int limit,
			@RequestParam(value = "status", required = false, defaultValue="0") int status,
			@RequestParam(value = "accessToken", required = true) String accessToken
			) {
		Long uid = validateAndGetUid(null, accessToken);
		return Result.successData(cmStoreCouponRecordService.userCouponRecordList(uid, status, index, limit));
	}
	
	
	
}
