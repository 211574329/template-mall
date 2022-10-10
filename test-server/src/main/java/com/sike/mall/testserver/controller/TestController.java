package com.sike.mall.testserver.controller;

import com.sike.mall.testserver.service.UserClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private UserClient userClient;

    @GetMapping("getUser")
    public String getUser(){
        return userClient.getUser();
    }
}
