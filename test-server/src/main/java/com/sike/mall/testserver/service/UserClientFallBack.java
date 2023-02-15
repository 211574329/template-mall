package com.sike.mall.testserver.service;

import com.sike.mall.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserClientFallBack implements UserClient{

    @Override
    public UserVO getUser(Integer id) {
        log.error("未查询到{}用户的信息", id);
        return null;
    }

}
