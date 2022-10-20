package com.sike.mall.userserver.controller;


import com.sike.mall.result.entity.R;
import com.sike.mall.userserver.dto.UserDTO;
import com.sike.mall.util.jwt.util.JwtUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class LoginController {

    @PostMapping("login")
    public R<String> login(@RequestBody UserDTO UserDTO){

        // 省略相关逻辑, 直接生成token
        String token = JwtUtil.createJWT(UUID.randomUUID().toString(), UserDTO.getUsername(), 3600L * 1000);
        return R.success(token);
    }

}
