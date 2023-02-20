package com.sike.mall.payment.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 订单支付信息vo
 */
@Data
public class OrderPaymentVO implements Serializable {

    private static final long serialVersionUID = 2947779100360132110L;
    /**
     * 支付信息
     */
    private String message;
    // 省略...
}
