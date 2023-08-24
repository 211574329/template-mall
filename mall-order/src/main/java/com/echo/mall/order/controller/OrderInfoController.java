package com.echo.mall.order.controller;

import com.echo.mall.module.order.dto.OrderDTO;
import com.echo.mall.order.service.IOrderInfoService;
import com.echo.mall.result.entity.R;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 订单信息 前端控制器
 * </p>
 *
 * @author echo
 * @since 2023-07-26
 */
@RestController
@RequestMapping("/order")
public class OrderInfoController {

    @Resource
    private IOrderInfoService orderInfoService;

    /**
     * 订单生成
     *
     * @param orderDTO
     */
    @PostMapping("create")
    public R<Long> create(@RequestBody OrderDTO orderDTO) {
        return R.success(orderInfoService.create(orderDTO));
    }

    /**
     * 订单支付
     *
     * @param orderDTO
     * @return
     */
    @PostMapping("pay")
    public R<Integer> pay(@RequestBody @Validated OrderDTO orderDTO) {
        return R.success(orderInfoService.pay(orderDTO));
    }

}
