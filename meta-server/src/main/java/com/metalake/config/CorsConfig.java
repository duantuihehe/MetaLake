package com.metalake.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")  // 指定需要允许跨域的URL路径
                .allowedOrigins("*")  // 允许所有源
                .allowedMethods(HttpMethod.GET.name(), HttpMethod.POST.name());  // 允许GET和POST方法
    }
}