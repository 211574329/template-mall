package com.echo.mall.order.feign;

import com.echo.mall.module.payment.bo.OrderPaymentBO;
import com.echo.mall.module.payment.dto.PaymentDTO;
import com.echo.mall.result.entity.R;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "mall-payment", path = "payment", fallback = PaymentClientFallBack.class)
public interface PaymentClient {
    R<OrderPaymentBO> pay(PaymentDTO paymentDTO);
}
