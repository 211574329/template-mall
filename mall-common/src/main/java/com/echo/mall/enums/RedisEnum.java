package com.echo.mall.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * redis key
 */
@Getter
@AllArgsConstructor
public enum RedisEnum {

    /**
     * flink对订单的统计
     */
    ORDER_SUMMARY("flink:order:summary", "订单统计")

    ;

    /**
     * key
     */
    private String key;

    /**
     * 说明
     */
    private String explain;


}
