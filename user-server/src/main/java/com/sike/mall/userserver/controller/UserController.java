package com.sike.mall.userserver.controller;


import com.sike.mall.userserver.entity.User;
import com.sike.mall.userserver.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author  
 * @since 2022-10-09
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService iUserService;

    @GetMapping("getUser")
    public String user(){
        return "wwwww";
    }

    @GetMapping("list")
    public List<User> list(){
        return iUserService.list();
    }

    @GetMapping("list2")
    public List<User> list2(){
        return iUserService.list();
    }


}
