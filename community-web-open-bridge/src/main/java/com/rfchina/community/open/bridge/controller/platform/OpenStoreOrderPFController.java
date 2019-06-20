package com.rfchina.community.open.bridge.controller.platform;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.OpenRefundConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.ValidatorUtil;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.open.bridge.entity.ExtOpenStoreOrder;
import com.rfchina.community.open.bridge.service.OpenRefundService;
import com.rfchina.community.open.bridge.service.OpenStoreOrderService;
import com.rfchina.community.service.openser.OpenOrderSerService;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.Page;
import org.mybatis.paginator.model.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 */
@RestController
@RequestMapping(value = {OpenConstant.ROOT_PATH_PLATFORM})
public class OpenStoreOrderPFController extends BaseController {

	@Autowired
	private OpenStoreOrderService openStoreOrderService;
	@Autowired
	private OpenRefundService openRefundService;
	@Autowired
	private OpenOrderSerService openOrderSerService;

	/**
	 * 
	订单状态：退款状态：商家名称：店铺名称：服务订单号：支付单号：下单时间：开始时间至结束时间：流水ID
	 * @throws ParseException
	 * @author:fukangwen @Description: 订单管理 @return Result<?> @throws
	 */
	@RequestMapping(value = {"/listOpenStoreOrderList"})
	public Result<?> listOpenStoreOrderList(
			@RequestParam(value = "goodId", required = false, defaultValue = "0") long goodId,
			@RequestParam(value = "communityId", required = false, defaultValue="0") int communityId,//社区id
			@RequestParam(value = "serviceId", required = false, defaultValue="0") int serviceId,//服务id
			@RequestParam(value = "merchantId", required = false, defaultValue="0") long merchantId,	// 商家id
			@RequestParam(value = "sendStatus", required = false) Integer sendStatus,	//发送状态
			@RequestParam(value = "payStatus", required = false) Integer payStatus,	//支付状态：
			@RequestParam(value = "refundStatus", required = false) Integer refundStatus,	//退款状态
			@RequestParam(value = "orderCode", required = false) String orderCode,	//流水id
			@RequestParam(value = "outTradeNo", required = false) String outTradeNo,	//服务订单号
			@RequestParam(value = "orderType", required = false) String orderType,	//订单类型
			@RequestParam(value = "startCreateTime", required = false, defaultValue = "") String startCreateTime,
			@RequestParam(value = "endCreateTime", required = false, defaultValue = "") String endCreateTime,
			@RequestParam(value = "commentStatus", required = false, defaultValue = "") String commentStatus,
			@RequestParam(value = "groupStatus", required = false) Integer groupStatus,	//团购状态
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) throws ParseException {
		Map<String, Object> param = getParamMap(goodId, communityId, serviceId, merchantId, sendStatus, payStatus, refundStatus, orderCode,
				outTradeNo, startCreateTime, endCreateTime,commentStatus, groupStatus);
		PageBounds pageBounds = new PageBounds(index, size);
		Page<ExtOpenStoreOrder> orderList = openStoreOrderService.pageQuery(param, pageBounds);
		Map<String, Object> map = new HashMap<>();
		map.put("orderList", orderList);
		map.put("total", orderList.getTotal());
		param.put("payStatus", 1);//支付状态成功
		map.put("successTotalMoney", openStoreOrderService.getSuccessTotalMoney(param));
		return Result.successData(map);
	}

	/**
	 * @Author wlrllr
	 * @Description //构建查询条件
	 * @Date 2019/1/4
	 * @Param [goodId, communityId, serviceId, merchantId, sendStatus, payStatus, refundStatus, orderCode, outTradeNo, startCreateTime, endCreateTime]
	 * @return java.util.Map<java.lang.String,java.lang.Object>
	 **/
	private Map<String, Object> getParamMap(long goodId, int communityId, int serviceId, long merchantId, Integer sendStatus, Integer payStatus, Integer refundStatus,
											String orderCode,String outTradeNo, String startCreateTime,  String endCreateTime,String commentStatus, Integer groupStatus) throws ParseException {
		Date startCreateDate = convertDate(startCreateTime);
		Date endCreateDate = convertDate(endCreateTime);
		Map<String, Object> param = new HashMap<>();
		if (serviceId != 0) {
			param.put("serviceId", serviceId);
		}
		if (goodId != 0) {
			param.put("goodId", goodId);
		}
		if (merchantId != 0) {
			param.put("merchantId", merchantId);
		}
		if (communityId != 0) {
			param.put("communityId", communityId);
		}
		if (payStatus != null) {
			param.put("payStatus", payStatus);
		}
		if (sendStatus != null) {
			param.put("sendStatus", sendStatus);
		}
		if (refundStatus != null) {
			param.put("refundStatus", refundStatus);
		}
		if (StringUtils.isNotBlank(orderCode)) {
			param.put("orderCode", "%" + orderCode + "%");
		}
		if (StringUtils.isNotBlank(outTradeNo)) {
			param.put("outTradeNo", "%" + outTradeNo + "%");
		}
		if (startCreateDate != null) {
			param.put("startCreateDate", startCreateDate);
		}
		if (endCreateDate != null) {
			param.put("endCreateDate", endCreateDate);
		}
		if(StringUtils.isNotBlank(commentStatus)){
			param.put("commentStatus", commentStatus);
		}
		if(groupStatus != null){
			param.put("groupStatus", groupStatus);
		}
		return param;
	}


	@RequestMapping(value = {"/listOpenStoreOrderListByGoodId"})
	public Result<?> listOpenStoreOrderListByGoodId(
			@RequestParam(value = "goodId") Long goodId,//商品id
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) throws ParseException {
		Map<String, Object> param = new HashMap<>();
		if (goodId != 0) {
			param.put("goodId", goodId);
		} 
		PageBounds pageBounds = new PageBounds(index, size);
		
		return Result.successData(openStoreOrderService.pageQuery(param, pageBounds));
		}
	
