package com.sofency.top.nuxtblog.controller;


import com.sofency.top.nuxtblog.dto.Result;
import com.sofency.top.nuxtblog.entity.Archive;
import com.sofency.top.nuxtblog.service.ArchiveService;
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
    private final ArchiveService archiveService;

    @Autowired
    public ArchiveController(ArchiveService archiveService) {
        this.archiveService = archiveService;
    }

    @RequestMapping("/")
    public Result<List<Archive>> list() {
        return Result.success(archiveService.list());
    }
}

