package com.rfchina.community.brothers.xxljob;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.stereotype.Component;

/**
 * @ClassName SyncAroundInfoTask
 * @Description 通过高德同步周边信息
 * @Author wlrllr
 * @Date 2019/4/22 14:34
 * @Version 1.0
 **/
@JobHandler(value = "brothers-SyncAroundInfoTask")
@Component
public class SyncAroundInfoTask  extends IJobHandler {
    @Override
    public ReturnT<String> execute(String s) throws Exception {
        return null;
    }
}
