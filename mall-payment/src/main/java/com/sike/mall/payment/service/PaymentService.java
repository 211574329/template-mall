package com.sike.mall.payment.service;


import com.sike.mall.payment.dto.PaymentDTO;
import com.sike.mall.payment.vo.OrderPaymentVO;

/**
 * 订单接口
 */
public interface PaymentService {

    /**
     * 支付
     * @param paymentDTO    订单信息封装
     * @return
     */
    OrderPaymentVO pay(PaymentDTO paymentDTO);

}
