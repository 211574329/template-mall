package com.sike.mall.userserver.controller;


import com.sike.mall.result.entity.R;
import com.sike.mall.user.vo.UserVO;
import com.sike.mall.userserver.dto.UserDTO;
import com.sike.mall.util.jwt.util.JwtUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class LoginController {

    @PostMapping("login")
    public R<String> login(@RequestBody UserDTO UserDTO, HttpSession session){

        // 省略相关逻辑, 直接生成token
        String token = JwtUtil.createJWT(UUID.randomUUID().toString(), UserDTO.getUsername(), 3600L * 1000);
        session.setAttribute("user", new UserVO(1, UserDTO.getUsername()));
        return R.success(token);
    }

    @GetMapping("userInfo")
    public R<UserVO> userInfo(HttpSession session){
        UserVO userVO = (UserVO) session.getAttribute("user");
        return R.success(userVO);
    }

}
