package com.sike.mall.user.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sike.mall.module.user.dto.UserDTO;
import com.sike.mall.module.user.dto.UserEditDTO;
import com.sike.mall.module.user.vo.UserVO;
import com.sike.mall.result.entity.R;
import com.sike.mall.user.entity.User;
import com.sike.mall.user.service.IUserService;
import com.sike.mall.util.page.Pages;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    @PostMapping("getUser")
    public UserVO getUser(@RequestBody UserDTO userDTO){
        return UserVO.builder().id(userDTO.getId()).username(userDTO.getUsername()).build();
    }

    @GetMapping("get")
    public UserVO get(@RequestParam Integer id){
        return UserVO.builder().id(id).build();
    }

    @GetMapping("path/{id}")
    public UserVO path(@PathVariable Integer id){
        return UserVO.builder().id(id).build();
    }

    @GetMapping("find/{id}")
    public User find(@PathVariable Integer id){
        return iUserService.getById(id);
    }

    @PostMapping("list")
    public IPage<UserVO> list(@RequestBody Pages<UserDTO> pages){
        return iUserService.listUser(pages);
    }


    @PostMapping("editHead")
    public R<String> editHead(@Validated UserEditDTO userEditDTO) {
        return R.success(iUserService.editHead(userEditDTO));
    }

}
