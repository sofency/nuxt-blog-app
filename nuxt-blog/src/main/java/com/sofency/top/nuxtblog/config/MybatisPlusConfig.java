package com.sofency.top.nuxtblog.config;

import com.sofency.top.nuxtblog.handler.MyMetaObjectHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;  
  
@Configuration  
public class MybatisPlusConfig {

    @Bean
    public MyMetaObjectHandler myMetaObjectHandler() {
        return new MyMetaObjectHandler();
    }
}