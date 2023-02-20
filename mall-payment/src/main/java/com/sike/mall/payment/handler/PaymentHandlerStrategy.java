package com.sike.mall.payment.handler;

import com.sike.mall.payment.enums.PaymentEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Map;

/**
 * 支付的接口策略
 */
@Component
public class PaymentHandlerStrategy {

    @Autowired
    private Map<String, PaymentHandler> strategyMap;

    /**
     * 获取支付处理器
     * @param type  类型
     * @return
     */
    public PaymentHandler strategy(Integer type) {
        String className = PaymentEnum.getClassName(type);
        Assert.notNull(className, "未找到{" + type + "}类型所对应的处理器");
        return strategyMap.get(className);
    }

}
