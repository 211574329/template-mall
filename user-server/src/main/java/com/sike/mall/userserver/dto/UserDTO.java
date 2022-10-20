package com.sike.mall.userserver.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {


    private static final long serialVersionUID = -7005312106917555831L;
    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
