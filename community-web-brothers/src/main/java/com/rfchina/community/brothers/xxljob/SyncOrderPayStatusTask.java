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
 * @Description //查找超时支付的订单，更新订单状态为已过期
 * @Date 2019/1/31
 * @Param
 * @return
 **/
@Component
@JobHandler(value = "brothers-SyncOrderPayStatusTask")
public class SyncOrderPayStatusTask extends IJobHandler {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private OpenStoreOrderService openStoreOrderService;
    @Value("${order.pay.timeout}")
    private long payTimeout;

    @Override
    public ReturnT<String> execute(String s) throws Exception {
        long now = System.currentTimeMillis();
        logger.info("查找超时支付的订单，更新订单状态为已过期...");
        int result = openStoreOrderService.checkInvalidPayAndUpdate(payTimeout);
        logger.info("处理超时支付订单结束;影响条数: result={}，耗时：{}ms", result, System.currentTimeMillis() - now);
        return ReturnT.SUCCESS;
    }
}
