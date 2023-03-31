package com.echo.mall.plugins.oss.util;

import com.aliyun.oss.OSSClient;
import com.echo.mall.enums.DateEnum;
import com.echo.mall.enums.StockEnum;
import com.echo.mall.plugins.oss.constant.OssConstant;
import com.echo.mall.result.entity.R;
import com.echo.mall.result.enums.ResultEnum;
import com.echo.mall.util.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

/**
 * oss工具类
 */
@Slf4j
@Component
public class OssUtil {

    @Resource
    private OSSClient ossClient;

    /**
     * 上传文件，以IO流方式
     * 文件路径:path/YYYYMMDD/HHMMSS.文件后缀
     *
     * @param file 文件
     * @param path 上传路径
     * @return  文件存放路径
     */
    public R<String> upload(MultipartFile file, String path) {
        String objectName = null;
        InputStream inputStream = null;
        try {
            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(StockEnum.DOT.getStock()));
            objectName = new StringBuilder(path).append(DateUtil.getNow(DateEnum.YYYY_MM_DD)).append(StockEnum.BAR.getStock()).append(DateUtil.getNow(DateEnum.HH_MM_SS)).append(suffix).toString();
            inputStream = file.getInputStream();
            ossClient.putObject(OssConstant.BUCKET_NAME, objectName, inputStream);
            return R.success(objectName);
        } catch (Exception e) {
            log.error("文件上传失败, 文件路径:{}", objectName);
            e.printStackTrace();
            return R.fail(ResultEnum.FILE_ERROR);
        } finally {
            close(inputStream);
        }
    }

    /**
     * 删除文件
     *
     * @param objectName 文件名(完整文件名包括文件夹, 例如:a/b/c/1.png)
     */
    public void delete(String objectName) {
        ossClient.deleteObject(OssConstant.BUCKET_NAME, objectName);
    }

    /**
     * 关闭流
     *
     * @param inputStream 输入流
     */
    public static void close(InputStream inputStream) {
        try {
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
