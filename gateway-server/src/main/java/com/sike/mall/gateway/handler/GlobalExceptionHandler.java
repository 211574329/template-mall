package com.sike.mall.gateway.handler;

import com.sike.mall.result.enums.ResultEnum;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.DefaultErrorWebExceptionHandler;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.cloud.gateway.support.NotFoundException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.reactive.function.server.*;

import java.util.HashMap;
import java.util.Map;

public class GlobalExceptionHandler extends DefaultErrorWebExceptionHandler {
    /**
     * Create a new {@code DefaultErrorWebExceptionHandler} instance.
     *
     * @param errorAttributes    the error attributes
     * @param resourceProperties the resources configuration properties
     * @param errorProperties    the error configuration properties
     * @param applicationContext the current application context
     */
    public GlobalExceptionHandler(ErrorAttributes errorAttributes, ResourceProperties resourceProperties, ErrorProperties errorProperties, ApplicationContext applicationContext) {
        super(errorAttributes, resourceProperties, errorProperties, applicationContext);
    }


    @Override
    protected Map<String, Object> getErrorAttributes(ServerRequest request, ErrorAttributeOptions options) {
        Throwable error = super.getError(request);
        ResultEnum resultEnum = ResultEnum.FAIL;
        if (error instanceof NotFoundException) {
            resultEnum = ResultEnum.NO_HANDLER_ERROR;
        }
        if (error instanceof AuthException) {
            resultEnum = ResultEnum.UNAUTHORIZED;
        }
        if (error instanceof IllegalityException) {
            resultEnum = ResultEnum.ILLEGALITY;
        }
        Map<String, Object> map = new HashMap<>();
        //map.put("success", false);
        map.put("code", resultEnum.getCode());
        map.put("message", resultEnum.getMessage());
        map.put("data", null);
        return map;
        //return super.getErrorAttributes(request, options);
    }


    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
        return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse);
    }

    @Override
    protected int getHttpStatus(Map<String, Object> errorAttributes) {
        return 200;
    }
}
