package com.sofency.top.nuxtblog.config;

import com.sofency.top.nuxtblog.service.UserService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>Project: nuxt-blog - WebMvcConfig
 * <p>Powered by echo On 2024-03-16 19:20:32
 *
 * @author sofency [sofency@qq.com]
 * @version 1.0
 * @since 8
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    private UserService userService;

    @Autowired
    public WebMvcConfig(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void addInterceptors(@NonNull InterceptorRegistry registry) {
        // 只针对该路径拦截
        // registry.addInterceptor(new CommentInterceptor(userService)).addPathPatterns("/blog/comment/submit");
    }
}
