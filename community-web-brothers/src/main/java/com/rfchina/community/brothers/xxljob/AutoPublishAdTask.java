package com.rfchina.community.brothers.xxljob;

import com.rfchina.community.brothers.service.AdService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 自动发布审核通过的广告
 */
@JobHandler(value = "brothers-AutoPublishAdTask")
@Component
public class AutoPublishAdTask extends IJobHandler{

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AdService adService;

    /**
     * 自动发布审核通过的广告
     */
    public void runAutoPublish() {
        logger.debug("Begin to run [runAutoPublish] 自动发布审核通过的广告");
        adService.runAutoPublish();
        logger.debug("Finish [runAutoPublish] 自动发布审核通过的广告");
    }

    @Override
    public ReturnT<String> execute(String s) throws Exception {
        this.runAutoPublish();
        return ReturnT.SUCCESS;
    }
}
