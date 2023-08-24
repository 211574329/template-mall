package com.echo.mall.order.service;

import com.echo.mall.module.order.dto.OrderDTO;
import com.echo.mall.order.entity.OrderInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 订单信息 服务类
 * </p>
 *
 * @author echo
 * @since 2023-07-26
 */
public interface IOrderInfoService extends IService<OrderInfo> {

    Long create(OrderDTO orderDTO);

    Integer pay(OrderDTO orderDTO);

}