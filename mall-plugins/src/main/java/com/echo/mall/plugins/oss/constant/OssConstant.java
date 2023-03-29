package com.echo.mall.plugins.oss.constant;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * oss相关常量
 */
@Component
public class OssConstant implements InitializingBean {

    /**
     * bucket名称
     */
    @Value("${oss.bucketName}")
    private String bucketName;

    /**
     * 访问前缀
     */
    @Value("${oss.urlPrefix}")
    private String urlPrefix;

    /**
     * 头像路径
     */
    @Value("${oss.headPortraitPath}")
    private String headPortraitPath;

    /**
     * bucket名称
     */
    public static String BUCKET_NAME;

    /**
     * 访问前缀
     */
    public static String URL_PREFIX;

    /**
     * 头像路径
     */
    public static String HEAD_PORTRAIT_PATH;

    @Override
    public void afterPropertiesSet() throws Exception {
        BUCKET_NAME = bucketName;
        URL_PREFIX = urlPrefix;
        HEAD_PORTRAIT_PATH = headPortraitPath;
    }
}
