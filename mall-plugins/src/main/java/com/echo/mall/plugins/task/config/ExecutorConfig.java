package com.echo.mall.plugins.task.config;

import com.echo.mall.constant.TaskConstant;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池配置
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "task.pool")
public class ExecutorConfig {

    /**
     * 线程核心数
     */
    private Integer coreSize;
    /**
     * 最大线程数
     */
    private Integer maxSize;
    /**
     * 缓冲队列
     */
    private Integer queueCapacity;
    /**
     * 线程的空闲时间
     */
    private Integer keepAlive;
    /**
     * 允许核心线程超时
     */
    private Boolean allowCoreThreadTimeOut;
    /**
     * 等待任务在关闭时完成
     */
    private Boolean waitShutdown;


    @Bean(TaskConstant.DEFAULT_POOL_NAME)
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 线程核心数
        executor.setCorePoolSize(coreSize);
        // 最大线程数
        executor.setMaxPoolSize(maxSize);
        // 线程前缀
        executor.setThreadNamePrefix(TaskConstant.DEFAULT_POOL_PREFIX);
        // 缓冲队列
        executor.setQueueCapacity(queueCapacity);
        // 线程的空闲时间
        executor.setKeepAliveSeconds(keepAlive);
        // 允许核心线程超时
        executor.setAllowCoreThreadTimeOut(allowCoreThreadTimeOut);
        // 等待任务在关闭时完成
        executor.setWaitForTasksToCompleteOnShutdown(waitShutdown);
        // 当pool达到max size时,不在新线程执行任务,由调用者所在的线程执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}

