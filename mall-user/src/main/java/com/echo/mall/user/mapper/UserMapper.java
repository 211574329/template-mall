package com.echo.mall.user.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.echo.mall.module.user.dto.UserEditDTO;
import com.echo.mall.user.entity.User;
import com.echo.mall.module.user.dto.UserDTO;
import com.echo.mall.module.user.vo.UserVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author  echo
 * @since 2022-10-09
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 用户分页列表
     * @param page      分页参数
     * @param userDTO   用户参数
     * @return
     */
    IPage<UserVO> listUser(IPage<UserVO> page, @Param("user") UserDTO userDTO);

    /**
     * 更新用户
     * @param userEditDTO   用户信息
     * @return
     */
    Integer updateUser(UserEditDTO userEditDTO);
}
