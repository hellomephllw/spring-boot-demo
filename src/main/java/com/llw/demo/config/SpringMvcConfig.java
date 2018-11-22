package com.llw.demo.config;

import com.llw.demo.web.interceptor.LoggerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description: spring mvc配置
 * @author: llw
 * @date: 2018-11-15
 */
@Configuration
@EnableWebMvc
public class SpringMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //日志拦截器
        registry.addInterceptor(new LoggerInterceptor())
                .addPathPatterns("/api/**");
    }

}
