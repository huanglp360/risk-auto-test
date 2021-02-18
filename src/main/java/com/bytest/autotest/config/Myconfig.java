package com.bytest.autotest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

/**
 * <h3>risk-auto-test</h3>
 * <p>资源访问</p>
 *
 * @author : hh
 * @date : 2020-05-17 10:13
 **/
@Configuration
public class Myconfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pic/**").addResourceLocations("file:/home/auto-test/idcardPic/");
    }



}
