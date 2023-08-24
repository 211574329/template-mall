package com.echo.mall.payment.handler.impl;

import com.echo.mall.module.payment.dto.PaymentDTO;
import com.echo.mall.payment.handler.PaymentHandler;
import com.echo.mall.util.random.RandomUtil;
import org.springframework.stereotype.Service;

/**
 * 网银支付
 */
@Service
public class EcurrencyPaymentHandler implements PaymentHandler {

    @Override
    public Long pay(PaymentDTO paymentDTO) {
        System.out.println("网银支付方式");
        return RandomUtil.getLong(999L);
    }
}
