package com.echo.mall.payment.service;


import com.echo.mall.module.payment.dto.PaymentDTO;

/**
 * 支付接口
 */
public interface PaymentService {

    /**
     * 支付
     * @param paymentDTO    订单信息封装
     */
    void pay(PaymentDTO paymentDTO);

}
