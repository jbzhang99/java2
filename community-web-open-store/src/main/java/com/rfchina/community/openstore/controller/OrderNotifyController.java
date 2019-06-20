package com.rfchina.community.openstore.controller;

import com.alibaba.fastjson.JSON;
import com.rfchina.community.base.Constant;
import com.rfchina.community.openstore.service.OpenStoreOrderPayService;
import com.rfchina.community.openstore.service.OpenStoreOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//回调逻辑
@RestController
@RequestMapping(value = Constant.ROOT_PATH_OPENSTORE)
public class OrderNotifyController extends BaseController {

	@Autowired
	private OpenStoreOrderService openStoreOrderService;
	@Autowired
	private OpenStoreOrderPayService openStoreOrderPayService;
	@Value("${good.automatic.praise.length}")
	private long automaticPraiseLength;

	@RequestMapping("/notify_url/{serviceId}")
	@ResponseBody
	public String testCallBack(@RequestParam Map<String, Object> map, @PathVariable int serviceId) {
		logger.info("testCallBack==213:serviceId:{},map:{}", serviceId, JSON.toJSONString(map));
		if (map.containsKey("trade_status")
				&& Constant.TradeStatus.TRADE_PAID_SUCCESS.equals(map.get("trade_status").toString())) {
			// 支付成功
			openStoreOrderService.updatePayStatus(map.get("out_trade_no").toString(), map.get("pay_time").toString(), map.get("pay_channel").toString());
			return "success";
		} else if (map.containsKey("trade_status")
				&& Constant.TradeStatus.TRADE_TIMEOUT_CLOSE.equals(map.get("trade_status").toString())) {
			// 支付超时
			openStoreOrderPayService.timeOutClose(map.get("out_trade_no").toString());
			return "success";
		} else if (map.containsKey("trade_status")
				&& Constant.TradeStatus.TRADE_PAID_FAILURE.equals(map.get("trade_status").toString())) {
			// 支付失败
			openStoreOrderPayService.payFailure(map.get("out_trade_no").toString());
			return "success";
		} else if (map.containsKey("trade_status")
				&& Constant.TradeStatus.TRADE_REFUND_SUCCESS.equals(map.get("trade_status").toString())) {
			// 退款成功
			openStoreOrderPayService.refund(map.get("out_trade_no").toString(), 2);
			return "success";
		} else if (map.containsKey("trade_status")
				&& Constant.TradeStatus.TRADE_REFUND_FAILURE.equals(map.get("trade_status").toString())) {
			// 退款失败
			openStoreOrderPayService.refund(map.get("out_trade_no").toString(), 3);
			return "success";
		}else if (map.containsKey("trade_status")
			&& Constant.TradeStatus.TRADE_SCANED_CODE.equals(map.get("trade_status").toString())) {
			// 已扫描，产品没需求，不做处理
			return "success";
		}

		logger.error("testCallBack==214:serviceId:{},map:{}", serviceId, JSON.toJSONString(map));
		return "error";
	}

}
