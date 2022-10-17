package com.sike.mall.testserver.controller;

import com.sike.mall.testserver.service.UserClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("test")
public class TestController {

    @Resource
    private UserClient userClient;

    @GetMapping("getUser")
    public String getUser(){
        return userClient.getUser();
    }

    @GetMapping("getUser2")
    public String getUser2(){
        return userClient.getUser();
    }
}
