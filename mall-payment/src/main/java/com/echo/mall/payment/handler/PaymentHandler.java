package com.echo.mall.payment.handler;


import com.echo.mall.module.payment.dto.PaymentDTO;
import com.echo.mall.result.entity.PaymentResult;

/**
 * 支付接口
 */
public interface PaymentHandler {

    /**
     * 支付
     * @param paymentDTO    支付参数封装
     * @return  订单编号
     */
    PaymentResult<Long> pay(PaymentDTO paymentDTO);
}
