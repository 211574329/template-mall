package com.echo.mall.order.test;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * sku信息
 * </p>
 *
 * @author echo
 * @since 2023-07-26
 */
@Data
@AllArgsConstructor
public class Sku implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 属性id
     */
    private Long skuId;

    /**
     * SPU id
     */
    private Long spuId;

    /**
     * sku名称
     */
    private String skuName;

    /**
     * 售价，整数方式保存
     */
    private Long priceFee;




}
