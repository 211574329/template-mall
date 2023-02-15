package com.sike.mall.userserver.handler;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.sike.mall.result.entity.R;
import com.sike.mall.result.enums.ResultEnum;
import com.sike.mall.result.vo.FieldErrorVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

/**
 * 异常解析器
 */
@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    /**
     * 其它异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public R<String> handler(Exception e){
        Throwable cause = e.getCause() == null ? e : e.getCause();
        String message = e.getMessage();
        if(cause instanceof NumberFormatException){
            return R.fail(ResultEnum.NUMBER_FORMAT_ERROR, message);
        }
        return R.fail(e.getMessage());
    }


    /**
     * 请求方式异常 如：post接口用get方式调用
     * @param e
     * @return
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public R<String> handler(HttpRequestMethodNotSupportedException e){
        return R.fail(ResultEnum.METHOD_NOT_SUPPORTED_ERROR, e.getMessage());
    }


    /**
     * json参数校验异常 必填参数为空
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R<List<FieldErrorVO>> handler(MethodArgumentNotValidException e){
        // 提取验证失败的所有的信息
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        // 格式化
        List<FieldErrorVO> list = toValidatorMsg(fieldErrors);
        return R.fail(ResultEnum.JSON_VALID_ERROR, list);
    }

    /**
     * 普通参数校验异常 如：必填参数为空/Integet类型传了String
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    public R<List<FieldErrorVO>> handle(BindException e){
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<FieldErrorVO> list = toValidatorMsg(fieldErrors);
        return R.fail(ResultEnum.VALID_ERROR, list);
    }
    /**
     * Json异常 如：body为空 / 无法解析的JSON / Integet类型传了String
     * @param e
     * @return
     */
    @ExceptionHandler({HttpMessageNotReadableException.class, InvalidFormatException.class, JsonParseException.class})
    public R<String> handle(Exception e){
        Throwable cause = e.getCause() == null ? e : e.getCause();
        String message = e.getMessage();
        if(cause instanceof InvalidFormatException){
            return R.fail(ResultEnum.INVALID_FORMAT_ERROR, message);
        }
        if (cause instanceof JsonParseException){
            return R.fail(ResultEnum.JSON_PARSE_ERROR, message);
        }
        return R.fail(ResultEnum.REQUEST_BODY_MISS, message);
    }


    /**
     * 处理由断言 IllegalArgumentException 抛出的异常信息
     * @param e
     * @return
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public R<String> handleArgError(IllegalArgumentException e){
        return R.fail(ResultEnum.ASSERT_ERROR, e.getMessage());
    }


    /**
     * 异常属性解析
     * @param fieldErrorList    异常属性集合
     * @return
     */
    private List<FieldErrorVO> toValidatorMsg(List<FieldError> fieldErrorList) {
        List<FieldErrorVO> list = new ArrayList<>();
        fieldErrorList.stream().forEach(x -> list.add(FieldErrorVO.builder().field(x.getField()).message(x.getDefaultMessage()).build()));
        /*
        List<Map<String, String>> mapList = new ArrayList<>();
        // 循环提取
        for (FieldError fieldError : fieldErrorList) {
            Map<String, String> map = new HashMap<>();
            // 获取验证失败的属性
            map.put("field", fieldError.getField());
            // 获取验证失败的的提示信息
            map.put("msg", fieldError.getDefaultMessage());
            mapList.add(map);
        }

         */
        return list;
    }
}
