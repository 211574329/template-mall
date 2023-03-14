package com.sike.mall.order.service.impl;

import com.sike.mall.order.entity.Order;
import com.sike.mall.order.mapper.OrderMapper;
import com.sike.mall.order.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单信息 服务实现类
 * </p>
 *
 * @author 
 * @since 2023-03-14
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
