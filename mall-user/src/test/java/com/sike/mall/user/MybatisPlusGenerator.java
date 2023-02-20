package com.sike.mall.user;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.fill.Column;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;

public class MybatisPlusGenerator {
    /// 获取项目路径
    public static void getPath() {

        List<String> paths = new ArrayList<>();

        try {
            //第四种
            String path = ResourceUtils.getURL("classpath:").getPath();
            paths.add("ResourceUtils: " + path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            //第一种
            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            if (!path.exists()) {
                path = new File("");
            }
            paths.add("File(ResourceUtils): " + path.getAbsolutePath());
            paths.add("File(ResourceUtils): " + path.getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //第二种
        String userDir = System.getProperty("user.dir");
        paths.add("user.dir: " + userDir);

        try {
            //第三种
            URL classLoaderResource = ClassUtils.getDefaultClassLoader().getResource("");
            paths.add("ClassLoader: " + classLoaderResource.getPath());
            paths.add("ClassLoader: " + URLDecoder.decode(classLoaderResource.getPath(), "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

//        //第五种  spring boot打jar包，建议使用第五种
//        ApplicationHome applicationHome = new ApplicationHome(getClass());
//        File jarFile = applicationHome.getSource();
//        paths.add("ApplicationHome: " + jarFile.getPath());
//        paths.add("ApplicationHome: " + jarFile.getAbsolutePath());
//        paths.add("ApplicationHome: " + jarFile.getParent());


        //第六种  spring boot打jar包或者不打包，都可以使用的，建议区分系统以完善路径 本种也建议使用
        Properties properties = System.getProperties();
        paths.add("Properties(os.name): " + properties.getProperty("os.name"));
        paths.add("Properties(user.dir): " + properties.getProperty("user.dir"));

        for (String str : paths) {
            System.out.println(str);
        }
    }

    /// 生成代码
    public static void main(String[] args) {
        getPath();

        String dbUrl = "jdbc:mysql://127.0.0.1:3306/haha_db?useUnicode=true&useSSL=false&characterEncoding=utf-8&serverTimezone=UTC";
        // String driverName = "com.mysql.cj.jdbc.Driver"; // ("com.mysql.jdbc.Driver");
        String dbUsername = "root";
        String dbPassword = "12345678";

        String projectPath = System.getProperty("user.dir");
        String globalConfigOutputDir = projectPath + "/src/main/java";
        String globalConfigAuthor = "dk";
        String packageConfigParent = "com.example";

        // https://www.mybatis-plus.com/guide/generator-new.html
        DataSourceConfig.Builder dataSourceConfigBuilder = new DataSourceConfig.Builder(dbUrl, dbUsername, dbPassword);
        FastAutoGenerator fastAutoGenerator = FastAutoGenerator.create(dataSourceConfigBuilder);
        fastAutoGenerator
                .globalConfig(builder -> {
                    builder
                            .enableSwagger() // 开启 swagger 模式
                            .author(globalConfigAuthor)
                            .outputDir(globalConfigOutputDir);
                })
                .packageConfig(builder -> {
                    builder.parent(packageConfigParent)
                            .controller("api.controller");
                })
                // 策略配置
                .strategyConfig((scanner, builder) -> {
                    builder.addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all")))
                            .controllerBuilder() // controller 策略配置
                            .enableRestStyle() // 开启生成@ RestController 控制器
                            .enableHyphenStyle() // 开启驼峰转连字符
                            .entityBuilder() // 实体策略配置
                            .enableLombok() // 开启 lombok 模型
                            .addTableFills(
                                    new Column("create_time", FieldFill.INSERT)
                            ).build();
                })
                // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                //.templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}
