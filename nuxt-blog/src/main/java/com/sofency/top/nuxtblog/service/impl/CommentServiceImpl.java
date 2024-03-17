package com.sofency.top.nuxtblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sofency.top.nuxtblog.dto.CommentDTO;
import com.sofency.top.nuxtblog.entity.Comment;
import com.sofency.top.nuxtblog.entity.User;
import com.sofency.top.nuxtblog.mapper.CommentMapper;
import com.sofency.top.nuxtblog.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sofency.top.nuxtblog.utils.JsonUtils;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author sofency
 * @since 2024-03-16
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public void comment(HttpSession session, Comment comment) throws JsonProcessingException {
        // 获取当前session拿到当前的用户
        User user = JsonUtils.fromJson((String) session.getAttribute("user"), User.class);
        comment.setUserId(user.getId());
        comment.setCreateTime(new Date());
        comment.setUpdateTime(new Date());
        this.save(comment);
    }

    @Override
    public List<CommentDTO> getCommentByBlogId(Integer blogId) {
        List<Comment> comments = commentMapper.selectByBlogId(blogId);
        Map<Integer, Comment> commentMap = comments.stream().collect(Collectors.toMap(Comment::getId, Function.identity()));
        List<Integer> parentCommentIds = comments.stream().filter(comment -> Objects.isNull(comment.getParentId()))
                .sorted(Comparator.comparing(Comment::getCreateTime).reversed())
                .map(Comment::getId)
                .toList();
        List<CommentDTO> result = new ArrayList<>();
        for (Integer commentId : parentCommentIds) {
            // 获取首map信息
            Comment comment = commentMap.get(commentId);
            List<Comment> childComments = comments.stream().filter(temp -> Objects.equals(temp.getParentId(), commentId))
                    .sorted(Comparator.comparing(Comment::getCreateTime).reversed()).toList();
            CommentDTO commentDTO = CommentDTO.builder().parentComment(comment).childComment(childComments).build();
            result.add(commentDTO);
        }
        return result;
    }


}
