package com.sike.mall.payment.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sike.mall.payment.dto.PaymentDTO;
import com.sike.mall.payment.service.PaymentService;
import com.sike.mall.payment.vo.OrderPaymentVO;
import com.sike.mall.result.entity.R;
import com.sike.mall.result.enums.ResultEnum;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 订单控制器
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
    public R<OrderPaymentVO> pay(@RequestBody @Validated PaymentDTO paymentDTO){
        return R.success(paymentService.pay(paymentDTO));
    }

    /**
     * 测试接口
     * @param paymentDTO
     * @return
     */
    @GetMapping("test")
    @SentinelResource(value = "test", blockHandler = "exceptionHandler")
    public R<OrderPaymentVO> test(PaymentDTO paymentDTO){
        return R.success(paymentService.pay(paymentDTO));
    }

    public static R exceptionHandler(BlockException e){
        return R.fail(ResultEnum.REPEATEDLY_ERROR);
    }

}
