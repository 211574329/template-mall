package com.echo.mall.payment.service.impl;

import com.echo.mall.module.payment.dto.PaymentDTO;
import com.echo.mall.payment.handler.PaymentHandler;
import com.echo.mall.payment.handler.PaymentHandlerStrategy;
import com.echo.mall.payment.service.PaymentService;
import com.echo.mall.module.payment.vo.OrderPaymentVO;
import com.echo.mall.result.entity.PaymentResult;
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
        PaymentResult<Long> paymentResult = paymentHandler.pay(paymentDTO);
        // 业务逻辑省略...
        // 假数据
        OrderPaymentVO paymentVO = OrderPaymentVO.builder().orderNo(paymentResult.getData()).message("支付成功").build();
        return paymentVO;
    }

}
