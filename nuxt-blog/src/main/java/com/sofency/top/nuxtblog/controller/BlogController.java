package com.sofency.top.nuxtblog.controller;



import com.sofency.top.nuxtblog.dto.BlogDTO;
import com.sofency.top.nuxtblog.dto.Result;
import com.sofency.top.nuxtblog.service.BlogService;
import com.sofency.top.nuxtblog.vo.PageVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * </p>
 *
 * @author sofency
 * @since 2024-03-16
 */
@RestController
@RequestMapping("/blog")
public class BlogController {
    private static final Logger logger = LoggerFactory.getLogger(BlogController.class);

    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @RequestMapping("/detail/{blogId}")
    public Result<BlogDTO> getSingleBlogInfo(@PathVariable("blogId") Integer blogId) {
        BlogDTO blogDTO = blogService.getBlogInfoByBlogId(blogId);
        return Result.success(blogDTO);
    }

    @RequestMapping("/page")
    public Result<PageVO> getBlogList(@RequestParam(defaultValue = "1") Long current) {
        logger.info("current {}", current);
        PageVO pageVO = blogService.pageList(current);
        return Result.success(pageVO);
    }
}

