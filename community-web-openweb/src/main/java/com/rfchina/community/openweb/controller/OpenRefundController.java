package com.rfchina.community.openweb.controller;

import com.rfchina.community.base.*;
import com.rfchina.community.base.OpenConstant.OpenStoreRefundStatus;
import com.rfchina.community.openweb.service.OpenRefundService;
import com.rfchina.community.openweb.service.OpenStoreOrderService;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.OpenStoreOrder;
import com.rfchina.community.service.openser.OpenOrderSerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;

@RestController
@RequestMapping(value = Constant.ROOT_PATH_OPENWEB)
public class OpenRefundController extends BaseController {
	
	@Value("${app.environment}")
	private String environment;
	@Autowired
	private OpenStoreOrderService openStoreOrderService;
	@Autowired
	private OpenOrderSerService openOrderSerService;
	@Autowired
	private OpenRefundService openRefundService;
	
	/**
	 * 
	 * @Description: 订单退款 @throws
	 */
	@RequestMapping(value = { "/good_order_refund" })
	public Result<?> goodOrderRefund(@RequestParam(value = "id", required = true) int orderId,
			@RequestParam(value = "refundComment", required = true) String refundComment) throws ParseException {
		Long adminid = getAdminId();
		validator(adminid < 0, "参数有误");
		if (refundComment.length() > 128) {
			refundComment = refundComment.substring(0, 128);
		}
		OpenStoreOrder openStoreOrder = openStoreOrderService.getOpenStoreOrder(orderId);
		// 权限检查
		CommunityService ser = authorityCheck(openStoreOrder.getServiceId());
		String outTradeNo = openStoreOrder.getOutTradeNo();
		validator(StringUtils.isBlank(outTradeNo), "支付单号为空,不能发起退款" + orderId);
		validator(openStoreOrder.getRefundStatus() == OpenStoreRefundStatus.ing.getCode(), "退款中不用重复发起");
		validator(openStoreOrder.getRefundStatus() == OpenStoreRefundStatus.Success.getCode(),
				"退款成功,不能发起");
		//除微信支付宝，暂不支持原路退回方式
		validator(OpenConstant.PayChannel.UnionPay.equals(openStoreOrder.getPayChannel()), "暂不支持该支付方式的退款,请联系管理员");
		
		Long appId = ser.getAppId();
		int day = OpenConstant.refund_store_day;// 14;

		if ("test".equals(environment)) {
			// 测试环境1天后不能退款
			day = OpenConstant.TEST_BATCH_RUN;// 1;
		}
		logger.info("pay_refund:appId:{} outTradeNo:{},refund_reason:{},environment:{},day:{}", appId, outTradeNo,
				refundComment, environment, day);
		int flag = openOrderSerService.payRefund(appId, outTradeNo, day, refundComment,
				OpenRefundConstant.SameWayStatus.original);

		if (flag > 0) {
			openStoreOrder.setRefundStatus(OrderPayConstant.RefundStatus.PC_UPPING.getCode());
			openStoreOrder.setRefundTime(new Date());
			openStoreOrder.setRefundComment(refundComment);
			openStoreOrder.setRefundApproval("");
			openStoreOrder.setRefundRemark("");
			openStoreOrder.setSameWay(OpenRefundConstant.SameWayStatus.original);
			openStoreOrderService.save(openStoreOrder);
		}
		return Result.success();
	}

	
	/**
	 * 
	 * @Description: 订单退款审核通过 @throws
	 */
	@RequestMapping(value = { "/refund_audit_pass" })
	public Result<?> refundAuditPass(@RequestParam(value = "id", required = true) int orderId) throws ParseException {
		Long adminid = getAdminId();
		validator(adminid < 0, "参数有误");
		OpenStoreOrder openStoreOrder = openStoreOrderService.getOpenStoreOrder(orderId);
		// 权限检查
		CommunityService ser = authorityCheck(openStoreOrder.getServiceId());

		String outTradeNo = openStoreOrder.getOutTradeNo();
		validator(StringUtils.isBlank(outTradeNo), "支付单号为空,不能发起退款" + orderId);
		validator(openStoreOrder.getRefundStatus() != OpenStoreRefundStatus.user_apply.getCode(), "订单不在商家审核状态");
		validator(openStoreOrder.getRefundStatus() == OpenStoreRefundStatus.Success.getCode(),
				"退款成功,不能发起");
		
		//除微信支付宝，暂不支持原路退回方式
		validator(OpenConstant.PayChannel.UnionPay.equals(openStoreOrder.getPayChannel()), "暂不支持该支付方式的退款,请联系管理员");
		
		Long appId = ser.getAppId();
		int day = OpenConstant.refund_store_day;// 14;

		if ("test".equals(environment)) {
			// 测试环境1天后不能退款
			day = OpenConstant.TEST_BATCH_RUN;// 1;
		}
		logger.info("pay_refund:appId:{} outTradeNo:{},environment:{},day:{}", appId, outTradeNo,
				 environment, day);
		int flag = openOrderSerService.payRefund(appId, outTradeNo, day, openStoreOrder.getRefundComment(),
				OpenRefundConstant.SameWayStatus.original);

		if (flag > 0) {
			openStoreOrder.setRefundStatus(OrderPayConstant.RefundStatus.PC_UPPING.getCode());
			openStoreOrder.setRefundTime(new Date());
			openStoreOrder.setRefundApproval("");
			openStoreOrderService.save(openStoreOrder);
			openStoreOrder.setSameWay(OpenRefundConstant.SameWayStatus.original);
		}
		return Result.success();
	}
	
	/**
	 * 
	 * @Description: 订单退款审核拒绝@throws
	 */
	@RequestMapping(value = { "/refund_audit_reject" })
	public Result<?> refundAuditReject(@RequestParam(value = "id", required = true) int orderId,
									   @RequestParam(value = "refundApproval", required = true) String refundApproval) throws ParseException {
		Long adminid = getAdminId();
		validator(adminid < 0, "参数有误");
		if (refundApproval.length() > 128) {
			refundApproval = refundApproval.substring(0, 128);
		}
		OpenStoreOrder openStoreOrder = openStoreOrderService.getOpenStoreOrder(orderId);
		// 权限检查
		authorityCheck(openStoreOrder.getServiceId());

		String outTradeNo = openStoreOrder.getOutTradeNo();
		validator(StringUtils.isBlank(outTradeNo), "支付单号为空,不能发起退款" + orderId);
		validator(openStoreOrder.getRefundStatus() == OpenStoreRefundStatus.ing.getCode(), "该订单正在退款中");
		validator(openStoreOrder.getRefundStatus() == OpenStoreRefundStatus.Success.getCode(),
				"退款成功,不能发起");
		openRefundService.auditReject(openStoreOrder.getId(), refundApproval);
		return Result.success();
	}
	
	/**
	 * 退款详情
	 * @return
	 */
	@RequestMapping(value = { "/get_refund_detail" })
	public Result<?> getRefundDetail(
			@RequestParam(value = "id") int id
			) {
		return Result.successData(openOrderSerService.getRefundDetail(id));
	}
}
