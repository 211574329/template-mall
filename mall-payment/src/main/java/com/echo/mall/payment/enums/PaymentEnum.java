package com.echo.mall.payment.enums;

/**
 * 支付 枚举类
 */
public enum PaymentEnum {
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
        for (PaymentEnum payment : PaymentEnum.values()) {
            if (payment.type.equals(type)) {
                return payment.className;
            }
        }
        return null;
    }

    PaymentEnum(Integer type, String className) {
        this.type = type;
        this.className = className;
    }
}
