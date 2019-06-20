package com.rfchina.community.openapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.OpenRefundConstant;
import com.rfchina.community.openapi.base.Result;
import com.rfchina.community.service.openser.OpenOrderSerService;

/**
 * @author liyicun 退款
 */
@RestController
@RequestMapping(value = Constant.ROOT_PATH_OPEN)
public class FuPayRefundController extends BaseController {

	@Autowired
	private OpenOrderSerService openOrderService;

	@Value("${app.environment}")
	private String environment;

	private static transient Logger logger = LoggerFactory.getLogger(FuPayRefundController.class);

	@RequestMapping("/pay_refund")
	public Result<?> payRefund(@RequestParam(value = "__app_id") long appId,
			@RequestParam(value = "out_trade_no", required = true) String outTradeNo,
			@RequestParam(value = "refund_reason", required = true) String refund_reason) throws Exception {
		int day = OpenConstant.public_BATCH_RUN_day;// 14;
		if ("test".equals(environment)) {
			// 测试环境1天后不能退款
			day = OpenConstant.TEST_BATCH_RUN;// 1;
		}
		logger.info("pay_refund:appId:{} outTradeNo:{},refund_reason:{},environment:{},day:{}", appId, outTradeNo,
				refund_reason, environment, day);
		openOrderService.payRefund(appId, outTradeNo, day, refund_reason,
				OpenRefundConstant.SameWayStatus.original);
		return Result.success("提交成功,订单转退款中.");
	}

}
