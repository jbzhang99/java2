package com.rfchina.community.openweb.controller;

import java.text.ParseException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.service.openser.OpenQuickOrderSerService;

@RestController
@RequestMapping(value = Constant.ROOT_PATH_OPENWEB)
public class OpenQuickOrderController extends BaseController {

	@Autowired
	private OpenQuickOrderSerService openQuickOrderService;

	@RequestMapping(value = { "/open_quick_order_pager" })
	public Result<?> goodPageQuery(@RequestParam(value = "serviceId", required = true) int serviceId,

			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size,
			@RequestParam Map<String, Object> example
//			@RequestParam(value = "serviceId", required = false, defaultValue = "10") int serviceId,
//			@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword
	) throws ParseException {

		// 权限检查
		authorityCheck(serviceId);
		example.remove("size");
		example.remove("index");
		// 验证参数
		example.put("service_id", serviceId);

		return Result.successData(openQuickOrderService.listQuickOrder(example, index, size, true).convert());
	}

	@RequestMapping(value = { "/get_open_quick_order" })
	public Result<?> getData(@RequestParam(value = "serviceId", required = true) int serviceId, Long id)
			throws ParseException {
		// 权限检查
		authorityCheck(serviceId);
		return Result.successData(openQuickOrderService.getQuickOrder(id, serviceId, 0L));
	}
}
