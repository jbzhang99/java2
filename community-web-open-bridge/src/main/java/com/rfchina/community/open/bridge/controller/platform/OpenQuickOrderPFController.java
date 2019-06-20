package com.rfchina.community.open.bridge.controller.platform;

import java.text.ParseException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.MyUtils;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.service.openser.OpenQuickOrderSerService;

@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_PLATFORM)
public class OpenQuickOrderPFController extends BaseController {

	@Autowired
	private OpenQuickOrderSerService openQuickOrderService;

	@RequestMapping(value = { "/open_quick_order_pager" })
	public Result<?> goodPageQuery(

			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size,
			@RequestParam Map<String, Object> example
//			@RequestParam(value = "serviceId", required = false, defaultValue = "10") int serviceId,
//			@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword
	) throws ParseException {

		example.remove("size");
		example.remove("index");

		MyUtils.likeMap(example, "merchant_name", "service_name", "out_trade_no");
		return Result.successData(openQuickOrderService.listQuickOrder(example, index, size, false).convert());
	}

	@RequestMapping(value = { "/get_open_quick_order" })
	public Result<?> getData(Long id) throws ParseException {
		// 权限检查
		return Result.successData(openQuickOrderService.getQuickOrder(id, 0, 0L));
	}
}
