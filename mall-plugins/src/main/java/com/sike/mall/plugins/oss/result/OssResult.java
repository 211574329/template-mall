package com.sike.mall.plugins.oss.result;

import com.sike.mall.result.enums.ResultEnum;
import lombok.Data;

/**
 * oss响应实体
 */
@Data
public class OssResult {

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
    private String data;

    public OssResult(ResultEnum resultEnum, String data) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
        this.data = data;
    }
    public OssResult(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }

    public static OssResult success(ResultEnum resultEnum, String data){
        return new OssResult(resultEnum, data);
    }

    public static OssResult fail(ResultEnum resultEnum){
        return new OssResult(resultEnum);
    }
}
