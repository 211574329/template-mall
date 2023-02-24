package com.sike.mall.test;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class MybatisPlusGenerator {

    // 官网新版生成 https://baomidou.com/pages/981406/
    public static void main(String[] args) {
        String url = "jdbc:mysql://local:3306/info?useSSL=false&serverTimezone=UTC&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false";
        String username = "root";
        String password = "123456";

        String path = System.getProperty("user.dir") + "/mall-test/src/main/java";
        String parentPackage = "com.sike.mall.generator";

        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                   builder.author("k")
                           .outputDir(path);
                })
                .packageConfig(builder -> {
                    builder.parent(parentPackage);
                            //.pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D://"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude("user")
                            //.addTablePrefix("t_", "c_")
                            .entityBuilder()
                            // 开启 lombok 模型
                            .enableLombok()
                            .mapperBuilder()
                            // 启用 BaseResultMap 生成
                            .enableBaseResultMap()
                            .controllerBuilder()
                            // 开启生成@RestController 控制器
                            .enableRestStyle();
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }


}
