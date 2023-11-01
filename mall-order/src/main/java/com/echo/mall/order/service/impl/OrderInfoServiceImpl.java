package com.echo.mall.order.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.echo.mall.constant.RabbitConstant;
import com.echo.mall.enums.NumericalEnum;
import com.echo.mall.module.order.bo.OrderFlinkBO;
import com.echo.mall.module.order.dto.OrderDTO;
import com.echo.mall.module.payment.dto.PaymentDTO;
import com.echo.mall.order.entity.OrderInfo;
import com.echo.mall.order.feign.PaymentFeign;
import com.echo.mall.order.mapper.OrderInfoMapper;
import com.echo.mall.order.message.MessageService;
import com.echo.mall.order.service.IOrderInfoService;
import com.echo.mall.order.test.Sku;
import com.echo.mall.result.entity.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
    private MessageService messageService;

    @Resource
    private PaymentFeign paymentFeign;

    // 假数据
    final static List<Sku> LIST = new ArrayList<>();
    static {
        LIST.add(new Sku(0L,0L,"杂牌",new BigDecimal(400)));
        LIST.add(new Sku(1L,1L,"iQOO",new BigDecimal(5300)));
        LIST.add(new Sku(2L,1L,"OPPO",new BigDecimal(4500)));
        LIST.add(new Sku(3L,1L,"VIVO",new BigDecimal(4300)));
        LIST.add(new Sku(4L,1L,"MI",new BigDecimal(6300)));
        LIST.add(new Sku(5L,2L,"Lenovo",new BigDecimal(7100)));
        LIST.add(new Sku(6L,2L,"Mac",new BigDecimal(15000)));
        LIST.add(new Sku(7L,2L,"惠普",new BigDecimal(7590)));
        LIST.add(new Sku(8L,2L,"外星人",new BigDecimal(12000)));
        LIST.add(new Sku(9L,2L,"机械革命",new BigDecimal(6900)));
    }

    @Override
    public Long create(OrderDTO orderDTO) {
        Long orderNo = redisService.Generate();
        // 实际为调用商品feign接口,此处为测试
        Sku sku = LIST.get(orderDTO.getSkuId().intValue());
        BigDecimal price = sku.getPriceFee();
        OrderInfo order = OrderInfo.builder()
                .orderNo(orderNo)
                .userId(orderDTO.getUserId())
                .spuId(sku.getSpuId()).skuId(sku.getSkuId())
                .allCount(orderDTO.getAllCount())
                .price(price).isPayed(false)
                .total(price.multiply(new BigDecimal(orderDTO.getAllCount())))
                .createTime(LocalDateTime.now()).updateTime(LocalDateTime.now())
                .status(1).build();
        save(order);
        OrderFlinkBO orderFlinkBO = OrderFlinkBO.builder()
                .orderNo(orderNo)
                .spuId(sku.getSpuId()).skuId(sku.getSkuId())
                .skuName(sku.getSkuName())
                .allCount(orderDTO.getAllCount())
                .price(price)
                .total(price.multiply(new BigDecimal(orderDTO.getAllCount()))).build();
        messageService.sendMessage(RabbitConstant.ORDER_INFORM_FLINK_EXCHANGE, RabbitConstant.ORDER_INFORM_FLINK_KEY, JSON.toJSONString(orderFlinkBO));
        //messageService.sendMessage(orderFlinkBO);
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
