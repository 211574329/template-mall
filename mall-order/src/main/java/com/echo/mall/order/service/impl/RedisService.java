package com.echo.mall.order.service.impl;

import com.echo.mall.enums.DateEnum;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

@Component
public class RedisService {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    public Long Generate() {
        // 获取当前时间
        LocalDateTime currentTime = LocalDateTime.now();
        // 格式化当前时间
        String originDateStr = currentTime.format(DateTimeFormatter.ofPattern(DateEnum.YYYY_MM_DD.getFormat()));
        // 计算当前时间走过的秒
        LocalDateTime startTime = LocalDateTime.of(currentTime.getYear(), currentTime.getMonth(), currentTime.getDayOfMonth(), 0, 0, 0);
        long differSecond = startTime.until(currentTime, ChronoUnit.SECONDS);
        // 秒的长度不足补充0
        String yyMMddSecond = originDateStr + String.format("%05d", differSecond);
        // 通过key，采用redis自增函数，实现单秒自增；不同的key，每次递增1，同时设置60秒过期
        redisTemplate.expire("no", 60, TimeUnit.SECONDS);
        Long no = redisTemplate.opsForValue().increment("no", 1);
        // 生成订单编号
        String orderNo = yyMMddSecond + String.format("%04d", no);
        return Long.valueOf(orderNo);
    }

}
