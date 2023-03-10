package com.sike.mall.test.controller;

import com.sike.mall.module.user.dto.UserDTO;
import com.sike.mall.module.user.vo.UserVO;
import com.sike.mall.result.entity.R;
import com.sike.mall.test.service.UserClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("test")
public class TestController {

    @Resource
    private UserClient userClient;

    @RequestMapping("list")
    public R<UserVO> list(){
        UserVO build = UserVO.builder().id(1).build();
        return R.success(build);
    }

    @RequestMapping("getUser")
    public R<UserVO> getUser(@RequestBody UserDTO userDTO){
        return R.success(userClient.getUser(userDTO));
    }

    @RequestMapping("get")
    public R<UserVO> getUser(Integer id){
        return R.success(userClient.get(id));
    }

    @RequestMapping("path")
    public R<UserVO> path(Integer id){
        return R.success(userClient.path(id));
    }

    @GetMapping("userInfo")
    public R<UserVO> userInfo(HttpSession session){
        UserVO userVO = (UserVO) session.getAttribute("user");
        return R.success(userVO);
    }

}
