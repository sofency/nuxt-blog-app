package com.sofency.top.nuxtblog.controller;


import com.sofency.top.nuxtblog.dto.BlogDTO;
import com.sofency.top.nuxtblog.dto.Result;
import com.sofency.top.nuxtblog.service.BlogService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/blog")
public class BlogController {
    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @RequestMapping("/{blogId}")
    public Result<BlogDTO> getSingleBlogInfo(@PathVariable("blogId") Integer blogId) {
        BlogDTO blogDTO = blogService.getBlogInfoByBlogId(blogId);
        return Result.success(blogDTO);
    }
}
