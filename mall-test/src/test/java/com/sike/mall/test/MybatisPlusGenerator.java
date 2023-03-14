package com.sike.mall.test;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class MybatisPlusGenerator {

    // 官网新版生成 https://baomidou.com/pages/981406/
    public static void main(String[] args) {

        String path = System.getProperty("user.dir") + "/mall-order/src/main/java";
        String parentPackage = "com.sike.mall.order";

        FastAutoGenerator.create(null, null, null)
                .globalConfig(builder -> {
                   builder.author("")
                           .outputDir(path);
                })
                .packageConfig(builder -> {
                    builder.parent(parentPackage);
                            //.pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D://"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude("order")
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
