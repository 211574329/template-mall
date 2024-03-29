package com.echo.mall.result.entity;

import com.echo.mall.result.enums.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 响应实体
 *
 * @author echo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class R<T> implements Serializable {

    /**
     * 状态
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

    public R(ResultEnum enums) {
        this.code = enums.getCode();
        this.message = enums.getMessage();
    }

    public R(ResultEnum enums, T data) {
        this.code = enums.getCode();
        this.message = enums.getMessage();
        this.data = data;
    }

    /**
     * 默认成功
     * @return
     */
    public static <T> R<T> success() {
        return new R<T>(ResultEnum.SUCCESS);
    }

    /**
     * 默认失败
     * @return
     */
    public static <T> R<T> fail() {
        return new R<T>(ResultEnum.FAIL);
    }

    /**
     * 成功
     * @param t 数据
     * @return
     */
    public static <T> R<T> success(T t) {
        return new R<T>(ResultEnum.SUCCESS, t);
    }


    /**
     * 失败
     * @param t 数据
     * @return
     */
    public static <T> R<T> fail(T t) {
        return new R<T>(ResultEnum.FAIL, t);
    }

    /**
     * 失败
     * @param resultEnum    枚举
     * @param t 数据
     * @return
     */
    public static <T> R<T> fail(ResultEnum resultEnum, T t){
        return new R<T>(resultEnum, t);
    }

    /**
     * 失败
     * @param resultEnum    枚举
     * @return
     */
    public static R fail(ResultEnum resultEnum){
        return new R(resultEnum);
    }

}

