package com.echo.mall.payment.handler.impl;

import com.echo.mall.module.payment.dto.PaymentDTO;
import com.echo.mall.payment.handler.PaymentHandler;
import com.echo.mall.util.random.RandomUtil;
import org.springframework.stereotype.Service;

/**
 * 微信支付
 */
@Service
public class WechatPaymentHandler implements PaymentHandler {

    @Override
    public Long pay(PaymentDTO paymentDTO) {
        System.out.println("微信支付方式");
        return RandomUtil.getLong(999L);
    }
}
