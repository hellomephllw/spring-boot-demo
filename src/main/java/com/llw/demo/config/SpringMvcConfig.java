package com.llw.demo.config;

import com.llw.demo.web.interceptor.LoggerInterceptor;
import com.llw.demo.web.interceptor.ManageAuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description: spring mvc配置
 * @author: llw
 * @date: 2018-11-15
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.llw.exception")
public class SpringMvcConfig implements WebMvcConfigurer {

    /**
     * 权限拦截器:
     * 因为拦截器需要注入service, 且在spring context之前加载
     */
    @Bean
    public ManageAuthInterceptor manageAuthInterceptor() {
        return new ManageAuthInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //日志拦截器
        registry.addInterceptor(new LoggerInterceptor())
                .addPathPatterns("/api/**");
        //管理端权限拦截器
        registry.addInterceptor(manageAuthInterceptor())
                .addPathPatterns("/api/manage/**")
                .excludePathPatterns("/api/manage/admin/login");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //静态目录
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //swagger
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
