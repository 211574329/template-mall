package com.sike.mall.payment.handler;


import com.sike.mall.payment.dto.PaymentDTO;
import com.sike.mall.payment.result.PaymentResult;

/**
 * 支付接口
 */
public interface PaymentHandler {

    /**
     * 支付
     * @param paymentDTO    支付参数封装
     * @return
     */
    PaymentResult pay(PaymentDTO paymentDTO);
}
