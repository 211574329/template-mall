package com.echo.mall.payment.handler;


import com.echo.mall.module.payment.dto.PaymentDTO;

/**
 * 支付接口
 */
public interface PaymentHandler {

    /**
     * 支付
     * @param paymentDTO    支付参数封装
     * @return  支付流水号
     */
    Long pay(PaymentDTO paymentDTO);
}
