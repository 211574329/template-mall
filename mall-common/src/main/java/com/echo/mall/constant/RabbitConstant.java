package com.echo.mall.constant;

/**
 * mq相关常量
 */
public class RabbitConstant {

    /**
     * 支付通知订单的队列
     */
    public static final String PAY_INFORM_ORDER_QUEUE = "pay_inform_order_queue";

    /**
     * 支付通知订单的交换机
     */
    public static final String PAY_INFORM_ORDER_EXCHANGE = "pay_inform_order_exchange";

    /**
     * 支付通知订单的key
     */
    public static final String PAY_INFORM_ORDER_KEY = "pay_inform_order_key";

    /**
     * 订单通知flink的队列
     */
    public static final String ORDER_INFORM_FLINK_QUEUE = "order_inform_flink_queue";

    /**
     * 订单通知flink的交换机
     */
    public static final String ORDER_INFORM_FLINK_EXCHANGE = "order_inform_flink_exchange";

    /**
     * 订单通知flink的key
     */
    public static final String ORDER_INFORM_FLINK_KEY = "order_inform_flink_key";

}
