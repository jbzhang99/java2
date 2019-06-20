package com.rfchina.community.brothers.task;

import com.rfchina.community.brothers.service.OpenOrderBroService;
import com.rfchina.community.brothers.service.OpenRefundService;
import com.rfchina.community.service.openser.OpenServiceTotalSyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 */
//@Component
public class AutoOpenTask {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private OpenOrderBroService openOrderService;

	@Autowired
	private OpenServiceTotalSyncService openServiceTotalSyncService;
	@Autowired
	private OpenRefundService openRefundService;

	@Scheduled(initialDelay = 6000, fixedDelay = 10 * 60 * 1000L)
	public void syncOpenOrderStatus() {

		logger.info("-----------openOrderUpdateStatus--------------");
		// 更新支付中心的对账状态,用于退款中间的一步.必须对账成功才能发起对账
		openOrderService.openOrderUpdateStatus();

		logger.info("-----------syncOrderTotal--------------");

		openServiceTotalSyncService.syncOrderTotal();
		logger.info("-----------openOrderRefund--------------");

		// 发起退款
		openOrderService.openOrderRefund();
		logger.info("-----------openOrderRefundUpdate--------------");
		// 退款审批
		openOrderService.openOrderRefundUpdate();
	}
	
	/**
	 * 同步商家未审核的单据，三天未审核则自动提交到支付中心
	 */
	@Scheduled(initialDelay = 10000, fixedDelay = 10* 60 * 1000L)
	public void sysRefundOrderMerchantNoAudit() {
		logger.info("---sysRefundOrderMerchantNoAudit----");

		openRefundService.auditRefundAuditPass();
		 
	}

}
