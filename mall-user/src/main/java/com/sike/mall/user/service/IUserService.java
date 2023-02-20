package com.sike.mall.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sike.mall.module.user.dto.UserDTO;
import com.sike.mall.module.user.vo.UserVO;
import com.sike.mall.user.entity.User;
import com.sike.mall.util.page.Pages;
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
     * @param pages      分页参数
     * @return
     */
    IPage<UserVO> listUser(Pages<UserDTO> pages);

}
