package com.sike.mall.payment.handler.impl;

import com.sike.mall.payment.dto.PaymentDTO;
import com.sike.mall.payment.handler.PaymentHandler;
import com.sike.mall.payment.result.PaymentResult;
import org.springframework.stereotype.Service;

/**
 * 网银支付
 */
@Service
public class EcurrencyPaymentHandler implements PaymentHandler {

    @Override
    public PaymentResult pay(PaymentDTO paymentDTO) {
        System.out.println("网银支付方式");
        // 假数据
        PaymentResult result = new PaymentResult();
        result.setStatus(true);
        return result;
    }
}
