package com.rfchina.community.brothers.task;

import com.rfchina.community.service.openser.UserCommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author wlrllr
 * @Description //用户评价定时任务
 * @Date 2019/1/31
 * @Param
 * @return
 **/
//@Component
@Deprecated
public class UserCommentTask {

    /*private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserCommentService userCommentService;
    @Value("${comment.auto_comment_interval}")
    private Long autoCommentInterval;

    *//**
     * @return void
     * @Author wlrllr
     * @Description //超过7天自动评价
     * @Date 2019/3/8
     * @Param []
     **//*
    @Scheduled(fixedDelay = 10 * 60 * 1000L)
    public void autoCommentOrder() {
        Long now = System.currentTimeMillis();
        logger.info("后台自动评价订单，开始...");
        int num = userCommentService.autoComment(autoCommentInterval);
        logger.info("后台自动评价订单，结束，此次处理订单{}条，耗时:{}ms...", num, System.currentTimeMillis() - now);
    }*/
}
