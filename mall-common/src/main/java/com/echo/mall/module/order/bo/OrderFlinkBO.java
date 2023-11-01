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
     * spu名称
     */
    private String spuName;

    /**
     * 产品sku-id
     */
    private Long skuId;

    /**
     * sku名称
     */
    private String skuName;

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

    /**
     * 用户所在地区编号
     */
    private Integer areaNo;

    /**
     * 用户所在地区名称
     */
    private String areaName;
}
