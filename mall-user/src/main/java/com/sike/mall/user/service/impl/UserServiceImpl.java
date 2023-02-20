package com.sike.mall.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sike.mall.module.user.dto.UserDTO;
import com.sike.mall.module.user.vo.UserVO;
import com.sike.mall.user.entity.User;
import com.sike.mall.user.mapper.UserMapper;
import com.sike.mall.user.service.IUserService;
import com.sike.mall.util.page.Pages;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author
 * @since 2022-10-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public IPage<UserVO> listUser(Pages<UserDTO> pages) {
        IPage<UserVO> iPage = new Page<>(pages.getPageIndex(), pages.getPageSize());
        return userMapper.listUser(iPage, pages.getData());
    }
}
