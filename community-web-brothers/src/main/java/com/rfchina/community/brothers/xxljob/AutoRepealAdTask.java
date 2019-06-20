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
 * 自动下架过期广告
 */
@JobHandler(value = "brothers-AutoRepealAdTask")
@Component
public class AutoRepealAdTask extends IJobHandler{

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AdService adService;

    /**
     * 自动下架过期广告
     */
    public void runAutoRepeal() {
        logger.debug("Begin to run [runAutoRepeal] 自动下架过期广告");
        adService.runAutoRepeal();
        logger.debug("Finish [runAutoRepeal] 自动下架过期广告");
    }

    @Override
    public ReturnT<String> execute(String s) throws Exception {
        this.runAutoRepeal();
        return ReturnT.SUCCESS;
    }
}
