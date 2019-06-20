package com.rfchina.community.brothers.task;

import com.rfchina.community.brothers.service.OpenPointRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 定时扫描加减积分
 */
//@Component
public class AutoOpenPointTask {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private OpenPointRecordService openPointRecordService;
	@Value("${community.app.api}")
	private String serverUrl;
	
	@Scheduled(initialDelay = 6000, fixedDelay = 5 * 60 * 1000L)
	public void checkAndUpdatePoint() {
		//加积分扫描
		openPointRecordService.checkAndIncreasePoint(serverUrl);
		
		//减积分扫描
		openPointRecordService.checkAndDecreasePoint(serverUrl);
	}
	
}
