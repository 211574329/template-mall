package com.sike.mall.result.entity;

import com.sike.mall.result.enums.ResultEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * 响应实体
 *
 * @param <T>
 */
@Data
public class R<T> implements Serializable {

    /**
     * 状态 300:失败, 200:成功
     */
    private Integer code;
    /**
     * 响应信息
     */
    private String message;
    /**
     * 响应数据
     */
    private T data;

    public R(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> R<T> success() {
        return new R<T>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), null);
    }

    public static <T> R<T> success(T t) {
        return new R<T>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), t);
    }


    public static <T> R<T> fail(String message) {
        return new R<T>(ResultEnum.ERROR.getCode(), message, null);
    }

    public static <T> R<T> fail(ResultEnum resultEnum, T t){
        return new R<T>(resultEnum.getCode(), resultEnum.getMessage(), t);
    }

    public static R fail(ResultEnum resultEnum){
        return new R(resultEnum.getCode(), resultEnum.getMessage(), null);
    }

}

