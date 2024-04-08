package com.sofency.top.nuxtblog.controller;


import com.sofency.top.nuxtblog.dto.ArchiveDTO;
import com.sofency.top.nuxtblog.dto.Result;
import com.sofency.top.nuxtblog.entity.Archive;
import com.sofency.top.nuxtblog.service.ArchiveService;
import com.sofency.top.nuxtblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author sofency
 * @since 2024-04-07
 */
@RestController
@RequestMapping("/blog/archive")
public class ArchiveController {
    private final BlogService blogService;

    @Autowired
    public ArchiveController(BlogService blogService) {
        this.blogService = blogService;
    }

    @RequestMapping("/")
    public Result<List<ArchiveDTO>> list() {
        return Result.success(blogService.buildArchives());
    }
}

