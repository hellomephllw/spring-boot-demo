package com.llw.demo.service.impl;

import com.llw.demo.cache.AuthToken;
import com.llw.demo.service.IAuthTokenService;
import com.happy.exception.BusinessException;
import com.happy.redis.RedisAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: llw
 * @date: 2018-11-28
 */
@Service
public class IAuthTokenServiceImpl implements IAuthTokenService {

    @Autowired
    private RedisAccess redisAccess;

    @Override
    public AuthToken add(String token, String type, long durationSecond) throws Exception {
        AuthToken authToken = new AuthToken();
        authToken.setToken(token);
        authToken.setType(type);

        //存入
        redisAccess.putObject(token, authToken, durationSecond);

        return authToken;
    }

    @Override
    public AuthToken update(String token, long durationSecond) throws Exception {
        if (redisAccess.existObject(token)) {
            redisAccess.expireObject(token, durationSecond);
        } else {
            throw new BusinessException("不存在的token");
        }

        return redisAccess.getObject(token, AuthToken.class);
    }

    @Override
    public AuthToken get(String token) throws Exception {
        return redisAccess.getObject(token, AuthToken.class);
    }

    @Override
    public boolean exist(String token) throws Exception {
        return redisAccess.existObject(token);
    }
}
