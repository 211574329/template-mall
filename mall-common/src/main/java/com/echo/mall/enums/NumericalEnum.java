package com.echo.mall.enums;

import lombok.Getter;

/**
 * 数值
 */
@Getter
public enum NumericalEnum {
    /**
     * 0
     */
    ZERO(0),

    /**
     * 1
     */
    ONE(1),

    /**
     * 2
     */
    TWO(2),

    /**
     * 3
     */
    THREE(3),

    /**
     * 4
     */
    FOUR(4),

    /**
     * 200
     */
    TWO_HUNDRED(200);

    /**
     * 数值
     */
    private Integer numerical;

    NumericalEnum(Integer numerical) {
        this.numerical = numerical;
    }
}
