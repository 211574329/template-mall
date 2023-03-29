package com.echo.mall.module.payment.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 订单支付信息vo
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderPaymentVO implements Serializable {

    private static final long serialVersionUID = 2947779100360132110L;
    /**
     * 支付信息
     */
    private String message;

    /**
     * 订单号
     */
    private Long orderNo;
    // 省略...
}
