package com.echo.mall.payment.handler.impl;

import com.echo.mall.module.payment.dto.PaymentDTO;
import com.echo.mall.payment.handler.PaymentHandler;
import com.echo.mall.result.entity.PaymentResult;
import org.springframework.stereotype.Service;

/**
 * 微信支付
 */
@Service
public class WechatPaymentHandler implements PaymentHandler {

    @Override
    public PaymentResult<Long> pay(PaymentDTO paymentDTO) {
        System.out.println("微信支付方式");
        // 假数据
        Long orderNo = 1L;
        return PaymentResult.success(orderNo);
    }
}
