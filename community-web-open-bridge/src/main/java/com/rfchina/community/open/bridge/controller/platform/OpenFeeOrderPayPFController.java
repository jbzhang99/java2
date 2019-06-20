package com.rfchina.community.open.bridge.controller.platform;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.rfchina.community.service.openser.OpenFeeOrderPayService;
import com.rfchina.community.service.openser.OpenFeeOrderService;

/**
 */
@RestController
@RequestMapping(value = { OpenConstant.ROOT_PATH_PLATFORM })
public class OpenFeeOrderPayPFController extends BaseController {

	@Autowired
	private OpenFeeOrderPayService openFeeOrderPayService;

	/**
	 * @throws ParseException @author:fukangwen @Description: 商家缴费记录 @return
	 * Result<?> @throws
	 */
	@RequestMapping(value = { "/list_fee_order_pay" })
	public Result<?> listFeeOrderPay(@RequestParam(value = "serviceId", required = false) Integer serviceId,
			@RequestParam(value = "merchantName", required = false, defaultValue = "") String merchantName,
			@RequestParam(value = "payStatus", required = false, defaultValue = "") String payStatus,
			@RequestParam(value = "outTradeNo", required = false, defaultValue = "") String outTradeNo,
			@RequestParam(value = "startCreateTime", required = false, defaultValue = "") String startCreateTime,
			@RequestParam(value = "endCreateTime", required = false, defaultValue = "") String endCreateTime,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date startCreateDate = null;
		Date endCreateDate = null;

		if (StringUtils.isNotBlank(startCreateTime)) {
			startCreateDate = DateTimeUtils.date000000(sdf.parse(startCreateTime.trim()));
		}

		if (StringUtils.isNotBlank(endCreateTime)) {
			endCreateDate = DateTimeUtils.date235959(sdf.parse(endCreateTime.trim()));
		}

		return Result.successData(openFeeOrderPayService.listFeeOrderPay(serviceId, merchantName, payStatus, outTradeNo,
				startCreateDate, endCreateDate, index, size).convert());
	}

	/**
	 * @author:fukangwen @Description: 商家缴费记录详情 @return Result<?> @throws
	 */
	@RequestMapping(value = { "/get_fee_order_pay_detail" })
	public Result<?> getFeeOrderPayDetail(
			@RequestParam(value = "feeOrderPayId", required = true) long feeOrderPayId) {
		return Result.successData(openFeeOrderPayService.getFeeOrderPayDetail(feeOrderPayId));
	}
}
