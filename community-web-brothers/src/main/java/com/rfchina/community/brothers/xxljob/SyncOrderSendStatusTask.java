package com.rfchina.community.brothers.xxljob;

import com.rfchina.community.brothers.service.OpenStoreOrderService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author wlrllr
 * @Description //查找支付成功的单并且发送状态为1，发货时间超过7天，更改发送状态为2已完成
 * @Date 2019/1/31
 * @Param
 * @return
 **/
@Component
@JobHandler(value = "brothers-SyncOrderSendStatusTask")
public class SyncOrderSendStatusTask extends IJobHandler {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private OpenStoreOrderService openStoreOrderService;
    @Value("${good.automatic.praise.length}")
    private long automaticPraiseLength;

    @Override
    public ReturnT<String> execute(String s) throws Exception {
        long now = System.currentTimeMillis();
        logger.info("查找支付成功且发货超过7天的订单...");
        int result = openStoreOrderService.checkSendStatusAndUpdate(automaticPraiseLength);
        logger.info("处理自动完成的订单数: result={}，耗时：{}ms", result, System.currentTimeMillis() - now);
        return ReturnT.SUCCESS;
    }
}
