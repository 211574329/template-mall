package com.sike.mall.enums;

import lombok.Getter;

/**
 * 日期格式化枚举
 */
@Getter
public enum DateEnum {


    /**
     * yyyyMMdd
     */
    YYYY_MM_DD("yyyyMMdd"),
    /**
     * HHmmss
     */
    HH_MM_SS("HHmmss"),
    /**
     * yyyy-MM-dd HH:mm:ss
     */
    YY_SS("yyyy-MM-dd HH:mm:ss");



    private String format;


    DateEnum(String format) {
        this.format = format;
    }
}
