package com.echo.mall.order.message;

import com.echo.mall.constant.TaskConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 消息service
 */
@Slf4j
@Component
public class MessageService {

    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送消息
     * @param exchange  交换机
     * @param routingKey    key
     * @param t 消息体
     * @param <T>
     */
    @Async(TaskConstant.POOL_NAME)
    public <T> void sendMessage(String exchange, String routingKey, T t){
        log.info("交换机:{}, key:{}, 消息体:{}", exchange, routingKey, t);
        rabbitTemplate.convertAndSend(exchange, routingKey, t);
    }

}
