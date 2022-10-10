package com.sike.mall.userserver.service.impl;

import com.sike.mall.userserver.entity.User;
import com.sike.mall.userserver.mapper.UserMapper;
import com.sike.mall.userserver.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
