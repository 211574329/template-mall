package com.sike.mall.payment.service;


import com.sike.mall.module.payment.dto.PaymentDTO;
import com.sike.mall.module.payment.vo.OrderPaymentVO;

/**
 * 支付接口
 */
public interface PaymentService {

    /**
     * 支付
     * @param paymentDTO    订单信息封装
     * @return
     */
    OrderPaymentVO pay(PaymentDTO paymentDTO);

}
