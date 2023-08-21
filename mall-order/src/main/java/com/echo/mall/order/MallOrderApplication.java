package com.echo.mall.order;

import com.echo.mall.config.ExecutorConfig;
import com.echo.mall.config.OssConfig;
import com.echo.mall.server.OssServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@ComponentScan(basePackages = "com.echo.mall", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {
                OssServer.class, OssConfig.class, ExecutorConfig.class
        })
})
@SpringBootApplication//(scanBasePackages = "com.echo.mall")
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
@MapperScan("com.echo.mall.order.**.mapper")
public class MallOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallOrderApplication.class, args);
    }

}
