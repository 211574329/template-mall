package com.echo.mall.payment.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.echo.mall.module.payment.dto.PaymentDTO;
import com.echo.mall.payment.service.PaymentService;
import com.echo.mall.result.entity.R;
import com.echo.mall.result.enums.ResultEnum;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     *
     * @param paymentDTO 支付信息封装
     * @return
     */
    @PostMapping("pay")
    public R<Long> pay(@RequestBody @Validated PaymentDTO paymentDTO){
        paymentService.pay(paymentDTO);
        return R.success(paymentDTO.getOrderNo());
    }

    /**
     * 支付 测试
     *
     * @param paymentDTO 支付信息封装
     * @return
     */
    @PostMapping("payment")
    public R<Long> payment(@RequestBody @Validated PaymentDTO paymentDTO){
        paymentService.pay(paymentDTO);
        return R.success(paymentDTO.getOrderNo());
    }

    /**
     * 测试接口
     * @param paymentDTO
     * @return
     *//*
    @GetMapping("test")
    @SentinelResource(value = "test", blockHandler = "exceptionHandler")
    public R<OrderPaymentBO> test(PaymentDTO paymentDTO){
        return R.success(paymentService.pay(paymentDTO));
    }*/

    public static R exceptionHandler(BlockException e){
        return R.fail(ResultEnum.REPEATEDLY_ERROR);
    }

}
