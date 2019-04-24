package com.llw.demo.constant;

import com.happy.redis.RedisKeyAbstract;

/**
 * @description: redis的key管理工具
 * @author: llw
 * @date: 2018-11-27
 */
public class RedisKey extends RedisKeyAbstract {

    /**管理端模块*/
    private static String _MANAGE_MODULE_CONST = "manage";
    /**商户端模块*/
    private static String _MERCHANT_MODULE_CONST = "merchant";

    /**
     * 以下暴露出来访问
     */
    /**管理端token*/
    public static String _MANAGE_TOKEN = generate(_MANAGE_MODULE_CONST, "token");

}
