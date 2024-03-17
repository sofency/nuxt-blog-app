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
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public void saveSession(HttpSession session, User user) throws JsonProcessingException, SQLDataException {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq(User.NICKNAME, user.getNickname());
        List<User> userList = this.list(wrapper);
        logger.info("current nickname find result {}", userList.size());
        if (CollectionUtils.isEmpty(userList)) {
            user.setRegisterTime(new Date());
            boolean success = this.save(user);
            logger.info("save nickname {} to db , result: {}", user.getNickname(), success);
            if (success) {
                session.setAttribute("user", JsonUtils.toJson(user));
            } else {
                throw new SQLDataException("登录数据保存失败");
            }
        } else {
            session.setAttribute("user", JsonUtils.toJson(userList.get(0)));
        }
    }
}
