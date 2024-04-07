package com.sofency.top.nuxtblog.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sofency.top.nuxtblog.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.sql.SQLDataException;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author sofency
 * @since 2024-03-16
 */
public interface UserService extends IService<User> {
    User getUserById(Integer userId);
    User getUserInfo(User user) throws JsonProcessingException, SQLDataException;
}
