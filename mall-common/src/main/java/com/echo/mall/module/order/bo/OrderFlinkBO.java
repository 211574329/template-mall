package com.echo.mall.module.order.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单通知flink
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderFlinkBO implements Serializable {

    /**
     * 订单编号
     */
    private Long orderNo;

    /**
     * 产品spu-id
     */
    private Long spuId;

    /**
     * 产品sku-id
     */
    private Long skuId;

    /**
     * 订单商品总数
     */
    private Integer allCount;

    /**
     * 产品价格
     */
    private BigDecimal price;

    /**
     * 总值
     */
    private BigDecimal total;
}
