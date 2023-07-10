package com.echo.mall.util.random;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 随机数工具类
 */
public class RandomUtil {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    /**
     * 获取随机数
     *
     * @param max 最大值
     * @return
     */
    public static Integer getInt(Integer max) {
        return RANDOM.nextInt(max);
    }

    /**
     * 获取随机数
     *
     * @param min 最小值
     * @param max 最大值
     * @return
     */
    public static Integer getInt(Integer min, Integer max) {
        return RANDOM.nextInt(min, max);
    }

    public static void main(String[] args) {
        System.out.println(getInt(10));
        System.out.println(getInt(10,20));
    }

}
