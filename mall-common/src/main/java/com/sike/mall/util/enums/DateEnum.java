package com.sike.mall.util.enums;

import lombok.Getter;

/**
 * 日期格式化枚举
 */
@Getter
public enum DateEnum {


    YYYY_MM_DD("yyyyMMdd"),
    YY_SS("yyyy-MM-dd HH:mm:ss"),
    HH_MM_SS("HHmmss");


    private String format;


    DateEnum(String format) {
        this.format = format;
    }
}
