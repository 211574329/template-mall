package com.sike.mall.gateway.handler;

import lombok.Data;

@Data
public class IllegalityException extends Exception{

    private String message;

    public IllegalityException(String message) {
        super(message);
        this.message = message;
    }

    public IllegalityException() {
    }
}
