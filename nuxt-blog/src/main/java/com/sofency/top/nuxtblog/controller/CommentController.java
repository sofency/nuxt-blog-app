package com.sofency.top.nuxtblog.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.sofency.top.nuxtblog.dto.CommentDTO;
import com.sofency.top.nuxtblog.dto.Result;
import com.sofency.top.nuxtblog.entity.Comment;
import com.sofency.top.nuxtblog.service.CommentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author sofency
 * @since 2024-03-16
 */
@RestController
@RequestMapping("/blog/comment")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @RequestMapping("")
    public Result<Object> comment(@RequestBody Comment comment, HttpServletRequest request) throws JsonProcessingException {
        commentService.comment(request.getSession(), comment);
        return Result.success(null);
    }

    @GetMapping("/{blogId}")
    public Result<Object> comment(@PathVariable("blogId") Integer blogId) {
        List<CommentDTO> comments = commentService.getCommentByBlogId(blogId);
        return Result.success(comments);
    }
}

