package com.echo.mall.order.feign;

import com.echo.mall.module.payment.dto.PaymentDTO;
import com.echo.mall.result.entity.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "mall-payment", path = "payment", fallback = PaymentFeignFallBack.class)
public interface PaymentFeign {

    @PostMapping("pay")
    R<Long> pay(PaymentDTO paymentDTO);
}
