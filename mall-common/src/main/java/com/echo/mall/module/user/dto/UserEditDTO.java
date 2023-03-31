package com.echo.mall.module.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 用户修改信息dto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEditDTO implements Serializable {

    /**
     * 用户id
     */
    @NotNull
    private Long id;


    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 签名
     */
    private String signature;

}
