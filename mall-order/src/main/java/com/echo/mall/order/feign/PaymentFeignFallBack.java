package com.echo.mall.order.feign;

import com.echo.mall.module.payment.bo.OrderPaymentBO;
import com.echo.mall.module.payment.dto.PaymentDTO;
import com.echo.mall.result.entity.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PaymentFeignFallBack implements PaymentFeign {
    @Override
    public R<OrderPaymentBO> pay(PaymentDTO paymentDTO) {
        log.error("feign调用失败,支付模块异常");
        return R.fail();
    }
}
