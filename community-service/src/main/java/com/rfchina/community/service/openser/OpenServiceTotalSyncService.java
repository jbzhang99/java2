package com.rfchina.community.service.openser;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.rfchina.api.response.ResponseData;
import com.rfchina.api.response.model.pay.FuPayGetBillDetailResponseModel2;
import com.rfchina.api.response.model.pay.base.FuPayBillModel2;
import com.rfchina.community.base.openapi.ExtAppMoney;
import com.rfchina.community.base.openapi.ExtAppMoneyTotal;
import com.rfchina.community.component.PlatformGlobalComponent;
import com.rfchina.community.persistence.mapper.OpenOrderMapper;
import com.rfchina.community.persistence.mapper.OpenOrderTotalMapper;
import com.rfchina.community.persistence.model.OpenOrder;
import com.rfchina.community.persistence.model.OpenOrderExample;
import com.rfchina.community.persistence.model.OpenOrderTotal;
import com.rfchina.community.persistence.model.OpenOrderTotalExample;
import com.rfchina.community.service.BaseService;

@Service
public class OpenServiceTotalSyncService extends BaseService {

	private static Logger logger = LoggerFactory.getLogger(OpenServiceTotalSyncService.class);

	@Autowired
	private OpenOrderMapper openOrderMapper;
	@Autowired
	private OpenOrderTotalMapper openOrderTotalMapper;

	@Autowired
	private PlatformGlobalComponent platformGlobalComponent;

	public void syncOrderTotal() {
		OpenOrderTotalExample example = new OpenOrderTotalExample();
		example.createCriteria().andBillStatusEqualTo(2).andPfBalanceStatusNotEqualTo(2)
				.andBillFinishedTimeLessThanOrEqualTo(new Date(System.currentTimeMillis() - 10 * 3600 * 1000L));
		example.or().andBillStatusEqualTo(2).andPfBussinessBalanceStatusNotEqualTo(2)
				.andBillFinishedTimeLessThanOrEqualTo(new Date(System.currentTimeMillis() - 10 * 3600 * 1000L));
		example.or().andBillStatusEqualTo(2).andPfBussinessBalanceStatusNotEqualTo(2)
				.andBillFinishedTimeLessThanOrEqualTo(new Date(System.currentTimeMillis() - 10 * 3600 * 1000L));
		example.or().andBillStatusIn(Arrays.asList(1, 8))
				.andCreateTimeLessThan(new Date(System.currentTimeMillis() - 3600 * 1000L));

		List<OpenOrderTotal> list = openOrderTotalMapper.selectByExample(example);
		logger.info("size:{}", list.size());
		for (OpenOrderTotal order : list) {
			try {
				syncOrderTotal(order);
			} catch (Exception e) {
				logger.error("{}", JSON.toJSONString(order));
				logger.error(e.getMessage(), e);
			}

		}
	}

	public void syncOrderTotal(Long id) {
		OpenOrderTotal total = openOrderTotalMapper.selectByPrimaryKey(id);
		syncOrderTotal(total);
	}

	public void syncOrderTotal(OpenOrderTotal total) {
		OpenOrderExample example = new OpenOrderExample();
		example.createCriteria().andTotalIdEqualTo(total.getId());
		List<OpenOrder> childOrder = openOrderMapper.selectByExample(example);
		syncOrderTotal(total, childOrder);
	}

	public void syncOrderTotal(OpenOrderTotal total, List<OpenOrder> childOrder) {

		ResponseData<FuPayGetBillDetailResponseModel2> data = platformGlobalComponent.getBillDetail2(total.getBillId());

		syncOrderTotal(total, childOrder, data);
	}

	public void syncOrderTotal(OpenOrderTotal total, List<OpenOrder> list,
			ResponseData<FuPayGetBillDetailResponseModel2> data) {
		logger.info("{}", JSON.toJSONString(data));
		validator(data.getCode() != 1001, data.getCode() + ":" + data.getMsg());
		FuPayGetBillDetailResponseModel2 model = data.getData();
		syncOrderTotal(total, list, model);
	}

