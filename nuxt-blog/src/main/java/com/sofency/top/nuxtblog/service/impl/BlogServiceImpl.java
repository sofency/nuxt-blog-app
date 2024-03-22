package com.sofency.top.nuxtblog.service.impl;

import com.sofency.top.nuxtblog.dto.BlogDTO;
import com.sofency.top.nuxtblog.dto.CommentDTO;
import com.sofency.top.nuxtblog.dto.CommentListDTO;
import com.sofency.top.nuxtblog.entity.Blog;
import com.sofency.top.nuxtblog.exception.ErrorBlogIdException;
import com.sofency.top.nuxtblog.mapper.BlogMapper;
import com.sofency.top.nuxtblog.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sofency.top.nuxtblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {
    private final CommentService commentService;

    @Autowired
    public BlogServiceImpl(CommentService commentService) {
        this.commentService = commentService;
    }

    @Override
    public BlogDTO getBlogInfoByBlogId(Integer blogId) {
        Blog blog = this.getById(blogId);
        if (Objects.isNull(blog)) {
            throw new ErrorBlogIdException("未找到该文件,请检查BlogId");
        }
        List<CommentListDTO> commentListDTOS = commentService.getCommentByBlogId(blogId);
        return BlogDTO.builder().comments(commentListDTOS).blog(blog).build();
    }
}
