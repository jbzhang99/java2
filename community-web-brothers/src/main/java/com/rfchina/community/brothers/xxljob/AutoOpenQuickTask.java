package com.rfchina.community.brothers.xxljob;

import com.rfchina.community.service.openser.OpenQuickOrderSerService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 取消闪付支付
 */
@JobHandler(value = "brothers-AutoOpenQuickTask")
@Component
public class AutoOpenQuickTask extends IJobHandler{

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private OpenQuickOrderSerService openQuickOrderSerService;
 
	// 0 0/15 * * * ?
	public void canceltesk() {
		logger.debug("Begin to run [canceltesk] 取消闪付支付");
		openQuickOrderSerService.canceltesk();
		logger.debug("Finish [canceltesk] 取消闪付支付");
	}

	@Override
	public ReturnT<String> execute(String s) throws Exception {
		this.canceltesk();
		return ReturnT.SUCCESS;
	}
}
