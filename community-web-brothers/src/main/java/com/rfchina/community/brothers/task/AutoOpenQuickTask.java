package com.rfchina.community.brothers.task;

import com.rfchina.community.service.openser.OpenQuickOrderSerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 */
//@Component
public class AutoOpenQuickTask {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private OpenQuickOrderSerService openQuickOrderSerService;
 

	@Scheduled(initialDelay = 10000, fixedDelay = 15* 60 * 1000L)
	public void canceltesk() {
		
		logger.info("---AutoOpenQuickTask----");
		openQuickOrderSerService.canceltesk();
		 
	}

}
