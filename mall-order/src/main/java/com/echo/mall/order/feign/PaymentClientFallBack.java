package com.echo.mall.order.feign;

import com.echo.mall.module.payment.bo.OrderPaymentBO;
import com.echo.mall.module.payment.dto.PaymentDTO;
import com.echo.mall.result.entity.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PaymentClientFallBack implements PaymentClient{
    @Override
    public R<OrderPaymentBO> pay(PaymentDTO paymentDTO) {
        return R.fail();
    }
}
