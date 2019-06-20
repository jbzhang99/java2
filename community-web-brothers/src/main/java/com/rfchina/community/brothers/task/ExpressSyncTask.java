package com.rfchina.community.brothers.task;

import com.rfchina.community.service.openser.ExpressCompanyService;
import com.rfchina.community.service.openser.OpenOrderSerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * done
 * @Author wlrllr
 * @Description //快递信息同步
 * @Date 2019/1/31
 * @Param
 * @return
 **/
//@Component
public class ExpressSyncTask {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private ExpressCompanyService expressCompanyService;
	@Autowired
	private OpenOrderSerService openOrderSerService;

	@Scheduled(fixedDelay = 7*24*60* 60 * 1000L)
	public void syncExpressCompanyInfo() {
		logger.info("同步快递公司信息到redis...");
		expressCompanyService.syncCompanyInfo();
	}

	@Scheduled(fixedDelay = 2*60* 60 * 1000L)
	public void syncOrderExpressInfo() {
		logger.info("同步订单快递物流状态到redis...");
		openOrderSerService.SyncExpressStatus();
	}

}
