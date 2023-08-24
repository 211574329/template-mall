package com.echo.mall.module.payment.bo;

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
public class OrderPaymentBO implements Serializable {

    private static final long serialVersionUID = 2947779100360132110L;

    /**
     * 订单编号
     */
    private Long orderNo;

    /**
     * 支付流水号
     */
    private Long payNo;
    /**
     * 支付信息
     */
    private String message;

    // 省略...
}
