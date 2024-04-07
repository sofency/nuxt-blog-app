package com.sofency.top.nuxtblog.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sofency.top.nuxtblog.dto.CommentListDTO;
import com.sofency.top.nuxtblog.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sofency.top.nuxtblog.entity.User;
import com.sofency.top.nuxtblog.vo.CommentVO;
import jakarta.servlet.http.HttpServletRequest;

import java.sql.SQLDataException;
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
    public User comment(HttpServletRequest request, CommentVO commentVO) throws JsonProcessingException, SQLDataException;

    public List<CommentListDTO> getCommentByBlogId(Integer blogId);
}
