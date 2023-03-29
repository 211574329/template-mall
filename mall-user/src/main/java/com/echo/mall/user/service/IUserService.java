package com.echo.mall.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.echo.mall.user.entity.User;
import com.echo.mall.util.page.Pages;
import com.echo.mall.module.user.dto.UserDTO;
import com.echo.mall.module.user.dto.UserEditDTO;
import com.echo.mall.module.user.vo.UserVO;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author
 * @since 2022-10-09
 */
@Service
public interface IUserService extends IService<User> {

    /**
     * 用户分页列表
     *
     * @param pages 分页参数
     * @return
     */
    IPage<UserVO> listUser(Pages<UserDTO> pages);

    /**
     * 修改用户头像
     *
     * @param userEditDTO 修改信息dto
     * @return
     */
    String editHead(UserEditDTO userEditDTO);

}
