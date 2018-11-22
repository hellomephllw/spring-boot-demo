package com.llw.demo.web.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @description: 日志拦截器
 * @author: llw
 * @date: 2018-11-15
 */
public class LoggerInterceptor implements HandlerInterceptor {

    /**logger*/
    private static Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);

    /**请求进入时间*/
    private final static String _REQUEST_ENTER_TIME = "__request_enter_time__";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute(_REQUEST_ENTER_TIME, new Date().getTime());
        logger.info(">>>>>>>>>新的请求进入");
        logger.info("请求方式: " + request.getMethod());
        logger.info("url: " + request.getRequestURI());
        logger.info("完整请求路径: " + request.getRequestURL());
        logger.info("请求参数: " + JSON.toJSONString(request.getParameterMap(), SerializerFeature.DisableCircularReferenceDetect), SerializerFeature.WriteMapNullValue);
        logger.info("ContentType: " + request.getContentType());

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        Long enterTime = (Long) request.getAttribute(_REQUEST_ENTER_TIME);

        logger.info("处理耗时: " + (new Date().getTime() - enterTime) + "ms");

        logger.info(">>>>>>>>>请求结束");
    }
}
