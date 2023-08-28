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

    /**
     * 创建订单
     * @param orderDTO  订单信息
     * @return
     */
    Long create(OrderDTO orderDTO);

    /**
     * 支付订单
     * @param orderDTO  订单信息
     * @return
     */
    Integer pay(OrderDTO orderDTO);

}
