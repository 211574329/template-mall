package com.echo.mall.payment;

import com.echo.mall.config.ExecutorConfig;
import com.echo.mall.config.OssConfig;
import com.echo.mall.server.OssServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@ComponentScan(basePackages = "com.echo.mall", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {
                OssServer.class, OssConfig.class, ExecutorConfig.class
        })
})
@SpringBootApplication//(scanBasePackages = "com.echo.mall.*")
@EnableDiscoveryClient
public class MallPaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallPaymentApplication.class, args);
    }

}
