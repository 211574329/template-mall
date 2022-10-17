package com.sike.mall.testserver.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * name: 服务名
 * path: 所有方法映射的路径前缀
 * fallback: 熔断器
 */
@FeignClient(name = "user-server", path = "user", fallback = UserClientFallBack.class)
public interface UserClient {

    @GetMapping("/getUser")
    String getUser();

    @RequestMapping("/getUser")
    String getUser2();
}
