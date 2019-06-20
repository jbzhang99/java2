package com.rfchina.community.open.bridge.controller.platform;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.open.bridge.service.OpenOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_PLATFORM)
public class OpenOrderPFController extends BaseController {

	@Autowired
	private OpenOrderService openOrderService;

	/**
	 * @Author wlrllr
	 * @Description //自在生活资金流水列表
	 * @Date 2019/1/3
	 * @Param [startCreateTime, endCreateTime, communityId, billStatus, billId, communityTradeNo, index, size]
	 * @return com.rfchina.community.base.Result<?>
	 **/
	@RequestMapping("/getTotalOrderList")
	public Result<?> getTotalOrderList(
			@RequestParam(value = "startCreateTime", required = false, defaultValue = "") String startCreateTime,
			@RequestParam(value = "endCreateTime", required = false, defaultValue = "") String endCreateTime,
			@RequestParam(value = "communityId", required = false, defaultValue = "0") int communityId,
			@RequestParam(value = "billStatus", required = false, defaultValue = "0") int billStatus,
			@RequestParam(value = "billId", required = false, defaultValue = "") String billId,
			@RequestParam(value = "refundStatus", required = false, defaultValue = "") String refundStatus,
			@RequestParam(value = "communityTradeNo", required = false, defaultValue = "") String communityTradeNo,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) {
		return Result.successData(openOrderService.getTotalOrderList(convertDate(startCreateTime), convertDate(endCreateTime), communityId,
				billStatus, billId, communityTradeNo,refundStatus, index, size).convert());
	}

	@RequestMapping("/getOpenOrder")
	public Result<?> getOpenOrder(
			@RequestParam(value = "serviceId", required = false, defaultValue = "0") int serviceId,
			@RequestParam(value = "outTradeNo", required = false, defaultValue = "") String outTradeNo,
			@RequestParam(value = "communityTradeNo", required = false, defaultValue = "") String communityTradeNo)
			{
		return Result.successData(openOrderService.getOpenOrder(serviceId, outTradeNo, communityTradeNo));
	}

	/**
	 * @Author wlrllr
	 * @Description //获取退款审核流程
	 * @Date 2019/1/4
	 * @Param [refundId]
	 * @return com.rfchina.community.base.Result<?>
	 **/
    @RequestMapping("/getRefundAuditList")
    public Result<?> getRefundAuditList(@RequestParam String refundId){
        return Result.successData(openOrderService.getRefundAuditList(refundId));
    }
}
