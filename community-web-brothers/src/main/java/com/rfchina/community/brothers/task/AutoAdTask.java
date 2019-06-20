package com.rfchina.community.brothers.task;

import com.rfchina.community.brothers.service.AdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 */
//@Component
public class AutoAdTask {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AdService adService;

    /**
     * 自动下架过期广告
     */
    @Scheduled(cron = "0 * * * * ?")
    public void runAutoRepeal() {
        logger.debug("Begin to run [AutoRepealAdTask]");
        adService.runAutoRepeal();
        logger.debug("Finish [AutoRepealAdTask]");
    }

    /**
     * 自动发布审核通过的广告
     */
    @Scheduled(cron = "0 * * * * ?")
    public void runAutoPublish() {
        logger.debug("Begin to run [AutoPublishAdTask]");
        adService.runAutoPublish();
        logger.debug("Finish [AutoPublishAdTask]");
    }
}
