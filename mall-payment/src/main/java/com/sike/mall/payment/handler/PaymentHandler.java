package com.sike.mall.payment.handler;


import com.sike.mall.payment.dto.PaymentDTO;
import com.sike.mall.result.entity.PaymentResult;

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
