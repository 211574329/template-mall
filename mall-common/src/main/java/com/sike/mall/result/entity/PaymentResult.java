package com.sike.mall.result.entity;

import com.sike.mall.result.enums.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 支付结果
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResult<T> {

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

    public PaymentResult(ResultEnum resultEnum, T data) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
        this.data = data;
    }

    public PaymentResult(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }

    public static <T> PaymentResult<T> success(ResultEnum resultEnum, T data) {
        return new PaymentResult(resultEnum, data);
    }

    public static <T> PaymentResult<T> success(T data){
        return new PaymentResult(ResultEnum.SUCCESS, data);
    }

    public static <T> PaymentResult<T> fail(ResultEnum resultEnum) {
        return new PaymentResult(resultEnum);
    }

    public static <T> PaymentResult<T> fail(ResultEnum resultEnum, T data) {
        return new PaymentResult(resultEnum, data);
    }


}
