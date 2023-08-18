package com.echo.mall.order.controller;

import com.echo.mall.module.order.OrderDTO;
import com.echo.mall.order.service.IOrderInfoService;
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

    @RequestMapping("payment")
    public void payment(@RequestBody OrderDTO orderDTO){


    }

}
