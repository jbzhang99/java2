package com.rfchina.community.open.bridge.controller.platform;

import java.io.IOException;

import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rfchina.api.response.ResponseData;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.component.PlatformGlobalComponent;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.service.openser.OpenServiceTotalBillSplitService;
import com.rfchina.community.service.openser.OpenServiceTotalSyncService;

/**
 */
@Controller
@RequestMapping(value = OpenConstant.ROOT_PATH_PLATFORM)
public class PaymentCenterController extends BaseController {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private PlatformGlobalComponent platformGlobalComponent;
	@Autowired
	private OpenServiceTotalBillSplitService openServiceTotalBillSplitService;
	@Autowired
	private OpenServiceTotalSyncService openServiceTotalSyncService;

	@RequestMapping(value = { "/center_refundBillCallbackList" }, method = { RequestMethod.POST })
	@ResponseBody
	public Result<?> refundBillCallbackList(@RequestParam(value = "id", required = true) String refundId)
			throws ServletException, IOException {
		ResponseData<?> json = platformGlobalComponent.refundBillCallbackList(refundId);
		return Result.successData(json);
	}

	@RequestMapping(value = { "/center_getBillDetail" }, method = { RequestMethod.POST })
	@ResponseBody
	public Result<?> getBillDetail(@RequestParam(value = "id", required = true) String billId)
			throws ServletException, IOException {
		ResponseData<?> json = platformGlobalComponent.getBillDetail(billId);
		return Result.successData(json);
	}

	@RequestMapping(value = { "/center_getBillDetail2" }, method = { RequestMethod.POST })
	@ResponseBody
	public Result<?> getBillDetail2(@RequestParam(value = "id", required = true) String billId)
			throws ServletException, IOException {
		ResponseData<?> json = platformGlobalComponent.getBillDetail2(billId);
		return Result.successData(json);
	}

	@RequestMapping(value = { "/center_getRefundDetail" }, method = { RequestMethod.POST })
	@ResponseBody
	public Result<?> getRefundDetail(@RequestParam(value = "id", required = true) String refundId)
			throws ServletException, IOException {
		ResponseData<?> json = platformGlobalComponent.getRefundDetail(refundId);
		return Result.successData(json);
	}

	@RequestMapping(value = { "/center_refundRevoke" }, method = { RequestMethod.POST })
	@ResponseBody
	public Result<?> refundRevoke(@RequestParam(value = "id", required = true) String refundId)
			throws ServletException, IOException {
		ResponseData<?> res = platformGlobalComponent.refundRevoke(refundId);
		return Result.successData(res);
	}

	@RequestMapping(value = { "/center_getRefundBillDetail" }, method = { RequestMethod.POST })
	@ResponseBody
	public Result<?> getRefundBillDetail(@RequestParam(value = "id", required = true) String refundBillId)
			throws ServletException, IOException {
		ResponseData<?> json = platformGlobalComponent.getRefundBillDetail(refundBillId);
		return Result.successData(json);
	}

	@RequestMapping(value = { "/center_splitBillTotal" }, method = { RequestMethod.POST })
	@ResponseBody
	public Result<?> splitBillTotal(@RequestParam(value = "id", required = true) Long id)
			throws ServletException, IOException {
		openServiceTotalBillSplitService.splitBillTotal(id);
		return Result.successData(id);
	}

	@RequestMapping(value = { "/center_syncOrderTotal" }, method = { RequestMethod.POST })
	@ResponseBody
	public Result<?> syncOrderTotal(@RequestParam(value = "id", required = true) Long id)
			throws ServletException, IOException {
		openServiceTotalSyncService.syncOrderTotal(id);
		return Result.successData(id);
	}

}
