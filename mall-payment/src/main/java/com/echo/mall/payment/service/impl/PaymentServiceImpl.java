package com.echo.mall.payment.service.impl;

import com.echo.mall.module.payment.bo.OrderPaymentBO;
import com.echo.mall.module.payment.dto.PaymentDTO;
import com.echo.mall.payment.handler.PaymentHandler;
import com.echo.mall.payment.handler.PaymentHandlerStrategy;
import com.echo.mall.payment.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentHandlerStrategy paymentHandlerStrategy;

    @Override
    public OrderPaymentBO pay(PaymentDTO paymentDTO) {
        // 获取支付处理器
        PaymentHandler paymentHandler = paymentHandlerStrategy.strategy(paymentDTO.getType());
        // 支付
        Integer pay = paymentHandler.pay(paymentDTO);
        // 业务逻辑省略...
        // 假数据
        OrderPaymentBO payment = OrderPaymentBO.builder().message("支付成功").build();
        return payment;
    }

}
