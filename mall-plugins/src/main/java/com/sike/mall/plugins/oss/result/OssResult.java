package com.sike.mall.plugins.oss.result;

import com.sike.mall.result.enums.ResultEnum;
import lombok.Data;

/**
 * oss响应实体
 */
@Data
public class OssResult<T> {

    /**
     * 状态
     */
    private Integer code;

    /**
     * 信息
     */
    private String message;

    /**
     * 文件路径
     */
    private T data;

    public OssResult(ResultEnum resultEnum, T data) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
        this.data = data;
    }

    public OssResult(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }

    public static <T> OssResult<T> success(ResultEnum resultEnum, T data){
        return new OssResult(resultEnum, data);
    }

    public static <T> OssResult<T> success(T data){
        return new OssResult(ResultEnum.SUCCESS, data);
    }

    public static <T> OssResult<T> fail(ResultEnum resultEnum){
        return new OssResult(resultEnum);
    }

    public static <T> OssResult<T> fail(ResultEnum resultEnum, T data){
        return new OssResult(resultEnum, data);
    }
}
