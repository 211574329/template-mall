package com.sike.mall.payment.handler.impl;

import com.sike.mall.module.payment.dto.PaymentDTO;
import com.sike.mall.payment.handler.PaymentHandler;
import com.sike.mall.result.entity.PaymentResult;
import org.springframework.stereotype.Service;

/**
 * 支付宝支付
 */
@Service
public class AliPaymentHandler implements PaymentHandler {

    @Override
    public PaymentResult<Long> pay(PaymentDTO paymentDTO) {
        System.out.println("支付宝支付方式");
        // 假数据
        Long orderNo = 1L;
        return PaymentResult.success(orderNo);
    }
}
