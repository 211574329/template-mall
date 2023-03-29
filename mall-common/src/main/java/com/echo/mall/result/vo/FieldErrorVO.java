package com.echo.mall.result.vo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 参数异常类
 */
@Data
@Builder
public class FieldErrorVO implements Serializable {


    private static final long serialVersionUID = 6130556071941284281L;
    /**
     * 失败的属性
     */
    private String field;

    /**
     * 信息
     */
    private String message;
}
