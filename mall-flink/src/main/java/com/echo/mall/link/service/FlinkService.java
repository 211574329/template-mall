package com.echo.mall.link.service;

import org.apache.flink.api.java.ExecutionEnvironment;

import javax.annotation.PostConstruct;

//@Component
public class FlinkService {


    @PostConstruct
    public void runFlinkJob() throws Exception {
        // 创建Flink ExecutionEnvironment
        ExecutionEnvironment env = ExecutionEnvironment.createLocalEnvironment();



    }

}
