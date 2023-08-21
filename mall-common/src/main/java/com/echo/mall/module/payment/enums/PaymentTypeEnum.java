package com.echo.mall.module.payment.enums;

/**
 * 支付 枚举类
 */
public enum PaymentTypeEnum {
    // 支付宝
    ALI_PAY(1, "aliPaymentHandler"),
    // 微信
    WECHAT_PAY(2, "wechatPaymentHandler"),
    // 网银
    E_PAY(3, "ecurrencyPaymentHandler");

    /**
     * 类型
     */
    private Integer type;

    /**
     * 实现类的类名
     */
    private String className;

    public static String getClassName(Integer type) {
        for (PaymentTypeEnum payment : PaymentTypeEnum.values()) {
            if (payment.type.equals(type)) {
                return payment.className;
            }
        }
        return null;
    }

    PaymentTypeEnum(Integer type, String className) {
        this.type = type;
        this.className = className;
    }
}
