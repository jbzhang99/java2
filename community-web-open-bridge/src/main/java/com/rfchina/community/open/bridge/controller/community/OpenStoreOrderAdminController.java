package com.rfchina.community.open.bridge.controller.community;

import com.alibaba.fastjson.JSONArray;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.open.bridge.entity.ExtOpenStoreOrder;
import com.rfchina.community.open.bridge.service.OpenStoreOrderService;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.Page;
import org.mybatis.paginator.model.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 */
@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_COMMUNITY)
public class OpenStoreOrderAdminController extends BaseController {

	@Autowired
	private OpenStoreOrderService openStoreOrderService;

	/**
	 * 

订单状态：退款状态：商家名称：店铺名称：服务订单号：支付单号：下单时间：开始时间至结束时间：流水ID
type= wuye, type=xfsj, type=platform, type=estation
	 * @throws ParseException
	 * @author:fukangwen @Description: 订单管理 @return Result<?> @throws
	 */
	@RequestMapping("/listOpenStoreOrderList_{type}")
	public Result<?> listOpenStoreOrderList(
			@RequestParam(value = "type", required = true, defaultValue="") String type,//
			@RequestParam(value = "communityIdList", required = false, defaultValue="") String communityIdList,//改账户权限下的所有社区idList json
			@RequestParam(value = "communityId", required = false, defaultValue="0") int communityId,//社区id
			@RequestParam(value = "serviceId", required = false, defaultValue="0") int serviceId,//服务id
			@RequestParam(value = "merchantId", required = false, defaultValue="0") long merchantId,	// 商家id
			@RequestParam(value = "sendStatus", required = false) Integer sendStatus,	//发送状态
			@RequestParam(value = "refundStatus", required = false) Integer refundStatus,	//退款状态
			@RequestParam(value = "payStatus", required = false) Integer payStatus,	//支付状态：
			@RequestParam(value = "orderCode", required = false) String orderCode,	//流水id
			@RequestParam(value = "outTradeNo", required = false) String outTradeNo,	//服务订单号
			@RequestParam(value = "startCreateTime", required = false, defaultValue = "") String startCreateTime,
			@RequestParam(value = "endCreateTime", required = false, defaultValue = "") String endCreateTime,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date startCreateDate = null;
		Date endCreateDate = null;
		if (StringUtils.isNotBlank(startCreateTime)) {
			startCreateDate = sdf.parse(startCreateTime);
		}
		if (StringUtils.isNotBlank(endCreateTime)) {
			endCreateDate = sdf.parse(endCreateTime);
		}
		Map<String, Object> param = new HashMap<>();
		param.put("type", type);
		if(StringUtils.isNotBlank(communityIdList)) {
			param.put("communityIdList", StringUtils.join(JSONArray.parseArray(communityIdList, Integer.class).toArray(), ","));
		}
		if (serviceId != 0) {
			param.put("serviceId", serviceId);
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
		if (refundStatus != null) {
			param.put("refundStatus", refundStatus);
		}
		if (sendStatus != null) {
			param.put("sendStatus", sendStatus);
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
	 * @author:fukangwen @Description: 导出 @return Result<?> @throws
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@RequestMapping(value = "/export_open_store_order_list_{type}")
	public void exportOpenStoreOrderList(
			@RequestParam(value = "type", required = true, defaultValue="") String type,//
			@RequestParam(value = "communityIdList", required = false, defaultValue="") String communityIdList,//改账户权限下的所有社区idList json
			@RequestParam(value = "communityId", required = false, defaultValue="0") int communityId,//社区id
			@RequestParam(value = "serviceId", required = false, defaultValue="0") int serviceId,//服务id
			@RequestParam(value = "merchantId", required = false, defaultValue="0") long merchantId,	// 商家id
			@RequestParam(value = "sendStatus", required = false) Integer sendStatus,	//发送状态
			@RequestParam(value = "payStatus", required = false) Integer payStatus,	//支付状态：
			@RequestParam(value = "refundStatus", required = false) Integer refundStatus,	//退款状态
			@RequestParam(value = "orderCode", required = false) String orderCode,	//流水id
			@RequestParam(value = "outTradeNo", required = false) String outTradeNo,	//服务订单号
			@RequestParam(value = "startCreateTime", required = false, defaultValue = "") String startCreateTime,
			@RequestParam(value = "endCreateTime", required = false, defaultValue = "") String endCreateTime,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size,
			@RequestParam(value = "commentStatus", required = false, defaultValue = "") String commentStatus,
			@RequestParam(value = "groupStatus", required = false) Integer groupStatus,	//团购状态
			HttpServletResponse response) throws ParseException, FileNotFoundException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date startCreateDate = null;
		Date endCreateDate = null;
		if (StringUtils.isNotBlank(startCreateTime)) {
			startCreateDate = sdf.parse(startCreateTime);
		}
		if (StringUtils.isNotBlank(endCreateTime)) {
			endCreateDate = sdf.parse(endCreateTime);
		}
		Map<String, Object> param = new HashMap<>();
		param.put("type", type);
		if(StringUtils.isNotBlank(communityIdList)) {
			param.put("communityIdList", StringUtils.join(JSONArray.parseArray(communityIdList, Integer.class).toArray(), ","));
		}
		if (serviceId != 0) {
			param.put("serviceId", serviceId);
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
		if (refundStatus != null) {
			param.put("refundStatus", refundStatus);
		}
		if (sendStatus != null) {
			param.put("sendStatus", sendStatus);
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
		// 生成文件
		openStoreOrderService.createOpenOrderWorkBook(param, response);
	}

}
