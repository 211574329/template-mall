package com.echo.mall.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.echo.mall.enums.NumericalEnum;
import com.echo.mall.module.order.dto.OrderDTO;
import com.echo.mall.module.payment.dto.PaymentDTO;
import com.echo.mall.order.entity.OrderInfo;
import com.echo.mall.order.feign.PaymentFeign;
import com.echo.mall.order.mapper.OrderInfoMapper;
import com.echo.mall.order.service.IOrderInfoService;
import com.echo.mall.result.entity.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * <p>
 * 订单信息 服务实现类
 * </p>
 *
 * @author echo
 * @since 2023-07-26
 */
@Slf4j
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements IOrderInfoService {

    @Resource
    private RedisService redisService;

    @Resource
    private OrderInfoMapper orderInfoMapper;

    @Resource
    private PaymentFeign paymentFeign;

    @Override
    public Long create(OrderDTO orderDTO) {
        Long orderNo = redisService.Generate();
        BigDecimal price = new BigDecimal("1.39");
        OrderInfo order = OrderInfo.builder()
                .orderNo(orderNo)
                .userId(orderDTO.getUserId())
                .spuId(orderDTO.getSpuId()).skuId(orderDTO.getSkuId())
                .allCount(orderDTO.getAllCount())
                .price(price)
                .total(price.multiply(new BigDecimal(orderDTO.getAllCount())))
                .createTime(LocalDateTime.now()).updateTime(LocalDateTime.now())
                .status(1).build();
        save(order);
        return orderNo;
    }

    @Override
    public Integer pay(OrderDTO orderDTO) {
        Long orderNo = orderDTO.getOrderNo();
        log.info("订单编号:{}", orderNo);
        // 查询订单
        LambdaQueryWrapper<OrderInfo> query = Wrappers.lambdaQuery();
        query.eq(OrderInfo::getOrderNo, orderNo);
        OrderInfo orderInfo = getOne(query);
        Assert.notNull(orderInfo, "订单不存在");
        Assert.isTrue(!orderInfo.getIsPayed(), "订单已支付");
        // 调用支付
        PaymentDTO payment = PaymentDTO.builder().orderNo(orderNo).type(orderDTO.getPayType()).amount(orderInfo.getTotal()).userId(orderDTO.getUserId()).build();
        R<Long> r = paymentFeign.pay(payment);
        Assert.isTrue(Objects.equals(r.getCode(), NumericalEnum.TWO_HUNDRED.getIntValue()), "支付失败");
        // 更新订单
        orderInfo.setUpdateTime(LocalDateTime.now());
        orderInfo.setPayTime(LocalDateTime.now());
        orderInfo.setPayType(orderDTO.getPayType());
        updateById(orderInfo);
        return 0;
    }
}
