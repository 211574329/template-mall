package com.echo.mall.order.config;

import com.echo.mall.constant.RabbitConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 直连交换机 下单成功通知flink
 */
@Configuration
public class DirectConfig {


    /**
     *  队列
     * @return 队列
     */
    @Bean
    public Queue payQueue() {
        return new Queue(RabbitConstant.ORDER_INFORM_FLINK_QUEUE, true);
    }

    /**
     *  交换机
     * @return 交换机
     */
    @Bean
    public DirectExchange payExchange() {
        return new DirectExchange(RabbitConstant.ORDER_INFORM_FLINK_EXCHANGE, true, false);
    }

    /**
     * 队列与交换机绑定,并设置匹配键
     *
     * @return
     */
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(payQueue()).to(payExchange()).with(RabbitConstant.ORDER_INFORM_FLINK_KEY);
    }

}
