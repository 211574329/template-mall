package com.echo.mall.link.message.consumer;


import com.echo.mall.constant.RabbitConstant;
import com.echo.mall.module.order.bo.OrderFlinkBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderConsumer {


    /**
     * 订单创建成功通知
     * @param orderFlinkBO  订单信息
     */
    @RabbitListener(queues = RabbitConstant.ORDER_INFORM_FLINK_QUEUE)
    @RabbitHandler
    public void process(OrderFlinkBO orderFlinkBO) {
        log.info("订单消息:{}", orderFlinkBO);


    }

}
