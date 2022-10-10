package com.sike.mall.testserver.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(name = "user-server", fallback = UserClientFallBack.class)
public interface UserClient {

    @GetMapping("/getUser")
    String getUser();
}
