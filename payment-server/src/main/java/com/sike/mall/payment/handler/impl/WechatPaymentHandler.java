package com.sike.mall.payment.handler.impl;

import com.sike.mall.payment.dto.PaymentDTO;
import com.sike.mall.payment.handler.PaymentHandler;
import com.sike.mall.payment.result.PaymentResult;
import org.springframework.stereotype.Service;

/**
 * 微信
 */
@Service
public class WechatPaymentHandler implements PaymentHandler {

    @Override
    public PaymentResult pay(PaymentDTO paymentDTO) {
        System.out.println("微信支付方式");
        // 假数据
        PaymentResult result = new PaymentResult();
        result.setStatus(true);
        return result;
    }
}
