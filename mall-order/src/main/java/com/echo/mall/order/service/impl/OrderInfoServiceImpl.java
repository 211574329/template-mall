package com.echo.mall.order.service.impl;

import com.echo.mall.enums.NumericalEnum;
import com.echo.mall.module.order.OrderDTO;
import com.echo.mall.module.payment.bo.OrderPaymentBO;
import com.echo.mall.module.payment.dto.PaymentDTO;
import com.echo.mall.order.entity.OrderInfo;
import com.echo.mall.order.feign.PaymentClient;
import com.echo.mall.order.mapper.OrderInfoMapper;
import com.echo.mall.order.service.IOrderInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.echo.mall.result.entity.R;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * <p>
 * 订单信息 服务实现类
 * </p>
 *
 * @author echo
 * @since 2023-07-26
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements IOrderInfoService {

    @Resource
    private PaymentClient paymentClient;

    @Override
    public Integer payment(OrderDTO orderDTO) {
        PaymentDTO payment = PaymentDTO.builder().orderId(orderDTO.getOrderId()).type(orderDTO.getType()).amount(new BigDecimal("99.99")).userId(orderDTO.getUserId()).build();
        R<OrderPaymentBO> r = paymentClient.pay(payment);
        Assert.isTrue(Objects.equals(r.getCode(), NumericalEnum.TWO_HUNDRED.getIntValue()), "支付失败");
        return 0;
    }
}
