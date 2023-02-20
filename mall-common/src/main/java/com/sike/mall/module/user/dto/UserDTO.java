package com.sike.mall.module.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户dto
 * @author 211574329
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {


    private static final long serialVersionUID = -7005312106917555831L;

    /**
     * id
     */
    private Integer id;
    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
