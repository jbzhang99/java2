package com.rfchina.community.open.bridge.controller.platform;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.service.openser.OpenFeeOrderService;

/**
 */
@RestController
@RequestMapping(value = { OpenConstant.ROOT_PATH_PLATFORM })
public class OpenFeeOrderPFController extends BaseController {

	@Autowired
	private OpenFeeOrderService openFeeOrderService;

	@RequestMapping(value = { "/fee_store_order_add" })
	public Result<?> feeStoreOrderAddPf(@RequestParam(value = "serviceId", required = true) int serviceId,
			@RequestParam(value = "tradeAmount", required = true) BigDecimal tradeAmount,
			@RequestParam(value = "platformCharge", required = true) BigDecimal platformCharge,
			@RequestParam(value = "serviceCharge", required = true) BigDecimal serviceCharge,
			@RequestParam(value = "communityId", required = true) int communityId,
			@RequestParam(value = "orderExplain", required = true) String orderExplain) {
		return Result.successData(openFeeOrderService.feeStoreOrderAddPf(serviceId, tradeAmount, platformCharge,
				serviceCharge, communityId, orderExplain));
	}

	@RequestMapping(value = { "/fee_open_fee_order_list" })
	public Result<?> openFeeOrderList(@RequestParam(value = "service_id", required = false) Integer service_id,
			@RequestParam(value = "community_id", required = false) Integer community_id,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "pay_status", required = false) String pay_status,
			@RequestParam(value = "begin_create_time", required = false) String begin_create_time,
			@RequestParam(value = "end_create_time", required = false) String end_create_time,

			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "merchant_name", required = false) String merchant_name,
			@RequestParam(value = "service_name", required = false) String service_name,
			@RequestParam(value = "order_no", required = false) String order_no,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) throws ParseException {

		Map<String, Object> example = new HashMap<>();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (StringUtils.isNotBlank(begin_create_time)) {
			example.put("begin_create_time", DateTimeUtils.date000000(sdf.parse(begin_create_time.trim())));
		}
		if (StringUtils.isNotBlank(end_create_time)) {
			example.put("end_create_time", DateTimeUtils.date235959(sdf.parse(end_create_time.trim())));
		}
		if (StringUtils.isNotBlank(order_no)) {
			example.put("order_no", "%" + order_no + "%");
		}
		if (StringUtils.isNotBlank(merchant_name)) {
			example.put("merchant_name", "%" + merchant_name + "%");
		}

		if (StringUtils.isNotBlank(service_name)) {
			example.put("service_name", "%" + service_name + "%");
		}
		if (StringUtils.isNotBlank(pay_status)) {
			example.put("pay_status", pay_status);
		}if (StringUtils.isNotBlank(type)) {
			example.put("type", type);
		}

		example.put("id", id);
		example.put("community_id", community_id);
		example.put("service_id", service_id);
		PageBounds pageBounds = new PageBounds(index, size);

		return Result.successData(openFeeOrderService.openFeeOrderList(example, pageBounds).convert());
	}

	// success reject reject_reason
	@RequestMapping(value = { "/fee_update_pay_status" })
	public Result<?> updatePayStatus(
			@RequestParam(value = "__admin_id", required = false, defaultValue = "0") Long adminId2,
			@RequestParam(value = "__phone", required = false, defaultValue = "") String phone,
			@RequestParam(value = "__realname", required = false, defaultValue = "") String realname,
			@RequestParam(value = "pay_id", required = true) Long pay_id,
			@RequestParam(value = "status", required = true) String status,
			@RequestParam(value = "reject_reason", required = false) String reject_reason) throws ParseException {
		return Result.successData(
				openFeeOrderService.updatePayStatus(pay_id, status, reject_reason, adminId2, phone, realname));
	}

	@RequestMapping(value = { "/fee_get_open_fee_order_info" })
	public Result<?> getOpenFeeOrderInfo(@RequestParam(value = "id", required = false) Long id) throws ParseException {
		return Result.successData(openFeeOrderService.getOpenFeeOrderInfo(id, 0));
	}
}
