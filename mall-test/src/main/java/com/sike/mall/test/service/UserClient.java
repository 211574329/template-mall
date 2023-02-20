package com.sike.mall.test.service;

import com.sike.mall.module.user.dto.UserDTO;
import com.sike.mall.module.user.vo.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


/**
 * name: 服务名
 * path: 所有方法映射的路径前缀
 * fallback: 熔断器
 * @author soke
 */
@FeignClient(name = "mall-user", path = "user", fallback = UserClientFallBack.class)
public interface UserClient {

    @PostMapping("/getUser")
    UserVO getUser(@RequestBody UserDTO userDTO);

    @GetMapping("get")
    UserVO get(@RequestParam Integer id);

    @GetMapping("path/{id}")
    UserVO path(@PathVariable Integer id);

}
