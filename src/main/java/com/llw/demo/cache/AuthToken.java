package com.llw.demo.cache;

import lombok.Data;

/**
 * @description: token
 * @author: llw
 * @date: 2018-11-28
 */
@Data
public class AuthToken {

    /**token*/
    private String token;
    /**auth类型*/
    private String type;
    /**用户session*/
    private Session session;

}
