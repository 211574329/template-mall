package com.echo.mall.user.controller;


import com.echo.mall.module.user.dto.UserDTO;
import com.echo.mall.module.user.vo.UserVO;
import com.echo.mall.result.entity.R;
import com.echo.mall.util.jwt.util.JwtUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 *
 * @author echo
 */
@RestController
@RequestMapping("/user")
public class LoginController {

    @PostMapping("login")
    public R<String> login(@RequestBody UserDTO userDTO, HttpSession session){

        // 省略相关逻辑, 直接生成token
        String token = JwtUtil.createJWT(UUID.randomUUID().toString(), userDTO.getUsername(), 3600L * 1000);
        //session.setAttribute("user", new UserVO(1, userDTO.getUsername()));
        return R.success(token);
    }

    @GetMapping("userInfo")
    public R<UserVO> userInfo(HttpSession session){
        UserVO userVO = (UserVO) session.getAttribute("user");
        return R.success(userVO);
    }

}
