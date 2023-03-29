package com.echo.mall.test.service;

import com.echo.mall.module.user.dto.UserDTO;
import com.echo.mall.module.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 用户服务back
 * @author echo
 */
@Slf4j
@Component
public class UserClientFallBack implements UserClient{

    @Override
    public UserVO getUser(UserDTO userDTO) {
        log.error("未查询到{}用户的信息", userDTO.getUsername());
        return null;
    }

    @Override
    public UserVO get(Integer id) {
        log.error("未查询到{}用户的信息", id);
        return null;
    }

    @Override
    public UserVO path(Integer id) {
        log.error("未查询到{}用户的信息", id);
        return null;
    }

}
