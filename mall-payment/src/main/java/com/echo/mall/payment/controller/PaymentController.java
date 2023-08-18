package com.echo.mall.payment.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.echo.mall.module.payment.dto.PaymentDTO;
import com.echo.mall.payment.service.PaymentService;
import com.echo.mall.result.entity.R;
import com.echo.mall.result.enums.ResultEnum;
import com.echo.mall.module.payment.bo.OrderPaymentBO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 支付控制器
 */
@RestController
@RequestMapping("payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    /**
     * 支付
     * @param paymentDTO    支付信息封装
     * @return
     */
    @PostMapping("pay")
    public R<OrderPaymentBO> pay(@RequestBody @Validated PaymentDTO paymentDTO){
        return R.success(paymentService.pay(paymentDTO));
    }

    /**
     * 测试接口
     * @param paymentDTO
     * @return
     */
    @GetMapping("test")
    @SentinelResource(value = "test", blockHandler = "exceptionHandler")
    public R<OrderPaymentBO> test(PaymentDTO paymentDTO){
        return R.success(paymentService.pay(paymentDTO));
    }

    public static R exceptionHandler(BlockException e){
        return R.fail(ResultEnum.REPEATEDLY_ERROR);
    }

}
