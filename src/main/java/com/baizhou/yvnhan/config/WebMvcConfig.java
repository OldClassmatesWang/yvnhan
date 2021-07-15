package com.baizhou.yvnhan.config;

import com.baizhou.yvnhan.bean.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author HaiPeng Wang
 * @date 2021/7/14 16:16
 * @Description:
 */
@EnableWebMvc //开启SpringMVC注解
@Configuration //配置实现Springmvc的配置文件
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    LoginInterceptor loginInterceptor;

    /**
     * 配置拦截器
     * 参数是一个拦截器注册对象
     * addInterceptor 是注册一个自行编写的拦截器，会组成一个拦截器链
     * addPathPatterns
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/*")
                .excludePathPatterns(   //可以访问的路径，其他路径被拦截不管有没有配置token
                        "/swagger-ui.html",
                        "/",
                        "/index",
                        "/login",
                        "/register",
                        "/yvnhan/book/test"
                );
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").
                allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }
}