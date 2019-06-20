package com.rfchina.community.service.openser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.rfchina.api.request.pay.FuPaySplitBillRequestV2.RefundItem;
import com.rfchina.api.request.pay.FuPaySplitBillRequestV2.SplitDataModel;
import com.rfchina.api.response.ResponseData;
import com.rfchina.api.response.model.pay.FuPayGetBillDetailResponseModel2;
import com.rfchina.api.response.model.pay.FuPaySplitBillResponseModel2;
import com.rfchina.api.response.model.pay.base.FuPayBillModel2;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.openapi.ExtAppMoney;
import com.rfchina.community.base.openapi.ExtAppMoneyTotal;
import com.rfchina.community.component.PlatformGlobalComponent;
import com.rfchina.community.persistence.mapper.OpenOrderMapper;
import com.rfchina.community.persistence.mapper.OpenOrderTotalMapper;
import com.rfchina.community.persistence.mapper.PayConfirmRecordMapper;
import com.rfchina.community.persistence.model.OpenOrder;
import com.rfchina.community.persistence.model.OpenOrderExample;
import com.rfchina.community.persistence.model.OpenOrderTotal;
import com.rfchina.community.persistence.model.PayConfirmRecord;
import com.rfchina.community.service.BaseService;
import com.rfchina.community.service.openser.entity.SettleConfirm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class OpenServiceTotalBillSplitService extends BaseService {

	private static Logger logger = LoggerFactory.getLogger(OpenServiceTotalBillSplitService.class);

	@Autowired
	private OpenOrderMapper openOrderMapper;
	@Autowired
	private OpenOrderTotalMapper openOrderTotalMapper;
	@Autowired
	private PayConfirmRecordMapper payConfirmRecordMapper;
	@Autowired
	private PlatformGlobalComponent platformGlobalComponent;

	public void splitBillTotal(Long id) {
		OpenOrderTotal total = openOrderTotalMapper.selectByPrimaryKey(id);
		splitBillTotal(total, true);
	}

	public void splitBillTotal(OpenOrderTotal total, boolean flag) {
		try {
			_splitBillTotal(total);
		} catch (Exception e) {
			logger.error("{}", JSON.toJSONString(total));
			logger.error(e.getMessage(), e);
			if (flag) {
				throw e;
			}
		}
	}

	// 拆单的时候,只能一个单执行,防止重复执行
	private synchronized void _splitBillTotal(OpenOrderTotal total) {
		validator(total == null, "data is null");
		Long totalId = total.getId();
		String billId = total.getBillId();
		validator(total.getBillStatus() != 2, "未支付,不能拆单");
		validator(total.getBillSplitStatus() != 2, "拆单状态不对,不能重复拆单操作");

		ResponseData<FuPayGetBillDetailResponseModel2> data = platformGlobalComponent.getBillDetail2(billId);
		logger.info("BillDetail2:{}", JSON.toJSONString(data));
		validator(data.getCode() != 1001, data.getCode() + ":" + data.getMsg());
		// 查询订单详情信息
		FuPayGetBillDetailResponseModel2 model = data.getData();
		validator(model.getBalanceStatus() != 2, "支付中心的渠道没有对账");
		validator(model.getBussinessBalanceStatus() != 2, "支付中心的业务没有对账");
		validator(total.getBillSplitStatus() != 2, "已经拆过单");
		OpenOrderExample example = new OpenOrderExample();
		example.createCriteria().andTotalIdEqualTo(totalId);
		List<OpenOrder> list = openOrderMapper.selectByExample(example);
		ExtAppMoneyTotal mTotal = new ExtAppMoneyTotal();
		List<ExtAppMoney> moneyList = new ArrayList<>();
		for (OpenOrder openOrder : list) {
			validator(openOrder.getRefundStatus() == OpenConstant.open_order.RefundStatus.REFUND_AUDIT, "退款中不能拆单" + openOrder.getId());
			validator(openOrder.getRefundStatus() == OpenConstant.open_order.RefundStatus.REFUND_STORE_AUDIT, "商家审批中不能拆单" + openOrder.getId());
			ExtAppMoney money = new ExtAppMoney(openOrder.getTotalAmount(),
					openOrder.getPlatformChargeRate(), openOrder.getServiceChargeRate(), openOrder.getThinkChargeRate(),
					openOrder.getRefundStatus() == 2 ? 1 : 0);
			money.setAccountId(openOrder.getAccountId());
			money.setThinkAccountId(openOrder.getThinkAccountId());
			money.setOpenOrderId(openOrder.getId());
			money.setRefundBillId(openOrder.getRefundBillId());
			moneyList.add(money);
		}
		mTotal.setMoneys(moneyList);
		String communityAccountId = total.getCommunityAccountId();
		mTotal.setCommunityAccountId(communityAccountId);
		mTotal.build();


		for (ExtAppMoney string : mTotal.getMoneys()) {
			logger.info("{}", string);
		}
		logger.info("{}", mTotal);

		// 新的时间 0和1，false true
		int isExtend = 0;
		List<SplitDataModel> splitDataList = new ArrayList<>();
		List<SettleConfirm> confirmList = new ArrayList<>();

		for (ExtAppMoney child : mTotal.getMoneys()) {
			List<RefundItem> refundItems = new ArrayList<>();
			if (child.getIsRefund() > 0) {
				RefundItem r1 = new RefundItem(cent(child.getRefundUser()), child.getRefundBillId());
				refundItems.add(r1);
			}
			if (refundItems.isEmpty()) {
				refundItems = null;
			}

			//商家
			SplitDataModel e = new SplitDataModel(child.getAccountId(), cent(child.getSplitAmount()),
					"child_" + child.getOpenOrderId(), cent(child.getRefundUser()), cent(child.getPlatformCharge()),
					isExtend, refundItems);
			splitDataList.add(e);

			//思力
			if(child.getThinkCharge().compareTo(BigDecimal.valueOf(0)) > 0) {
				SplitDataModel thinkModel = new SplitDataModel(child.getThinkAccountId(), cent(child.getThinkCharge()),
						"think_"+ child.getOpenOrderId(), 0L, 0L, isExtend, null);
				splitDataList.add(thinkModel);
			}

			//社区
			if(child.getServiceCharge().compareTo(BigDecimal.valueOf(0)) > 0) {
				SplitDataModel communityModel = new SplitDataModel(mTotal.getCommunityAccountId(), cent(child.getServiceCharge()),
						"community_"+ child.getOpenOrderId(), 0L, 0L, isExtend, null);
				splitDataList.add(communityModel);
			}
		}



		ResponseData<FuPaySplitBillResponseModel2> datas = platformGlobalComponent.splitBill2(billId, splitDataList);
		validator(datas.getCode() != 1001, JSON.toJSONString(datas));

		FuPaySplitBillResponseModel2 splitModel = datas.getData();
		for (FuPayBillModel2 bm : splitModel) {
			String splitId = bm.getSplitId();
				String[] splits= splitId.split("_");
				long openStoreId = Long.valueOf(splits[1]);
				for (ExtAppMoney child : mTotal.getMoneys()) {
					long id = child.getOpenOrderId();
					if(openStoreId != id){
						return;
					}
					OpenOrder openOrder = new OpenOrder();
					openOrder.setId(id);
					if (splitId.startsWith("child")) {
						openOrder.setMerchantBillId(bm.getBillId());
						// 更新订单信息
						openOrder.setBalanceStatus(2);
						// '是否拆单，1：是，2：否',
						openOrder.setBillSplitStatus(1);

//						openOrder.setBillSplitTime(bm.getSuccessTime());
						openOrder.setSplitAmount(child.getSplitAmount());
						// 服务费
						openOrder.setServiceChargeStatus(2);

						List<FuPayBillModel2> refundModel = bm.getRefundList();
						if(refundModel != null && refundModel.size() > 0){
							openOrder.setRefundSubBillId(refundModel.get(0).getBillId());
						}
						openOrderMapper.updateByPrimaryKeySelective(openOrder);

						SettleConfirm confirm = new SettleConfirm();
						confirm.setBill_id(bm.getBillId());
						confirm.setType(1);//1支付，2退款
						if(child.getIsRefund() > 0){
							SettleConfirm refundConfirm = new SettleConfirm();
							confirm.setBill_id(openOrder.getRefundSubBillId());
							confirm.setType(2);//1支付，2退款
							List<SettleConfirm> refundConfirmList = new ArrayList<>();
							refundConfirmList.add(refundConfirm);
							confirm.setRefund_bill_list(refundConfirmList);
						}
						confirmList.add(confirm);

					}else if(splitId.startsWith("think")){
						openOrder.setThinkBillId(bm.getBillId());
						openOrderMapper.updateByPrimaryKeySelective(openOrder);

						SettleConfirm confirm = new SettleConfirm();
						confirm.setBill_id(bm.getBillId());
						confirm.setType(1);//1支付，2退款
						confirmList.add(confirm);

					}else if(splitId.startsWith("community")){
						openOrder.setServiceChargeBillId(bm.getBillId());
						openOrderMapper.updateByPrimaryKeySelective(openOrder);
						SettleConfirm confirm = new SettleConfirm();
						confirm.setBill_id(bm.getBillId());
						confirm.setType(1);//1支付，2退款
						confirmList.add(confirm);
					}
				}
		}

		OpenOrderTotal r = new OpenOrderTotal();
		r.setId(totalId);
		r.setUpdateTime(new Date());
		r.setTotalReceiptAmount(mTotal.getReceiptAmountTotal());
		r.setTotalToReceiptAmount(mTotal.getToReceiptAmountTotal());
		r.setTotalRefundMoney(mTotal.getRefundUserTotal());
		r.setTotalServiceCharge(mTotal.getServiceChargeTotal());
		r.setTotalToServiceCharge(mTotal.getToServiceChargeTotal());
		r.setRefundCount(mTotal.getRefund_count());
		r.setSplitAmount(mTotal.getSplitAmount());
		r.setTotalThinkAmount(mTotal.getToThinkAmountTotal());
		total.setBillSplitStatus(1);
		openOrderTotalMapper.updateByPrimaryKeySelective(r);

		if(confirmList.isEmpty()) {
			return;
		}
		Map<String, Object> respData = null;
		List<SettleConfirm> subList = new ArrayList<SettleConfirm>();
		Boolean flag = true;//total确认状态
		for(int i = 0; i < confirmList.size(); i++) {
			subList.add(confirmList.get(i));
			if(subList.size() % 50 == 0){
				respData = this.settleConfirm(subList);
				if(respData == null){
					flag = false;
				}
				subList.clear();
			}
		}

		if(subList.size() > 0){
			respData = this.settleConfirm(subList);
			if(respData == null){
				flag = false;
			}
		}

		// 更新total确认时间,即入账时间
		if(flag) {
			Date date = (Date) respData.get("settlable_time");
			updateTotalBillSpiltTime(total, date);
		}
	}

	private void updateTotalBillSpiltTime(OpenOrderTotal total, Date date){
		total.setBillSplitTime(date);
		openOrderTotalMapper.updateByPrimaryKeySelective(total);
	}

	private Map<String, Object> settleConfirm(List<SettleConfirm> confirmList){
		//拆单完成后确认单据为可结算
		String bills = JSONArray.toJSONString(confirmList).toString();
		logger.info("确认单据为可结算：{}", bills);
		ResponseData<Map<String, Object>> resp = platformGlobalComponent.settleConfirm(bills);
		insertByConfirmList(confirmList, resp.getCode(), resp.getMsg());
		if(resp.getCode() == 1001){
			List<String> billIdList = new ArrayList<String>();
			for(SettleConfirm confirm : confirmList){
				billIdList.add(confirm.getBill_id());
			}
			OpenOrderExample example = new OpenOrderExample();
			example.createCriteria().andMerchantBillIdIn(billIdList);
			OpenOrder record = new OpenOrder();
			//更新订单确认时间
			SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", java.util.Locale.US);

			Date date = null;
			try {
				date = sdf.parse(String.valueOf(resp.getData().get("settlable_time")));
			}catch (ParseException e){
				e.printStackTrace();
			}

			record.setBillSplitTime(date);
			// WithdrawStatus ,1未到提现时间,2可提现,3提现审批中 ,4提现成功,5提现失败,6不可提现
			record.setWithdrawStatus(2);
			openOrderMapper.updateByExampleSelective(record, example);

			return resp.getData();
		}
		return null;
	}

	/**
	 *	新增
	 * @param confirmList
	 */
	private void insertByConfirmList(List<SettleConfirm> confirmList, int code, String message){
		for(SettleConfirm confirm : confirmList){
			PayConfirmRecord record = payConfirmRecordMapper.selectByPrimaryKey(confirm.getBill_id());
			if(record == null){
				this.insertPayConfirmRecord(confirm.getBill_id(), null, confirm.getType(), code, message);
			}

			if(confirm.getRefund_bill_list() != null && confirm.getRefund_bill_list().size() > 0){
				SettleConfirm refundConfirm = confirm.getRefund_bill_list().get(0);
				PayConfirmRecord refundRecord = payConfirmRecordMapper.selectByPrimaryKey(refundConfirm.getBill_id());
				if(refundRecord == null){
					this.insertPayConfirmRecord(refundConfirm.getBill_id(), confirm.getBill_id(), refundConfirm.getType(), code, message);
				}
			}
		}
	}

	private void insertPayConfirmRecord(String billId, String origBillId, int type, int code, String message){
		PayConfirmRecord record = new PayConfirmRecord();
		record.setScanStatus(1);//0为未扫描，1为已扫描
		record.setResultStatus(code);
		if(code != 1001){
			record.setScanStatus(0);//0为未扫描，1为已扫描,不为1001，说明确认失败
		}
		record.setBillId(billId);
		record.setCreateTime(new Date());
		record.setScanTime(new Date());
		record.setOrigBillId(origBillId);
		record.setType(type);
		record.setRemark(message);
		payConfirmRecordMapper.insertSelective(record);
	}

	private long cent(BigDecimal money) {
		return money.multiply(new BigDecimal("100")).longValue();
	}
}
