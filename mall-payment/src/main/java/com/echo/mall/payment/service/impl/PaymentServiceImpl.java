package com.echo.mall.payment.service.impl;

import com.echo.mall.constant.RabbitConstant;
import com.echo.mall.constant.TaskConstant;
import com.echo.mall.module.payment.bo.OrderPaymentBO;
import com.echo.mall.module.payment.dto.PaymentDTO;
import com.echo.mall.payment.handler.PaymentHandler;
import com.echo.mall.payment.handler.PaymentHandlerStrategy;
import com.echo.mall.payment.message.MessageService;
import com.echo.mall.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentHandlerStrategy paymentHandlerStrategy;

    @Resource
    private MessageService messageService;

    @Async(TaskConstant.POOL_NAME)
    @Override
    public void pay(PaymentDTO paymentDTO) {
        Long orderNo = paymentDTO.getOrderNo();
        log.info("支付订单号:{}", orderNo);
        // 获取支付处理器
        PaymentHandler paymentHandler = paymentHandlerStrategy.strategy(paymentDTO.getType());
        // 支付
        Long payNo = paymentHandler.pay(paymentDTO);
        // 业务逻辑省略...
        // 假数据
        OrderPaymentBO payment = OrderPaymentBO.builder().orderNo(orderNo).payNo(payNo).message("支付成功").build();
        // 发送消息
        messageService.sendMessage(RabbitConstant.PAY_INFORM_ORDER_EXCHANGE, RabbitConstant.PAY_INFORM_ORDER_KEY, payment);
    }

}
