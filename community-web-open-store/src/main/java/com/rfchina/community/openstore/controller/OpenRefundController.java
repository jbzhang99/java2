package com.rfchina.community.openstore.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.openstore.service.OpenRefundService;
import com.rfchina.community.service.openser.OpenOrderSerService;

/**
 * 
 * @author fukangwen
 * 退款
 */
@RestController
@RequestMapping(value = { Constant.ROOT_PATH_OPENSTORE })
public class OpenRefundController extends BaseController {

	@Autowired
	private OpenRefundService openRefundService;
	@Autowired
	private OpenOrderSerService openOrderSerService;
	
	/**
	 * 提交退款申请
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = { "/refund_apply" })
	public Result<?> refundApply(
			@RequestParam(value = "access_token", required = true) String accessToken,
			@RequestParam(value = "store_order_id", required = true) int storeOrderId,
			@RequestParam(value = "reason_certificate", required = false) String reasonCertificate,
			@RequestParam(value = "refund_remark", required = false) String refundRemark,	//退款说明
			@RequestParam(value = "refund_comment", required = true) String refundComment //退款原因
			) throws ParseException {
		validateAndGetUid(null,accessToken);
		openRefundService.refundApply(storeOrderId, reasonCertificate,refundRemark, refundComment);
		return Result.success();
	}
	
	/**
	 * 退款详情
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = { "/get_refund_detail" })
	public Result<?> get_refund_detail(
			@RequestParam(value = "access_token", required = true) String accessToken,
			@RequestParam(value = "store_order_id", required = true) int storeOrderId
			) throws ParseException {
		validateAndGetUid(null,accessToken);
		return Result.successData(openOrderSerService.getRefundDetail(storeOrderId));
	}
}
