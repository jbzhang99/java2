package com.rfchina.community.brothers.xxljob;

import com.rfchina.community.service.openser.OpenOrderSerService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author wlrllr
 * @Description //同步订单快递物流状态到redis
 * @Date 2019/1/31
 * @Param
 * @return
 **/
@JobHandler(value = "brothers-SyncOrderExpressInfoTask")
@Component
public class SyncOrderExpressInfoTask extends IJobHandler {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private OpenOrderSerService openOrderSerService;

	@Override
	public ReturnT<String> execute(String s) throws Exception {
		this.syncOrderExpressInfo();
		return ReturnT.SUCCESS;
	}

	public void syncOrderExpressInfo() {
		logger.debug("Begin to run [syncOrderExpressInfo] 同步订单快递物流状态到redis");
		openOrderSerService.SyncExpressStatus();
		logger.debug("Finish [syncOrderExpressInfo] 同步订单快递物流状态到redis");
	}


}
