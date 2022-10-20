package com.sike.mall.testserver.service;

import org.springframework.stereotype.Component;

@Component
public class UserClientFallBack implements UserClient{

    @Override
    public String getUser() {
        return "未查询到user";
    }

}
