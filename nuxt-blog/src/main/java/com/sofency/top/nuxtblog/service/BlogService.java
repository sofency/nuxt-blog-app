package com.sofency.top.nuxtblog.service;

import com.sofency.top.nuxtblog.dto.BlogDTO;
import com.sofency.top.nuxtblog.dto.BlogDetail;
import com.sofency.top.nuxtblog.entity.Blog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sofency.top.nuxtblog.vo.PageVO;

import java.util.List;

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
    PageVO pageList(Long current);
}
