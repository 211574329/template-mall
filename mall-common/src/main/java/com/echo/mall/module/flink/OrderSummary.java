package com.echo.mall.module.flink;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * flink统计对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderSummary implements Serializable {

    private static final long serialVersionUID = 6836530909471066135L;

    /**
     * 产品sku-id
     */
    private Long skuId;

    /**
     * sku名称
     */
    private String skuName;

    /**
     * 商品购买数量
     */
    private Integer count;

}
