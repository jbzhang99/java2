package com.rfchina.community.brothers.xxljob;

import com.rfchina.community.brothers.service.OpenPointRecordService;
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
 * 定时扫描加减积分
 */
@JobHandler(value = "brothers-AutoOpenPointTask")
@Component
public class AutoOpenPointTask extends IJobHandler{

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private OpenPointRecordService openPointRecordService;
	@Value("${community.app.api}")
	private String serverUrl;

	// 0 0/5 * * * ? *
	public void checkAndUpdatePoint() {
		logger.debug("Begin to run [checkAndUpdatePoint] 定时扫描加减积分");

		//加积分扫描
		openPointRecordService.checkAndIncreasePoint(serverUrl);
		
		//减积分扫描
		openPointRecordService.checkAndDecreasePoint(serverUrl);

		logger.debug("Finish [checkAndUpdatePoint] 定时扫描加减积分");
	}

	@Override
	public ReturnT<String> execute(String s) throws Exception {
		this.checkAndUpdatePoint();
		return ReturnT.SUCCESS;
	}
}
