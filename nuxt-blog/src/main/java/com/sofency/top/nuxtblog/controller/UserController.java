package com.sofency.top.nuxtblog.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.sofency.top.nuxtblog.dto.Result;
import com.sofency.top.nuxtblog.entity.User;
import com.sofency.top.nuxtblog.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLDataException;

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

    @RequestMapping("/login")
    public Result<User> login(@RequestBody User user, HttpServletRequest request) throws JsonProcessingException, SQLDataException {
        userService.saveSession(request.getSession(), user);
        return Result.success(user);
    }
}

