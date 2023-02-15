package com.sike.mall.testserver.controller;

import com.sike.mall.result.entity.R;
import com.sike.mall.testserver.service.UserClient;
import com.sike.mall.user.vo.UserVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("test")
public class TestController {

    @Resource
    private UserClient userClient;

    @GetMapping("getUser")
    public R<UserVO> getUser(Integer id){
        return R.success(userClient.getUser(id));
    }

    @GetMapping("userInfo")
    public R<UserVO> userInfo(HttpSession session){
        UserVO userVO = (UserVO) session.getAttribute("user");
        return R.success(userVO);
    }

}
