package com.echo.mall.order.controller;

import com.alibaba.fastjson2.JSON;
import com.echo.mall.constant.RabbitConstant;
import com.echo.mall.module.order.bo.OrderFlinkBO;
import com.echo.mall.order.entity.OrderInfo;
import com.echo.mall.order.message.MessageService;
import com.echo.mall.order.service.IOrderInfoService;
import com.echo.mall.order.service.impl.RedisService;
import com.echo.mall.order.test.Sku;
import com.echo.mall.result.entity.R;
import com.echo.mall.util.random.RandomUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private IOrderInfoService orderService;

    @Resource
    private RedisService redisService;

    @Resource
    private MessageService messageService;

    final static List<Sku> LIST = new ArrayList<>();
    final static Map<Integer, String> AREA = new HashMap<>();

    static {
        LIST.add(new Sku(0L,0L,"杂牌",new BigDecimal(400)));
        LIST.add(new Sku(1L,1L,"iQOO",new BigDecimal(5300)));
        LIST.add(new Sku(2L,1L,"OPPO",new BigDecimal(4500)));
        LIST.add(new Sku(3L,1L,"VIVO",new BigDecimal(4300)));
        LIST.add(new Sku(4L,1L,"MI",new BigDecimal(6300)));
        LIST.add(new Sku(5L,2L,"Lenovo",new BigDecimal(7100)));
        LIST.add(new Sku(6L,2L,"Mac",new BigDecimal(15000)));
        LIST.add(new Sku(7L,2L,"惠普",new BigDecimal(7590)));
        LIST.add(new Sku(8L,2L,"外星人",new BigDecimal(12000)));
        LIST.add(new Sku(9L,2L,"机械革命",new BigDecimal(6900)));

        AREA.put(1, "北京");
        AREA.put(2, "上海");
        AREA.put(3, "深圳");
        AREA.put(4, "天津");
        AREA.put(5, "新疆");
        AREA.put(6, "黑龙江");
        AREA.put(7, "云南");
        AREA.put(8, "山东");
        AREA.put(9, "安徽");
        AREA.put(10, "广西");
    }

    @RequestMapping("batch")
    public R<Integer> batch(){
        Thread[] threads = new Thread[2];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    OrderInfo order = OrderInfo.builder().createTime(LocalDateTime.now()).updateTime(LocalDateTime.now()).status(5).build();
                    order.setOrderNo(redisService.Generate());
                    Sku sku = LIST.get(RandomUtil.getInt(9));
                    order.setShopName(sku.getSkuName());
                    order.setSkuId(sku.getSkuId());
                    order.setSpuId(sku.getSpuId());
                    BigDecimal priceFee = sku.getPriceFee();
                    Integer total = RandomUtil.getInt(5);
                    order.setPrice(priceFee);
                    order.setTotal(priceFee.multiply(new BigDecimal(total)));
                    order.setAllCount(total);
                    order.setUserId(RandomUtil.getLong(10000L));
                    orderService.save(order);
                }
            });
            threads[i].start();
        }
        return R.success();
    }

    @RequestMapping("batch2")
    public R<Integer> batch2(Integer length){
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < length; j++) {
                    Long orderNo = redisService.Generate();
                    Sku sku = LIST.get(RandomUtil.getInt(9));
                    BigDecimal priceFee = sku.getPriceFee();
                    Integer total = RandomUtil.getInt(5);
                    Integer areaNo = RandomUtil.getInt(10);
                    OrderFlinkBO orderFlinkBO = OrderFlinkBO.builder()
                            .orderNo(orderNo)
                            .areaId(areaNo).areaName(AREA.get(areaNo))
                            .spuId(sku.getSpuId()).skuId(sku.getSkuId())
                            .skuName(sku.getSkuName())
                            .allCount(total)
                            .price(priceFee)
                            .total(priceFee.multiply(new BigDecimal(total))).build();
                    messageService.sendMessage(RabbitConstant.ORDER_INFORM_FLINK_EXCHANGE, RabbitConstant.ORDER_INFORM_FLINK_KEY, JSON.toJSONString(orderFlinkBO));
                }
            });
            threads[i].start();
        }
        return R.success();
    }

}
