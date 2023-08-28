package com.echo.mall.order.message.consumer;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.echo.mall.constant.RabbitConstant;
import com.echo.mall.module.payment.bo.OrderPaymentBO;
import com.echo.mall.order.entity.OrderInfo;
import com.echo.mall.order.service.IOrderInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * 消费支付消息
 */
@Slf4j
@Component
public class PayConsumer {

    @Resource
    private IOrderInfoService orderInfoService;

    /**
     * 订单支付成功的通知
     *
     * @param payment   订单支付信息
     */
    @RabbitListener(queues = RabbitConstant.PAY_INFORM_ORDER_QUEUE)// 监听队列
    @RabbitHandler
    public void process(OrderPaymentBO payment) {
        log.info("支付消息:{}", payment);
        Long orderNo = payment.getOrderNo();
        LambdaQueryWrapper<OrderInfo> query = Wrappers.lambdaQuery();
        query.eq(OrderInfo::getOrderNo, orderNo);
        OrderInfo orderInfo = orderInfoService.getOne(query);
        Assert.notNull(orderInfo, "订单不存在");
        Assert.isTrue(!orderInfo.getIsPayed(), "订单已支付");
        orderInfo.setIsPayed(true);
        orderInfo.setPayNo(payment.getPayNo());
        orderInfo.setUpdateTime(LocalDateTime.now());
        orderInfo.setStatus(2);
        orderInfoService.updateById(orderInfo);
    }

}
