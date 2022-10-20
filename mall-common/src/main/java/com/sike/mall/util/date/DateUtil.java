package com.sike.mall.util.date;


import com.sike.mall.util.enums.DateEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 日期工具类
 */
public class DateUtil {

    /**
     * 当前日期
     * @return
     */
    public static String getNow(DateEnum dateEnum){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateEnum.getFormat());
        return LocalDateTime.now().format(formatter);
    }


    /**
     * 字符串转日期
     * @param dateStr   日期字符串
     * @param format    格式
     * @return
     */
    public static LocalDate getDate(String dateStr, String format){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDate.parse(dateStr, formatter);
    }

    public static void main(String[] args) {
        System.out.println(getNow(DateEnum.YYYY_MM_DD));
        System.out.println(getNow(DateEnum.HH_MM_SS));
    }


}
