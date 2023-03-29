package com.echo.mall.gateway.handler;

import lombok.Data;

@Data
public class AuthException extends Exception{

    private String message;

    public AuthException(String message) {
        super(message);
        this.message = message;
    }

    public AuthException() {
    }
}