	public void syncOrderTotal(OpenOrderTotal total, List<OpenOrder> list, FuPayGetBillDetailResponseModel2 model) {
		validator(total == null, "total不能为空");
		validator(list == null, "list不能为空");
		validator(model == null, "model不能为空");
		logger.info("total:{},list:{},model:{}", JSON.toJSONString(total), JSON.toJSONString(list),
				JSON.toJSONString(model));
		validator(total.getBillStatus() != 2, "该订单未支付!");

		Integer pfPayStatus = new Integer(model.getPayStatus());
		Integer pfRefundStatus = new Integer(model.getRefundStatus());
		OpenOrderTotal record = new OpenOrderTotal();
		record.setId(total.getId());
		record.setPfBalanceStatus(new Integer(model.getBalanceStatus()));
		record.setPfBussinessBalanceStatus(new Integer(model.getBussinessBalanceStatus()));
		record.setPfRefundStatus(new Integer(model.getRefundStatus()));
		record.setPfPayStatus(pfPayStatus);
		if (pfPayStatus == 3 || pfPayStatus == 4) {
			// 关闭订单
			record.setBillStatus(6);
		}

		ExtAppMoneyTotal mtotal = new ExtAppMoneyTotal();
		List<ExtAppMoney> m = new ArrayList<>();
		for (OpenOrder openOrder : list) {
			ExtAppMoney e = new ExtAppMoney(openOrder.getTotalAmount(),
					openOrder.getPlatformChargeRate(),
					openOrder.getServiceChargeRate(), openOrder.getThinkChargeRate(), openOrder.getRefundStatus() == 2 ? 1 : 0);
			e.setServiceId(openOrder.getServiceId());
			e.setOpenOrderId(openOrder.getId());
			m.add(e);
		}
		mtotal.setMoneys(m);
		mtotal.build();

		// "refund_status":1,//退款状态, 0:无, 1:退款审批中, 2:退款审批失败, 3:退款审批成功, 4:退款进行中, 5:退款失败,
		// 6:退款成功,7:有退款,8:无退款

		List<FuPayBillModel2> relist = model.getRefundList();
		if (relist == null) {
			relist = new ArrayList<FuPayBillModel2>();
		}
		if (pfRefundStatus == 7) {
			record.setRefundCount(relist.size());
		}
		//更新
		record.setTotalToServiceCharge(mtotal.getToServiceChargeTotal());
		record.setTotalServiceCharge(mtotal.getServiceChargeTotal());
		record.setTotalThinkToAmount(mtotal.getToThinkAmountTotal());
		record.setTotalThinkAmount(mtotal.getThinkAmountTotal());
		record.setTotalToReceiptAmount(mtotal.getToReceiptAmountTotal());
		record.setTotalReceiptAmount(mtotal.getReceiptAmountTotal());
		
		openOrderTotalMapper.updateByPrimaryKeySelective(record);
		for (OpenOrder openOrder : list) {
			OpenOrder o = new OpenOrder();
			o.setId(openOrder.getId());
			o.setPfBalanceStatus(new Integer(model.getBalanceStatus()));
			o.setPfBussinessBalanceStatus(new Integer(model.getBussinessBalanceStatus()));
			o.setPfRefundStatus(new Integer(model.getRefundStatus()));

			String refundBillId = openOrder.getRefundBillId();
			for (FuPayBillModel2 m2 : relist) {
				if (m2.getBillId().equals(refundBillId)) {
					o.setPfRefundTime(m2.getSuccessTime());
					o.setRefundAccountId(m2.getAccountId());
				}
				
				
			}

			for (ExtAppMoney m2 : mtotal.getMoneys()) {
				if (m2.getOpenOrderId().longValue() == openOrder.getId().longValue()) {
					o.setServiceCharge(m2.getServiceCharge());
					o.setRefundMoney(m2.getRefundUser());
					o.setReceiptAmount(m2.getReceiptAmount());
				}

			}
			// WithdrawStatus ,1未到提现时间,2可提现,3提现审批中 ,4提现成功,5提现失败,6不可提现
			// billStatus 1支付中,2支付成功,6关闭,8已扫码
			// RefundStatus 1退款审批中,2退款成功,3退款失败
			// bill_split_status 1拆单,2没有拆单
			// ServiceChargeStatus '物业服务费状态，1：不可结算，2：可结算但未结算，3：已结算',

			if (openOrder.getBillSplitStatus() == 1) {
				//
			} else {
				o.setWithdrawStatus(1);
			}

			// "bussiness_balance_status":"",//业务对账状态, 1:未对账, 2:已对账, 3:对账出错
			if (o.getPfBussinessBalanceStatus() == 2) {
				o.setBalanceStatus(2);// 对账状态，1:未对账, 2:已对账, 3:对账出错
			}
			openOrderMapper.updateByPrimaryKeySelective(o);
		}

	}

}
