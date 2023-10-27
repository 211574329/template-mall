package com.echo.mall.module.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO implements Serializable {

    private static final long serialVersionUID = 705259482621219658L;

    /**
     * 订单编号
     */
    private Long orderNo;

    /**
     * 用户ID
     */
    @NotNull
    private Long userId;

    /**
     * 产品sku-id
     */
    private Long skuId;

    /**
     * 订单商品总数
     */
    private Integer allCount;

    /**
     * 支付类型
     */
    @NotNull
    private Integer payType;
}
