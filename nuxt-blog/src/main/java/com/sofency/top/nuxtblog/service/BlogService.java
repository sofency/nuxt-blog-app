package com.sofency.top.nuxtblog.service;

import com.sofency.top.nuxtblog.dto.BlogDTO;
import com.sofency.top.nuxtblog.entity.Blog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sofency
 * @since 2024-03-16
 */
public interface BlogService extends IService<Blog> {
    public BlogDTO getBlogInfoByBlogId(Integer blogId);
}
