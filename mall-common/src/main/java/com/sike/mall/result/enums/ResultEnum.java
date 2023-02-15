package com.sike.mall.result.enums;

import lombok.Getter;

/**
 * 通用返回结果枚举
 */
@Getter
public enum ResultEnum {

    // 默认成功
    SUCCESS(200, "成功"),
    // 默认失败
    FAIL(500, "失败"),
    // 未登录
    UNAUTHORIZED(401, "用户未登录"),
    // 非法请求
    ILLEGALITY(403, "非法请求"),
    // 404异常
    NO_HANDLER_ERROR(404, "资源不存在"),
    // JSON参数校验
    JSON_VALID_ERROR(201, "参数校验异常"),
    // 普通参数校验
    VALID_ERROR(202, "参数校验异常"),
    // 缺失请求正文
    REQUEST_BODY_MISS(203, "缺失请求正文"),
    // ASSERT校验异常
    ASSERT_ERROR(204, "业务校验异常"),
    // 方法参数类型不匹配异常
    ARGUMENT_TYPE_ERROR(205, "方法参数类型不匹配异常"),
    // 序列化异常
    INVALID_FORMAT_ERROR(206, "参数有误，序列化异常"),
    // JSON解析异常
    JSON_PARSE_ERROR(207, "参数有误，解析异常"),
    // 数字类型转换异常
    NUMBER_FORMAT_ERROR(300, "数字类型转换异常"),
    // 文件上传
    FILE_ERROR(301, "文件上传失败"),

    // 请求方式错误
    METHOD_NOT_SUPPORTED_ERROR(410, "请求方式错误"),
    // 多次提交
    REPEATEDLY_ERROR(600, "多次提交");

    ;


    /**
     * 响应编码
     */
    private Integer code;

    /**
     * 信息
     */
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
