package com.sike.mall.module.payment.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 支付信息参数
 */
@Data
public class PaymentDTO implements Serializable {

    private static final long serialVersionUID = -7985258620999508770L;
    /**
     * 订单号
     * @mock @integer   // 长整型
     */
    @NotNull
    private Long orderNo;
    /**
     * 金额
     * @mock @float(0, 100000) // 浮点型
     */
    @NotNull
    private BigDecimal amount;
    /**
     * 支付类型
     * @mock @natural(1, 3) // 1~3自然数
     */
    @NotNull
    private Integer type;
    /**
     * 用户id
     * @mock @integer // 长整型
     */
    @NotNull
    private Long userId;
    // 省略...
}
