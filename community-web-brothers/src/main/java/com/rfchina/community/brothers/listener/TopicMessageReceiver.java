package com.rfchina.community.brothers.listener;

import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.brothers.service.MessageBusinessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicMessageReceiver {

    @Autowired
    private MessageBusinessService messageBusinessService;

    private static Logger logger = LoggerFactory.getLogger("TopicMessageReceiver");

    /**
     * @Author wlrllr
     * @Description //商家资料审批状态变动
     * @Date 2018/12/20
     **//*
    @RabbitListener(bindings = {@QueueBinding(value = @Queue(value = "${rabbitmq.queue.name}", durable = "true"), exchange = @Exchange(type = "topic", durable = "true", value = "${rabbitmq.exchange.name}"), key = "${rabbitmq.routing.key.audit}")})
    public void merchantAudit(String str) {
        logger.info("监听mq merchantAudit 不做业务处理: {} ", str);
        //auditStatusChange(JSONObject.parseObject(str));
    }*/

    /**
     * @Author wlrllr
     * @Description // 商家草稿状态变动
     * @Date 2018/12/20  
     **/
    @RabbitListener(bindings = {@QueueBinding(value = @Queue(value = "${rabbitmq.queue.name}", durable = "true"), exchange = @Exchange(type = "topic", durable = "true", value = "${rabbitmq.exchange.name}"), key = "${rabbitmq.routing.key.draft}")})
    public void merchantDraftStatus(String str) {
        logger.info("监听mq merchantDraftStatus : {} ", str);
        //1:填写中 2:审批中, 3:审批通过, 4:审批失败, 5: 用户撤回修改
        messageBusinessService.auditStatusChange(JSONObject.parseObject(str));
    }

    /**
     * @Author wlrllr
     * @Description // 结算时mq消息
     * @Date 2018/12/20
     **/
   // @RabbitListener(bindings = {@QueueBinding(value = @Queue(value = "${rabbitmq.queue.name}", durable = "true"), exchange = @Exchange(type = "topic", durable = "true", value = "${rabbitmq.exchange.name}"), key = "${rabbitmq.routing.key.draft}")})
    public void settleAudit(String str) {
        logger.info("监听mq settleAudit : {} ", str);
    }

}
