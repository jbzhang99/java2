package com.rfchina.community.open.bridge.controller.community;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.open.bridge.mapper.ext.ExtOpenXFSJInfoBridgeMapper;

//小富市集
@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_COMMUNITY)
public class OpenXFSJSignUpController extends BaseController {

	@Autowired
	private ExtOpenXFSJInfoBridgeMapper extOpenXFSJInfoBridgeMapper;

	// 综合服务费订单
	@RequestMapping("/generalServiceOrder")
	public Result<?> generalServiceOrder(
			@RequestParam(value = "cityId", required = false, defaultValue = "0") int cityId,
			@RequestParam(value = "communityIds", required = false, defaultValue = "0") int communityIds,
			@RequestParam(value = "bill_status", required = false, defaultValue = "-1") int bill_status,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size,
			@RequestParam(value = "create_time_begin", required = false) String create_time_begin,
			@RequestParam(value = "create_time_end", required = false) String create_time_end,
			@RequestParam(value = "merchant_title", required = false) String merchant_title,
			@RequestParam(value = "service_title", required = false) String service_title,
			@RequestParam(value = "act_titile", required = false) String act_titile,
			@RequestParam(value = "bill_id", required = false) String bill_id) throws Exception {

		// 支付状态
		// 商家名称
		// 店铺/服务名称
		// 活动名称
		// 订单号

		Map<String, Object> param = new HashMap<>();

		if (cityId > 0) {
			param.put("cityId", cityId);
		}
		if (communityIds > 0) {
			param.put("communityIds", communityIds);
		}
		if (bill_status > -1) {
			param.put("bill_status", bill_status);
		}
		if (StringUtils.isNotBlank(create_time_begin)) {
			param.put("create_time_begin", create_time_begin);
		}
		if (StringUtils.isNotBlank(create_time_end)) {
			param.put("create_time_end", create_time_end);
		}
		if (StringUtils.isNotBlank(merchant_title)) {
			param.put("merchant_title", "%" + merchant_title + "%");
		}
		if (StringUtils.isNotBlank(service_title)) {
			param.put("service_title", "%" + service_title + "%");
		}
		if (StringUtils.isNotBlank(act_titile)) {
			param.put("act_titile", "%" + act_titile + "%");
		}
		if (StringUtils.isNotBlank(bill_id)) {
			param.put("bill_id", "%" + bill_id + "%");
		}

		PageBounds pageBounds = new PageBounds(index, size);
		PageList<Map<String, Object>> pager = extOpenXFSJInfoBridgeMapper.generalServiceOrder(param, pageBounds);

		return Result.successData(pager.convert());
	}

}
