package com.sofency.top.nuxtblog.mapper;

import com.sofency.top.nuxtblog.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sofency
 * @since 2024-03-16
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
    public List<Comment> selectByBlogId(@Param("blog_id") Integer blogId);
}
