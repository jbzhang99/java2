package com.rfchina.community.open.bridge.controller.appapi;

import java.math.BigDecimal;
import java.util.*;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.base.OrderPayConstant;
import com.rfchina.community.open.bridge.service.OpenOrderService;
import com.rfchina.community.persistence.model.*;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.component.HttpClientComponent;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.persistence.mapper.CommunityServiceMapper;
import com.rfchina.community.persistence.mapper.OpenOrderMapper;
import com.rfchina.community.persistence.mapper.OpenOrderTotalMapper;
import com.rfchina.community.service.openser.OpenQuickOrderSerService;

@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_APP)
public class AppPayCallbackNewController extends BaseController {

	@Autowired
	private OpenOrderMapper openOrderMapper;
	@Autowired
	private OpenOrderTotalMapper openOrderTotalMapper;
	@Autowired
	private CommunityServiceMapper communityServiceMapper;
	@Autowired
	private HttpClientComponent httpClientComponent;
	@Autowired
	private OpenQuickOrderSerService openQuickOrderService;
	@Autowired
	private OpenOrderService openOrderService;

	// /api/app/open/bridgeapi/pay/callback
	@RequestMapping("/pay/callback_new")
	public String callback(@RequestParam() Map<String, String> map) throws Exception {
		logger.info("callback_new_map:{}", map);
		String billId = MapUtils.getString(map, "bill_id");
		String outTradeNo = MapUtils.getString(map, "out_trade_no", "");
		String notifyScene = MapUtils.getString(map, "notify_scene", "");
		Long payTime = MapUtils.getLong(map, "pay_time");
		String payChannel = MapUtils.getString(map, "pay_channel", "");
		// 修改第三方订单状态，并且回调第三方
		// 新版 回调
		if (outTradeNo.startsWith("life_")) {
			// notify_scene 是 回调场景类型, TRADE_PAID_SUCCESS: 用户支付成功,
			// TRADE_TIMEOUT_CLOSE:用户未付款超时关闭, TRADE_REFUND_SUCCESS:用户退款成功,
			// TRADE_REFUND_FAILURE: 用户退款失败, TRADE_SCANED_CODE: 订单已被扫码, APPLY_REFUND: 退款申请,
			// APPLY_SETTLEMENT：结算申请, APPLY_POST_BUSSINESS_BILLS: 申请业务对账数据
			OpenOrderTotal oot = getOpenOrderTotal(billId);
			validator(oot == null, "没有回调的支付订单号：" + billId);
			validator(!oot.getCommunityTradeNo().equals(outTradeNo), "业务订单号不一致：" + outTradeNo);
			Long totalId = oot.getId();
			List<OpenOrder> list = getOpenOrder(totalId);
			for (OpenOrder openOrder : list) {
				validator(!openOrder.getCommunityTradeNo().equals(outTradeNo), "子业务订单号不一致：" + outTradeNo);
				validator(!openOrder.getBillId().equals(billId), "子订单号不一致：" + billId);
			}
			int billStatus = Constant.BILL_STATUS_MAP.get(notifyScene);
			if ("TRADE_PAID_SUCCESS".equalsIgnoreCase(notifyScene)) {
				// TRADE_PAID_SUCCESS: 用户支付成功,
				updateOrderTotalStatus(totalId,billStatus,payChannel,payTime);
				updateOrderInfo(payChannel,totalId,billStatus,payTime,1);
				return callBackThird(list, map);
			} else if ("TRADE_TIMEOUT_CLOSE".equalsIgnoreCase(notifyScene)
					|| "TRADE_PAID_FAILURE".equalsIgnoreCase(notifyScene)) {
				// TRADE_TIMEOUT_CLOSE:用户未付款超时关闭,
				updateOrderTotalStatus(totalId,billStatus);
				updateOrderInfo(payChannel, totalId, billStatus,null,6);
				return callBackThird(list, map);
			} else if ("TRADE_SCANED_CODE".equalsIgnoreCase(notifyScene)) {
				// TRADE_SCANED_CODE: 订单已被扫码,
				if (oot.getBillStatus() == 2) {
					// 如果已经支付,没有必要支付了.
					return "success";
				}
				updateOrderTotalStatus(totalId,billStatus);
				updateOrderInfo(null,totalId,billStatus,null,6);
				return callBackThird(list, map);
			} else if ("TRADE_REFUND_SUCCESS".equalsIgnoreCase(notifyScene)) {
				// 退款成功
				String refund_bill_id = MapUtils.getString(map, "refund_bill_id", "-1");
				for (OpenOrder openOrder : list) {
					if (Objects.equals(openOrder.getRefundBillId(), refund_bill_id)) {
						OpenOrder record = new OpenOrder();
                        record.setRefundStatus(OrderPayConstant.RefundStatus.SUCCESS.getCode());
						record.setUpdateTime(new Date());
						record.setId(openOrder.getId());
						record.setRefundMoney(openOrder.getTotalAmount());
						record.setThinkCharge(BigDecimal.valueOf(0));
						record.setServiceCharge(BigDecimal.valueOf(0));
						record.setReceiptAmount(openOrder.getPlatformCharge().multiply(BigDecimal.valueOf(-1L)));
						openOrderService.updateRefundStatus(record);
						return callBackThird(Arrays.asList(openOrder), map);
					}
				}
			} else if ("TRADE_REFUND_FAILURE".equalsIgnoreCase(notifyScene)) {
				// 退款失败
				String refund_bill_id = MapUtils.getString(map, "refund_bill_id", "-1");
				for (OpenOrder openOrder : list) {
					if (Objects.equals(openOrder.getRefundBillId(), refund_bill_id)) {
						openOrderService.updateRefundStatusById(openOrder.getId(),OrderPayConstant.RefundStatus.FAILURE.getCode());
						return callBackThird(Arrays.asList(openOrder), map);
					}
				}
			}else {
				error("新字段类型不认识:" + notifyScene);
			}
			return "success";
		}
		return "failure";
	}


