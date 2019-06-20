package com.rfchina.community.openweb.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.paginator.model.Order;
import org.mybatis.paginator.model.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.HttpUtil;
import com.rfchina.community.component.IdComponent;
import com.rfchina.community.service.openser.OpenFeeOrderService;

/**
 */
@RestController
@RequestMapping(value = { Constant.ROOT_PATH_OPENWEB })
public class OpenFeeOrderController extends BaseController {

	@Autowired
	private OpenFeeOrderService openFeeOrderService;

	@RequestMapping(value = { "/store_order_verify" })
	public Result<?> storeOrderVerifyPre(@RequestParam(value = "serviceId", required = true) int serviceId,
			@RequestParam(value = "storeOrderId", required = true) int storeOrderId,
			@RequestParam(value = "goodsDetail", required = true) String goods_detail,
			@RequestParam(value = "pre", defaultValue = "true") boolean pre) {
		authorityCheck(serviceId);
		return Result.successData(openFeeOrderService.storeOrderVerifyPre(serviceId, storeOrderId, goods_detail, pre));
	}

	@RequestMapping(value = { "/fee/open_fee_order_list" })
	public Result<?> openFeeOrderList(@RequestParam(value = "service_id", required = true) Integer service_id,
			@RequestParam(value = "community_id", required = false) Integer community_id,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "pay_status", required = false) String pay_status,
			@RequestParam(value = "begin_create_time", required = false) String begin_create_time,
			@RequestParam(value = "end_create_time", required = false) String end_create_time,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) throws ParseException {
		authorityCheck(service_id);
		Map<String, Object> example = new HashMap<>();
		example.put("service_id", service_id);
		example.put("type", type);
		example.put("community_id", community_id);
		example.put("pay_status", pay_status);
		example.put("begin_create_time", begin_create_time);
		example.put("end_create_time", end_create_time);
		PageBounds pageBounds = new PageBounds(index, size);

		return Result.successData(openFeeOrderService.openFeeOrderList(example, pageBounds).convert());
	}

	@RequestMapping(value = { "/fee/update_sales_contract" })
	public Result<?> updateOpenFeeBySalesContract(
			@RequestParam(value = "service_id", required = true) Integer service_id,
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "sales_contract", required = false) String salesContract) throws ParseException {
		authorityCheck(service_id);
		return Result.successData(openFeeOrderService.updateOpenFeeBySalesContract(id, salesContract, service_id));
	}

	@RequestMapping(value = { "/fee/order_pay_by_img_link" })
	public Result<?> payImgLink(@RequestParam(value = "service_id", required = true) Integer service_id,
			@RequestParam(value = "ids", required = true) String ids,
			@RequestParam(value = "img_link", required = true) String imgLink) {
		authorityCheck(service_id);
		return Result.successData(openFeeOrderService.payImgLink(ids, service_id, imgLink));
	}

	@RequestMapping(value = { "/fee/order_pay_by_online" })
	public Result<?> payByOnline(@RequestParam(value = "service_id", required = true) Integer service_id,
			@RequestParam(value = "ids", required = true) String ids,
			@RequestParam(value = "pay_channel", required = true) String payChannel, HttpServletRequest request) {
		authorityCheck(service_id);
		String ip = HttpUtil.getIp2(request);
		return Result.successData(openFeeOrderService.payByOnline(ids, service_id, payChannel, ip, null));
	}

	@RequestMapping(value = { "/fee/order_pay_by_online_h5" })
	public Result<?> payByOnlineH5(@RequestParam(value = "service_id", required = true) Integer service_id,
			@RequestParam(value = "ids", required = true) String ids,
			@RequestParam(value = "pay_channel", required = true) String payChannel,
			@RequestParam(value = "redirectUrl", required = true) String redirectUrl, HttpServletRequest request) {
		authorityCheck(service_id);
		String ip = HttpUtil.getIp2(request);
		return Result.successData(openFeeOrderService.payByOnline(ids, service_id, payChannel, ip, redirectUrl));
	}

	@RequestMapping(value = { "/fee/fee_get_open_fee_order_info" })
	public Result<?> getOpenFeeOrderInfo(@RequestParam(value = "service_id", required = true) Integer service_id,
			@RequestParam(value = "id", required = false) Long id) throws ParseException {
		authorityCheck(service_id);
		return Result.successData(openFeeOrderService.getOpenFeeOrderInfo(id, service_id));
	}
}
