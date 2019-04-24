package com.llw.demo.web.interceptor;

import com.llw.demo.cache.AuthToken;
import com.llw.demo.constant.CacheTimeConst;
import com.llw.demo.service.IAuthTokenService;
import com.happy.exception.BusinessException;
import com.happy.redis.RedisAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 管理端权限拦截器
 * @author: llw
 * @date: 2018-11-28
 */
public class ManageAuthInterceptor implements HandlerInterceptor {

    @Autowired
    private IAuthTokenService authTokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getParameter("token");
        if (token == null || "".equals(token)) {
            throw new BusinessException("缺少token");
        }

        if (authTokenService.exist(token)) {
            //更新token过期时间
            authTokenService.update(token, CacheTimeConst._MANAGE_ADMIN_EXPIRE);

            return true;
        }

        throw new BusinessException("token无效");
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}
