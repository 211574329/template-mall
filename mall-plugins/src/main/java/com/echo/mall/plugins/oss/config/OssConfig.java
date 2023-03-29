package com.echo.mall.plugins.oss.config;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * oss配置
 */
@Data
@Component
@ConfigurationProperties(prefix = "oss")
public class OssConfig {

    /**
     * 节点
     */
    private String endpoint;

    /**
     * keyId
     */
    private String accessKeyId;

    /**
     * keySecret
     */
    private String accessKeySecret;

    @Bean
    public OSSClient ossClient() {
        return (OSSClient) new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    }

}
