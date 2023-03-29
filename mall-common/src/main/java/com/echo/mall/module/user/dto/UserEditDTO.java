package com.echo.mall.module.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 用户修改信息dto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEditDTO implements Serializable {

    private static final long serialVersionUID = -6336969961136301958L;

    /**
     * 用户id
     */
    @NotNull
    private Long id;

    /**
     * 头像文件
     */
    @NotNull
    private MultipartFile file;
}
