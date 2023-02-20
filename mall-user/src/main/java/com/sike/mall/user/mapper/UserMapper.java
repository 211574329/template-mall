package com.sike.mall.user.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sike.mall.module.user.dto.UserDTO;
import com.sike.mall.module.user.vo.UserVO;
import com.sike.mall.user.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author  sike
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

}
