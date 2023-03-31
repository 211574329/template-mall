package com.echo.mall.user.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.echo.mall.module.user.dto.UserDTO;
import com.echo.mall.module.user.dto.UserEditDTO;
import com.echo.mall.module.user.dto.UserEditHeadDTO;
import com.echo.mall.module.user.vo.UserVO;
import com.echo.mall.result.entity.R;
import com.echo.mall.user.entity.User;
import com.echo.mall.user.service.IUserService;
import com.echo.mall.util.page.Pages;
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
    public R<String> editHead(@Validated UserEditHeadDTO userEditHeadDTO) {
        return R.success(iUserService.editHead(userEditHeadDTO));
    }

    @PostMapping("update")
    public R<String> update(@Validated @RequestBody UserEditDTO userEditDTO) {
        iUserService.updateUser(userEditDTO);
        return R.success();
    }


}