	@RequestMapping("/pay/refund/callback")
	public String callbackForRefund(@RequestParam() Map<String, String> map){
		logger.info("callbackForRefund_map:{}", map);
		String notifyScene = MapUtils.getString(map, "notify_scene", "");
       if ("REFUND_PROGRESS".equalsIgnoreCase(notifyScene)) {// 退款进度 3:退款审批成功 待财务确认
            dealRefundProgress(map);
		}else if ("APPLY_REFUND".equalsIgnoreCase(notifyScene)) {// 退款申请 1:退款审批中,待支付中心审批
		    dealApplyRefund(map);
		}
		return "success";
	}


	private void updateOrderInfo(String payChannel, Long totalId, int billStatus,Long payTime,Integer withdrawStatus) {
		OpenOrderExample example = new OpenOrderExample();
		example.createCriteria().andTotalIdEqualTo(totalId);
		OpenOrder record = new OpenOrder();
		record.setBillStatus(billStatus);
		record.setUpdateTime(new Date());
		record.setWithdrawStatus(withdrawStatus); // 不可提现
		if(StringUtils.isNotBlank(payChannel)){
			record.setPayChannel(payChannel);
		}
		if(payTime != null && payTime.longValue() != 0){
			record.setBillFinishedTime(new Date(payTime));
		}
		openOrderMapper.updateByExampleSelective(record, example);
	}

	public String callBackThird(List<OpenOrder> list, Map<String, String> map) {

		int countSuccess = 0;
		for (OpenOrder openOrder : list) {
			// 闪付回调的逻辑
			if (openOrder.getType() == 5) {
				countSuccess++;
				openQuickOrderService.exeQuick(list, map);
				continue;
			}
			// 回调第三方
			// 根据订单中的APPID查询对应的回调地址
			Map<String, String> params = new HashMap<>();

			params.put("out_trade_no", openOrder.getOutTradeNo());
			params.put("community_trade_no", openOrder.getCommunityTradeNo());
			params.put("pay_channel", MapUtils.getString(map, "pay_channel"));
			params.put("pay_time", MapUtils.getString(map, "pay_time"));

			params.put("total_amount", MapUtils.getString(map, "total_amount"));
			params.put("receipt_amount", MapUtils.getString(map, "receipt_amount"));// 收据
			params.put("refund_fee", MapUtils.getString(map, "refund_fee"));// 退款

			params.put("trade_status", MapUtils.getString(map, "trade_status"));
			params.put("notify_scene", MapUtils.getString(map, "notify_scene"));

			// 如果是三方的正常交易单，则需要回调第三方
			CommunityService communityService = communityServiceMapper.selectByPrimaryKey(openOrder.getServiceId());
			if (communityService == null) {
				logger.error(openOrder.getServiceId() + "对应的服务信息不存在");
			} else {
				// 返回结果
				String url = communityService.getNotifyUrl();
				logger.info("callback_new_map_beging:getServiceId:{} getNotifyUrl :{} : params{}",
						openOrder.getServiceId(), communityService.getNotifyUrl(), JSON.toJSONString(params));
				try {
					String str = HttpClientComponent.send(url, params, "UTF-8");
					logger.info("callback_new_map_end:getServiceId: {} url:{},str :{},params:{}",
							openOrder.getServiceId(), url, str, JSON.toJSONString(params));
					// 上线之前需要修改 目前测试的默认都返回正确
					if ("success".equals(str)) {
						countSuccess++;
					}
				} catch (Exception e) {
					logger.error("callback_new_map:url_error:" + openOrder.getServiceId() + "  " + url + "  "
							+ JSON.toJSONString(params), e);

				}

			}
		}
		String callBackStr = null;
		if (countSuccess == list.size()) {
			callBackStr = "success";
		} else {
			callBackStr = "failure";
		}
		logger.info("callback_new_map:{},countSuccess:{},size:{}", callBackStr, countSuccess, list.size());
		return callBackStr;
	}

