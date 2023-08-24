package com.echo.mall.payment.config;

import com.echo.mall.constant.RabbitConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 直连交换机 支付成功通知订单
 */
@Configuration
public class DirectConfig {


    /**
     * durable 消息是否持久化,持久化队列会被存储在磁盘上,当消息代理重启时仍然存在,暂存队列
     *
     * @return 队列
     */
    @Bean
    public Queue payQueue() {
        return new Queue(RabbitConstant.PAY_INFORM_ORDER_QUEUE, true);
    }

    /**
     * durable 消息是否持久化
     * autoDelete 消息是否自动删除
     *
     * @return 交换机
     */
    @Bean
    public DirectExchange payExchange() {
        return new DirectExchange(RabbitConstant.PAY_INFORM_ORDER_EXCHANGE, true, false);
    }

    /**
     * 队列与交换机绑定,并设置匹配键
     *
     * @return
     */
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(payQueue()).to(payExchange()).with(RabbitConstant.PAY_INFORM_ORDER_KEY);
    }

}
