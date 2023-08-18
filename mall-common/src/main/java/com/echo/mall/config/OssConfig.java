package com.echo.mall.config;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * oss配置
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "oss")
public class OssConfig implements InitializingBean {

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

    /**
     * bucket名称
     */
    private String bucketName;

    /**
     * 访问前缀
     */
    private String prefix;

    /**
     * 各个模块需要的路径
     */
    private String path;

    /**
     * bucket名称
     */
    public static String BUCKET_NAME;

    /**
     * 访问前缀
     */
    public static String PREFIX;

    /**
     * 各个模块需要的路径
     */
    public static String PATH;


    @Bean
    public OSSClient ossClient() {
        return (OSSClient) new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        BUCKET_NAME = bucketName;
        PREFIX = prefix;
        PATH = path;
    }

}
