package com.sofency.top.nuxtblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.sofency.top.nuxtblog.entity.User;
import com.sofency.top.nuxtblog.mapper.UserMapper;
import com.sofency.top.nuxtblog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 服务实现类
 * 后续实现 binlog监听更新缓存
 * </p>
 *
 * @author sofency
 * @since 2024-03-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    // 创建一个Guava本地缓存，设置缓存的过期时间和最大容量
    private final Cache<Integer, User> userCache = CacheBuilder.newBuilder()
            .expireAfterWrite(10, TimeUnit.MINUTES) // 10分钟后过期
            .maximumSize(100) // 最大缓存100个用户
            .build();

    // 根据ID从缓存中获取用户，如果不存在则从数据库中获取并存入缓存
    public User getUserById(Integer userId) {
        User user = userCache.getIfPresent(userId);
        if (user == null) {
            synchronized (this) {
                user = userCache.getIfPresent(userId);
                if (user == null) {
                    user = this.getById(userId);
                    userCache.put(userId, user);
                }
            }
        }
        return user;
    }

    // 更新用户信息到缓存
    public void updateUser(Integer userId, User updatedUser) {
        userCache.put(userId, updatedUser);
    }

    // 清除缓存
    public void evictUser(Integer userId) {
        userCache.invalidate(userId);
    }

    // 清空所有缓存
    public void evictAll() {
        userCache.invalidateAll();
    }

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
            if (!Objects.equals(temp.getWebsite(), user.getWebsite())) {
                temp.setWebsite(user.getWebsite());
                this.updateById(temp);
            }
            return temp;
        }
    }
}
