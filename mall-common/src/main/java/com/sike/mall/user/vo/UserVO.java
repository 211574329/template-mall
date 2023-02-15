package com.sike.mall.user.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户信息
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserVO implements Serializable {


    private static final long serialVersionUID = -1685566705261473712L;

    /**
     * id
     */
    private Integer id;

    /**
     * 账号
     */
    private String username;

}
