package com.sofency.top.nuxtblog.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sofency.top.nuxtblog.dto.CommentDTO;
import com.sofency.top.nuxtblog.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author sofency
 * @since 2024-03-16
 */
public interface CommentService extends IService<Comment> {
    public void comment(HttpSession session, Comment comment) throws JsonProcessingException;

    public List<CommentDTO> getCommentByBlogId(Integer blogId);
}
