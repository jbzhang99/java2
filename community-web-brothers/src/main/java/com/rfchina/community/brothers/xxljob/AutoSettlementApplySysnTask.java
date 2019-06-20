package com.rfchina.community.brothers.xxljob;

import com.rfchina.community.brothers.service.BaseSettlementApplyService;
import com.rfchina.community.brothers.service.PaySettlementInfoService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 结算状态同步
 */
@JobHandler(value = "brothers-AutoSettlementApplySysnTask")
@Component
public class AutoSettlementApplySysnTask extends IJobHandler{

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Value("${app.environment}")
	private String environment;
	@Autowired
	private BaseSettlementApplyService baseSettlementApplyService;
	@Autowired
	private PaySettlementInfoService paySettlementInfoService;


	// 注解@Scheduled
	//0 0/5 * * * ?
	// 可以作为一个触发源添加到一个方法中，例如，以下的方法将以一个固定延迟时间5秒钟调用一次执行，这个周期是以上一个调用任务的完成时间为基准，在上一个任务完成之后，5s后再次执行：
	public void settlementApplySyncStatus() {
		logger.debug("Begin to run [settlementApplySyncStatus] 结算状态同步");
		// 同步状态
		if (!"test".equalsIgnoreCase(environment)) {
			baseSettlementApplyService.syncStatus();
			baseSettlementApplyService.syncSettlementApply();
		}
		// 平台更新
		// 同步
		paySettlementInfoService.syncStatus();
		logger.debug("Finish [settlementApplySyncStatus] 结算状态同步");
	}

	@Override
	public ReturnT<String> execute(String s) throws Exception {
		this.settlementApplySyncStatus();
		return ReturnT.SUCCESS;
	}
}
