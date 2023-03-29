package com.echo.mall.enums;

import lombok.Getter;

/**
 * 特殊符号
 */
@Getter
public enum StockEnum {

    /**
     * 点
     */
    DOT("."),
    /**
     * 斜杠
     */
    BAR("/");

    /**
     * 符号
     */
    private String stock;

    StockEnum(String stock) {
        this.stock = stock;
    }

}