	/**
	 * @author:fukangwen
	 * @Description: 手续费详情
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/get_transfer_charge_detail")
	public Result<?> getTransferChargeDetail(
			@RequestParam(value="openStoreOrderId") int openStoreOrderId){
		return Result.successData(openStoreOrderService.getTransferChargeDetail(openStoreOrderId));
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 订单详情
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/get_open_store_order_detail")
	public Result<?> getOpenStoreOrderDetail(
			@RequestParam(value="openStoreOrderId") int openStoreOrderId){
		return Result.successData(openStoreOrderService.getOpenStoreOrderDetail(openStoreOrderId));
	}
	
	
	/**
	 * 
	订单状态：退款状态：商家名称：店铺名称：服务订单号：支付单号：下单时间：开始时间至结束时间：流水ID
	 * @throws ParseException
	 * @author:fukangwen @Description: 导出@return Result<?> @throws
	 * @throws IOException 
	 */
	@RequestMapping(value = "/export_open_store_order_list")
	public void exportOpenStoreOrderList(
			@RequestParam(value = "communityId", required = false, defaultValue="0") int communityId,//社区id
			@RequestParam(value = "serviceId", required = false, defaultValue="0") int serviceId,//服务id
			@RequestParam(value = "merchantId", required = false, defaultValue="0") long merchantId,	// 商家id
			@RequestParam(value = "sendStatus", required = false) Integer sendStatus,	//发送状态
			@RequestParam(value = "payStatus", required = false) Integer payStatus,	//支付状态：
			@RequestParam(value = "orderCode", required = false) String orderCode,	//流水id
			@RequestParam(value = "outTradeNo", required = false) String outTradeNo,	//服务订单号
			@RequestParam(value = "refundStatus", required = false) Integer refundStatus,	//退款状态
			@RequestParam(value = "startCreateTime", required = false, defaultValue = "") String startCreateTime,
			@RequestParam(value = "endCreateTime", required = false, defaultValue = "") String endCreateTime,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size,
			@RequestParam(value = "commentStatus", required = false, defaultValue = "") String commentStatus,
			@RequestParam(value = "groupStatus", required = false) Integer groupStatus,	//团购状态
			HttpServletResponse response) throws ParseException, IOException {
		Map<String, Object> param = getParamMap(0, communityId, serviceId, merchantId, sendStatus, payStatus, refundStatus,
				orderCode,outTradeNo, startCreateTime, endCreateTime,commentStatus, groupStatus);
		// 生成文件
		openStoreOrderService.createOpenOrderWorkBook(param, response);
			
	}

	/**
	 * @author:fukangwen
	 * @Description: 订单详情
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/platform_refund")
	public Result<?> platformRefund(
			@RequestParam(value = "store_order_id", required = true) int storeOrderId,
			@RequestParam(value = "same_way", required = true) int sameWay,	//1原路，2非原路
			@RequestParam(value = "refund_comment", required = true) String refundComment, //退款原因
			@RequestParam(value = "reason_certificate", required = false) String reasonCertificate,	//退款凭证
			@RequestParam(value = "refund_remark", required = false, defaultValue="") String refundRemark,	//退款说明
			
			@RequestParam(value = "confirm_letter", required = false, defaultValue="") String confirmLetter,	//非原路退款时必需, 确认函
			@RequestParam(value = "id_card_front", required = false, defaultValue="") String idCardFront,	//非原路退款时必需,身份证正面
			@RequestParam(value = "id_card_rear", required = false, defaultValue="") String idCardFear,	//非原路退款时必需,身份证反面
			@RequestParam(value = "name", required = false, defaultValue="") String name,	//非原路退款时必需, 姓名，最长64位字符串
			@RequestParam(value = "account_type", required = false, defaultValue="1") int accountType,	//非原路退款时必需, 1: 银行账号, 2:支付宝账号
			@RequestParam(value = "deposit_bank", required = false, defaultValue="") String depositBank,	//非原路退款时必需, 开户行, 如果是支付宝账号请填支付宝, 否收填写实际银行名称，最长256位字符串
			@RequestParam(value = "account_no", required = false, defaultValue="") String accountNo,	//非原路退款时必需, 银行账号或支付宝账号
			@RequestParam(value = "account_pic", required = false, defaultValue="") String accountPic	//非原路退款时必需, 账号或支付宝用户首页图片
			){
		
		//参数判断
		if(OpenRefundConstant.SameWayStatus.no_original == sameWay) {
			ValidatorUtil.verify(confirmLetter, "确认函", true, 1, 512);
			ValidatorUtil.verify(idCardFront, "身份证正面", true, 1, 128);
			ValidatorUtil.verify(idCardFear, "身份证反面", true, 1, 128);
			ValidatorUtil.verify(name, "开户名", true, 1, 64);
			ValidatorUtil.verify(depositBank, "开户银行", true, 1, 256);
			ValidatorUtil.verify(accountNo, "银行账号", true, 1, 256);
			ValidatorUtil.verify(accountPic, "银行卡正面", true, 1, 128);
		}
		
		//进入service
		openRefundService.refund(storeOrderId, sameWay, refundComment, reasonCertificate,
				confirmLetter, idCardFront, idCardFear, name, depositBank, accountNo, accountPic);
		return Result.success();
	}
	
	/**
	 * 退款详情
	 * @return
	 */
	@RequestMapping(value = { "/get_refund_detail" })
	public Result<?> getRefundRetail(@RequestParam(value = "id") int id) {
		return Result.successData(openRefundService.getRefundDetailAndAuditList(id));
	}

}
