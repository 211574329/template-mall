package com.echo.mall.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 数值
 */
@Getter
@AllArgsConstructor
public enum NumericalEnum {

    /**
     * 0
     */
    ZERO(0, 0L, "0"),

    /**
     * 1
     */
    ONE(1, 1L, "1"),

    /**
     * 2
     */
    TWO(2, 2L, "2"),

    /**
     * 3
     */
    THREE(3, 3L, "3"),

    /**
     * 4
     */
    FOUR(4, 4L, "4"),

    /**
     * 200
     */
    TWO_HUNDRED(200, 200L, "200");

    /**
     * 数字（int类型）
     */
    private Integer intValue;

    /**
     * 数字（long类型）
     */
    private Long longValue;

    /**
     * 数字（字符类型）
     */
    private String charValue;


}