	public OpenOrderTotal getOpenOrderTotal(String billId) {
		OpenOrderTotalExample example = new OpenOrderTotalExample();
		example.createCriteria().andBillIdEqualTo(billId);
		List<OpenOrderTotal> list = openOrderTotalMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public List<OpenOrder> getOpenOrder(Long totalId) {
		OpenOrderExample example = new OpenOrderExample();
		example.createCriteria().andTotalIdEqualTo(totalId);
		List<OpenOrder> list = openOrderMapper.selectByExample(example);
		return list;
	}


	private void updateOrderTotalStatus(Long totalId,Integer billStatus){
		updateOrderTotalStatus(totalId,billStatus,null,null);
	}

	private void updateOrderTotalStatus(Long totalId,Integer billStatus,String payChannel,Long payTime){
		OpenOrderTotal total = new OpenOrderTotal();
		total.setBillStatus(billStatus);
		total.setId(totalId);
		if(StringUtils.isNotBlank(payChannel)){
			total.setPayChannel(payChannel);
		}
		if(payTime != null && payTime.longValue() != 0){
			total.setBillFinishedTime(new Date(payTime));
		}
		openOrderTotalMapper.updateByPrimaryKeySelective(total);
	}

	/**
	 * @Author wlrllr
	 * @Description //退款申请  1:退款审批中,待支付中心审批
	 * "notify_data": "{
	 * 		"refund_id":"RFT201805038963399",//退款申请单号
	 * 		"refund_bills":[{"pay_bill_id":"00012599269956656",//支付单据号
	 * 	                 	"refund_bill_id":"00012859966636",//退款单据号
	 * 						"out_trade_no":""//业务商户订单号
	 * 				     }]
	 * 	   }
	 * @Date 2019/1/9
	 * @Param [map]
	 * @return void
	 **/
	//
    private void dealApplyRefund(Map<String, String> map){
		JSONObject data = JSONObject.parseObject(map.get("notify_data"));
		if(data != null && !data.isEmpty()){
			JSONArray refundBills = data.getJSONArray("refund_bills");
			if(refundBills != null && refundBills.size()>0){
				for(int i=0;i<refundBills.size();i++){
					JSONObject obj = refundBills.getJSONObject(i);
					String billId = obj.getString("pay_bill_id");
					String refundBillId = obj.getString("refund_bill_id");
					if(StringUtils.isNotBlank(billId)){
						openOrderService.updateRefundStatus(billId,refundBillId, OrderPayConstant.RefundStatus.PC_AUDITING.getCode());
					}
				}
			}
		}
	}

	/**
	 * @Author wlrllr
	 * @Description //退款进度回调，3:退款审批成功,　5:退款审批成功
	 * 数据结构{"list":[{"refund_id": "","refund_status": 3, "bill_id": ""}]} bill_id对应refund_bill_id
	 * @Date 2019/1/9
	 * @Param [map]
	 * @return void
	 **/
	//退款申请 3:退款审批中,待财务确认
	private void dealRefundProgress(Map<String, String> map){
		String data = map.get("notify_data");
		JSONObject notifyData = JSONObject.parseObject(data);
		JSONArray list = notifyData.getJSONArray("list");
		if(list != null && list.size()>0){
			for(int i=0;i<list.size();i++){
                 JSONObject obj = list.getJSONObject(i);
				 int refundStatus = obj.getIntValue("refund_status");
				 String refundBillId = obj.getString("bill_id");
                 if(3 == refundStatus && StringUtils.isNotBlank(refundBillId)){
					 openOrderService.updateRefundStatus(null,refundBillId, OrderPayConstant.RefundStatus.PC_CONFIRM.getCode());
				 }
			}
		}
	}
}
