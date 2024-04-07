package com.sofency.top.nuxtblog.controller;


import com.sofency.top.nuxtblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author sofency
 * @since 2024-03-16
 */
@RestController
@RequestMapping("/blog/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

}

