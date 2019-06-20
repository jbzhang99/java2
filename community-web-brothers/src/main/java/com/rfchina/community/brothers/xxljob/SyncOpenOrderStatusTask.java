package com.rfchina.community.brothers.xxljob;

import com.rfchina.community.brothers.service.OpenOrderBroService;
import com.rfchina.community.service.openser.OpenServiceTotalSyncService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 同步订单状态
 */
@JobHandler(value = "brothers-SyncOpenOrderStatusTask")
@Component
public class SyncOpenOrderStatusTask extends IJobHandler{

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private OpenOrderBroService openOrderService;

	@Autowired
	private OpenServiceTotalSyncService openServiceTotalSyncService;

	// 0 0/10 * * * ?
	public void syncOpenOrderStatus() {
		logger.debug("Begin to run [syncOpenOrderStatus] 同步订单状态");

		// 更新支付中心的对账状态,用于退款中间的一步.必须对账成功才能发起对账
		openOrderService.openOrderUpdateStatus();

		logger.info("-----------syncOrderTotal--------------");
		openServiceTotalSyncService.syncOrderTotal();

		// 发起退款
		logger.info("-----------openOrderRefund--------------");
		openOrderService.openOrderRefund();

		// 退款审批
		logger.info("-----------openOrderRefundUpdate--------------");
		openOrderService.openOrderRefundUpdate();

		logger.debug("Finish [syncOpenOrderStatus] 同步订单状态");
	}


	@Override
	public ReturnT<String> execute(String s) throws Exception {
		this.syncOpenOrderStatus();
		return ReturnT.SUCCESS;
	}
}
