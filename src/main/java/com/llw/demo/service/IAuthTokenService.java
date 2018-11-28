package com.llw.demo.service;

import com.llw.demo.cache.AuthToken;

/**
 * @description:
 * @author: llw
 * @date: 2018-11-28
 */
public interface IAuthTokenService {

    public AuthToken add(String token, String type, long durationSecond) throws Exception;

    public AuthToken update(String token, long durationSecond) throws Exception;

    public AuthToken get(String token) throws Exception;

    public boolean exist(String token) throws Exception;

}
