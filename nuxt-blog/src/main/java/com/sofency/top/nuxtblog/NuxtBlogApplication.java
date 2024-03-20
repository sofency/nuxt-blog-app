package com.sofency.top.nuxtblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.sofency.top.nuxtblog.mapper")
public class NuxtBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(NuxtBlogApplication.class, args);
    }

}
