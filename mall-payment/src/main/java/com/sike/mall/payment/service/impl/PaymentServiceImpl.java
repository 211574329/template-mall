package com.sike.mall.payment.service.impl;

import com.sike.mall.payment.dto.PaymentDTO;
import com.sike.mall.payment.handler.PaymentHandler;
import com.sike.mall.payment.handler.PaymentHandlerStrategy;
import com.sike.mall.payment.result.PaymentResult;
import com.sike.mall.payment.service.PaymentService;
import com.sike.mall.payment.vo.OrderPaymentVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentHandlerStrategy paymentHandlerStrategy;

    @Override
    public OrderPaymentVO pay(PaymentDTO paymentDTO) {
        // 获取支付处理器
        PaymentHandler paymentHandler = paymentHandlerStrategy.strategy(paymentDTO.getType());
        // 支付
        PaymentResult paymentResult = paymentHandler.pay(paymentDTO);
        // 业务逻辑省略...
        // 假数据
        OrderPaymentVO orderPaymentVO = new OrderPaymentVO();
        orderPaymentVO.setMessage("支付成功");
        return orderPaymentVO;
    }

}
