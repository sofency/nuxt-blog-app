package com.sofency.top.nuxtblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sofency.top.nuxtblog.dto.CommentDTO;
import com.sofency.top.nuxtblog.entity.Comment;
import com.sofency.top.nuxtblog.entity.User;
import com.sofency.top.nuxtblog.mapper.CommentMapper;
import com.sofency.top.nuxtblog.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sofency.top.nuxtblog.service.UserService;
import com.sofency.top.nuxtblog.utils.JsonUtils;
import com.sofency.top.nuxtblog.vo.CommentVO;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.sql.SQLDataException;
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
    private static final Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class);
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private UserService userService;

    @Override
    public void comment(CommentVO commentVO) throws JsonProcessingException, SQLDataException {
        // 先检查用户是否注册过
        User user = userService.getUserInfo(commentVO.getUser());
        logger.info("current user: {} comment info:{}", user.getNickname(), commentVO.getComment().getContent());
        Comment comment = commentVO.getComment();
        comment.setUserId(user.getId());
        comment.setCreateTime(new Date());
        comment.setUpdateTime(new Date());
        this.save(comment);
    }

    @Override
    public List<CommentDTO> getCommentByBlogId(Integer blogId) {
        List<Comment> comments = commentMapper.selectByBlogId(blogId);
        if (CollectionUtils.isEmpty(comments)) {
            return Collections.emptyList();
        }
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
