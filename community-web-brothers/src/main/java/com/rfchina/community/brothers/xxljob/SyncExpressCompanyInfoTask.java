package com.rfchina.community.brothers.xxljob;

import com.rfchina.community.service.openser.ExpressCompanyService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author wlrllr
 * @Description //同步快递公司信息到redis
 * @Date 2019/1/31
 * @Param
 * @return
 **/
@JobHandler(value = "brothers-SyncExpressCompanyInfoTask")
@Component
public class SyncExpressCompanyInfoTask extends IJobHandler {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ExpressCompanyService expressCompanyService;

    @Override
    public ReturnT<String> execute(String s) throws Exception {
        this.syncExpressCompanyInfo();
        return ReturnT.SUCCESS;
    }

    public void syncExpressCompanyInfo() {
        logger.debug("Begin to run [syncExpressCompanyInfo] 同步快递公司信息到redis");
        expressCompanyService.syncCompanyInfo();
        logger.debug("Finish [syncExpressCompanyInfo] 同步快递公司信息到redis");
    }



}
