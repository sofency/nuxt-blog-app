package com.sofency.top.nuxtblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sofency.top.nuxtblog.controller.UserController;
import com.sofency.top.nuxtblog.entity.User;
import com.sofency.top.nuxtblog.mapper.UserMapper;
import com.sofency.top.nuxtblog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sofency.top.nuxtblog.utils.JsonUtils;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.sql.SQLDataException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author sofency
 * @since 2024-03-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public User getUserInfo(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq(User.NICKNAME, user.getNickname());
        wrapper.eq(User.EMAIL, user.getEmail());
        List<User> users = this.list(wrapper);
        if (CollectionUtils.isEmpty(users)) {
            user.setRegisterTime(new Date());
            this.save(user);
            return user;
        } else {
            User temp = users.get(0);
            if (!Objects.equals(temp.getWebsite(), user.getWebsite())){
                temp.setWebsite(user.getWebsite());
                this.updateById(temp);
            }
            return temp;
        }
    }
}
