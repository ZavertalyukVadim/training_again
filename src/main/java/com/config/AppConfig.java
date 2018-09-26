package com.config;

import com.interceptor.TestDataInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {
    private final TestDataInterceptor testDataInterceptor;

    @Autowired
    public AppConfig(TestDataInterceptor testDataInterceptor) {
        this.testDataInterceptor = testDataInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(testDataInterceptor).addPathPatterns("/**");
    }
}